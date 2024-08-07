package com.ruoyi.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.common.domain.ChatMessage;

import java.util.List;

/**
 * 坐席对话Mapper接口
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
public interface ChatMessageMapper extends BaseMapper<ChatMessage>
{
    /**
     * 查询坐席对话
     * 
     * @param id 坐席对话主键
     * @return 坐席对话
     */
    public ChatMessage selectChatMessageById(String id);

    /**
     * 查询坐席对话列表
     * 
     * @param chatMessage 坐席对话
     * @return 坐席对话集合
     */
    public List<ChatMessage> selectChatMessageList(ChatMessage chatMessage);

    /**
     * 新增坐席对话
     * 
     * @param chatMessage 坐席对话
     * @return 结果
     */
    public int insertChatMessage(ChatMessage chatMessage);

    /**
     * 修改坐席对话
     * 
     * @param chatMessage 坐席对话
     * @return 结果
     */
    public int updateChatMessage(ChatMessage chatMessage);

    /**
     * 删除坐席对话
     * 
     * @param id 坐席对话主键
     * @return 结果
     */
    public int deleteChatMessageById(String id);

    /**
     * 批量删除坐席对话
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChatMessageByIds(String[] ids);
}
