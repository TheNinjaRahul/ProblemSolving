package com.company.javaLogic;

import com.sun.javafx.util.Logging;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class LoaderTest extends ClassLoader{
    public static void main(String[] args) {
        LoaderTest lt=new LoaderTest();
        try {
            Class clas = lt.loadClass("TestLoader");
            Class mainArgType[] = { (new String[0]).getClass() };
            Method main = clas.getMethod("main", mainArgType);
            main.invoke(null, null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Class loadClass(String s) throws ClassNotFoundException {
        System.out.println("Loading Class '" + s + "'");

            return getClass(s);

    }

    private byte[] loadClassFileData(String name) throws IOException {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(
                name);
        int size = stream.available();
        byte buff[] = new byte[size];
        DataInputStream in = new DataInputStream(stream);
        in.readFully(buff);
        in.close();
        return buff;
    }
    private Class getClass(String name) throws ClassNotFoundException {
        String file = name.replace('.', File.separatorChar) + ".class";
        byte[] b = null;
        try {
            // This loads the byte code data from the file
            b = loadClassFileData(file);
            // defineClass is inherited from the ClassLoader class
            // that converts byte array into a Class. defineClass is Final
            // so we cannot override it
            Class c = defineClass(name, b, 0, b.length);
            resolveClass(c);
            return c;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    private static void printLoader() {
        System.out.println("Classloader of this class:"
                + LoaderTest.class.getClassLoader());

        System.out.println("Classloader of Logging:"
                + Logging.class.getClassLoader());

        try {
            Class.forName("naem");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Classloader of ArrayList:"
                + ArrayList.class.getClassLoader());
    }
}
