package utils;

import org.openqa.selenium.By;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    public ConfigReader(String fileName) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("src/test/resources/" + fileName + ".properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("@@@@@File is not found@@@@@");
        }
        properties = new Properties();
        try {
            properties.load(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String propertyType) {
        String property = properties.getProperty(propertyType);
        if (property != null) return property;
        else throw new RuntimeException("@@@@@Property is not found@@@@@");
    }
}
