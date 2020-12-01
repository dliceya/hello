package com.dlice.hello.model.user.entity;

import com.dlice.hello.common.model.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "users")
public class HelloUser extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    /**
     * User mobile phone.
     */
    @Column(name = "phone", length = 15, unique = true)
    private String phone;

    /**
     * User name.
     */
    @Column(name = "username", length = 50, nullable = false, unique = true)
    private String username;

    /**
     * User nick name, used to display on page.
     */
    @Column(name = "nickname", length = 50, nullable = false)
    private String nickname;

    /**
     * Password.
     */
    @Column(name = "password", nullable = false)
    @JsonIgnore
    private String password;

    /**
     * User birthday.
     */
    @Column(name = "birthday")

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthday;

    /**
     * User email.
     */
    @Column(name = "email", length = 50)
    private String email;

    /**
     * User qq number, used to get default Head portrait.
     */
    @Column(name = "qq", length = 15)
    private String qq;

    /**
     * Head portrait url.
     */
    @Column(name = "head_portrait", length = 100)
    private String headPortrait;

    @Override
    public void prePersist() {
        super.prePersist();

        if (email == null) {
            email = "";
        }

        if (phone == null) {
            phone = "";
        }

        if (qq == null) {
            qq = "1767953212";
        }

        if (headPortrait == null) {
            headPortrait = "";
        }
    }
}
