package com.infinitus.saas.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by administrator on 17/1/25.
 */
public class ResourceLoaderUtils {

    /**
     * @param args
     */
    public static void main(String[] args) {
//        System.out.println("ByClazz...\n--------------------------");
//        System.out.println(loadResourceByClazz(String.class, "/java/lang/String.class"));
//        System.out.println(loadResourceByClazz(String.class, "/ResourceLoadUtil.class"));
//        System.out.println();
//
//        System.out.println("ByClasLoader...\n--------------------------");
//        System.out.println(loadResourceByClassLoader("java/lang/String.class"));
//        System.out.println(loadResourceByClassLoader("ResourceLoadUtil.class"));
//        System.out.println();
//
//        System.out.println("sByClasLoader...\n--------------------------");
//        System.out.println(loadResourcesByClassLoader("java/lang/String.class"));
//        System.out.println(loadResourcesByClassLoader("ResourceLoadUtil.class"));
        System.out.println(loadResourcesByClassLoader("vm/acs/java_jdk_base.yml"));

    }

    /**
     * 根据Class加载资源文件
     *
     * @param clazz
     * @param path
     *            以'/'开头的路径: 使用绝对路径寻找文件(以ClassPath为根路径开始)<br>
     *            否则: 使用相对路径寻找文件(相对于clazz位置路径开始)
     * @return
     */
    public static InputStream loadResourceByClazz(Class<?> clazz, String path) {
        return clazz.getResourceAsStream(path);
    }

    /**
     * 根据ClassLoader加载资源文件(单个), 使用默认的ClassLoader!
     *
     * @param path
     *            不能以'/'开头的路径
     * @return
     */
    public static InputStream loadResourceByClassLoader(String path) {
        return loadResourceByClassLoader(null, path);
    }

    /**
     * 根据ClassLoader加载资源文件(单个), 使用默认的ClassLoader!
     *
     * @param path
     *            不能以'/'开头的路径
     * @return
     */
    public static InputStream loadResourceByClassLoader(ClassLoader cl, String path) {
        if (cl == null) {
            cl = Thread.currentThread().getContextClassLoader();
        }
        return cl.getResourceAsStream(path);
    }

    /**
     * 根据ClassLoader加载资源文件(多个),使用默认的ClassLoader!
     *
     * @param path
     *            不能以'/'开头的路径
     * @return
     */
    public static List<URL> loadResourcesByClassLoader(String path) {
        return loadResourcesByClassLoader(null, path);
    }

    /**
     * 根据ClassLoader加载资源文件(多个),使用指定的ClassLoader!
     *
     * @param path
     *            不能以'/'开头的路径
     * @return
     */
    public static List<URL> loadResourcesByClassLoader(ClassLoader cl, String path) {
        if (cl == null) {
            cl = Thread.currentThread().getContextClassLoader();
        }
        List<URL> urlLst = new ArrayList<URL>();
        try {
            Enumeration<URL> urlsEnum = cl.getResources(path);
            while (urlsEnum.hasMoreElements()) {
                URL url = (URL) urlsEnum.nextElement();
                urlLst.add(url);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlLst;
    }
}

