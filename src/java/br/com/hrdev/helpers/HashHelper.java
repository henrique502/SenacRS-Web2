package br.com.hrdev.helpers;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HashHelper {
    public static String md5(String valor){
        MessageDigest digest;
        try {
       
            digest = MessageDigest.getInstance("MD5");
            byte[] valorMD5 = digest.digest(valor.getBytes("UTF-8"));
            
            StringBuffer sb = new StringBuffer();
            for (byte b : valorMD5){
                sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1,3));
            }
            
            return sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(HashHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
