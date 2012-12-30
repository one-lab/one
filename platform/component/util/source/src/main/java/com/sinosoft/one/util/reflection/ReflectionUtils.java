package com.sinosoft.one.util.reflection;

import java.beans.ExceptionListener;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.reflect.*;
import java.util.*;

import com.sun.beans.ObjectHandler;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;


/**
 * 反射工具类.
 * 
 * 提供访问私有变量,获取泛型类型Class, 提取集合中元素的属性, 转换字符串到对象等Util函数.
 * 
 */
public class ReflectionUtils {

	private static Logger logger = LoggerFactory.getLogger(ReflectionUtils.class);

	/**
	 * 调用Getter方法.
	 */
	public static Object invokeGetterMethod(Object obj, String propertyName) {
		String getterMethodName = "get" + StringUtils.capitalize(propertyName);
		return invokeMethod(obj, getterMethodName, new Class[] {}, new Object[] {});
	}

	/**
	 * 调用Setter方法.使用value的Class来查找Setter方法.
	 */
	public static void invokeSetterMethod(Object obj, String propertyName, Object value) {
		invokeSetterMethod(obj, propertyName, value, null);
	}

	/**
	 * 调用Setter方法.
	 * 
	 * @param propertyType 用于查找Setter方法,为空时使用value的Class替代.
	 */
	public static void invokeSetterMethod(Object obj, String propertyName, Object value, Class<?> propertyType) {
		Class<?> type = propertyType != null ? propertyType : value.getClass();
		String setterMethodName = "set" + StringUtils.capitalize(propertyName);
		invokeMethod(obj, setterMethodName, new Class[] { type }, new Object[] { value });
	}

	/**
	 * 直接读取对象属性值, 无视private/protected修饰符, 不经过getter函数.
	 */
	public static Object getFieldValue(final Object obj, final String fieldName) {
		Field field = getAccessibleField(obj, fieldName);

		if (field == null) {
			throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + obj + "]");
		}

