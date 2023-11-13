package com.JAMAM.JAMAMAds.repository;
import com.JAMAM.JAMAMAds.view.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AdRepository extends JpaRepository <Ad,Long> {
    List<Ad> findByUserID(Long userID);
    @Query("SELECT COUNT(a) FROM Ad a WHERE a.adStatus = 'ACTIVE'")
    long countActiveAds();
    List<Ad> findByAdStatus(Ad.AdStatus adStatus);
    List<Ad> findActiveAdsByExpiryDateBefore(Date currentDate);
}

