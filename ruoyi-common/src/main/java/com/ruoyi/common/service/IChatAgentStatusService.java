package com.ruoyi.common.service;

import java.util.List;
import com.ruoyi.system.domain.ChatAgentStatus;

/**
 * 在线客服坐席状态Service接口
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
public interface IChatAgentStatusService 
{
    /**
     * 查询在线客服坐席状态
     * 
     * @param id 在线客服坐席状态主键
     * @return 在线客服坐席状态
     */
    public ChatAgentStatus selectChatAgentStatusById(String id);

    /**
     * 查询在线客服坐席状态列表
     * 
     * @param chatAgentStatus 在线客服坐席状态
     * @return 在线客服坐席状态集合
     */
    public List<ChatAgentStatus> selectChatAgentStatusList(ChatAgentStatus chatAgentStatus);

    /**
     * 新增在线客服坐席状态
     * 
     * @param chatAgentStatus 在线客服坐席状态
     * @return 结果
     */
    public int insertChatAgentStatus(ChatAgentStatus chatAgentStatus);

    /**
     * 修改在线客服坐席状态
     * 
     * @param chatAgentStatus 在线客服坐席状态
     * @return 结果
     */
    public int updateChatAgentStatus(ChatAgentStatus chatAgentStatus);

    /**
     * 批量删除在线客服坐席状态
     * 
     * @param ids 需要删除的在线客服坐席状态主键集合
     * @return 结果
     */
    public int deleteChatAgentStatusByIds(String[] ids);

    /**
     * 删除在线客服坐席状态信息
     * 
     * @param id 在线客服坐席状态主键
     * @return 结果
     */
    public int deleteChatAgentStatusById(String id);
}
