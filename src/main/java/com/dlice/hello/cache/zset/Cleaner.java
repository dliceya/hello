package com.dlice.hello.cache.zset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author mubai
 * @apiNote:
 * @date 2021/5/21 09:54
 **/
public class Cleaner {

    @Autowired
    private ZSetCacheUtils zSetUtils;

    @Scheduled(cron = "0 0 4 * * ?")
    //@Scheduled(fixedDelay = 120 * 1000)
    public void execute() {



    }

}
