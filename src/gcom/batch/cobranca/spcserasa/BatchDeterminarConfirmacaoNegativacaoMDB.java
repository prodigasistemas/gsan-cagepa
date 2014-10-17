
package gcom.batch.cobranca.spcserasa;

import gcom.spcserasa.ControladorSpcSerasaLocal;
import gcom.spcserasa.ControladorSpcSerasaLocalHome;
import gcom.util.ConstantesJNDI;
import gcom.util.ControladorException;
import gcom.util.ServiceLocator;
import gcom.util.ServiceLocatorException;
import gcom.util.SistemaException;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.MessageDrivenBean;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

public class BatchDeterminarConfirmacaoNegativacaoMDB
				implements MessageDrivenBean, MessageListener {

	private static final long serialVersionUID = 1L;

	public BatchDeterminarConfirmacaoNegativacaoMDB() {

		super();
	}

	public void ejbRemove() throws EJBException{

		// TODO Auto-generated method stub

	}

	public void setMessageDrivenContext(MessageDrivenContext arg0) throws EJBException{

		// TODO Auto-generated method stub

	}

	public void onMessage(Message message){

		if(message instanceof ObjectMessage){

			try{
				ObjectMessage objectMessage = (ObjectMessage) message;

				System.out.println("....................Enviando mensagem para batch ");
				this.getControladorSpcSerasa().determinarConfirmacaoNegativacao((Integer) ((Object[]) objectMessage.getObject())[0]);

			}catch(ControladorException e){
				System.out.println("Erro no MDB");
				e.printStackTrace();
			}catch(JMSException e){
				System.out.println("Erro no MDB");
				e.printStackTrace();
			}
		}

	}

	/**
	 * Retorna a interface remota de ControladorSpcSerasa
	 * 
	 * @return A interface remota do controlador de par�metro
	 */
	private ControladorSpcSerasaLocal getControladorSpcSerasa(){

		ControladorSpcSerasaLocalHome localHome = null;
		ControladorSpcSerasaLocal local = null;

		// pega a inst�ncia do ServiceLocator.

		ServiceLocator locator = null;

		try{
			locator = ServiceLocator.getInstancia();

			localHome = (ControladorSpcSerasaLocalHome) locator.getLocalHome(ConstantesJNDI.CONTROLADOR_SPC_SERASA_SEJB);
			// guarda a referencia de um objeto capaz de fazer chamadas
			// objetos remotamente
			local = localHome.create();

			return local;
		}catch(CreateException e){
			throw new SistemaException(e);
		}catch(ServiceLocatorException e){
			throw new SistemaException(e);
		}
	}

	/**
	 * Default create method
	 * 
	 * @throws CreateException
	 */
	public void ejbCreate(){

	}

}
