package com.sinosoft.one.util.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * BeanMapper test JavaBean
 * User: ChengQi
 * Date: 13-1-8
 * Time: PM2:20
 */
public class Car {

    private String licenceNo;

    private String name;

    private String[] packages;

    private int age;

    private Car car;

    private Car[] cars;

    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }

    private List<Car> carList = new ArrayList<Car>(0);

    private List<Integer> noList = new ArrayList<Integer>(2);

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLicenceNo() {
        return licenceNo;
    }

    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public String[] getPackages() {
        return packages;
    }

    public void setPackages(String[] packages) {
        this.packages = packages;
    }

    public List<Integer> getNoList() {
        return noList;
    }

    public void setNoList(List<Integer> noList) {
        this.noList = noList;
    }
}
