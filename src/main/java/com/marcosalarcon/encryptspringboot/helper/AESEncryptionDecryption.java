package com.marcosalarcon.encryptspringboot.helper;

import com.marcosalarcon.encryptspringboot.common.Constants;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class AESEncryptionDecryption {
    public static String encrypt(String valueToEnc) throws Exception {
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(Constants.ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encValue = cipher.doFinal(valueToEnc.getBytes());
        return new BASE64Encoder().encode(encValue);
    }

    public static String decrypt(String encryptedValue) throws Exception {
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(Constants.ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedValue);
        byte[] decValue = cipher.doFinal(decordedValue);
        return new String(decValue);
    }

    private static Key generateKey() throws Exception {
        return new SecretKeySpec(Constants.myEncryptionKey.getBytes(Constants.UNICODE_FORMAT), Constants.ALGORITHM);
    }
}
