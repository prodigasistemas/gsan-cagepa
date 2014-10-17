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
 * Andr� Nishimura
 * Eduardo Henrique Bandeira Carneiro da Silva
 * Jos� Gilberto de Fran�a Matos
 * Lucas Daniel Medeiros
 * Saulo Vasconcelos de Lima
 * Virginia Santos de Melo
 *
 * Este programa � software livre; voc� pode redistribu�-lo e/ou
 * modific�-lo sob os termos de Licen�a P�blica Geral GNU, conforme
 * publicada pela Free Software Foundation; vers�o 2 da Licen�a.
 * Este programa � distribu�do na expectativa de ser �til, mas SEM
 * QUALQUER GARANTIA; sem mesmo a garantia impl�cita de
 * COMERCIALIZA��O ou de ADEQUA��O A QUALQUER PROP�SITO EM
 * PARTICULAR. 
 * Consulte a Licen�a P�blica Geral GNU para obter mais detalhes.
 * Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU
 * junto com este programa; se n�o, escreva para Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
 * 02111-1307, USA.
 */

package gcom.gui.faturamento.conta.contamotivo;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import gcom.fachada.Fachada;
import gcom.faturamento.conta.ContaMotivoCancelamento;
import gcom.faturamento.conta.FiltroContaMotivoCancelamento;
import gcom.gui.GcomAction;
import gcom.util.filtro.ParametroSimples;

public class ExibirAtualizarContaMotivoCancelamentoAction
				extends GcomAction {

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		final ActionForward retorno = actionMapping.findForward("exibirAtualizarContaMotivoCancelamento");

		final HttpSession sessao = httpServletRequest.getSession(false);

		final AtualizarContaMotivoCancelamentoActionForm atualizarContaMotivoCancelamentoActionForm = (AtualizarContaMotivoCancelamentoActionForm) actionForm;

		final Fachada fachada = Fachada.getInstancia();

		String idRegistroAtualizacao = (String) httpServletRequest.getParameter("idRegistroAtualizacao");

		FiltroContaMotivoCancelamento filtroContaMotivoCancelamento = new FiltroContaMotivoCancelamento();

		filtroContaMotivoCancelamento.adicionarParametro(new ParametroSimples(FiltroContaMotivoCancelamento.CODIGO, idRegistroAtualizacao));

		Collection colecao = fachada.pesquisar(filtroContaMotivoCancelamento, ContaMotivoCancelamento.class.getName());

		ContaMotivoCancelamento contaMotivoCancelamento = (ContaMotivoCancelamento) colecao.iterator().next();

		atualizarContaMotivoCancelamentoActionForm.setId(String.valueOf(contaMotivoCancelamento.getId()));
		atualizarContaMotivoCancelamentoActionForm.setDescricao(contaMotivoCancelamento.getDescricaoMotivoCancelamentoConta());
		sessao.setAttribute("atualizarContaMotivoCancelamentoActionForm", atualizarContaMotivoCancelamentoActionForm);
		return retorno;
	}
}