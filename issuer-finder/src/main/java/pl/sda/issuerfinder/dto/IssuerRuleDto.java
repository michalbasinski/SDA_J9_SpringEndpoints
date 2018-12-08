package pl.sda.issuerfinder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssuerRuleDto {
    String id;
    String issuerName;
    String prefix;
    int length;
}
