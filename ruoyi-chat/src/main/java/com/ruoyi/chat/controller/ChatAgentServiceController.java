package com.ruoyi.chat.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.ChatAgentService;
import com.ruoyi.system.service.IChatAgentServiceService;
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
 * 在线客服服务记录Controller
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
@RestController
@RequestMapping("/system/service")
public class ChatAgentServiceController extends BaseController
{
    @Autowired
    private IChatAgentServiceService chatAgentServiceService;

    /**
     * 查询在线客服服务记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:service:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChatAgentService chatAgentService)
    {
        startPage();
        List<ChatAgentService> list = chatAgentServiceService.selectChatAgentServiceList(chatAgentService);
        return getDataTable(list);
    }

    /**
     * 导出在线客服服务记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:service:export')")
    @Log(title = "在线客服服务记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChatAgentService chatAgentService)
    {
        List<ChatAgentService> list = chatAgentServiceService.selectChatAgentServiceList(chatAgentService);
        ExcelUtil<ChatAgentService> util = new ExcelUtil<ChatAgentService>(ChatAgentService.class);
        util.exportExcel(response, list, "在线客服服务记录数据");
    }

    /**
     * 获取在线客服服务记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:service:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(chatAgentServiceService.selectChatAgentServiceById(id));
    }

    /**
     * 新增在线客服服务记录
     */
    @PreAuthorize("@ss.hasPermi('system:service:add')")
    @Log(title = "在线客服服务记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChatAgentService chatAgentService)
    {
        return toAjax(chatAgentServiceService.insertChatAgentService(chatAgentService));
    }

    /**
     * 修改在线客服服务记录
     */
    @PreAuthorize("@ss.hasPermi('system:service:edit')")
    @Log(title = "在线客服服务记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChatAgentService chatAgentService)
    {
        return toAjax(chatAgentServiceService.updateChatAgentService(chatAgentService));
    }

    /**
     * 删除在线客服服务记录
     */
    @PreAuthorize("@ss.hasPermi('system:service:remove')")
    @Log(title = "在线客服服务记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(chatAgentServiceService.deleteChatAgentServiceByIds(ids));
    }
}
