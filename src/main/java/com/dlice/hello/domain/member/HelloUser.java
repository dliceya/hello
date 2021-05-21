package com.dlice.hello.domain.member;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户基础表
 * </p>
 *
 * @author hello
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("hello_user")
public class HelloUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户状态
     */
    private String status;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 用户名
     */
    private String username;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Integer isDeleted;

    private LocalDateTime sysCreateTime;

    private LocalDateTime sysUpdateTime;


}
