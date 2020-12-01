package com.dlice.hello.model.role.entity;

import com.dlice.hello.common.model.entity.BaseEntity;
import com.dlice.hello.model.user.entity.HelloUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "hello_role")
public class Role extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private HelloUser user;

    @Column(name = "role_name", length = 20)
    private String roleName;

    @Column(name = "role_code", length = 20)
    private String roleCode;

    @Override
    public void prePersist() {
        super.prePersist();

    }
}
