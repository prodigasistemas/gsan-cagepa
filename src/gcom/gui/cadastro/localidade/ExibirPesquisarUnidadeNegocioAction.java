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

package gcom.gui.cadastro.localidade;

import gcom.cadastro.localidade.FiltroLocalidade;
import gcom.cadastro.localidade.Localidade;
import gcom.fachada.Fachada;
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
 * Action que define o pr�-processamento da p�gina de pesquisa unidade de neg�cio
 * 
 * @author Diogo Monteiro
 * @created 10/07/2012
 */
public class ExibirPesquisarUnidadeNegocioAction
				extends GcomAction {

	/**
	 * Description of the Method
	 * 
	 * @param actionMapping
	 *            Description of the Parameter
	 * @param actionForm
	 *            Description of the Parameter
	 * @param httpServletRequest
	 *            Description of the Parameter
	 * @param httpServletResponse
	 *            Description of the Parameter
	 * @return Description of the Return Value
	 */
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		// Seta o mapeamento de retorno
		ActionForward retorno = actionMapping.findForward("exibirPesquisarUnidadeNegocio");

		// Mudar isso quando tiver esquema de seguran�a
		HttpSession sessao = httpServletRequest.getSession(false);

		PesquisarUnidadeNegocioActionForm pesquisarUnidadeNegocioActionForm = (PesquisarUnidadeNegocioActionForm) actionForm;

		// Flag indicando que o usu�rio fez uma consulta a partir da tecla Enter
		String objetoConsulta = httpServletRequest.getParameter("objetoConsulta");

		if(objetoConsulta != null && !objetoConsulta.trim().equals("") && objetoConsulta.trim().equals("1")){

			// Faz a consulta de Localidade
			pesquisarLocalidade(httpServletRequest, retorno, pesquisarUnidadeNegocioActionForm);

		}

		// Identificar se � uma unidade de origem ou destino para saber que campo retornar
		String campoUnidade = httpServletRequest.getParameter("campoUnidade");

		if(!Util.isVazioOuBranco(campoUnidade)){
			sessao.setAttribute("campoUnidade", campoUnidade);
		}

		if(httpServletRequest.getParameter("tipo") != null){
			sessao.setAttribute("caminhoRetornoTelaPesquisaUnidadeNegocio", httpServletRequest.getParameter("tipo"));
		}else{
			if(httpServletRequest.getParameter("caminhoRetornoTelaPesquisaUnidadeNegocio") != null){
				sessao.setAttribute("caminhoRetornoTelaPesquisaUnidadeNegocio", httpServletRequest
								.getParameter("caminhoRetornoTelaPesquisaUnidadeNegocio"));
			}
		}

		if(httpServletRequest.getParameter("tipoConsulta") != null && !httpServletRequest.getParameter("tipoConsulta").equals("")){

			if(httpServletRequest.getParameter("tipoConsulta").equals("localidade")){

				pesquisarUnidadeNegocioActionForm.setIdLocalidade(httpServletRequest.getParameter("idCampoEnviarDados"));

				pesquisarUnidadeNegocioActionForm.setDescricaoLocalidade(httpServletRequest.getParameter("descricaoCampoEnviarDados"));

				httpServletRequest.setAttribute("idLocalidadeEncontrada", "true");

			}

		}

		if(httpServletRequest.getParameter("limpaForm") != null){
			pesquisarUnidadeNegocioActionForm.setIdLocalidade("");
			pesquisarUnidadeNegocioActionForm.setDescricaoLocalidade("");
			pesquisarUnidadeNegocioActionForm.setDescricao("");
			pesquisarUnidadeNegocioActionForm.setIdUnidade("");
		}

		this.setaRequest(httpServletRequest, pesquisarUnidadeNegocioActionForm);

		if(pesquisarUnidadeNegocioActionForm.getTipoPesquisa() == null){
			pesquisarUnidadeNegocioActionForm.setTipoPesquisa(ConstantesSistema.TIPO_PESQUISA_INICIAL.toString());
		}

		return retorno;
	}

	private void pesquisarLocalidade(HttpServletRequest httpServletRequest, ActionForward retorno,
					PesquisarUnidadeNegocioActionForm pesquisarUnidadeNegocioActionForm){

		// Filtro para obter o localidade ativo de id informado
		FiltroLocalidade filtroLocalidade = new FiltroLocalidade();

		filtroLocalidade.adicionarParametro(new ParametroSimples(FiltroLocalidade.ID, new Integer(pesquisarUnidadeNegocioActionForm
						.getIdLocalidade())));

		// Pesquisa de acordo com os par�metros informados no filtro
		Collection colecaoLocalidade = Fachada.getInstancia().pesquisar(filtroLocalidade, Localidade.class.getName());

		// Verifica se a pesquisa retornou algum objeto para a cole��o
		if(colecaoLocalidade != null && !colecaoLocalidade.isEmpty()){

			// Obt�m o objeto da cole��o pesquisada
			Localidade localidade = (Localidade) Util.retonarObjetoDeColecao(colecaoLocalidade);

			// Exibe o c�digo e a descri��o pesquisa na p�gina
			httpServletRequest.setAttribute("idLocalidadeEncontrada", "true");

			pesquisarUnidadeNegocioActionForm.setIdLocalidade(localidade.getId().toString());
			pesquisarUnidadeNegocioActionForm.setDescricaoLocalidade(localidade.getDescricao());

		}else{

			pesquisarUnidadeNegocioActionForm.setDescricaoLocalidade("Localidade inexistente");
			pesquisarUnidadeNegocioActionForm.setIdLocalidade("");

		}
	}

	/**
	 * Seta os request com os id encontrados
	 * 
	 * @author Diogo Monteiro
	 * @date 10/07/2012
	 */
	private void setaRequest(HttpServletRequest httpServletRequest, PesquisarUnidadeNegocioActionForm pesquisarUnidadeNegocioActionForm){

		// Localidade
		if(pesquisarUnidadeNegocioActionForm.getIdLocalidade() != null && !pesquisarUnidadeNegocioActionForm.getIdLocalidade().equals("")
						&& pesquisarUnidadeNegocioActionForm.getDescricaoLocalidade() != null
						&& !pesquisarUnidadeNegocioActionForm.getDescricaoLocalidade().equals("")){

			httpServletRequest.setAttribute("idLocalidadeEncontrada", "true");
		}
	}

}
