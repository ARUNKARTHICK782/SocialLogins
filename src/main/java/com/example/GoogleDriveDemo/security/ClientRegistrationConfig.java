package com.example.GoogleDriveDemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;

@Configuration
public class ClientRegistrationConfig {

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(this.keycloakClientRegistration(),this.githubClientRegistration(),this.googleClientRegistration());
    }


    private ClientRegistration googleClientRegistration(){
        return ClientRegistration.withRegistrationId("Google")
                .clientId("1078652517750-0m6m6bvtr8ucrn17b5co23mqpk7giifb.apps.googleusercontent.com")
                .clientSecret("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")
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .scope("openid","profile","email")
                .redirectUri("{baseUrl}/{action}/oauth2/code/{registrationId}")
                .authorizationUri("https://accounts.google.com/o/oauth2/v2/auth")
                .jwkSetUri("https://www.googleapis.com/oauth2/v3/certs")
                .tokenUri("https://www.googleapis.com/oauth2/v4/token")
                .userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
                .userNameAttributeName("sub")
                .build();
    }


    private ClientRegistration githubClientRegistration(){
        return ClientRegistration.withRegistrationId("Github")
                .clientId("Iv1.754361d4dc22ee70")
                .clientSecret("61633501a19616cb1c741df86bfe1002a3641370")
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUri("{baseUrl}/{action}/oauth2/code/{registrationId}")
                .authorizationUri("https://github.com/login/oauth/authorize")
                .tokenUri("https://github.com/login/oauth/access_token")
                .userInfoUri("https://api.github.com/user")
                .userNameAttributeName("id")
                .build();
    }

    private ClientRegistration keycloakClientRegistration() {

//        ClientRegistration clientRegistration = ClientRegistrations.fromIssuerLocation("http://localhost:8080/realms/myrealm").build();
        return ClientRegistration.withRegistrationId("Keycloak")
                .clientId("myclient")
                .clientSecret("c5543e6c-fccc-4c02-91a4-5b522219248a")
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUri("{baseUrl}/{action}/oauth2/code/{registrationId}")
                .scope("openid")
                .authorizationUri("http://localhost:8080/auth/realms/myrealm/protocol/openid-connect/auth")
                .tokenUri("http://localhost:8080/auth/realms/myrealm/protocol/openid-connect/token")
                .userInfoUri("http://localhost:8080/auth/realms/myrealm/protocol/openid-connect/userinfo")
                .userNameAttributeName(IdTokenClaimNames.SUB)
                .jwkSetUri("http://localhost:8080/auth/realms/myrealm/protocol/openid-connect/certs")
                .clientName("Keycloak")
                .build();
    }
}
