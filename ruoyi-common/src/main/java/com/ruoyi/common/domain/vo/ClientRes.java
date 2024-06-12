package com.ruoyi.common.domain.vo;

import com.ruoyi.common.core.domain.entity.SysUser;
import lombok.Data;
import sun.management.resources.agent;

@Data
public class ClientRes {

    private String appId;

//    private String appKey;

    private String nickName;

    private String realName;

    private String userId;

    private Integer clientType;

    private String mobile;

    private String remark;

    private String jpushToken;

    private String jpushPackageName;

//    private String organId;

    private String message;

    private String msgType;

    /**
     * 坐席账号
     */
    private String agentAccount;

    /**
     * 发送人名称
     */
    private String sendUserName;

    /**
     * 所选坐席
     */
    private SysUser agent;

}
