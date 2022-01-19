package com.atguigu.eduorder.constants;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author jesse.hu
 * @date 2022/1/18 17:57
 */

@Component
@PropertySource("classpath:application.properties")
public class WxConstants implements InitializingBean {
    @Value("${wx.open.app_id}")
    private String appId;

    @Value("${wx.open.partner}")
    private String partner;

    @Value("${wx.open.partnerkey}")
    private String partnerkey;

    @Value("${wx.open.notifyurl}")
    private String notifyurl;

    public static String WX_OPEN_APP_ID;
    public static String WX_OPEN_PARTNER;
    public static String WX_OPEN_PARTNER_KEY;
    public static String WX_OPEN_NOTIFY_URL;

    @Override
    public void afterPropertiesSet() throws Exception {
        WX_OPEN_APP_ID = appId;
        WX_OPEN_PARTNER = partner;
        WX_OPEN_PARTNER_KEY = partnerkey;
        WX_OPEN_NOTIFY_URL = notifyurl;
    }
}
