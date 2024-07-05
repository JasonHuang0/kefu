package com.ruoyi.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.domain.ChatContacts;

import java.util.List;

/**
 * 联系人信息Service接口
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
public interface IChatContactsService extends IService<ChatContacts>
{
    /**
     * 查询联系人信息
     * 
     * @param id 联系人信息主键
     * @return 联系人信息
     */
    public ChatContacts selectChatContactsById(String id);

    /**
     * 查询联系人信息列表
     * 
     * @param chatContacts 联系人信息
     * @return 联系人信息集合
     */
    public List<ChatContacts> selectChatContactsList(ChatContacts chatContacts);

    /**
     * 新增联系人信息
     * 
     * @param chatContacts 联系人信息
     * @return 结果
     */
    public int insertChatContacts(ChatContacts chatContacts);

    /**
     * 修改联系人信息
     * 
     * @param chatContacts 联系人信息
     * @return 结果
     */
    public int updateChatContacts(ChatContacts chatContacts);

    /**
     * 批量删除联系人信息
     * 
     * @param ids 需要删除的联系人信息主键集合
     * @return 结果
     */
    public int deleteChatContactsByIds(String[] ids);

    /**
     * 删除联系人信息信息
     * 
     * @param id 联系人信息主键
     * @return 结果
     */
    public int deleteChatContactsById(String id);

    ChatContacts findByUserIdAndDatatStatus(String userId, boolean dataStatus);
}
