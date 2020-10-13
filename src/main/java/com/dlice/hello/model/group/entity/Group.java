package com.dlice.hello.model.group.entity;

import com.dlice.hello.common.model.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Desc
 * @Auth dlice
 * @Date 2020/10/13 21:52
 **/
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity(name = "group")
public class Group extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "group_name", length = 50, nullable = false)
    private String groupName;

    @Column(name = "group_number", length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer groupNumber;

}
