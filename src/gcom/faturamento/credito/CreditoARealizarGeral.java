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

package gcom.faturamento.credito;

import gcom.interceptor.ObjetoTransacao;
import gcom.util.filtro.Filtro;
import gcom.util.filtro.ParametroSimples;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CreditoARealizarGeral
				extends ObjetoTransacao {

	private static final long serialVersionUID = 1L;

	/** identifier field */
	private Integer id;

	/** persistent field */
	private short indicadorHistorico;

	/** persistent field */
	private Date ultimaAlteracao;

	/** nullable persistent field */
	private CreditoARealizarHistorico creditoARealizarHistorico;

	/** nullable persistent field */
	private CreditoARealizar creditoARealizar;

	public static final short INDICADOR_HISTORICO_SIM = 1;

	public static final short INDICADOR_HISTORICO_NAO = 2;

	/** full constructor */
	public CreditoARealizarGeral(Integer id, short indicadorHistorico, Date ultimaAlteracao,
									CreditoARealizarHistorico creditoARealizarHistorico, CreditoARealizar creditoARealizar) {

		this.id = id;
		this.indicadorHistorico = indicadorHistorico;
		this.ultimaAlteracao = ultimaAlteracao;
		this.creditoARealizarHistorico = creditoARealizarHistorico;
		this.creditoARealizar = creditoARealizar;
	}

	/** default constructor */
	public CreditoARealizarGeral() {

	}

	/** minimal constructor */
	public CreditoARealizarGeral(Integer id, short indicadorHistorico, Date ultimaAlteracao) {

		this.id = id;
		this.indicadorHistorico = indicadorHistorico;
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public String toString(){

		return new ToStringBuilder(this).append("crarId", getId()).toString();
	}

	/**
	 * @return Retorna o campo creditoARealizar.
	 */
	public CreditoARealizar getCreditoARealizar(){

		return creditoARealizar;
	}

	/**
	 * @param creditoARealizar
	 *            O creditoARealizar a ser setado.
	 */
	public void setCreditoARealizar(CreditoARealizar creditoARealizar){

		this.creditoARealizar = creditoARealizar;
	}

	/**
	 * @return Retorna o campo creditoARealizarHistorico.
	 */
	public CreditoARealizarHistorico getCreditoARealizarHistorico(){

		return creditoARealizarHistorico;
	}

	/**
	 * @param creditoARealizarHistorico
	 *            O creditoARealizarHistorico a ser setado.
	 */
	public void setCreditoARealizarHistorico(CreditoARealizarHistorico creditoARealizarHistorico){

		this.creditoARealizarHistorico = creditoARealizarHistorico;
	}

	/**
	 * @return Retorna o campo id.
	 */
	public Integer getId(){

		return id;
	}

	/**
	 * @param id
	 *            O id a ser setado.
	 */
	public void setId(Integer id){

		this.id = id;
	}

	/**
	 * @return Retorna o campo indicadorHistorico.
	 */
	public short getIndicadorHistorico(){

		return indicadorHistorico;
	}

	/**
	 * @param indicadorHistorico
	 *            O indicadorHistorico a ser setado.
	 */
	public void setIndicadorHistorico(short indicadorHistorico){

		this.indicadorHistorico = indicadorHistorico;
	}

	/**
	 * @return Retorna o campo ultimaAlteracao.
	 */
	public Date getUltimaAlteracao(){

		return ultimaAlteracao;
	}

	/**
	 * @param ultimaAlteracao
	 *            O ultimaAlteracao a ser setado.
	 */
	public void setUltimaAlteracao(Date ultimaAlteracao){

		this.ultimaAlteracao = ultimaAlteracao;
	}

	public String[] retornaCamposChavePrimaria(){

		String[] retorno = new String[1];
		retorno[0] = "id";
		return retorno;
	}

	public Filtro retornaFiltro(){

		FiltroCreditoARealizarGeral filtroCreditoARealizarGeral = new FiltroCreditoARealizarGeral();

		filtroCreditoARealizarGeral.adicionarParametro(new ParametroSimples(FiltroCreditoARealizarGeral.ID, this.getId()));

		filtroCreditoARealizarGeral.adicionarCaminhoParaCarregamentoEntidade("creditoARealizarHistorico");
		filtroCreditoARealizarGeral.adicionarCaminhoParaCarregamentoEntidade("creditoARealizar");

		return filtroCreditoARealizarGeral;
	}

}