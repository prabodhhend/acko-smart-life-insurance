package org.acko.smartlife.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

/**
 * @author prabodh.hend
 */
@Configuration
@Data
@EnableCaching
@EnableAsync
public class AppConfig implements ApplicationContextAware {

    @Autowired
    private Environment environment;

    private ApplicationContext appContext;

    public void setApplicationContext(ApplicationContext context) {
        this.appContext = context;
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters()
                .add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

        return restTemplate;
    }
}
