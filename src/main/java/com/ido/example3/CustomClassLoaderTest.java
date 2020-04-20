package com.ido.example3;

import java.lang.reflect.Method;

public class CustomClassLoaderTest {

    public static void main(String args[]) throws Exception {
        String progClass = "com.globant.example3.foobar.Foo";
        String progArgs[] = {"LOREM", "IPSUM"};

        CustomClassLoader ccl = new CustomClassLoader(CustomClassLoaderTest.class.getClassLoader());
        Class clas = ccl.loadClass(progClass);
        Class mainArgType[] = { (new String[0]).getClass() };
        Method main = clas.getMethod("main", mainArgType);
        Object argsArray[] = { progArgs };
        main.invoke(null, argsArray);

        // El método de abajo es usado para chequear que Foo está siendo cargada por CustomClassLoader
        Method printCL = clas.getMethod("printCL", null);
        printCL.invoke(null, new Object[0]);
    }
}
