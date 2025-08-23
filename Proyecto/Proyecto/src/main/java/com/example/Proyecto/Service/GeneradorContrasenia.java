package com.example.Proyecto.Service;

import java.security.SecureRandom;

public class GeneradorContrasenia {

	private static int longitudContasenia = 15;

	public static String contrasenia() {
		String caracteresPermitidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!#$%/&*()+";
		SecureRandom random =new SecureRandom();
		char[] contrasenia = new char[longitudContasenia];
		
		for(int i = 0; i < contrasenia.length; i++) {
			contrasenia[i] = caracteresPermitidos.charAt(random.nextInt(caracteresPermitidos.length()));
		}
		return new String(contrasenia);
	}
}
