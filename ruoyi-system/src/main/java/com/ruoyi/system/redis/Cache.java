package com.ruoyi.system.redis;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.redis.RedisCommand;
import com.ruoyi.common.core.redis.RedisKey;
import com.ruoyi.common.utils.SerializeUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: jason
 * @Date: 12/6/2024 14:38
 * @Description:
 */
@Component
public class Cache {
    @Autowired
    private ISysUserService userService;

    @Autowired
    private RedisCommand redisCommand;

    public SysUser findUserByUserName(String userName){
        String serialized = redisCommand.getHashKV(RedisKey.getUserNameKey(Constants.SYSTEM_NAME), userName);
        if (StringUtils.isBlank(serialized)) {
            SysUser user = userService.selectUserByUserName(userName);
            if(user == null){
                return null;
            }
            this.putUserByUserName(user.getUserName(),user);
            return user;
        }

        return(SysUser) SerializeUtil.deserialize(serialized) ;
        }

        public void putUserByUserName(String userName,SysUser user){
            SysUser cacheUser = new SysUser();
            BeanUtils.copyProperties(user,cacheUser);
            cacheUser.setPassword(null);
            redisCommand.setHashKV(RedisKey.getUserNameKey(Constants.SYSTEM_NAME),userName,SerializeUtil.serialize(cacheUser));
        }

}

