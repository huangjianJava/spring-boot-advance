package com.huangj.advance.common.service;

import com.huangj.advance.common.EmailDataConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

/**
 * @author huangj
 * @Description:  Email service 工具类
 * @date 2018/6/11
 */
@Service
public class EmailService {

    private static final String FROM_EMAIL = "597112336@qq.com";

    @Autowired
    private JavaMailSender mailSender;

    /**
     * 发送邮件
     * @param emailDataConfig
     * @throws MessagingException
     */
    public void send(EmailDataConfig emailDataConfig) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(FROM_EMAIL);
        helper.setTo(emailDataConfig.getToUsers().toArray(new String[]{}));
        helper.setSubject(emailDataConfig.getTitle());
        helper.setText(emailDataConfig.getContent(), true); //支持html

        // 增加inline   遍历 Map 集合
        if(null != emailDataConfig.getInlines()){
            for(Map.Entry<String,Object> entry: emailDataConfig.getInlines().entrySet()){
                if(entry.getValue() instanceof File){
                    helper.addInline(entry.getKey(), (File) entry.getValue());
                }else if(entry.getValue() instanceof Resource){
                    helper.addInline(entry.getKey(), (Resource) entry.getValue());
                }
            }
        }

        // 添加附件
        if(null != emailDataConfig.getAttachments()){
            for(Map.Entry<String,Object> entry : emailDataConfig.getAttachments().entrySet()){
                if(entry.getValue() instanceof File){
                    helper.addAttachment(entry.getKey(), (File) entry.getValue());
                }else if(entry.getValue() instanceof InputStreamResource){
                    helper.addAttachment(entry.getKey(), (InputStreamResource) entry.getValue());
                }
            }
        }

        mailSender.send(mimeMessage);
    }

}
























