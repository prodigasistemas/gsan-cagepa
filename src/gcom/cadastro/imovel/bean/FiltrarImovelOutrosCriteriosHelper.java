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

package gcom.cadastro.imovel.bean;

public class FiltrarImovelOutrosCriteriosHelper {

	private String idClienteTipo;

	private String tipoRelatorio;

	private String NomeCliente;

	private String id;

	private String descricao;

	private String indicadorUso;

	private String intervaloMediaMinimaHidrometroInicio;

	private String intervaloMediaMinimaHidrometroFinal;

	private String intervaloMediaMinimaImovelInicio;//

	private String intervaloMediaMinimaImovelFinal;//

	private String indicadorMedicao;//

	private String intervaloPercentualEsgotoInicial;

	private String intervaloPercentualEsgotoFinal;

	private String inscricaoTipo;//

	private String consumoMinimo;

	private String nomeMunicipio;

	private String idNomeConta;

	private String idImovelPrincipal;

	private String idImovelCondominio;

	private String tipoRelacao;// Falta modificar no hbm pra fazer reverso, so

	// com rodrigo...

	private String idCliente;

	private String loteDestino;

	private String quadraDestinoNM;

	private String idBairro;

	private String nomeBairro;

	private String loteOrigem;

	private String idLocalidade;

	private String nomeLocalidadeOrigem;

	private String nomeSetorComercialOrigem;

	private String quadraOrigemNM;

	private String quadraMensagemOrigem;

	private String nomeLocalidadeDestino;

	private String setorComercialDestinoCD;

	private String setorComercialOrigemCD;

	private String setorComercialOrigemID;

	private String quadraOrigemID;

	private String localidadeDestinoID;

	private String localidadeOrigemID;

	private String nomeSetorComercialDestino;

	private String setorComercialDestinoID;

	private String quadraMensagemDestino;

	private String idGerenciaRegional;

	private String quadraDestinoID;

	private String idMunicipio;

	private String consumoMinimoInicial;//

	private String consumoMinimoFinal;//

	private String situacaoAgua;

	private String situacaoLigacaoEsgoto;

	private String consumoMinimoFixadoEsgotoInicial;

	private String consumoMinimoFixadoEsgotoFinal;

	private String tipoMedicao;

	private String perfilImovel;

	private String categoriaImovel;

	private String subcategoria;

	private String quantidadeEconomiasInicial;//

	private String quantidadeEconomiasFinal;//

	private String numeroPontosInicial;//

	private String numeroPontosFinal;//

	private String numeroMoradoresInicial;//

	private String numeroMoradoresFinal;//

	private String areaConstruidaInicial;//

	private String areaConstruidaFinal;//

	private String areaConstruidaFaixa;//

	private String tipoPoco;

	private String tipoSituacaoEspecialFaturamento;//

	private String tipoSituacaoEspecialCobranca;//

	private String situacaoCobranca;//

	private String diaVencimentoAlternativo;//

	private String anormalidadeElo;//

	private String ocorrenciaCadastro;//

	private String tarifaConsumo;//

	private String CEP;

	private String idLogradouro;

	// Dados informados na guia Tarifa Social

	private String indicadorImovelTarifaSocial;

	private String dataInicioImplantacao;

	private String dataFimImplantacao;

	private String dataInicioExclusao;

	private String dataFimExclusao;

	private String idMotivoExclusao;

	private String dataInicioValidadeCartao;

	private String dataFimValidadeCartao;

	private String mesInicioAdesao;

	private String mesFimAdesao;

	private String tarifaSocialCartaoTipoId;

	private String tarifaSocialRendaTipoId;

	private String tarifaSocialExclusaoMotivoId;

	private String rendaInicial;

	private String rendaFinal;

	private String celpeInicial;

	private String celpeFinal;

	private String dataInicioRecadastramento;

	private String dataFimRecadastramento;

	private String recadastramentoNumeroInicial;

	private String recadastramentoNumeroFinal;

