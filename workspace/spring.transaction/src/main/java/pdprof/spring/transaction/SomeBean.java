package pdprof.spring.transaction;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.jta.WebSphereUowTransactionManager;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class SomeBean {

	WebSphereUowTransactionManager transactionManager;

	public WebSphereUowTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(WebSphereUowTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	@Transactional
	public void testAnnotation() {
		System.out.println("Some testAnnotation()");
	}
	
	public void test() {

		try {
			DefaultTransactionDefinition def = new DefaultTransactionDefinition();
			def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
			TransactionStatus status = transactionManager.getTransaction(def);
			System.out.println("Is the transaction new ? " + status.isNewTransaction());
			transactionManager.commit(status);

		} catch (TransactionException e)

		{
			e.printStackTrace();
		}

		System.out.println("Some test()");

	}

}
