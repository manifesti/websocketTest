package com.manifesti.websocketTest.Repositories;


import com.manifesti.websocketTest.Beans.EchoResponse;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<EchoResponse, Long> {


}
