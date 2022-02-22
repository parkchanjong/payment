package Payment.pay.domain.account;

import Payment.pay.domain.BaseTimeEntity;
import Payment.pay.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Account extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "account_id")
    private Long id;

    @Column(name = "bank_account_id")
    private int bankAccountId;

    @Embedded
    private Bank bank;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "balance_id")
    private Balance balance;

    @Builder
    public Account(int bankAccountId, Bank bank, Member member, Balance balance) {
        this.bankAccountId = bankAccountId;
        this.bank = bank;
        this.member = member;
        this.balance = balance;
    }
}
