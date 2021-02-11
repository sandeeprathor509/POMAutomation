package com.company.sites;

import java.io.FileInputStream;
import java.util.Properties;

public class Site {
    public String sBrowserName;
    public String sStie;
    public String sUserName;
    public String sPassword;
    public Properties prop;

    public Site() {
        try {
            prop = new Properties();
            FileInputStream f = new FileInputStream(System.getProperty("user.dir") + "src/main/java/com/company/config/config.properties");
            sBrowserName = prop.getProperty("browser");
            sStie = prop.getProperty("url");
            sUserName = prop.getProperty("user");
            sPassword = prop.getProperty("password");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getBrowser(){
        return sBrowserName;
    }
    public String getURL(){
        return sStie;
    }
    public String getsUserName(){
        return sUserName;
    }
    public String getsPassword(){
        return sPassword;
    }
}
