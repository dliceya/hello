package com.dlice.hello.repository.base;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Base repository interface.
 *
 * @Date: 2020/9/3 22:05
 * @Author: dlice
 */
@NoRepositoryBean
public interface BaseRepository<DoMain, ID> extends PagingAndSortingRepository<DoMain, ID> {

}
