package Payment.pay.domain.history;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue("Withdrawal")
public class Withdrawal extends History {

}
