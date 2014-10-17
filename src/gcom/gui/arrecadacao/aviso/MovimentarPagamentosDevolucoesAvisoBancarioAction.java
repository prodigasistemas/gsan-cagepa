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

package gcom.gui.arrecadacao.aviso;

import gcom.arrecadacao.aviso.bean.MovimentarPagamentosDevolucoesHelper;
import gcom.arrecadacao.aviso.bean.PagamentosDevolucoesHelper;
import gcom.fachada.Fachada;
import gcom.gui.ActionServletException;
import gcom.gui.GcomAction;
import gcom.seguranca.acesso.usuario.Usuario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * [UC0611] Movimentar Pagamentos/ Devolu��es entre Avisos Banc�rios
 * 
 * @author Ana Maria
 * @date 11/06/2007
 */

public class MovimentarPagamentosDevolucoesAvisoBancarioAction
				extends GcomAction {

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		ActionForward retorno = actionMapping.findForward("telaSucesso");

		HttpSession sessao = httpServletRequest.getSession(false);

		Usuario usuarioLogado = (Usuario) sessao.getAttribute("usuarioLogado");

		Fachada fachada = Fachada.getInstancia();

		MovimentarPagamentosDevolucoesAvisoBancarioActionForm form = (MovimentarPagamentosDevolucoesAvisoBancarioActionForm) actionForm;

		Integer idAvisoBancarioO = (Integer) sessao.getAttribute("avisoBancarioO");
		Integer idAvisoBancarioD = (Integer) sessao.getAttribute("avisoBancarioD");

		Collection<Integer> idsPagamentos = new ArrayList();
		Collection<Integer> idsPagamentosHistorico = new ArrayList();

		Collection<Integer> idsDevolucoes = new ArrayList();
		Collection<Integer> idsDevolucoesHistorico = new ArrayList();

		if(sessao.getAttribute("pagamentoHelper") != null){

			PagamentosDevolucoesHelper helper = (PagamentosDevolucoesHelper) sessao.getAttribute("pagamentoHelper");
			if(helper.getColecaoMovimentarPagamentos() != null){
				Collection pagamentos = (Collection) helper.getColecaoMovimentarPagamentos();
				Iterator colecaoPagamentosIterator = pagamentos.iterator();
				while(colecaoPagamentosIterator.hasNext()){
					MovimentarPagamentosDevolucoesHelper pagamento = (MovimentarPagamentosDevolucoesHelper) colecaoPagamentosIterator
									.next();
					if(!pagamento.isHistorico()){
						idsPagamentos.add(pagamento.getId());
					}else{
						idsPagamentosHistorico.add(pagamento.getId());
					}

				}
				if((idsPagamentos != null && !idsPagamentos.isEmpty())
								|| (idsPagamentosHistorico != null && !idsPagamentosHistorico.isEmpty())){

					fachada.atualizarAvisoBancarioPagamentos(idsPagamentos, idsPagamentosHistorico,
									form.getArrecadacaoCalculadoDepoisOrigem(), form.getArrecadacaoCalculadoDepoisDestino(),
									idAvisoBancarioO, idAvisoBancarioD, usuarioLogado);
				}
			}

		}

		if(sessao.getAttribute("devolucaoHelper") != null){

			PagamentosDevolucoesHelper helper = (PagamentosDevolucoesHelper) sessao.getAttribute("devolucaoHelper");
			if(helper.getColecaoMovimentarDevolucoes() != null){
				Collection devolucoes = (Collection) helper.getColecaoMovimentarDevolucoes();
				Iterator colecaoDevolucoesIterator = devolucoes.iterator();
				while(colecaoDevolucoesIterator.hasNext()){
					MovimentarPagamentosDevolucoesHelper devolucao = (MovimentarPagamentosDevolucoesHelper) colecaoDevolucoesIterator
									.next();
					if(!devolucao.isHistorico()){
						idsDevolucoes.add(devolucao.getId());
					}else{
						idsDevolucoesHistorico.add(devolucao.getId());
					}

				}
				if((idsDevolucoes != null && !idsDevolucoes.isEmpty())
								|| (idsDevolucoesHistorico != null && !idsDevolucoesHistorico.isEmpty())){
					fachada.atualizarAvisoBancarioDevolucoes(idsDevolucoes, idsDevolucoesHistorico,
									form.getDevolucaoInformadoDepoisOrigem(), form.getDevolucaoCalculadoDepoisOrigem(),
									form.getDevolucaoInformadoDepoisDestino(), form.getDevolucaoCalculadoDepoisDestino(), idAvisoBancarioO,
									idAvisoBancarioD, usuarioLogado);
				}
			}

		}

		if((idsPagamentos == null || idsPagamentos.isEmpty()) && (idsPagamentosHistorico == null || idsPagamentosHistorico.isEmpty())
						&& (idsDevolucoes == null || idsDevolucoes.isEmpty())
						&& (idsDevolucoesHistorico == null || idsDevolucoesHistorico.isEmpty())){
			throw new ActionServletException("atencao.nenhum_pagamento_ou_devolucao_foi_selecionado");
		}

		// Monta a p�gina de sucesso
		montarPaginaSucesso(
						httpServletRequest,
						"Pagamentos/Devolu��es foram movimentados com sucesso do Aviso Banc�rio "
										+ sessao.getAttribute("descricaoABOrigem") + " para o Aviso Banc�rio "
										+ sessao.getAttribute("descricaoABDestino"), "Realizar outra Movimenta��o",
						"exibirSelecionarPagamentosAvisoBancarioAction.do?menu=sim");

		return retorno;
	}

}