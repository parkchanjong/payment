package Payment.pay.web;

import Payment.pay.service.account.AccountService;
import Payment.pay.web.dto.AccountRegisterRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/api/v1/account")
    public void save(@RequestBody AccountRegisterRequestDto requestDto) {
        accountService.register(requestDto);
    }
}
