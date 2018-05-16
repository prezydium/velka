package eu.sii.pl.velka;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LoadFile {

    public static String loadJsonFile(String fileName) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        Path platformIndependentPath = null;
        try {
            platformIndependentPath = Paths.get(classloader.getResource(fileName).toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return new String(Files.readAllBytes(platformIndependentPath));
    }
}
