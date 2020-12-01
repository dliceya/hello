package com.dlice.hello.model.permission.entity;

import com.dlice.hello.common.model.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Desc
 * @Auth dlice
 * @Date 2020/10/18 13:44
 **/
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity(name = "hello_permission")
public class Permission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id")
    private Integer Id;

    /**
     * Permission code, used to check authorization.
     */
    @Column(name = "permission_code", length = 50, unique = true)
    private String permissionCode;

    /**
     * Permission name, used to display on page.
     */
    @Column(name = "permission_name", length = 50)
    private String permissionName;

    /**
     * Parent permission ID, used to implement multi-level authority management.
     */
    @Column(name = "parent_id")
    private Integer parentId;

}
