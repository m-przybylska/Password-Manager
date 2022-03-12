package com.security.security.service;

import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Random;

@Service
public class CryptographicService {
    public String encrypt(String decoded, Key key) throws Exception {
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encoded = c.doFinal(decoded.getBytes());
        return Base64.getEncoder().encodeToString(encoded);
    }

    public String decrypt(String encoded, Key key) throws Exception {
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedVal = Base64.getDecoder().decode(encoded);
        byte[] decoded = c.doFinal(decodedVal);
        return new String(decoded);
    }

    public String calculateSHA512(String text) {
        return null;
    }

    public Key generateKey(String keyValue) {
        return new SecretKeySpec(keyValue.getBytes(), "AES");
    }

    public String generateRandomText(int targetStringLength) {
        int left = 97, right = 122;
        return new Random().ints(left, right + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
