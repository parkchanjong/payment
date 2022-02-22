package Payment.pay.web;

import Payment.pay.domain.member.Member;
import Payment.pay.domain.member.MemberRepository;
import Payment.pay.web.dto.MemberSaveRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class MemberControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void member_등록() throws Exception {
        //given
        String name = "name";
        MemberSaveRequestDto requestDto = MemberSaveRequestDto.builder()
                                                              .name(name)
                                                              .build();

        String url = "http://localhost:" + port + "/api/v1/member";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isPositive();

        List<Member> all = memberRepository.findAll();
        assertThat(all.get(0)
                      .getName()).isEqualTo(name);
    }
}