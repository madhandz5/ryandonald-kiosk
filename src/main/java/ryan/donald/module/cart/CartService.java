package ryan.donald.module.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ryan.donald.module.cart.form.CartForm;
import ryan.donald.module.menu.Menu;
import ryan.donald.module.menu.MenuRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final MenuRepository menuRepository;

    public List<Menu> insertCart(CartForm cartForm) {
        List<Menu> menuList = new ArrayList<>();
        for (int i = 0; i < cartForm.getMenus().length; i++) {
            Optional<Menu> menu = menuRepository.findById(cartForm.getMenus()[i]);
            menu.ifPresent(menuList::add);
        }
        Cart cart = Cart.builder()
                .createdAt(LocalDateTime.now())
                .menuList(menuList)
                .build();
        cartRepository.save(cart);
        return menuList;
    }
}
