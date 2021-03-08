package ryan.donald.module.account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ryan.donald.module.account.form.SignUpForm;

import javax.validation.Valid;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class AccountService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public Account saveAccount(@Valid SignUpForm signUpForm) {
        Account account = Account.builder()
                .email(signUpForm.getEmail())
                .password(passwordEncoder.encode(signUpForm.getPassword()))
                .username(signUpForm.getName())
                .phoneNumber(signUpForm.getPhoneNumber())
                .nickname(signUpForm.getNickname())
                .build();
        account.generateEmailCheckToken();
        return accountRepository.save(account);
    }

}
