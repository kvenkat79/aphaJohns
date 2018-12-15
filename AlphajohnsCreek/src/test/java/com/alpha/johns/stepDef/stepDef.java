package com.alpha.johns.stepDef;

import com.alpha.johns.*;
import com.alpha.johns.Utils.WaitUtil;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class stepDef {
    Navigator navigator=new Navigator();
    LoadProperties prop=new LoadProperties();

    @Test
    public void testee(){
        String url=this.prop.getProperty("baseurl");
        navigator.navigateToURL(url);
        WaitUtil.waitSeconds(2);

        navigator.clickLink("List of Transactions");
        //int number=5700;5925;5900
        int number=5700;
        do {
            WaitUtil.waitSeconds(2);
            navigator.selectItemFromDropDown("districtCode","PRAKASAM");
            WaitUtil.waitSeconds(1);
            navigator.selectItemFromDropDown("sroCode","KANDUKUR");
            WaitUtil.waitSeconds(1);
            navigator.setTextByName("doctno",String.valueOf(number));
            navigator.setTextByName("regyear","2018");
            WaitUtil.waitSeconds(1);
            navigator.clickInput("Submit","submit");
            WaitUtil.waitSeconds(2);
            Alert alert=navigator.isWindowAlertExists();
            if(alert!=null){
                alert.accept();
            }else {
                getDesc("Description of property",number);
                navigator.clickInput("Back","button");
            }
            number++;
        }while (number<5990);
    }

    public void getDesc(String header, int number){
        List<WebElement> tds=null;
        List<WebElement> trs=null;
        WebElement table=navigator.findTableByHeader(header);
        trs=table.findElements(By.tagName("tr"));
        for(int IntTB=1;IntTB<trs.size();IntTB++){
            tds=trs.get(IntTB).findElements(By.xpath("td"));
            String des=tds.get(1).getText();
            if(des.contains("GUDLURU")){
                String date=tds.get(2).getText();
                String nature=tds.get(3).getText();
                String owner=tds.get(4).getText();
                Log.info("-----Doc Number Begin ----"+number +" --------Registration date: "+date+"-------");
                Log.info("-----Descrption-------"+des);
                Log.info("-----Nature-------"+nature);
                Log.info("-----Owner------------"+owner);
                //Registration registration=new Registration(des,date,owner,nature);
                //ExcelWriter excelWriter=new ExcelWriter();
                //excelWriter.AddData();
            }
        }
    }
}
