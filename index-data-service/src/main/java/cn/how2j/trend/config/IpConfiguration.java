package cn.how2j.trend.config;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 用于获取当前端口号。本微服务会做成集群，不同的微服务使用的是不同的端口号，
 * 可以通过获取并打印出来知当前是哪个端口。
 */

@Component
public class IpConfiguration implements ApplicationListener<WebServerInitializedEvent> {
    private int serverPort;

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        this.serverPort = event.getWebServer().getPort();
    }

    public int getPort() {
        return this.serverPort;
    }
}
