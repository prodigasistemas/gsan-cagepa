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
 * 
 * GSANPCG
 * Virg�nia Melo
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

package gcom.gui.cobranca.programacobranca;

import gcom.cobranca.CobrancaCriterio;
import gcom.cobranca.FiltroCobrancaCriterio;
import gcom.cobranca.programacobranca.ProgramaCobranca;
import gcom.fachada.Fachada;
import gcom.gui.ActionServletException;
import gcom.gui.GcomAction;
import gcom.interceptor.RegistradorOperacao;
import gcom.seguranca.acesso.Operacao;
import gcom.seguranca.acesso.OperacaoEfetuada;
import gcom.seguranca.acesso.usuario.Usuario;
import gcom.seguranca.acesso.usuario.UsuarioAcao;
import gcom.seguranca.acesso.usuario.UsuarioAcaoUsuarioHelper;
import gcom.util.ConstantesSistema;
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
 * Action respons�vel por Inserir um Programa de Cobran�a.
 * 
 * @author Virg�nia Melo
 */
public class InserirProgramaCobrancaAction
				extends GcomAction {

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		ActionForward retorno = actionMapping.findForward("telaSucesso");
		HttpSession sessao = httpServletRequest.getSession(false);
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		InserirProgramaCobrancaActionForm form = (InserirProgramaCobrancaActionForm) actionForm;
		Fachada fachada = Fachada.getInstancia();

		String nomePrograma = form.getNomeProgramaCobranca();
		String descricaoPrograma = form.getDescricaoProgramaCobranca();
		String idCriterio = form.getIdCriterio();
		CobrancaCriterio criterio = new CobrancaCriterio();

		// Crit�rio de Cobran�a � obrigat�rio.
		if(idCriterio == null || idCriterio.equalsIgnoreCase("")){
			throw new ActionServletException("atencao.required", null, "Crit�rio de Cobran�a");
		}else{
			FiltroCobrancaCriterio filtroCriterio = new FiltroCobrancaCriterio();
			filtroCriterio.adicionarParametro(new ParametroSimples(FiltroCobrancaCriterio.ID, idCriterio));
			filtroCriterio.adicionarParametro(new ParametroSimples(FiltroCobrancaCriterio.INDICADOR_USO,
							ConstantesSistema.INDICADOR_USO_ATIVO));

			// Retorna o Crit�rio de Cobran�a
			Collection colecaoPesquisa = fachada.pesquisar(filtroCriterio, CobrancaCriterio.class.getName());

			if(colecaoPesquisa == null || colecaoPesquisa.isEmpty()){
				throw new ActionServletException("atencao.pesquisa.criterio_inexistente");
			}
			criterio.setId(Integer.parseInt(form.getIdCriterio()));
		}

		ProgramaCobranca programa = new ProgramaCobranca();
		programa.setNome(nomePrograma);
		programa.setDescricao(descricaoPrograma);
		programa.setCriterio(criterio);
		programa.setDataCriacao(new Date());
		programa.setIndicadorUso(new Integer(1).shortValue());
		programa.setUltimaAlteracao(new Date());

		fachada.inserir(programa);

		// Registrar Opera��o
		RegistradorOperacao registradorOperacao = new RegistradorOperacao(Operacao.OPERACAO_INSERIR_PROGRAMA_COBRANCA,
						new UsuarioAcaoUsuarioHelper(usuario, UsuarioAcao.USUARIO_ACAO_EFETUOU_OPERACAO));

		Operacao operacao = new Operacao();
		operacao.setId(Operacao.OPERACAO_INSERIR_PROGRAMA_COBRANCA);
		OperacaoEfetuada operacaoEfetuada = new OperacaoEfetuada();
		operacaoEfetuada.setOperacao(operacao);

		montarPaginaSucesso(httpServletRequest, "Programa de Cobran�a de c�digo " + programa.getId() + " inserido com sucesso.",
						"Inserir outro Programa de Cobran�a", "exibirInserirProgramaCobrancaAction.do?menu=sim",
						"exibirAtualizarProgramaCobrancaAction.do?codigoPrograma=" + programa.getId(),
						"Atualizar Programa de Cobran�a inserido");

		return retorno;

	}
}