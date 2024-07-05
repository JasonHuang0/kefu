package com.ruoyi.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.auth.AuthToken;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.domain.ChatAgentuserContacts;
import com.ruoyi.common.domain.ChatContacts;
import com.ruoyi.common.domain.vo.ClientRes;
import com.ruoyi.common.enums.ClientTypeEnum;
import com.ruoyi.common.exception.GlobalException;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.mapper.ChatContactsMapper;
import com.ruoyi.common.service.ApiTokenService;
import com.ruoyi.common.service.IChatAgentuserContactsService;
import com.ruoyi.common.service.IChatContactsService;
import com.ruoyi.common.utils.AesEncryptUtil;
import com.ruoyi.common.utils.MD5Util;
import com.ruoyi.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
public class ApiTokenServiceImpl  implements ApiTokenService {

    @Autowired
    private IChatAgentuserContactsService agentuserContactsService;

    @Autowired
    private IChatContactsService contactsService;

    @Autowired
    private AuthToken authToken;

    /**
     * 获取客户端token
     * @param clientRes
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult getClientToken(ClientRes clientRes) throws Exception{
        ChatContacts contacts = synchronization(clientRes);
        this.setToken(contacts);
        authToken.putClienUsertByAuth(contacts.getToken(),contacts);
        Map<String,Object> resultMap =new HashMap<>();
        resultMap.put("wsToken",contacts.getToken());
        return AjaxResult.success(AesEncryptUtil.dataEncrypt(JSONObject.toJSONString(resultMap)));
    }



    @Override
    @Transactional
    public ChatContacts synchronization(ClientRes clientRes) throws GlobalException{
        if(StringUtils.isBlank(clientRes.getAppId())){
            throw new GlobalException("appId not be null ");
        }
        ClientTypeEnum clientTypeEnum = ClientTypeEnum.getEnumByValue(clientRes.getClientType());
        if(clientTypeEnum == null){
            throw new GlobalException(("clientType error "));
        }
        String userId = MD5Util.MD5Encode(clientRes.getUserId());
        ChatContacts contacts = contactsService.findByUserIdAndDatatStatus(userId, false);
        if(contacts == null){
            contacts = new ChatContacts();
            contacts.setUserId(userId);
            if(!clientRes.getClientType().equals(ClientTypeEnum.MEMBER.getCode())){
                contacts.setClientId(clientRes.getUserId());
            }
            contacts.setCreateTime(new Date());
            contacts.setDataStatus(false);
            ChatAgentuserContacts agentuserContacts = new ChatAgentuserContacts();
            agentuserContacts.setUserId(contacts.getUserId());
            agentuserContacts.setChannel("webim");
            agentuserContacts.setCreateTime(new Date());
            agentuserContacts.setAppid(clientRes.getAppId());
            agentuserContacts.setContactsId(contacts.getId());
            agentuserContactsService.save(agentuserContacts);
        }
        contacts.setNickName(clientRes.getNickName());
        contacts.setName(clientRes.getRealName());
        contacts.setAccountNo(clientRes.getMobile());
        contacts.setRemark(clientRes.getRemark());
        contacts.setClientType(clientRes.getClientType());
        contacts.setJpushPackageName(clientRes.getJpushPackageName());
        if(!StringUtils.isBlank(clientRes.getJpushToken())){
            contacts.setJpushToken(clientRes.getJpushToken());
        }
        contactsService.save(contacts);
        return contacts;
    }


    /**
     * 生成token
     */
    public ChatContacts setToken(ChatContacts contacts){
        //TODO 后续可考虑token的生成方式, 先简单实现
        String token = UUID.randomUUID().toString();
        if(!StringUtils.isBlank(contacts.getToken())){
            authToken.deleteClientUserAuth(contacts.getToken());
        }
        contacts.setToken(token);
        return contacts;
    }

}
