package com.atguigu.msmservice.service.impl;

import com.atguigu.msmservice.service.MsmService;
import com.atguigu.msmservice.utils.HttpUtils;
import com.atguigu.msmservice.utils.RandomUtil;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author jesse.hu
 * @date 2022/1/14 10:47
 * @LeetCodeNo
 */

@Service
public class MsmServiceImpl implements MsmService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Override
    public boolean sendMsm(String phone) {
        /*
        空号码
         */
        if (StringUtils.isEmpty(phone)){
            return false;
        }
        /**
         * REDIS 看是否缓存
         */
        String redisCode = redisTemplate.opsForValue().get(phone);
        if (!StringUtils.isEmpty(redisCode)){
            return true;   // 已经caching
        }
        String code = RandomUtil.getFourBitRandom();
        String host = "https://gyytz.market.alicloudapi.com";
        String path = "/sms/smsSend";
        String method = "POST";
        String appcode = "6a5729372512445a8145e8153aaea1a1";
        Map<String, String> headers = new HashMap<>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<>();
        querys.put("mobile", phone);
        querys.put("param", String.format("**code**:%s,**minute**:5",code));
        querys.put("smsSignId", "2e65b1bb3d054466b82f0c9d125465e2");
        querys.put("templateId", "908e94ccf08b4476ba6c876d13f084ad");
        Map<String, String> body = new HashMap<>();
        try {
            HttpResponse response =  HttpUtils.doPost(host, path, method, headers, querys, body);
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES); // 存到redis并设置过期时间
        return true;
    }
}
