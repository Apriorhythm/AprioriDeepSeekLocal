package com.leonard.apriori.ds.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Apriorhythm
 * @version 1.0
 * @date 2025-03-25
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChatEntity implements Serializable {

    /**
     * 对话ID
     */
    private String chatId;

    /**
     * 消息类型
     */
    private String type;

    /**
     * 消息文本
     */
    private String text;

    /**
     * 调用时间
     */
    private String time;
}
