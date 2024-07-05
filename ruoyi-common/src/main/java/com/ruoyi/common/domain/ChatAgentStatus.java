package com.ruoyi.common.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 在线客服坐席状态对象 chat_agent_status
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
public class ChatAgentStatus extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private String id;



    /** 登录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "登录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date loginDate;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 最大接入用户数 */
    @Excel(name = "最大接入用户数")
    private Long maxUsers;

    /** 接入用户数 */
    @Excel(name = "接入用户数")
    private Long users;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 名称 */
    @Excel(name = "名称")
    private String nickName;

    /** 用户ID */
    @Excel(name = "用户ID")
    private String userId;

    /** 创建人 */
    @Excel(name = "创建人")
    private String creater;

    /** 修改人 */
    @Excel(name = "修改人")
    private String updateUser;

    /** 示忙 */
    @Excel(name = "示忙")
    private Long busy;

    /** 头像url */
    @Excel(name = "头像url")
    private String headImg;

    /** 临时示忙 */
    @Excel(name = "临时示忙")
    private Long tempBusy;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }

    public void setLoginDate(Date loginDate) 
    {
        this.loginDate = loginDate;
    }

    public Date getLoginDate() 
    {
        return loginDate;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setMaxUsers(Long maxUsers) 
    {
        this.maxUsers = maxUsers;
    }

    public Long getMaxUsers() 
    {
        return maxUsers;
    }
    public void setUsers(Long users) 
    {
        this.users = users;
    }

    public Long getUsers() 
    {
        return users;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setNickName(String nickName) 
    {
        this.nickName = nickName;
    }

    public String getNickName() 
    {
        return nickName;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setCreater(String creater) 
    {
        this.creater = creater;
    }

    public String getCreater() 
    {
        return creater;
    }
    public void setUpdateUser(String updateUser) 
    {
        this.updateUser = updateUser;
    }

    public String getUpdateUser() 
    {
        return updateUser;
    }
    public void setBusy(Long busy) 
    {
        this.busy = busy;
    }

    public Long getBusy() 
    {
        return busy;
    }
    public void setHeadImg(String headImg) 
    {
        this.headImg = headImg;
    }

    public String getHeadImg() 
    {
        return headImg;
    }
    public void setTempBusy(Long tempBusy) 
    {
        this.tempBusy = tempBusy;
    }

    public Long getTempBusy() 
    {
        return tempBusy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("loginDate", getLoginDate())
            .append("status", getStatus())
            .append("maxUsers", getMaxUsers())
            .append("users", getUsers())
            .append("userName", getUserName())
            .append("nickName", getNickName())
            .append("userId", getUserId())
            .append("createTime", getCreateTime())
            .append("creater", getCreater())
            .append("updateTime", getUpdateTime())
            .append("updateUser", getUpdateUser())
            .append("busy", getBusy())
            .append("headImg", getHeadImg())
            .append("tempBusy", getTempBusy())
            .toString();
    }
}
