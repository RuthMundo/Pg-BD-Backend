package com.example.Proyecto.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encriptado {
	
	public static String encriptar(String entrada) {

		String salida = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] digest = md.digest(entrada.getBytes());
			StringBuilder sb = new StringBuilder();
			for(byte b : digest) {
				sb.append(String.format("%02x", b));
			}
			
			salida = sb.toString();
			
		}catch (NoSuchAlgorithmException e){
			throw new RuntimeException(e);
		}
		return salida;
				
	}
	

	
}