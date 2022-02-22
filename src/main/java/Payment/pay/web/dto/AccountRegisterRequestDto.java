package Payment.pay.web.dto;

import Payment.pay.domain.account.Bank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccountRegisterRequestDto {

    private Long memberId;
    private Bank bank;

    @Builder
    public AccountRegisterRequestDto(Long memberId, Bank bank) {
        this.memberId = memberId;
        this.bank = bank;
    }
}
