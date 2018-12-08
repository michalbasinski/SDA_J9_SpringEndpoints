package pl.sda.issuerfinder.dto;

import lombok.Value;

@Value
public class IssuerRuleDto {
    String issuerName;
    String prefix;
    int length;
}
