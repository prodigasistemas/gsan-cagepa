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

package gcom.gui.faturamento.conta;

import gcom.cadastro.imovel.Categoria;
import gcom.cadastro.imovel.Imovel;
import gcom.cadastro.imovel.Subcategoria;
import gcom.cadastro.sistemaparametro.SistemaParametro;
import gcom.fachada.Fachada;
import gcom.faturamento.bean.CalcularValoresAguaEsgotoHelper;
import gcom.faturamento.consumotarifa.ConsumoTarifa;
import gcom.faturamento.conta.Conta;
import gcom.gui.ActionServletException;
import gcom.gui.GcomAction;
import gcom.seguranca.acesso.PermissaoEspecial;
import gcom.seguranca.acesso.usuario.Usuario;
import gcom.util.ConstantesSistema;
import gcom.util.ControladorException;
import gcom.util.Util;
import gcom.util.parametrizacao.faturamento.ParametroFaturamento;

import java.math.BigDecimal;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CalcularValoresRetificarContaAction
				extends GcomAction {

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		// Seta o mapeamento de retorno
		ActionForward retorno = actionMapping.findForward("exibirRetificarConta");

		Fachada fachada = Fachada.getInstancia();

		// Mudar isso quando tiver esquema de seguran�a
		HttpSession sessao = httpServletRequest.getSession(false);

		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		// Inst�ncia do formul�rio que est� sen`o utilizado
		RetificarContaActionForm retificarContaActionForm = (RetificarContaActionForm) actionForm;

		Conta contaAtual = (Conta) sessao.getAttribute("contaRetificar");
		if(contaAtual == null){
			throw new ActionServletException("atencao.conta_retificacao_nao_existente_sessao");
		}

		// Recebendo os dados enviados pelo formUl�rio
		String imovelID = retificarContaActionForm.getIdImovel();
		String mesAnoConta = retificarContaActionForm.getMesAnoConta();
		Integer situacaoAguaConta = new Integer(retificarContaActionForm.getSituacaoAguaConta());
		Integer situacaoEsgotoConta = new Integer(retificarContaActionForm.getSituacaoEsgotoConta());
		String consumoAgua = retificarContaActionForm.getConsumoAgua();
		String consumoEsgoto = retificarContaActionForm.getConsumoEsgoto();
		String percentualEsgoto = retificarContaActionForm.getPercentualEsgoto();
		String motivoRetificacao = retificarContaActionForm.getMotivoRetificacaoID();
		Date dataLeituraAtual = null;
		Date dataLeituraAnterior = null;
		// Data de vencimento da conta
		Date dataVencimentoConta = Util.converteStringParaDate(retificarContaActionForm.getVencimentoConta());
		Date dataVencimentoContaAnterior = Util.converteStringParaDate(retificarContaActionForm.getVencimentoContaAnterior());

		if(Util.compararData(dataVencimentoConta, dataVencimentoContaAnterior) != 0){
			if(!retificarContaActionForm.getVencimentoConta().equals("") && retificarContaActionForm.getVencimentoConta() != null){
				if(!getFachada().verificarPermissaoEspecial(
								PermissaoEspecial.RETIFICAR_DATA_VENCIMENTO_ANTERIOR_OU_POSTERIOR_DATA_CORRENTE, usuario)){

					Calendar dataCorrente = new GregorianCalendar();
					if(Util.compararData(dataVencimentoConta, dataCorrente.getTime()) == -1){
						throw new ActionServletException("atencao.data_vencimento_menor_data_corrente");
					}

					Integer qtdDiasVencimentoConta = null;
					try{
						qtdDiasVencimentoConta = Util
										.converterStringParaInteger((String) ParametroFaturamento.P_QUANTIDADE_DIAS_VENCIMENTO_CONTA
														.executar());
					}catch(ControladorException e){
						throw new ActionServletException(e.getMessage(), e.getParametroMensagem().toArray(
										new String[e.getParametroMensagem().size()]));
					}
					dataCorrente.add(Calendar.DATE, qtdDiasVencimentoConta.intValue());

					if(Util.compararData(dataVencimentoConta, dataCorrente.getTime()) == 1){
						throw new ActionServletException("atencao.data_vencimento_maior_data_corrente_parametro", qtdDiasVencimentoConta
										.toString());
					}
				}
			}
		}

		if(!Util.isVazioOuBranco(retificarContaActionForm.getDataLeituraAtualMedicaoHistoricoAgua())){
			dataLeituraAtual = Util.converteStringParaDate(retificarContaActionForm.getDataLeituraAtualMedicaoHistoricoAgua());
		}
		if(!Util.isVazioOuBranco(retificarContaActionForm.getDataLeituraAnteriorMedicaoHistoricoAgua())){
			dataLeituraAnterior = Util.converteStringParaDate(retificarContaActionForm.getDataLeituraAnteriorMedicaoHistoricoAgua());
		}

		// Carrega as cole��es de acordo com os Objetos da sess�o
		Collection colecaoDebitoCobrado = null;
		if(sessao.getAttribute("colecaoDebitoCobrado") != null){
			colecaoDebitoCobrado = (Collection) sessao.getAttribute("colecaoDebitoCobrado");
		}

		Collection colecaoCreditoRealizado = new ArrayList();
		if(sessao.getAttribute("colecaoCreditoRealizado") != null){
			colecaoCreditoRealizado = (Collection) sessao.getAttribute("colecaoCreditoRealizado");
		}

		// Alterado por Raphael Rossiter em 17/04/2007
		Collection colecaoCategoriaOUSubcategoria = null;

		// Cria��o do consumo tarifa
		Imovel imovel = new Imovel();

		ConsumoTarifa consumoTarifa = null;
		Integer idConsumoTarifa = null;

		String idConsumoTarifaStr = retificarContaActionForm.getConsumoTarifaId();

		if(!Util.isVazioOuBranco(idConsumoTarifaStr)
						&& !idConsumoTarifaStr.equals(Integer.toString(ConstantesSistema.NUMERO_NAO_INFORMADO))){
			idConsumoTarifa = Integer.valueOf(idConsumoTarifaStr);

			consumoTarifa = new ConsumoTarifa();
			consumoTarifa.setId(idConsumoTarifa);
		}

		imovel.setConsumoTarifa(consumoTarifa);

		Integer qtdEconnomia = null;
		int consumoMinimoLigacao = 0;

		if(sessao.getAttribute("colecaoCategoria") != null){

			colecaoCategoriaOUSubcategoria = (Collection) sessao.getAttribute("colecaoCategoria");
			qtdEconnomia = this.atualizarQuantidadeEconomiasCategoria(colecaoCategoriaOUSubcategoria, httpServletRequest);

			// Obt�m o consumo m�nimo liga��o por categoria
			consumoMinimoLigacao = fachada.obterConsumoMinimoLigacaoPeriodo(imovel, colecaoCategoriaOUSubcategoria, contaAtual
							.getReferenciaFormatada(), idConsumoTarifa);
		}else{

			colecaoCategoriaOUSubcategoria = (Collection) sessao.getAttribute("colecaoSubcategoria");
			qtdEconnomia = this.atualizarQuantidadeEconomiasSubcategoria(colecaoCategoriaOUSubcategoria, httpServletRequest);

			// Obt�m o consumo m�nimo liga��o por categoria
			consumoMinimoLigacao = fachada.obterConsumoMinimoLigacaoPeriodo(imovel, colecaoCategoriaOUSubcategoria, contaAtual
							.getReferenciaFormatada(), idConsumoTarifa);
		}

		// SB0010 � Ajuste do Consumo para M�ltiplo da Quantidade de Economias
		Integer consumoAguaAux = null;
		if(consumoAgua != null){
			consumoAguaAux = Integer.parseInt(consumoAgua);
		}

		Integer consumoEsgotoAux = null;
		if(consumoEsgoto != null && !consumoEsgoto.equals("")){
			consumoEsgotoAux = Integer.parseInt(consumoEsgoto);
		}

		Map<String, String> consumoFaturadoAguaEsgoto = fachada.ajusteConsumoMultiploQuantidadeEconomia(consumoAguaAux,
						consumoMinimoLigacao, consumoEsgotoAux, qtdEconnomia);

		if(consumoFaturadoAguaEsgoto != null && !consumoFaturadoAguaEsgoto.isEmpty()){
			if(consumoFaturadoAguaEsgoto.get("agua") != null){
				consumoAgua = consumoFaturadoAguaEsgoto.get("agua");
			}

			if(consumoFaturadoAguaEsgoto.get("esgoto") != null){
				consumoEsgoto = consumoFaturadoAguaEsgoto.get("esgoto");
			}
		}

		// [SF0001] - Determinar Valores para Faturamento de �gua e/ou Esgoto
		Usuario usuarioLogado = (Usuario) sessao.getAttribute(Usuario.USUARIO_LOGADO);

		Collection<CalcularValoresAguaEsgotoHelper> valoresConta = fachada.calcularValoresConta(mesAnoConta, imovelID, situacaoAguaConta,
						situacaoEsgotoConta, colecaoCategoriaOUSubcategoria, consumoAgua, consumoEsgoto, percentualEsgoto, idConsumoTarifa,
						usuarioLogado, dataLeituraAnterior, dataLeituraAtual);

		// C�lcula o valor total dos d�bitos de uma conta de acordo com o informado pelo usu�rio
		BigDecimal valorTotalDebitosConta = fachada.calcularValorTotalDebitoConta(colecaoDebitoCobrado, httpServletRequest
						.getParameterMap());

		// C�lcula o valor total dos cr�ditos de uma conta de acordo com o informado pelo usu�rio
		BigDecimal valorTotalCreditosConta = fachada.calcularValorTotalCreditoConta(colecaoCreditoRealizado, httpServletRequest
						.getParameterMap());

		// Totalizando os valores de �gua e esgoto
		BigDecimal valorTotalAgua = new BigDecimal("0.00");
		BigDecimal valorTotalEsgoto = new BigDecimal("0.00");

		if(valoresConta != null && !valoresConta.isEmpty()){

			Iterator valoresContaIt = valoresConta.iterator();
			CalcularValoresAguaEsgotoHelper valoresContaObjeto = null;

			while(valoresContaIt.hasNext()){

				valoresContaObjeto = (CalcularValoresAguaEsgotoHelper) valoresContaIt.next();

				// Valor Faturado de �gua
				if(valoresContaObjeto.getValorFaturadoAguaCategoria() != null){
					valorTotalAgua = valorTotalAgua.add(valoresContaObjeto.getValorFaturadoAguaCategoria());
				}

				// Valor Faturado de Esgoto
				if(valoresContaObjeto.getValorFaturadoEsgotoCategoria() != null){
					valorTotalEsgoto = valorTotalEsgoto.add(valoresContaObjeto.getValorFaturadoEsgotoCategoria());
				}

			}

		}

		BigDecimal valorTotalConta = new BigDecimal("0.00");

		valorTotalConta = valorTotalConta.add(valorTotalAgua);
		valorTotalConta = valorTotalConta.add(valorTotalEsgoto);
		valorTotalConta = valorTotalConta.add(valorTotalDebitosConta);

		valorTotalConta = valorTotalConta.subtract(valorTotalCreditosConta);

		if(valoresConta != null){
			// Consumo de Esgoto
			Integer consumoAgua2 = fachada.calcularConsumoTotalAguaOuEsgotoPorCategoria(valoresConta, ConstantesSistema.CALCULAR_AGUA);
			if(consumoAgua2 != null && consumoAgua2 > 0){
				retificarContaActionForm.setConsumoAgua(consumoAgua2.toString());
			}
			Integer consumoEsgoto2 = fachada.calcularConsumoTotalAguaOuEsgotoPorCategoria(valoresConta, ConstantesSistema.CALCULAR_ESGOTO);
			if(consumoEsgoto2 != null && consumoEsgoto2 > 0){
				retificarContaActionForm.setConsumoEsgoto(consumoEsgoto2.toString());
			}
		}

		// [UC0146][FS0025] � Validar leitura de faturamento
		try{

			if(ParametroFaturamento.P_MOTIVO_RETIFICACAO_OCORRENCIA_LEITURA.executar().equals(motivoRetificacao)){

				Integer consumoAguaFaturada = 0;
				Integer leituraFaturamento = 0;

				if(sessao.getAttribute("consumoAguaFaturada") != null){
					consumoAguaFaturada = new Integer(sessao.getAttribute("consumoAguaFaturada").toString());
				}

				if(sessao.getAttribute("leituraFaturamento") != null){
					leituraFaturamento = new Integer(sessao.getAttribute("leituraFaturamento").toString());
				}

				leituraFaturamento = leituraFaturamento - consumoAguaFaturada + consumoAguaAux;
				retificarContaActionForm.setNumeroLeituraAtualMedicaoHistoricoAgua(leituraFaturamento.toString());

			}

		}catch(ControladorException e){
			throw new ActionServletException("erro.parametro.nao.informado", "P_MOTIVO_RETIFICACAO_OCORRENCIA_LEITURA");
		}


		// // [FS0008] - Verificar valor da conta igual a zero
		// if(valorTotalConta.equals(new BigDecimal("0.00"))
		// && (valorTotalCreditosConta == null || valorTotalCreditosConta.equals(new
		// BigDecimal("0.00")))){
		// throw new ActionServletException("atencao.valor_conta_igual_zero");
		// }else if(valorTotalConta.compareTo(new BigDecimal("0.00")) == -1){
		// throw new ActionServletException("atencao.valor_conta_negativo");
		// }

		// Arredondando os valores obtidos para duas casas decimais
		valorTotalAgua.setScale(2, BigDecimal.ROUND_HALF_UP);
		valorTotalEsgoto.setScale(2, BigDecimal.ROUND_HALF_UP);
		valorTotalDebitosConta.setScale(2, BigDecimal.ROUND_HALF_UP);
		valorTotalCreditosConta.setScale(2, BigDecimal.ROUND_HALF_UP);
		valorTotalConta.setScale(2, BigDecimal.ROUND_HALF_UP);

		Collection colecaoAnteriorCreditosRealizados = new ArrayList();
		colecaoAnteriorCreditosRealizados.addAll(colecaoCreditoRealizado);


		// [FS0001 - Verificar valor total da conta negativo].
		Object[] retornoValorContaNegativo = fachada.verificarVaorTotalContaNegativo(valorTotalConta, valorTotalCreditosConta,
						valorTotalAgua.add(valorTotalEsgoto).add(valorTotalDebitosConta), colecaoAnteriorCreditosRealizados, usuarioLogado,
						false);

		Collection colecaoNovosCreditosRealizados = null;


		if(retornoValorContaNegativo != null){

			colecaoAnteriorCreditosRealizados = (Collection) retornoValorContaNegativo[1];
			colecaoNovosCreditosRealizados = (Collection) retornoValorContaNegativo[2];
			if(!Util.isVazioOrNulo(colecaoNovosCreditosRealizados)){
				colecaoAnteriorCreditosRealizados.addAll(colecaoNovosCreditosRealizados);

				sessao.setAttribute("checarValorNegativo", true);
			}

		}


		// Recalculando :
		valorTotalConta = new BigDecimal("0.00");

		valorTotalConta = valorTotalConta.add(valorTotalAgua);
		valorTotalConta = valorTotalConta.add(valorTotalEsgoto);
		valorTotalConta = valorTotalConta.add(valorTotalDebitosConta);

		if(!Util.isVazioOrNulo(colecaoAnteriorCreditosRealizados)){
			// C�lcula o valor total dos cr�ditos de uma conta de acordo com o informado pelo
			// usu�rio
			valorTotalCreditosConta = fachada.calcularValorTotalCreditoConta(colecaoAnteriorCreditosRealizados);
		}else{
			// C�lcula o valor total dos cr�ditos de uma conta de acordo com o informado pelo
			// usu�rio
			valorTotalCreditosConta = fachada.calcularValorTotalCreditoConta(colecaoCreditoRealizado, httpServletRequest.getParameterMap());
		}

		valorTotalConta = valorTotalConta.subtract(valorTotalCreditosConta);

		// Arredondando os valores obtidos para duas casas decimais
		valorTotalAgua.setScale(2, BigDecimal.ROUND_HALF_UP);
		valorTotalEsgoto.setScale(2, BigDecimal.ROUND_HALF_UP);
		valorTotalDebitosConta.setScale(2, BigDecimal.ROUND_HALF_UP);
		valorTotalCreditosConta.setScale(2, BigDecimal.ROUND_HALF_UP);
		valorTotalConta.setScale(2, BigDecimal.ROUND_HALF_UP);

		// Exibindo os valores calculados
		retificarContaActionForm.setValorAgua(Util.formatarMoedaReal(valorTotalAgua));
		retificarContaActionForm.setValorEsgoto(Util.formatarMoedaReal(valorTotalEsgoto));
		retificarContaActionForm.setValorDebito(Util.formatarMoedaReal(valorTotalDebitosConta));
		retificarContaActionForm.setValorCredito(Util.formatarMoedaReal(valorTotalCreditosConta));
		retificarContaActionForm.setValorTotal(Util.formatarMoedaReal(valorTotalConta));

		/*
		 * Colocado por Raphael Rossiter em 17/04/2007
		 * Objetivo: Manipula��o dos objetos que ser�o exibidos no formul�rio de acordo com a
		 * empresa
		 */
		SistemaParametro sistemaParametro = fachada.pesquisarParametrosDoSistema();
		httpServletRequest.setAttribute("empresaNome", sistemaParametro.getNomeAbreviadoEmpresa().trim());

		if(!Util.isVazioOuBranco(sessao.getAttribute("isPermitidoAlterarDataLeituraAnterior"))){
			httpServletRequest.setAttribute("isPermitidoAlterarDataLeituraAnterior", sessao
							.getAttribute("isPermitidoAlterarDataLeituraAnterior"));
		}

		// Verifica se a situa��o da liga��o de esgoto � fatur�vel, caso n�o seja limpa e desabilita
		// campos relativos aos dados da liga��o de esgoto.
		if(retificarContaActionForm.getIndicadorEsgotoFaturavel() == null
						|| retificarContaActionForm.getIndicadorEsgotoFaturavel().equals(ConstantesSistema.NAO.toString())){

			retificarContaActionForm.setConsumoEsgoto(null);
			retificarContaActionForm.setPercentualEsgoto(null);
			retificarContaActionForm.setLigacaoEsgotoPerfilId(null);
		}

		return retorno;
	}

	private Integer atualizarQuantidadeEconomiasCategoria(Collection colecaoCategorias, HttpServletRequest httpServletRequest){

		/*
		 * Atualizando a quantidade de economias por categoria de acordo com o
		 * informado pelo usu�rio
		 */

		Integer qtdEconnomia = 0;

		if(colecaoCategorias != null && !colecaoCategorias.isEmpty()){

			Iterator colecaoCategoriaIt = colecaoCategorias.iterator();
			Categoria categoria;
			Map<String, String[]> requestMap = httpServletRequest.getParameterMap();
			String qtdPorEconomia;

			while(colecaoCategoriaIt.hasNext()){
				categoria = (Categoria) colecaoCategoriaIt.next();

				if(requestMap.get("categoria" + categoria.getId().intValue()) != null){

					qtdPorEconomia = (requestMap.get("categoria" + categoria.getId().intValue()))[0];

					if(qtdPorEconomia == null || qtdPorEconomia.equalsIgnoreCase("")){

						throw new ActionServletException("atencao.campo_texto.obrigatorio", null, "Quantidade de economias");
					}

					categoria.setQuantidadeEconomiasCategoria(new Integer(qtdPorEconomia));

					qtdEconnomia = Util.somaInteiros(qtdEconnomia, new Integer(qtdPorEconomia));
				}
			}
		}

		return qtdEconnomia;
	}

	private Integer atualizarQuantidadeEconomiasSubcategoria(Collection colecaoSubcategorias, HttpServletRequest httpServletRequest){

		/*
		 * Atualizando a quantidade de economias por subcategoria de acordo com o
		 * informado pelo usu�rio
		 */

		Integer qtdEconnomia = 0;

		if(colecaoSubcategorias != null && !colecaoSubcategorias.isEmpty()){

			Iterator colecaoSubcategoriaIt = colecaoSubcategorias.iterator();
			Subcategoria subcategoria;
			Map<String, String[]> requestMap = httpServletRequest.getParameterMap();
			String qtdPorEconomia;

			while(colecaoSubcategoriaIt.hasNext()){
				subcategoria = (Subcategoria) colecaoSubcategoriaIt.next();

				if(requestMap.get("subcategoria" + subcategoria.getId().intValue()) != null){

					qtdPorEconomia = (requestMap.get("subcategoria" + subcategoria.getId().intValue()))[0];

					if(qtdPorEconomia == null || qtdPorEconomia.equalsIgnoreCase("")){

						throw new ActionServletException("atencao.campo_texto.obrigatorio", null, "Quantidade de economias");
					}

					subcategoria.setQuantidadeEconomias(new Integer(qtdPorEconomia));

					qtdEconnomia = Util.somaInteiros(qtdEconnomia, new Integer(qtdPorEconomia));
				}
			}
		}

		return qtdEconnomia;
	}

}
