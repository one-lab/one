package ins.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PropertyBeanUtils {
	public static Object objCopyToObj(Object obj1,Object obj2) throws Exception{
		Method[] methods1 = obj1.getClass().getMethods();
		Method[] methods2 = obj2.getClass().getMethods();
		String methodName1 = null;
		String methodFix1 = null;
		String methodName2 = null;
		String methodFix2 = null;
		for(int i = 0; i < methods2.length; i++){
			methodName2 = methods2[i].getName();
			methodFix2 = methodName2.substring(3,methodName2.length());
			if(methodName2.startsWith("get")){
				if(methodFix2.equals("Id")){
					Object id = methods2[i].invoke(obj2, new Object[0]);
					Method[] id2Methods = id.getClass().getMethods();
					String id2MethodName = null;
					String id2MethodFix = null;
					for(int j = 0;j < id2Methods.length;j++){
						id2MethodName = id2Methods[j].getName();
						id2MethodFix = id2MethodName.substring(3,id2MethodName.length());
						if(id2MethodName.startsWith("get")){
							for(int k = 0;k < methods1.length; k++){
								methodName1 = methods1[k].getName();
								methodFix1 = methodName1.substring(3,methodName1.length());
								if(methodName1.startsWith("set")){
									if(methodFix1.equals(id2MethodFix)){
										Object[] objs2=new Object[0];
										Object[] objs1=new Object[1];
										objs1[0]=id2Methods[j].invoke(id,objs2);
										methods1[k].invoke(obj1,objs1);
										continue;
									}
								}
								if(methodName1.equals("getId")){
									Object id1 = methods1[k].invoke(obj1,new Object[0]);
									
									if(id1==null){
										Field fieldId = obj1.getClass().getDeclaredField("id");
										Class clazz = fieldId.getType();
										
										Object objId =clazz.newInstance();
										
										Class[] classes = new Class[1];
										classes[0]=clazz;
										
										Object[] objshuzu = new Object[1];
										objshuzu[0]=objId;
										obj1.getClass().getMethod("setId", classes).invoke(obj1, objshuzu);
									}
									
									id1 = methods1[k].invoke(obj1,new Object[0]);
									
									
									
									Method[] id1Methods = id1.getClass().getMethods();
									String id1MethodName = null;
									String id1MethodFix = null;
									for(int m = 0;m < id1Methods.length;m++){
										id1MethodName = id1Methods[m].getName();
										id1MethodFix = id1MethodName.substring(3,id1MethodName.length());
										if(id1MethodName.startsWith("set")){
											if(id1MethodFix.equals(id2MethodFix)){
												Object[] objs2=new Object[0];
												Object[] objs1=new Object[1];
												objs1[0]=id2Methods[j].invoke(id,objs2);
												id1Methods[m].invoke(id1,objs1);
												continue;
											}
										}
									}
								}
							}
						}
					}
				}else{
					for(int k = 0;k < methods1.length; k++){
						methodName1 = methods1[k].getName();
						methodFix1 = methodName1.substring(3,methodName1.length());
						if(methodName1.startsWith("set")){
							if(methodFix1.equals(methodFix2)){
								Object[] objs2=new Object[0];
								Object[] objs1=new Object[1];
								objs1[0]=methods2[i].invoke(obj2,objs2);
								methods1[k].invoke(obj1,objs1);
								continue;
							}
						}
						if(methodName1.equals("getId")){
							Object id = methods1[k].invoke(obj1,new Object[0]);
							
							
							if(id==null){
								Field fieldId = obj1.getClass().getDeclaredField("id");
								Class clazz = fieldId.getType();
								
								Object objId =clazz.newInstance();
								
								Class[] classes = new Class[1];
								classes[0]=clazz;
								
								Object[] objshuzu = new Object[1];
								objshuzu[0]=objId;
								obj1.getClass().getMethod("setId", classes).invoke(obj1, objshuzu);
							}
							
							
							id = methods1[k].invoke(obj1,new Object[0]);
							
							
							Method[] id1Methods = id.getClass().getMethods();
							String id1MethodName = null;
							String id1MethodFix = null;
							for(int m = 0;m < id1Methods.length;m++){
								id1MethodName = id1Methods[m].getName();
								id1MethodFix = id1MethodName.substring(3,id1MethodName.length());
								if(id1MethodName.startsWith("set")){
									if(id1MethodFix.equals(methodFix2)){
										Object[] objs2=new Object[0];
										Object[] objs1=new Object[1];
										objs1[0]=methods2[i].invoke(obj2,objs2);
										id1Methods[m].invoke(id,objs1);
										continue;
									}
								}
							}
						}
					}
				}
			}
		}
		return obj1;
	}
	
}
