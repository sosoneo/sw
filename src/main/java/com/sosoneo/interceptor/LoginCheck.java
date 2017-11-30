package com.sosoneo.interceptor;

import java.lang.annotation.*;

/**
 * Created by sosoneo on 2017/11/29.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginCheck {
}
