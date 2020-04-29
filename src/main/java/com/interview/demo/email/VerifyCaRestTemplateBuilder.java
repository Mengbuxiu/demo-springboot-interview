package com.interview.demo.email;

import java.io.IOException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class VerifyCaRestTemplateBuilder {

    private Logger logger = LoggerFactory.getLogger(VerifyCaRestTemplateBuilder.class);

    @Value("classpath:cert.p12")
    private Resource certFile;

    @Bean("verifyCaRestTemplate")
    public RestTemplate verifyCaRestTemplate() {
        RestTemplate rest = new RestTemplate();

        SSLConnectionSocketFactory ssLSocketFactory = null;
        try {
            ssLSocketFactory = sslFactory("PKCS12", "abc123");
        } catch (Exception e) {
            logger.error("", e);
        }

        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory(
                HttpClients.custom().setSSLSocketFactory(ssLSocketFactory).build());
        // 设置传递数据超时时长
        httpRequestFactory.setReadTimeout(1000);

        rest.setRequestFactory(httpRequestFactory);

        // 如果返回的数据非json则可能需要添加对应httpmessageconverter
        // Jaxb2RootElementHttpMessageConverter converter = new
        // Jaxb2RootElementHttpMessageConverter();
        //
        // List<MediaType> mediaTypeList = new ArrayList<>();
        // mediaTypeList.addAll(converter.getSupportedMediaTypes());
        // mediaTypeList.add(MediaType.TEXT_HTML);
        // converter.setSupportedMediaTypes(mediaTypeList);
        //
        // List<HttpMessageConverter<?>> list = new ArrayList<>();
        // list.add(converter);
        // rest.setMessageConverters(list);

        return rest;

    }

    public SSLConnectionSocketFactory sslFactory(String keyStoreType, String keyPassword) {
        SSLConnectionSocketFactory sslConnectionSocketFactory = null;
        try {
            KeyStore keyStore = null;
            try {
                keyStore = KeyStore.getInstance(keyStoreType);
                keyStore.load(certFile.getInputStream(), keyPassword.toCharArray());
            } catch (IOException e) {
                logger.error("", e);
            }

            HostnameVerifier hv = new HostnameVerifier() {
                @Override
                public boolean verify(String urlHostName, SSLSession session) {
                    // 如果需要验证https域名，可以在该处做判断,如果访问的hostname与判断不一致，则会出现如下异常
                    // if("localhost".equals(urlHostName)) {
                    // return true;
                    // }else {
                    // return false;
                    // }
                    // 此处不校验hostname，接收所有hostname，只是用于测试。
                    return true;
                }
            };

            SSLContext sslcontext = SSLContexts.custom()
                    .loadTrustMaterial(certFile.getFile(), keyPassword.toCharArray(), new TrustSelfSignedStrategy())
                    .loadKeyMaterial(keyStore, keyPassword.toCharArray()).build();
            sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null, hv);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sslConnectionSocketFactory;
    }

}