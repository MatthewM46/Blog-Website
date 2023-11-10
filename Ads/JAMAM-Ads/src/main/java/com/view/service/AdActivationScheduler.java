package com.view.service;

import com.Ads.repository.AdRepository;
import com.view.model.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class AdActivationScheduler {
    private final AdRepository adRepository;
    @Autowired
    public AdActivationScheduler(AdRepository adRepository){
        this.adRepository = adRepository;
    }
    @Scheduled(cron = "0 0 0 * * ?")
    public void activateInactiveAds(){
        long activeAdCount = 5;
                //adRepository.countActiveAds();
        if (activeAdCount<6){
            //List<Ad> inactiveAds = adRepository.findByStatus(Ad.AdStatus.INACTIVE);
            List<Ad> inactiveAds = new ArrayList<>();
            inactiveAds.add(new Ad());
            int adsToActivate = 6 - (int)activeAdCount;

            int adsActivated = 0;
            Date currentDate = new Date();
            Calendar calendar = Calendar.getInstance();
            for (Ad ad : inactiveAds) {
                if (adsActivated < adsToActivate){
                    ad.setStatus(Ad.AdStatus.ACTIVE);
                    calendar.setTime(currentDate);
                    calendar.add(Calendar.DAY_OF_MONTH,2);
                    ad.setExpiryDate(calendar.getTime());
                    //adRepository.save(ad);
                    adsActivated++;
                }
                else{
                    break;
                }
            }
        }
    }
}
