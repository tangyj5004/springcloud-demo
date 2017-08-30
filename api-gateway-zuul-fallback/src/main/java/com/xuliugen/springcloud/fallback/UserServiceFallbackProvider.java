package com.xuliugen.springcloud.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Providing Hystrix Fallbacks For Routes
 * <p>
 * When a circuit for a given route in Zuul is tripped you can provide a fallback response by creating a bean of type ZuulFallbackProvider.
 * Within this bean you need to specify the route ID the fallback is for and provide a ClientHttpResponse to return as a fallback.
 * Here is a very simple ZuulFallbackProvider implementation.
 * <p>
 * 当user-server-provider微服务关闭之后会调用这个类
 */
@Component
public class UserServiceFallbackProvider implements ZuulFallbackProvider {

    @Override
    public String getRoute() {
        return "user-server-provider"; //指定哪一个微服务
    }

    @Override
    public ClientHttpResponse fallbackResponse() {

        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.BAD_GATEWAY;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.BAD_GATEWAY.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.BAD_GATEWAY.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("fallback".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}