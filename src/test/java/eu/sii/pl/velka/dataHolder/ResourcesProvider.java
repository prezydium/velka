package eu.sii.pl.velka.dataHolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class ResourcesProvider {

    public ResourcesProvider() {
    }

    public static String getFileContent(String resourcesFileName) throws IOException {
        Path path = Paths.get(Objects.requireNonNull(ClassLoader
                .getSystemClassLoader()
                .getResource(resourcesFileName))
                .getPath());
        return new String(Files.readAllBytes(path));
    }
}
