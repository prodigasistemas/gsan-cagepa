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

package gcom.gui.atendimentopublico.ordemservico;

import gcom.atendimentopublico.ordemservico.Atividade;
import gcom.atendimentopublico.ordemservico.FiltroAtividade;
import gcom.fachada.Fachada;
import gcom.gui.ActionServletException;
import gcom.gui.GcomAction;
import gcom.util.ConstantesSistema;
import gcom.util.filtro.ComparacaoTexto;
import gcom.util.filtro.ComparacaoTextoCompleto;
import gcom.util.filtro.ParametroSimples;
import java.util.Collection;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * [UC0438] Pesquisar Atividade
 * 
 * @author Ana Maria
 * @date 03/08/2006
 */
public class PesquisarAtividadeAction
				extends GcomAction {

	/**
	 * [UC0438] Esse caso de uso efetua pesquisa de Atividade
	 * 
	 * @author Ana Maria
	 * @date 03/08/2006
	 * @param actionMapping
	 * @param actionForm
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		ActionForward retorno = actionMapping.findForward("listaAtividade");

		// Obt�m a inst�ncia da Fachada
		Fachada fachada = Fachada.getInstancia();

		// HttpSession sessao = httpServletRequest.getSession(false);

		// Obt�m o action form
		PesquisarAtividadeActionForm pesquisarAtividadeActionForm = (PesquisarAtividadeActionForm) actionForm;

		// Recupera os par�metros do form
		String idAtividade = (String) pesquisarAtividadeActionForm.getIdAtividade();
		String descricaoAtividade = (String) pesquisarAtividadeActionForm.getDescricaoAtividade();
		String abreviaturaAtividade = (String) pesquisarAtividadeActionForm.getAbreviaturaAtividade();
		String tipoPesquisa = (String) pesquisarAtividadeActionForm.getTipoPesquisa();
		String tipoPesquisaAbreviada = (String) pesquisarAtividadeActionForm.getTipoPesquisaAbreviada();

		boolean peloMenosUmParametroInformado = false;

		FiltroAtividade filtroAtividade = new FiltroAtividade(FiltroAtividade.DESCRICAO);

		if(idAtividade != null && !idAtividade.trim().equalsIgnoreCase("")){
			filtroAtividade.adicionarParametro(new ParametroSimples(FiltroAtividade.ID, new Integer(idAtividade)));
			peloMenosUmParametroInformado = true;
		}

		if(descricaoAtividade != null && !descricaoAtividade.trim().equalsIgnoreCase("")){
			peloMenosUmParametroInformado = true;
			if(tipoPesquisa != null && tipoPesquisa.equals(ConstantesSistema.TIPO_PESQUISA_COMPLETA.toString())){
				filtroAtividade.adicionarParametro(new ComparacaoTextoCompleto(FiltroAtividade.DESCRICAO, descricaoAtividade));
			}else{
				filtroAtividade.adicionarParametro(new ComparacaoTexto(FiltroAtividade.DESCRICAO, descricaoAtividade));
			}
		}

		if(abreviaturaAtividade != null && !abreviaturaAtividade.trim().equalsIgnoreCase("")){
			peloMenosUmParametroInformado = true;
			if(tipoPesquisaAbreviada != null && tipoPesquisaAbreviada.equals(ConstantesSistema.TIPO_PESQUISA_COMPLETA.toString())){
				filtroAtividade.adicionarParametro(new ComparacaoTextoCompleto(FiltroAtividade.DESCRICAOABREVIADA, abreviaturaAtividade));
			}else{
				filtroAtividade.adicionarParametro(new ComparacaoTexto(FiltroAtividade.DESCRICAOABREVIADA, abreviaturaAtividade));
			}
		}
		// Erro caso o usu�rio mandou filtrar sem nenhum par�metro
		if(!peloMenosUmParametroInformado){
			throw new ActionServletException("atencao.filtro.nenhum_parametro_informado");
		}

		filtroAtividade.adicionarParametro(new ParametroSimples(FiltroAtividade.INDICADORUSO, ConstantesSistema.INDICADOR_USO_ATIVO));

		filtroAtividade.adicionarParametro(new ParametroSimples(FiltroAtividade.INDICADORATIVIDADEUNICA,
						Atividade.INDICADOR_ATIVIDADE_UNICA_NAO));

		// Faz a pesquisa baseada no filtro
		Collection atividades = fachada.pesquisar(filtroAtividade, Atividade.class.getName());

		// Verificar se a pesquisa de atividade n�o est� vazia
		if(atividades != null && !atividades.isEmpty()){
			// Aciona o controle de pagina��o para que sejam pesquisados apenas
			// os registros que aparecem na p�gina
			Map resultado = controlarPaginacao(httpServletRequest, retorno, filtroAtividade, Atividade.class.getName());
			atividades = (Collection) resultado.get("colecaoRetorno");
			retorno = (ActionForward) resultado.get("destinoActionForward");

			// sessao.setAttribute("atividades", atividades);
			// Manda a cole��o das Atividade pesquisadas para o request
			httpServletRequest.getSession(false).setAttribute("atividades", atividades);

		}else{
			throw new ActionServletException("atencao.pesquisa.nenhumresultado", null, "atividade");
		}

		return retorno;
	}

}
