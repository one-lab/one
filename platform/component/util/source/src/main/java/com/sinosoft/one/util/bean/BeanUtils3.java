package com.sinosoft.one.util.bean;

import static org.springframework.core.GenericTypeResolver.*;
import com.google.common.collect.Sets;
import com.sinosoft.one.util.reflection.ReflectionUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.expression.DefaultResolver;
import org.apache.commons.beanutils.expression.Resolver;
import org.apache.commons.lang.ClassUtils;
import org.springframework.util.Assert;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * 对apache BeanUtils & Spring BeanUtils做一些功能补充
 * User: CQ
 * Date: 13-1-6
 * Time: PM3:59
 */
public abstract class BeanUtils3 {

    private static Resolver resolver = new DefaultResolver();

    /**
     * 对source所有属性按照规格进行处理
     * @param source
     * @param specifications
     */
    public static void dealPropertiesBySpecification(Object source,Specification[] specifications){
        dealPropertiesBySpecification(source,specifications,null,null);
    }

    /**
     * 对source所有属性按照规格进行处理
     * @param source
     * @param specifications
     * @param excludeProperties
     */
    public static void dealPropertiesBySpecification(Object source,Specification[] specifications,String... excludeProperties){
        dealPropertiesBySpecification(source,specifications,excludeProperties,null);
    }

