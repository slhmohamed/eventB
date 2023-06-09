package tn.eesprit.gestionevenementback.Services;

import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;



    // Method 1
    // To send a simple email
    public String sendSimpleMail(String to)
    {

        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom("femarwa965@gmail.com");
            mailMessage.setTo(to);
            mailMessage.setSubject("Activation account");
            mailMessage.setText("Your accoount is actived by admin");


            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }




    public String sendMailConfirmation(String to,String text)
    {

        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom("femarwa965@gmail.com");
            mailMessage.setTo(to);
            mailMessage.setSubject("Confirmation");
            mailMessage.setText(text);


            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }


    public String sendMailReset(String to,String token)
    {

        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom("femarwa965@gmail.com");
            mailMessage.setTo(to);
            mailMessage.setSubject("Reset password code ");
            String text="Code de réinitialisation est : " + token;
            mailMessage.setText(text);
            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }

}
