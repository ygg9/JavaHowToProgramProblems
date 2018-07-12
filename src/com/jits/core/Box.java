package com.jits.core;

import Week4.DeliveryMethod;
import Week4.Parcel;

public class Box extends Parcel {
    private double height;
    private double width;
    private double depth;
    private double volume;
    private boolean hasInsurance;

    public Box(String id, Address origin, Address destination, DeliveryMethod deliveryMethod, double height, double width, double depth, boolean hasInsurance) {
        super(id, origin, destination, deliveryMethod);
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.volume = this.height * this.width * this.depth;
        this.hasInsurance = hasInsurance;
    }

    @Override
    public String getPackageType(){
        return "Box";
    }

    @Override
    public double getVolume() {
        return volume;
    }

    @Override
    public boolean isInsured(){
        return hasInsurance;
    }
}
