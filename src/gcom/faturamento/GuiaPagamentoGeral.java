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

package gcom.faturamento;

import gcom.arrecadacao.pagamento.FiltroGuiaPagamentoGeral;
import gcom.arrecadacao.pagamento.GuiaPagamento;
import gcom.arrecadacao.pagamento.GuiaPagamentoHistorico;
import gcom.interceptor.ObjetoTransacao;
import gcom.util.filtro.Filtro;
import gcom.util.filtro.ParametroSimples;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class GuiaPagamentoGeral
				extends ObjetoTransacao
				implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
	private Integer id;

	/** persistent field */
	private short indicadorHistorico;

	/** persistent field */
	private Date ultimaAlteracao;

	/** nullable persistent field */
	private GuiaPagamento guiaPagamento;

	/** persistent field */
	private Set cobrancaDocumentoItems;

	/** persistent field */
	private Set parcelamentoItems;

	private GuiaPagamentoHistorico guiaPagamentoHistorico;

	/**
	 * Description of the Field
	 */

	public final static short INDICADOR_HISTORICO = 1;

	/** full constructor */
	public GuiaPagamentoGeral(Integer id, short indicadorHistorico, Date ultimaAlteracao, GuiaPagamento guiaPagamento,
								GuiaPagamentoHistorico guiaPagamentoHistorico, Set cobrancaDocumentoItems, Set parcelamentoItems) {

		this.id = id;
		this.indicadorHistorico = indicadorHistorico;
		this.ultimaAlteracao = ultimaAlteracao;
		this.guiaPagamento = guiaPagamento;
		this.cobrancaDocumentoItems = cobrancaDocumentoItems;
		this.parcelamentoItems = parcelamentoItems;
		this.guiaPagamentoHistorico = guiaPagamentoHistorico;
	}

	/** default constructor */
	public GuiaPagamentoGeral() {

	}

	/** minimal constructor */
	public GuiaPagamentoGeral(Integer id, short indicadorHistorico, Date ultimaAlteracao, Set cobrancaDocumentoItems, Set parcelamentoItems) {

		this.id = id;
		this.indicadorHistorico = indicadorHistorico;
		this.ultimaAlteracao = ultimaAlteracao;
		this.cobrancaDocumentoItems = cobrancaDocumentoItems;
		this.parcelamentoItems = parcelamentoItems;
	}

	public Set getCobrancaDocumentoItems(){

		return this.cobrancaDocumentoItems;
	}

	public void setCobrancaDocumentoItems(Set cobrancaDocumentoItems){

		this.cobrancaDocumentoItems = cobrancaDocumentoItems;
	}

	public Set getParcelamentoItems(){

		return this.parcelamentoItems;
	}

	public void setParcelamentoItems(Set parcelamentoItems){

		this.parcelamentoItems = parcelamentoItems;
	}

	public String toString(){

		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	public GuiaPagamento getGuiaPagamento(){

		return guiaPagamento;
	}

	public void setGuiaPagamento(GuiaPagamento guiaPagamento){

		this.guiaPagamento = guiaPagamento;
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

	public GuiaPagamentoHistorico getGuiaPagamentoHistorico(){

		return guiaPagamentoHistorico;
	}

	public void setGuiaPagamentoHistorico(GuiaPagamentoHistorico guiaPagamentoHistorico){

		this.guiaPagamentoHistorico = guiaPagamentoHistorico;
	}

	@Override
	public Filtro retornaFiltro(){

		FiltroGuiaPagamentoGeral filtroGuiaPagamentoGeral = new FiltroGuiaPagamentoGeral();
		filtroGuiaPagamentoGeral.adicionarParametro(new ParametroSimples(FiltroGuiaPagamentoGeral.ID, this.id));

		return filtroGuiaPagamentoGeral;
	}

	@Override
	public String[] retornaCamposChavePrimaria(){

		String[] retorno = new String[1];
		retorno[0] = "id";
		return retorno;
	}

	@Override
	public String getDescricaoParaRegistroTransacao(){

		return getId() + "";
	}

}
