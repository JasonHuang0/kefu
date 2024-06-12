package com.ruoyi.common.enums;

import com.ruoyi.common.utils.StringUtils;

/**
 * @Auther: jason
 * @Date: 12/6/2024 11:04
 * @Description:
 */
public enum AgentStatusEnum {
    READY("就绪", 1),
    NOTREADY("未就绪", 2),
    BUSY("置忙", 3),
    NOTBUSY("不忙", 4),
    IDLE("空闲", 5),
    OFFLINE("离线", 6),
    SERVICES("服务", 7),
    TEMPBUSY("临时置忙",8),
    TEMPNOTBUSY("临时不忙",9)
    ;

    private String name;
    private int index;

    AgentStatusEnum(final String name, final int index) {
        this.name = name;
        this.index = index;
    }

    public String zh() {
        return this.name;
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }

    public static AgentStatusEnum toValue(final String str) {
        for (final AgentStatusEnum item : values()) {
            if (StringUtils.equalsIgnoreCase(item.toString(), str)) {
                return item;
            }
        }
        throw new IllegalArgumentException();
    }

}