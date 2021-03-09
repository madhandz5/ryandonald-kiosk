package ryan.donald.module.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ryan.donald.module.cart.form.CartForm;
import ryan.donald.module.menu.Menu;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/cart")
public class CartController {

    private final CartService cartService;

    @PostMapping(value = "/input-cart")
    public String insertCart(CartForm cartForm, Model model, Errors errors) {
        List<Menu> menuList = cartService.insertCart(cartForm);
        for (Menu menu : menuList) {
            System.out.println("menu.getMenuName() = " + menu.getMenuName());
        }
        if (errors.hasErrors()) {
            return "page/home";
        }
        model.addAttribute("cartList", menuList);
        return "cart/cartbox";
    }
}
