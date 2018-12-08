package pl.sda.issuerfinder.model;

import lombok.AllArgsConstructor;
import pl.sda.issuerfinder.dto.IssuerDto;

import java.util.List;

@AllArgsConstructor
public class IssuerFinderService {

    private IssuerRuleRepository issuerRuleRepository;

    public IssuerDto getIssuer(String cardNumber) {
        List<IssuerRuleEntity> rules = issuerRuleRepository.findAll();

        String issuer = "UNKNOWN";
        for (IssuerRuleEntity rule: rules) {
            if (cardNumber.startsWith(rule.getPrefix()) && cardNumber.length() == rule.getLength()) {
                issuer = rule.getIssuerName();
                break;
            }
        }
        return new IssuerDto(issuer);
    }

}
