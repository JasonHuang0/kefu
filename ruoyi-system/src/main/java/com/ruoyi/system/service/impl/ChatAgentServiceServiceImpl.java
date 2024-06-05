package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ChatAgentServiceMapper;
import com.ruoyi.system.domain.ChatAgentService;
import com.ruoyi.system.service.IChatAgentServiceService;

/**
 * 在线客服服务记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
@Service
public class ChatAgentServiceServiceImpl implements IChatAgentServiceService 
{
    @Autowired
    private ChatAgentServiceMapper chatAgentServiceMapper;

    /**
     * 查询在线客服服务记录
     * 
     * @param id 在线客服服务记录主键
     * @return 在线客服服务记录
     */
    @Override
    public ChatAgentService selectChatAgentServiceById(String id)
    {
        return chatAgentServiceMapper.selectChatAgentServiceById(id);
    }

    /**
     * 查询在线客服服务记录列表
     * 
     * @param chatAgentService 在线客服服务记录
     * @return 在线客服服务记录
     */
    @Override
    public List<ChatAgentService> selectChatAgentServiceList(ChatAgentService chatAgentService)
    {
        return chatAgentServiceMapper.selectChatAgentServiceList(chatAgentService);
    }

    /**
     * 新增在线客服服务记录
     * 
     * @param chatAgentService 在线客服服务记录
     * @return 结果
     */
    @Override
    public int insertChatAgentService(ChatAgentService chatAgentService)
    {
        chatAgentService.setCreateTime(DateUtils.getNowDate());
        return chatAgentServiceMapper.insertChatAgentService(chatAgentService);
    }

    /**
     * 修改在线客服服务记录
     * 
     * @param chatAgentService 在线客服服务记录
     * @return 结果
     */
    @Override
    public int updateChatAgentService(ChatAgentService chatAgentService)
    {
        chatAgentService.setUpdateTime(DateUtils.getNowDate());
        return chatAgentServiceMapper.updateChatAgentService(chatAgentService);
    }

    /**
     * 批量删除在线客服服务记录
     * 
     * @param ids 需要删除的在线客服服务记录主键
     * @return 结果
     */
    @Override
    public int deleteChatAgentServiceByIds(String[] ids)
    {
        return chatAgentServiceMapper.deleteChatAgentServiceByIds(ids);
    }

    /**
     * 删除在线客服服务记录信息
     * 
     * @param id 在线客服服务记录主键
     * @return 结果
     */
    @Override
    public int deleteChatAgentServiceById(String id)
    {
        return chatAgentServiceMapper.deleteChatAgentServiceById(id);
    }
}
