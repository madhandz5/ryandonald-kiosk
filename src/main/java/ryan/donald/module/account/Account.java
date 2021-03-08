package ryan.donald.module.account;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Builder
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_ACCOUNT")
@SequenceGenerator(name = "TB_ACCOUNT_SEQ", sequenceName = "TB_ACCOUNT_SEQ", allocationSize = 30)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_ACCOUNT_SEQ")
    @Column(name = "account_id")
    private Long id;

    @Column(unique = true)
    private String email;
    private String password;
    private String username;

    @Column(unique = true)
    private String nickname;

    @Column(unique = true)
    private String phoneNumber;

    private boolean emailVerified;
    private String emailCheckToken;
    private LocalDateTime emailCheckTokenGeneratedAt;
    private LocalDateTime joinedAt;


    public void generateEmailCheckToken() {
        this.emailCheckToken = UUID.randomUUID().toString();
        this.emailCheckTokenGeneratedAt = LocalDateTime.now();
    }

    public void completeSignUp() {
        this.emailVerified = true;
        this.joinedAt = LocalDateTime.now();
    }

    public boolean isValidToken(String token) {
        return this.emailCheckToken.equals(token);
    }

    public boolean canSendConfirmEmail() {
        return this.emailCheckTokenGeneratedAt.isBefore(LocalDateTime.now().minusMinutes(30));
    }


}
