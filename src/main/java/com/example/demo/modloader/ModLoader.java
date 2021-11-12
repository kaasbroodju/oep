package com.example.demo.modloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Scanner;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Stream;

public class ModLoader {

    private static final Logger logger = LoggerFactory.getLogger(ModLoader.class);
    private static final String copiedDirectory = "static/";
    private static final String dest = "./web/oep/mods";
    private static final String infoFileName = "/info.txt";
    private static final String jarDirectory = "./jars";

    public static void loadMods() throws IOException {
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
            logger.info("Front-end files of " + getInfoFileDirectory(jar) + " copied to mod directory");
            jar.close();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
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
    }
}

