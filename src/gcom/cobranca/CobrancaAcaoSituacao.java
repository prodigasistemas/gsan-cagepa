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

package gcom.cobranca;

import gcom.util.tabelaauxiliar.abreviada.TabelaAuxiliarAbreviada;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CobrancaAcaoSituacao
				extends TabelaAuxiliarAbreviada
				implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
	/*
	 * private Integer id;
	 *//** persistent field */
	/*
	 * private String descricao;
	 *//** persistent field */
	/*
	 * private String descricaoAbreviada;
	 *//** persistent field */
	/*
	 * private short indicadorUso;
	 *//** persistent field */
	/*
	 * private Date ultimaAlteracao;
	 */

	/** persistent field */
	private Set resumoCobrancaAcaos;

	/** persistent field */
	private Set cobrancaDocumentos;

	public static final Integer PENDENTE = Integer.valueOf(1);

	public static final Integer EXECUTADA = Integer.valueOf(2);

	public static final Integer CANCELADA = Integer.valueOf(3);

	public static final Integer CANCELADA_PRAZO = Integer.valueOf(4);

	public static final Integer FISCALIZADA = Integer.valueOf(5);

	public static final Integer ENVIADOS = Integer.valueOf(6);

	public static final Integer NAO_ENTREGUE = Integer.valueOf(7);

	public static final Integer ENTREGUE = Integer.valueOf(8);

	/** default constructor */
	public CobrancaAcaoSituacao() {

	}

	public String toString(){

		return new ToStringBuilder(this).append("castId", getId()).toString();
	}

	/**
	 * @return Retorna o campo castId.
	 */
	/*
	 * public Integer getId(){
	 * return id;
	 * }
	 *//**
	 * @param castId
	 *            O castId a ser setado.
	 */
	/*
	 * public void setId(Integer castId){
	 * this.id = castId;
	 * }
	 */
	/**
	 * @return Retorna o campo cobrancaDocumentos.
	 */
	public Set getCobrancaDocumentos(){

		return cobrancaDocumentos;
	}

	/**
	 * @param cobrancaDocumentos
	 *            O cobrancaDocumentos a ser setado.
	 */
	public void setCobrancaDocumentos(Set cobrancaDocumentos){

		this.cobrancaDocumentos = cobrancaDocumentos;
	}

	/**
	 * @return Retorna o campo descricao.
	 */
	/*
	 * public String getDescricao(){
	 * return descricao;
	 * }
	 *//**
	 * @param descricao
	 *            O descricao a ser setado.
	 */
	/*
	 * public void setDescricao(String descricao){
	 * this.descricao = descricao;
	 * }
	 *//**
	 * @return Retorna o campo descricaoAbreviada.
	 */
	/*
	 * public String getDescricaoAbreviada(){
	 * return descricaoAbreviada;
	 * }
	 *//**
	 * @param descricaoAbreviada
	 *            O descricaoAbreviada a ser setado.
	 */
	/*
	 * public void setDescricaoAbreviada(String descricaoAbreviada){
	 * this.descricaoAbreviada = descricaoAbreviada;
	 * }
	 *//**
	 * @return Retorna o campo indicadorUso.
	 */
	/*
	 * public short getIndicadorUso(){
	 * return indicadorUso;
	 * }
	 *//**
	 * @param indicadorUso
	 *            O indicadorUso a ser setado.
	 */
	/*
	 * public void setIndicadorUso(short indicadorUso){
	 * this.indicadorUso = indicadorUso;
	 * }
	 */
	/**
	 * @return Retorna o campo resumoCobrancaAcaos.
	 */
	public Set getResumoCobrancaAcaos(){

		return resumoCobrancaAcaos;
	}

	/**
	 * @param resumoCobrancaAcaos
	 *            O resumoCobrancaAcaos a ser setado.
	 */
	public void setResumoCobrancaAcaos(Set resumoCobrancaAcaos){

		this.resumoCobrancaAcaos = resumoCobrancaAcaos;
	}

	@Override
	public String[] retornaCamposChavePrimaria(){

		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return Retorna o campo ultimaAltercao.
	 */
	/*
	 * public Date getUltimaAlteracao(){
	 * return ultimaAlteracao;
	 * }
	 *//**
	 * @param ultimaAltercao
	 *            O ultimaAltercao a ser setado.
	 */
	/*
	 * public void setUltimaAlteracao(Date ultimaAlteracao){
	 * this.ultimaAlteracao = ultimaAlteracao;
	 * }
	 */

}