package com.company.pages;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.openqa.selenium.support.FindBy;
import sun.rmi.runtime.Log;

public class Login extends Page {
        String urlPage;
        String browser;

        public Login(String url){
            urlPage = url;
        }
        public boolean Login(String username, String password){
            Boolean bresult = true;
            tools.GotoPage(urlPage);
            tools.openBrowser(browser);

            return bresult;
        }


}
