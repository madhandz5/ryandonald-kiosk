package ryan.donald.module.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ryan.donald.module.account.form.SignUpForm;
import ryan.donald.module.account.validator.SignUpFormValidator;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/account")
public class AccountController {
    private final AccountService accountService;
    private final SignUpFormValidator signUpFormValidator;

    @InitBinder("signUpForm")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(signUpFormValidator);
    }

    @GetMapping(value = "/sign-up")
    public String signUpForm(Model model) {
        model.addAttribute(new SignUpForm());
        return "account/sign-up";
    }

    @PostMapping(value = "/sign-up")
    public String signUpSubmit(@Valid SignUpForm signUpForm, Errors errors) {
        if (errors.hasErrors()) {
            System.out.println("errors = " + errors);
            return "account/sign-up";
        }
        System.out.println("signUpForm = " + signUpForm.toString());
        accountService.saveAccount(signUpForm);
        return "redirect:/";
    }


}
