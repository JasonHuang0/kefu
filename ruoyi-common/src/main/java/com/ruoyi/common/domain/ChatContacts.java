package com.ruoyi.common.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 联系人信息对象 chat_contacts
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
public class ChatContacts extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 联系人ID */
    private String id;

    /** 联系人昵称 */
    @Excel(name = "联系人昵称")
    private String nickName;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String accountNo;

    /** 数据状态 */
    @Excel(name = "数据状态")
    private Boolean dataStatus;

    /** 租户标识 */
    @Excel(name = "租户标识")
    private String orgi;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 部门 */
    @Excel(name = "部门")
    private String organ;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String userId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long msgUnreadNum;

    /** 极光推送token */
    @Excel(name = "极光推送token")
    private String jpushToken;

    /** token */
    @Excel(name = "token")
    private String token;

    /** 客户类型 */
    @Excel(name = "客户类型")
    private Integer clientType;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String jpushPackageName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String clientId;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setNickName(String nickName) 
    {
        this.nickName = nickName;
    }

    public String getNickName() 
    {
        return nickName;
    }
    public void setAccountNo(String accountNo) 
    {
        this.accountNo = accountNo;
    }

    public String getAccountNo() 
    {
        return accountNo;
    }
    public void setDataStatus(Boolean dataStatus)
    {
        this.dataStatus = dataStatus;
    }

    public Boolean getDataStatus()
    {
        return dataStatus;
    }
    public void setOrgi(String orgi) 
    {
        this.orgi = orgi;
    }

    public String getOrgi() 
    {
        return orgi;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setOrgan(String organ) 
    {
        this.organ = organ;
    }

    public String getOrgan() 
    {
        return organ;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setMsgUnreadNum(Long msgUnreadNum) 
    {
        this.msgUnreadNum = msgUnreadNum;
    }

    public Long getMsgUnreadNum() 
    {
        return msgUnreadNum;
    }
    public void setJpushToken(String jpushToken) 
    {
        this.jpushToken = jpushToken;
    }

    public String getJpushToken() 
    {
        return jpushToken;
    }
    public void setToken(String token) 
    {
        this.token = token;
    }

    public String getToken() 
    {
        return token;
    }
    public void setClientType(Integer clientType)
    {
        this.clientType = clientType;
    }

    public Integer getClientType()
    {
        return clientType;
    }
    public void setJpushPackageName(String jpushPackageName) 
    {
        this.jpushPackageName = jpushPackageName;
    }

    public String getJpushPackageName() 
    {
        return jpushPackageName;
    }
    public void setClientId(String clientId) 
    {
        this.clientId = clientId;
    }

    public String getClientId() 
    {
        return clientId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("nickName", getNickName())
            .append("accountNo", getAccountNo())
            .append("dataStatus", getDataStatus())
            .append("orgi", getOrgi())
            .append("createTime", getCreateTime())
            .append("name", getName())
            .append("organ", getOrgan())
            .append("userId", getUserId())
            .append("msgUnreadNum", getMsgUnreadNum())
            .append("jpushToken", getJpushToken())
            .append("token", getToken())
            .append("clientType", getClientType())
            .append("jpushPackageName", getJpushPackageName())
            .append("clientId", getClientId())
            .toString();
    }
}
