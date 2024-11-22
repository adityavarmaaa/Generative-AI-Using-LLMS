package com.praveen.azureopenai;

import org.springframework.ai.azure.openai.AzureOpenAiChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.azure.openai.AzureOpenAiChatOptions;
import org.springframework.stereotype.Service;

@Service
public class ChatService{
    private final AzureOpenAiChatModel chatModel;

    public ChatService(AzureOpenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String getResponse(String promptText) {
        Prompt prompt = new Prompt(promptText);
        ChatResponse response = chatModel.call(prompt);
        return response.getResults().get(0).getOutput().getContent();
        // Assuming getText() method exists
    }

    public String getResponseOptions(String prompt) {
        ChatResponse response = chatModel.call(
         new Prompt(
                prompt,
                 AzureOpenAiChatOptions.builder()
                         .withDeploymentName("chatapplication") // Correct deployment name
                         .withTemperature(0.4)
                         .withMaxTokens(200)
                         .build()
        ));
        return response.getResults().get(0).getOutput().getContent(); // Assuming getText() method exists
    }
}