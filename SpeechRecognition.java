//package com.praveen.azureopenai;
//
//import com.microsoft.cognitiveservices.speech.*;
//import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
//
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.Future;
//
//public class SpeechRecognition {
//    // Define the speech key and region directly in the code
//    private static final String SPEECH_KEY = "9f2a31f2b94c415dabeb15c79dd46f19";
//    private static final String SPEECH_REGION = "eastus";
//    private static final String LANGUAGE = "en-US"; // Telugu (India),
//
//    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        SpeechConfig speechConfig = SpeechConfig.fromSubscription(SPEECH_KEY, SPEECH_REGION);
//        speechConfig.setSpeechRecognitionLanguage(LANGUAGE);
//        recognizeFromMicrophone(speechConfig);
//    }
//
//    public static void recognizeFromMicrophone(SpeechConfig speechConfig) throws InterruptedException, ExecutionException {
//        AudioConfig audioConfig = AudioConfig.fromDefaultMicrophoneInput();
//        SpeechRecognizer speechRecognizer = new SpeechRecognizer(speechConfig, audioConfig);
//
//        System.out.println("Speak into your microphone.");
//        Future<SpeechRecognitionResult> task = speechRecognizer.recognizeOnceAsync();
//        SpeechRecognitionResult speechRecognitionResult = task.get();
//
//        if (speechRecognitionResult.getReason() == ResultReason.RecognizedSpeech) {
//            System.out.println("RECOGNIZED: Text=" + speechRecognitionResult.getText());
//        } else if (speechRecognitionResult.getReason() == ResultReason.NoMatch) {
//            System.out.println("NOMATCH: Speech could not be recognized.");
//        } else if (speechRecognitionResult.getReason() == ResultReason.Canceled) {
//            CancellationDetails cancellation = CancellationDetails.fromResult(speechRecognitionResult);
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