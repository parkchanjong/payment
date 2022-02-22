package Payment.pay.web.dto;

import Payment.pay.web.dto.MemberSaveRequestDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberSaveRequestDtoTest {

    @Test
    public void memberSaveRequestDto_test() {
        //given
        String name = "name";

        //when
        MemberSaveRequestDto dto = new MemberSaveRequestDto(name);

        //then
        assertThat(dto.getName()).isEqualTo(name);
    }
}