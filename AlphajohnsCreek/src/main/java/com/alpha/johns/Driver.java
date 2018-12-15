package com.alpha.johns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;

public class Driver {
    public Driver(){

    }
    private static WebDriver driver=null;
    private static final String BROWSER_PROP_KEY = "browser";

    public synchronized static WebDriver getLocalDriver(){
        if(driver==null){
            try {
                driver=getBrowser();

            }catch (UnreachableBrowserException e){
                driver=getBrowser();
            }catch (WebDriverException e){
                driver=getBrowser();
            }finally {

            }

        }

        return driver;
    }

    public static WebDriver getBrowser(){
        Browser browser;
        WebDriver getBrowser;

        if(System.getProperty(BROWSER_PROP_KEY)==null){
            LoadProperties prop=new LoadProperties();
            String browserName=prop.getProperty("browser");
            browser= Browser.browserForName(browserName);
        }else {
            browser= Browser.browserForName(System.getProperty(BROWSER_PROP_KEY));
        }

        switch (browser){
            case CHROME:
                getBrowser = chromeDriver();
                break;
            default:
                getBrowser = chromeDriver();
        }

        return getBrowser;
    }

    private static WebDriver chromeDriver(){
        WebDriver chromeDriver=null;
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\webDriver\\chromedriver.exe");
 /*       ChromeOptions options=new ChromeOptions();
        DesiredCapabilities capabilities=DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY,options);*/
        chromeDriver=new ChromeDriver();
        return chromeDriver;
    }

    private ThreadLocal<WebDriver> webDriver=new ThreadLocal<>();

    private ThreadLocal<String> sessionId=new ThreadLocal<>();

    /**
     *
     * @return the {@link WebDriver} for the current thread
     */
    public WebDriver getWebDriver(){
        return webDriver.get();
    }

    public String getSessionId(){return sessionId.get();}
}
