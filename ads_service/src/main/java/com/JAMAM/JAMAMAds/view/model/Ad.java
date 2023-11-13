package com.JAMAM.JAMAMAds.view.model;

import jakarta.persistence.*;
import java.lang.String;
import java.io.Serializable;
import java.util.Date;
import java.lang.Long;

@Entity
@Table(name = "ads")
public class Ad implements Serializable {




    private String imagePath;
    private Long userID;

    @Enumerated(EnumType.STRING)

    private AdStatus adStatus;
//
    private Date expiryDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Ad(){
        this.adStatus = AdStatus.INACTIVE;
    }



    public Long getId() {
        return id;
    }

    public enum AdStatus{
        ACTIVE, INACTIVE, EXPIRED

    }

    public void setImagePath(String imagePath){
        this.imagePath = imagePath;
    }
    public String getImagePath(){
        return imagePath;
    }
    public void setUserID(Long userId) {
        this.userID = userId;
    }

    public Long getUserID(){
        return userID;
    }
    public void setStatus(AdStatus status){
        this.adStatus = status;
    }
    public AdStatus getStatus(){
        return adStatus;
    }
    public void setExpiryDate(Date expiryDate){
        this.expiryDate = expiryDate;
    }
    public Date getExpiryDate(){
        return expiryDate;
    }

    @Override
    public String toString(){
        return "Ad{" + "id='" + id + '\'' + "adStatus='" + adStatus + '}';
    }

}
