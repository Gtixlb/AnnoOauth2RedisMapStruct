package com.example.annotation;

import java.lang.annotation.*;

/**
 * @author Administrator
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Permission {
    String value();
}
