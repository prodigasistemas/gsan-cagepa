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

package gcom.arrecadacao.pagamento;

import gcom.util.filtro.Filtro;

/**
 * O filtro � respons�vel por armazenar os par�metros de pesquisa de pagamentos historico
 * 
 * @author Vivianne Sousa
 * @date 11/07/2007
 */
public class FiltroPagamentoHistorico
				extends Filtro {

	private static final long serialVersionUID = 1L;

	public final static String ID = "id";

	public final static String CONTA_ID = "conta.id";

	public final static String GUIA_PAGAMENTO_GERAL_ID = "guiaPagamentoGeral.id";

	public final static String NUMERO_PRESTACAO = "numeroPrestacao";

	public final static String DEBITO_A_COBRAR_ID = "debitoACobrar.id";

	public final static String IMOVEL = "imovel";

	public final static String IMOVEL_ID = "imovel.id";

	public final static String CLIENTE = "cliente";

	public final static String CLIENTE_ID = "cliente.id";

	public final static String CONTA = "conta";

	public final static String AVISO_BANCARIO = "avisoBancario";

	public final static String AVISO_BANCARIO_ID = "avisoBancario.id";

	public final static String ANO_MES_REFERENCIA_ARRECADACAO = "anoMesReferenciaArrecadacao";

	public final static String ANO_MES_REFERENCIA_PAGAMENTO = "anoMesReferenciaPagamento";

	public final static String DATA_PAGAMENTO = "dataPagamento";

	public final static String GUIA_PAGAMENTO_DOCUMENTO_TIPO_ID = "guiaPagamentoGeral.guiaPagamento.documentoTipo.id";

	public final static String DOCUMENTO_TIPO = "documentoTipo";

	public final static String DOCUMENTO_TIPO_ID = "documentoTipo.id";

	public final static String ARRECADACAO_FORMA = "arrecadacaoForma";

	public final static String ARRECADACAO_FORMA_ID = "arrecadacaoForma.id";

	public final static String PAGAMENTO_ARRECADACAO_FORMA = "arrecadacaoForma.id";

	public final static String PAGAMENTO_SITUACAO_ATUAL = "pagamentoSituacaoAtual";

	public final static String PAGAMENTO_SITUACAO_ATUAL_ID = "pagamentoSituacaoAtual.id";

	public final static String PAGAMENTO_GUIA_PAGAMENTO_CONTA_CLIENTE_CONTAS_CLIENTE_RELACAO_TIPO_ID = "guiaPagamentoGeral.guiaPagamento.conta.clienteContas.clienteRelacaoTipo.id";

	public final static String PAGAMENTO_GUIA_PAGAMENTO_CONTA_CLIENTE_CONTAS_CLIENTE_ID = "guiaPagamentoGeral.guiaPagamento.conta.clienteContas.cliente.id";

	public final static String PAGAMENTO_IMOVEL_CLIENTE_IMOVEIS_CLIENTE_RELACAO_TIPO_ID = "imovel.clienteImoveis.clienteRelacaoTipo.id";

	public final static String PAGAMENTO_IMOVEL_CLIENTE_IMOVEIS_CLIENTE_ID = "imovel.clienteImoveis.cliente.id";

	// public final static String
	// DEVOLUCAO_GUIA_DEVOLUCAO_GUIA_PAGAMENTO_CLIENTE_GUIA_PAGAMENTO_CLIENTE_RELACAO_TIPO_ID =
	// "guiaPagamento.guiaPagamento.clientesGuiaPagamento.clienteRelacaoTipo.id";

	public final static String PAGAMENTO_GUIA_PAGAMENTO_CLIENTE_GUIA_PAGAMENTO_CLIENTE_RELACAO_TIPO_ID = "guiaPagamentoGeral.guiaPagamento.clientesGuiaPagamento.clienteRelacaoTipo.id";

	public final static String PAGAMENTO_GUIA_PAGAMENTO_CLIENTE_GUIA_PAGAMENTO_CLIENTE_ID = "guiaPagamentoGeral.guiaPagamento.clientesGuiaPagamento.cliente.id";

	public final static String PAGAMENTO_GUIA_PAGAMENTO_CLIENTE_GUIA_PAGAMENTO_GUIA_PAGAMENTO_ID = "guiaPagamentoGeral.guiaPagamento.clientesGuiaPagamento.guiaPagamento.id";

	public final static String AVISO_BANCARIO_ARRECADADOR = "avisoBancario.arrecadador";

	public final static String DEBITO_TIPO = "debitoTipo";

	public final static String DEBITO_TIPO_ID = "debitoTipo.id";

	public final static String DEBITO_A_COBRAR = "debitoACobrar";

	public final static String PAGAMENTO_SITUACAO_ATUAL_DESCRICAO = "pagamentoSituacaoAtual.descricaoPagamentoSituacao";

	public final static String PAGAMENTO_SITUACAO_ANTERIOR_DESCRICAO = "pagamentoSituacaoAnterior.descricaoPagamentoSituacao";

	public final static String GUIA_PAGAMENTO_GERAL = "guiaPagamentoGeral";

	public final static String GUIA_PAGAMENTO = "guiaPagamentoGeral.guiaPagamento";

	public final static String GUIA_PAGAMENTO_ID = "guiaPagamentoGeral.guiaPagamento.id";

	public final static String ARRECADADOR_MOVIMENTO_ITEM = "arrecadadorMovimentoItem";

	public final static String ARRECADADOR_MOVIMENTO_ITEM_ID = "arrecadadorMovimentoItem.id";

	public final static String LOCALIDADE_ID = "localidade.id";

	public final static String PRE_PARCELAMENTO_OPCAO = "preParcelamentoOpcao";

	public final static String GUIA_PAGAMENTO_DEBITO_CREDITO_SITUACAO_ID = "guiaPagamentoGeral.guiaPagamento.debitoCreditoSituacaoAtual.id";

	public final static String PAGAMENTO_SITUACAO_ANTERIOR = "pagamentoSituacaoAnterior";

	public final static String LOCALIDADE = "localidade";

	public final static String ULTIMA_ALTERACAO = "ultimaAlteracao";

	public final static String GUIA_PAGAMENTO_HISTORICO = "guiaPagamentoGeral.guiaPagamentoHistorico";

	/**
	 * Construtor de FiltroPagamento
	 */
	public FiltroPagamentoHistorico() {

	}

	/**
	 * Construtor da classe FiltroPagamento
	 * 
	 * @param campoOrderBy
	 *            Descri��o do par�metro
	 */
	public FiltroPagamentoHistorico(String campoOrderBy) {

		this.campoOrderBy = campoOrderBy;
	}
}