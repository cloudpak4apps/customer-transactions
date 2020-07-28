package application.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import application.domain.Transaction;
import application.service.TransactionService;

@RestController
public class TransactionRestController {

	private static Log log = LogFactory.getLog(TransactionRestController.class);
	
	@Autowired
	private TransactionService service;
	
	@PostMapping("transaction")
	String sendTransaction(@RequestBody Transaction transaction) {
		if (log.isDebugEnabled())
    		log.debug("send transaction controller: " + transaction);
		
		service.sendTransaction(transaction);
		
		return "OK";
		
	}
}
