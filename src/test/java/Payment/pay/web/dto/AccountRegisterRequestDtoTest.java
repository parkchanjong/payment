package Payment.pay.web.dto;

import Payment.pay.domain.account.Bank;
import Payment.pay.domain.account.BankCode;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class AccountRegisterRequestDtoTest {

    @Test
    public void AccountRegisterRequestDto_test() {
        //given
        Long memberId = 1L;
        BankCode bankCode = BankCode.valueOf("CODE1");
        int bankAccountNumber = 1234567890;

        //when
        AccountRegisterRequestDto dto = new AccountRegisterRequestDto(memberId, bankCode, bankAccountNumber);

        //then
        assertThat(dto.getMemberId()).isEqualTo(memberId);
        assertThat(dto.getBankCode()).isEqualTo(bankCode);
        assertThat(dto.getBankAccountNumber()).isEqualTo(bankAccountNumber);
    }
}