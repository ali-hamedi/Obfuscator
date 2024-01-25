package ir.ac.kntu;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class MyCipher {
    private static final String CIPHER_ALGORITHM = "AES/CFB/NoPadding";
    private static final String SERIALIZED_FILE_NAME = "main/java/ir/ac/kntu/serialized";
    private KeyStoreReader instance2;
    private static final MyCipher instance = new MyCipher();

    private String mainKeyHex;
    private String mainIvHex;

    public static MyCipher getInstance() {
        return instance;
    }

    private MyCipher() {
        this.instance2 = (KeyStoreReader) deSerialize(SERIALIZED_FILE_NAME);
        String keyAndIv = instance2.getKey();
        this.mainKeyHex = keyAndIv.split("\\.")[0];
        this.mainIvHex = keyAndIv.split("\\.")[1];

    }

    public String decode(String ciphertextHex) {
        if(ciphertextHex==null){
            return "0";
        }
        try {
            byte[] iv = hexStringToByteArray(mainIvHex);
            byte[] keyBytes = hexStringToByteArray(mainKeyHex);

            SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv));

            byte[] ciphertext = hexStringToByteArray(ciphertextHex);
            byte[] decryptedBytes = cipher.doFinal(ciphertext);

            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace(); // Log or handle the exception appropriately
            return ""; // or throw a custom exception
        }
    }

    public String encode(Object data) {
        String inputString = data.toString();
        byte[] key = hexStringToByteArray(mainKeyHex);
        byte[] iv = hexStringToByteArray(mainIvHex);

        try {
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

            byte[] ciphertext = cipher.doFinal(inputString.getBytes(StandardCharsets.UTF_8));
            return byteArrayToHexString(ciphertext);
        } catch (Exception e) {
            e.printStackTrace(); // Log or handle the exception appropriately
            return ""; // or throw a custom exception
        }
    }

    private byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    private static String byteArrayToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static Object deSerialize(String fileName) {
        try (FileInputStream fileIn = new FileInputStream(fileName);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            return objectIn.readObject();

        } catch (Exception e) {
            System.out.println("Error while deserializing.Could be you using instance where you should not");
            return null;
        }
    }
}
