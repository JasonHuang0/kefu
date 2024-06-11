package com.ruoyi.common.service.impl;

import java.util.List;

import com.ruoyi.common.domain.ChatAgentStatus;
import com.ruoyi.common.mapper.ChatAgentStatusMapper;
import com.ruoyi.common.service.IChatAgentStatusService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 在线客服坐席状态Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
@Service
public class ChatAgentStatusServiceImpl implements IChatAgentStatusService
{
    @Autowired
    private ChatAgentStatusMapper chatAgentStatusMapper;

    /**
     * 查询在线客服坐席状态
     * 
     * @param id 在线客服坐席状态主键
     * @return 在线客服坐席状态
     */
    @Override
    public ChatAgentStatus selectChatAgentStatusById(String id)
    {
        return chatAgentStatusMapper.selectChatAgentStatusById(id);
    }

    /**
     * 查询在线客服坐席状态列表
     * 
     * @param chatAgentStatus 在线客服坐席状态
     * @return 在线客服坐席状态
     */
    @Override
    public List<ChatAgentStatus> selectChatAgentStatusList(ChatAgentStatus chatAgentStatus)
    {
        return chatAgentStatusMapper.selectChatAgentStatusList(chatAgentStatus);
    }

    /**
     * 新增在线客服坐席状态
     * 
     * @param chatAgentStatus 在线客服坐席状态
     * @return 结果
     */
    @Override
    public int insertChatAgentStatus(ChatAgentStatus chatAgentStatus)
    {
        chatAgentStatus.setCreateTime(DateUtils.getNowDate());
        return chatAgentStatusMapper.insertChatAgentStatus(chatAgentStatus);
    }

    /**
     * 修改在线客服坐席状态
     * 
     * @param chatAgentStatus 在线客服坐席状态
     * @return 结果
     */
    @Override
    public int updateChatAgentStatus(ChatAgentStatus chatAgentStatus)
    {
        chatAgentStatus.setUpdateTime(DateUtils.getNowDate());
        return chatAgentStatusMapper.updateChatAgentStatus(chatAgentStatus);
    }

    /**
     * 批量删除在线客服坐席状态
     * 
     * @param ids 需要删除的在线客服坐席状态主键
     * @return 结果
     */
    @Override
    public int deleteChatAgentStatusByIds(String[] ids)
    {
        return chatAgentStatusMapper.deleteChatAgentStatusByIds(ids);
    }

    /**
     * 删除在线客服坐席状态信息
     * 
     * @param id 在线客服坐席状态主键
     * @return 结果
     */
    @Override
    public int deleteChatAgentStatusById(String id)
    {
        return chatAgentStatusMapper.deleteChatAgentStatusById(id);
    }
}
