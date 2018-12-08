package pl.sda.issuerfinder.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sda.issuerfinder.IssuerFinderServiceApplication;
import pl.sda.issuerfinder.model.IssuerFinderService;
import pl.sda.issuerfinder.model.IssuerRuleEntity;
import pl.sda.issuerfinder.model.IssuerRuleRepository;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = IssuerFinderServiceApplication.class)
public class IssuerFinderControllerTest {

    @LocalServerPort
    private int localServerPort;

    @MockBean
    private IssuerRuleRepository issuerRuleRepository;

    @Autowired
    private IssuerFinderService issuerFinderService;

    @Before
    public void setUp() {
        when(issuerRuleRepository.findAll()).thenReturn(getRules());
    }

    @Test
    public void shouldFindIssuer() {
        //given


        //when

        //then
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