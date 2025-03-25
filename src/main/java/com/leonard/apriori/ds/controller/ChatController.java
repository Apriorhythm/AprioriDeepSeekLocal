package com.leonard.apriori.ds.controller;

import com.leonard.apriori.ds.entity.ChatEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.AbstractChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.*;

/**
 * @author Apriorhythm
 * @version 1.0
 * @date 2025-03-25
 */
@Slf4j
@RestController
@RequestMapping("/ai")
public class ChatController {

    private final ChatClient chatClient;

    private final ChatMemory chatMemory;

    public ChatController(ChatClient.Builder builder, ChatMemory chatMemory) {
        this.chatClient = builder
                .defaultSystem("You are a helpful assistant.")
                .defaultAdvisors(new MessageChatMemoryAdvisor(chatMemory))
                .build();
        this.chatMemory = chatMemory;
    }

    @PostMapping(value = "/ollama/ds/chat")
    public String chat(@RequestBody ChatEntity chatEntity) {
        log.info("[4ff3f1223eea44d5bdd415153bc7574d]-[/ollama/ds/chat]-[{}]", chatEntity);

        String text = chatClient.prompt()
                .user(chatEntity.getText())
                .advisors(spec -> spec.param(AbstractChatMemoryAdvisor.CHAT_MEMORY_CONVERSATION_ID_KEY, chatEntity.getChatId())
                        .param(AbstractChatMemoryAdvisor.CHAT_MEMORY_RETRIEVE_SIZE_KEY, 100))
                .call()
                .content();

        return text.split("</think>")[1].trim();
    }
}