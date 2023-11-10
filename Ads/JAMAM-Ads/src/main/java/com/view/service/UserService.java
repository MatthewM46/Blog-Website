package com.view.service;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class UserService {
    private final RestTemplate restTemplate;
    public UserService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;

    }
    public String getUsernameFromAccountService(String userId){
        String accountsServiceUrl = "http://accounts-service/api/userinfo/" + userId;
        return restTemplate.getForObject(accountsServiceUrl, String.class);
    }
}
