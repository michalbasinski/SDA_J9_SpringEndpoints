package pl.sda.spring.dataservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
class DataServiceConfiguration {

    //wartości zmiennych są ustawiane w czasie startu aplikacji na bazie ustawień z pliku application.properties
    @Value("${checksum.service.url}")
    String checksumServiceUrl;

    @Value("${issuer.finder.service.url}")
    String issuerFinderServiceUrl;

    @Bean
    CardIssuerService cardIssuerService(RestTemplate restTemplate) {
        return new CardIssuerService(issuerFinderServiceUrl, restTemplate);
    }

    @Bean
    ChecksumService checksumService(RestTemplate restTemplate) {
        return new ChecksumService(checksumServiceUrl, restTemplate);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
