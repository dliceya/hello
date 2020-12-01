package com.dlice.hello;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
class AppApplicationTests {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void contextLoads() {
        String location = this.getLocation("183.156.97.4");
        System.out.println(location);

    }

    //获取用户登录地址
    @SuppressWarnings("unchecked")
    private String getLocation(String ip) {

        String authUri = "https://ips.api.bdymkt.com/iplocaltion?ip=" + ip;
        String appCode = "AppCode/e051fe2f1c1a435a886a1835019cb797";

        LinkedMultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        header.add("X-Bce-Signature", appCode);

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(header);
        StringBuilder sb = new StringBuilder();

        ResponseEntity<Map> exchange = restTemplate.exchange(authUri, HttpMethod.GET, httpEntity, Map.class);
        if (exchange.getStatusCode().equals(HttpStatus.OK)) {
            Map body = exchange.getBody();
            if (CollectionUtils.isEmpty(body)) {
                return "";
            }

            LinkedHashMap<String, String> res = (LinkedHashMap<String, String>)body.get("result");
            System.out.println(JSON.toJSONString(exchange));
            if (!CollectionUtils.isEmpty(res)) {
                sb.append(res.getOrDefault("nation", "-"))
                        .append(res.getOrDefault("province", "-"))
                        .append(res.getOrDefault("city", "-"))
                        .append(res.getOrDefault("district", "-"))
                        .append(" 经度：").append(res.getOrDefault("lat", "-"))
                        .append(" 维度：").append(res.getOrDefault("lng", "-"));
            }
        }
        return sb.toString();
    }


}
