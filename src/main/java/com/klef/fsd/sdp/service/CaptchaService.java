package com.klef.fsd.sdp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@Service
public class CaptchaService {

    private static final String RECAPTCHA_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";
    private static final String SECRET_KEY = "REPLACE_WITH_YOUR_ACTUAL_SECRET_KEY"; // Replace with your Google reCAPTCHA secret key

    public boolean verifyCaptcha(String token) {
        RestTemplate restTemplate = new RestTemplate();

        String url = RECAPTCHA_VERIFY_URL + "?secret=" + SECRET_KEY + "&response=" + token;

        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(url, null, Map.class);
            Map body = response.getBody();
            if (body == null) {
                return false;
            }
            Boolean success = (Boolean) body.get("success");
            return success != null && success;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}


