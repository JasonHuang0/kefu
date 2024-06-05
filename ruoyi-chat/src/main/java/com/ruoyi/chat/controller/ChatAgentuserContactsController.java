package com.ruoyi.chat.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.ChatAgentuserContacts;
import com.ruoyi.system.service.IChatAgentuserContactsService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 访客联系人关联Controller
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
@RestController
@RequestMapping("/system/contacts")
public class ChatAgentuserContactsController extends BaseController
{
    @Autowired
    private IChatAgentuserContactsService chatAgentuserContactsService;

    /**
     * 查询访客联系人关联列表
     */
    @PreAuthorize("@ss.hasPermi('system:contacts:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChatAgentuserContacts chatAgentuserContacts)
    {
        startPage();
        List<ChatAgentuserContacts> list = chatAgentuserContactsService.selectChatAgentuserContactsList(chatAgentuserContacts);
        return getDataTable(list);
    }

    /**
     * 导出访客联系人关联列表
     */
    @PreAuthorize("@ss.hasPermi('system:contacts:export')")
    @Log(title = "访客联系人关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChatAgentuserContacts chatAgentuserContacts)
    {
        List<ChatAgentuserContacts> list = chatAgentuserContactsService.selectChatAgentuserContactsList(chatAgentuserContacts);
        ExcelUtil<ChatAgentuserContacts> util = new ExcelUtil<ChatAgentuserContacts>(ChatAgentuserContacts.class);
        util.exportExcel(response, list, "访客联系人关联数据");
    }

    /**
     * 获取访客联系人关联详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:contacts:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(chatAgentuserContactsService.selectChatAgentuserContactsById(id));
    }

    /**
     * 新增访客联系人关联
     */
    @PreAuthorize("@ss.hasPermi('system:contacts:add')")
    @Log(title = "访客联系人关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChatAgentuserContacts chatAgentuserContacts)
    {
        return toAjax(chatAgentuserContactsService.insertChatAgentuserContacts(chatAgentuserContacts));
    }

    /**
     * 修改访客联系人关联
     */
    @PreAuthorize("@ss.hasPermi('system:contacts:edit')")
    @Log(title = "访客联系人关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChatAgentuserContacts chatAgentuserContacts)
    {
        return toAjax(chatAgentuserContactsService.updateChatAgentuserContacts(chatAgentuserContacts));
    }

    /**
     * 删除访客联系人关联
     */
    @PreAuthorize("@ss.hasPermi('system:contacts:remove')")
    @Log(title = "访客联系人关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(chatAgentuserContactsService.deleteChatAgentuserContactsByIds(ids));
    }
}
