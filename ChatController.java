package com.example.account.controller;


import com.example.account.domain.ChatConfig;
import com.example.account.models.Chat;
import com.example.account.service.IChatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    IChatService chatService;


    @CrossOrigin
    @PostMapping("/send-msg")
    @ResponseBody
    public String sendMessage(@RequestBody Chat msg) throws FileNotFoundException, IOException  {
        File file = new File("src/main/resources/test-iwdw-e3b736d87722.json");
        String CREDENTIAL_FILE = file.getAbsolutePath();
        String PROJECT_ID = "test-iwdw";
        ChatConfig client = new ChatConfig(CREDENTIAL_FILE, PROJECT_ID);
        String sessionId = UUID.randomUUID().toString();
        Chat chat = new Chat(msg.getMessageSent(), client.request(sessionId,msg.getMessageSent()));
        chatService.addChat(chat);
        return client.request(sessionId, msg.getMessageSent());
    }



}
