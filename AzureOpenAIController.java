package com.praveen.azureopenai;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.image.ImageResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/openai")
public class AzureOpenAIController {

    private final ChatService chatService;
    private final ImageService imageService;
    private final RecipeService recipeService;

    public AzureOpenAIController(ChatService chatService, ImageService imageService, RecipeService recipeService) {
        this.chatService = chatService;
        this.imageService = imageService;
        this.recipeService = recipeService;

    }

    @GetMapping("chat")
    public String chat() {
        return chatService.getResponse("Hello I'm PraveenChalla, You are being used in a demo.");
    }

    @GetMapping("ask-ai")
    public String getResponse(@RequestParam String prompt) {
        return chatService.getResponse(prompt);
    }

    @GetMapping("ask-ai-options")
    public String getResponseOptions(@RequestParam String prompt) {
        return chatService.getResponseOptions(prompt);
    }

    @GetMapping("generate-image")
    public void generateImages(HttpServletResponse response, @RequestParam String prompt) throws IOException {
        ImageResponse imageResponse = imageService.generateImage(prompt);
        String imageurl =  imageResponse.getResult().getOutput().getUrl();
        response.sendRedirect(imageurl);
    }
    @GetMapping("generate-images")
    public List<String> generateImagesOptional(HttpServletResponse response, @RequestParam String prompt,@RequestParam(defaultValue = "hd") String quality, @RequestParam(defaultValue = "1") int n,
                                               @RequestParam (defaultValue = "1024")int width,
                                               @RequestParam(defaultValue = "1024") int height
                                               ) throws IOException {
        ImageResponse imageResponse = imageService.generateImageOptions(prompt,quality,n,width,height);
       //stream to get urls from ImagesResponse
        List<String> imageUrls = imageResponse.getResults().stream()
                .map(result -> result.getOutput().getUrl())
                .toList();
        return imageUrls;
    }

    @GetMapping("recipe-creator")
    public String recipeCreator(@RequestParam String ingredients,@RequestParam(defaultValue = "any") String cuisine,@RequestParam(defaultValue = "") String dietaryRestrictions)  {
        return recipeService.createRecipe(ingredients,cuisine,dietaryRestrictions);

    }


}
