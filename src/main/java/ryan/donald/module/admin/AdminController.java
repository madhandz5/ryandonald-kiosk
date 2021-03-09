package ryan.donald.module.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ryan.donald.module.menu.Menu;
import ryan.donald.module.menu.MenuService;
import ryan.donald.module.menu.form.RegMenuForm;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/admin")
public class AdminController {
    private final MenuService menuService;

    @GetMapping(value = "/reg-menu")
    public String regMenuForm(Model model) {
        model.addAttribute(new RegMenuForm());
        return "admin/reg-menu";
    }

    @PostMapping(value = "/reg-menu")
    public String regMenu(@Valid RegMenuForm regMenuForm, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "admin/reg-menu";
        }
        Menu newMenu = menuService.regMenu(regMenuForm);
        model.addAttribute("newMenu", newMenu);
        return "admin/reg-menu";
    }


}
