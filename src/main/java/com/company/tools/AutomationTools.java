package com.company.tools;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutomationTools {

    protected WebDriver driver;
    protected String sBrowser;
    protected String sURL;
    protected WebElement element;
    protected HttpURLConnection hLink;
    protected  int respCode;

    public AutomationTools(){
        driver = null;
        sBrowser = null;
        element = null;
        hLink = null;
        respCode = 200;
    }

    public Boolean openBrowser(@NotNull String sBrowser){
        if(sBrowser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\SandeepRathor\\IdeaProjects\\AutomationProject\\src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        return true;
    }

//    @FindBy(how = How.ID, using = "log")
//    @CacheLookup
    public void impliciteTime(int time){
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        //throws a "No Such Element Exception"
    }

    public void expliciteTime(int time, WebElement ele){
        // tell the Web Driver to wait for certain conditions
        // thorws an "ElementNotVisibleException" exception
        WebDriverWait wait = new WebDriverWait(driver,time);
        ele = wait.until(ExpectedConditions.visibilityOfElementLocated((By) ele));
    }

    public Boolean brokenLinks(String url) throws IOException {
        List<WebElement> ele = driver.findElements(By.tagName("a"));
        Iterator<WebElement> itr = ele.iterator();
        while (itr.hasNext()) {
            url = itr.next().getAttribute("href");
        }
        try {
            hLink = (HttpURLConnection) (new URL(url).openConnection());
            hLink.setRequestMethod("HEAD");
            hLink.connect();
            respCode = hLink.getResponseCode();

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (respCode == hLink.getResponseCode()) {
            return true;
        }
        else{
            return false;
        }
    }

    public Alert handleAlert(WebElement ele){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",ele);
        Alert alert = driver.switchTo().alert();
        return alert;
    }

    public Select selectDropdown(WebElement element){

        Select select = new Select(driver.findElement(By.xpath("")));
        /*
        selectByValue(String args)
        SelectByIndex(String ars)
        SelectByVisibleText(String args)
        .isMultiple = return True if select multiple values
         */
        return select;
    }

    public List<WebElement> gettinglistofallDD(String element){
        Select select = new Select(driver.findElement(By.id(element)));
        List<WebElement> ele = select.getOptions();
        return ele;
    }

    public static void takeScreenshot(WebDriver driver, String path) throws IOException {
        TakesScreenshot screenshot = ((TakesScreenshot)driver);
        File scrpath = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(path);
        FileUtils.copyFile(scrpath,destFile);
    }

    public Boolean GotoPage(String sURL){
        driver.get(sURL);
        return true;
    }

    public void closeBrowser(){
        driver.quit();
    }
}
