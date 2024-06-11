package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.domain.ChatContacts;
import com.ruoyi.common.service.IChatContactsService;
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
 * 联系人信息Controller
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
@RestController
@RequestMapping("/system/contacts")
public class ChatContactsController extends BaseController
{
    @Autowired
    private IChatContactsService chatContactsService;

    /**
     * 查询联系人信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:contacts:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChatContacts chatContacts)
    {
        startPage();
        List<ChatContacts> list = chatContactsService.selectChatContactsList(chatContacts);
        return getDataTable(list);
    }

    /**
     * 导出联系人信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:contacts:export')")
    @Log(title = "联系人信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChatContacts chatContacts)
    {
        List<ChatContacts> list = chatContactsService.selectChatContactsList(chatContacts);
        ExcelUtil<ChatContacts> util = new ExcelUtil<ChatContacts>(ChatContacts.class);
        util.exportExcel(response, list, "联系人信息数据");
    }

    /**
     * 获取联系人信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:contacts:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(chatContactsService.selectChatContactsById(id));
    }

    /**
     * 新增联系人信息
     */
    @PreAuthorize("@ss.hasPermi('system:contacts:add')")
    @Log(title = "联系人信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChatContacts chatContacts)
    {
        return toAjax(chatContactsService.insertChatContacts(chatContacts));
    }

    /**
     * 修改联系人信息
     */
    @PreAuthorize("@ss.hasPermi('system:contacts:edit')")
    @Log(title = "联系人信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChatContacts chatContacts)
    {
        return toAjax(chatContactsService.updateChatContacts(chatContacts));
    }

    /**
     * 删除联系人信息
     */
    @PreAuthorize("@ss.hasPermi('system:contacts:remove')")
    @Log(title = "联系人信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(chatContactsService.deleteChatContactsByIds(ids));
    }
}
