package pl.sda.issuerfinder.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.sda.issuerfinder.dto.IssuerDto;
import pl.sda.issuerfinder.dto.IssuerRuleDto;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IssuerFinderServiceTest {

    @Mock
    private IssuerRuleRepository issuerRuleRepository;

    @InjectMocks
    private IssuerFinderService issuerFinderService;

    @Before
    public void setUp() {
        issuerFinderService = new IssuerFinderService(issuerRuleRepository);
        when(issuerRuleRepository.findAll()).thenReturn(getRules());
    }

    @Test
    public void getIssuer() {
        //given
        final String expectedIssuer = "Master Card";
        final String cardNumberToCheck = "5100000000000000";

        //when
        IssuerDto result = issuerFinderService.getIssuer(cardNumberToCheck);

        //then
        assertEquals(expectedIssuer, result.getIssuerName());
    }

    @Test
    public void addIssuerRule() {
        //given
        final String expectedIssuer = "Visa";
        final String expectedPrefix = "4";
        final int expectedLength = 16;
        IssuerRuleDto issuerRuleDto = new IssuerRuleDto(null, expectedIssuer, expectedPrefix, expectedLength);


        IssuerRuleEntity issuerRuleEntity = new IssuerRuleEntity();
        String expectedId = "123456";
        issuerRuleEntity.setId(expectedId);
        issuerRuleEntity.setLength(expectedLength);
        issuerRuleEntity.setPrefix(expectedPrefix);
        issuerRuleEntity.setIssuerName(expectedIssuer);
        when(issuerRuleRepository.save(any(IssuerRuleEntity.class))).thenReturn(issuerRuleEntity);

        //when
        IssuerRuleDto returnedIssuerRule = issuerFinderService.addIssuerRule(issuerRuleDto);
        ArgumentCaptor<IssuerRuleEntity> entityToSave = ArgumentCaptor.forClass(IssuerRuleEntity.class);
        verify(issuerRuleRepository).save(entityToSave.capture());

        //then
        assertEquals(expectedId, returnedIssuerRule.getId());
        assertEquals(expectedIssuer, returnedIssuerRule.getIssuerName());
        assertEquals(expectedPrefix, returnedIssuerRule.getPrefix());
        assertEquals(expectedLength, returnedIssuerRule.getLength());

        IssuerRuleEntity capturedValue = entityToSave.getValue();
        assertEquals(expectedIssuer, capturedValue.getIssuerName());
        assertEquals(expectedPrefix, capturedValue.getPrefix());
        assertEquals(expectedLength, capturedValue.getLength());
    }

    private List<IssuerRuleEntity> getRules() {
        IssuerRuleEntity issuerRuleMasterCard = new IssuerRuleEntity();
        issuerRuleMasterCard.setIssuerName("Master Card");
        issuerRuleMasterCard.setPrefix("51");
        issuerRuleMasterCard.setLength(16);

        IssuerRuleEntity issuerRuleVisa = new IssuerRuleEntity();
        issuerRuleVisa.setIssuerName("Visa");
        issuerRuleVisa.setPrefix("4");
        issuerRuleVisa.setLength(16);

        return Arrays.asList(issuerRuleMasterCard, issuerRuleVisa);
    }
}