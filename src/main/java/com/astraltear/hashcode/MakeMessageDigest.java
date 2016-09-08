package com.astraltear.hashcode;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;


public class MakeMessageDigest {

	public static void main(String[] args) {
		
		MakeMessageDigest makeHashCode = new MakeMessageDigest();
		
		String input="한글이다";
		makeHashCode.getHash(input);
		makeHashCode.getMD5(input);
		makeHashCode.getSHA256(input);
		System.out.println("md5:\t\t"+DigestUtils.md5Hex(input)+"\t"+DigestUtils.md5Hex(input).length());
		System.out.println("sha1Hex:\t"+DigestUtils.sha1Hex(input)+"\t"+DigestUtils.sha1Hex(input).length());
		System.out.println("sha256Hex:\t"+DigestUtils.sha256Hex(input)+"\t"+DigestUtils.sha256Hex(input).length());
		System.out.println("sha512Hex:\t"+DigestUtils.sha512Hex(input)+"\t"+DigestUtils.sha512Hex(input).length());
		System.out.println("");
		
		input="RedisTemplate을 사용하면 redis client 라이브러리의 종류에 상관없이 사용할 수 있어 좋고,redis가 지원하는 자료구조를 사용하기 좋게 랩핑을 해놓아 좋다";
		makeHashCode.getHash(input);
		makeHashCode.getMD5(input);
		makeHashCode.getSHA256(input);
		System.out.println("md5:\t\t"+DigestUtils.md5Hex(input));
		System.out.println("sha1Hex:\t"+DigestUtils.sha1Hex(input));
		System.out.println("sha256Hex:\t"+DigestUtils.sha256Hex(input));
		System.out.println("sha512Hex:\t"+DigestUtils.sha512Hex(input));
		System.out.println("");
		
		input="jedis, jredis, ... 등의 redis client 라이브러리만을 추가해 사용하는 것과,spring에서 제공하는 RedisTemplate을 함께 사용하는 방법이 있다.";
		makeHashCode.getHash(input);
		makeHashCode.getMD5(input);
		makeHashCode.getSHA256(input);
		System.out.println("md5:\t\t"+DigestUtils.md5Hex(input));
		System.out.println("sha1Hex:\t"+DigestUtils.sha1Hex(input));
		System.out.println("sha256Hex:\t"+DigestUtils.sha256Hex(input));
		System.out.println("sha512Hex:\t"+DigestUtils.sha512Hex(input));
		System.out.println("");
		
		input="Testpublic void getUserFromCache() {Stopwatch sw = new Stopwatch(\"initial User\");sw.start();User user1 = userRepository.getUser(\"debop\", 100);";
		makeHashCode.getHash(input);
		makeHashCode.getMD5(input);
		makeHashCode.getSHA256(input);
		System.out.println("md5:\t\t"+DigestUtils.md5Hex(input));
		System.out.println("sha1Hex:\t"+DigestUtils.sha1Hex(input));
		System.out.println("sha256Hex:\t"+DigestUtils.sha256Hex(input));
		System.out.println("sha512Hex:\t"+DigestUtils.sha512Hex(input));
		System.out.println("");
	}
	
	public void getHash(String str) {
		System.out.println("getHash:\t"+str.hashCode());
		
	}
	
	public void getMD5(String str){

		String MD5 = ""; 
		try{
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			md.update(str.getBytes()); 
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer(); 

			for(int i = 0 ; i < byteData.length ; i++){
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}

			MD5 = sb.toString();

		}catch(NoSuchAlgorithmException e){
			e.printStackTrace(); 
			MD5 = ""; 
		}
		System.out.println("getMD5:\t\t"+MD5);
		
	}
	
	public void getSHA256(String str){
		
		String SHA = ""; 
		try{
			MessageDigest sh = MessageDigest.getInstance("SHA-256"); 
			sh.update(str.getBytes()); 
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer(); 

			for(int i = 0 ; i < byteData.length ; i++){
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}

			SHA = sb.toString();

		}catch(NoSuchAlgorithmException e){
			e.printStackTrace(); 
			SHA = ""; 

		}
		System.out.println("getSHA256:\t"+SHA);

	}

}