	// cliente_relacao_tipoem
	// vermelho
	private String nomeLogradouro;

	private String cdRotaInicial;

	private String sequencialRotaInicial;

	private String cdRotaFinal;

	private String sequencialRotaFinal;

	private String segmentoInicial;

	private String segmentoFinal;

	private String subloteInicial;

	private String subloteFinal;

	public String getIdLogradouro(){

		return idLogradouro;
	}

	public String getAnormalidadeElo(){

		return anormalidadeElo;
	}

	public void setAnormalidadeElo(String anormalidadeElo){

		this.anormalidadeElo = anormalidadeElo;
	}

	public String getAreaConstruidaFaixa(){

		return areaConstruidaFaixa;
	}

	public void setAreaConstruidaFaixa(String areaConstruidaFaixa){

		this.areaConstruidaFaixa = areaConstruidaFaixa;
	}

	public String getCategoriaImovel(){

		return categoriaImovel;
	}

	public void setCategoriaImovel(String categoriaImovel){

		this.categoriaImovel = categoriaImovel;
	}

	public String getCEP(){

		return CEP;
	}

	public void setCEP(String cep){

		CEP = cep;
	}

	public String getDiaVencimentoAlternativo(){

		return diaVencimentoAlternativo;
	}

	public void setDiaVencimentoAlternativo(String diaVencimentoAlternativo){

		this.diaVencimentoAlternativo = diaVencimentoAlternativo;
	}

	public String getIdBairro(){

		return idBairro;
	}

	public void setIdBairro(String idBairro){

		this.idBairro = idBairro;
	}

	public String getIdCliente(){

		return idCliente;
	}

	public void setIdCliente(String idCliente){

		this.idCliente = idCliente;
	}

	public String getIdGerenciaRegional(){

		return idGerenciaRegional;
	}

	public void setIdGerenciaRegional(String idGerenciaRegional){

		this.idGerenciaRegional = idGerenciaRegional;
	}

	public String getIdImovelCondominio(){

		return idImovelCondominio;
	}

	public void setIdImovelCondominio(String idImovelCondominio){

		this.idImovelCondominio = idImovelCondominio;
	}

	public String getIdImovelPrincipal(){

		return idImovelPrincipal;
	}

	public void setIdImovelPrincipal(String idImovelPrincipal){

		this.idImovelPrincipal = idImovelPrincipal;
	}

	public String getIdLocalidade(){

		return idLocalidade;
	}

	public void setIdLocalidade(String idLocalidade){

		this.idLocalidade = idLocalidade;
	}

	public String getIdMunicipio(){

		return idMunicipio;
	}

	public void setIdMunicipio(String idMunicipio){

		this.idMunicipio = idMunicipio;
	}

	public String getIdNomeConta(){

		return idNomeConta;
	}

	public void setIdNomeConta(String idNomeConta){

		this.idNomeConta = idNomeConta;
	}

	public String getInscricaoTipo(){

		return inscricaoTipo;
	}

	public void setInscricaoTipo(String inscricaoTipo){

		this.inscricaoTipo = inscricaoTipo;
	}

	public String getLocalidadeDestinoID(){

		return localidadeDestinoID;
	}

	public void setLocalidadeDestinoID(String localidadeDestinoID){

		this.localidadeDestinoID = localidadeDestinoID;
	}

	public String getLocalidadeOrigemID(){

		return localidadeOrigemID;
	}

	public void setLocalidadeOrigemID(String localidadeOrigemID){

		this.localidadeOrigemID = localidadeOrigemID;
	}

	public String getLoteDestino(){

		return loteDestino;
	}

	public void setLoteDestino(String loteDestino){

		this.loteDestino = loteDestino;
	}

	public String getLoteOrigem(){

		return loteOrigem;
	}

	public void setLoteOrigem(String loteOrigem){

		this.loteOrigem = loteOrigem;
	}

	public String getNomeBairro(){

		return nomeBairro;
	}

