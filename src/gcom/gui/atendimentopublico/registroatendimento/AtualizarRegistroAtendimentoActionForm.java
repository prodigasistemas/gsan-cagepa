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

package gcom.gui.atendimentopublico.registroatendimento;

import org.apache.struts.validator.ValidatorForm;

/**
 * Esta classe tem por finalidade gerar o formul�rio que receber� os par�metros
 * para realiza��o da atualiza��o de um R.A
 * 
 * @author S�vio Luiz
 * @date 10/08/2006
 */
public class AtualizarRegistroAtendimentoActionForm
				extends ValidatorForm {

	private static final long serialVersionUID = 1L;

	private String idOrdemServico;

	// ABA N� 01
	private String numeroRA;

	private String numeroAtendimentoManual;

	private String tipo;

	private String dataAtendimento;

	private String hora;

	private String tempoEsperaInicial;

	private String tempoEsperaFinal;

	private String unidade;

	private String descricaoUnidade;

	private String meioSolicitacao;

	private String senhaAtendimento;

	private String tipoSolicitacao;

	private String especificacao;

	private String dataPrevista;

	private String observacao;

	private String indicadorProcessoAdmJud;

	private String numeroProcessoAgencia;

	// ABA N� 02
	private String imovelObrigatorio;

	private String pavimentoRuaObrigatorio;

	private String pavimentoCalcadaObrigatorio;

	private String idImovel;

	private String inscricaoImovel;

	private String pontoReferencia;

	private String idMunicipio;

	private String descricaoMunicipio;

	private String cdBairro;

	private String descricaoBairro;

	private String idBairro;

	private String idBairroArea;

	private String idLocalidade;

	private String descricaoLocalidade;

	private String cdSetorComercial;

	private String descricaoSetorComercial;

	private String idSetorComercial;

	private String nnQuadra;

	private String idQuadra;

	private String idDivisaoEsgoto;

	private String idUnidadeAtual;

	private String descricaoUnidadeAtual;

	private String parecerUnidadeDestino;

	private String idLocalOcorrencia;

	private String idPavimentoRua;

	private String idPavimentoCalcada;

	private String descricaoLocalOcorrencia;

	private String indValidacaoMatriculaImovel;

	private String enderecoOcorrencia;

	private String indRuaLocalOcorrencia;

	private String indCalcadaLocalOcorrencia;

	private String indFaltaAgua;

	private String indMatricula;

	private String idSolicitantePrincipal;

	private String descricaoRA;

	private String clienteTipo;

	private String numeroCpf;

	private String numeroRG;

	private String orgaoExpedidorRg;

	private String unidadeFederacaoRG;

	private String numeroCnpj;

	private String indicadorCpfCnpj;

	private String indicadorRg;

	public String getDescricaoRA(){

		return descricaoRA;
	}

	public void setDescricaoRA(String descricaoRA){

		this.descricaoRA = descricaoRA;
	}

	public String getNumeroAtendimentoManual(){

		return numeroAtendimentoManual;
	}

	public void setNumeroAtendimentoManual(String numeroAtendimentoManual){

		this.numeroAtendimentoManual = numeroAtendimentoManual;
	}

	public String getIndFaltaAgua(){

		return indFaltaAgua;
	}

	public void setIndFaltaAgua(String indFaltaAgua){

		this.indFaltaAgua = indFaltaAgua;
	}

	public String getIndMatricula(){

		return indMatricula;
	}

	public void setIndMatricula(String indMatricula){

		this.indMatricula = indMatricula;
	}

	public String getIdQuadra(){

		return idQuadra;
	}

	public void setIdQuadra(String idQuadra){

		this.idQuadra = idQuadra;
	}

	public String getIdSetorComercial(){

		return idSetorComercial;
	}

	public void setIdSetorComercial(String idSetorComercial){

		this.idSetorComercial = idSetorComercial;
	}

	public String getIdBairro(){

		return idBairro;
	}

	public void setIdBairro(String idBairro){

		this.idBairro = idBairro;
	}

	public String getCdBairro(){

		return cdBairro;
	}

	public void setCdBairro(String cdBairro){

		this.cdBairro = cdBairro;
	}

	public String getCdSetorComercial(){

		return cdSetorComercial;
	}

	public void setCdSetorComercial(String cdSetorComercial){

		this.cdSetorComercial = cdSetorComercial;
	}

	public String getDescricaoBairro(){

		return descricaoBairro;
	}

	public void setDescricaoBairro(String descricaoBairro){

		this.descricaoBairro = descricaoBairro;
	}

	public String getDescricaoLocalidade(){

		return descricaoLocalidade;
	}

	public void setDescricaoLocalidade(String descricaoLocalidade){

		this.descricaoLocalidade = descricaoLocalidade;
	}

	public String getDescricaoLocalOcorrencia(){

		return descricaoLocalOcorrencia;
	}

	public void setDescricaoLocalOcorrencia(String descricaoLocalOcorrencia){

		this.descricaoLocalOcorrencia = descricaoLocalOcorrencia;
	}

	public String getDescricaoMunicipio(){

		return descricaoMunicipio;
	}

	public void setDescricaoMunicipio(String descricaoMunicipio){

		this.descricaoMunicipio = descricaoMunicipio;
	}

	public String getDescricaoSetorComercial(){

		return descricaoSetorComercial;
	}

	public void setDescricaoSetorComercial(String descricaoSetorComercial){

		this.descricaoSetorComercial = descricaoSetorComercial;
	}

	public String getIdBairroArea(){

		return idBairroArea;
	}

	public void setIdBairroArea(String idBairroArea){

		this.idBairroArea = idBairroArea;
	}

	public String getIdDivisaoEsgoto(){

		return idDivisaoEsgoto;
	}

	public void setIdDivisaoEsgoto(String idDivisaoEsgoto){

		this.idDivisaoEsgoto = idDivisaoEsgoto;
	}

	public String getIdImovel(){

		return idImovel;
	}

	public void setIdImovel(String idImovel){

		this.idImovel = idImovel;
	}

	public String getIdLocalidade(){

		return idLocalidade;
	}

	public void setIdLocalidade(String idLocalidade){

		this.idLocalidade = idLocalidade;
	}

	public String getIdLocalOcorrencia(){

		return idLocalOcorrencia;
	}

	public void setIdLocalOcorrencia(String idLocalOcorrencia){

		this.idLocalOcorrencia = idLocalOcorrencia;
	}

	public String getIdMunicipio(){

		return idMunicipio;
	}

	public void setIdMunicipio(String idMunicipio){

		this.idMunicipio = idMunicipio;
	}

	public String getIdPavimentoCalcada(){

		return idPavimentoCalcada;
	}

	public void setIdPavimentoCalcada(String idPavimentoCalcada){

		this.idPavimentoCalcada = idPavimentoCalcada;
	}

	public String getIdPavimentoRua(){

		return idPavimentoRua;
	}

	public void setIdPavimentoRua(String idPavimentoRua){

		this.idPavimentoRua = idPavimentoRua;
	}

	public String getInscricaoImovel(){

		return inscricaoImovel;
	}

	public void setInscricaoImovel(String inscricaoImovel){

		this.inscricaoImovel = inscricaoImovel;
	}

	public String getNnQuadra(){

		return nnQuadra;
	}

	public void setNnQuadra(String nnQuadra){

		this.nnQuadra = nnQuadra;
	}

	public String getParecerUnidadeDestino(){

		return parecerUnidadeDestino;
	}

	public void setParecerUnidadeDestino(String parecerUnidadeDestino){

		this.parecerUnidadeDestino = parecerUnidadeDestino;
	}

	public String getPontoReferencia(){

		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia){

		this.pontoReferencia = pontoReferencia;
	}

	public String getObservacao(){

		return observacao;
	}

	public void setObservacao(String observacao){

		this.observacao = observacao;
	}

	public String getDataAtendimento(){

		return dataAtendimento;
	}

	public void setDataAtendimento(String dataAtendimento){

		this.dataAtendimento = dataAtendimento;
	}

	public String getDataPrevista(){

		return dataPrevista;
	}

	public void setDataPrevista(String dataPrevista){

		this.dataPrevista = dataPrevista;
	}

	public String getDescricaoUnidade(){

		return descricaoUnidade;
	}

	public void setDescricaoUnidade(String descricaoUnidade){

		this.descricaoUnidade = descricaoUnidade;
	}

	public String getEspecificacao(){

		return especificacao;
	}

	public void setEspecificacao(String especificacao){

		this.especificacao = especificacao;
	}

	public String getHora(){

		return hora;
	}

	public void setHora(String hora){

		this.hora = hora;
	}

	public String getMeioSolicitacao(){

		return meioSolicitacao;
	}

	public void setMeioSolicitacao(String meioSolicitacao){

		this.meioSolicitacao = meioSolicitacao;
	}

	public String getTempoEsperaFinal(){

		return tempoEsperaFinal;
	}

	public void setTempoEsperaFinal(String tempoEsperaFinal){

		this.tempoEsperaFinal = tempoEsperaFinal;
	}

	public String getTempoEsperaInicial(){

		return tempoEsperaInicial;
	}

	public void setTempoEsperaInicial(String tempoEsperaInicial){

		this.tempoEsperaInicial = tempoEsperaInicial;
	}

	public String getTipo(){

		return tipo;
	}

	public void setTipo(String tipo){

		this.tipo = tipo;
	}

	public String getTipoSolicitacao(){

		return tipoSolicitacao;
	}

	public void setTipoSolicitacao(String tipoSolicitacao){

		this.tipoSolicitacao = tipoSolicitacao;
	}

	public String getUnidade(){

		return unidade;
	}

	public void setUnidade(String unidade){

		this.unidade = unidade;
	}

	public String getNumeroRA(){

		return numeroRA;
	}

	public void setNumeroRA(String numeroRA){

		this.numeroRA = numeroRA;
	}

	public String getIndValidacaoMatriculaImovel(){

		return indValidacaoMatriculaImovel;
	}

	public void setIndValidacaoMatriculaImovel(String indValidacaoMatriculaImovel){

		this.indValidacaoMatriculaImovel = indValidacaoMatriculaImovel;
	}

	public String getIdOrdemServico(){

		return idOrdemServico;
	}

	public void setIdOrdemServico(String idOrdemServico){

		this.idOrdemServico = idOrdemServico;
	}

	public String getEnderecoOcorrencia(){

		return enderecoOcorrencia;
	}

	public void setEnderecoOcorrencia(String enderecoOcorrencia){

		this.enderecoOcorrencia = enderecoOcorrencia;
	}

	public String getImovelObrigatorio(){

		return imovelObrigatorio;
	}

	public void setImovelObrigatorio(String imovelObrigatorio){

		this.imovelObrigatorio = imovelObrigatorio;
	}

	public String getPavimentoCalcadaObrigatorio(){

		return pavimentoCalcadaObrigatorio;
	}

	public void setPavimentoCalcadaObrigatorio(String pavimentoCalcadaObrigatorio){

		this.pavimentoCalcadaObrigatorio = pavimentoCalcadaObrigatorio;
	}

	public String getPavimentoRuaObrigatorio(){

		return pavimentoRuaObrigatorio;
	}

	public void setPavimentoRuaObrigatorio(String pavimentoRuaObrigatorio){

		this.pavimentoRuaObrigatorio = pavimentoRuaObrigatorio;
	}

	public String getDescricaoUnidadeAtual(){

		return descricaoUnidadeAtual;
	}

	public void setDescricaoUnidadeAtual(String descricaoUnidadeAtual){

		this.descricaoUnidadeAtual = descricaoUnidadeAtual;
	}

	public String getIdUnidadeAtual(){

		return idUnidadeAtual;
	}

	public void setIdUnidadeAtual(String idUnidadeAtual){

		this.idUnidadeAtual = idUnidadeAtual;
	}

	public String getIndCalcadaLocalOcorrencia(){

		return indCalcadaLocalOcorrencia;
	}

	public void setIndCalcadaLocalOcorrencia(String indCalcadaLocalOcorrencia){

		this.indCalcadaLocalOcorrencia = indCalcadaLocalOcorrencia;
	}

	public String getIndRuaLocalOcorrencia(){

		return indRuaLocalOcorrencia;
	}

	public void setIndRuaLocalOcorrencia(String indRuaLocalOcorrencia){

		this.indRuaLocalOcorrencia = indRuaLocalOcorrencia;
	}

	public String getIdSolicitantePrincipal(){

		return idSolicitantePrincipal;
	}

	public void setIdSolicitantePrincipal(String idSolicitantePrincipal){

		this.idSolicitantePrincipal = idSolicitantePrincipal;
	}

	public String getSenhaAtendimento(){

		return senhaAtendimento;
	}

	public void setSenhaAtendimento(String senhaAtendimento){

		this.senhaAtendimento = senhaAtendimento;
	}

	public String getClienteTipo(){

		return clienteTipo;
	}

	public void setClienteTipo(String clienteTipo){

		this.clienteTipo = clienteTipo;
	}

	public String getNumeroCpf(){

		return numeroCpf;
	}

	public void setNumeroCpf(String numeroCpf){

		this.numeroCpf = numeroCpf;
	}

	public String getNumeroRG(){

		return numeroRG;
	}

	public void setNumeroRG(String numeroRG){

		this.numeroRG = numeroRG;
	}

	public String getOrgaoExpedidorRg(){

		return orgaoExpedidorRg;
	}

	public void setOrgaoExpedidorRg(String orgaoExpedidorRg){

		this.orgaoExpedidorRg = orgaoExpedidorRg;
	}

	public String getUnidadeFederacaoRG(){

		return unidadeFederacaoRG;
	}

	public void setUnidadeFederacaoRG(String unidadeFederacaoRG){

		this.unidadeFederacaoRG = unidadeFederacaoRG;
	}

	public String getNumeroCnpj(){

		return numeroCnpj;
	}

	public void setNumeroCnpj(String numeroCnpj){

		this.numeroCnpj = numeroCnpj;
	}

	public String getIndicadorCpfCnpj(){

		return indicadorCpfCnpj;
	}

	public void setIndicadorCpfCnpj(String indicadorCpfCnpj){

		this.indicadorCpfCnpj = indicadorCpfCnpj;
	}

	public String getIndicadorRg(){

		return indicadorRg;
	}

	public void setIndicadorRg(String indicadorRg){

		this.indicadorRg = indicadorRg;
	}

	/**
	 * @return the indicadorProcessoAdmJud
	 */
	public String getIndicadorProcessoAdmJud(){

		return indicadorProcessoAdmJud;
	}

	/**
	 * @param indicadorProcessoAdmJud
	 *            the indicadorProcessoAdmJud to set
	 */
	public void setIndicadorProcessoAdmJud(String indicadorProcessoAdmJud){

		this.indicadorProcessoAdmJud = indicadorProcessoAdmJud;
	}

	/**
	 * @return the numeroProcessoAgencia
	 */
	public String getNumeroProcessoAgencia(){

		return numeroProcessoAgencia;
	}

	/**
	 * @param numeroProcessoAgencia
	 *            the numeroProcessoAgencia to set
	 */
	public void setNumeroProcessoAgencia(String numeroProcessoAgencia){

		this.numeroProcessoAgencia = numeroProcessoAgencia;
	}

}
