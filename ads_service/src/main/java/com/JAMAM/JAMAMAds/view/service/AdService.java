package com.JAMAM.JAMAMAds.view.service;
import com.JAMAM.JAMAMAds.repository.AdRepository;
import com.JAMAM.JAMAMAds.view.model.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdService {
    private final AdRepository adRepository;

    @Autowired
    public AdService(AdRepository adRepository) {
        this.adRepository = adRepository;
    }
    public List<Ad> getAdsByUserID(Long userID){
        return adRepository.findByUserID(userID);
    }
    public long countActiveAds(){
        return adRepository.countActiveAds();
    }
    public List<Ad> getActiveAds(){
        return adRepository.findByAdStatus(Ad.AdStatus.ACTIVE);
    }
    public Ad save(Ad ad){
        return adRepository.save(ad);
    }

}
