package com.example.demo.controller;

import com.example.demo.model.AdminUser;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class BaseController {

    public AdminUser getSessionAdminUser(HttpServletRequest request){
        AdminUser adminUser = new AdminUser();
        KeycloakPrincipal principal = (KeycloakPrincipal) request.getUserPrincipal();
        KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
        AccessToken accessToken = session.getToken();
        adminUser.setUserId(accessToken.getSubject());
        adminUser.setUsername(accessToken.getPreferredUsername());
        adminUser.setEmail(accessToken.getEmail());
        adminUser.setLastname(accessToken.getFamilyName());
        adminUser.setFirstname(accessToken.getGivenName());
        adminUser.setRealmName(accessToken.getIssuer());
        AccessToken.Access realmAccess = accessToken.getRealmAccess();
        adminUser.setRoles(realmAccess.getRoles());

//        System.out.println("sessionID:" + request.getSession().getId());
//        System.out.println("IdToken_toString:" + session.getIdToken().toString());
//        System.out.println("IdToken_id:" + session.getIdToken().getId());
//        System.out.println("IdToken_string:" + session.getIdTokenString());
//        System.out.println("Token_toString:" + session.getToken().toString());
//        System.out.println("Token_id:" + session.getToken().getId());
//        System.out.println("Token_string:" + session.getTokenString());
        return adminUser;
    }

    public void logout(HttpServletRequest request) throws ServletException {
        request.logout();
    }
}
