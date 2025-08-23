package com.example.Proyecto.Service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificacionContrasenia {

	private final JavaMailSender mailSender;

    // Inyección de dependencias por constructor
    public NotificacionContrasenia(final JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void enviarCorreo(String destinatario, String asunto, String cuerpo) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(destinatario);  // Configura el destinatario del correo
        mensaje.setSubject(asunto);   // Configura el asunto del correo
        mensaje.setText("Hola tu contraseña temporal es: "+cuerpo);      // Configura el contenido del mensaje
        mensaje.setFrom("claconm@miumg.edu.gt"); // Define quién envía el correo

        mailSender.send(mensaje); // Envía el correo
        System.out.println("correo enviado");
    }
}
