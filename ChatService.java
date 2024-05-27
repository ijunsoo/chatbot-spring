package com.example.account.service;

import java.util.List;
import java.util.Optional;

import com.example.account.models.Chat;
import com.example.account.repository.ChatRepository;
import com.example.account.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
;

@Service
public class ChatService implements IChatService{

    @Autowired
    ChatRepository chatRepository;


    @Override
    public Chat addChat(Chat c) {
        chatRepository.save(c);
        return c;
    }

    @Override
    public void deleteChat(Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public Chat updateChat(Chat c) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Chat retrieveChat(Long id) {
        // TODO Auto-generated method stub

        return null;
    }

}