	public void setNomeBairro(String nomeBairro){

		this.nomeBairro = nomeBairro;
	}

	public String getNomeLocalidadeDestino(){

		return nomeLocalidadeDestino;
	}

	public void setNomeLocalidadeDestino(String nomeLocalidadeDestino){

		this.nomeLocalidadeDestino = nomeLocalidadeDestino;
	}

	public String getNomeLocalidadeOrigem(){

		return nomeLocalidadeOrigem;
	}

	public void setNomeLocalidadeOrigem(String nomeLocalidadeOrigem){

		this.nomeLocalidadeOrigem = nomeLocalidadeOrigem;
	}

	public String getNomeLogradouro(){

		return nomeLogradouro;
	}

	public void setNomeLogradouro(String nomeLogradouro){

		this.nomeLogradouro = nomeLogradouro;
	}

	public String getNomeMunicipio(){

		return nomeMunicipio;
	}

	public void setNomeMunicipio(String nomeMunicipio){

		this.nomeMunicipio = nomeMunicipio;
	}

	public String getNomeSetorComercialDestino(){

		return nomeSetorComercialDestino;
	}

	public void setNomeSetorComercialDestino(String nomeSetorComercialDestino){

		this.nomeSetorComercialDestino = nomeSetorComercialDestino;
	}

	public String getNomeSetorComercialOrigem(){

		return nomeSetorComercialOrigem;
	}

	public void setNomeSetorComercialOrigem(String nomeSetorComercialOrigem){

		this.nomeSetorComercialOrigem = nomeSetorComercialOrigem;
	}

	public String getOcorrenciaCadastro(){

		return ocorrenciaCadastro;
	}

	public void setOcorrenciaCadastro(String ocorrenciaCadastro){

		this.ocorrenciaCadastro = ocorrenciaCadastro;
	}

	public String getPerfilImovel(){

		return perfilImovel;
	}

	public void setPerfilImovel(String perfilImovel){

		this.perfilImovel = perfilImovel;
	}

	public String getQuadraDestinoID(){

		return quadraDestinoID;
	}

	public void setQuadraDestinoID(String quadraDestinoID){

		this.quadraDestinoID = quadraDestinoID;
	}

	public String getQuadraDestinoNM(){

		return quadraDestinoNM;
	}

	public void setQuadraDestinoNM(String quadraDestinoNM){

		this.quadraDestinoNM = quadraDestinoNM;
	}

	public String getQuadraMensagemDestino(){

		return quadraMensagemDestino;
	}

	public void setQuadraMensagemDestino(String quadraMensagemDestino){

		this.quadraMensagemDestino = quadraMensagemDestino;
	}

	public String getQuadraMensagemOrigem(){

		return quadraMensagemOrigem;
	}

	public void setQuadraMensagemOrigem(String quadraMensagemOrigem){

		this.quadraMensagemOrigem = quadraMensagemOrigem;
	}

	public String getQuadraOrigemID(){

		return quadraOrigemID;
	}

	public void setQuadraOrigemID(String quadraOrigemID){

		this.quadraOrigemID = quadraOrigemID;
	}

	public String getQuadraOrigemNM(){

		return quadraOrigemNM;
	}

	public void setQuadraOrigemNM(String quadraOrigemNM){

		this.quadraOrigemNM = quadraOrigemNM;
	}

	public String getSetorComercialDestinoCD(){

		return setorComercialDestinoCD;
	}

	public void setSetorComercialDestinoCD(String setorComercialDestinoCD){

		this.setorComercialDestinoCD = setorComercialDestinoCD;
	}

	public String getSetorComercialDestinoID(){

		return setorComercialDestinoID;
	}

	public void setSetorComercialDestinoID(String setorComercialDestinoID){

		this.setorComercialDestinoID = setorComercialDestinoID;
	}

	public String getSetorComercialOrigemCD(){

		return setorComercialOrigemCD;
	}

