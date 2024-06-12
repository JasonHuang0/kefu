package com.ruoyi.system.basic;

import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.system.redis.Cache;

/**
 * @Auther: jason
 * @Date: 12/6/2024 15:26
 * @Description:
 */
public class MainContext {
    private static Cache cache;
    /**
     * 缓存管理
     *
     * @return
     */
    public final static Cache getCache() {
        if (cache == null) {
            cache = SpringUtils.getBean(Cache.class);
        }
        return cache;
    }
}
