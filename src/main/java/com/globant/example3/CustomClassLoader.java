package com.globant.example3;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Cualquier clase en com.globant.example3.foobar será cargada
 * usando este ClassLoader. EL resto, lo delegará a su Parent ClassLoader.
 *
 */
public class CustomClassLoader extends ClassLoader {

    private final String EXAMPLE_PACKAGE = "com.globant.example3.foobar";

    public CustomClassLoader(ClassLoader parent) {
        super(parent);
    }

    /**
     * Carga la clase desde el file system.
     *
     * @param name
     */
    private Class getClass(String name) throws ClassNotFoundException {
        String file = name.replace('.', File.separatorChar) + ".class";
        byte[] b = null;
        try {
            b = loadClassFileData(file);
            Class c = defineClass(name, b, 0, b.length);
            resolveClass(c);
            return c;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Cualquier request a una clase pasa a través de este método.
     *
     * @param name
     */
    @Override
    public Class loadClass(String name) throws ClassNotFoundException {
        System.out.println("Loading Class '" + name + "'");
        if (name.startsWith(EXAMPLE_PACKAGE)) {
            System.out.println("Loading Class using CustomClassLoader");
            return getClass(name);
        }
        return super.loadClass(name);
    }

    /**
     * Lee el archivo (.class) a un byte array.
     *
     * @param name
     * @return
     * @throws IOException
     */
    private byte[] loadClassFileData(String name) throws IOException {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(name);
        int size = stream.available();
        byte buff[] = new byte[size];
        DataInputStream in = new DataInputStream(stream);
        in.readFully(buff);
        in.close();
        return buff;
    }

}
