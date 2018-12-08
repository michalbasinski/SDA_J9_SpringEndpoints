package pl.sda.issuerfinder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.sda.issuerfinder.model.IssuerFinderService;
import pl.sda.issuerfinder.model.IssuerRuleRepository;

@Configuration
public class IssuerFinderConfiguration {

    @Bean
    IssuerFinderService issuerFinderService(IssuerRuleRepository issuerRuleRepository) {
        return new IssuerFinderService(issuerRuleRepository);
    }

}
