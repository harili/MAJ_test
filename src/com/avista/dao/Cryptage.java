/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avista.dao;


 
import javax.crypto.Cipher;  
import javax.crypto.NoSuchPaddingException;  
import javax.crypto.spec.SecretKeySpec;  
import java.io.UnsupportedEncodingException;  
import java.security.InvalidKeyException;  
import java.security.Key;  
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author Chafy 
 */
public class Cryptage {
    
    /**
     * CIPHER ALGORITHM
     */
    public static final String CIPHER_ALGORITHM = "AES";

    /**
     * KEY ALGORITHM
     */
    public static final String KEY_ALGORITHM = "AES";

    /**
     * PASS HASH ALGORITHM
     */
    public static final String PASS_HASH_ALGORITHM = "SHA-256";

    /**
     * DEFAULT PASS
     */
    public static final String DEFAULT_PASS = "AaEtcm2";

    /**
     * Crypter la donnée
     * @param data donnée à crypter
     * @return la donnée cryptée
     */
    public String encrypt(String data) {
        try {
            Cipher cipher = buildCipher(DEFAULT_PASS, Cipher.ENCRYPT_MODE);
            byte[] dataToSend = data.getBytes(Charsets.UTF_8);
            byte[] encryptedData = cipher.doFinal(dataToSend);
            return Base64.encodeBase64URLSafeString(encryptedData);

        } catch (Exception e) {
            
            throw new RuntimeException(e);
        }
    }

    /**
     * Décrypter la donnée
     * @param encryptedValue donnée à décrypter
     * @return la donnée décryptée
     */
    public String decrypt(String encryptedValue) {
        try {
            Cipher cipher = buildCipher(DEFAULT_PASS, Cipher.DECRYPT_MODE);
            byte[] encryptedData = Base64.decodeBase64(encryptedValue);
            byte[] data = cipher.doFinal(encryptedData);
            return new String(data, Charsets.UTF_8);

        } catch (Exception e) {
            
            throw new RuntimeException(e);
        }
    }

    private Cipher buildCipher(String password, int mode) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException {
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        Key key = buildKey(password);
        cipher.init(mode, key);
        return cipher;
    }

    private Key buildKey(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digester = MessageDigest.getInstance(PASS_HASH_ALGORITHM);
        digester.update(String.valueOf(password).getBytes(Charsets.UTF_8.name()));
        byte[] key = digester.digest();
        return new SecretKeySpec(key, KEY_ALGORITHM);
    }
    
    /**
     * Crypte en Hexadecimale un message
     * @param data
     * @return 
     */
    public String encryptHexa(String data) {
        try {
            Cipher cipher = buildCipher(DEFAULT_PASS, Cipher.ENCRYPT_MODE);
            byte[] dataToSend = data.getBytes(Charsets.UTF_8);
            byte[] encryptedData = cipher.doFinal(dataToSend);
            return Hex.encodeHexString(encryptedData);

        } catch (Exception e) {
            
            throw new RuntimeException(e);
        }
    }
    /**
     * décrypt le message qui est en héxadécimale
     * @param encryptedValue
     * @return 
     */
    public String decryptHexa(String encryptedValue) {
        try {
            Cipher cipher = buildCipher(DEFAULT_PASS, Cipher.DECRYPT_MODE);
            byte[] encryptedData = Hex.decodeHex(encryptedValue.toCharArray());
            byte[] data = cipher.doFinal(encryptedData);
            return new String(data, Charsets.UTF_8);

        } catch (Exception e) {
            
            throw new RuntimeException(e);
        }
    }
    
}
