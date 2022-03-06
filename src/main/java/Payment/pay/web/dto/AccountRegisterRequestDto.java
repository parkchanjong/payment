package Payment.pay.web.dto;

import Payment.pay.domain.account.BankCode;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccountRegisterRequestDto {

    private Long memberId;
    private BankCode bankCode;
    private int bankAccountNumber;

    @Builder
    public AccountRegisterRequestDto(Long memberId, BankCode bankCode, int bankAccountNumber) {
        this.memberId = memberId;
        this.bankCode = bankCode;
        this.bankAccountNumber = bankAccountNumber;
    }
}
