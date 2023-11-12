package com.JAMAM.JAMAMAds;

import com.JAMAM.JAMAMAds.view.model.Ad;
import com.JAMAM.JAMAMAds.view.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ads")
public class AdController {
    @Autowired
    private AdService adService;
    @GetMapping
    public ResponseEntity <List<Ad>> getActiveAds(){
        List<Ad> ads = adService.getActiveAds();
        /*List<Ad> ads = new ArrayList<>();
        Ad ad = new Ad();
        ad.setStatus(Ad.AdStatus.INACTIVE);
        ad.setId(Long.valueOf(123456));
        ads.add(ad);
         */
        return new ResponseEntity<>(ads, HttpStatus.OK );

    }
}
