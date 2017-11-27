package me.alanwe.poowfinal.auth;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Crypto {

    private Crypto() {}

    public static byte[] genRandomBytes(final int size) {
        final SecureRandom random = new SecureRandom();
        final byte bytes[] = new byte[size];
        random.nextBytes(bytes);
        return bytes;
    }

    public static String genBase64EncodedRandomBytes(final int size) {
        byte[] bytes = genRandomBytes(size);
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static HashedPassword hashPassword(String password) {
        final byte[] salt = genRandomBytes(20);
        password += salt;
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA-512");
            digest.update(salt);
            final byte[] encoded = digest.digest(password.getBytes("UTF-8"));
            final StringBuilder sb = new StringBuilder();
            for (byte anEncoded : encoded)
                sb.append(Integer.toString((anEncoded & 0xff) + 0x100, 16).substring(1));
            return new HashedPassword(sb.toString(), Base64.getEncoder().encodeToString(salt));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }        return null;
    }

    public static class HashedPassword {
        private final String hashedPassword;
        private final String salt;

        public HashedPassword(final String hashedPassword, final String salt) {
            this.hashedPassword = hashedPassword;
            this.salt = salt;
        }

        public String getHashedPassword() {
            return hashedPassword;
        }

        public String getSalt() {
            return salt;
        }
    }
}
