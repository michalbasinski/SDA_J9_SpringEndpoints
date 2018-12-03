package pl.sda.spring.dataservice;

import lombok.Value;

@Value
public class AnalysisResponse {
    String issuer;
    boolean isValidationPassed;
}