	public void setSetorComercialOrigemCD(String setorComercialOrigemCD){

		this.setorComercialOrigemCD = setorComercialOrigemCD;
	}

	public String getSetorComercialOrigemID(){

		return setorComercialOrigemID;
	}

	public void setSetorComercialOrigemID(String setorComercialOrigemID){

		this.setorComercialOrigemID = setorComercialOrigemID;
	}

	public String getSituacaoAgua(){

		return situacaoAgua;
	}

	public void setSituacaoAgua(String situacaoAgua){

		this.situacaoAgua = situacaoAgua;
	}

	public String getSituacaoCobranca(){

		return situacaoCobranca;
	}

	public void setSituacaoCobranca(String situacaoCobranca){

		this.situacaoCobranca = situacaoCobranca;
	}

	public String getSituacaoLigacaoEsgoto(){

		return situacaoLigacaoEsgoto;
	}

	public void setSituacaoLigacaoEsgoto(String situacaoLigacaoEsgoto){

		this.situacaoLigacaoEsgoto = situacaoLigacaoEsgoto;
	}

	public String getSubcategoria(){

		return subcategoria;
	}

	public void setSubcategoria(String subcategoria){

		this.subcategoria = subcategoria;
	}

	public String getTarifaConsumo(){

		return tarifaConsumo;
	}

	public void setTarifaConsumo(String tarifaConsumo){

		this.tarifaConsumo = tarifaConsumo;
	}

	public String getTarifaSocialCartaoTipoId(){

		return tarifaSocialCartaoTipoId;
	}

	public void setTarifaSocialCartaoTipoId(String tarifaSocialCartaoTipoId){

		this.tarifaSocialCartaoTipoId = tarifaSocialCartaoTipoId;
	}

	public String getTarifaSocialExclusaoMotivoId(){

		return tarifaSocialExclusaoMotivoId;
	}

	public void setTarifaSocialExclusaoMotivoId(String tarifaSocialExclusaoMotivoId){

		this.tarifaSocialExclusaoMotivoId = tarifaSocialExclusaoMotivoId;
	}

	public String getTarifaSocialRendaTipoId(){

		return tarifaSocialRendaTipoId;
	}

	public void setTarifaSocialRendaTipoId(String tarifaSocialRendaTipoId){

		this.tarifaSocialRendaTipoId = tarifaSocialRendaTipoId;
	}

	public String getTipoMedicao(){

		return tipoMedicao;
	}

	public void setTipoMedicao(String tipoMedicao){

		this.tipoMedicao = tipoMedicao;
	}

	public String getTipoPoco(){

		return tipoPoco;
	}

	public void setTipoPoco(String tipoPoco){

		this.tipoPoco = tipoPoco;
	}

	public String getTipoRelacao(){

		return tipoRelacao;
	}

	public void setTipoRelacao(String tipoRelacao){

		this.tipoRelacao = tipoRelacao;
	}

	public String getTipoSituacaoEspecialCobranca(){

		return tipoSituacaoEspecialCobranca;
	}

	public void setTipoSituacaoEspecialCobranca(String tipoSituacaoEspecialCobranca){

		this.tipoSituacaoEspecialCobranca = tipoSituacaoEspecialCobranca;
	}

	public String getTipoSituacaoEspecialFaturamento(){

		return tipoSituacaoEspecialFaturamento;
	}

	public void setTipoSituacaoEspecialFaturamento(String tipoSituacaoEspecialFaturamento){

		this.tipoSituacaoEspecialFaturamento = tipoSituacaoEspecialFaturamento;
	}

	public void setIdLogradouro(String idLogradouro){

		this.idLogradouro = idLogradouro;
	}

	public String getConsumoMinimoFinal(){

		return consumoMinimoFinal;
	}

	public void setConsumoMinimoFinal(String consumoMinimoFinal){

		this.consumoMinimoFinal = consumoMinimoFinal;
	}

	public String getConsumoMinimoInicial(){

		return consumoMinimoInicial;
	}

