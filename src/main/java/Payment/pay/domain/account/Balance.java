package Payment.pay.domain.account;

import Payment.pay.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Balance extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "balance_id")
    private Long id;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Builder
    public Balance(int amount) {
        this.amount = 0;
    }

    public void update(int amount) {
        this.amount += amount;
    }
}
