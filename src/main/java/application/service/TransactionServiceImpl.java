package application.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import application.domain.Transaction;

@Service
@EnableJms
public class TransactionServiceImpl implements TransactionService {
	
	private static Log log = LogFactory.getLog(TransactionServiceImpl.class);

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Override
	public void sendTransaction(Transaction transaction) {
		try {
			if (log.isDebugEnabled())
        		log.debug("sendTransaction demo : " + transaction);
			jmsTemplate.convertAndSend("DEV.QUEUE.1", transaction);
			
		} catch(JmsException ex) {
			ex.printStackTrace();
			
		}
	}

}
