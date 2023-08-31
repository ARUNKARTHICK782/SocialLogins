package com.example.GoogleDriveDemo.service;

import com.example.GoogleDriveDemo.model.LoginResponse;
import com.example.GoogleDriveDemo.model.ResponseModal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {


    @Autowired
    RestTemplate restTemplate;

//    @Value("${spring.security.oauth2.client.keycloak.client-id}")
    String client_id;
//    @Value("${spring.security.oauth2.client.keycloak.authorization-grant-type}")
    String grant_type;
//    @Value("${spring.security.oauth2.client.keycloak.client-secret}")
    String client_secret;

    public ResponseEntity<ResponseModal> login(@RequestParam String username, @RequestParam String password){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String,String> credentials = new LinkedMultiValueMap<>();
        credentials.add("client_id",client_id);
        credentials.add("grant_type",grant_type);
        credentials.add("client_secret",client_secret);
        credentials.add("username",username);
        credentials.add("password",password);

        try{
            ResponseEntity<LoginResponse> response =  restTemplate.postForEntity("http://localhost:8080/realms/myrealm/protocol/openid-connect/token",credentials,LoginResponse.class);

            return ResponseEntity.status(200).body(new ResponseModal(true,"Logged successfully",response.getBody()));
        }catch (Exception e){
            return ResponseEntity.status(400).body(new ResponseModal(false,e.getMessage(),null));
        }
    }
}
