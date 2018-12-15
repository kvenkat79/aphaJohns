package com.alpha.johns;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

    Properties prop;
    FileInputStream input=null;

    public LoadProperties(){
        try {
            File source = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\test.properties");
            FileInputStream input=new FileInputStream(source);
            prop=new Properties();
            prop.load(input);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public String getProperty(String key){
        return prop.getProperty(key);
    }
}
