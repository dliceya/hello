package com.dlice.hello.dao.member.impl;

import com.dlice.hello.domain.member.HelloUser;
import com.dlice.hello.mapper.member.HelloUserMapper;
import com.dlice.hello.dao.member.HelloUserDaoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户基础表 服务实现类
 * </p>
 *
 * @author hello
 * @since 2021-05-21
 */
@Service
public class HelloUserDaoServiceImpl extends ServiceImpl<HelloUserMapper, HelloUser> implements HelloUserDaoService {

}
