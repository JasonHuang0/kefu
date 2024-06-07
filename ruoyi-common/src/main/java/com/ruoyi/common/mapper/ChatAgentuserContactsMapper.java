package com.ruoyi.common.mapper;

import java.util.List;
import com.ruoyi.system.domain.ChatAgentuserContacts;

/**
 * 访客联系人关联Mapper接口
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
public interface ChatAgentuserContactsMapper 
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
     * 删除访客联系人关联
     * 
     * @param id 访客联系人关联主键
     * @return 结果
     */
    public int deleteChatAgentuserContactsById(String id);

    /**
     * 批量删除访客联系人关联
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChatAgentuserContactsByIds(String[] ids);
}
