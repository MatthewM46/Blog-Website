package com.JAMAM.JAMAMAds;
import com.Ads.repository.AdRepository;
import com.view.model.Ad;
import com.view.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;


@RestController
@RequestMapping("api/upload")
public class PostDeleteController {
    @Value("${upload.directory}")
    private String uploadDirectory;
    //@Autowired
   // private AdRepository adRepository;
    //@Autowired
    //private UserService userService;


    @PostMapping("/image")
    public ResponseEntity<String> uploadImage(/*@RequestHeader("Authorization") String jwtToken,*/ @RequestParam("file") MultipartFile file){
        //String userId = extractUsername(jwtToken);
       // if (userId == null){
          // return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
       // }
        if (file.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please select a file to upload");
        }
        try {

            String originalFilename = file.getOriginalFilename();

            File destFile = new File(uploadDirectory + File.separator + originalFilename);
            file.transferTo(destFile);
            // Put ad in the database. Save ad info for later. file storage location?
            Ad ad = new Ad();
            // ad.setUserId(userId);
            ad.setImagePath(destFile.getAbsolutePath()); // set the image path
            long activeAdCount = 5;
           // adRepository.countActiveAds();
            Calendar calendar = Calendar.getInstance();
            if (activeAdCount < 6){
                ad.setStatus(Ad.AdStatus.ACTIVE);
                calendar.setTime(new Date());
                calendar.add(Calendar.DAY_OF_MONTH,2);
                Date expiryDate = calendar.getTime();
                ad.setExpiryDate(expiryDate);

            }else{
                ad.setStatus(Ad.AdStatus.INACTIVE);
            }
            //save ad to the database


            //Ad save = adRepository.save(ad);


            return ResponseEntity.status(HttpStatus.CREATED).body("Ad created and uploaded");
        }
        catch (IOException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload and ad creation failed: " + e.getMessage());


        }

    }


    @DeleteMapping("api/deleteImage/{imageId}")
    public ResponseEntity<String> deleteImage(@PathVariable Long imageId, @RequestParam String imageName){

        File imageFile = new File(uploadDirectory + File.separator +imageName);

        if (imageFile.exists() && imageFile.delete()) {

            return new ResponseEntity<>("Image deleted successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Image deletion failed", HttpStatus.NOT_FOUND);
        }
    }


}
