package com.huangj.advance;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.google.common.io.Resources;
import com.huangj.advance.common.RsaCryptUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

/**
 * @author huangj
 * @Description: 一些简单的测试
 * @date 2018/5/29
 */
public class SimpleTest {

    private static final Logger logger = LoggerFactory.getLogger(SimpleTest.class);

    public static final String PUBLICKEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCOdxKM4vLrMnzLXOyjcTCOA62gvNAKio3MA22V\n" +
            "FOhDXAuf8V1V81vVeHSrOv4UYB3aXuk4SbCdg/8XmJ8jK6nss4X/7KBdnFZrD/LswQedJeWcYlDe\n" +
            "gBcFV3Xp87AHBRjMHTFv0f4mpiqwZHmKb9iP2jIlLUBszMeylGO9WmOm5wIDAQAB";

    public static final String PRIVATEKEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAI53Eozi8usyfMtc7KNxMI4DraC8\n" +
            "0AqKjcwDbZUU6ENcC5/xXVXzW9V4dKs6/hRgHdpe6ThJsJ2D/xeYnyMrqeyzhf/soF2cVmsP8uzB\n" +
            "B50l5ZxiUN6AFwVXdenzsAcFGMwdMW/R/iamKrBkeYpv2I/aMiUtQGzMx7KUY71aY6bnAgMBAAEC\n" +
            "gYA9momf+GcYgw1plrYQ+toHHtoOnnbLiBxGstjI1XCV6BByyhkVGJWGWn8AqBLEVsex7Mame17u\n" +
            "zewZlPqDZ9cjCUMTdUHzsqSl14ZJXwsMK2ImvQW4LZ4nXPtQi5GEMJwRC3rSjV3RK5gZGGyBdm17\n" +
            "65C5MNhx+F34cLR6t73iSQJBAMUu6D8JVc84TeffobtUEF2RE6BXhoACR+sVaBsQp05y21p5QE9L\n" +
            "yUKD3/bPG+505k9oHLF8W+5velCIYlPelgMCQQC49dcqvHc0s5YtNtmMtktQHmLqNHvzVz6gysyr\n" +
            "7u8Z0xV8YHz64kqovMASs78H0S5evsCk3x0jQKmFVRGnSthNAkB5pWGUGf89MsAlL3rIZakfADR6\n" +
            "c+S/LikOJ4utPs3ogMVAgJMjGF8WUOMnkUfrCWVYUaN5/317kHyGGE2I7kXfAkAI+BLpBZ6aNaMw\n" +
            "qho+kpBwYCjXxpfEIxTsYyktpTZ/ABdoop0s5VBNgmml/oVi8afX/FQHKrKVBQuzZX6nqB95AkEA\n" +
            "peJ2R9PyU05ZqotyRSSLHEwa3ZJOhU0HhiQltUWNM614PO+n8SWaD4rJ1b/sPT2uxrW3GOVF7e/p\n" +
            "7zu3QEYL4g==\n" +
            "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCOdxKM4vLrMnzLXOyjcTCOA62gvNAKio3MA22V\n" +
            "FOhDXAuf8V1V81vVeHSrOv4UYB3aXuk4SbCdg/8XmJ8jK6nss4X/7KBdnFZrD/LswQedJeWcYlDe\n" +
            "gBcFV3Xp87AHBRjMHTFv0f4mpiqwZHmKb9iP2jIlLUBszMeylGO9WmOm5wIDAQAB";

    @Test
    public void testPath() throws Exception {
        File file = new File(Resources.getResource("application.properties").getFile());
        System.out.println("file:" + file.getAbsolutePath());

        ClassLoader classLoader = SimpleTest.class.getClassLoader();
        URL resource = classLoader.getResource("application.properties");
        String path = resource.getPath();
        System.out.println(path);
    }

    @Test
    public void testSome() throws Exception {
        System.out.println("============== URL 编码测试 ==============");
        String hello = "{\"ali_gh\":\"123\",\"att_path\":\"123\",\"m_work_code\":\"123\",\"name\":\"开放需求\",\"presenter\":\"小明\",\"workload\":200}";
        String encode = URLEncoder.encode(hello, Charsets.UTF_8.name());
        System.out.println("encode:" + encode);

        String decode = URLDecoder.decode(encode, Charsets.UTF_8.name());
        System.out.println("decode:" + decode);
    }

