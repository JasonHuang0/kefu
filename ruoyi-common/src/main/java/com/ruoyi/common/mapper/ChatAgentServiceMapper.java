package com.ruoyi.common.mapper;

import java.util.List;
import com.ruoyi.system.domain.ChatAgentService;

/**
 * 在线客服服务记录Mapper接口
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
public interface ChatAgentServiceMapper 
{
    /**
     * 查询在线客服服务记录
     * 
     * @param id 在线客服服务记录主键
     * @return 在线客服服务记录
     */
    public ChatAgentService selectChatAgentServiceById(String id);

    /**
     * 查询在线客服服务记录列表
     * 
     * @param chatAgentService 在线客服服务记录
     * @return 在线客服服务记录集合
     */
    public List<ChatAgentService> selectChatAgentServiceList(ChatAgentService chatAgentService);

    /**
     * 新增在线客服服务记录
     * 
     * @param chatAgentService 在线客服服务记录
     * @return 结果
     */
    public int insertChatAgentService(ChatAgentService chatAgentService);

    /**
     * 修改在线客服服务记录
     * 
     * @param chatAgentService 在线客服服务记录
     * @return 结果
     */
    public int updateChatAgentService(ChatAgentService chatAgentService);

    /**
     * 删除在线客服服务记录
     * 
     * @param id 在线客服服务记录主键
     * @return 结果
     */
    public int deleteChatAgentServiceById(String id);

    /**
     * 批量删除在线客服服务记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChatAgentServiceByIds(String[] ids);
}
