package com.alpha.johns;

import com.alpha.johns.Utils.WaitUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class Navigator {

    Driver oDriver=new Driver();
    WebDriver driver=null;

    public Navigator(){
        if(driver==null){
            driver=oDriver.getLocalDriver();
        }
    }

    public boolean navigateToURL(String url){
        boolean navigateToURL=false;
        try {
            driver.get(url);
            WaitUtil.waitMillis(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return navigateToURL;
    }
    public boolean isLinkExists(String linkText){
        boolean isLinkExists=false;
        try {
            List<WebElement> links=driver.findElements(By.linkText(linkText));
            if(links.size()>0){
                isLinkExists=true;
            }
        }catch (Exception e){
            System.err.println("isLinkExists Exce");
        }

        return isLinkExists;
    }

    public boolean selectItemFromDropDown(String dropDownName, String itemToBeSelected){
        Boolean isItemSelected=false;
        try {
            Select dropDown = new Select(driver.findElement(By.xpath("//*[contains(@name,'"+dropDownName+"')]")));
            dropDown.selectByVisibleText(itemToBeSelected);
            isItemSelected=true;
        }catch (Exception e){

        }
        return isItemSelected;
    }

    public boolean setTextByName(String inputName, String textToEnter){
        Boolean setTextById=false;
        try {
            WaitUtil.waitSeconds(1);
            WebElement input = driver.findElement(By.xpath("//*[contains(@name,'"+inputName+"')]"));
            input.sendKeys(Keys.chord(Keys.CONTROL));
            input.sendKeys(textToEnter);
        }catch (Exception e){

        }
        return setTextById;
    }

    public boolean clickInput(String inputName, String type){
        boolean clickInputType=false;
        try {
            WebElement button=driver.findElement(By.cssSelector("input[type='"+type+"'][value='"+inputName+"']"));
            if(button!=null){
                JavascriptExecutor executor=(JavascriptExecutor)driver;
                executor.executeScript("arguments[0].click();",button);
                clickInputType=true;
            }
        }catch (Exception e){

        }
        return clickInputType;
    }

    public boolean clickLink(String linkName){
        boolean clickLink=false;
        try {
            WebElement link=driver.findElement(By.linkText(linkName));
            if(link!=null){
                JavascriptExecutor executor=(JavascriptExecutor)driver;
                executor.executeScript("arguments[0].click();",link);
                clickLink=true;
            }
        }catch (Exception e){

        }
        return clickLink;
    }
    public Alert isWindowAlertExists(){
        Alert alert=null;
        try {
            alert=driver.switchTo().alert();
        }catch (Exception e){

        }
        return alert;
    }

    public WebElement findTableByHeader(String th){
        List<WebElement>ths=null;
        WebElement table=null;
        try {
            ths=driver.findElements(By.tagName("th"));
            if(ths.size()>0){
                for(int IntTh=0;IntTh<ths.size();IntTh++){
                    if(ths.get(IntTh).getText().equalsIgnoreCase(th)){
                        table=ths.get(IntTh).findElement(By.xpath("..")).findElement(By.xpath("..")).findElement(By.xpath(".."));
                        if(table!=null){
                            return table;
                        }
                    }
                }
            }
        }catch (Exception e){

        }
        return table;
    }

}
