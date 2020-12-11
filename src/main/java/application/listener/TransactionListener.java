package application.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import application.domain.Transaction;

@Component
public class TransactionListener {
	private static Log log = LogFactory.getLog(TransactionListener.class);
	
	@JmsListener(destination = "DEV.QUEUE.1")
	public void receiveTransaction(Transaction transaction) {
		if (log.isDebugEnabled())
			log.debug("Transaction: " + transaction);
		System.out.println("Transaction: " + transaction);
	}
	
}
