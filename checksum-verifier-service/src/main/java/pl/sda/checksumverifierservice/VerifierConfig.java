package pl.sda.checksumverifierservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VerifierConfig {

    @Bean
    LuhnVerifierService luhnVerifierService() {
        return new LuhnVerifierService();
    }

}
