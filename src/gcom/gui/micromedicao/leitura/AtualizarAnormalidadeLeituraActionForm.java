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
 * 
 * GSANPCG
 * Eduardo Henrique
 */

package gcom.gui.micromedicao.leitura;

import org.apache.struts.validator.ValidatorActionForm;

/**
 * <<Descri��o da classe>>
 * 
 * @author lms
 * @date 26/07/2006
 * @author eduardo henrique
 * @date 16/06/2008
 *       Inclus�o dos atributos: Mensagem de Leitura , Mensagem de manuten��o, Mensagem de preven��o
 *       de acidentes
 *       Incid�ncia da anormalidade para a gera��o da ordem de servi�o,
 *       Emiss�o autom�tica de documento, Indicador de que a ocorr�ncia aceita leitura,
 *       Indicador de que a ocorr�ncia deve ser listada nos relat�rios de cr�tica/fiscaliza��o de
 *       leitura
 *       Indicador de reten��o de conta , Indicador de concess�o de cr�dito de consumo
 *       Indicador de isen��o de cobran�a de �gua, Indicador de isen��o de cobran�a de esgoto
 */
public class AtualizarAnormalidadeLeituraActionForm
				extends ValidatorActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String descricao;

	private String abreviatura;

	private String indicadorRelativoHidrometro;

	private String indicadorImovelSemHidrometro;

	private String usoRestritoSistema;

	private String perdaTarifaSocial;

	private String osAutomatico;

	private String tipoServico;

	private String consumoLeituraNaoInformado;

	private String consumoLeituraInformado;

	private String leituraLeituraNaoturaInformado;

	private String leituraLeituraInformado;

	private String dataUltimaAlteracao;

	private String indicadorUso;

	private String tipoDocumento;

	private String numeroIncidenciasGeracaoOS;

	private String aceiteLeitura;

	private String impressaoRelatorioCriticaFiscalizacao;

	private String indicadorRetencaoConta;

	private String indicadorIsencaoCobrancaAgua;

	private String indicadorIsencaoCobrancaEsgoto;

	private String indicadorConcessaoCreditoConsumo;

	private String mensagemImpressaoConta;

	private String sugestaoAgenteManutencao;

	private String sugestaoAgentePrevencao;

	public String getIndicadorUso(){

		return indicadorUso;
	}

	public void setIndicadorUso(String indicadorUso){

		this.indicadorUso = indicadorUso;
	}

	public String getDataUltimaAlteracao(){

		return dataUltimaAlteracao;
	}

	public void setDataUltimaAlteracao(String dataUltimaAlteracao){

		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

	public String getAbreviatura(){

		return abreviatura;
	}

	public void setAbreviatura(String abreviatura){

		this.abreviatura = abreviatura;
	}

	public String getConsumoLeituraInformado(){

		return consumoLeituraInformado;
	}

	public void setConsumoLeituraInformado(String consumoLeituraInformado){

		this.consumoLeituraInformado = consumoLeituraInformado;
	}

	public String getConsumoLeituraNaoInformado(){

		return consumoLeituraNaoInformado;
	}

	public void setConsumoLeituraNaoInformado(String consumoLeituraNaoInformado){

		this.consumoLeituraNaoInformado = consumoLeituraNaoInformado;
	}

	public String getDescricao(){

		return descricao;
	}

	public void setDescricao(String descricao){

		this.descricao = descricao;
	}

	public String getIndicadorImovelSemHidrometro(){

		return indicadorImovelSemHidrometro;
	}

	public void setIndicadorImovelSemHidrometro(String indicadorImovelSemHidrometro){

		this.indicadorImovelSemHidrometro = indicadorImovelSemHidrometro;
	}

	public String getIndicadorRelativoHidrometro(){

		return indicadorRelativoHidrometro;
	}

	public void setIndicadorRelativoHidrometro(String indicadorRelativoHidrometro){

		this.indicadorRelativoHidrometro = indicadorRelativoHidrometro;
	}

	public String getLeituraLeituraInformado(){

		return leituraLeituraInformado;
	}

	public void setLeituraLeituraInformado(String leituraLeituraInformado){

		this.leituraLeituraInformado = leituraLeituraInformado;
	}

	public String getLeituraLeituraNaoturaInformado(){

		return leituraLeituraNaoturaInformado;
	}

	public void setLeituraLeituraNaoturaInformado(String leituraLeituraNaoturaInformado){

		this.leituraLeituraNaoturaInformado = leituraLeituraNaoturaInformado;
	}

	public String getOsAutomatico(){

		return osAutomatico;
	}

	public void setOsAutomatico(String osAutomatico){

		this.osAutomatico = osAutomatico;
	}

	public String getPerdaTarifaSocial(){

		return perdaTarifaSocial;
	}

	public void setPerdaTarifaSocial(String perdaTarifaSocial){

		this.perdaTarifaSocial = perdaTarifaSocial;
	}

	public String getTipoServico(){

		return tipoServico;
	}

	public void setTipoServico(String tipoServico){

		this.tipoServico = tipoServico;
	}

	public String getUsoRestritoSistema(){

		return usoRestritoSistema;
	}

	public void setUsoRestritoSistema(String usoRestritoSistema){

		this.usoRestritoSistema = usoRestritoSistema;
	}

	public String getTipoDocumento(){

		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento){

		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroIncidenciasGeracaoOS(){

		return numeroIncidenciasGeracaoOS;
	}

	public void setNumeroIncidenciasGeracaoOS(String numeroIncidenciasGeracaoOS){

		this.numeroIncidenciasGeracaoOS = numeroIncidenciasGeracaoOS;
	}

	public String getAceiteLeitura(){

		return aceiteLeitura;
	}

	public void setAceiteLeitura(String aceiteLeitura){

		this.aceiteLeitura = aceiteLeitura;
	}

	public String getImpressaoRelatorioCriticaFiscalizacao(){

		return impressaoRelatorioCriticaFiscalizacao;
	}

	public void setImpressaoRelatorioCriticaFiscalizacao(String impressaoRelatorioCriticaFiscalizacao){

		this.impressaoRelatorioCriticaFiscalizacao = impressaoRelatorioCriticaFiscalizacao;
	}

	public String getIndicadorRetencaoConta(){

		return indicadorRetencaoConta;
	}

	public void setIndicadorRetencaoConta(String indicadorRetencaoConta){

		this.indicadorRetencaoConta = indicadorRetencaoConta;
	}

	public String getIndicadorIsencaoCobrancaAgua(){

		return indicadorIsencaoCobrancaAgua;
	}

	public void setIndicadorIsencaoCobrancaAgua(String indicadorIsencaoCobrancaAgua){

		this.indicadorIsencaoCobrancaAgua = indicadorIsencaoCobrancaAgua;
	}

	public String getIndicadorIsencaoCobrancaEsgoto(){

		return indicadorIsencaoCobrancaEsgoto;
	}

	public void setIndicadorIsencaoCobrancaEsgoto(String indicadorIsencaoCobrancaEsgoto){

		this.indicadorIsencaoCobrancaEsgoto = indicadorIsencaoCobrancaEsgoto;
	}

	public String getIndicadorConcessaoCreditoConsumo(){

		return indicadorConcessaoCreditoConsumo;
	}

	public void setIndicadorConcessaoCreditoConsumo(String indicadorConcessaoCreditoConsumo){

		this.indicadorConcessaoCreditoConsumo = indicadorConcessaoCreditoConsumo;
	}

	public String getMensagemImpressaoConta(){

		return mensagemImpressaoConta;
	}

	public void setMensagemImpressaoConta(String mensagemImpressaoConta){

		this.mensagemImpressaoConta = mensagemImpressaoConta;
	}

	public String getSugestaoAgenteManutencao(){

		return sugestaoAgenteManutencao;
	}

	public void setSugestaoAgenteManutencao(String sugestaoAgenteManutencao){

		this.sugestaoAgenteManutencao = sugestaoAgenteManutencao;
	}

	public String getSugestaoAgentePrevencao(){

		return sugestaoAgentePrevencao;
	}

	public void setSugestaoAgentePrevencao(String sugestaoAgentePrevencao){

		this.sugestaoAgentePrevencao = sugestaoAgentePrevencao;
	}
}
