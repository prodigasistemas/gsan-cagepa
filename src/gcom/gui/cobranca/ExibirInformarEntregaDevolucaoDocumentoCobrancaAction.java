/*
 * Copyright (C) 2007-2007 the GSAN � Sistema Integrado de Gest�o de Servi�os de Saneamento
 *
 * This file is part of GSAN, an integrated service management system for Sanitation
 *
 * GSAN is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License.
 *
 * GSAN is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place � Suite 330, Boston, MA 02111-1307, USA
 */

/*
 * GSAN � Sistema Integrado de Gest�o de Servi�os de Saneamento
 * Copyright (C) <2007> 
 * Adriano Britto Siqueira
 * Alexandre Santos Cabral
 * Ana Carolina Alves Breda
 * Ana Maria Andrade Cavalcante
 * Aryed Lins de Ara�jo
 * Bruno Leonardo Rodrigues Barros
 * Carlos Elmano Rodrigues Ferreira
 * Cl�udio de Andrade Lira
 * Denys Guimar�es Guenes Tavares
 * Eduardo Breckenfeld da Rosa Borges
 * Fab�ola Gomes de Ara�jo
 * Fl�vio Leonardo Cavalcanti Cordeiro
 * Francisco do Nascimento J�nior
 * Homero Sampaio Cavalcanti
 * Ivan S�rgio da Silva J�nior
 * Jos� Edmar de Siqueira
 * Jos� Thiago Ten�rio Lopes
 * K�ssia Regina Silvestre de Albuquerque
 * Leonardo Luiz Vieira da Silva
 * M�rcio Roberto Batista da Silva
 * Maria de F�tima Sampaio Leite
 * Micaela Maria Coelho de Ara�jo
 * Nelson Mendon�a de Carvalho
 * Newton Morais e Silva
 * Pedro Alexandre Santos da Silva Filho
 * Rafael Corr�a Lima e Silva
 * Rafael Francisco Pinto
 * Rafael Koury Monteiro
 * Rafael Palermo de Ara�jo
 * Raphael Veras Rossiter
 * Roberto Sobreira Barbalho
 * Rodrigo Avellar Silveira
 * Rosana Carvalho Barbosa
 * S�vio Luiz de Andrade Cavalcante
 * Tai Mu Shih
 * Thiago Augusto Souza do Nascimento
 * Tiago Moreno Rodrigues
 * Vivianne Barbosa Sousa
 *
 * Este programa � software livre; voc� pode redistribu�-lo e/ou
 * modific�-lo sob os termos de Licen�a P�blica Geral GNU, conforme
 * publicada pela Free Software Foundation; vers�o 2 da
 * Licen�a.
 * Este programa � distribu�do na expectativa de ser �til, mas SEM
 * QUALQUER GARANTIA; sem mesmo a garantia impl�cita de
 * COMERCIALIZA��O ou de ADEQUA��O A QUALQUER PROP�SITO EM
 * PARTICULAR. Consulte a Licen�a P�blica Geral GNU para obter mais
 * detalhes.
 * Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU
 * junto com este programa; se n�o, escreva para Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
 * 02111-1307, USA.
 */

package gcom.gui.cobranca;

import gcom.cobranca.CobrancaAcao;
import gcom.cobranca.FiltroCobrancaAcao;
import gcom.cobranca.FiltroMotivoNaoEntregaDocumento;
import gcom.fachada.Fachada;
import gcom.faturamento.conta.MotivoNaoEntregaDocumento;
import gcom.gui.ActionServletException;
import gcom.gui.GcomAction;
import gcom.util.ConstantesSistema;
import gcom.util.Util;
import gcom.util.filtro.ParametroSimples;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * InformarEntregaDevolucaoDocumentoCobrancaActionForm
 * [UC3044] Informar Entrega/Devolu��o de Documentos de Cobran�a
 * 
 * @author Carlos Chrystian
 * @created 03 de Mar�o de 2012
 */

public class ExibirInformarEntregaDevolucaoDocumentoCobrancaAction
				extends GcomAction {

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		// Seta o retorno
		ActionForward retorno = actionMapping.findForward("exibirInformarEntregaDevolucaoDocumentoCobrancaAction");

		Fachada fachada = Fachada.getInstancia();

		HttpSession sessao = httpServletRequest.getSession(false);

		if(httpServletRequest.getParameter("limparForm") != null){
			String limparForm = httpServletRequest.getParameter("limparForm");
			httpServletRequest.setAttribute("limparForm", limparForm);
		}

		if(httpServletRequest.getParameter("idCampo") != null){
			String idCampo = (String) httpServletRequest.getParameter("idCampo");
			httpServletRequest.setAttribute("idCampo", idCampo);
		}

		// 2.2. Dados dos Documentos de Cobran�a
		// A��o de Cobran�a (obrigat�rio)
		FiltroCobrancaAcao filtroCobrancaAcao = new FiltroCobrancaAcao();

		filtroCobrancaAcao.adicionarParametro(new ParametroSimples(FiltroCobrancaAcao.INDICADOR_ENTREGA_DOCUMENTO,
						ConstantesSistema.INDICADOR_ENTREGA_DOCUMENTO));

		filtroCobrancaAcao
						.adicionarParametro(new ParametroSimples(FiltroCobrancaAcao.INDICADOR_USO, ConstantesSistema.INDICADOR_USO_ATIVO));

		filtroCobrancaAcao.setCampoOrderBy(FiltroCobrancaAcao.DESCRICAO);

		Collection colecaoCobrancaAcao = fachada.pesquisar(filtroCobrancaAcao, CobrancaAcao.class.getName());

		if(Util.isVazioOrNulo(colecaoCobrancaAcao)){
			throw new ActionServletException("atencao.entidade_sem_dados_para_selecao", null, "A��O DE COBRAN�A");
		}

		sessao.setAttribute("colecaoCobrancaAcao", colecaoCobrancaAcao);

		// Motivo da N�o Entrega
		FiltroMotivoNaoEntregaDocumento filtroMotivoNaoEntrega = new FiltroMotivoNaoEntregaDocumento();

		filtroMotivoNaoEntrega.adicionarParametro(new ParametroSimples(FiltroMotivoNaoEntregaDocumento.INDICADOR_USO,
						ConstantesSistema.INDICADOR_USO_ATIVO));

		filtroMotivoNaoEntrega.setCampoOrderBy(FiltroMotivoNaoEntregaDocumento.DESCRICAO);

		Collection colecaoMotivosNaoEntrega = fachada.pesquisar(filtroMotivoNaoEntrega, MotivoNaoEntregaDocumento.class.getName());

		if(Util.isVazioOrNulo(colecaoMotivosNaoEntrega)){
			throw new ActionServletException("atencao.entidade_sem_dados_para_selecao", null, "MOTIVOS DE N�O ENTREGA DE DOCUMENTO");
		}

		sessao.setAttribute("colecaoMotivosNaoEntrega", colecaoMotivosNaoEntrega);

		String idCampoMatriculaImovel = (String) httpServletRequest.getParameter("idCampoMatriculaImovel");

		httpServletRequest.setAttribute("idCampoMatriculaImovel", idCampoMatriculaImovel);

		return retorno;
	}

}
