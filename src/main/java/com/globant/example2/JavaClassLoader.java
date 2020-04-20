package com.globant.example2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class JavaClassLoader extends ClassLoader {
    
    public void invokeClassMethod(String className, String methodName){
        
        try {
            // Carga la clase usando su nombre completo
            Class<?> loadedMyClass = loadClass(className);
            
            System.out.println("Loaded class name: " + loadedMyClass.getName());
            
            // Crea una nueva instancia de la clase cargada
            Constructor<?> constructor = loadedMyClass.getConstructor();
            Object myClassObject = constructor.newInstance();
            
            // Obtiene el método de la clase y lo invoca
            Method method = loadedMyClass.getMethod(methodName);
            System.out.println("Invoked method name: " + method.getName());
            method.invoke(myClassObject);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}