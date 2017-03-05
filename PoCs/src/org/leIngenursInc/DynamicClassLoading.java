package org.leIngenursInc;

import org.apache.hadoop.fs.Path;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by blackShadow on 11/4/2016.
 */
public class DynamicClassLoading {

    private static final String CLASS_FQ_NAME = "topPkg.anotherPkg.finalPkg.TestClass";
    private static final String CLASS_FQ_NAME2 = "boa.Pl";
    private static final String SRC_FOLDER_PATH = "someOtherSource/";
    private static final String PROJECT_DIR = "E:/repos/javaWorkspace/DataStructuresAlgorithms/PoCs/someOtherSource/";

    public static void main(String[] args) {
        File srcDir = new File(SRC_FOLDER_PATH);
        System.out.println(srcDir.getAbsolutePath());
        System.out.println("Checking is source folder path exists ? : " +srcDir.exists());
        System.out.println("Source directory is a directory?: " +srcDir.isDirectory());
        try {
            URL srcDirUrl = srcDir.toURI().toURL();
            ClassLoader cl = new URLClassLoader(new URL[]{srcDirUrl});
            Class cls = cl.loadClass(CLASS_FQ_NAME2);
            for(Method method : cls.getDeclaredMethods()) {
                if("main".equals(method.getName())) {
                    System.out.println("MAIN...");
                    String[] params = new String[] {PROJECT_DIR, PROJECT_DIR +"out"};
//                    method.setAccessible(true);
                    method.invoke(null, (Object)params);
                }
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static void method1(String[] args) {
        File srcDir = new File(SRC_FOLDER_PATH);
        System.out.println("Checking is source folder path exists ? : " +srcDir.exists());
        System.out.println("Source directory is a directory?: " +srcDir.isDirectory());
        try {
            URL srcDirUrl = srcDir.toURI().toURL();
            ClassLoader cl = new URLClassLoader(new URL[]{ srcDirUrl});
            Class cls = cl.loadClass(CLASS_FQ_NAME);
            System.out.println(cls);
            Method[] arrMethod = cls.getDeclaredMethods();
            System.out.println("Printing method names...");
            for(Method meth : arrMethod) {
                System.out.println("-->\t" +meth.getName());
            }

            String methodName = "staticMethod1";

            System.out.println("Invoking static method... with no args...");
            Method method = cls.getMethod(methodName);
            method.invoke(cls);

            methodName = "staticMethWithArgs";
            method = cls.getMethod(methodName, String.class, int.class);
            method.invoke(cls, "Hello World!!!", 10);

            Object instance = cls.newInstance();
            Object instance1 = cls.getConstructor(String.class).newInstance("this is a string arg for constructor");

            methodName = "method1";
            method = cls.getMethod(methodName);
            System.out.println("Invoking on no arg constructed instance...");
            method.invoke(instance);
            System.out.println("Invoking on arg constructed instance...");
            method.invoke(instance1);


            methodName = "method2";
            method = cls.getMethod(methodName, String.class, int.class);
            System.out.println("Invoking on no arg constructed instance...");
            method.invoke(instance, "This is a new arg", 100);
            System.out.println("Invoking on arg constructed instance...");
            method.invoke(instance1, "This is a new arg", 100);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void listAllClassLoaders() {
        System.out.println("--- TBD ---");
    }
}
