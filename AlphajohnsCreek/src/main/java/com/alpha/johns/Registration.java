package com.alpha.johns;

import java.util.Date;

public class Registration {
    private String descrptionOfProperty;
    private String regDate;
    private String nameOfParties;
    private String nature;

    public Registration(String descrptionOfProperty, String regDate, String nameOfParties, String nature) {
        this.descrptionOfProperty = descrptionOfProperty;
        this.regDate = regDate;
        this.nameOfParties = nameOfParties;
        this.nature = nature;

        setDescrptionOfProperty(this.descrptionOfProperty);
        setRegDate(this.regDate);
        setNameOfParties(this.nameOfParties);
        setNature(this.nature);
    }

    public String getDescrptionOfProperty(){return descrptionOfProperty;}
    public String getRegDate(){return regDate;}
    public String getNameOfParties(){return nameOfParties;}
    public String getNature(){return nature;}

    private void setDescrptionOfProperty(String descrptionOfProperty){this.descrptionOfProperty=descrptionOfProperty;}
    private void setRegDate(String regDate){this.regDate=regDate;}
    private void setNameOfParties(String nameOfParties){this.nameOfParties=nameOfParties;}
    private void setNature(String nature){this.nature=nature;}
}
