package com.example.demo;

import challenge2.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Stream;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo.*"})
public class DemoApplication extends SpringBootServletInitializer {

    private static final String copiedDirectory = "static/";
    private static final String dest = "./web/oep/mods";
    private static final String infoFileName = "/info.txt";
    private static final String jarDirectory = "./jars";

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        try {
            loadMods();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadMods() throws IOException {
        try (Stream<Path> paths = Files.walk(Paths.get(jarDirectory))) {
            paths
                    .filter(path -> path.toString().endsWith(".jar"))
                    .forEach(path -> extractJar(path.toString()));
        }
    }

    private static void extractJar(String source) {
        try {
            JarFile jar = new JarFile(source);
            Enumeration<JarEntry> enumEntries = jar.entries();
            if (!isNewVersion(jar)) return; // Do not overwrite files if there's no new version.
            while (enumEntries.hasMoreElements()) {
                JarEntry file = enumEntries.nextElement();
                if (!file.getName().contains(copiedDirectory)) continue;
                System.out.println(file.getName());
                File f = new File(dest + File.separator + file.getName().substring(copiedDirectory.length()));
                if (file.isDirectory()) {
                    f.mkdir();
                    continue;
                } else {
                    f.getParentFile().mkdirs();
                }
                InputStream is = jar.getInputStream(file);
                FileOutputStream fos = new FileOutputStream(f);
                while (is.available() > 0) {
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

    private static boolean isNewVersion(JarFile jar) throws IOException {
        String dir = getInfoFileDirectory(jar) + infoFileName;
        String jarVersion = getVersion(jar.getInputStream(jar.getEntry(copiedDirectory + dir)));
        String localVersion = "";
        try {
            localVersion = getVersion(new FileInputStream(dest + dir));
        } catch (FileNotFoundException fnfe) {
            return true;
        }
        return !jarVersion.equals(localVersion);
    }

    private static String getVersion(InputStream is) {
        Scanner myReader = new Scanner(is);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            if (data.startsWith("Version:")) return data.substring(data.indexOf(":")+1);
        }
        myReader.close();
        return "";
    }

    private static String getInfoFileDirectory(JarFile jarFile) {
        Enumeration<JarEntry> enumEntries = jarFile.entries();
        while (enumEntries.hasMoreElements()) {
            JarEntry file = enumEntries.nextElement();

            if (!file.getName().contains(copiedDirectory)) continue;
            if (!file.getName().endsWith(infoFileName)) continue;
            return file.getName().substring(copiedDirectory.length(), file.getName().length() - infoFileName.length());
        }
        return null;
    }}
