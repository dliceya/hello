package com.dlice.hello.biz.member;

import com.dlice.hello.domain.member.HelloUser;

import java.util.List;

/**
 * @author mubai
 * @apiNote:
 * @date 2021/5/21 14:14
 **/
public interface HelloUserBiz {

    List<HelloUser> listUser();

    HelloUser getByUserName(String userName);

}
