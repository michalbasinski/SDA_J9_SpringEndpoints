package pl.sda.checksumverifierservice;

public class LuhnVerifierService {
    public VerificationResult verify(String cardNo) {
        int[] cardNumberArray = new int[cardNo.length()];
        for (int i = 0; i < cardNo.length();i++) {
            cardNumberArray[i] = Character.getNumericValue(cardNo.charAt(i));
        }

        int sum = 0;
        int j = 0;
        for (int i = cardNumberArray.length - 1; i >= 0; i--) {
            int element = cardNumberArray[i];
            j++;
            if (j % 2 == 0) {
                element = element * 2;
                if (element >= 10) {
                    element = element - 9;
                }
            }
            sum = sum + element;
        }

        return new VerificationResult(sum % 10 == 0);
    }
}
