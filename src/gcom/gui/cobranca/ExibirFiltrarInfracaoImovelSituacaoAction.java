
package gcom.gui.cobranca;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import gcom.gui.GcomAction;

/**
 * @author anishimura
 * @date fevereiro/2011
 */
public class ExibirFiltrarInfracaoImovelSituacaoAction
				extends GcomAction {

	/**
	 * @date fevereiro/2011
	 */
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		ActionForward retorno = actionMapping.findForward("exibirFiltrarInfracaoImovelSituacao");

		return retorno;
	}
}
