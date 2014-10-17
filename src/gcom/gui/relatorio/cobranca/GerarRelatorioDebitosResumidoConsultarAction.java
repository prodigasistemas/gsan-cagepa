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

package gcom.gui.relatorio.cobranca;

import gcom.cadastro.cliente.ClienteRelacaoTipo;
import gcom.gui.cobranca.ConsultarDebitoClienteActionForm;
import gcom.relatorio.ExibidorProcessamentoTarefaRelatorio;
import gcom.relatorio.cobranca.RelatorioConsultarDebitosResumido;
import gcom.seguranca.acesso.usuario.Usuario;
import gcom.tarefa.TarefaRelatorio;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * action respons�vel pela exibi��o do relat�rio de bairro manter
 * 
 * @author S�vio Luiz
 * @created 11 de Julho de 2005
 */
public class GerarRelatorioDebitosResumidoConsultarAction
				extends ExibidorProcessamentoTarefaRelatorio {

	/**
	 * < <Descri��o do m�todo>>
	 * 
	 * @param actionMapping
	 *            Descri��o do par�metro
	 * @param actionForm
	 *            Descri��o do par�metro
	 * @param httpServletRequest
	 *            Descri��o do par�metro
	 * @param httpServletResponse
	 *            Descri��o do par�metro
	 * @return Descri��o do retorno
	 */
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		// cria a vari�vel de retorno
		ActionForward retorno = null;

		ConsultarDebitoClienteActionForm consultarDebitoClienteActionForm = (ConsultarDebitoClienteActionForm) actionForm;

		// Pega uma instancia da sessao
		HttpSession sessao = httpServletRequest.getSession(false);

		Collection colecaoContaValores = new ArrayList();
		Collection colecaoDebitoACobrar = new ArrayList();
		Collection colecaoCreditoARealizar = new ArrayList();
		Collection colecaoGuiasPagamento = new ArrayList();
		String valorTotalDebitos = null;
		String valorTotalDebitosAtualizado = null;

		if(sessao.getAttribute("colecaoContaValores") != null){
			colecaoContaValores = (Collection) sessao.getAttribute("colecaoContaValores");
		}

		if(sessao.getAttribute("colecaoDebitoACobrar") != null){
			colecaoDebitoACobrar = (Collection) sessao.getAttribute("colecaoDebitoACobrar");
		}

		if(sessao.getAttribute("colecaoCreditoARealizar") != null){
			colecaoCreditoARealizar = (Collection) sessao.getAttribute("colecaoCreditoARealizar");
		}

		if(sessao.getAttribute("colecaoGuiaPagamentoValores") != null){
			colecaoGuiasPagamento = (Collection) sessao.getAttribute("colecaoGuiaPagamentoValores");
		}

		if(sessao.getAttribute("valorTotalSemAcrescimo") != null){
			valorTotalDebitos = (String) sessao.getAttribute("valorTotalSemAcrescimo");
		}

		if(sessao.getAttribute("valorTotalComAcrescimo") != null){
			valorTotalDebitosAtualizado = (String) sessao.getAttribute("valorTotalComAcrescimo");
		}

		String tipoRelatorio = httpServletRequest.getParameter("tipoRelatorio");

		RelatorioConsultarDebitosResumido relatorioConsultarDebitosResumido = new RelatorioConsultarDebitosResumido(
						(Usuario) (httpServletRequest.getSession(false)).getAttribute("usuarioLogado"));
		relatorioConsultarDebitosResumido.addParametro("colecaoContaValores", colecaoContaValores);
		relatorioConsultarDebitosResumido.addParametro("colecaoDebitoACobrar", colecaoDebitoACobrar);
		relatorioConsultarDebitosResumido.addParametro("colecaoCreditoARealizar", colecaoCreditoARealizar);
		relatorioConsultarDebitosResumido.addParametro("colecaoGuiasPagamento", colecaoGuiasPagamento);

		ClienteRelacaoTipo tipoRelacao = (ClienteRelacaoTipo) sessao.getAttribute("tipoRelacao");

		if(consultarDebitoClienteActionForm.getCodigoCliente() != null
						&& !consultarDebitoClienteActionForm.getCodigoCliente().trim().equals("")){
			relatorioConsultarDebitosResumido.addParametro("codigoCliente", consultarDebitoClienteActionForm.getCodigoCliente());
			relatorioConsultarDebitosResumido.addParametro("nomeCliente", consultarDebitoClienteActionForm.getNomeCliente());
			relatorioConsultarDebitosResumido.addParametro("tipoRelacao", tipoRelacao);
		}else{
			relatorioConsultarDebitosResumido.addParametro("codigoCliente", consultarDebitoClienteActionForm.getCodigoClienteSuperior());
			relatorioConsultarDebitosResumido.addParametro("nomeCliente", consultarDebitoClienteActionForm.getNomeClienteSuperior());
			relatorioConsultarDebitosResumido.addParametro("tipoRelacao", null);
		}
		relatorioConsultarDebitosResumido.addParametro("periodoReferenciaInicial", consultarDebitoClienteActionForm.getReferenciaInicial());
		relatorioConsultarDebitosResumido.addParametro("periodoReferenciaFinal", consultarDebitoClienteActionForm.getReferenciaFinal());
		relatorioConsultarDebitosResumido
						.addParametro("dataVencimentoInicial", consultarDebitoClienteActionForm.getDataVencimentoInicial());
		relatorioConsultarDebitosResumido.addParametro("dataVencimentoFinal", consultarDebitoClienteActionForm.getDataVencimentoFinal());
		relatorioConsultarDebitosResumido.addParametro("tipoRelacao", tipoRelacao);

		relatorioConsultarDebitosResumido.addParametro("valorTotalDebitos", valorTotalDebitos);
		relatorioConsultarDebitosResumido.addParametro("valorTotalDebitosAtualizado", valorTotalDebitosAtualizado);

		if(tipoRelatorio == null){
			tipoRelatorio = TarefaRelatorio.TIPO_PDF + "";
		}

		relatorioConsultarDebitosResumido.addParametro("tipoFormatoRelatorio", Integer.parseInt(tipoRelatorio));

		retorno = processarExibicaoRelatorio(relatorioConsultarDebitosResumido, tipoRelatorio, httpServletRequest, httpServletResponse,
						actionMapping);

		// devolve o mapeamento contido na vari�vel retorno
		return retorno;
	}

}
