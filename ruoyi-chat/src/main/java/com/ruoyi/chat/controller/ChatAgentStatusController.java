package com.ruoyi.chat.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.ChatAgentStatus;
import com.ruoyi.system.service.IChatAgentStatusService;
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
 * 在线客服坐席状态Controller
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
@RestController
@RequestMapping("/system/status")
public class ChatAgentStatusController extends BaseController
{
    @Autowired
    private IChatAgentStatusService chatAgentStatusService;

    /**
     * 查询在线客服坐席状态列表
     */
    @PreAuthorize("@ss.hasPermi('system:status:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChatAgentStatus chatAgentStatus)
    {
        startPage();
        List<ChatAgentStatus> list = chatAgentStatusService.selectChatAgentStatusList(chatAgentStatus);
        return getDataTable(list);
    }

    /**
     * 导出在线客服坐席状态列表
     */
    @PreAuthorize("@ss.hasPermi('system:status:export')")
    @Log(title = "在线客服坐席状态", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChatAgentStatus chatAgentStatus)
    {
        List<ChatAgentStatus> list = chatAgentStatusService.selectChatAgentStatusList(chatAgentStatus);
        ExcelUtil<ChatAgentStatus> util = new ExcelUtil<ChatAgentStatus>(ChatAgentStatus.class);
        util.exportExcel(response, list, "在线客服坐席状态数据");
    }

    /**
     * 获取在线客服坐席状态详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:status:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(chatAgentStatusService.selectChatAgentStatusById(id));
    }

    /**
     * 新增在线客服坐席状态
     */
    @PreAuthorize("@ss.hasPermi('system:status:add')")
    @Log(title = "在线客服坐席状态", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChatAgentStatus chatAgentStatus)
    {
        return toAjax(chatAgentStatusService.insertChatAgentStatus(chatAgentStatus));
    }

    /**
     * 修改在线客服坐席状态
     */
    @PreAuthorize("@ss.hasPermi('system:status:edit')")
    @Log(title = "在线客服坐席状态", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChatAgentStatus chatAgentStatus)
    {
        return toAjax(chatAgentStatusService.updateChatAgentStatus(chatAgentStatus));
    }

    /**
     * 删除在线客服坐席状态
     */
    @PreAuthorize("@ss.hasPermi('system:status:remove')")
    @Log(title = "在线客服坐席状态", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(chatAgentStatusService.deleteChatAgentStatusByIds(ids));
    }
}
