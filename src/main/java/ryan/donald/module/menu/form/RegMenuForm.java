package ryan.donald.module.menu.form;

import lombok.Data;
import ryan.donald.module.menu.MenuCategory;

@Data
public class RegMenuForm {

    private String menuName;
    private int price;
    private String menuImage;
    private MenuCategory menuCategory;
}
