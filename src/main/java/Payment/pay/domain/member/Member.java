package Payment.pay.domain.member;

import Payment.pay.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "name",
            nullable = false)
    private String name;

    @Builder
    public Member(String name) {
        this.name = name;
    }
}
