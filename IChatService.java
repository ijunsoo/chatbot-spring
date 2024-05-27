package com.example.account.service;

import com.example.account.models.Chat;

import java.util.List;



public interface IChatService {



    Chat addChat(Chat c);

    void deleteChat(Long id);

    Chat updateChat(Chat c);

    Chat retrieveChat(Long id);

}