	public void setConsumoMinimoInicial(String consumoMinimoInicial){

		this.consumoMinimoInicial = consumoMinimoInicial;
	}

	public String getConsumoMinimo(){

		return consumoMinimo;
	}

	public void setConsumoMinimo(String consumoMinimo){

		this.consumoMinimo = consumoMinimo;
	}

	public String getIntervaloPercentualEsgotoFinal(){

		return intervaloPercentualEsgotoFinal;
	}

	public void setIntervaloPercentualEsgotoFinal(String intervaloPercentualEsgotoFinal){

		this.intervaloPercentualEsgotoFinal = intervaloPercentualEsgotoFinal;
	}

	public String getIntervaloPercentualEsgotoInicial(){

		return intervaloPercentualEsgotoInicial;
	}

	public void setIntervaloPercentualEsgotoInicial(String intervaloPercentualEsgotoInicial){

		this.intervaloPercentualEsgotoInicial = intervaloPercentualEsgotoInicial;
	}

	public String getConsumoMinimoFixadoEsgotoFinal(){

		return consumoMinimoFixadoEsgotoFinal;
	}

	public void setConsumoMinimoFixadoEsgotoFinal(String consumoMinimoFixadoEsgotoFinal){

		this.consumoMinimoFixadoEsgotoFinal = consumoMinimoFixadoEsgotoFinal;
	}

	public String getConsumoMinimoFixadoEsgotoInicial(){

		return consumoMinimoFixadoEsgotoInicial;
	}

	public void setConsumoMinimoFixadoEsgotoInicial(String consumoMinimoFixadoEsgotoInicial){

		this.consumoMinimoFixadoEsgotoInicial = consumoMinimoFixadoEsgotoInicial;
	}

	public String getIndicadorMedicao(){

		return indicadorMedicao;
	}

	public void setIndicadorMedicao(String indicadorMedicao){

		this.indicadorMedicao = indicadorMedicao;
	}

	public String getIntervaloMediaMinimaImovelFinal(){

		return intervaloMediaMinimaImovelFinal;
	}

	public void setIntervaloMediaMinimaImovelFinal(String intervaloMediaMinimaImovelFinal){

		this.intervaloMediaMinimaImovelFinal = intervaloMediaMinimaImovelFinal;
	}

	public String getIntervaloMediaMinimaImovelInicio(){

		return intervaloMediaMinimaImovelInicio;
	}

	public void setIntervaloMediaMinimaImovelInicio(String intervaloMediaMinimaImovelInicio){

		this.intervaloMediaMinimaImovelInicio = intervaloMediaMinimaImovelInicio;
	}

	public String getIntervaloMediaMinimaHidrometroFinal(){

		return intervaloMediaMinimaHidrometroFinal;
	}

	public void setIntervaloMediaMinimaHidrometroFinal(String intervaloMediaMinimaHidrometroFinal){

		this.intervaloMediaMinimaHidrometroFinal = intervaloMediaMinimaHidrometroFinal;
	}

	public String getIntervaloMediaMinimaHidrometroInicio(){

		return intervaloMediaMinimaHidrometroInicio;
	}

	public void setIntervaloMediaMinimaHidrometroInicio(String intervaloMediaMinimaHidrometroInicio){

		this.intervaloMediaMinimaHidrometroInicio = intervaloMediaMinimaHidrometroInicio;
	}

	public String getQuantidadeEconomiasFinal(){

		return quantidadeEconomiasFinal;
	}

	public void setQuantidadeEconomiasFinal(String quantidadeEconomiasFinal){

		this.quantidadeEconomiasFinal = quantidadeEconomiasFinal;
	}

	public String getQuantidadeEconomiasInicial(){

		return quantidadeEconomiasInicial;
	}

	public void setQuantidadeEconomiasInicial(String quantidadeEconomiasInicial){

		this.quantidadeEconomiasInicial = quantidadeEconomiasInicial;
	}

	public String getNumeroPontosInicial(){

		return numeroPontosInicial;
	}

