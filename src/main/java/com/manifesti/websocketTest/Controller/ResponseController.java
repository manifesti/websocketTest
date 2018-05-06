/**
 * 
 */
package com.manifesti.websocketTest.Controller;


import com.manifesti.websocketTest.Beans.EchoResponse;
import com.manifesti.websocketTest.Services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;


/**
 * @author manifest
 *
 */
@Controller
public class ResponseController {

	@Autowired
	SimpMessagingTemplate template;

	@Autowired
	MessageService messageService;

	@MessageMapping("/hello")
	public EchoResponse echoresponse(EchoResponse echoresponse) throws Exception {

		echoresponse.setMessage(HtmlUtils.htmlEscape(echoresponse.getMessage()));
		echoresponse.setUsername(HtmlUtils.htmlEscape(echoresponse.getUsername()));

		template.convertAndSend("/topic/greetings", echoresponse);
		messageService.save(echoresponse);

		return echoresponse;
	}
}
