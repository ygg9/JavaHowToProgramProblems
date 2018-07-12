package com.jits.core;

import Week4.DeliveryMethod;
import Week4.Durability;
import Week4.Parcel;

public class Letter extends Parcel {
    private final double volume = 1;
    private Durability durability;
    private final boolean hasInsurance = false;

    public Letter(String id, Address origin, Address destination, DeliveryMethod deliveryMethod, Durability durability) {
        super(id, origin, destination, deliveryMethod);
        this.durability = durability;
    }

    public Durability getDurability() {
        return durability;
    }

    @Override
    public String getPackageType(){
        return "Letter";
    }

    @Override
    public double getVolume() {
        return volume;
    }

    @Override
    public boolean isInsured(){
        return hasInsurance;
    }

    public void setDurability(Durability durability) {
        this.durability = durability;
    }
}
