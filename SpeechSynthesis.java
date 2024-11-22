//package com.praveen.azureopenai;
//
//import com.microsoft.cognitiveservices.speech.*;
//import com.microsoft.cognitiveservices.speech.audio.*;
//
//import java.util.Scanner;
//import java.util.concurrent.ExecutionException;
//
//public class SpeechSynthesis {
//    // Define the speech key and region directly in the code
//    private static final String SPEECH_KEY = "9f2a31f2b94c415dabeb15c79dd46f19";
//    private static final String SPEECH_REGION = "eastus";
//    // Define the language
//    private static final String LANGUAGE = "te-IN"; // Telugu (India)
//
//    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        SpeechConfig speechConfig = SpeechConfig.fromSubscription(SPEECH_KEY, SPEECH_REGION);
//        speechConfig.setSpeechSynthesisVoiceName("te-IN-MohanNeural"); // Telugu (India) voice
//
//        SpeechSynthesizer speechSynthesizer = new SpeechSynthesizer(speechConfig);
//
//        // Get text from the console and synthesize to the default speaker.
//        System.out.println("Enter some text that you want to speak >");
//        String text = new Scanner(System.in).nextLine();
//        if (text.isEmpty()) {
//            return;
//        }
//
//        SpeechSynthesisResult speechSynthesisResult = speechSynthesizer.SpeakTextAsync(text).get();
//
//        if (speechSynthesisResult.getReason() == ResultReason.SynthesizingAudioCompleted) {
//            System.out.println("Speech synthesized to speaker for text [" + text + "]");
//        } else if (speechSynthesisResult.getReason() == ResultReason.Canceled) {
//            SpeechSynthesisCancellationDetails cancellation = SpeechSynthesisCancellationDetails.fromResult(speechSynthesisResult);
//            System.out.println("CANCELED: Reason=" + cancellation.getReason());
//
//            if (cancellation.getReason() == CancellationReason.Error) {
//                System.out.println("CANCELED: ErrorCode=" + cancellation.getErrorCode());
//                System.out.println("CANCELED: ErrorDetails=" + cancellation.getErrorDetails());
//                System.out.println("CANCELED: Did you set the speech resource key and region values?");
//            }
//        }
//
//        System.exit(0);
//    }
//}