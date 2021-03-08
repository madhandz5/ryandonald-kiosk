package ryan.donald.module.page;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ryan.donald.module.menu.Menu;
import ryan.donald.module.menu.MenuService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/page")
public class PageController {

    private final MenuService menuService;

    @GetMapping(value = "/home")
    public String home(Model model) {
        List<Menu> menuList = menuService.getAllMenus();
        model.addAttribute("menuList", menuList);
        return "page/home";
    }
}
