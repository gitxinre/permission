package com.ly.exception;

import com.ly.util.IdGenerator;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xinre
 */
@Slf4j
public class PermissionException extends RuntimeException {

    public PermissionException() {
        super();
    }

    public PermissionException(String message) {
        super(message);
    }

    public PermissionException(String message, Throwable cause) {
        super(message, cause);
    }

    public PermissionException(Throwable cause) {
        super(cause);
    }

    protected PermissionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public static void main(String[] args) {
        long l = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            //log.info("====" + i + "   IdGenerator.guid() = " + IdGenerator.guid());
            System.out.println("====" + i + "   IdGenerator.guid() = " + IdGenerator.guid());
        }
        long l1 = System.currentTimeMillis();
        System.out.println("l = " + (l1-l));


    }
}
