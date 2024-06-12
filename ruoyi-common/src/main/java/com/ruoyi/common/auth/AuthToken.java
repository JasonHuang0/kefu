/*
 * Copyright (C) 2019-2022 Chatopera Inc, <https://www.chatopera.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ruoyi.common.auth;

import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.core.redis.RedisKey;
import com.ruoyi.common.domain.ChatContacts;
import com.ruoyi.common.utils.SerializeUtil;
import com.ruoyi.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 认证和授权的API Token管理
 */
@Component
public class AuthToken {

    private  final  Logger logger = LoggerFactory.getLogger(AuthToken.class);

    @Value("${server.session-timeout}")
    private int timeout;

    @Autowired
    private RedisCache redisCache;

    private ValueOperations<String, String> redisValOps;

//    @PostConstruct
//    private void init() {
//        redisValOps = redisTemplate.opsForValue();
//    }

    /**
     * 设置一个KEY的过期时间
     *
     * @param key
     * @param seconds
     */
    private void expire(final String key, final long seconds) {
        redisCache.expire(key, seconds, TimeUnit.SECONDS);
    }


//    private String authKey(final String auth) {
//        return redisCache.getLoginUserKey(auth);
//    }

    /**********************************
     *  LOGIN USER API TOKEN 相关
     *  认证，授权，登录用户
     **********************************/

    /**
     * @param auth      授权的KEY
     * @param loginUser 已经登录的用户
     */
//    public void putUserByAuth(final String auth, final User loginUser) {
//        if (StringUtils.isNotBlank(auth) && loginUser != null) {
//            String serialized = SerializeUtil.serialize(loginUser);
//            final String key = authKey(auth);
//            redisValOps.set(key, serialized);
//            expire(key, timeout);
//        } else {
//            logger.warn("[putLoginUserByAuth] error Invalid params.");
//        }
//    }


    /**
     * 删除客户端旧token
     * @param auth      授权的KEY
     */
    public void deleteClientUserAuth(final String auth) {
        if (StringUtils.isNotBlank(auth)) {
            redisCache.deleteObject(RedisKey.getClientUserKey(auth));
        } else {
            logger.warn("[deleteClientUserAuth] error Invalid params.");
        }
    }

    /**
     * @param auth  授权的KEY
     * @param contacts 已经登录的用户
     */
    public void putClienUsertByAuth(final String auth, final ChatContacts contacts) {
        if (StringUtils.isNotBlank(auth) && contacts != null) {
            String serialized = SerializeUtil.serialize(contacts);
            final String key = RedisKey.getClientUserKey(auth);
            redisValOps.set(key, serialized);
            //TODO 暂时为确定token过期限制,后续补充
//            expire(key, timeout);
        } else {
            logger.warn("[putLoginUserByAuth] error Invalid params.");
        }
    }



    /**
     * 判断一个ClientAuth是否是有效的
     *
     * @param auth
     * @return
     */
    public boolean existClientUserByAuth(final String auth) {
        return redisCache.hasKey(RedisKey.getClientUserKey(auth));
    }


    /**
     * 判断一个Auth是否是有效的
     *
     * @param auth
     * @return
     */
//    public boolean existUserByAuth(final String auth) {
//        return redisCache.hasKey(authKey(auth));
//    }


    /**
     * 根据租户ID和认证Auth获得一个登录用户
     *
     * @param auth
     * @return
     */
//    public User findUserByAuth(final String auth) {
//        String serialized = redisValOps.get(authKey(auth));
//        if (StringUtils.isNotBlank(serialized)) {
//            return (User) SerializeUtil.deserialize(serialized);
//        }
//        return null;
//    }

    /**
     * 根据租户ID和认证Auth获得一个登录用户
     * @param auth
     * @return
     */
    public ChatContacts findClientUserByAuth(final String auth) {
        String serialized = redisCache.getCacheObject(RedisKey.getClientUserKey(auth));
        if (StringUtils.isNotBlank(serialized)) {
            return (ChatContacts) SerializeUtil.deserialize(serialized);
        }
        return null;
    }

    /**
     * 登出已经登录的系统用户
     *
     * @param auth
     */
//    public void deleteUserByAuth(final String auth) {
//        redisCache.deleteObject(authKey(auth));
//    }
}
