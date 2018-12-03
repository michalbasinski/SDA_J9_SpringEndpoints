package pl.sda.spring.dataservice;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
public class CardIssuerService {

    private String serviceUrl;

    private RestTemplate restTemplate;

    public String findIssuer(String number) {
        ResponseEntity<IssuerServiceResponse> responseEntity =
                restTemplate.getForEntity(serviceUrl + "/issuer/" + number,
                        IssuerServiceResponse.class);

        return responseEntity.getBody().getIssuerName();
    }
}
