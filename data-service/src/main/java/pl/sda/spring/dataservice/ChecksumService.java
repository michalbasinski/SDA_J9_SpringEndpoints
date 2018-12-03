package pl.sda.spring.dataservice;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
public class ChecksumService {

    String url;

    RestTemplate restTemplate;

    public boolean isChecksumCorrect(String number) {

        ResponseEntity<ChecksumValidatorResponse> response =
                restTemplate.getForEntity(url + "/checksum/" + number,
                        ChecksumValidatorResponse.class);
        return response.getBody().isCheckSumCorrect();
    }
}
