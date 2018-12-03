package pl.sda.spring.dataservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class RestControllerStaticTest {

    @Mock
    private CardIssuerService cardIssuerService;

    @Mock
    private ChecksumService checksumService;

    @InjectMocks
    private DataServiceController dataServiceController = new DataServiceController();

    @Test
    public void shouldAnalyseCardNumbersCorrectly() {
        //given
        final String expectedIssuer = "Visa";
        final boolean expectedValidationResult = true;

        Mockito.when(cardIssuerService.findIssuer(ArgumentMatchers.anyString()))
                .thenReturn(expectedIssuer);

        Mockito.when(checksumService.isChecksumCorrect(ArgumentMatchers.anyString()))
                .thenReturn(expectedValidationResult);

        final String cardNumber = "111111";

        //when
        ResponseEntity response = dataServiceController.getCardAnalysisData(cardNumber);

        //then
        AnalysisResponse  analysisResult = (AnalysisResponse) response.getBody();
        Assert.assertEquals(expectedIssuer, analysisResult.getIssuer());
        Assert.assertTrue(analysisResult.isValidationPassed());
    }
}
