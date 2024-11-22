import React from "react";
import {useState} from "react";

function ChatComponent() {
    const [prompt,setPrompt] = useState('');
    const [chatResponse,setChatResponse] = useState('');
    const askAI = async() =>{
        try{
            const response = await fetch (` http://localhost:8080/openai/ask-ai?prompt=${prompt}`)
            const data = await response.text();
            console.log(data)
            setChatResponse(data);

        }catch(error){
            console.error("Error generating image : ",error)
        }

    }
    return (
        <div>
            <h2>Talk to AI</h2>
            <input
                type="text"
                value={prompt}
                onChange={(e) => setPrompt(e.target.value)}
                placeholder="Enter your prompt here..."
                />
            <button onClick={askAI}>ASk AI </button>

            <div className ="output">
                <p>{chatResponse}</p>

            </div>
        </div>
    );
}

export default  ChatComponent;