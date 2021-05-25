package com.github.rafzsz.userpass.classes;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class Cripto {
	public static String criptSenha (String password) throws NoSuchAlgorithmException {
		MessageDigest m=MessageDigest.getInstance("MD5");
	       m.update(password.getBytes());
	       byte[] digest = m.digest();
	       String myHash = DatatypeConverter
	         .printHexBinary(digest);
	       return myHash;
	}
}
