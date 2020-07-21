package application;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableJms
public class Main {

	private static Log log = LogFactory.getLog(Main.class);

	@Autowired
	private JmsTemplate jmsTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@GetMapping("send")
	String send() {
		try {
			if (log.isDebugEnabled())
        		log.debug("send hello world");
			jmsTemplate.convertAndSend("DEV.QUEUE.1", "Message from Cloud Pak 4 Applications...");
			return "OK";
		} catch(JmsException ex) {
			ex.printStackTrace();
			return "FAIL";
		}
	}

	@GetMapping("recv")
	String recv() {
		try {
			return jmsTemplate.receiveAndConvert("DEV.QUEUE.1").toString();
		} catch(JmsException ex) {
			ex.printStackTrace();
			return "FAIL";
		}
	}
}
