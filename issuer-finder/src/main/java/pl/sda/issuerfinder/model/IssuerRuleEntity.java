package pl.sda.issuerfinder.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "issuerRules")
@Getter
@Setter
public class IssuerRuleEntity {

    @Id
    private String id;
    private String issuerName;
    private String prefix;
    private int length;

}
