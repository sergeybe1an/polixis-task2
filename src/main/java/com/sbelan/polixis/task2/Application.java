package com.sbelan.polixis.task2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Scanner;

public class Application {

    private static final BinarySearchTree BINARY_SEARCH_TREE = new BinarySearchTree();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(Paths.get(ConfigProperties.getFileName()))) {

            while (scanner.hasNext()) {
                BINARY_SEARCH_TREE.put(scanner.next());
            }

            System.out.printf("Quantity of unique IPs: %d", BINARY_SEARCH_TREE.size());

        } catch (IOException e) {
            System.out.printf("Some error occured, while reading file: %s", e.getMessage());
        }
    }

    private static class ConfigProperties {
        private final static String propertiesFile = "config.properties";

        private static String getFileName() {
            String fileName = "";
            InputStream inputStream;
            Properties properties = new Properties();

            try {
                inputStream = ConfigProperties.class.getClassLoader().getResourceAsStream(propertiesFile);

                if (inputStream != null) {
                    properties.load(inputStream);
                } else {
                    throw new FileNotFoundException("property file " + propertiesFile + " didn't found");
                }

                fileName = properties.getProperty("ips_file_name_path");

            } catch (IOException e) {
                System.out.printf("Error while loading properties: %s", e.getMessage());
            }
            return fileName;
        }
    }
}