	public void setNumeroPontosInicial(String numeroPontosInicial){

		this.numeroPontosInicial = numeroPontosInicial;
	}

	public String getNumeroPontosFinal(){

		return numeroPontosFinal;
	}

	public void setNumeroPontosFinal(String numeroPontosFinal){

		this.numeroPontosFinal = numeroPontosFinal;
	}

	public String getNumeroMoradoresFinal(){

		return numeroMoradoresFinal;
	}

	public void setNumeroMoradoresFinal(String numeroMoradoresFinal){

		this.numeroMoradoresFinal = numeroMoradoresFinal;
	}

	public String getNumeroMoradoresInicial(){

		return numeroMoradoresInicial;
	}

	public void setNumeroMoradoresInicial(String numeroMoradoresInicial){

		this.numeroMoradoresInicial = numeroMoradoresInicial;
	}

	public String getAreaConstruidaFinal(){

		return areaConstruidaFinal;
	}

	public void setAreaConstruidaFinal(String areaConstruidaFinal){

		this.areaConstruidaFinal = areaConstruidaFinal;
	}

	public String getAreaConstruidaInicial(){

		return areaConstruidaInicial;
	}

	public void setAreaConstruidaInicial(String areaConstruidaInicial){

		this.areaConstruidaInicial = areaConstruidaInicial;
	}

	public String getDescricao(){

		return descricao;
	}

	public void setDescricao(String descricao){

		this.descricao = descricao;
	}

	public String getId(){

		return id;
	}

	public void setId(String id){

		this.id = id;
	}

	public String getIndicadorUso(){

		return indicadorUso;
	}

	public void setIndicadorUso(String indicadorUso){

		this.indicadorUso = indicadorUso;
	}

	public String getNomeCliente(){

		return NomeCliente;
	}

	public void setNomeCliente(String nomeCliente){

		NomeCliente = nomeCliente;
	}

	public String getTipoRelatorio(){

		return tipoRelatorio;
	}

	public void setTipoRelatorio(String tipoRelatorio){

		this.tipoRelatorio = tipoRelatorio;
	}

	public String getIdClienteTipo(){

		return idClienteTipo;
	}

	public void setIdClienteTipo(String idClienteTipo){

		this.idClienteTipo = idClienteTipo;
	}

	public String getCdRotaFinal(){

		return cdRotaFinal;
	}

	public void setCdRotaFinal(String cdRotaFinal){

		this.cdRotaFinal = cdRotaFinal;
	}

	public String getCdRotaInicial(){

		return cdRotaInicial;
	}

	public void setCdRotaInicial(String cdRotaInicial){

		this.cdRotaInicial = cdRotaInicial;
	}

	public String getSequencialRotaFinal(){

		return sequencialRotaFinal;
	}

	public void setSequencialRotaFinal(String sequencialRotaFinal){

		this.sequencialRotaFinal = sequencialRotaFinal;
	}

	public String getSequencialRotaInicial(){

		return sequencialRotaInicial;
	}

	public void setSequencialRotaInicial(String sequencialRotaInicial){

		this.sequencialRotaInicial = sequencialRotaInicial;
	}

	public String getSegmentoInicial(){

		return segmentoInicial;
	}

	public void setSegmentoInicial(String segmentoInicial){

		this.segmentoInicial = segmentoInicial;
	}

	public String getSegmentoFinal(){

		return segmentoFinal;
	}

	public void setSegmentoFinal(String segmentoFinal){

		this.segmentoFinal = segmentoFinal;
	}

	public String getSubloteInicial(){

		return subloteInicial;
	}

	public void setSubloteInicial(String subloteInicial){

		this.subloteInicial = subloteInicial;
	}

	public String getSubloteFinal(){

		return subloteFinal;
	}

	public void setSubloteFinal(String subloteFinal){

		this.subloteFinal = subloteFinal;
	}

	public String getIndicadorImovelTarifaSocial(){

		return indicadorImovelTarifaSocial;
	}

