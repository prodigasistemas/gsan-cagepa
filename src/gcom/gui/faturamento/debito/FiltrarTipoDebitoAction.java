/**
 * 
 */
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

package gcom.gui.faturamento.debito;

import gcom.faturamento.debito.FiltroDebitoTipo;
import gcom.gui.ActionServletException;
import gcom.gui.GcomAction;
import gcom.util.ConstantesSistema;
import gcom.util.Util;
import gcom.util.filtro.ComparacaoTexto;
import gcom.util.filtro.ComparacaoTextoCompleto;
import gcom.util.filtro.MaiorQue;
import gcom.util.filtro.MenorQue;
import gcom.util.filtro.ParametroSimples;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Descri��o da classe
 * 
 * @author R�mulo Aur�lio
 * @date 13/03/2007
 */
public class FiltrarTipoDebitoAction
				extends GcomAction {

	/**
	 * Este caso de uso cria um filtro que ser� usado na pesquisa de Tipo de
	 * D�bito
	 * [UC0531] Filtrar Tipo de D�bito
	 * 
	 * @author R�mulo Aur�lio
	 * @date 13/03/2007
	 * @author eduardo henrique
	 * @date 08/07/2008
	 *       Inclus�o dos Atributos indicadorIncidenciaMulta, indicadorIncidenciaJurosMora
	 * @param actionMapping
	 * @param actionForm
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 */

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		ActionForward retorno = actionMapping.findForward("exibirManterTipoDebitoAction");

		FiltrarTipoDebitoActionForm form = (FiltrarTipoDebitoActionForm) actionForm;

		FiltroDebitoTipo filtroDebitoTipo = new FiltroDebitoTipo();

		HttpSession sessao = httpServletRequest.getSession(false);

		boolean peloMenosUmParametroInformado = false;

		String descricao = form.getDescricao();

		String descricaoAbreviada = form.getDescricaoAbreviada();

		String idTipoFinanciamento = form.getFinanciamentoTipo();

		String idLancamentoItemContabil = form.getLancamentoItemContabil();

		String tipoPesquisa = form.getTipoPesquisa();

		String indicadorGeracaoDebitoAutomatica = form.getIndicadorGeracaoDebitoAutomatica();

		String indicadorGeracaoDebitoConta = form.getIndicadorGeracaoDebitoConta();
		String indicadorUso = form.getIndicadorUso();

		String valorLimiteDebitoInicial = form.getValorLimiteDebitoInicial();

		String valorLimiteDebitoFinal = form.getValorLimiteDebitoFinal();

		// Verifica se o campo descricao foi informado

		if(descricao != null && !descricao.equalsIgnoreCase("")){

			peloMenosUmParametroInformado = true;

			if(tipoPesquisa != null && tipoPesquisa.equals(ConstantesSistema.TIPO_PESQUISA_COMPLETA.toString())){

				filtroDebitoTipo.adicionarParametro(new ComparacaoTextoCompleto(FiltroDebitoTipo.DESCRICAO, descricao));
			}else{

				filtroDebitoTipo.adicionarParametro(new ComparacaoTexto(FiltroDebitoTipo.DESCRICAO, descricao));
			}
		}

		// Verifica se o campo descricaoAbreviada foi informado

		if(descricaoAbreviada != null && !descricaoAbreviada.trim().equalsIgnoreCase("")){

			peloMenosUmParametroInformado = true;

			filtroDebitoTipo.adicionarParametro(new ComparacaoTexto(FiltroDebitoTipo.DESCRICAO_ABREVIADA, descricaoAbreviada));

		}

		// Verifica se o campo TipoFinanciamento foi informado

		if(idTipoFinanciamento != null && !idTipoFinanciamento.trim().equals("" + ConstantesSistema.NUMERO_NAO_INFORMADO)){
			peloMenosUmParametroInformado = true;
			filtroDebitoTipo.adicionarParametro(new ParametroSimples(FiltroDebitoTipo.FINANCIAMENTO_TIPO_ID, idTipoFinanciamento));

		}

		// Verifica se o campo LancamentoItemContabil foi informado

		if(idLancamentoItemContabil != null && !idLancamentoItemContabil.trim().equals("" + ConstantesSistema.NUMERO_NAO_INFORMADO)){

			peloMenosUmParametroInformado = true;

			filtroDebitoTipo
							.adicionarParametro(new ParametroSimples(FiltroDebitoTipo.LANCAMENTO_ITEM_CONTABIL_ID, idLancamentoItemContabil));

		}

		if(indicadorGeracaoDebitoAutomatica != null && !indicadorGeracaoDebitoAutomatica.trim().equals("3")){

			peloMenosUmParametroInformado = true;

			filtroDebitoTipo.adicionarParametro(new ParametroSimples(FiltroDebitoTipo.INDICADOR_GERACAO_AUTOMATICA,
							indicadorGeracaoDebitoAutomatica));

		}

		if(indicadorGeracaoDebitoConta != null && !indicadorGeracaoDebitoConta.trim().equals("3")){

			peloMenosUmParametroInformado = true;

			filtroDebitoTipo.adicionarParametro(new ParametroSimples(FiltroDebitoTipo.INDICADOR_GERACAO_DEBITO_CONTA,
							indicadorGeracaoDebitoConta));

		}

		// se o usu�rio informar o intervalo inicial do valor de limite
		if(valorLimiteDebitoInicial != null && !valorLimiteDebitoInicial.trim().equalsIgnoreCase("")){

			// se o usu�rio n�o informar o intervalo final do valor de
			// limite
			if(valorLimiteDebitoFinal == null || valorLimiteDebitoFinal.trim().equalsIgnoreCase("")){
				// o intervalo final do valor de limite vai receber o valor
				// do intervalo inicial
				valorLimiteDebitoFinal = valorLimiteDebitoInicial;

				// se o usu�rio informar o intervalo final do valor de
				// limite
			}else{
				// se o intervalo final do valor de limite for menor que o
				// inicial
				if((Util.formatarMoedaRealparaBigDecimal(valorLimiteDebitoInicial)).doubleValue() > ((Util
								.formatarMoedaRealparaBigDecimal(valorLimiteDebitoFinal))).doubleValue()){
					// levanta a exce��o para a pr�xima camada
					throw new ActionServletException("atencao.valorlimitefinal.menorque");
				}
			}

			// se o usu�rio n�o informar o intervalo inicial do valor de
			// limite
		}else{
			// seta o intervalo final do valor de limite para null
			valorLimiteDebitoFinal = null;
		}

		// se o intervalo final do valor de limite n�o estiver nulo ou em
		// branco
		if(valorLimiteDebitoFinal != null && !valorLimiteDebitoFinal.trim().equalsIgnoreCase("")){
			peloMenosUmParametroInformado = true;

			peloMenosUmParametroInformado = true;
			// seta no filtro para retornar os tipos de d�bito entre os
			// valores informados
			filtroDebitoTipo.adicionarParametro(new MaiorQue(FiltroDebitoTipo.VALOR_LIMITE, Util
							.formatarMoedaRealparaBigDecimal(valorLimiteDebitoInicial), ParametroSimples.CONECTOR_AND));
			filtroDebitoTipo.adicionarParametro(new MenorQue(FiltroDebitoTipo.VALOR_LIMITE, Util
							.formatarMoedaRealparaBigDecimal(valorLimiteDebitoFinal)));
		}

		if(indicadorUso != null && !indicadorUso.trim().equals("3")){

			peloMenosUmParametroInformado = true;

			filtroDebitoTipo.adicionarParametro(new ParametroSimples(FiltroDebitoTipo.INDICADOR_USO, indicadorUso));

		}

		// adicionado em 08/07/2008
		if(form.getIndicadorIncidenciaMulta() != null && !form.getIndicadorIncidenciaMulta().trim().equals("3")){

			peloMenosUmParametroInformado = true;

			filtroDebitoTipo.adicionarParametro(new ParametroSimples(FiltroDebitoTipo.INDICADOR_INCIDENCIA_MULTA, form
							.getIndicadorIncidenciaMulta()));

		}

		if(form.getIndicadorIncidenciaJurosMora() != null && !form.getIndicadorIncidenciaJurosMora().trim().equals("3")){

			peloMenosUmParametroInformado = true;

			filtroDebitoTipo.adicionarParametro(new ParametroSimples(FiltroDebitoTipo.INDICADOR_INCIDENCIA_JUROS_MORA, form
							.getIndicadorIncidenciaJurosMora()));

		}

		// Erro caso o usu�rio mandou Pesquisar sem nenhum par�metro
		if(!peloMenosUmParametroInformado){
			throw new ActionServletException("atencao.filtro.nenhum_parametro_informado");
		}

		filtroDebitoTipo.adicionarCaminhoParaCarregamentoEntidade("financiamentoTipo");
		filtroDebitoTipo.adicionarCaminhoParaCarregamentoEntidade("lancamentoItemContabil");

		// Verifica se o checkbox Atualizar est� marcado e em caso afirmativo
		// manda pelo um request uma vari�vel para o
		// ExibirManterFuncionalidadeAction e nele verificar se ir� para o
		// atualizar ou para o manter
		if(form.getAtualizar() != null && form.getAtualizar().equalsIgnoreCase("1")){
			httpServletRequest.setAttribute("atualizar", form.getAtualizar());

		}

		// Manda o filtro pelo sessao para o
		// ExibirFuncionalidadeAction

		sessao.setAttribute("filtroDebitoTipo", filtroDebitoTipo);

		httpServletRequest.setAttribute("filtroDebitoTipo", filtroDebitoTipo);

		return retorno;

	}

}
