package top.hzfq.email.service;

/**
 * @author hzfq
 * @email huzhifengqing@qq.com
 * @date 2019/11/18
 */
public interface EmailService {

	Boolean sendSimpleEmail(String receiver);

	Boolean sendTemplateEmail(String receiver);
}
