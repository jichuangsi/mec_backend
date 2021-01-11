package com.jichuangsi.mes.advice;

import java.lang.annotation.Target;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
   * 自定义操作日志注解
   * @author
 * */
@Target(ElementType.METHOD) //注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
@Documented
public @interface OperLog {
    String operModul() default ""; // 操作模块
     String operType() default "";  // 操作类型 登陆1 操作2 异常3
     String operDesc() default "";  // 操作说明
}
