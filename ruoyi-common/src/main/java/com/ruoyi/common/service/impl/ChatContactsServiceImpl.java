package com.ruoyi.common.service.impl;

import java.util.List;

import com.ruoyi.common.mapper.ChatContactsMapper;
import com.ruoyi.common.service.IChatContactsService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.domain.ChatContacts;

/**
 * 联系人信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
@Service
public class ChatContactsServiceImpl implements IChatContactsService
{
    @Autowired
    private ChatContactsMapper chatContactsMapper;

    /**
     * 查询联系人信息
     * 
     * @param id 联系人信息主键
     * @return 联系人信息
     */
    @Override
    public ChatContacts selectChatContactsById(String id)
    {
        return chatContactsMapper.selectChatContactsById(id);
    }

    /**
     * 查询联系人信息列表
     * 
     * @param chatContacts 联系人信息
     * @return 联系人信息
     */
    @Override
    public List<ChatContacts> selectChatContactsList(ChatContacts chatContacts)
    {
        return chatContactsMapper.selectChatContactsList(chatContacts);
    }

    /**
     * 新增联系人信息
     * 
     * @param chatContacts 联系人信息
     * @return 结果
     */
    @Override
    public int insertChatContacts(ChatContacts chatContacts)
    {
        chatContacts.setCreateTime(DateUtils.getNowDate());
        return chatContactsMapper.insertChatContacts(chatContacts);
    }

    /**
     * 修改联系人信息
     * 
     * @param chatContacts 联系人信息
     * @return 结果
     */
    @Override
    public int updateChatContacts(ChatContacts chatContacts)
    {
        return chatContactsMapper.updateChatContacts(chatContacts);
    }

    /**
     * 批量删除联系人信息
     * 
     * @param ids 需要删除的联系人信息主键
     * @return 结果
     */
    @Override
    public int deleteChatContactsByIds(String[] ids)
    {
        return chatContactsMapper.deleteChatContactsByIds(ids);
    }

    /**
     * 删除联系人信息信息
     * 
     * @param id 联系人信息主键
     * @return 结果
     */
    @Override
    public int deleteChatContactsById(String id)
    {
        return chatContactsMapper.deleteChatContactsById(id);
    }
}
