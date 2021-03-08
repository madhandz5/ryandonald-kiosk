package ryan.donald.module.menu;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ryan.donald.module.menu.form.RegMenuForm;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/menu")
public class MenuController {
    private final MenuService menuService;

    @GetMapping(value = "/reg-menu")
    public String regMenuForm(Model model) {
        model.addAttribute(new RegMenuForm());
        return "admin/reg-menu";
    }

    @PostMapping(value = "/reg-menu")
    public String regMenu(@Valid RegMenuForm regMenuForm, Errors errors) {
        System.out.println("regMenuForm = " + regMenuForm);
        if (errors.hasErrors()) {
            return "admin/reg-menu";
        }
        menuService.regMenu(regMenuForm);
        return "redirect:/";
    }


}
