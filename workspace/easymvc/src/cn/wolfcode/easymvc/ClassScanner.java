package cn.wolfcode.easymvc;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class ClassScanner {
    private String basePackageName;
    private URLClassLoader cl = (URLClassLoader) ClassScanner.class.getClassLoader();

    public ClassScanner(String basePackageName) {
        this.basePackageName = basePackageName;
    }

    public List<Class<?>> getClassWithAnnotation(Class<? extends Annotation> anno) {
        List<Class<?>> classes = new ArrayList<>();
        try {
            String path = basePackageName.replaceAll("\\.","/");
            URL url = cl.getURLs()[0];
            File[] files = new File(url.getPath(), path).listFiles((a,b) -> b.endsWith(".class"));
            for (File f : files) {
                int e = f.getName().lastIndexOf('.');
                String className = basePackageName + "." + f.getName().substring(0,e);
                Class<?> clz = Class.forName(className);
                if (clz.isAnnotationPresent(anno)) {
                    classes.add(clz);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return classes;
    }
}
