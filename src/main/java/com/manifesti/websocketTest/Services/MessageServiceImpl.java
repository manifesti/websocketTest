package com.manifesti.websocketTest.Services;

import com.manifesti.websocketTest.Beans.EchoResponse;
import com.manifesti.websocketTest.Repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements  MessageService {

    @Autowired
    MessageRepository repository;

    @Override
    public void save(EchoResponse echoResponse) {

        repository.save(echoResponse);

    }
    public Iterable<EchoResponse> findAll() {
        return repository.findAll();
    }

}
