package com.bwhome.basic.reflect;



import com.bwhome.basic.doamin.Person;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyReflect {

    public static  void main(String[] args){

        try {
            Class a = Class.forName("com.java.basic.bean.Person");
            Person p = (Person)a.newInstance();
            Method method = a.getDeclaredMethod("setName",String.class);
            method.invoke(p,"陈");
            Method method2 = a.getDeclaredMethod("getName");
            System.out.println(method2.invoke(p));
            Field name = a.getDeclaredField("name");
            name.setAccessible(true);
            System.out.println(name.getType());
            System.out.println(name.getName());
            name.set(p,"王五");
            System.out.println(name.get(p));
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
