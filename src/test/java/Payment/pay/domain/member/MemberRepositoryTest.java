package Payment.pay.domain.member;

import Payment.pay.domain.member.Member;
import Payment.pay.domain.member.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        //given
        String name = "name";

        memberRepository.save(Member.builder()
                                    .name(name)
                                    .build());

        //when
        List<Member> memberList = memberRepository.findAll();

        //then
        Member members = memberList.get(0);
        assertThat(members.getName()).isEqualTo(name);
    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2022, 2, 17, 0, 0, 0);
        String name = "name";

        memberRepository.save(Member.builder()
                                    .name(name)
                                    .build());
        //when
        List<Member> memberList = memberRepository.findAll();

        //then
        Member members = memberList.get(0);

        assertThat(members.getCreatedDate()).isAfter(now);
        assertThat(members.getLastModifiedDate()).isAfter(now);
    }
}