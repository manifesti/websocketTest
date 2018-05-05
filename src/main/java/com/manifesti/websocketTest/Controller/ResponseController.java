/**
 * 
 */
package com.manifesti.websocketTest.Controller;


import com.manifesti.websocketTest.Beans.EchoResponse;
import com.manifesti.websocketTest.Services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;


/**
 * @author manifest
 *
 */
@Controller
public class ResponseController {

	@Autowired
	MessageService messageService;

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public EchoResponse echoresponse(EchoResponse echoresponse) throws Exception {

		messageService.save(echoresponse);


		return new EchoResponse(
			HtmlUtils.htmlEscape(echoresponse.getUsername()), 
			HtmlUtils.htmlEscape(echoresponse.getMessage())
		);
	}
}
