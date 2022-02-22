package Payment.pay.domain.history;

import Payment.pay.domain.BaseTimeEntity;
import Payment.pay.domain.account.Account;
import Payment.pay.domain.account.Bank;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter
public abstract class History extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "history_id")
    private Long id;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "transation_balance", nullable = false)
    private int transationBalance;

    @Embedded
    private Bank targetAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;
}
