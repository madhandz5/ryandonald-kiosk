package ryan.donald.module.menu;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ryan.donald.module.menu.form.RegMenuForm;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MenuService {
    private final MenuRepository menuRepository;

    public Menu regMenu(@Valid RegMenuForm regMenuForm) {
        Menu menu = Menu.builder()
                .menuName(regMenuForm.getMenuName())
                .price(regMenuForm.getPrice())
                .menuCategory(MenuCategory.valueOf(String.valueOf(regMenuForm.getMenuCategory())))
                .registeredAt(LocalDateTime.now())
                .build();
        return menuRepository.save(menu);
    }

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

}