    /**
     * 对source所有属性按照规格进行处理,支持Nest Bean、List、Array，
     *
     * Map--暂时未处理，待续...
     * @param source
     * @param specifications
     * @param excludeProperties
     * @param includeProperties
     */
    public static final void dealPropertiesBySpecification(Object source,Specification[] specifications,
                                                           String[] excludeProperties,String... includeProperties){

        Assert.notNull(source,"BeanUtils3 param:source can't is null");
        Assert.noNullElements(specifications);
        //如果是基本类型不做任何处理
        if(ReflectionUtils.isPrimitive(source.getClass())||source instanceof String){
            throw new RuntimeException("BeanUtils3 not support pram:Source is primitive type Or String!");
        }

        BeanUtilsBean beanUtilsBean = BeanUtilsBean.getInstance();

        //include
        Set<String> includes = Sets.newHashSet(includeProperties==null?new String[]{}:includeProperties);

        if(!includes.isEmpty()){
            for(String include:includes){
                try {
                    Object value = beanUtilsBean.getPropertyUtils().getNestedProperty(source, include);
                    for (Specification specification : specifications) {
                        //specification interface's General Type need equals PropertyType
                        if (getSpecificationClass(specification.getClass()).equals(value.getClass())) {
                            beanUtilsBean.getPropertyUtils().setNestedProperty(source, include, specification.deal(value));
                        }
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }
            }
            return;
        }

        //not has include
        Set<String> excludes = Sets.newHashSet(excludeProperties == null ? new String[]{} : excludeProperties);
        excludes.add("class");


        PropertyDescriptor[]  propertyDescriptors = beanUtilsBean.getPropertyUtils().getPropertyDescriptors(source.getClass());

        if(propertyDescriptors!=null ){

            Exclude exclude = new Exclude(excludes,propertyDescriptors);
            for(PropertyDescriptor propertyDescriptor:propertyDescriptors){
                //exclude not contain
                if(!exclude.contains(propertyDescriptor)){
                    try {
                        Object value = beanUtilsBean.getPropertyUtils().getProperty(source, propertyDescriptor.getName());

                        if(value==null)
                            continue;

                        if(propertyDescriptor.getPropertyType().isArray()){
                            arrayDeal(source,specifications,propertyDescriptor.getPropertyType(),propertyDescriptor.getName(),value,exclude);
                        }
                        else if(value instanceof java.util.List){
                            listDeal(source,specifications,propertyDescriptor.getPropertyType(),propertyDescriptor.getName(),value,exclude);
                        }
                        else{
                            //普通处理
                            for (Specification specification : specifications) {
                                //specification interface's General Type need equals PropertyType
                                if (ClassUtils.isAssignable(propertyDescriptor.getPropertyType(), getSpecificationClass(specification.getClass()))) {
                                    // beanUtilsBean.getPropertyUtils().setProperty(source, propertyDescriptor.getName(), specification.deal(value));
                                    ReflectionUtils.setFieldValue(source, propertyDescriptor.getName(), specification.deal(value));
                                }
                                //has nested
                                if (!(ReflectionUtils.isPrimitive(value.getClass()) || value instanceof String)) {
                                    dealPropertiesBySpecification(value, specifications, exclude.getPropertyExcludeExps(propertyDescriptor.getName()));
                                }
                            }
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    } catch (NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    }

    static boolean isExclude(Set<String> excludes,String propertyName){
        int index =0;
        for(String exclude:excludes){
            if(exclude.equals(propertyName)){
                return true;
            }
            if(resolver.hasNested(exclude)){
                //如果相等
                if(resolver.getProperty(exclude).equals(propertyName)){
                   exclude = resolver.remove(exclude);
                }
            }
            index++;
        }
        return false;
    }




    static void arrayDeal(Object source, Specification[] specifications, Class<?> propertyClass, String propertyName,
                          Object propertyValue, Exclude exclude)  {
        if(!propertyClass.isArray())
            return;
        if(propertyValue == null)
            return;
        int length =  Array.getLength(propertyValue);
        //创建新数组
        Object newArray = null;
        if(length>0){
            Object a = Array.get(propertyValue,length-1);
            newArray = Array.newInstance(a.getClass(),length);
        }
        else{
            return;
        }

        while (length>0){
            Object a = Array.get(propertyValue,length-1);
            for(Specification specification:specifications){
                //match
                if(ClassUtils.isAssignable(a.getClass(),getSpecificationClass(specification.getClass()))){
                    a = specification.deal(a);
                }
            }
            Array.set(newArray,length-1,a);
            if(!(ReflectionUtils.isPrimitive(a.getClass())||a instanceof String)){
                dealPropertiesBySpecification(Array.get(newArray,length-1),specifications,exclude.getPropertyExcludeExps(propertyName));
            }
            length--;
        }
        ReflectionUtils.setFieldValue(source,propertyName, newArray);
    }

    static void listDeal(Object source, Specification[] specifications, Class<?> propertyClass, String propertyName,
                         Object propertyValue, Exclude exclude) {
        if(propertyValue == null)
            return;
        if (propertyValue instanceof List) {
              List<Object> l = (List)propertyValue;
              for(int i=0,n=l.size();i<n;i++){
                  Object object = l.get(i);
                  for(Specification specification:specifications){
                      if(ClassUtils.isAssignable(propertyClass,specification.getClass()))
                          object = specification.deal(object);
                  }
                  //如果是私有类型,直接设置
                  if(!(ReflectionUtils.isPrimitive(object.getClass())||object instanceof String)){
                      dealPropertiesBySpecification(object,specifications,exclude.getPropertyExcludeExps(propertyName));
                  }
              }
        }
    }


    private static void simpleDeal(Object source,Specification[] specifications,Class<?> propertyClass,String propertyName,
                                        Object propertyValue){
        for(Specification specification:specifications){
            //specification interface's General Type need equals PropertyType
            if(ClassUtils.isAssignable(propertyClass,specification.getClass())){
                ReflectionUtils.setFieldValue(source,propertyName, specification.deal(propertyValue));
            }
        }
        //has nested
        if(!(ReflectionUtils.isPrimitive(propertyClass)||propertyValue instanceof String)){
            dealPropertiesBySpecification(propertyValue,specifications);
        }
    }



    /**
     * 获取class实现的接口泛型的参数
     * @param specificationImpl
     * @return
     */
    static Class<?> getSpecificationClass(Class specificationImpl){
        Class<?>[] arguments = resolveTypeArguments(specificationImpl, Specification.class);
        return arguments == null ? null : arguments[0];
    }


    private static class Exclude{

        /**
         * key is propertyName,value is it's all exclude
         */
        private Map<String,Set<String>> excludeExp= new HashMap<String, Set<String>>();

        private Map<PropertyDescriptor,Boolean> excludeResult = new HashMap<PropertyDescriptor,Boolean>();

        public Exclude(final Set<String> excludes, final PropertyDescriptor[] propertyDescriptors) {

            for(String exclude:excludes){
                for(PropertyDescriptor propertyDescriptor:propertyDescriptors){
                      //如果为null或者如果为false，则继续进入直到为true
                      if(excludeResult.get(propertyDescriptor) == null||!excludeResult.get(propertyDescriptor)){
                         excludeResult.put(propertyDescriptor,exclude.equals(propertyDescriptor.getName()));
                      }
                    //如果是包括嵌套关系
                    if(resolver.hasNested(exclude)){
                        //match
                        if(resolver.getProperty(exclude).equals(propertyDescriptor.getName())){
                            addPropertyExclude(propertyDescriptor.getName(), resolver.remove(exclude));
                        }
                    }
                }
            }

        }

        public boolean contains(PropertyDescriptor propertyDescriptor){
            return excludeResult.get(propertyDescriptor);
        }

        private void addPropertyExclude(String propertyName,String excludePath){
            Set<String> s =  excludeExp.get(propertyName);
            if(s==null){
                s = new HashSet<String>();
                s.add(excludePath);
                excludeExp.put(propertyName,s);
            }
            else{
                s.add(excludePath);
            }
        }

        public  String[] getPropertyExcludeExps(String propertyName){
            Set<String> s =excludeExp.get(propertyName);
            if(s==null){
                return new String[0];
            }
            return s.toArray(new String[s.size()]);
        }
    }

}
