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

import gcom.atendimentopublico.ordemservico.OrdemServico;
import gcom.atendimentopublico.registroatendimento.Tramite;
import gcom.cadastro.unidade.FiltroUnidadeOrganizacional;
import gcom.cadastro.unidade.UnidadeOrganizacional;
import gcom.fachada.Fachada;
import gcom.gui.ActionServletException;
import gcom.gui.GcomAction;
import gcom.interceptor.RegistradorOperacao;
import gcom.seguranca.acesso.Operacao;
import gcom.seguranca.acesso.OperacaoEfetuada;
import gcom.seguranca.acesso.usuario.Usuario;
import gcom.seguranca.acesso.usuario.UsuarioAcao;
import gcom.seguranca.acesso.usuario.UsuarioAcaoUsuarioHelper;
import gcom.util.Util;
import gcom.util.filtro.ParametroSimples;

import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * [UC0371] Inserir Equipe
 * 
 * @author Ailton Sousa
 * @date 08/02/2012
 */
public class TramitarOrdemServicoAction
				extends GcomAction {

	/**
	 * [UC0371] Inserir Equipe
	 * [UC0107] Registrar Transa��o
	 * 
	 * @author Ailton Sousa
	 * @date 08/02/2012
	 * @param actionMapping
	 * @param actionForm
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return forward
	 */
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		// Seta Retorno (Forward = Sucesso)
		ActionForward retorno = actionMapping.findForward("telaSucesso");
		// Form
		TramitarOrdemServicoActionForm tramitarOrdemServicoActionForm = (TramitarOrdemServicoActionForm) actionForm;
		// Fachada
		Fachada fachada = Fachada.getInstancia();

		HttpSession sessao = httpServletRequest.getSession(false);

		// Usuario logado no sistema
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		OrdemServico ordemServico = (OrdemServico) sessao.getAttribute("ordemServico");

		if(ordemServico == null){
			ordemServico = fachada
							.consultarDadosOrdemServico(Util.converterStringParaInteger(tramitarOrdemServicoActionForm.getNumeroOS()));

			if(ordemServico == null){
				throw new ActionServletException("atencao.naocadastrado", null, "Ordem de Servi�o");
			}
		}

		/*
		 * [UC0107] Registrar Transa��o
		 */
		RegistradorOperacao registradorOperacao = new RegistradorOperacao(Operacao.OPERACAO_TRAMITAR_ORDEM_SERVICO,
						new UsuarioAcaoUsuarioHelper(usuario, UsuarioAcao.USUARIO_ACAO_EFETUOU_OPERACAO));

		Operacao operacao = new Operacao();
		operacao.setId(Operacao.OPERACAO_TRAMITAR_ORDEM_SERVICO);

		OperacaoEfetuada operacaoEfetuada = new OperacaoEfetuada();
		operacaoEfetuada.setOperacao(operacao);
		// [UC0107] -Fim- Registrar Transa��o

		// Tramite
		Tramite tramite = null;
		if(tramitarOrdemServicoActionForm.getUnidadeDestinoId() != null){
			// Recupera informa��es do tr�mite
			tramite = getTramite(tramitarOrdemServicoActionForm, fachada);

			// Faz as valida��es de tramita��o
			fachada.validarTramitacaoOS(tramite, usuario);

			// Insere Tr�mite
			fachada.tramitarOS(tramite, ordemServico.getUltimaAlteracao());

			// Setando Opera��o
			tramite.setOperacaoEfetuada(operacaoEfetuada);
			tramite.adicionarUsuario(usuario, UsuarioAcao.USUARIO_ACAO_EFETUOU_OPERACAO);
			registradorOperacao.registrarOperacao(tramite);

			// [FS008] Monta a p�gina de sucesso
			montarPaginaSucesso(httpServletRequest, "Ordem de Servi�o " + tramite.getOrdemServico().getId() + " tramitada com sucesso!",
							"Efetuar outra Tramita��o de Ordem de Servi�o",
							"exibirTramitarOrdemServicoAction.do?resetarTramitacao=true&numeroOS=" + tramite.getOrdemServico().getId(),
							"exibirConsultarDadosOrdemServicoAction.do?numeroOS=" + tramite.getOrdemServico().getId().toString(), "Voltar");
		}
		return retorno;
	}

	/**
	 * Carrega Tr�mite com informa��es vindas da tela
	 * 
	 * @author Ailton Sousa
	 * @date 08/02/2012
	 * @param form
	 */
	private Tramite getTramite(TramitarOrdemServicoActionForm form, Fachada fachada){

		Tramite tramite = new Tramite();
		// Unidade Origem
		UnidadeOrganizacional unidadeOrigem = null;
		unidadeOrigem = fachada.obterUnidadeAtualOrdemServico(Util.converterStringParaInteger(form.getNumeroOS()));

		tramite.setUnidadeOrganizacionalOrigem(unidadeOrigem);
		// Unidade Destino
		UnidadeOrganizacional unidadeDestino = null;
		// unidadeDestino.setId(new Integer(form.getUnidadeDestinoId()));
		// Filtra Unidade de Destino
		FiltroUnidadeOrganizacional filtroUnidadeDestino = new FiltroUnidadeOrganizacional();
		filtroUnidadeDestino.adicionarParametro(new ParametroSimples(FiltroUnidadeOrganizacional.ID, form.getUnidadeDestinoId()));

		// Recupera Unidade de Destino
		Collection colecaoUnidadeDestino = fachada.pesquisar(filtroUnidadeDestino, UnidadeOrganizacional.class.getName());

		if(colecaoUnidadeDestino != null && !colecaoUnidadeDestino.isEmpty()){
			unidadeDestino = (UnidadeOrganizacional) Util.retonarObjetoDeColecao(colecaoUnidadeDestino);
		}else{
			// levanta a exce��o para a pr�xima camada
			throw new ActionServletException("atencao.data.invalida", null, "Unidade Destino");
		}

		tramite.setUnidadeOrganizacionalDestino(unidadeDestino);
		// Ordem de Servi�o
		OrdemServico ordemServico = new OrdemServico();
		ordemServico.setId(Util.converterStringParaInteger(form.getNumeroOS()));
		tramite.setOrdemServico(ordemServico);
		// Usu�rio Registro
		Usuario usuarioRegistro = new Usuario();
		usuarioRegistro.setId(new Integer(form.getUsuarioRegistroId()));
		UnidadeOrganizacional unidadeOrganizacional = new UnidadeOrganizacional();
		unidadeOrganizacional.setId(new Integer(form.getUsuarioRegistroUnidade()));
		unidadeOrganizacional.setIndicadorTarifaSocial(new Short(form.getUsuarioRegistroUnidadeIndicadorTarifaSocial()));
		usuarioRegistro.setUnidadeOrganizacional(unidadeOrganizacional);
		tramite.setUsuarioRegistro(usuarioRegistro);
		// Usu�rio Respons�vel
		if(form.getUsuarioResponsavelId() != null && !form.getUsuarioResponsavelId().equals("")){
			Usuario usuarioResponsavel = new Usuario();
			usuarioResponsavel.setId(new Integer(form.getUsuarioResponsavelId()));
			tramite.setUsuarioResponsavel(usuarioResponsavel);
		}
		if(form.getParecerTramite() != null && !form.getParecerTramite().equals("")){
			tramite.setParecerTramite(form.getParecerTramite());
		}else{
			tramite.setParecerTramite(null);
		}
		tramite.setDataTramite(Util.converteStringParaDateHora(form.getDataTramite() + " " + form.getHoraTramite() + ":00"));
		tramite.setUltimaAlteracao(new Date());

		return tramite;
	}
}