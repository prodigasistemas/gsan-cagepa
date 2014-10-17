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

package gcom.faturamento.conta;

import gcom.cobranca.CobrancaDocumentoItem;
import gcom.integracao.acquagis.TabelaIntegracaoContaAtualizada;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ContaGeral
				implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
	private Integer id;

	/** persistent field */
	private short indicadorHistorico;

	/** persistent field */
	private Date ultimaAlteracao;

	/** nullable persistent field */
	private gcom.faturamento.conta.ContaImpressao contaImpressao;

	/** persistent field */
	private Set debitoAutomaticoMovimentos;

	/** nullable persistent field */
	private gcom.faturamento.conta.Conta conta;

	/** nullable persistent field */
	private ContaHistorico contaHistorico;

	private Set<CobrancaDocumentoItem> cobrancaDocumentoItem;

	private Set<TabelaIntegracaoContaAtualizada> contasAtualizadas;

	/**
	 * Description of the Field
	 */

	public final static short INDICADOR_HISTORICO = 1;

	/** full constructor */
	public ContaGeral(Integer id, short indicadorHistorico, Date ultimaAlteracao, ContaImpressao contaImpressao,
						Set debitoAutomaticoMovimentos, Conta conta, ContaHistorico contaHistorico) {

		this.id = id;
		this.indicadorHistorico = indicadorHistorico;
		this.ultimaAlteracao = ultimaAlteracao;
		this.contaImpressao = contaImpressao;
		this.debitoAutomaticoMovimentos = debitoAutomaticoMovimentos;
		this.conta = conta;
		this.contaHistorico = contaHistorico;
	}

	/** default constructor */
	public ContaGeral() {

	}

	public ContaGeral(Integer id) {

		this.id = id;
	}

	/** minimal constructor */
	public ContaGeral(Integer id, short indicadorHistorico, Date ultimaAlteracao, Set debitoAutomaticoMovimentos) {

		this.id = id;
		this.indicadorHistorico = indicadorHistorico;
		this.ultimaAlteracao = ultimaAlteracao;
		this.debitoAutomaticoMovimentos = debitoAutomaticoMovimentos;
	}

	public ContaImpressao getContaImpressao(){

		return this.contaImpressao;
	}

	public void setContaImpressao(ContaImpressao contaImpressao){

		this.contaImpressao = contaImpressao;
	}

	public Set getDebitoAutomaticoMovimentos(){

		return this.debitoAutomaticoMovimentos;
	}

	public void setDebitoAutomaticoMovimentos(Set debitoAutomaticoMovimentos){

		this.debitoAutomaticoMovimentos = debitoAutomaticoMovimentos;
	}

	public String toString(){

		return new ToStringBuilder(this).append("cntaId", getId()).toString();
	}

	public Integer getId(){

		return id;
	}

	public void setId(Integer id){

		this.id = id;
	}

	public short getIndicadorHistorico(){

		return indicadorHistorico;
	}

	public void setIndicadorHistorico(short indicadorHistorico){

		this.indicadorHistorico = indicadorHistorico;
	}

	public Date getUltimaAlteracao(){

		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao){

		this.ultimaAlteracao = ultimaAlteracao;
	}

	public String[] retornaCamposChavePrimaria(){

		String[] retorno = new String[1];
		retorno[0] = "id";
		return retorno;
	}

	public gcom.faturamento.conta.Conta getConta(){

		return conta;
	}

	public void setConta(gcom.faturamento.conta.Conta conta){

		this.conta = conta;
	}

	public ContaHistorico getContaHistorico(){

		return contaHistorico;
	}

	public void setContaHistorico(ContaHistorico contaHistorico){

		this.contaHistorico = contaHistorico;
	}

	public Set<CobrancaDocumentoItem> getCobrancaDocumentoItem(){

		return cobrancaDocumentoItem;
	}

	public void setCobrancaDocumentoItem(Set<CobrancaDocumentoItem> cobrancaDocumentoItem){

		this.cobrancaDocumentoItem = cobrancaDocumentoItem;
	}

	public Set<TabelaIntegracaoContaAtualizada> getContasAtualizadas(){

		return contasAtualizadas;
	}

	public void setContasAtualizadas(Set<TabelaIntegracaoContaAtualizada> contasAtualizadas){

		this.contasAtualizadas = contasAtualizadas;
	}

}