package com.klef.fsd.sdp.service;

import com.github.cage.Cage;
import com.github.cage.GCage;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class CaptchaService {
    private final Cage cage = new GCage();
    private final Map<String, String> captchaStore = new HashMap<>();

    public String generateCaptcha() {
        String token = UUID.randomUUID().toString();
        String text = cage.getTokenGenerator().next();
        
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            cage.draw(text, os);
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate CAPTCHA", e);
        }
        
        String base64Image = "data:image/png;base64," + 
            Base64.getEncoder().encodeToString(os.toByteArray());
        
        captchaStore.put(token, text);
        return token + "|" + base64Image;
    }

    public boolean validateCaptcha(String token, String userInput) {
        String storedText = captchaStore.get(token);
        if (storedText == null) {
            return false;
        }
        captchaStore.remove(token);
        return storedText.equalsIgnoreCase(userInput);
    }
}