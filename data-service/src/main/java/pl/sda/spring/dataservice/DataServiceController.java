package pl.sda.spring.dataservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataServiceController {

    @Autowired
    ChecksumService checksumService;

    @Autowired
    CardIssuerService cardIssuerService;

    @GetMapping("/card/{number}")
    public ResponseEntity getCardAnalysisData(@PathVariable String number) {

        boolean isCorrect = checksumService.isChecksumCorrect(number);
        String issuer = cardIssuerService.findIssuer(number);

        AnalysisResponse response = new AnalysisResponse(issuer, isCorrect);
        return new ResponseEntity(response, HttpStatus.OK);
    }

}
