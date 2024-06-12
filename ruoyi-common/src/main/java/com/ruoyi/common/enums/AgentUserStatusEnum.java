package com.ruoyi.common.enums;

/**
 * @Auther: jason
 * @Date: 12/6/2024 11:02
 * @Description:
 */

import com.ruoyi.common.utils.StringUtils;

/**
 * 坐席访客对话状态
 */
public enum AgentUserStatusEnum {
    INSERVICE,
    INQUENE,
    END;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }

    public static AgentUserStatusEnum toValue(final String str) {
        for (final AgentUserStatusEnum item : values()) {
            if (StringUtils.equalsIgnoreCase(item.toString(), str)) {
                return item;
            }
        }
        throw new IllegalArgumentException();
    }
}