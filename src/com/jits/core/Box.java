package com.jits.core;

import Week4.Address;
import Week4.DeliveryMethod;
import Week4.Parcel;

public class Box extends Parcel {
    private double height;
    private double width;
    private double depth;
    private double volume;

    public Box(String id, Address origin, Address destination, DeliveryMethod deliveryMethod, double height, double width, double depth) {
        super(id, origin, destination, deliveryMethod);
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    @Override
    public double getVolume() {
        return height * width * depth;
    }
}
