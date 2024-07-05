package com.ruoyi.common.enums;

import com.ruoyi.common.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * client类型枚举
 */
@Getter
@AllArgsConstructor
public enum ClientTypeEnum {

    MEMBER(1,"会员");


    private Integer code;

    private String name;

    private static final Map<Object, ClientTypeEnum> ENUM_MAP;

    static {
        Map<Object, ClientTypeEnum> map = new ConcurrentHashMap<Object, ClientTypeEnum>();
        for (ClientTypeEnum instance : ClientTypeEnum.values()) {
            map.put(instance.getName(),instance);
            map.put(instance.getCode(), instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static ClientTypeEnum getEnumByValue(Integer code) {
        if(code == null){
            return null;
        }
        return ENUM_MAP.get(code);
    }

    public static ClientTypeEnum getEnumByDescription(String name) {
        if(StringUtils.isBlank(name)){
            return null;
        }
        return ENUM_MAP.get(name);
    }

    public static ClientTypeEnum[] getList() {
        return values();
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
