package com.ruoyi.common.service;

import com.ruoyi.common.domain.ChatAgentuserContacts;

import java.util.List;

/**
 * 访客联系人关联Service接口
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
public interface IChatAgentuserContactsService 
{
    /**
     * 查询访客联系人关联
     * 
     * @param id 访客联系人关联主键
     * @return 访客联系人关联
     */
    public ChatAgentuserContacts selectChatAgentuserContactsById(String id);

    /**
     * 查询访客联系人关联列表
     * 
     * @param chatAgentuserContacts 访客联系人关联
     * @return 访客联系人关联集合
     */
    public List<ChatAgentuserContacts> selectChatAgentuserContactsList(ChatAgentuserContacts chatAgentuserContacts);

    /**
     * 新增访客联系人关联
     * 
     * @param chatAgentuserContacts 访客联系人关联
     * @return 结果
     */
    public int insertChatAgentuserContacts(ChatAgentuserContacts chatAgentuserContacts);

    /**
     * 修改访客联系人关联
     * 
     * @param chatAgentuserContacts 访客联系人关联
     * @return 结果
     */
    public int updateChatAgentuserContacts(ChatAgentuserContacts chatAgentuserContacts);

    /**
     * 批量删除访客联系人关联
     * 
     * @param ids 需要删除的访客联系人关联主键集合
     * @return 结果
     */
    public int deleteChatAgentuserContactsByIds(String[] ids);

    /**
     * 删除访客联系人关联信息
     * 
     * @param id 访客联系人关联主键
     * @return 结果
     */
    public int deleteChatAgentuserContactsById(String id);
}
