/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.church.controller;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author nshut
 */
public class EmailService {

    private static final String FROM_EMAIL = "nshutidelphin@gmail.com";
    private static final String APP_PASSWORD = "yqsk aojk jgly kpet";

    public static void sendOTP(String toEmail, String username, String otp) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(FROM_EMAIL, APP_PASSWORD);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM_EMAIL));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(toEmail));
            message.setSubject("Church Member & Tithe System - OTP Verification");
            message.setText("Dear " + username + ",\n\n" +
                "Your One-Time Password (OTP) for login is: " + otp + "\n\n" +
                "This OTP is valid for one use only.\n\n" +
                "Church Member & Tithe System");

            Transport.send(message);
            System.out.println("OTP email sent to: " + toEmail);
        } catch (Exception ex) {
            System.out.println("Email failed, OTP for [" + username + "]: " + otp);
            ex.printStackTrace();
        }
    }

    public static void sendWelcome(String toEmail, String fullName) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(FROM_EMAIL, APP_PASSWORD);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM_EMAIL));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(toEmail));
            message.setSubject("Welcome to Church Member & Tithe System");
            message.setText("Dear " + fullName + ",\n\n" +
                "Welcome! Your membership has been registered successfully.\n" +
                "You can now log in to the Church Member & Tithe System.\n\n" +
                "God bless you.\n" +
                "Church Administration");

            Transport.send(message);
            System.out.println("Welcome email sent to: " + toEmail);
        } catch (Exception ex) {
            System.out.println("Welcome email failed for: " + fullName);
            ex.printStackTrace();
        }
    }
}
