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
 * [UC0538] Filtrar RAs na Agencia Reguladora
 * 
 * @author K�ssia Albuquerque
 * @date 02/05/2007
 */

public class FiltrarRaDadosAgenciaReguladoraActionForm
				extends ValidatorForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String numeroRa;

	private String motivoReclamacao;

	private String motivoEncerramentoAtendimento;

	private String indicadorSituacaoAgencia;

	private String indicadorSituacaoRA;

	private String periodoReclamacaoInicio;

	private String periodoReclamacaoFim;

	private String periodoRetornoInicio;

	private String periodoRetornoFim;

	private String motivoRetornoAgencia;

	public String getIndicadorSituacaoAgencia(){

		return indicadorSituacaoAgencia;
	}

	public void setIndicadorSituacaoAgencia(String indicadorSituacaoAgencia){

		this.indicadorSituacaoAgencia = indicadorSituacaoAgencia;
	}

	public String getIndicadorSituacaoRA(){

		return indicadorSituacaoRA;
	}

	public void setIndicadorSituacaoRA(String indicadorSituacaoRA){

		this.indicadorSituacaoRA = indicadorSituacaoRA;
	}

	public String getMotivoEncerramentoAtendimento(){

		return motivoEncerramentoAtendimento;
	}

	public void setMotivoEncerramentoAtendimento(String motivoEncerramentoAtendimento){

		this.motivoEncerramentoAtendimento = motivoEncerramentoAtendimento;
	}

	public String getMotivoReclamacao(){

		return motivoReclamacao;
	}

	public void setMotivoReclamacao(String motivoReclamacao){

		this.motivoReclamacao = motivoReclamacao;
	}

	public String getMotivoRetornoAgencia(){

		return motivoRetornoAgencia;
	}

	public void setMotivoRetornoAgencia(String motivoRetornoAgencia){

		this.motivoRetornoAgencia = motivoRetornoAgencia;
	}

	public String getNumeroRa(){

		return numeroRa;
	}

	public void setNumeroRa(String numeroRa){

		this.numeroRa = numeroRa;
	}

	public String getPeriodoReclamacaoFim(){

		return periodoReclamacaoFim;
	}

	public void setPeriodoReclamacaoFim(String periodoReclamacaoFim){

		this.periodoReclamacaoFim = periodoReclamacaoFim;
	}

	public String getPeriodoReclamacaoInicio(){

		return periodoReclamacaoInicio;
	}

	public void setPeriodoReclamacaoInicio(String periodoReclamacaoInicio){

		this.periodoReclamacaoInicio = periodoReclamacaoInicio;
	}

	public String getPeriodoRetornoFim(){

		return periodoRetornoFim;
	}

	public void setPeriodoRetornoFim(String periodoRetornoFim){

		this.periodoRetornoFim = periodoRetornoFim;
	}

	public String getPeriodoRetornoInicio(){

		return periodoRetornoInicio;
	}

	public void setPeriodoRetornoInicio(String periodoRetornoInicio){

		this.periodoRetornoInicio = periodoRetornoInicio;
	}

	/*
	 * public RaDadosAgenciaReguladora setDadosAgenciaReguladora(RaDadosAgenciaReguladora
	 * raDadosAgenciaReguladora) {
	 * RegistroAtendimento registroAtendimento = new RegistroAtendimento();
	 * registroAtendimento.setId(new Integer(getNumeroRADados()));
	 * raDadosAgenciaReguladora.setRegistroAtendimento(registroAtendimento);
	 * AgenciaReguladoraMotReclamacao agenciaReguladoraMotReclamacao = new
	 * AgenciaReguladoraMotReclamacao();
	 * agenciaReguladoraMotReclamacao.setId(new Integer(getMotivoReclamacao()));
	 * raDadosAgenciaReguladora.setAgenciaReguladoraMotReclamacao(agenciaReguladoraMotReclamacao);
	 * if (getIdMotivoEncerramento() != null && !getIdMotivoEncerramento().equalsIgnoreCase("") ){
	 * AtendimentoMotivoEncerramento atendimentoMotivoEncerramento = new
	 * AtendimentoMotivoEncerramento();
	 * atendimentoMotivoEncerramento.setId(new Integer(getIdMotivoEncerramento()));
	 * raDadosAgenciaReguladora.setAtendimentoMotivoEncerramento(atendimentoMotivoEncerramento);
	 * }
	 * raDadosAgenciaReguladora.setAgenciaReguladora(getNumeroRegistroAgenciaReguladora());
	 * raDadosAgenciaReguladora.setDataPrevisaoOriginal(Util.converteStringParaDate(
	 * getDataPrevisaoOriginal()));
	 * 
	 * raDadosAgenciaReguladora.setDataPrevisaoAtual(Util.converteStringParaDate(getDataPrevisaoAtual
	 * ()));
	 * raDadosAgenciaReguladora.setDescricaoReclamacao(getReclamacao());
	 * raDadosAgenciaReguladora.setCodigoSituacaoArpe(new Short(getCodigoSituacao()));
	 * raDadosAgenciaReguladora.setCodigoSituacao(RegistroAtendimento.SITUACAO_PENDENTE);
	 * return raDadosAgenciaReguladora;
	 * }
	 */

}