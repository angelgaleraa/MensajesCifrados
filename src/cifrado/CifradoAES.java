package cifrado;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class CifradoAES {
    private static final String algoritmo = "AES";
    private static final String clave = "1234567890abcdef";

    public static String cifrar(String texto) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec key = new SecretKeySpec(clave.getBytes(), algoritmo);
        Cipher cipher = Cipher.getInstance(algoritmo);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] cifrado = cipher.doFinal(texto.getBytes());
        return Base64.getEncoder().encodeToString(cifrado);
    }

    public static String descifrar(String textoCifrado) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec key = new SecretKeySpec(clave.getBytes(), algoritmo);
        Cipher cipher = Cipher.getInstance(algoritmo);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodificado = Base64.getDecoder().decode(textoCifrado);
        byte[] descifrado = cipher.doFinal(decodificado);
        return new String(descifrado);
    }
}
