package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 访客联系人关联对象 chat_agentuser_contacts
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
public class ChatAgentuserContacts extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private String id;

    /** 租户ID */
    @Excel(name = "租户ID")
    private String orgi;

    /** SNSID */
    @Excel(name = "SNSID")
    private String appid;

    /** 渠道 */
    @Excel(name = "渠道")
    private String channel;

    /** 用户ID */
    @Excel(name = "用户ID")
    private String userId;

    /** 联系人ID */
    @Excel(name = "联系人ID")
    private String contactsId;

    /** 创建人用户名 */
    @Excel(name = "创建人用户名")
    private String userName;

    /** 创建人ID */
    @Excel(name = "创建人ID")
    private String creater;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setOrgi(String orgi) 
    {
        this.orgi = orgi;
    }

    public String getOrgi() 
    {
        return orgi;
    }
    public void setAppid(String appid) 
    {
        this.appid = appid;
    }

    public String getAppid() 
    {
        return appid;
    }
    public void setChannel(String channel) 
    {
        this.channel = channel;
    }

    public String getChannel() 
    {
        return channel;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setContactsId(String contactsId) 
    {
        this.contactsId = contactsId;
    }

    public String getContactsId() 
    {
        return contactsId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setCreater(String creater) 
    {
        this.creater = creater;
    }

    public String getCreater() 
    {
        return creater;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orgi", getOrgi())
            .append("appid", getAppid())
            .append("channel", getChannel())
            .append("userId", getUserId())
            .append("contactsId", getContactsId())
            .append("userName", getUserName())
            .append("creater", getCreater())
            .append("createTime", getCreateTime())
            .toString();
    }
}
