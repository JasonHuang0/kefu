package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.domain.ChatMessage;
import com.ruoyi.common.service.IChatMessageService;
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
 * 坐席对话Controller
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
@RestController
@RequestMapping("/system/message")
public class ChatMessageController extends BaseController
{
    @Autowired
    private IChatMessageService chatMessageService;

    /**
     * 查询坐席对话列表
     */
    @PreAuthorize("@ss.hasPermi('system:message:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChatMessage chatMessage)
    {
        startPage();
        List<ChatMessage> list = chatMessageService.selectChatMessageList(chatMessage);
        return getDataTable(list);
    }

    /**
     * 导出坐席对话列表
     */
    @PreAuthorize("@ss.hasPermi('system:message:export')")
    @Log(title = "坐席对话", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChatMessage chatMessage)
    {
        List<ChatMessage> list = chatMessageService.selectChatMessageList(chatMessage);
        ExcelUtil<ChatMessage> util = new ExcelUtil<ChatMessage>(ChatMessage.class);
        util.exportExcel(response, list, "坐席对话数据");
    }

    /**
     * 获取坐席对话详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:message:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(chatMessageService.selectChatMessageById(id));
    }

    /**
     * 新增坐席对话
     */
    @PreAuthorize("@ss.hasPermi('system:message:add')")
    @Log(title = "坐席对话", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChatMessage chatMessage)
    {
        return toAjax(chatMessageService.insertChatMessage(chatMessage));
    }

    /**
     * 修改坐席对话
     */
    @PreAuthorize("@ss.hasPermi('system:message:edit')")
    @Log(title = "坐席对话", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChatMessage chatMessage)
    {
        return toAjax(chatMessageService.updateChatMessage(chatMessage));
    }

    /**
     * 删除坐席对话
     */
    @PreAuthorize("@ss.hasPermi('system:message:remove')")
    @Log(title = "坐席对话", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(chatMessageService.deleteChatMessageByIds(ids));
    }
}
