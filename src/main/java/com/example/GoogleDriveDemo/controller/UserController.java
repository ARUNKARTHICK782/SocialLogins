package com.example.GoogleDriveDemo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@RequestMapping("/userdetails")
public class UserController {
    @GetMapping
    public String userDetails(Model model, Authentication authentication){
        OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
        String registrationId = oauthToken.getAuthorizedClientRegistrationId();
        Map<String,Object> attributes = oauthToken.getPrincipal().getAttributes();
        System.out.println(registrationId);
        switch (registrationId){
            case "Keycloak":{
                model.addAttribute("name",attributes.get("preferred_username"));
                model.addAttribute("email",attributes.get("email"));
                System.out.println(attributes);
                return "AuthenticatedUser";
            }
            case "Github":{
                System.out.println(attributes);
                model.addAttribute("name",attributes.get("login").toString());
                model.addAttribute("picture",attributes.get("avatar_url").toString());
                model.addAttribute("bio",attributes.get("bio"));
                model.addAttribute("following",attributes.get("following"));
                model.addAttribute("followers",attributes.get("followers"));
                return "AuthenticatedUser";
            }
            default: {
                System.out.println("Google");
                System.out.println(attributes);
                String name = attributes.get("name").toString();
                String email =attributes.get("email").toString();
                String picture = attributes.get("picture").toString();
                model.addAttribute("name",name);
                model.addAttribute("email",email);
                model.addAttribute("picture",picture);
                System.out.println(name+" "+email);
                return "AuthenticatedUser";
            }
        }
    }
}
