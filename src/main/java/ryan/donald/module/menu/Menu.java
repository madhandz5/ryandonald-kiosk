package ryan.donald.module.menu;

import lombok.*;
import ryan.donald.module.account.Account;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_MENU")
@SequenceGenerator(name = "TB_MENU_SEQ", sequenceName = "TB_MENU_SEQ", allocationSize = 30)
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_MENU_SEQ")
    @Column(name = "menu_id")
    private Long id;

    private String menuName;
    private int price;
    private String menuImage;
    private LocalDateTime registeredAt;

    @Enumerated(EnumType.STRING)
    private MenuCategory menuCategory;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account registeredBy;
}
