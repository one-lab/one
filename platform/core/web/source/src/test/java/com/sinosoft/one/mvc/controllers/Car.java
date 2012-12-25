package com.sinosoft.one.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

/**
 * used for cascade testing
 * User: ChengQi
 * Date: 12/13/12
 * Time: 1:42 下午
 * To change this template use File | Settings | File Templates.
 */
public class Car {

    public RentalCar getRentalCar() {
        return rentalCar;
    }

    public void setRentalCar(RentalCar rentalCar) {
        this.rentalCar = rentalCar;
    }

    private RentalCar rentalCar;

    private List<RentalCar> rentalCarList = new ArrayList<RentalCar>(0);

    public List<RentalCar> getRentalCarList() {
        return rentalCarList;
    }

    public void setRentalCarList(List<RentalCar> rentalCarList) {
        this.rentalCarList = rentalCarList;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    private String manufacturer;

    private String licensePlate;


    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    private int seatCount;

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }
}
