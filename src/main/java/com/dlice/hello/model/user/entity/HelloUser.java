package com.dlice.hello.model.user.entity;

import com.dlice.hello.common.model.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity(name = "users")
public class HelloUser extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * User name.
     */
    @Column(name = "username", length = 50, nullable = false)
    private String username;

    /**
     * User nick name,used to display on page.
     */
    @Column(name = "nickname", length = 50, nullable = false)
    private String nickname;

    /**
     * Password.
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * User email.
     */
    @Column(name = "email", length = 50)
    private String email;

    /**
     * User phone number.
     */
    @Column(name = "phone", length = 15)
    private String phone;

    /**
     * User active mark.
     */
    @Column(name = "is_active")
    private Boolean isActive;

    @Override
    public void prePersist() {
        super.prePersist();

        if (email == null) {
            email = "";
        }

        if (phone == null) {
            phone = "";
        }

        if (isActive == null) {
            isActive = true;
        }
    }
}
