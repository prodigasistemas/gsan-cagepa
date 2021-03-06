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

package gcom.cadastro.dadocensitario;

import gcom.cadastro.geografico.Municipio;
import gcom.interceptor.ControleAlteracao;
import gcom.interceptor.ObjetoTransacao;
import gcom.util.filtro.Filtro;
import gcom.util.filtro.ParametroSimples;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
@ControleAlteracao()
public class MunicipioDadosCensitario
				extends ObjetoTransacao {

	private static final long serialVersionUID = 1L;

	public static final int ATRIBUTOS_DADOS_CENSITARIOS_INSERIR = 23773;

	public static final int ATRIBUTOS_DADOS_CENSITARIOS_REMOVER = 33097;

	public static final int ATRIBUTOS_DADOS_CENSITARIOS_ATUALIZAR = 34133;

	/** identifier field */
	private Integer id;

	/** persistent field */
	@ControleAlteracao(funcionalidade = {ATRIBUTOS_DADOS_CENSITARIOS_INSERIR, ATRIBUTOS_DADOS_CENSITARIOS_REMOVER, ATRIBUTOS_DADOS_CENSITARIOS_ATUALIZAR})
	private int anoMesReferencia;

	/** nullable persistent field */
	@ControleAlteracao(funcionalidade = {ATRIBUTOS_DADOS_CENSITARIOS_INSERIR, ATRIBUTOS_DADOS_CENSITARIOS_REMOVER, ATRIBUTOS_DADOS_CENSITARIOS_ATUALIZAR})
	private Integer numeroPopulacaoUrbana;

	/** nullable persistent field */
	@ControleAlteracao(funcionalidade = {ATRIBUTOS_DADOS_CENSITARIOS_INSERIR, ATRIBUTOS_DADOS_CENSITARIOS_REMOVER, ATRIBUTOS_DADOS_CENSITARIOS_ATUALIZAR})
	private BigDecimal taxaAnualCrescimentoPopulacaoUrbana;

	/** nullable persistent field */
	@ControleAlteracao(funcionalidade = {ATRIBUTOS_DADOS_CENSITARIOS_INSERIR, ATRIBUTOS_DADOS_CENSITARIOS_REMOVER, ATRIBUTOS_DADOS_CENSITARIOS_ATUALIZAR})
	private BigDecimal taxaOcupacaoUrbana;

	/** nullable persistent field */
	@ControleAlteracao(funcionalidade = {ATRIBUTOS_DADOS_CENSITARIOS_INSERIR, ATRIBUTOS_DADOS_CENSITARIOS_REMOVER, ATRIBUTOS_DADOS_CENSITARIOS_ATUALIZAR})
	private Integer numeroPopulacaoRural;

	/** nullable persistent field */
	@ControleAlteracao(funcionalidade = {ATRIBUTOS_DADOS_CENSITARIOS_INSERIR, ATRIBUTOS_DADOS_CENSITARIOS_REMOVER, ATRIBUTOS_DADOS_CENSITARIOS_ATUALIZAR})
	private BigDecimal taxaCrescimentoPopulacaoRural;

	/** nullable persistent field */
	@ControleAlteracao(funcionalidade = {ATRIBUTOS_DADOS_CENSITARIOS_INSERIR, ATRIBUTOS_DADOS_CENSITARIOS_REMOVER, ATRIBUTOS_DADOS_CENSITARIOS_ATUALIZAR})
	private BigDecimal taxaOcupacaoRural;

	/** nullable persistent field */
	@ControleAlteracao(funcionalidade = {ATRIBUTOS_DADOS_CENSITARIOS_INSERIR, ATRIBUTOS_DADOS_CENSITARIOS_REMOVER, ATRIBUTOS_DADOS_CENSITARIOS_ATUALIZAR})
	private Date ultimaAlteracao;

	/** persistent field */
	@ControleAlteracao(value = FiltroMunicipioDadosCensitario.MUNICIPIO, funcionalidade = {ATRIBUTOS_DADOS_CENSITARIOS_INSERIR, ATRIBUTOS_DADOS_CENSITARIOS_REMOVER, ATRIBUTOS_DADOS_CENSITARIOS_ATUALIZAR})
	private Municipio municipio;

	/** persistent field */
	@ControleAlteracao(value = FiltroMunicipioDadosCensitario.FONTE_DADOS_CENSITARIO, funcionalidade = {ATRIBUTOS_DADOS_CENSITARIOS_INSERIR, ATRIBUTOS_DADOS_CENSITARIOS_REMOVER, ATRIBUTOS_DADOS_CENSITARIOS_ATUALIZAR})
	private gcom.cadastro.dadocensitario.FonteDadosCensitario fonteDadosCensitario;

	/** full constructor */
	public MunicipioDadosCensitario(int anoMesReferencia, Integer numeroPopulacaoUrbana, BigDecimal taxaAnualCrescimentoPopulacaoUrbana,
									BigDecimal taxaOcupacaoUrbana, Integer numeroPopulacaoRural, BigDecimal taxaCrescimentoPopulacaoRural,
									BigDecimal taxaOcupacaoRural, Date ultimaAlteracao, Municipio municipio,
									gcom.cadastro.dadocensitario.FonteDadosCensitario fonteDadosCensitario) {

		this.anoMesReferencia = anoMesReferencia;
		this.numeroPopulacaoUrbana = numeroPopulacaoUrbana;
		this.taxaAnualCrescimentoPopulacaoUrbana = taxaAnualCrescimentoPopulacaoUrbana;
		this.taxaOcupacaoUrbana = taxaOcupacaoUrbana;
		this.numeroPopulacaoRural = numeroPopulacaoRural;
		this.taxaCrescimentoPopulacaoRural = taxaCrescimentoPopulacaoRural;
		this.taxaOcupacaoRural = taxaOcupacaoRural;
		this.ultimaAlteracao = ultimaAlteracao;
		this.municipio = municipio;
		this.fonteDadosCensitario = fonteDadosCensitario;
	}

	/** default constructor */
	public MunicipioDadosCensitario() {

	}

	/** minimal constructor */
	public MunicipioDadosCensitario(int anoMesReferencia, Municipio municipio,
									gcom.cadastro.dadocensitario.FonteDadosCensitario fonteDadosCensitario) {

		this.anoMesReferencia = anoMesReferencia;
		this.municipio = municipio;
		this.fonteDadosCensitario = fonteDadosCensitario;
	}

	public Integer getId(){

		return this.id;
	}

	public void setId(Integer id){

		this.id = id;
	}

	public int getAnoMesReferencia(){

		return this.anoMesReferencia;
	}

	public void setAnoMesReferencia(int anoMesReferencia){

		this.anoMesReferencia = anoMesReferencia;
	}

	public Integer getNumeroPopulacaoUrbana(){

		return this.numeroPopulacaoUrbana;
	}

	public void setNumeroPopulacaoUrbana(Integer numeroPopulacaoUrbana){

		this.numeroPopulacaoUrbana = numeroPopulacaoUrbana;
	}

	public BigDecimal getTaxaAnualCrescimentoPopulacaoUrbana(){

		return this.taxaAnualCrescimentoPopulacaoUrbana;
	}

	public void setTaxaAnualCrescimentoPopulacaoUrbana(BigDecimal taxaAnualCrescimentoPopulacaoUrbana){

		this.taxaAnualCrescimentoPopulacaoUrbana = taxaAnualCrescimentoPopulacaoUrbana;
	}

	public BigDecimal getTaxaOcupacaoUrbana(){

		return this.taxaOcupacaoUrbana;
	}

	public void setTaxaOcupacaoUrbana(BigDecimal taxaOcupacaoUrbana){

		this.taxaOcupacaoUrbana = taxaOcupacaoUrbana;
	}

	public Integer getNumeroPopulacaoRural(){

		return this.numeroPopulacaoRural;
	}

	public void setNumeroPopulacaoRural(Integer numeroPopulacaoRural){

		this.numeroPopulacaoRural = numeroPopulacaoRural;
	}

	public BigDecimal getTaxaCrescimentoPopulacaoRural(){

		return this.taxaCrescimentoPopulacaoRural;
	}

	public void setTaxaCrescimentoPopulacaoRural(BigDecimal taxaCrescimentoPopulacaoRural){

		this.taxaCrescimentoPopulacaoRural = taxaCrescimentoPopulacaoRural;
	}

	public BigDecimal getTaxaOcupacaoRural(){

		return this.taxaOcupacaoRural;
	}

	public void setTaxaOcupacaoRural(BigDecimal taxaOcupacaoRural){

		this.taxaOcupacaoRural = taxaOcupacaoRural;
	}

	public Date getUltimaAlteracao(){

		return this.ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao){

		this.ultimaAlteracao = ultimaAlteracao;
	}

	public Municipio getMunicipio(){

		return this.municipio;
	}

	public void setMunicipio(Municipio municipio){

		this.municipio = municipio;
	}

	public gcom.cadastro.dadocensitario.FonteDadosCensitario getFonteDadosCensitario(){

		return this.fonteDadosCensitario;
	}

	public void setFonteDadosCensitario(gcom.cadastro.dadocensitario.FonteDadosCensitario fonteDadosCensitario){

		this.fonteDadosCensitario = fonteDadosCensitario;
	}

	public String toString(){

		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	public String[] retornaCamposChavePrimaria(){

		String[] retorno = new String[1];
		retorno[0] = "id";
		return retorno;
	}

	public String[] retornarAtributosInformacoesOperacaoEfetuada(){

		String[] atributos = {"municipio.id", "formatarAnoMesParaMesAno"};
		return atributos;
	}

	public String[] retornarLabelsInformacoesOperacaoEfetuada(){

		String[] labels = {"Municipio", "Ano/Mes Referencia"};
		return labels;
	}

	public Filtro retornaFiltro(){

		FiltroMunicipioDadosCensitario filtroMunicipioDadosCensitario = new FiltroMunicipioDadosCensitario();
		filtroMunicipioDadosCensitario.adicionarParametro(new ParametroSimples(FiltroMunicipioDadosCensitario.ID, this.getId()));
		filtroMunicipioDadosCensitario.adicionarCaminhoParaCarregamentoEntidade(FiltroMunicipioDadosCensitario.MUNICIPIO);
		filtroMunicipioDadosCensitario.adicionarCaminhoParaCarregamentoEntidade(FiltroLocalidadeDadosCensitario.FONTE_DADOS_CENSITARIO);

		return filtroMunicipioDadosCensitario;
	}

	public String getFormatarAnoMesParaMesAno(){

		String anoMesRecebido = "" + this.getAnoMesReferencia();
		String mes = anoMesRecebido.substring(4, 6);
		String ano = anoMesRecebido.substring(0, 4);
		String anoMesFormatado = mes + "/" + ano;

		return anoMesFormatado.toString();
	}

}
