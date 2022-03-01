package Payment.pay.domain.history;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@DiscriminatorValue("Transfer")
public class Transfer extends History {

    private int txId;

    private int bankTxId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",
            nullable = false)
    private TransferStatus transferStatus;
}
