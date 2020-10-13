package com.dlice.hello.repository;

import com.dlice.hello.model.user.entity.HelloUser;
import com.dlice.hello.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

/**
 * @Date: 2020/9/3 21:55
 * @Author: dlice
 */
@Repository
public interface UserRepository extends BaseRepository<HelloUser, Integer> {

    @Query(value = "select * from users  where username = ?1 and password = ?2", nativeQuery = true)
    HelloUser getUser(String username, String password);

    HelloUser getByUsername(@NonNull String username);

}
