package teddy.test;

import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.Base64;

public class KeyInfo {

	public static String getPublicKeyString(String keyStoreFile, String password, String alias) {
		try {

			FileInputStream is = new FileInputStream(keyStoreFile);
			KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());

			char[] passwd = password.toCharArray();
			keystore.load(is, passwd);

			Key key = keystore.getKey(alias, passwd);
			if (key instanceof PrivateKey) {
				// Get certificate of public key
				Certificate cert = keystore.getCertificate(alias);
				// Get public key
				PublicKey publicKey = cert.getPublicKey();
				// get public key 's string
				String publicKeyString = Base64.getEncoder().encodeToString(publicKey.getEncoded());
				return publicKeyString;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "null";
	}
	
	public static void runTest() {
//		String keyStoreFile = "";
//		String password = "";
//		String alias = "";
		
//		String publicKeyString = KeyInfo.getPublicKeyString(keyStoreFile, password, alias);
//		System.out.println("public key string = \n" + publicKeyString);
	}
}
