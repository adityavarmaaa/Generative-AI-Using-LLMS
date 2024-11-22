package com.praveen.azureopenai;
import org.springframework.ai.azure.openai.AzureOpenAiChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RecipeService {
    private final AzureOpenAiChatModel chatModel;

    public RecipeService(AzureOpenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }
    public String createRecipe(String Ingredients,String cuisine,String dietaryRestrictions){
        var template = """
                I want to create a recipe using the following ingredients:{ingredients}.
                 The cuisine type I prefered is {cuisine}.
                 PLease consider the following dietary restrictions:{dietaryRestrictions}.
                 Please provide me with a detailed recipe including title, list of ingredients, and cooking Instructions
                """;
        PromptTemplate promptTemplate = new PromptTemplate(template);
        Map<String ,Object> params = Map.of(
                "ingredients",Ingredients,
                "cuisine",cuisine,
                "dietaryRestrictions",dietaryRestrictions
        );
        Prompt prompt = promptTemplate.create(params);
        return chatModel.call(prompt).getResult().getOutput().getContent();
    }

}

