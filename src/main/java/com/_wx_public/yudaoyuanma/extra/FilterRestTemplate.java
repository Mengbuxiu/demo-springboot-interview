package com._wx_public.yudaoyuanma.extra;

import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

public abstract class FilterRestTemplate implements RestOperations {
        protected volatile RestTemplate restTemplate;

        protected FilterRestTemplate(RestTemplate restTemplate){
                this.restTemplate = restTemplate;
        }

        //实现RestOperations所有的接口
}