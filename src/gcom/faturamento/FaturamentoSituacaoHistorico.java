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

import gcom.cadastro.imovel.Imovel;
import gcom.interceptor.ControleAlteracao;
import gcom.interceptor.ObjetoTransacao;
import gcom.seguranca.acesso.usuario.Usuario;
import gcom.util.filtro.Filtro;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
@ControleAlteracao()
public class FaturamentoSituacaoHistorico
				extends ObjetoTransacao {

	public static final int ATRIBUTOS_VALIDAR_SITUACAO_ESPECIAL_FATURAMENTO = 435;

	private static final long serialVersionUID = 1L;

	/** identifier field */
	private Integer id;

	/** persistent field */
	@ControleAlteracao(funcionalidade = {ATRIBUTOS_VALIDAR_SITUACAO_ESPECIAL_FATURAMENTO})
	private Integer anoMesFaturamentoSituacaoInicio;

	/** persistent field */
	@ControleAlteracao(funcionalidade = {ATRIBUTOS_VALIDAR_SITUACAO_ESPECIAL_FATURAMENTO})
	private Integer anoMesFaturamentoSituacaoFim;

	/** nullable persistent field */
	@ControleAlteracao(funcionalidade = {ATRIBUTOS_VALIDAR_SITUACAO_ESPECIAL_FATURAMENTO})
	private Date ultimaAlteracao;

	/** persistent field */
	@ControleAlteracao(funcionalidade = {ATRIBUTOS_VALIDAR_SITUACAO_ESPECIAL_FATURAMENTO})
	private gcom.faturamento.FaturamentoSituacaoMotivo faturamentoSituacaoMotivo;

	/** persistent field */
	@ControleAlteracao(funcionalidade = {ATRIBUTOS_VALIDAR_SITUACAO_ESPECIAL_FATURAMENTO})
	private Imovel imovel;

	/** persistent field */
	@ControleAlteracao(funcionalidade = {ATRIBUTOS_VALIDAR_SITUACAO_ESPECIAL_FATURAMENTO})
	private gcom.faturamento.FaturamentoSituacaoTipo faturamentoSituacaoTipo;

	/** persistent field */
	@ControleAlteracao(funcionalidade = {ATRIBUTOS_VALIDAR_SITUACAO_ESPECIAL_FATURAMENTO})
	private Integer anoMesFaturamentoRetirada;

	/** nullable persistent field */
	@ControleAlteracao(funcionalidade = {ATRIBUTOS_VALIDAR_SITUACAO_ESPECIAL_FATURAMENTO})
	private Usuario usuario;

	/** persistent field */
	@ControleAlteracao(funcionalidade = {ATRIBUTOS_VALIDAR_SITUACAO_ESPECIAL_FATURAMENTO})
	private Integer volume;

	/** nullable persistent field */
	@ControleAlteracao(funcionalidade = {ATRIBUTOS_VALIDAR_SITUACAO_ESPECIAL_FATURAMENTO})
	private BigDecimal percentualEsgoto;

	/** full constructor */
	public FaturamentoSituacaoHistorico(Integer anoMesFaturamentoSituacaoInicio, Integer anoMesFaturamentoSituacaoFim,
										Date ultimaAlteracao, gcom.faturamento.FaturamentoSituacaoMotivo faturamentoSituacaoMotivo,
										Imovel imovel, gcom.faturamento.FaturamentoSituacaoTipo faturamentoSituacaoTipo,
										Integer anoMesFaturamentoRetirada, Usuario usuario, Integer volume, BigDecimal percentualEsgoto) {

		this.anoMesFaturamentoSituacaoInicio = anoMesFaturamentoSituacaoInicio;
		this.anoMesFaturamentoSituacaoFim = anoMesFaturamentoSituacaoFim;
		this.ultimaAlteracao = ultimaAlteracao;
		this.faturamentoSituacaoMotivo = faturamentoSituacaoMotivo;
		this.imovel = imovel;
		this.faturamentoSituacaoTipo = faturamentoSituacaoTipo;
		this.anoMesFaturamentoRetirada = anoMesFaturamentoRetirada;
		this.usuario = usuario;
		this.volume = volume;
		this.percentualEsgoto = percentualEsgoto;
	}

	/** default constructor */
	public FaturamentoSituacaoHistorico() {

	}

	/** minimal constructor */
	public FaturamentoSituacaoHistorico(Integer anoMesFaturamentoSituacaoInicio, Integer anoMesFaturamentoSituacaoFim,
										gcom.faturamento.FaturamentoSituacaoMotivo faturamentoSituacaoMotivo, Imovel imovel,
										gcom.faturamento.FaturamentoSituacaoTipo faturamentoSituacaoTipo,
										Integer anoMesFaturamentoRetirada, Usuario usuario) {

		this.anoMesFaturamentoSituacaoInicio = anoMesFaturamentoSituacaoInicio;
		this.anoMesFaturamentoSituacaoFim = anoMesFaturamentoSituacaoFim;
		this.faturamentoSituacaoMotivo = faturamentoSituacaoMotivo;
		this.imovel = imovel;
		this.faturamentoSituacaoTipo = faturamentoSituacaoTipo;
		this.anoMesFaturamentoRetirada = anoMesFaturamentoRetirada;
		this.anoMesFaturamentoRetirada = anoMesFaturamentoRetirada;
		this.usuario = usuario;
	}

	public Usuario getUsuario(){

		return usuario;
	}

	public void setUsuario(Usuario usuario){

		this.usuario = usuario;
	}

	public Integer getId(){

		return this.id;
	}

	public void setId(Integer id){

		this.id = id;
	}

	public Date getUltimaAlteracao(){

		return this.ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao){

		this.ultimaAlteracao = ultimaAlteracao;
	}

	public gcom.faturamento.FaturamentoSituacaoMotivo getFaturamentoSituacaoMotivo(){

		return this.faturamentoSituacaoMotivo;
	}

	public void setFaturamentoSituacaoMotivo(gcom.faturamento.FaturamentoSituacaoMotivo faturamentoSituacaoMotivo){

		this.faturamentoSituacaoMotivo = faturamentoSituacaoMotivo;
	}

	public Imovel getImovel(){

		return this.imovel;
	}

	public void setImovel(Imovel imovel){

		this.imovel = imovel;
	}

	public gcom.faturamento.FaturamentoSituacaoTipo getFaturamentoSituacaoTipo(){

		return this.faturamentoSituacaoTipo;
	}

	public void setFaturamentoSituacaoTipo(gcom.faturamento.FaturamentoSituacaoTipo faturamentoSituacaoTipo){

		this.faturamentoSituacaoTipo = faturamentoSituacaoTipo;
	}

	/**
	 * @return Retorna o campo anoMesFaturamentoRetirada.
	 */
	public Integer getAnoMesFaturamentoRetirada(){

		return anoMesFaturamentoRetirada;
	}

	/**
	 * @param anoMesFaturamentoRetirada
	 *            O anoMesFaturamentoRetirada a ser setado.
	 */
	public void setAnoMesFaturamentoRetirada(Integer anoMesFaturamentoRetirada){

		this.anoMesFaturamentoRetirada = anoMesFaturamentoRetirada;
	}

	/**
	 * @return Retorna o campo anoMesFaturamentoSituacaoFim.
	 */
	public Integer getAnoMesFaturamentoSituacaoFim(){

		return anoMesFaturamentoSituacaoFim;
	}

	/**
	 * @param anoMesFaturamentoSituacaoFim
	 *            O anoMesFaturamentoSituacaoFim a ser setado.
	 */
	public void setAnoMesFaturamentoSituacaoFim(Integer anoMesFaturamentoSituacaoFim){

		this.anoMesFaturamentoSituacaoFim = anoMesFaturamentoSituacaoFim;
	}

	/**
	 * @return Retorna o campo anoMesFaturamentoSituacaoInicio.
	 */
	public Integer getAnoMesFaturamentoSituacaoInicio(){

		return anoMesFaturamentoSituacaoInicio;
	}

	/**
	 * @param anoMesFaturamentoSituacaoInicio
	 *            O anoMesFaturamentoSituacaoInicio a ser setado.
	 */
	public void setAnoMesFaturamentoSituacaoInicio(Integer anoMesFaturamentoSituacaoInicio){

		this.anoMesFaturamentoSituacaoInicio = anoMesFaturamentoSituacaoInicio;
	}

	public String toString(){

		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	public Integer getVolume(){

		return volume;
	}

	public void setVolume(Integer volume){

		this.volume = volume;
	}

	public BigDecimal getPercentualEsgoto(){

		return percentualEsgoto;
	}

	public void setPercentualEsgoto(BigDecimal percentualEsgoto){

		this.percentualEsgoto = percentualEsgoto;
	}

	@Override
	public Filtro retornaFiltro(){

		// TODO Auto-generated method stub
		return new FiltroFaturamentoSituacaoHistorico();
	}

	@Override
	public String[] retornaCamposChavePrimaria(){

		// TODO Auto-generated method stub
		String[] retorno = {"id"};
		return retorno;
	}

	@Override
	public void initializeLazy(){

		imovel.initializeLazy();
	}


}
