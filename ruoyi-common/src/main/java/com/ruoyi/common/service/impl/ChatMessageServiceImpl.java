package com.ruoyi.common.service.impl;

import java.util.List;

import com.ruoyi.common.domain.ChatMessage;
import com.ruoyi.common.mapper.ChatMessageMapper;
import com.ruoyi.common.service.IChatMessageService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 坐席对话Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
@Service
public class ChatMessageServiceImpl implements IChatMessageService
{
    @Autowired
    private ChatMessageMapper chatMessageMapper;

    /**
     * 查询坐席对话
     * 
     * @param id 坐席对话主键
     * @return 坐席对话
     */
    @Override
    public ChatMessage selectChatMessageById(String id)
    {
        return chatMessageMapper.selectChatMessageById(id);
    }

    /**
     * 查询坐席对话列表
     * 
     * @param chatMessage 坐席对话
     * @return 坐席对话
     */
    @Override
    public List<ChatMessage> selectChatMessageList(ChatMessage chatMessage)
    {
        return chatMessageMapper.selectChatMessageList(chatMessage);
    }

    /**
     * 新增坐席对话
     * 
     * @param chatMessage 坐席对话
     * @return 结果
     */
    @Override
    public int insertChatMessage(ChatMessage chatMessage)
    {
        chatMessage.setCreateTime(DateUtils.getNowDate());
        return chatMessageMapper.insertChatMessage(chatMessage);
    }

    /**
     * 修改坐席对话
     * 
     * @param chatMessage 坐席对话
     * @return 结果
     */
    @Override
    public int updateChatMessage(ChatMessage chatMessage)
    {
        return chatMessageMapper.updateChatMessage(chatMessage);
    }

    /**
     * 批量删除坐席对话
     * 
     * @param ids 需要删除的坐席对话主键
     * @return 结果
     */
    @Override
    public int deleteChatMessageByIds(String[] ids)
    {
        return chatMessageMapper.deleteChatMessageByIds(ids);
    }

    /**
     * 删除坐席对话信息
     * 
     * @param id 坐席对话主键
     * @return 结果
     */
    @Override
    public int deleteChatMessageById(String id)
    {
        return chatMessageMapper.deleteChatMessageById(id);
    }
}
