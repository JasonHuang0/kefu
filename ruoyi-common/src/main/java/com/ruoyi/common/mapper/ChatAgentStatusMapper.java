package com.ruoyi.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.common.domain.ChatAgentStatus;

import java.util.List;

/**
 * 在线客服坐席状态Mapper接口
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
public interface ChatAgentStatusMapper extends BaseMapper<ChatAgentStatus>
{
    /**
     * 查询在线客服坐席状态
     * 
     * @param id 在线客服坐席状态主键
     * @return 在线客服坐席状态
     */
    public ChatAgentStatus selectChatAgentStatusById(String id);
    public ChatAgentStatus selectChatAgentStatusByUserId(String userId);

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
     * 删除在线客服坐席状态
     * 
     * @param id 在线客服坐席状态主键
     * @return 结果
     */
    public int deleteChatAgentStatusById(String id);

    /**
     * 批量删除在线客服坐席状态
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChatAgentStatusByIds(String[] ids);
}
