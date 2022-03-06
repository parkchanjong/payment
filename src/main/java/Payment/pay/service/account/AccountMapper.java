package Payment.pay.service.account;

import Payment.pay.domain.account.Account;
import Payment.pay.domain.account.Balance;
import Payment.pay.domain.member.Member;
import Payment.pay.domain.member.MemberRepository;
import Payment.pay.web.dto.AccountRegisterRequestDto;
import Payment.pay.domain.account.Bank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AccountMapper {

    private final MemberRepository memberRepository;

    public Account mapAccount(AccountRegisterRequestDto requestDto, Balance balance) {
        Member member = memberRepository.findById(requestDto.getMemberId())
                                        .orElseThrow(IllegalArgumentException::new);

        //        BankRegisterDto bankRegisterDto = BankRegisterService.getBankAccountId(requestDto.getBank());

        return Account.builder()
                      .bankAccountId(1234)
                      .bank(Bank.builder()
                                .bankCode(requestDto.getBankCode())
                                .bankAccountNumber(requestDto.getBankAccountNumber())
                                .build())
                      .member(member)
                      .balance(balance)
                      .build();
    }
}
