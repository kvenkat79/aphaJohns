package com.alpha.johns;

public enum  Browser {
    CHROME,FIREFOX,IE;

    public static Browser browserForName(String browser){
        for(Browser b: values()){
            if(b.toString().equalsIgnoreCase(browser)){
                return b;
            }
        }
        throw browserNotFound(browser);
    }

    private static IllegalArgumentException browserNotFound(String outcome){
        return new IllegalArgumentException(("invalid browser ["+outcome+"]"));
    }
}
