package com.flying.entity;



import java.io.Serializable;
import java.util.Date;

//@Data
public class Test implements Serializable {

    private static final long serialVersionUID = 5231134212346077681L;

    private String ID;

    private Date CDate;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Date getCDate() {
        return CDate;
    }

    public void setCDate(Date CDate) {
        this.CDate = CDate;
    }


    @Override
    public String toString() {
        return "{ID:" + ID + "}";
    }
}
