package Payment.pay.service.account;

import Payment.pay.domain.account.Account;
import Payment.pay.domain.account.AccountRepository;
import Payment.pay.domain.account.Balance;
import Payment.pay.domain.account.BalanceRepository;
import Payment.pay.web.dto.AccountRegisterRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final BalanceRepository balanceRepository;
    private final AccountMapper accountMapper;

    @Transactional
    public void register(AccountRegisterRequestDto requestDto) {
        Balance balance = balanceRepository.save(Balance.builder()
                                                        .amount(0)
                                                        .build());

        Account account = accountMapper.mapAccount(requestDto, balance);
        accountRepository.save(account);
    }
}