    @Test
    public void testSign() throws Exception {
        // 将参数进行字典排序
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = new TreeMap<>();
        map.put("orderId", "10086");
        map.put("mobile", "13632598743");
        // 组成待签名字符串
        sb.delete(0, sb.length()); // 清空StringBuilder
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sb.toString().contains("="))
                sb.append("&");
            sb.append(entry.getKey() + "=" + entry.getValue());
        }
        String signContent = sb.toString();
        System.out.println("待签名内容：" + signContent);

        // 1.用私钥生成签名
        String sign = RsaCryptUtil.sign(signContent.getBytes(), PRIVATEKEY);
        System.out.println("私钥：" + PRIVATEKEY);
        System.out.println("签名：" + sign);
        System.out.println("签名长度：" + sign.length());

        // 2.用公钥进行验签
        boolean verifySuccess = RsaCryptUtil.verify(signContent.getBytes(), PUBLICKEY, sign);
        System.out.println("公钥：" + PUBLICKEY);
        System.out.println("验签结果：" + verifySuccess);
    }

    @Test
    public void testRsa() throws Exception {
        System.out.println("生成新的秘钥对---------------------------------------------------------");
        Map<String, Object> genKeyPair = RsaCryptUtil.genKeyPair();
        Object object = RsaCryptUtil.getPublicKey(genKeyPair);
        System.out.println("PublicKey:" + object.toString());
        System.out.println("公钥长度:" + object.toString().length());
        Object object2 = RsaCryptUtil.getPrivateKey(genKeyPair);
        System.out.println("PrivateKey:" + object2.toString());
        System.out.println("私钥长度:" + object2.toString().length());

        System.out.println("--------------公钥加密,私钥解密--------------");
        String phone = "13632598743";
        System.out.println("原始手机号：\r\n" + phone);
        String encodedData = RsaCryptUtil.encryptByPublicKey(phone, PUBLICKEY);
        System.out.println("公钥加密后手机号：\r\n" + encodedData);
        System.out.println("---------------------------------------------------------");
        String decryptData = RsaCryptUtil.decryptByPrivateKey(encodedData, PRIVATEKEY);
        System.out.println("私钥解密后手机号：\r\n" + decryptData);

        System.out.println("--------------私钥加密,公钥解密--------------");
        String phoneTwo = "15773002366";
        System.out.println("原始手机号：\r\n" + phoneTwo);
        String encodedDataTwo = RsaCryptUtil.encryptByPrivateKey(phoneTwo, PRIVATEKEY);
        System.out.println("私钥加密后手机号：\r\n" + encodedDataTwo);
        System.out.println("---------------------------------------------------------");
        String decryptDataTwo = RsaCryptUtil.decryptByPublicKey(encodedDataTwo, PUBLICKEY);
        System.out.println("公钥解密后手机号：\r\n" + decryptDataTwo);

    }

    @Test
    public void testJson() {
        String json = "{\n" +
                "  \"memberLogReqDto\": {\n" +
                "    \"appVersion\": \"string\",\n" +
                "    \"businessTypeCode\": 0,\n" +
                "    \"cityName\": \"string\",\n" +
                "    \"deviceSystem\": \"string\",\n" +
                "    \"latitude\": 0,\n" +
                "    \"logIp\": \"string\",\n" +
                "    \"logMac\": \"string\",\n" +
                "    \"logPhoneType\": \"string\",\n" +
                "    \"longitude\": 0,\n" +
                "    \"sourceType\": 0\n" +
                "  },\n" +
                "  \"password\": \"string\",\n" +
                "  \"phone\": \"string\"\n" +
                "}";

        Map map = JSON.parseObject(json, Map.class);

        Map<String, String> sortedMap = new TreeMap<String, String>(map);

        String postName = HttpMethod.POST.name();
        System.out.println("postName:" + postName);
    }

    @Test
    public void testOne() {
        Date today = new Date();
        long time1 = System.currentTimeMillis();

        long time2 = DateUtils.addMinutes(today, 2).getTime();

        Long diff = (time2 - time1) / (1000 * 60);
        System.out.println("diff:" + diff);

        if (diff < 0 || diff > 1) {
            System.out.println("有误");
        } else {
            System.out.println("无误");
        }


       /* Long diff = (1534911836876L - 1534911836776L) / (1000 * 60);
        System.out.println("diff:" + diff);*/



        /*JSONObject json = JSONObject.parseObject("{\"session_key\":\"wAZ26h\\/rp1aBkp6qYuQ48Q==\",\"openid\":\"oXuJJ5ICD9bry45a5no_eASv4KUI\",\"unionid\":\"o5c8S1OLftMj89sR92PsPDpOE60I\"}");
        Object keyObject = json.get("session_key1");
        if (keyObject != null) {
            String sessionKey = String.valueOf(keyObject);
            System.out.println("sessionKey:" + sessionKey);
        }else{
            System.out.println("失败");
        }*/



       /* try {
            String str = new String(null, "utf-8");
            System.out.println("str:" + str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
    }

    @Test
    public void test() {
        boolean numberFlag = true;
        String retStr = "";
        String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
        int len = strTable.length();
        boolean bDone = true;
        do {
            retStr = "";
            int count = 0;
            for (int i = 0; i < 8; i++) {
                double dblR = Math.random() * len;
                int intR = (int) Math.floor(dblR);
                char c = strTable.charAt(intR);
                if (('0' <= c) && (c <= '9')) {
                    count++;
                }
                retStr += strTable.charAt(intR);
            }
            if (count >= 2) {
                bDone = false;
            }
        } while (bDone);
        System.out.println("retStr:" + retStr);
    }

    @Test
    public void testLog() throws Exception {
        logger.error("error log 测试");

        Date date1 = DateUtils.parseDate("2018-09-07 23:59:59","yyyy-MM-dd HH:mm:ss");
        long time1 = date1.getTime();
        System.out.println("time1:" + time1);

        Date date2 = DateUtils.parseDate("2018-09-07","yyyy-MM-dd");
        long time2 = date2.getTime();
        System.out.println("time2:" + time2);




    }

}

























