package com.jeek_time.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.core.MainResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class TestAgg {
    RestClientBuilder builder = RestClient.builder(new HttpHost("localhost", 9200))
            .setRequestConfigCallback(requestConfigBuilder -> requestConfigBuilder
                    .setConnectTimeout(3000)
                    .setSocketTimeout(5000)
                    .setConnectionRequestTimeout(500));
    RestHighLevelClient client = new RestHighLevelClient(builder);
    @Test
    void test() throws IOException {
        final MainResponse info = client.info(RequestOptions.DEFAULT);
        System.out.println("info.getNodeName() = " + info.getNodeName());
        System.out.println("info.getClusterName() = " + info.getClusterName());
        System.out.println("info.getTagline() = " + info.getTagline());
    }
}
