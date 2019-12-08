package top.hzfq.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.hzfq.email.service.EmailService;

/**
 * @author hzfq
 * @email huzhifengqing@qq.com
 * @date 2019/11/18
 */
@RequestMapping(value = "/")
@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;

	@GetMapping(value = "send", produces = MediaType.APPLICATION_JSON_VALUE)
	public Boolean send() {
		return emailService.sendTemplateEmail("huzhifengqing@qq.com");
	}
}
