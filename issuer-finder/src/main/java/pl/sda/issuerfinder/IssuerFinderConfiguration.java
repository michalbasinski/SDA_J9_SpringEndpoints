package pl.sda.issuerfinder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IssuerFinderConfiguration {

    @Bean
    IssuerFinderService issuerFinderService(IssuerRuleRepository issuerRuleRepository) {
        return new IssuerFinderService(issuerRuleRepository);
    }

}
