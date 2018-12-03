package pl.sda.spring.dataservice;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
class ChecksumService {

    String serviceUrl;

    RestTemplate restTemplate;

    boolean isChecksumCorrect(String number) {

        ResponseEntity<ChecksumValidatorResponse> response =
                restTemplate.getForEntity(serviceUrl + number,
                        ChecksumValidatorResponse.class);
        return response.getBody().isCheckSumCorrect();
    }
}
