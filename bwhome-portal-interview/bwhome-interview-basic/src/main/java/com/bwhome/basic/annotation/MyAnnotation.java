package com.bwhome.basic.annotation;

import java.lang.annotation.Annotation;
import java.util.Arrays;

@MyRequestMapping("/hello")
@Deprecated
public class MyAnnotation {

    public static void main(String[] args) {
        Class<?> c = MyAnnotation.class;
        MyRequestMapping annotation = c.getAnnotation(MyRequestMapping.class);
        Annotation[] a = c.getAnnotations();
        Arrays.stream(a).forEach(item-> System.out.println(item));
        System.out.println(annotation.value());
    }
}
