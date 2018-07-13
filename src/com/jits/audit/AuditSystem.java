package com.jits.audit;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class AuditSystem {
    public static Audit logAudit(){
        InvocationHandler handler = new LoggerHandler(new AuditRecordShipping());

        return (Audit) Proxy.newProxyInstance(Audit.class.getClassLoader(), new Class[] {Audit.class}, handler);
    }
}
