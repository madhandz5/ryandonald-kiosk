package ryan.donald.module.cart;

import lombok.*;
import ryan.donald.module.account.Account;
import ryan.donald.module.menu.Menu;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_CART")
@SequenceGenerator(name = "TB_CART_SEQ", sequenceName = "TB_CART_SEQ", allocationSize = 30)
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_CART_SEQ")
    @Column(name = "cart_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany
    private List<Menu> menuList = new ArrayList<>();

    private LocalDateTime createdAt;

    private boolean isCheckedOut;

    private LocalDateTime checkedOutAt;


}
