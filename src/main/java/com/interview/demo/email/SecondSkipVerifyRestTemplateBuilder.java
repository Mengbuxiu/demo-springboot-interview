package com.interview.demo.email;

import java.io.IOException;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SecondSkipVerifyRestTemplateBuilder {

    @Bean("secondSkipRestTemplate")
    public RestTemplate verifyCaRestTemplate() {
        RestTemplate rest = new RestTemplate();
        SSLConnectionSocketFactory ssLSocketFactory = null;
        try {
            ssLSocketFactory = sslFactory("PKCS12", "abc123");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
            SSLContext sslcontext = SSLContexts.custom()
                    // //忽略掉对服务器端证书的校验
                    .loadTrustMaterial(new TrustStrategy() {
                        @Override
                        public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                            return true;
                        }
                    }).build();
            sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null,
                    SSLConnectionSocketFactory.getDefaultHostnameVerifier());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sslConnectionSocketFactory;
    }

}