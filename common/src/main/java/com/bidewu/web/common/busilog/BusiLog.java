package com.bidewu.web.common.busilog;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface BusiLog {
    /**
     * 业务类型
     * @return
     */
    String  busitype() default "";
}