package ir.ac.kntu;

import java.io.*;
import java.security.*;
import java.util.Base64;

import javax.crypto.Cipher;

public final class KeyStoreReader implements Serializable {
    private transient KeyStore keyStore;
    private String path;
    private int[] array;

    public KeyStoreReader(int[] array, String path) {
        this.path = path;
        this.array = array;
    }

    public String getKey() {
        try {
            this.keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(new FileInputStream(path + "/keystore.p12"), new String(array, 0, 16).toCharArray());

            KeyPair pythonKeyPair = getKeyPairFromKeyStore("python", new String(this.array, 0, 16));
            KeyPair javaKeyPair = getKeyPairFromKeyStore("java", new String(this.array, 0, 16));

            String mainKey = readFileContent(path + "/key.txt");
            String firstDecryptedMessage = decrypt(mainKey, javaKeyPair.getPrivate());
            return decrypt(firstDecryptedMessage, pythonKeyPair.getPublic());

        } catch (Exception e) {
            System.out.println("Error2: " + e.getMessage() + e.toString());
            return null;
        }
    }

    private KeyPair getKeyPairFromKeyStore(String alias, String keyPassword) throws Exception {
        PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, keyPassword.toCharArray());
        PublicKey publicKey = keyStore.getCertificate(alias).getPublicKey();
        return new KeyPair(publicKey, privateKey);
    }

    private String readFileContent(String filePath) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            bufferedReader.lines().forEach(contentBuilder::append);
        }
        return contentBuilder.toString();
    }

    private String decrypt(String message, Key key) throws Exception {
        String[] parts = message.split("\\|");
        String encodedString = parts[0].trim();
        String encodedKey = parts[1].trim();

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.UNWRAP_MODE, key);
        Key AESKey = cipher.unwrap(Base64.getDecoder().decode(encodedKey), "AES", Cipher.SECRET_KEY);

        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.DECRYPT_MODE, AESKey);
        byte[] decryptedBytes = aesCipher.doFinal(Base64.getDecoder().decode(encodedString));

        return new String(decryptedBytes);
    }

}
