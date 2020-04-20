package com.globant.example1;

import org.json.JSONString;

public class ClassLoaderInfo {
    public static void main(String[] args) {
        System.out.println("Class loader for String: " + java.lang.String.class.getClassLoader());
        System.out.println("Class loader for DNSNameService: " + sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader());
        System.out.println("Class loader for JSONString: "+ JSONString.class.getClassLoader());
        System.out.println("Class loader for this class: " + ClassLoaderInfo.class.getClassLoader());

        ClassLoader loader = ClassLoaderInfo.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }
    }
}
