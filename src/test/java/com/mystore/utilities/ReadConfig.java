package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {

    Properties properties;

    String path ="C:\\Users\\sanjeet.kumar2\\IdeaProjects\\MyStoreV1\\Configuration\\config.properties";

    public ReadConfig(){

        try {
        properties =new Properties();
        //Now we need to read the property file

            FileInputStream fis =new FileInputStream(path);

            // Need to Load the property file
            properties.load(fis);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public String getBaseUrl() {

        String value = properties.getProperty("baseUrl");

        if (value != null)

            return value;
        else

            throw new RuntimeException("url Not specified in config File");

    }

    public String getBrowser() {

        String value = properties.getProperty("browser");

        if (value != null)

            return value;
        else

            throw new RuntimeException("url Not specified in config File");

    }
}