	public void setIndicadorImovelTarifaSocial(String indicadorImovelTarifaSocial){

		this.indicadorImovelTarifaSocial = indicadorImovelTarifaSocial;
	}

	public String getDataInicioImplantacao(){

		return dataInicioImplantacao;
	}

	public void setDataInicioImplantacao(String dataInicioImplantacao){

		this.dataInicioImplantacao = dataInicioImplantacao;
	}

	public String getDataFimImplantacao(){

		return dataFimImplantacao;
	}

	public void setDataFimImplantacao(String dataFimImplantacao){

		this.dataFimImplantacao = dataFimImplantacao;
	}

	public String getDataInicioExclusao(){

		return dataInicioExclusao;
	}

	public void setDataInicioExclusao(String dataInicioExclusao){

		this.dataInicioExclusao = dataInicioExclusao;
	}

	public String getDataFimExclusao(){

		return dataFimExclusao;
	}

	public void setDataFimExclusao(String dataFimExclusao){

		this.dataFimExclusao = dataFimExclusao;
	}

	public String getIdMotivoExclusao(){

		return idMotivoExclusao;
	}

	public void setIdMotivoExclusao(String idMotivoExclusao){

		this.idMotivoExclusao = idMotivoExclusao;
	}

	public String getDataInicioValidadeCartao(){

		return dataInicioValidadeCartao;
	}

	public void setDataInicioValidadeCartao(String dataInicioValidadeCartao){

		this.dataInicioValidadeCartao = dataInicioValidadeCartao;
	}

	public String getDataFimValidadeCartao(){

		return dataFimValidadeCartao;
	}

	public void setDataFimValidadeCartao(String dataFimValidadeCartao){

		this.dataFimValidadeCartao = dataFimValidadeCartao;
	}

	public String getMesInicioAdesao(){

		return mesInicioAdesao;
	}

	public void setMesInicioAdesao(String mesInicioAdesao){

		this.mesInicioAdesao = mesInicioAdesao;
	}

	public String getMesFimAdesao(){

		return mesFimAdesao;
	}

	public void setMesFimAdesao(String mesFimAdesao){

		this.mesFimAdesao = mesFimAdesao;
	}

	public String getRendaInicial(){

		return rendaInicial;
	}

	public void setRendaInicial(String rendaInicial){

		this.rendaInicial = rendaInicial;
	}

	public String getRendaFinal(){

		return rendaFinal;
	}

	public void setRendaFinal(String rendaFinal){

		this.rendaFinal = rendaFinal;
	}

	public String getCelpeInicial(){

		return celpeInicial;
	}

	public void setCelpeInicial(String celpeInicial){

		this.celpeInicial = celpeInicial;
	}

	public String getCelpeFinal(){

		return celpeFinal;
	}

	public void setCelpeFinal(String celpeFinal){

		this.celpeFinal = celpeFinal;
	}

	public String getDataInicioRecadastramento(){

		return dataInicioRecadastramento;
	}

	public void setDataInicioRecadastramento(String dataInicioRecadastramento){

		this.dataInicioRecadastramento = dataInicioRecadastramento;
	}

	public String getDataFimRecadastramento(){

		return dataFimRecadastramento;
	}

	public void setDataFimRecadastramento(String dataFimRecadastramento){

		this.dataFimRecadastramento = dataFimRecadastramento;
	}

	public String getRecadastramentoNumeroInicial(){

		return recadastramentoNumeroInicial;
	}

	public void setRecadastramentoNumeroInicial(String recadastramentoNumeroInicial){

		this.recadastramentoNumeroInicial = recadastramentoNumeroInicial;
	}

	public String getRecadastramentoNumeroFinal(){

		return recadastramentoNumeroFinal;
	}

	public void setRecadastramentoNumeroFinal(String recadastramentoNumeroFinal){

		this.recadastramentoNumeroFinal = recadastramentoNumeroFinal;
	}

}
