package com.huangj.advance;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author huangj
 * @Description:
 * @date 2018/5/25
 */
public class DemoBaseTest extends BaseTest {

    @Value("${server.port}")
    int port;

    @Test
    public void testOne(){
        System.out.println("port:" + port);
    }

}
