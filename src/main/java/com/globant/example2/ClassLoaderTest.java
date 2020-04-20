package com.globant.example2;

public class ClassLoaderTest {

    public static void main(String[] args) {
        JavaClassLoader javaClassLoader = new JavaClassLoader();
        javaClassLoader.invokeClassMethod("com.globant.example2.MyClass", "printHelloWorld");
    }

}