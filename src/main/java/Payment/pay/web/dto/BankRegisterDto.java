package Payment.pay.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BankRegisterDto {

    private int bankAccountId;

    @Builder
    public BankRegisterDto(int bankAccountId) {
        this.bankAccountId = bankAccountId;
    }
}
