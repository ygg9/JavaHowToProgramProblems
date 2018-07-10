package com.jits.core;

import Week4.Address;
import Week4.DeliveryMethod;
import Week4.Parcel;

public class Box extends Parcel {
    private double height;
    private double width;
    private double depth;

    public Box(String id, Address origin, Address destination, DeliveryMethod deliveryMethod, double height, double width, double depth) {
        super(id, origin, destination, deliveryMethod);
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }
}
