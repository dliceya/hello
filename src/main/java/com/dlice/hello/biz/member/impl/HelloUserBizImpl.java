package com.dlice.hello.biz.member.impl;

import com.dlice.hello.biz.member.HelloUserBiz;
import com.dlice.hello.dao.member.HelloUserDaoService;
import com.dlice.hello.domain.member.HelloUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mubai
 * @apiNote:
 * @date 2021/5/21 14:17
 **/
@Service
public class HelloUserBizImpl implements HelloUserBiz {

    @Resource
    private HelloUserDaoService helloUserDaoService;

    @Override
    public List<HelloUser> listUser() {

        return helloUserDaoService.list();
    }

    @Override
    public HelloUser getByUserName(String userName) {

        return helloUserDaoService.lambdaQuery()
                .eq(HelloUser::getUsername, userName)
                .one();
    }
}
