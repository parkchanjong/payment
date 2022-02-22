package Payment.pay.domain.history;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue("Transfer")
public class Transfer extends History {

    private int txId;

    private int bankTxId;

    @Column(name = "sucess_flag", nullable = false)
    private boolean isSuccess;
}
