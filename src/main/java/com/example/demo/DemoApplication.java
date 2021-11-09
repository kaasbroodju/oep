package com.example.demo;

import challenge2.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Stream;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo.*"})
public class DemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        loadMod("../demo1/out/artifacts/demo1_jar/demo1.jar");
    }

    private static void loadMod(String locationJar) {
        String dest = "./web/oep/mods";
        try {
            JarFile jar = new JarFile(locationJar);
            Enumeration<JarEntry> enumEntries = jar.entries();
            while (enumEntries.hasMoreElements()) {
                JarEntry file = enumEntries.nextElement();
                File f = new File(dest + File.separator + file.getName());
                if (!(dest + File.separator + file.getName()).contains("static")) continue;
                System.out.println(dest + File.separator + file.getName());
                if (file.isDirectory()) { // if its a directory, create it
                    f.mkdir();
                    continue;
                }
                f.getParentFile().mkdirs();
                InputStream is = jar.getInputStream(file); // get the input stream
                FileOutputStream fos = new FileOutputStream(f);
                while (is.available() > 0) {  // write contents of 'is' to 'fos'
                    fos.write(is.read());
                }
                fos.close();
                is.close();
            }
            jar.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
