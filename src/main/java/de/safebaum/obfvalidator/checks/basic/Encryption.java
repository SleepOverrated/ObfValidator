package de.safebaum.obfvalidator.checks.basic;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Encryption {

     static int passed = 0, checks = 2;

    public static void testBlowfish() throws Exception {
        byte[] keyBytes = "mySecretKey12345".getBytes("UTF-8");
        SecretKeySpec key = new SecretKeySpec(keyBytes, "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish/ECB/NoPadding");
        cipher.init(1, key);
        byte[] inputBytes = "Encryption Test 1 Passed".getBytes("UTF-8");
        byte[] encryptedBytes = cipher.doFinal(inputBytes);
        System.out.println("Encrypted data: " + new String(encryptedBytes, "UTF-8"));
        cipher.init(2, key);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        System.out.println("Decrypted data: " + new String(decryptedBytes, "UTF-8"));
    }
    public static void testAES() throws Exception {
        String plainText = "Encryption Test 2 Passed";
        byte[] key = "very funni key12".getBytes();
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, keySpec);
        byte[] encrypted = cipher.doFinal(plainText.getBytes());
        System.out.println("Encrypted message: " + Base64.getEncoder().encodeToString(encrypted));
        cipher.init(2, keySpec);
        byte[] decrypted = cipher.doFinal(encrypted);
        System.out.println("Decrypted message: " + new String(decrypted));
    }
    public static void finish() {
        System.out.println(passed + "/" + checks);
    }
}
