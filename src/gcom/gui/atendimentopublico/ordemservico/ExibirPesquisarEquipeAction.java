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

import gcom.atendimentopublico.ordemservico.Equipe;
import gcom.atendimentopublico.ordemservico.FiltroEquipe;
import gcom.atendimentopublico.ordemservico.FiltroServicoPerfilTipo;
import gcom.atendimentopublico.ordemservico.ServicoPerfilTipo;
import gcom.cadastro.unidade.FiltroUnidadeOrganizacional;
import gcom.cadastro.unidade.UnidadeOrganizacional;
import gcom.fachada.Fachada;
import gcom.gui.ActionServletException;
import gcom.gui.GcomAction;
import gcom.util.filtro.ParametroSimples;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Exibe a pesquisa de equipe
 * 
 * @author Leonardo Regis
 * @date 31/07/2006
 */
public class ExibirPesquisarEquipeAction
				extends GcomAction {

	/**
	 * Efetua pesquisa de equipe
	 * [UC0377] Pesquisar Equipe
	 * 
	 * @author Leonardo Regis
	 * @date 31/07/2006
	 * @param actionMapping
	 * @param actionForm
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 */
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		HttpSession sessao = httpServletRequest.getSession(false);

		PesquisarEquipeActionForm pesquisarEquipeActionForm = (PesquisarEquipeActionForm) actionForm;

		ActionForward retorno = actionMapping.findForward("equipePesquisar");

		Fachada fachada = Fachada.getInstancia();
		// Filtro Unidade Organizacional
		if(pesquisarEquipeActionForm.getUnidadeOrganizacionalId() != null
						&& !pesquisarEquipeActionForm.getUnidadeOrganizacionalId().trim().equals("")){
			getUnidadeOrganizacional(pesquisarEquipeActionForm, fachada);
		}
		// Filtro Tipo Perfil
		if(pesquisarEquipeActionForm.getTipoPerfilServicoId() != null
						&& !pesquisarEquipeActionForm.getTipoPerfilServicoId().trim().equals("")){
			getTipoPerfilServico(pesquisarEquipeActionForm, fachada);
		}
		// Equipe
		FiltroEquipe filtroEquipe = new FiltroEquipe();
		Collection<Equipe> colecaoEquipe = fachada.pesquisar(filtroEquipe, Equipe.class.getName());
		if(colecaoEquipe == null || colecaoEquipe.isEmpty()){
			throw new ActionServletException("atencao.entidade_sem_dados_para_selecao", null, "Equipe");
		}
		httpServletRequest.setAttribute("colecaoEquipe", colecaoEquipe);

		if(httpServletRequest.getParameter("caminhoRetornoTelaPesquisa") != null){
			sessao.setAttribute("caminhoRetornoTelaPesquisaEquipe", httpServletRequest.getParameter("caminhoRetornoTelaPesquisa"));
		}

		if(httpServletRequest.getParameter("tipoConsulta") != null){
			String tipoConsulta = httpServletRequest.getParameter("tipoConsulta");
			String idCampo = httpServletRequest.getParameter("idCampoEnviarDados");
			String descricaoCampo = httpServletRequest.getParameter("descricaoCampoEnviarDados");

			if(tipoConsulta.equals("unidadeOrganizacional")){
				pesquisarEquipeActionForm.setUnidadeOrganizacionalId(idCampo);
				pesquisarEquipeActionForm.setUnidadeOrganizacionalDescricao(descricaoCampo);

			}else if(tipoConsulta.equals("servicoPerfilTipo")){
				pesquisarEquipeActionForm.setTipoPerfilServicoId(idCampo);
				pesquisarEquipeActionForm.setTipoPerfilServicoDescricao(descricaoCampo);
			}
		}

		sessao.setAttribute("caminhoRetornoTelaPesquisaEquipe", httpServletRequest.getParameter("caminhoRetornoTelaPesquisa"));

		return retorno;
	}

	/**
	 * Recupera Tipo Perfil Servi�o
	 * 
	 * @author Leonardo Regis
	 * @date 01/08/2006
	 * @param pesquisarEquipeActionForm
	 * @param equipeComponentes
	 */
	private void getTipoPerfilServico(PesquisarEquipeActionForm pesquisarEquipeActionForm, Fachada fachada){

		// [F0002] Valida Tipo Perfil Servi�o
		if(isValidateTipoPerfilServico(pesquisarEquipeActionForm)){
			// Filtra
			FiltroServicoPerfilTipo filtroServicoPerfilTipo = new FiltroServicoPerfilTipo();
			filtroServicoPerfilTipo.adicionarParametro(new ParametroSimples(FiltroServicoPerfilTipo.ID, pesquisarEquipeActionForm
							.getTipoPerfilServicoId()));
			// Recupera
			Collection colecaoServicoPerfilTipo = fachada.pesquisar(filtroServicoPerfilTipo, ServicoPerfilTipo.class.getName());
			if(colecaoServicoPerfilTipo != null && !colecaoServicoPerfilTipo.isEmpty()){
				ServicoPerfilTipo servicoPerfilTipo = (ServicoPerfilTipo) colecaoServicoPerfilTipo.iterator().next();
				pesquisarEquipeActionForm.setTipoPerfilServicoDescricao(servicoPerfilTipo.getDescricao());
			}else{
				pesquisarEquipeActionForm.setTipoPerfilServicoDescricao("Tipo Perfil Servi�o inexistente");
			}
			pesquisarEquipeActionForm.setValidaTipoPerfilServico("false");
		}
	}

	/**
	 * Recupera Unidade Organizacional
	 * 
	 * @author Leonardo Regis
	 * @date 01/08/2006
	 * @param pesquisarEquipeActionForm
	 * @param equipeComponentes
	 */
	private void getUnidadeOrganizacional(PesquisarEquipeActionForm pesquisarEquipeActionForm, Fachada fachada){

		// [F0001] Valida Unidade Organizacional
		if(isValidateUnidadeOrganizacional(pesquisarEquipeActionForm)){
			// Filtra Unidade Organizacional
			FiltroUnidadeOrganizacional filtroUnidadeOrganizacional = new FiltroUnidadeOrganizacional();
			filtroUnidadeOrganizacional.adicionarParametro(new ParametroSimples(FiltroUnidadeOrganizacional.ID, pesquisarEquipeActionForm
							.getUnidadeOrganizacionalId()));
			// Recupera Unidade Organizacional
			Collection colecaoUnidadeOrganizacional = fachada.pesquisar(filtroUnidadeOrganizacional, UnidadeOrganizacional.class.getName());
			if(colecaoUnidadeOrganizacional != null && !colecaoUnidadeOrganizacional.isEmpty()){
				UnidadeOrganizacional unidadeOrganizacional = (UnidadeOrganizacional) colecaoUnidadeOrganizacional.iterator().next();
				pesquisarEquipeActionForm.setUnidadeOrganizacionalDescricao(unidadeOrganizacional.getDescricao());
			}else{
				pesquisarEquipeActionForm.setUnidadeOrganizacionalDescricao("Unidade Organizacional inexistente");
			}
			pesquisarEquipeActionForm.setValidaUnidadeOrganizacional("false");
		}
	}

	/**
	 * Valida Unidade Organizacional
	 * 
	 * @author Leonardo Regis
	 * @date 01/08/2006
	 * @return est� validando unidade organizacional?
	 */
	private boolean isValidateUnidadeOrganizacional(PesquisarEquipeActionForm form){

		boolean toReturn = false;
		if(form.getValidaUnidadeOrganizacional().equalsIgnoreCase("true")){
			toReturn = true;
		}
		return toReturn;
	}

	/**
	 * Valida Tipo de Perfil do Servi�o
	 * 
	 * @author Leonardo Regis
	 * @date 01/08/2006
	 * @return est� validando tipo de perfil do servi�o?
	 */
	private boolean isValidateTipoPerfilServico(PesquisarEquipeActionForm form){

		boolean toReturn = false;
		if(form.getValidaTipoPerfilServico().equalsIgnoreCase("true")){
			toReturn = true;
		}
		return toReturn;
	}
}
