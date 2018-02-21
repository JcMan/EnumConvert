package com.enumconvert.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface BindEnum {
    Class enumClass();
    String suffix() default "Label";
}
