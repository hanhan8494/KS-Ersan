package com.itersan.ersanadmin.config;


import com.itersan.ersanadmin.service.WeatherInterface;
import com.itersan.properties.APIProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpExchangeAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;



//阿里云API调用
@Slf4j
@Configuration
public class AliYunApiConfig {

    @Autowired
    APIProperties apiProperties;

    //1.创建客户端WebClient并纳入IOC容器
    @Bean
    public WebClient webClient() {
        //1.创建客户端
        return  WebClient.builder()
                .defaultHeader("Authorization",  "APPCODE " + apiProperties.getAppcode())
                .codecs(clientCodecConfigurer -> {
                    clientCodecConfigurer
                            .defaultCodecs()
                            .maxInMemorySize(10 * 1024 * 1024);
                    //响应数据量太大有可能会超出BufferSize，所有这里设置的大一点
                })
                .build();
    }
    //2. 将WebClient 转换为 HttpExchangeAdapter
    @Bean
    public HttpExchangeAdapter httpExchangeAdapter(WebClient apiWebClient) {
        return WebClientAdapter.create(apiWebClient); // WebClient → HttpExchangeAdapter
    }


    //3.创建工厂 HttpServiceProxyFactory
    @Bean
    public HttpServiceProxyFactory httpServiceProxyFactory() {
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(httpExchangeAdapter(webClient()))// 传入适配器
                .build();

        return factory;
    }


    //获取阿里云 地名查询code API
    @Bean
    WeatherInterface weatherInterface(HttpServiceProxyFactory httpServiceProxyFactory) {
        //获取代理对象
        WeatherInterface weatherInterface = httpServiceProxyFactory.createClient(WeatherInterface.class);
        return weatherInterface;
    }




}
