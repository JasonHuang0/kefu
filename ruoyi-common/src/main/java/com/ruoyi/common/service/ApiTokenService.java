package com.ruoyi.common.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.domain.vo.ClientRes;
import com.ruoyi.common.domain.ChatContacts;

public interface ApiTokenService {

    AjaxResult getClientToken(ClientRes clientRes) throws Exception;


    ChatContacts synchronization(ClientRes clientRes) throws Exception;
}
