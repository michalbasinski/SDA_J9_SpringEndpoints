package pl.sda.issuerfinder.controllers;

import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.issuerfinder.dto.IssuerRuleDto;
import pl.sda.issuerfinder.model.IssuerRuleRepository;

@RestController
@NoArgsConstructor
public class RuleManagementController {

    private IssuerRuleRepository issuerRuleRepository;

    @PostMapping("/rules")
    public ResponseEntity addRule(@RequestBody IssuerRuleDto issuerRuleDto) {
        return null;
    }

}
