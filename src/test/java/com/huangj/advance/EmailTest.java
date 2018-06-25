//package com.huangj.advance;
//
//import com.google.common.collect.Maps;
//import com.huangj.advance.common.EmailDataConfig;
//import com.huangj.advance.common.service.EmailService;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.mail.MessagingException;
//import java.io.File;
//import java.util.Arrays;
//import java.util.Map;
//
///**
// * @author huangj
// * @Description:    Email 测试类
// * @date 2018/6/13
// */
//public class EmailTest extends BaseTest {
//
//    @Autowired
//    EmailService emailService;
//
//    @Test
//    public void testSendMail() throws MessagingException {
//        Map fileMap = Maps.newHashMap();
//        fileMap.put("testFile.png",new File("D:/1.png"));
//        EmailDataConfig emailConfig = EmailDataConfig.builder()
//                .title("测试一下 JavaMailSender")
//                .content("测试一下 JavaMailSender。这是测试内容")
//                .toUsers(Arrays.asList("597112336@qq.com","2223682130@qq.com"))
//                .attachments(fileMap)
//                .build();
//        emailService.send(emailConfig);
//        System.out.println("========== 发送成功 ============");
//    }
//
//}