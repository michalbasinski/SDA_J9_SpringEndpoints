package pl.sda.checksumverifierservice;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class VerifierController {

    private LuhnVerifierService luhnVerifierService;

    @GetMapping("/verifier/{cardNumber}")
    public ResponseEntity verify(@PathVariable String cardNumber) {
        VerificationResult result = luhnVerifierService.verify(cardNumber);
        return new ResponseEntity(result, HttpStatus.OK);
    }

}
