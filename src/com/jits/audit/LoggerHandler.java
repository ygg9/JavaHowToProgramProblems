package com.jits.audit;

import Week4.Parcel;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerHandler implements InvocationHandler {
    private static final Logger LOG = Logger.getLogger(Parcel.class);

    private Object target;

    public LoggerHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable { //does nothing except call the origin method and with argu
        // log stuff
        this.logAuditRecord((Parcel)args[0]);

        return method.invoke(target, args);
    }

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
}
