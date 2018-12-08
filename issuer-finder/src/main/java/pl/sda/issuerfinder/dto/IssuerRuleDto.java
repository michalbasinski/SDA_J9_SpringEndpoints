package pl.sda.issuerfinder.dto;

import lombok.Value;

@Value
public class IssuerRuleDto {
    String id;
    String issuerName;
    String prefix;
    int length;
}
