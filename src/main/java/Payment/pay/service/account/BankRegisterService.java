package Payment.pay.service.account;

import Payment.pay.domain.account.Bank;
import Payment.pay.web.dto.BankRegisterDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class BankRegisterService {

    private static RestTemplate restTemplate;

    private static String BankApiUrl = "...";

    public BankRegisterService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public static BankRegisterDto getBankAccountId(Bank bank) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(BankApiUrl)
                                                           .queryParam("bank_code", bank.getBankCode())
                                                           .queryParam("bank_account_number",
                                                                       bank.getBankAccountNumber());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, httpEntity, BankRegisterDto.class)
                           .getBody();

    }
}
