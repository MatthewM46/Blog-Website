package com.JAMAM.JAMAMAds.view.service;

import com.JAMAM.JAMAMAds.repository.AdRepository;
import com.JAMAM.JAMAMAds.view.model.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service

public class AdExpirationService {
    @Autowired
    private AdRepository adRepository;
    @Scheduled(fixedRate=3600000)
    public void checkAdExpiry(){
        Date currentDate = new Date();
        List<Ad> activeAds = new ArrayList<>();
        Ad ad = new Ad();
        ad.setExpiryDate(currentDate);
        ad.setStatus(Ad.AdStatus.ACTIVE);
        activeAds.add(ad);
        adRepository.findActiveAdsByExpiryDateBefore(currentDate);
        for (Ad ad1 : activeAds){
            ad1.setStatus(Ad.AdStatus.EXPIRED);
            adRepository.save(ad1);
        }
    }
}
