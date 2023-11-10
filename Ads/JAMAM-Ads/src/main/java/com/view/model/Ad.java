package com.view.model;

//import jakarta.persistence.*;

import java.util.Date;

//@Entity
//@Table(name = "ads")
public class Ad {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)


    private String imagePath;
    private Long userID;
    public enum AdStatus{
        ACTIVE, INACTIVE, EXPIRED

    }

    private AdStatus status;
    private String AdId;
//
    private Date expiryDate;

    public void setImagePath(String imagePath){
        this.imagePath = imagePath;
    }
    public void setUserId(Long userId) {
        this.userID = userId;
    }
    public void setStatus(AdStatus status){
        this.status = status;
    }
    public void setExpiryDate(Date expiryDate){
        this.expiryDate = expiryDate;
    }

}
