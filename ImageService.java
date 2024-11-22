package com.praveen.azureopenai;

import org.springframework.ai.azure.openai.AzureOpenAiImageModel;
import org.springframework.ai.azure.openai.AzureOpenAiImageOptions;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    private final AzureOpenAiImageModel azureOpenAiImageModel;

    public ImageService(AzureOpenAiImageModel azureOpenAiImageModel) {
        this.azureOpenAiImageModel = azureOpenAiImageModel;
    }
    public ImageResponse generateImage(String prompt) {
        ImagePrompt Prompt = new ImagePrompt(prompt);
        ImageResponse response = azureOpenAiImageModel.call(Prompt);
        return response;
    }

    public ImageResponse generateImageOptions(String prompt,String quality , int n,int width,int height ) {
        ImageResponse imageResponse = azureOpenAiImageModel.call(
                new ImagePrompt(
                        prompt,
                        AzureOpenAiImageOptions.builder()
                                .withModel("dall-e-2")
                                .withUser(quality)
                                .withN(n)
                                .withHeight(height)
                                .withWidth(width)
                                .build()
                )
        );
        return imageResponse;
    }
}