package utiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configreader {
    private  Properties prop;
    public Properties init_prop() throws IOException {
        prop = new Properties();
        FileInputStream ip = new FileInputStream("src\\test\\resources\\dataset\\config.properties");
        prop.load(ip);
        return prop;
}}
