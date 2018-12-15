package com.alpha.johns.Utils;

public class WaitUtil {

    public static void waitMillis(int millis){
        try {
            Thread.sleep(millis);
        }catch (InterruptedException e){

        }
    }

    public static void waitSeconds(int seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){

        }
    }

    public static void waitOneSecond(){
        waitSeconds(1);
    }

}
