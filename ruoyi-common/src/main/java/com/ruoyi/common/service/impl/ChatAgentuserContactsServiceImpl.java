package com.ruoyi.system.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.domain.ChatAgentStatus;
import com.ruoyi.common.domain.ChatAgentuserContacts;
import com.ruoyi.common.mapper.ChatAgentStatusMapper;
import com.ruoyi.common.mapper.ChatAgentuserContactsMapper;
import com.ruoyi.common.service.IChatAgentuserContactsService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 访客联系人关联Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
@Service
public class ChatAgentuserContactsServiceImpl extends ServiceImpl<ChatAgentuserContactsMapper, ChatAgentuserContacts> implements IChatAgentuserContactsService
{
    @Autowired
    private ChatAgentuserContactsMapper chatAgentuserContactsMapper;

    /**
     * 查询访客联系人关联
     * 
     * @param id 访客联系人关联主键
     * @return 访客联系人关联
     */
    @Override
    public ChatAgentuserContacts selectChatAgentuserContactsById(String id)
    {
        return chatAgentuserContactsMapper.selectChatAgentuserContactsById(id);
    }

    /**
     * 查询访客联系人关联列表
     * 
     * @param chatAgentuserContacts 访客联系人关联
     * @return 访客联系人关联
     */
    @Override
    public List<ChatAgentuserContacts> selectChatAgentuserContactsList(ChatAgentuserContacts chatAgentuserContacts)
    {
        return chatAgentuserContactsMapper.selectChatAgentuserContactsList(chatAgentuserContacts);
    }

    /**
     * 新增访客联系人关联
     * 
     * @param chatAgentuserContacts 访客联系人关联
     * @return 结果
     */
    @Override
    public int insertChatAgentuserContacts(ChatAgentuserContacts chatAgentuserContacts)
    {
        chatAgentuserContacts.setCreateTime(DateUtils.getNowDate());
        return chatAgentuserContactsMapper.insertChatAgentuserContacts(chatAgentuserContacts);
    }

    /**
     * 修改访客联系人关联
     * 
     * @param chatAgentuserContacts 访客联系人关联
     * @return 结果
     */
    @Override
    public int updateChatAgentuserContacts(ChatAgentuserContacts chatAgentuserContacts)
    {
        return chatAgentuserContactsMapper.updateChatAgentuserContacts(chatAgentuserContacts);
    }

    /**
     * 批量删除访客联系人关联
     * 
     * @param ids 需要删除的访客联系人关联主键
     * @return 结果
     */
    @Override
    public int deleteChatAgentuserContactsByIds(String[] ids)
    {
        return chatAgentuserContactsMapper.deleteChatAgentuserContactsByIds(ids);
    }

    /**
     * 删除访客联系人关联信息
     * 
     * @param id 访客联系人关联主键
     * @return 结果
     */
    @Override
    public int deleteChatAgentuserContactsById(String id)
    {
        return chatAgentuserContactsMapper.deleteChatAgentuserContactsById(id);
    }
}
