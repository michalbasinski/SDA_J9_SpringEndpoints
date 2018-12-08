package pl.sda.checksumverifierservice;

import org.junit.Test;

import static org.junit.Assert.*;

public class LuhnVerifierServiceTest {

    private LuhnVerifierService luhnVerifierService = new LuhnVerifierService();

    @Test
    public void shouldVerifyNegatively() {
        //given
        final String cardNumber = "45678";

        //when
        VerificationResult result = luhnVerifierService.verify(cardNumber);

        //then
        assertFalse(result.isCorrect());
    }

    @Test
    public void shouldVerifyPositively() {
        //given
        final String cardNumber = "45674";

        //when
        VerificationResult result = luhnVerifierService.verify(cardNumber);

        //then
        assertTrue(result.isCorrect());
    }
}