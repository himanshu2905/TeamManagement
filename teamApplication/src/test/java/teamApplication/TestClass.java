package teamApplication;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestClass {

	public static void main(String[] args) {
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String encodedstring = encoder.encodePassword("secret",null);
		System.out.println(encodedstring);
		
		BCryptPasswordEncoder bencoder = new BCryptPasswordEncoder();
		System.out.println(bencoder.encode("secret1"));
	}
	
	
}
