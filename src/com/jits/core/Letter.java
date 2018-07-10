package com.jits.core;

import Week4.Address;
import Week4.DeliveryMethod;
import Week4.Durability;
import Week4.Parcel;

public class Letter extends Parcel {

    Durability durability;

    public Letter(String id, Address origin, Address destination, DeliveryMethod deliveryMethod, Durability durability) {
        super(id, origin, destination, deliveryMethod);
        this.durability = durability;
    }

    public Durability getDurability() {
        return durability;
    }

    public void setDurability(Durability durability) {
        this.durability = durability;
    }
}