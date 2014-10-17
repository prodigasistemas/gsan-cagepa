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

import gcom.atendimentopublico.ligacaoagua.LigacaoAguaSituacao;
import gcom.cadastro.cliente.EsferaPoder;
import gcom.cadastro.imovel.Categoria;
import gcom.cadastro.imovel.CategoriaTipo;
import gcom.cadastro.imovel.ImovelPerfil;
import gcom.cadastro.localidade.GerenciaRegional;
import gcom.cadastro.localidade.Localidade;
import gcom.cadastro.localidade.Quadra;
import gcom.cadastro.localidade.SetorComercial;
import gcom.cadastro.localidade.UnidadeNegocio;
import gcom.faturamento.consumotarifa.ConsumoTarifa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class HistogramaAguaLigacao
				implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** identifier field */
	private Integer id;

	/** persistent field */
	private int anoMesReferencia;

	/** persistent field */
	private int codigoSetorComercial;

	/** persistent field */
	private int numeroQuadra;

	/** persistent field */
	private short indicadorLigacaoMista;

	/** persistent field */
	private short indicadorConsumoReal;

	/** persistent field */
	private short indicadorHidrometro;

	/** persistent field */
	private short indicadorPoco;

	/** persistent field */
	private short indicadorVolFixadoAgua;

	/** persistent field */
	private int quantidadeConsumo;

	/** persistent field */
	private int quantidadeLigacao;

	/** persistent field */
	private int quantidadeEconomiaLigacao;

	/** persistent field */
	private BigDecimal valorFaturadoLigacao;

	/** persistent field */
	private int volumeFaturadoLigacao;

	/** persistent field */
	private Date ultimaAlteracao;

	/** persistent field */
	private GerenciaRegional gerenciaRegional;

	/** persistent field */
	private Localidade localidade;

	/** persistent field */
	private Localidade localidadeElo;

	/** persistent field */
	private Quadra quadra;

	/** persistent field */
	private ConsumoTarifa consumoTarifa;

	/** persistent field */
	private ImovelPerfil imovelPerfil;

	/** persistent field */
	private LigacaoAguaSituacao ligacaoAguaSituacao;

	/** persistent field */
	private UnidadeNegocio unidadeNegocio;

	/** persistent field */
	private EsferaPoder esferaPoder;

	/** persistent field */
	private Categoria categoria;

	/** persistent field */
	private CategoriaTipo categoriaTipo;

	/** persistent field */
	private SetorComercial setorComercial;

	/** persistent field */
	private int quantidadeLigacaoRefaturamento;

	/** persistent field */
	private int quantidadeEconomiaLigacaoRefaturamento;

	/** persistent field */
	private BigDecimal valorFaturadoLigacaoRefaturamento;

	/** persistent field */
	private int volumeFaturadoLigacaoRefaturamento;

	/** full constructor */
	public HistogramaAguaLigacao(Integer id, int anoMesReferencia, int codigoSetorComercial, int numeroQuadra, short indicadorLigacaoMista,
									short indicadorConsumoReal, short indicadorHidrometro, short indicadorPoco,
									short indicadorVolFixadoAgua, int quantidadeConsumo, int quantidadeLigacao,
									int quantidadeEconomiaLigacao, BigDecimal valorFaturadoLigacao, int volumeFaturadoLigacao,
									Date ultimaAlteracao, GerenciaRegional gerenciaRegional, Localidade localidade,
									Localidade localidadeElo, Quadra quadra, ConsumoTarifa consumoTarifa, ImovelPerfil imovelPerfil,
									LigacaoAguaSituacao ligacaoAguaSituacao, UnidadeNegocio unidadeNegocio, EsferaPoder esferaPoder,
									Categoria categoria, CategoriaTipo categoriaTipo, SetorComercial setorComercial,
									int quantidadeLigacaoRefaturamento, int quantidadeEconomiaLigacaoRefaturamento,
									BigDecimal valorFaturadoLigacaoRefaturamento, int volumeFaturadoLigacaoRefaturamento) {

		this.id = id;
		this.anoMesReferencia = anoMesReferencia;
		this.codigoSetorComercial = codigoSetorComercial;
		this.numeroQuadra = numeroQuadra;
		this.indicadorLigacaoMista = indicadorLigacaoMista;
		this.indicadorConsumoReal = indicadorConsumoReal;
		this.indicadorHidrometro = indicadorHidrometro;
		this.indicadorPoco = indicadorPoco;
		this.indicadorVolFixadoAgua = indicadorVolFixadoAgua;
		this.quantidadeConsumo = quantidadeConsumo;
		this.quantidadeLigacao = quantidadeLigacao;
		this.quantidadeEconomiaLigacao = quantidadeEconomiaLigacao;
		this.valorFaturadoLigacao = valorFaturadoLigacao;
		this.volumeFaturadoLigacao = volumeFaturadoLigacao;
		this.ultimaAlteracao = ultimaAlteracao;
		this.gerenciaRegional = gerenciaRegional;
		this.localidade = localidade;
		this.localidadeElo = localidadeElo;
		this.quadra = quadra;
		this.consumoTarifa = consumoTarifa;
		this.imovelPerfil = imovelPerfil;
		this.ligacaoAguaSituacao = ligacaoAguaSituacao;
		this.unidadeNegocio = unidadeNegocio;
		this.esferaPoder = esferaPoder;
		this.categoria = categoria;
		this.categoriaTipo = categoriaTipo;
		this.setorComercial = setorComercial;
		this.quantidadeLigacaoRefaturamento = quantidadeLigacaoRefaturamento;
		this.quantidadeEconomiaLigacaoRefaturamento = quantidadeEconomiaLigacaoRefaturamento;
		this.valorFaturadoLigacaoRefaturamento = valorFaturadoLigacaoRefaturamento;
		this.volumeFaturadoLigacaoRefaturamento = volumeFaturadoLigacaoRefaturamento;
	}

	/** default constructor */
	public HistogramaAguaLigacao() {

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

	public int getCodigoSetorComercial(){

		return this.codigoSetorComercial;
	}

	public void setCodigoSetorComercial(int codigoSetorComercial){

		this.codigoSetorComercial = codigoSetorComercial;
	}

	public int getNumeroQuadra(){

		return this.numeroQuadra;
	}

	public void setNumeroQuadra(int numeroQuadra){

		this.numeroQuadra = numeroQuadra;
	}

	public short getIndicadorLigacaoMista(){

		return this.indicadorLigacaoMista;
	}

	public void setIndicadorLigacaoMista(short indicadorLigacaoMista){

		this.indicadorLigacaoMista = indicadorLigacaoMista;
	}

	public short getIndicadorConsumoReal(){

		return this.indicadorConsumoReal;
	}

	public void setIndicadorConsumoReal(short indicadorConsumoReal){

		this.indicadorConsumoReal = indicadorConsumoReal;
	}

	public short getIndicadorHidrometro(){

		return this.indicadorHidrometro;
	}

	public void setIndicadorHidrometro(short indicadorHidrometro){

		this.indicadorHidrometro = indicadorHidrometro;
	}

	public short getIndicadorPoco(){

		return this.indicadorPoco;
	}

	public void setIndicadorPoco(short indicadorPoco){

		this.indicadorPoco = indicadorPoco;
	}

	public short getIndicadorVolFixadoAgua(){

		return this.indicadorVolFixadoAgua;
	}

	public void setIndicadorVolFixadoAgua(short indicadorVolFixadoAgua){

		this.indicadorVolFixadoAgua = indicadorVolFixadoAgua;
	}

	public int getQuantidadeConsumo(){

		return this.quantidadeConsumo;
	}

	public void setQuantidadeConsumo(int quantidadeConsumo){

		this.quantidadeConsumo = quantidadeConsumo;
	}

	public int getQuantidadeLigacao(){

		return this.quantidadeLigacao;
	}

	public void setQuantidadeLigacao(int quantidadeLigacao){

		this.quantidadeLigacao = quantidadeLigacao;
	}

	public int getQuantidadeEconomiaLigacao(){

		return this.quantidadeEconomiaLigacao;
	}

	public void setQuantidadeEconomiaLigacao(int quantidadeEconomiaLigacao){

		this.quantidadeEconomiaLigacao = quantidadeEconomiaLigacao;
	}

	public BigDecimal getValorFaturadoLigacao(){

		return this.valorFaturadoLigacao;
	}

	public void setValorFaturadoLigacao(BigDecimal valorFaturadoLigacao){

		this.valorFaturadoLigacao = valorFaturadoLigacao;
	}

	public int getVolumeFaturadoLigacao(){

		return this.volumeFaturadoLigacao;
	}

	public void setVolumeFaturadoLigacao(int volumeFaturadoLigacao){

		this.volumeFaturadoLigacao = volumeFaturadoLigacao;
	}

	public Date getUltimaAlteracao(){

		return this.ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao){

		this.ultimaAlteracao = ultimaAlteracao;
	}

	public GerenciaRegional getGerenciaRegional(){

		return this.gerenciaRegional;
	}

	public void setGerenciaRegional(GerenciaRegional gerenciaRegional){

		this.gerenciaRegional = gerenciaRegional;
	}

	public Localidade getLocalidade(){

		return this.localidade;
	}

	public void setLocalidade(Localidade localidade){

		this.localidade = localidade;
	}

	public Localidade getLocalidadeElo(){

		return this.localidadeElo;
	}

	public void setLocalidadeElo(Localidade localidadeElo){

		this.localidadeElo = localidadeElo;
	}

	public Quadra getQuadra(){

		return this.quadra;
	}

	public void setQuadra(Quadra quadra){

		this.quadra = quadra;
	}

	public ConsumoTarifa getConsumoTarifa(){

		return this.consumoTarifa;
	}

	public void setConsumoTarifa(ConsumoTarifa consumoTarifa){

		this.consumoTarifa = consumoTarifa;
	}

	public ImovelPerfil getImovelPerfil(){

		return this.imovelPerfil;
	}

	public void setImovelPerfil(ImovelPerfil imovelPerfil){

		this.imovelPerfil = imovelPerfil;
	}

	public LigacaoAguaSituacao getLigacaoAguaSituacao(){

		return this.ligacaoAguaSituacao;
	}

	public void setLigacaoAguaSituacao(LigacaoAguaSituacao ligacaoAguaSituacao){

		this.ligacaoAguaSituacao = ligacaoAguaSituacao;
	}

	public UnidadeNegocio getUnidadeNegocio(){

		return this.unidadeNegocio;
	}

	public void setUnidadeNegocio(UnidadeNegocio unidadeNegocio){

		this.unidadeNegocio = unidadeNegocio;
	}

	public EsferaPoder getEsferaPoder(){

		return this.esferaPoder;
	}

	public void setEsferaPoder(EsferaPoder esferaPoder){

		this.esferaPoder = esferaPoder;
	}

	public Categoria getCategoria(){

		return this.categoria;
	}

	public void setCategoria(Categoria categoria){

		this.categoria = categoria;
	}

	public CategoriaTipo getCategoriaTipo(){

		return this.categoriaTipo;
	}

	public void setCategoriaTipo(CategoriaTipo categoriaTipo){

		this.categoriaTipo = categoriaTipo;
	}

	public SetorComercial getSetorComercial(){

		return this.setorComercial;
	}

	public void setSetorComercial(SetorComercial setorComercial){

		this.setorComercial = setorComercial;
	}

	public String toString(){

		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	public int getQuantidadeLigacaoRefaturamento(){

		return quantidadeLigacaoRefaturamento;
	}

	public void setQuantidadeLigacaoRefaturamento(int quantidadeLigacaoRefaturamento){

		this.quantidadeLigacaoRefaturamento = quantidadeLigacaoRefaturamento;
	}

	public int getQuantidadeEconomiaLigacaoRefaturamento(){

		return quantidadeEconomiaLigacaoRefaturamento;
	}

	public void setQuantidadeEconomiaLigacaoRefaturamento(int quantidadeEconomiaLigacaoRefaturamento){

		this.quantidadeEconomiaLigacaoRefaturamento = quantidadeEconomiaLigacaoRefaturamento;
	}

	public BigDecimal getValorFaturadoLigacaoRefaturamento(){

		return valorFaturadoLigacaoRefaturamento;
	}

	public void setValorFaturadoLigacaoRefaturamento(BigDecimal valorFaturadoLigacaoRefaturamento){

		this.valorFaturadoLigacaoRefaturamento = valorFaturadoLigacaoRefaturamento;
	}

	public int getVolumeFaturadoLigacaoRefaturamento(){

		return volumeFaturadoLigacaoRefaturamento;
	}

	public void setVolumeFaturadoLigacaoRefaturamento(int volumeFaturadoLigacaoRefaturamento){

		this.volumeFaturadoLigacaoRefaturamento = volumeFaturadoLigacaoRefaturamento;
	}

}
