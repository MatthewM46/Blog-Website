package com.view.service;
import com.Ads.repository.AdRepository;
import com.view.model.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/*
@Service
public class AdService {
    private final AdRepository adRepository;

    @Autowired
    public AdService(AdRepository adRepository) {
        this.adRepository = adRepository;
    }
   /* public List<Ad> getAdsByUserID(Long userID){
        return adRepository.findByUserId(userID);
    }
    public long countActiveAds(){
        return adRepository.countActiveAds();
    }
    public List<Ad> getActiveAds(){
        return adRepository.findByStatus(Ad.AdStatus.ACTIVE);
    }

}
*/