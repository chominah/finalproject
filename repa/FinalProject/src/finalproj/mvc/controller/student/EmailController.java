package finalproj.mvc.controller.student;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import finalproj.dto.CplistVO;





@Controller
public class EmailController {
@Autowired
private JavaMailSender mailSender;

// 메일보내기
@RequestMapping(value="/sendmail")	
public ModelAndView sendmail(String mailTo,String subject,String text,MultipartFile file) throws AddressException, MessagingException {
	ModelAndView mav = new ModelAndView();
	MimeMessage mimeMessage = mailSender.createMimeMessage();
	
	System.out.println(mailTo);
	System.out.println(subject);
	System.out.println(text);
	System.out.println(file.getOriginalFilename());
	
	String from = "''";
	mimeMessage.setFrom(new InternetAddress(from));
	mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(mailTo));
    mimeMessage.setSubject(subject);
    mimeMessage.setText(text,"UTF-8","html");
    mimeMessage.setFileName(file.getOriginalFilename());
    mailSender.send(mimeMessage);
    
    
    return mav;
}
	
}
