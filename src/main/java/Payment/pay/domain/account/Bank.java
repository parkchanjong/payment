package Payment.pay.domain.account;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
@Getter
public class Bank {

    @Enumerated(EnumType.STRING)
    @Column(name = "bank_code")
    private BankCode bankCode;

    @Column(name = "bank_account_number")
    private int bankAccountNumber;

    protected Bank() {
    }

    @Builder
    public Bank(BankCode bankCode, int bankAccountNumber) {
        this.bankCode = bankCode;
        this.bankAccountNumber = bankAccountNumber;
    }
}