		Object result = null;
		try {
			result = field.get(obj);
		} catch (IllegalAccessException e) {
			logger.error("不可能抛出的异常{}", e.getMessage());
		}
		return result;
	}

	/**
	 * 直接设置对象属性值, 无视private/protected修饰符, 不经过setter函数.
	 */
	public static void setFieldValue(final Object obj, final String fieldName, final Object value) {
		Field field = getAccessibleField(obj, fieldName);

		if (field == null) {
			throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + obj + "]");
		}

		try {
			field.set(obj, value);
		} catch (IllegalAccessException e) {
			logger.error("不可能抛出的异常:{}", e.getMessage());
		}
	}

	/**
	 * 循环向上转型, 获取对象的DeclaredField,	 并强制设置为可访问.
	 * 
	 * 如向上转型到Object仍无法找到, 返回null.
	 */
	public static Field getAccessibleField(final Object obj, final String fieldName) {
		Assert.notNull(obj, "object不能为空");
		Assert.hasText(fieldName, "fieldName");
		for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
			try {
				Field field = superClass.getDeclaredField(fieldName);
				field.setAccessible(true);
				return field;
			} catch (NoSuchFieldException e) {//NOSONAR
				// Field不在当前类定义,继续向上转型
			}
		}
		return null;
	}

	/**
	 * 直接调用对象方法, 无视private/protected修饰符.
	 * 用于一次性调用的情况.
	 */
	public static Object invokeMethod(final Object obj, final String methodName, final Class<?>[] parameterTypes,
			final Object[] args) {
		Method method = getAccessibleMethod(obj, methodName, parameterTypes);
		if (method == null) {
			throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + obj + "]");
		}

		try {
			return method.invoke(obj, args);
		} catch (Exception e) {
			throw convertReflectionExceptionToUnchecked(e);
		}
	}

	/**
	 * 循环向上转型, 获取对象的DeclaredMethod,并强制设置为可访问.
	 * 如向上转型到Object仍无法找到, 返回null.
	 * 
	 * 用于方法需要被多次调用的情况. 先使用本函数先取得Method,然后调用Method.invoke(Object obj, Object... args)
	 */
	public static Method getAccessibleMethod(final Object obj, final String methodName,
			final Class<?>... parameterTypes) {
		Assert.notNull(obj, "object不能为空");

		for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
			try {
				Method method = superClass.getDeclaredMethod(methodName, parameterTypes);

				method.setAccessible(true);

				return method;

			} catch (NoSuchMethodException e) {//NOSONAR
				// Method不在当前类定义,继续向上转型
			}
		}
		return null;
	}

	/**
	 * 通过反射, 获得Class定义中声明的父类的泛型参数的类型.
	 * 如无法找到, 返回Object.class.
	 * eg.
	 * public UserDao extends HibernateDao<User>
	 *
	 * @param clazz The class to introspect
	 * @return the first generic declaration, or Object.class if cannot be determined
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getSuperClassGenricType(final Class clazz) {
		return getSuperClassGenricType(clazz, 0);
	}

	/**
	 * 通过反射, 获得Class定义中声明的父类的泛型参数的类型.
	 * 如无法找到, 返回Object.class.
	 * 
	 * 如public UserDao extends HibernateDao<User,Long>
	 *
	 * @param clazz clazz The class to introspect
	 * @param index the Index of the generic ddeclaration,start from 0.
	 * @return the index generic declaration, or Object.class if cannot be determined
	 */
	@SuppressWarnings("unchecked")
	public static Class getSuperClassGenricType(final Class clazz, final int index) {

		Type genType = clazz.getGenericSuperclass();

		if (!(genType instanceof ParameterizedType)) {
			logger.warn(clazz.getSimpleName() + "'s superclass not ParameterizedType");
			return Object.class;
		}

		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

		if (index >= params.length || index < 0) {
			logger.warn("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: "
					+ params.length);
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			logger.warn(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
			return Object.class;
		}

		return (Class) params[index];
	}

	/**
	 * 将反射时的checked exception转换为unchecked exception.
	 */
	public static RuntimeException convertReflectionExceptionToUnchecked(Exception e) {
		if (e instanceof IllegalAccessException || e instanceof IllegalArgumentException
				|| e instanceof NoSuchMethodException) {
			return new IllegalArgumentException("Reflection Exception.", e);
		} else if (e instanceof InvocationTargetException) {
			return new RuntimeException("Reflection Exception.", ((InvocationTargetException) e).getTargetException());
		} else if (e instanceof RuntimeException) {
			return (RuntimeException) e;
		}
		return new RuntimeException("Unexpected Checked Exception.", e);
	}

    // from jdk's ReflectionUtils
    private static Reference methodCacheRef;

    public static Class typeToClass(Class type) {
        return type.isPrimitive() ? ObjectHandler.typeNameToClass(type.getName()) : type;
    }

    public static boolean isPrimitive(Class type) {
        return primitiveTypeFor(type) != null;
    }

    public static Class primitiveTypeFor(Class wrapper) {
        if (wrapper == Boolean.class) return Boolean.TYPE;
        if (wrapper == Byte.class) return Byte.TYPE;
        if (wrapper == Character.class) return Character.TYPE;
        if (wrapper == Short.class) return Short.TYPE;
        if (wrapper == Integer.class) return Integer.TYPE;
        if (wrapper == Long.class) return Long.TYPE;
        if (wrapper == Float.class) return Float.TYPE;
        if (wrapper == Double.class) return Double.TYPE;
        if (wrapper == Void.class) return Void.TYPE;
        return null;
    }

    /**
     * Tests each element on the class arrays for assignability.
     *
     * @param argClasses arguments to be tested
     * @param argTypes arguments from Method
     * @return true if each class in argTypes is assignable from the
     *         corresponding class in argClasses.
     */
    private static boolean matchArguments(Class[] argClasses, Class[] argTypes) {
        return matchArguments(argClasses, argTypes, false);
    }

    /**
     * Tests each element on the class arrays for equality.
     *
     * @param argClasses arguments to be tested
     * @param argTypes arguments from Method
     * @return true if each class in argTypes is equal to the
     *         corresponding class in argClasses.
     */
    private static boolean matchExplicitArguments(Class[] argClasses, Class[] argTypes) {
        return matchArguments(argClasses, argTypes, true);
    }

    private static boolean matchArguments(Class[] argClasses,
                                          Class[] argTypes, boolean explicit) {

        boolean match = (argClasses.length == argTypes.length);
        for(int j = 0; j < argClasses.length && match; j++) {
            Class argType = argTypes[j];
            if (argType.isPrimitive()) {
                argType = typeToClass(argType);
            }
            if (explicit) {
                // Test each element for equality
                if (argClasses[j] != argType) {
                    match = false;
                }
            } else {
                // Consider null an instance of all classes.
                if (argClasses[j] != null &&
                        !(argType.isAssignableFrom(argClasses[j]))) {
                    match = false;
                }
            }
        }
        return match;
    }





    /**
     * Return the most specific method from the list of methods which
     * matches the args. The most specific method will have the most
     * number of equal parameters or will be closest in the inheritance
     * heirarchy to the runtime execution arguments.
     * <p>
     * See the JLS section 15.12
     * http://java.sun.com/docs/books/jls/second_edition/html/expressions.doc.html#20448
     *
     * @param methods List of methods which already have the same param length
     *                and arg types are assignable to param types
     * @param args an array of param types to match
     * @return method or null if a specific method cannot be determined
     */
    private static Method getMostSpecificMethod(List methods, Class[] args) {
        Method method = null;

        int matches = 0;
        int lastMatch = matches;

        ListIterator iterator = methods.listIterator();
        while (iterator.hasNext()) {
            Method m = (Method)iterator.next();
            Class[] mArgs = m.getParameterTypes();
            matches = 0;
            for (int i = 0; i < args.length; i++) {
                Class mArg = mArgs[i];
                if (mArg.isPrimitive()) {
                    mArg = typeToClass(mArg);
                }
                if (args[i] == mArg) {
                    matches++;
                }
            }
            if (matches == 0 && lastMatch == 0) {
                if (method == null) {
                    method = m;
                } else {
                    // Test existing method. We already know that the args can
                    // be assigned to all the method params. However, if the
                    // current method parameters is higher in the inheritance
                    // hierarchy then replace it.
                    if (!matchArguments(method.getParameterTypes(),
                            m.getParameterTypes())) {
                        method = m;
                    }
                }
            } else if (matches > lastMatch) {
                lastMatch = matches;
                method = m;
            } else if (matches == lastMatch) {
                // ambiguous method selection.
                method = null;
            }
        }
        return method;
    }


    /**
     * A class that represents the unique elements of a method that will be a
     * key in the method cache.
     */
    private static class Signature {
        private Class targetClass;
        private String methodName;
        private Class[] argClasses;

        private volatile int hashCode = 0;

        public Signature(Class targetClass, String methodName, Class[] argClasses) {
            this.targetClass = targetClass;
            this.methodName = methodName;
            this.argClasses = argClasses;
        }

        public boolean equals(Object o2) {
            if (this == o2) {
                return true;
            }
            Signature that = (Signature)o2;
            if (!(targetClass == that.targetClass)) {
                return false;
            }
            if (!(methodName.equals(that.methodName))) {
                return false;
            }
            if (argClasses.length != that.argClasses.length) {
                return false;
            }
            for (int i = 0; i < argClasses.length; i++) {
                if (!(argClasses[i] == that.argClasses[i])) {
                    return false;
                }
            }
            return true;
        }

        /**
         * Hash code computed using algorithm suggested in
         * Effective Java, Item 8.
         */
        public int hashCode() {
            if (hashCode == 0) {
                int result = 17;
                result = 37 * result + targetClass.hashCode();
                result = 37 * result + methodName.hashCode();
                if (argClasses != null) {
                    for (int i = 0; i < argClasses.length; i++) {
                        result = 37 * result + ((argClasses[i] == null) ? 0 :
                                argClasses[i].hashCode());
                    }
                }
                hashCode = result;
            }
            return hashCode;
        }
    }


    /**
     * Return a constructor on the class with the arguments.
     *
     * @throws exception if the method is ambiguios.
     */
        public static Constructor getConstructor(Class cls, Class[] args) {
        Constructor constructor = null;

        // PENDING: Implement the resolutuion of ambiguities properly.
        Constructor[] ctors = cls.getDeclaredConstructors();
        for(int i = 0; i < ctors.length; i++) {
            if (matchArguments(args, ctors[i].getParameterTypes())) {
                constructor = ctors[i];
            }
        }
        return constructor;
    }

    public static Constructor getPrivateConstructor(Class cls, Class[] args) {
        Constructor constructor = getConstructor(cls, args);
        if(!constructor.isAccessible()) {
            constructor.setAccessible(true);
        }
        return constructor;
    }


    public static Object getPrivateField(Object instance, Class cls, String name) {
        return getPrivateField(instance, cls, name);
    }

    /**
     * Returns the value of a private field.
     *
     * @param instance object instance
     * @param cls class
     * @param name name of the field
     * @param el an exception listener to handle exceptions; or null
     * @return value of the field; null if not found or an error is encountered
     */
    public static Object getPrivateField(Object instance, Class cls,
                                         String name, ExceptionListener el) {
        try {
            Field f = cls.getDeclaredField(name);
            f.setAccessible(true);
            return f.get(instance);
        }
        catch (Exception e) {
            if (el != null) {
                el.exceptionThrown(e);
            }
        }
        return null;
    }
}
