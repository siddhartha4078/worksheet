package config;

import org.apache.commons.codec.binary.Base64;
import org.testng.annotations.Test;

public class passwords {

	static String preuat = "123456";
	private byte encodedBytes;

	@Test
	public static String  encrypt_preuat() {

		byte[] encodedBytes = Base64.encodeBase64(preuat.getBytes());
		//System.out.println("encodedBytes " + new String(encodedBytes));

		byte[] decodedBytes = Base64.decodeBase64(encodedBytes);
		
		String decodedpass = new String(decodedBytes);
		//System.out.println("decodedBytes " + new String(decodedBytes));

		return decodedpass;

	}

}
