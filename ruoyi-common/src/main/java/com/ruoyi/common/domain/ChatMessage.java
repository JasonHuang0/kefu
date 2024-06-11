package com.ruoyi.common.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 坐席对话对象 chat_message
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
public class ChatMessage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 类型 */
    @Excel(name = "类型")
    private String type;

    /** 主键ID */
    private String id;

    /** 对话方向(呼入呼出) */
    @Excel(name = "对话方向(呼入呼出)")
    private String callType;

    /** 会话ID */
    @Excel(name = "会话ID")
    private String contextId;

    /** 会话ID */
    @Excel(name = "会话ID")
    private String uSession;

    /** 目标用户 */
    @Excel(name = "目标用户")
    private String toUser;

    /** 渠道 */
    @Excel(name = "渠道")
    private String channel;

    /** SNSID */
    @Excel(name = "SNSID")
    private String appId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userId;

    /** 消息内容 */
    @Excel(name = "消息内容")
    private String message;

    /** 消息类型 */
    @Excel(name = "消息类型")
    private String msgType;

    /** 租户ID */
    @Excel(name = "租户ID")
    private String orgi;

    /** 创建人 */
    @Excel(name = "创建人")
    private String creater;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 坐席服务ID */
    @Excel(name = "坐席服务ID")
    private String agentServiceId;

    /** 会话时长 */
    @Excel(name = "会话时长")
    private String duration;

    /** 文件名 */
    @Excel(name = "文件名")
    private String fileName;

    /** 文件尺寸 */
    @Excel(name = "文件尺寸")
    private Long fileSize;

    /** 最近一次坐席发送消息时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最近一次坐席发送消息时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastAgentMsgTime;

    /** 坐席回复消息时间 */
    @Excel(name = "坐席回复消息时间")
    private Long agentReplyTime;

    /** 访客最近一次发送消息时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "访客最近一次发送消息时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastMsgTime;

    /** 坐席回复消息时间 */
    @Excel(name = "坐席回复消息时间")
    private Long agentReplyInterval;

    /** 会话ID */
    @Excel(name = "会话ID")
    private String sessionId;

    /** 数据状态（已删除/未删除） */
    @Excel(name = "数据状态", readConverterExp = "已=删除/未删除")
    private Long dataStatus;

    /** 发送至用户名称 */
    @Excel(name = "发送至用户名称")
    private String toUserName;

    /** 用户类型(用户/访客) */
    @Excel(name = "用户类型(用户/访客)")
    private Long userType;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String dateString;

    /** 图像通讯信息 */
    @Excel(name = "图像通讯信息")
    private String imagesMsg;

    /** 坐席头像 */
    @Excel(name = "坐席头像")
    private String agentHeadImg;

    /** 已读状态  1 已读 ,  0 未读 */
    @Excel(name = "已读状态  1 已读 ,  0 未读")
    private Long readStatus;

    /** 是否为自动回复语句 */
    @Excel(name = "是否为自动回复语句")
    private Long autoReply;

    /** 发送至坐席名称 */
    @Excel(name = "发送至坐席名称")
    private String sendToAgentName;

    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setCallType(String callType) 
    {
        this.callType = callType;
    }

    public String getCallType() 
    {
        return callType;
    }
    public void setContextId(String contextId) 
    {
        this.contextId = contextId;
    }

    public String getContextId() 
    {
        return contextId;
    }
    public void setuSession(String uSession) 
    {
        this.uSession = uSession;
    }

    public String getuSession() 
    {
        return uSession;
    }
    public void setToUser(String toUser) 
    {
        this.toUser = toUser;
    }

    public String getToUser() 
    {
        return toUser;
    }
    public void setChannel(String channel) 
    {
        this.channel = channel;
    }

    public String getChannel() 
    {
        return channel;
    }
    public void setAppId(String appId) 
    {
        this.appId = appId;
    }

    public String getAppId() 
    {
        return appId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setMessage(String message) 
    {
        this.message = message;
    }

    public String getMessage() 
    {
        return message;
    }
    public void setMsgType(String msgType) 
    {
        this.msgType = msgType;
    }

    public String getMsgType() 
    {
        return msgType;
    }
    public void setOrgi(String orgi) 
    {
        this.orgi = orgi;
    }

    public String getOrgi() 
    {
        return orgi;
    }
    public void setCreater(String creater) 
    {
        this.creater = creater;
    }

    public String getCreater() 
    {
        return creater;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setAgentServiceId(String agentServiceId) 
    {
        this.agentServiceId = agentServiceId;
    }

    public String getAgentServiceId() 
    {
        return agentServiceId;
    }
    public void setDuration(String duration) 
    {
        this.duration = duration;
    }

    public String getDuration() 
    {
        return duration;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setFileSize(Long fileSize) 
    {
        this.fileSize = fileSize;
    }

    public Long getFileSize() 
    {
        return fileSize;
    }
    public void setLastAgentMsgTime(Date lastAgentMsgTime) 
    {
        this.lastAgentMsgTime = lastAgentMsgTime;
    }

    public Date getLastAgentMsgTime() 
    {
        return lastAgentMsgTime;
    }
    public void setAgentReplyTime(Long agentReplyTime) 
    {
        this.agentReplyTime = agentReplyTime;
    }

    public Long getAgentReplyTime() 
    {
        return agentReplyTime;
    }
    public void setLastMsgTime(Date lastMsgTime) 
    {
        this.lastMsgTime = lastMsgTime;
    }

    public Date getLastMsgTime() 
    {
        return lastMsgTime;
    }
    public void setAgentReplyInterval(Long agentReplyInterval) 
    {
        this.agentReplyInterval = agentReplyInterval;
    }

    public Long getAgentReplyInterval() 
    {
        return agentReplyInterval;
    }
    public void setSessionId(String sessionId) 
    {
        this.sessionId = sessionId;
    }

    public String getSessionId() 
    {
        return sessionId;
    }
    public void setDataStatus(Long dataStatus) 
    {
        this.dataStatus = dataStatus;
    }

    public Long getDataStatus() 
    {
        return dataStatus;
    }
    public void setToUserName(String toUserName) 
    {
        this.toUserName = toUserName;
    }

    public String getToUserName() 
    {
        return toUserName;
    }
    public void setUserType(Long userType) 
    {
        this.userType = userType;
    }

    public Long getUserType() 
    {
        return userType;
    }
    public void setDateString(String dateString) 
    {
        this.dateString = dateString;
    }

    public String getDateString() 
    {
        return dateString;
    }
    public void setImagesMsg(String imagesMsg) 
    {
        this.imagesMsg = imagesMsg;
    }

    public String getImagesMsg() 
    {
        return imagesMsg;
    }
    public void setAgentHeadImg(String agentHeadImg) 
    {
        this.agentHeadImg = agentHeadImg;
    }

    public String getAgentHeadImg() 
    {
        return agentHeadImg;
    }
    public void setReadStatus(Long readStatus) 
    {
        this.readStatus = readStatus;
    }

    public Long getReadStatus() 
    {
        return readStatus;
    }
    public void setAutoReply(Long autoReply) 
    {
        this.autoReply = autoReply;
    }

    public Long getAutoReply() 
    {
        return autoReply;
    }
    public void setSendToAgentName(String sendToAgentName) 
    {
        this.sendToAgentName = sendToAgentName;
    }

    public String getSendToAgentName() 
    {
        return sendToAgentName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("type", getType())
            .append("id", getId())
            .append("callType", getCallType())
            .append("contextId", getContextId())
            .append("uSession", getuSession())
            .append("toUser", getToUser())
            .append("channel", getChannel())
            .append("appId", getAppId())
            .append("userId", getUserId())
            .append("message", getMessage())
            .append("msgType", getMsgType())
            .append("orgi", getOrgi())
            .append("createTime", getCreateTime())
            .append("creater", getCreater())
            .append("userName", getUserName())
            .append("agentServiceId", getAgentServiceId())
            .append("duration", getDuration())
            .append("fileName", getFileName())
            .append("fileSize", getFileSize())
            .append("lastAgentMsgTime", getLastAgentMsgTime())
            .append("agentReplyTime", getAgentReplyTime())
            .append("lastMsgTime", getLastMsgTime())
            .append("agentReplyInterval", getAgentReplyInterval())
            .append("sessionId", getSessionId())
            .append("dataStatus", getDataStatus())
            .append("toUserName", getToUserName())
            .append("userType", getUserType())
            .append("dateString", getDateString())
            .append("imagesMsg", getImagesMsg())
            .append("agentHeadImg", getAgentHeadImg())
            .append("readStatus", getReadStatus())
            .append("autoReply", getAutoReply())
            .append("sendToAgentName", getSendToAgentName())
            .toString();
    }
}
