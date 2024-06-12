package com.ruoyi.chat.controller;


import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.domain.vo.ClientRes;
import com.ruoyi.common.core.domain.vo.RequestEntity;
import com.ruoyi.common.exception.GlobalException;
import com.ruoyi.common.service.ApiTokenService;
import com.ruoyi.common.utils.AesEncryptUtil;
import com.ruoyi.system.basic.MainContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 对接其他系统用
 */

@Slf4j
@RestController
@RequestMapping("/apiClient")
public class ApiClientController {

    @Autowired
    private ApiTokenService apiTokenService;


    //发送消息
//    @Autowired
//    private AsyncService asyncService;


    /**
     * 获取 ws 连接 token
     * @return
     */
    @PostMapping("/getWsToken")
    public AjaxResult getToken(@RequestBody RequestEntity requestEntity) {
        try {
            ClientRes clientRes = verify(requestEntity);
            return apiTokenService.getClientToken(clientRes);
        }catch (Exception e){
            if(e instanceof GlobalException){
                return AjaxResult.error(e.getMessage());
            }else {
                e.printStackTrace();
                return AjaxResult.error("系统异常!");
            }
        }
    }

    /**
     * 同步用户信息
     * @param requestEntity
     * @return
     */
    @PostMapping("/userSync")
    public AjaxResult userSync(@RequestBody RequestEntity requestEntity) {
        try {
            ClientRes clientRes = verify(requestEntity);
            apiTokenService.synchronization(clientRes);
            return AjaxResult.success(AesEncryptUtil.dataEncrypt("success"));
        }catch (Exception e){
            if(e instanceof GlobalException){
                return AjaxResult.error(e.getMessage());
            }else {
                e.printStackTrace();
                return AjaxResult.error("系统异常!");
            }
        }
    }



    /**
     * 发送消息
     * @return
     */
    @PostMapping("/sendMessage")
    public AjaxResult sendMessage(@RequestBody RequestEntity requestEntity) {
        try {
            ClientRes clientRes = verify(requestEntity);
            if(!StringUtils.isEmpty(clientRes.getAgentAccount())){
                SysUser agentUser = MainContext.getCache().findUserByUserName(clientRes.getAgentAccount());
                if(agentUser == null){
                    return AjaxResult.error("所选坐席不存在,请检查配置是否正确!");
                }
                clientRes.setAgent(agentUser);
            }
            //TODO 发送消息
//            asyncService.asyncSendMessage(clientRes);
            return AjaxResult.success();
        }catch (Exception e){
            if(e instanceof GlobalException){
                return AjaxResult.error(e.getMessage());
            }else {
                e.printStackTrace();
                return AjaxResult.error("系统异常!");
            }
        }
    }



    public ClientRes verify(RequestEntity requestEntity) throws Exception{
        if(requestEntity.getT() == null){
            throw new GlobalException("t not be null");
        }
        if(System.currentTimeMillis() - requestEntity.getT() > 10000){
            throw new GlobalException("timeout request");
        }
        if(StringUtils.isEmpty(requestEntity.getSign())){
            throw new GlobalException("sign not be null");
        }
        if(StringUtils.isEmpty(requestEntity.getData())){
            throw new GlobalException("data not be null ");
        }
        String decryptData = AesEncryptUtil.dataDecrypt(requestEntity.getData());
        if(StringUtils.isEmpty(decryptData)){
            throw new GlobalException("data error ");
        }
        Map<String,String> map  = JSONObject.parseObject(decryptData, Map.class);
        if(StringUtils.isEmpty(map.get("appId"))){
            throw new GlobalException("data error ");
        }
//        SNSAccount snsAccount = cache.findSnsAccountBySnsId(map.get("appId"));
//        if(snsAccount == null){
//            throw new GlobalException("chat channel not configured ");
//        }
        boolean result = AesEncryptUtil.verifySign(map, requestEntity.getT().toString(), requestEntity.getSign(),Constants.SIGN_KEY);
        if(!result){
            throw new GlobalException("sign error ");
        }
        ClientRes clientRes = JSONObject.parseObject(decryptData, ClientRes.class);
//        clientRes.setOrganId(snsAccount.getOrgan());
//        clientRes.setAppKey(snsAccount.getAppkey());
        return clientRes;
    }




}
