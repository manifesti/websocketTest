package com.manifesti.websocketTest.Services;

import com.manifesti.websocketTest.Beans.EchoResponse;
import org.springframework.stereotype.Service;

public interface MessageService {
    void save(EchoResponse echoResponse);
}
