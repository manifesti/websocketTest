/**
 * 
 */
package com.manifesti.websocketTest;


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
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public EchoResponse echoresponse(EchoResponse echoresponse) throws Exception {
		return new EchoResponse(
			HtmlUtils.htmlEscape(echoresponse.getUsername()), 
			HtmlUtils.htmlEscape(echoresponse.getMessage())
		);
	}
}
