package com.jits.audit;

import Week4.Parcel;
import org.apache.log4j.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuditRecordShipping implements Audit{
    private static final Logger LOG = Logger.getLogger(Parcel.class);

    public String getAuditRecord(String id, String cost){
        double costDouble = Double.parseDouble(cost);
        costDouble = (double)Math.round(costDouble * 100d)/100;
        return id + " " + Double.toString(costDouble) + " " + getTimeStamp();
    }

    public String getTimeStamp(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    public void logAuditRecord(Parcel parcel){
        LOG.info(getAuditRecord(parcel.getId(), Double.toString(parcel.getCost())));
    }

    @Override
    public double calculateShippingCost(Parcel parcel) {
        return parcel.getCost();
    }
}
