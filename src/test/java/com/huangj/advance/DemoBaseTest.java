package com.huangj.advance;

import com.huangj.advance.dto.PersonConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author huangj
 * @Description:
 * @date 2018/5/25
 */
public class DemoBaseTest extends BaseTest {

    @Value("${person.account}")
    String account;

    @Autowired
    PersonConfig personConfig;

    @Test
    public void testOne(){
        System.out.println("account:" + account);
        System.out.println("personConfig:" + personConfig);
    }

}
