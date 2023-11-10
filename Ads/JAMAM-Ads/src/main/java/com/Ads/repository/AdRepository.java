package com.Ads.repository;
import com.view.model.Ad;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AdRepository /*extends JpaRepository <Ad,Long>*/ {
    List<Ad> findByUserId(Long userID);
//    @Query("SELECT COUNT(a) FROM Ad a WHERE a.status = 'ACTIVE'")
    long countActiveAds();
    List<Ad> findByStatus(Ad.AdStatus status);
    List<Ad> findActiveAdsByExpiryDateBefore(Date currentDate);
}

