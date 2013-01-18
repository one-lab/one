package com.sinosoft.one.util.bean;

import ins.framework.utils.BeanUtils;
import junit.framework.Assert;
import org.apache.commons.beanutils.expression.DefaultResolver;
import org.apache.commons.beanutils.expression.Resolver;
import org.junit.Test;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * BeanUtils Test
 * User: cq
 * Date: 13-1-6
 * Time: PM5:45
 */
public class BeanUtils3Test {

    @Test
    public void testDealPropertiesBySpecification() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Car car = new Car();
        car.setName("blue");
        car.setLicenceNo(" 8123123  ");
        BeanUtils3.dealPropertiesBySpecification(car,new Specification[]{Specifications.TrimRight()});
        Assert.assertEquals(" 8123123",car.getLicenceNo());
        car.setName("green ");
        BeanUtils3.dealPropertiesBySpecification(car,new Specification[]{Specifications.TrimRight()},"name");
        Assert.assertEquals("green ",car.getName());
        Car car2 = new Car();
        car2.setName(" car2 ");
        Car car3 = new Car();
        car3.setName(" car3  ");

        //test array
        car.setCars(new Car[]{car2, car3});
        car.setPackages(new String[]{" ddd  ","1 "});
        BeanUtils3.dealPropertiesBySpecification(car,new Specification[]{Specifications.TrimRight()});
        //object array
        Assert.assertEquals(" car2",BeanUtils.getProperty(car,"cars[0].name"));
        //String array
        Assert.assertEquals("1",BeanUtils.getProperty(car,"packages[1]"));

        //test list
        List<Car> carList = new ArrayList<Car>(2);
        car2.setLicenceNo("111 ");
        car3.setLicenceNo("222 ");
        carList.add(car2);
        carList.add(car3);
        car.setCarList(carList);
        List<Integer> noList = new ArrayList<Integer>(2);
        noList.add(11);
        noList.add(22);
        car.setNoList(noList);
        BeanUtils3.dealPropertiesBySpecification(car,new Specification[]{Specifications.TrimRight()});
        Assert.assertEquals("111",BeanUtils.getProperty(car,"carList[0].licenceNo"));
        car2.setLicenceNo("333 ");
        car3.setLicenceNo("444 ");

        BeanUtils3.dealPropertiesBySpecification(car,new Specification[]{Specifications.TrimRight()},new String[]{},"carList[1].licenceNo");
        Assert.assertEquals("333 ",BeanUtils.getProperty(car,"carList[0].licenceNo"));
        Assert.assertEquals("444",BeanUtils.getProperty(car,"carList[1].licenceNo"));

        //exclude
        car3.setLicenceNo("222 ");
        BeanUtils3.dealPropertiesBySpecification(car,new Specification[]{Specifications.TrimRight()},"carList.licenceNo","cars");
        Assert.assertEquals("222 ",BeanUtils.getProperty(car,"carList[1].licenceNo"));

        //test nested Object
        car2.setName(" bb ");
        car.setCar(car2);
        BeanUtils3.dealPropertiesBySpecification(car,new Specification[]{Specifications.TrimRight()});
        Assert.assertEquals(" bb",BeanUtils.getProperty(car,"car.name"));


    }


    @Test
    public void testSpecification(){
        Resolver resolver = new DefaultResolver();
        System.out.println(resolver.next("a.b.c[2].d"));
        Set<String> set = new HashSet<String>();
        set.add("aa");
        set.add("a.b");
        set.add("a.c[0]");
        Assert.assertEquals(true,BeanUtils3.isExclude(set,"aa"));

        Car car = new Car();
        Car car2 = new Car();
        Car[] cars = {car,car2};
        System.out.println(cars.getClass());

        arr(cars);

        String[] t2 = new String[]{"1","2"};

        int[] i2 = new int[]{1,2,0};
        arr(t2);
        arr(i2);
        Assert.assertEquals(true, BeanUtils3.getSpecificationClass(Specifications.TrimRight().getClass()).equals(String.class));
    }



    private void arr(Object arr){
        if (arr.getClass().isArray()) {
            int length =  Array.getLength(arr);
            while (length>0){
                Object a = Array.get(arr,length-1);
                System.out.println(a.getClass());
                length--;
            }
        }
    }


}
