package pl.sda.issuerfinder.model;

import lombok.AllArgsConstructor;
import pl.sda.issuerfinder.dto.IssuerDto;
import pl.sda.issuerfinder.dto.IssuerRuleDto;

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

    public IssuerRuleDto addIssuerRule(IssuerRuleDto issuerRuleDto) {
        IssuerRuleEntity ruleToSave = new IssuerRuleEntity();
        ruleToSave.setIssuerName(issuerRuleDto.getIssuerName());
        ruleToSave.setLength(issuerRuleDto.getLength());
        ruleToSave.setPrefix(issuerRuleDto.getPrefix());

        IssuerRuleEntity savedRule = issuerRuleRepository.save(ruleToSave);

        return dtoFromEntity(savedRule);
    }

    private IssuerRuleDto dtoFromEntity(IssuerRuleEntity savedRule) {
        return new IssuerRuleDto(savedRule.getId(),
                savedRule.getIssuerName(),
                savedRule.getPrefix(),
                savedRule.getLength());
    }
}
