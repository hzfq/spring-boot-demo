package top.hzfq.email.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import top.hzfq.email.service.EmailService;

import javax.mail.MessagingException;
import java.util.Date;

/**
 * @author hzfq
 * @email huzhifengqing@qq.com
 * @date 2019/11/18
 */
@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSenderImpl sender;
	@Autowired
	private TemplateEngine engine;

	@Override
	public Boolean sendSimpleEmail(String receiver) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(sender.getUsername());
		message.setTo(receiver);
		message.setSubject("SimpleMailMessage");
		message.setText("Simple Mail Message, " + new Date());

		try {
			sender.send(message);
			return true;
		} catch (MailException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean sendTemplateEmail(String receiver) {
		//模板上下文
		Context context = new Context();
		//模板变量，可使用Map
		context.setVariable("project", "HZFQ");
		context.setVariable("author", "huzhifengqing");
		context.setVariable("code", "123456");

		try {
			MimeMessageHelper helper = new MimeMessageHelper(sender.createMimeMessage());
			helper.setFrom(sender.getUsername());
			helper.setTo(receiver);
			helper.setSubject("TemplateMailMessage");
			helper.setText(engine.process("email", context), true);
			sender.send(helper.getMimeMessage());
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}
}
