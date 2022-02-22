package Payment.pay.service.account;

import Payment.pay.domain.account.Account;
import Payment.pay.domain.account.AccountRepository;
import Payment.pay.web.dto.AccountRegisterRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Transactional
    public Long register(AccountRegisterRequestDto requestDto) {
        Account account = accountMapper.toAccount(requestDto);
        return accountRepository.save(account)
                                .getId();
    }
}
