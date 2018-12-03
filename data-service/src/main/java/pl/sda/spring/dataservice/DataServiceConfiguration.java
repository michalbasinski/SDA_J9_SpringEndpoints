package pl.sda.spring.dataservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
class DataServiceConfiguration {

    @Value("${checksum.service.url}")
    String url;

    @Value("${issuer.finder.service.url}")
    String serviceUrl;

    @Bean
    CardIssuerService cardIssuerService(RestTemplate restTemplate) {
        return new CardIssuerService(url, restTemplate);
    }

    @Bean
    ChecksumService checksumService(RestTemplate restTemplate) {
        return new ChecksumService(url, restTemplate);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
