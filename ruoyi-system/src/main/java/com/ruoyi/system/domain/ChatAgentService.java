package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 在线客服服务记录对象 chat_agent_service
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
public class ChatAgentService extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private String id;

    /** 创建人用户名 */
    @Excel(name = "创建人用户名")
    private String userName;

    /** 坐席ID */
    @Excel(name = "坐席ID")
    private String agentNo;

    /** 用户ID */
    @Excel(name = "用户ID")
    private String userId;

    /** 渠道 */
    @Excel(name = "渠道")
    private String channel;

    /** 登录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "登录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date loginDate;

    /** 租户ID */
    @Excel(name = "租户ID")
    private String orgi;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickName;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    /** 省份 */
    @Excel(name = "省份")
    private String province;

    /** 国家 */
    @Excel(name = "国家")
    private String country;

    /** 等待时间 */
    @Excel(name = "等待时间")
    private Long waittingTime;

    /** 未回复消息数量 */
    @Excel(name = "未回复消息数量")
    private Long tokeNum;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** SNSID */
    @Excel(name = "SNSID")
    private String appId;

    /** 会话ID */
    @Excel(name = "会话ID")
    private String contextId;

    /** 最后一条消息时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后一条消息时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastMessage;

    /** 进入排队时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "进入排队时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date waittingTimeStart;

    /** 坐席最后一条消息时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "坐席最后一条消息时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastGetMessage;

    /** 最后一条消息内容 */
    @Excel(name = "最后一条消息内容")
    private String lastMsg;

    /** 创建人 */
    @Excel(name = "创建人")
    private String creater;

    /** 修改人 */
    @Excel(name = "修改人")
    private String updateUser;

    /** 分配目标用户 */
    @Excel(name = "分配目标用户")
    private String assignedTo;

    /** IP地址 */
    @Excel(name = "IP地址")
    private String ipAddr;

    /** 操作系统名称 */
    @Excel(name = "操作系统名称")
    private String osName;

    /** 浏览器 */
    @Excel(name = "浏览器")
    private String browser;

    /** 会话时长 */
    @Excel(name = "会话时长")
    private Long sessionTimes;

    /** 服务时长 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "服务时长", width = 30, dateFormat = "yyyy-MM-dd")
    private Date serviceTime;

    /** 区域 */
    @Excel(name = "区域")
    private String region;

    /** 坐席用户名 */
    @Excel(name = "坐席用户名")
    private String agentUserName;

    /** 消息数量 */
    @Excel(name = "消息数量")
    private Long times;

    /** 数据ID */
    @Excel(name = "数据ID")
    private String dataId;

    /** 联系人ID */
    @Excel(name = "联系人ID")
    private String contactsId;

    /** 消息到达时间 */
    @Excel(name = "消息到达时间")
    private String createDate;

    /** 是否转接 */
    @Excel(name = "是否转接")
    private Long trans;

    /** 转接时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "转接时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date transTime;

    /** 转接备注 */
    @Excel(name = "转接备注")
    private String transMemo;

    /** 坐席评级回复间隔 */
    @Excel(name = "坐席评级回复间隔")
    private Long agentReplyInterval;

    /** 坐席评级回复时间 */
    @Excel(name = "坐席评级回复时间")
    private Long agentReplyTime;

    /** 访客平均回复间隔 */
    @Excel(name = "访客平均回复间隔")
    private Long avgReplyInterval;

    /** 访客回复总时长 */
    @Excel(name = "访客回复总时长")
    private Long avgReplyTime;

    /** 坐席回复消息数量 */
    @Excel(name = "坐席回复消息数量")
    private Long agentReplys;

    /** 访客发送消息数量 */
    @Excel(name = "访客发送消息数量")
    private Long userAsks;

    /** 访客ID */
    @Excel(name = "访客ID")
    private String agentUserId;

    /** 会话ID */
    @Excel(name = "会话ID")
    private String sessionId;

    /** 是否留言 */
    @Excel(name = "是否留言")
    private Long leaveMsg;

    /** 坐席超时时长 */
    @Excel(name = "坐席超时时长")
    private Long agentTimeout;

    /** 坐席超时次数 */
    @Excel(name = "坐席超时次数")
    private Long agentTimeoutTimes;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long serviceTimeout;

    /** 服务超时 */
    @Excel(name = "服务超时")
    private Long agentServiceTimeout;

    /** 留言处理状态 */
    @Excel(name = "留言处理状态")
    private String leaveMsgStatus;

    /** 坐席 */
    @Excel(name = "坐席")
    private String agent;

    /** 技能组 */
    @Excel(name = "技能组")
    private String skill;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setAgentNo(String agentNo) 
    {
        this.agentNo = agentNo;
    }

    public String getAgentNo() 
    {
        return agentNo;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setChannel(String channel) 
    {
        this.channel = channel;
    }

    public String getChannel() 
    {
        return channel;
    }
    public void setLoginDate(Date loginDate) 
    {
        this.loginDate = loginDate;
    }

    public Date getLoginDate() 
    {
        return loginDate;
    }
    public void setOrgi(String orgi) 
    {
        this.orgi = orgi;
    }

    public String getOrgi() 
    {
        return orgi;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setNickName(String nickName) 
    {
        this.nickName = nickName;
    }

    public String getNickName() 
    {
        return nickName;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setCountry(String country) 
    {
        this.country = country;
    }

    public String getCountry() 
    {
        return country;
    }
    public void setWaittingTime(Long waittingTime) 
    {
        this.waittingTime = waittingTime;
    }

    public Long getWaittingTime() 
    {
        return waittingTime;
    }
    public void setTokeNum(Long tokeNum) 
    {
        this.tokeNum = tokeNum;
    }

    public Long getTokeNum() 
    {
        return tokeNum;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setAppId(String appId) 
    {
        this.appId = appId;
    }

    public String getAppId() 
    {
        return appId;
    }
    public void setContextId(String contextId) 
    {
        this.contextId = contextId;
    }

    public String getContextId() 
    {
        return contextId;
    }
    public void setLastMessage(Date lastMessage) 
    {
        this.lastMessage = lastMessage;
    }

    public Date getLastMessage() 
    {
        return lastMessage;
    }
    public void setWaittingTimeStart(Date waittingTimeStart) 
    {
        this.waittingTimeStart = waittingTimeStart;
    }

    public Date getWaittingTimeStart() 
    {
        return waittingTimeStart;
    }
    public void setLastGetMessage(Date lastGetMessage) 
    {
        this.lastGetMessage = lastGetMessage;
    }

    public Date getLastGetMessage() 
    {
        return lastGetMessage;
    }
    public void setLastMsg(String lastMsg) 
    {
        this.lastMsg = lastMsg;
    }

    public String getLastMsg() 
    {
        return lastMsg;
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
    public void setAssignedTo(String assignedTo) 
    {
        this.assignedTo = assignedTo;
    }

    public String getAssignedTo() 
    {
        return assignedTo;
    }
    public void setIpAddr(String ipAddr) 
    {
        this.ipAddr = ipAddr;
    }

    public String getIpAddr() 
    {
        return ipAddr;
    }
    public void setOsName(String osName) 
    {
        this.osName = osName;
    }

    public String getOsName() 
    {
        return osName;
    }
    public void setBrowser(String browser) 
    {
        this.browser = browser;
    }

    public String getBrowser() 
    {
        return browser;
    }
    public void setSessionTimes(Long sessionTimes) 
    {
        this.sessionTimes = sessionTimes;
    }

    public Long getSessionTimes() 
    {
        return sessionTimes;
    }
    public void setServiceTime(Date serviceTime) 
    {
        this.serviceTime = serviceTime;
    }

    public Date getServiceTime() 
    {
        return serviceTime;
    }
    public void setRegion(String region) 
    {
        this.region = region;
    }

    public String getRegion() 
    {
        return region;
    }
    public void setAgentUserName(String agentUserName) 
    {
        this.agentUserName = agentUserName;
    }

    public String getAgentUserName() 
    {
        return agentUserName;
    }
    public void setTimes(Long times) 
    {
        this.times = times;
    }

    public Long getTimes() 
    {
        return times;
    }
    public void setDataId(String dataId) 
    {
        this.dataId = dataId;
    }

    public String getDataId() 
    {
        return dataId;
    }
    public void setContactsId(String contactsId) 
    {
        this.contactsId = contactsId;
    }

    public String getContactsId() 
    {
        return contactsId;
    }
    public void setCreateDate(String createDate) 
    {
        this.createDate = createDate;
    }

    public String getCreateDate() 
    {
        return createDate;
    }
    public void setTrans(Long trans) 
    {
        this.trans = trans;
    }

    public Long getTrans() 
    {
        return trans;
    }
    public void setTransTime(Date transTime) 
    {
        this.transTime = transTime;
    }

    public Date getTransTime() 
    {
        return transTime;
    }
    public void setTransMemo(String transMemo) 
    {
        this.transMemo = transMemo;
    }

    public String getTransMemo() 
    {
        return transMemo;
    }
    public void setAgentReplyInterval(Long agentReplyInterval) 
    {
        this.agentReplyInterval = agentReplyInterval;
    }

    public Long getAgentReplyInterval() 
    {
        return agentReplyInterval;
    }
    public void setAgentReplyTime(Long agentReplyTime) 
    {
        this.agentReplyTime = agentReplyTime;
    }

    public Long getAgentReplyTime() 
    {
        return agentReplyTime;
    }
    public void setAvgReplyInterval(Long avgReplyInterval) 
    {
        this.avgReplyInterval = avgReplyInterval;
    }

    public Long getAvgReplyInterval() 
    {
        return avgReplyInterval;
    }
    public void setAvgReplyTime(Long avgReplyTime) 
    {
        this.avgReplyTime = avgReplyTime;
    }

    public Long getAvgReplyTime() 
    {
        return avgReplyTime;
    }
    public void setAgentReplys(Long agentReplys) 
    {
        this.agentReplys = agentReplys;
    }

    public Long getAgentReplys() 
    {
        return agentReplys;
    }
    public void setUserAsks(Long userAsks) 
    {
        this.userAsks = userAsks;
    }

    public Long getUserAsks() 
    {
        return userAsks;
    }
    public void setAgentUserId(String agentUserId) 
    {
        this.agentUserId = agentUserId;
    }

    public String getAgentUserId() 
    {
        return agentUserId;
    }
    public void setSessionId(String sessionId) 
    {
        this.sessionId = sessionId;
    }

    public String getSessionId() 
    {
        return sessionId;
    }
    public void setLeaveMsg(Long leaveMsg) 
    {
        this.leaveMsg = leaveMsg;
    }

    public Long getLeaveMsg() 
    {
        return leaveMsg;
    }
    public void setAgentTimeout(Long agentTimeout) 
    {
        this.agentTimeout = agentTimeout;
    }

    public Long getAgentTimeout() 
    {
        return agentTimeout;
    }
    public void setAgentTimeoutTimes(Long agentTimeoutTimes) 
    {
        this.agentTimeoutTimes = agentTimeoutTimes;
    }

    public Long getAgentTimeoutTimes() 
    {
        return agentTimeoutTimes;
    }
    public void setServiceTimeout(Long serviceTimeout) 
    {
        this.serviceTimeout = serviceTimeout;
    }

    public Long getServiceTimeout() 
    {
        return serviceTimeout;
    }
    public void setAgentServiceTimeout(Long agentServiceTimeout) 
    {
        this.agentServiceTimeout = agentServiceTimeout;
    }

    public Long getAgentServiceTimeout() 
    {
        return agentServiceTimeout;
    }
    public void setLeaveMsgStatus(String leaveMsgStatus) 
    {
        this.leaveMsgStatus = leaveMsgStatus;
    }

    public String getLeaveMsgStatus() 
    {
        return leaveMsgStatus;
    }
    public void setAgent(String agent) 
    {
        this.agent = agent;
    }

    public String getAgent() 
    {
        return agent;
    }
    public void setSkill(String skill) 
    {
        this.skill = skill;
    }

    public String getSkill() 
    {
        return skill;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userName", getUserName())
            .append("agentNo", getAgentNo())
            .append("userId", getUserId())
            .append("channel", getChannel())
            .append("loginDate", getLoginDate())
            .append("orgi", getOrgi())
            .append("endTime", getEndTime())
            .append("nickName", getNickName())
            .append("city", getCity())
            .append("province", getProvince())
            .append("country", getCountry())
            .append("waittingTime", getWaittingTime())
            .append("tokeNum", getTokeNum())
            .append("status", getStatus())
            .append("appId", getAppId())
            .append("contextId", getContextId())
            .append("lastMessage", getLastMessage())
            .append("waittingTimeStart", getWaittingTimeStart())
            .append("lastGetMessage", getLastGetMessage())
            .append("lastMsg", getLastMsg())
            .append("createTime", getCreateTime())
            .append("creater", getCreater())
            .append("updateTime", getUpdateTime())
            .append("updateUser", getUpdateUser())
            .append("assignedTo", getAssignedTo())
            .append("ipAddr", getIpAddr())
            .append("osName", getOsName())
            .append("browser", getBrowser())
            .append("sessionTimes", getSessionTimes())
            .append("serviceTime", getServiceTime())
            .append("region", getRegion())
            .append("agentUserName", getAgentUserName())
            .append("times", getTimes())
            .append("dataId", getDataId())
            .append("contactsId", getContactsId())
            .append("createDate", getCreateDate())
            .append("trans", getTrans())
            .append("transTime", getTransTime())
            .append("transMemo", getTransMemo())
            .append("agentReplyInterval", getAgentReplyInterval())
            .append("agentReplyTime", getAgentReplyTime())
            .append("avgReplyInterval", getAvgReplyInterval())
            .append("avgReplyTime", getAvgReplyTime())
            .append("agentReplys", getAgentReplys())
            .append("userAsks", getUserAsks())
            .append("agentUserId", getAgentUserId())
            .append("sessionId", getSessionId())
            .append("leaveMsg", getLeaveMsg())
            .append("agentTimeout", getAgentTimeout())
            .append("agentTimeoutTimes", getAgentTimeoutTimes())
            .append("serviceTimeout", getServiceTimeout())
            .append("agentServiceTimeout", getAgentServiceTimeout())
            .append("leaveMsgStatus", getLeaveMsgStatus())
            .append("agent", getAgent())
            .append("skill", getSkill())
            .toString();
    }
}
