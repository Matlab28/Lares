package com.example.lares.service;

import com.example.lares.dto.request.CustomerRequestDto;
import com.example.lares.repository.CustomerRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;
    private final CustomerRepository customerRepository;

    public void sendEmailOnce(CustomerRequestDto dto) {
        SimpleMailMessage message = new SimpleMailMessage();

        boolean exists = customerRepository.existsByEmail(dto.getEmail());

        if (exists) {
            return;
        }

        String text = "Hi, I hope you have a good time! Thank you for receiving this message!";
        String subject = "Greetings!";

        message.setFrom("matlab.abbaszada@gmail.com");
        message.setTo("metleb.abbaszade@gmail.com");
        message.setText(text);
        message.setSubject(subject);
        javaMailSender.send(message);
    }

    public String sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        String text = "Hi, I hope you have a good time! Thank you for receiving this message!";
        String subject = "Greetings!";

        message.setFrom("matlab.abbaszada@gmail.com");
        message.setTo("metleb.abbaszade@gmail.com");
        message.setText(text);
        message.setSubject(subject);
        javaMailSender.send(message);
        return "Sent successfully!";
    }

    public void sendPicture() {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            String text = "Check this";

            messageHelper.setFrom("matlab.abbaszada@gmail.com");
            messageHelper.setTo("metleb.abbaszade@gmail.com");
            messageHelper.setSubject("Gemini");
            messageHelper.setText("Check");

            String filePath = "/Users/matlab/Downloads/_a0887c6b-c882-484a-8e6b-313cce7349bb.jpg";
            File file = new File(filePath);

            if (file.exists()) {
                messageHelper.addAttachment(file.getName(), file);
                javaMailSender.send(message);
            } else {
                throw new RuntimeException("File does not exist at the specified path: " + filePath);
            }
        } catch (MessagingException e) {
            throw new RuntimeException("Error occurred while sending email: " + e.getMessage());
        }
    }

    public void sendWithPath(MultipartFile multipart) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
        String text = "Hello!";

        messageHelper.setFrom("matlab.abbaszada@gmail.com");
        messageHelper.setTo("metleb.abbaszade@gmail.com");
        messageHelper.setSubject("New Picture");
        messageHelper.setText(text);

        String fileName = multipart.getOriginalFilename();
        assert fileName != null;
        messageHelper.addAttachment(fileName, multipart);
        javaMailSender.send(message);
    }

    public void sendMultiple(List<MultipartFile> multipart) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

        for (MultipartFile item : multipart) {
            String text = "Check";

            messageHelper.setFrom("matlab.abbaszada@gmail.com");
            messageHelper.setTo("metleb.abbaszade@gmail.com");
            messageHelper.setSubject("New Picture");
            messageHelper.setText(text);

            String fileName = item.getOriginalFilename();
            messageHelper.addAttachment(fileName, item);
        }

        javaMailSender.send(message);
    }

//    @Scheduled(fixedDelay = 10000)
    public void reminder() {
        sendEmail();
    }
}
