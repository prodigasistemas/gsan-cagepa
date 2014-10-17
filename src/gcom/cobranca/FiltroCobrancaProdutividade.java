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
 * GSANPCG
 * Eduardo Henrique
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

package gcom.cobranca;

import gcom.util.filtro.Filtro;

import java.io.Serializable;

/**
 * @author Pedro Alexandre
 * @created 08 de Fevereiro de 2006
 */

public class FiltroCobrancaProdutividade
				extends Filtro
				implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for the FiltroCobrancaSucesso object
	 */
	public FiltroCobrancaProdutividade() {

	}

	public FiltroCobrancaProdutividade(String campoOrderBy) {

		this.campoOrderBy = campoOrderBy;
	}

	public final static String ID = "id";

	public final static String ANO_MES_REFERENCIA = "anoMesReferencia";

	public final static String DATA = "data";

	public final static String QUANTIDADE_CONTAS = "quantidadeContas";

	public final static String QUANTIDADE_DOCUMENTOS = "quantidadeDocumentos";

	public final static String QUANTIDADE_CLIENTES = "quantidadeClientes";

	public final static String IDENTIFICADOR_HIDROMETRO = "identificadorHidrometro";

	public final static String IDENTIFICADOR_PRAZO = "identificadorPrazo";

	public final static String VALOR_CONTAS = "valorContas";

	public final static String VALOR_DOCUMENTOS = "valorDocumentos";

	public final static String ULTIMA_ALTERACAO = "ultimaAlteracao";

	public final static String COMANDO_ACAO_CRONOGRAMA_ID = "comandoAcaoCronograma.id";

	public final static String COMANDO_ACAO_EVENTUAL_ID = "comandoAcaoEventual.id";

	public final static String COBRANCA_ACAO_ID = "cobrancaAcao.id";

	public final static String EMPRESA_ID = "empresa.id";

	public final static String DOCUMENTO_TIPO_ID = "documentoTipo.id";

	public final static String SERVICO_TIPO = "servicoTipo";

	public final static String SERVICO_TIPO_ID = "servicoTipo.id";

	public final static String SUPRESSAO_TIPO_ID = "supressaoTipo.id";

	public final static String CORTE_TIPO_ID = "corteTipo.id";

	public final static String ATENDIMENTO_MOTIVO_ENCERRAMENTO_ID = "atendimentoMotivoEncerramento.id";

	public final static String COBRANCA_DEBITO_SITUACAO_ID = "cobrancaDebitoSituacao.id";

	public final static String COBRANCA_CONTRATO = "cobrancaContrato";
}