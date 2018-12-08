package pl.sda.issuerfinder.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.issuerfinder.dto.IssuerDto;
import pl.sda.issuerfinder.model.IssuerFinderService;

@RestController
@AllArgsConstructor
public class IssuerFinderController {

    private IssuerFinderService issuerFinderService;

    @GetMapping("/issuers/{cardNumber}")
    public ResponseEntity findIssuer(@PathVariable String cardNumber) {
        IssuerDto issuer = issuerFinderService.getIssuer(cardNumber);
        return new ResponseEntity(issuer, HttpStatus.OK);
    }

}
