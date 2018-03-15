package cn.wolfcode.easymvc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //能加载到JVM
@Target(ElementType.TYPE) //可以贴在类上
public @interface Controller {
}
