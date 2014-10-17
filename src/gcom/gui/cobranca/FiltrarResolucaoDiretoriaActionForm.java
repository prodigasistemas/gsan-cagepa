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

package gcom.gui.cobranca;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * [UC0217] Inserir Resolu��o de Diretoria
 * 
 * @author Rafael Corr�a
 * @since 30/03/2006
 */
public class FiltrarResolucaoDiretoriaActionForm
				extends ActionForm {

	private static final long serialVersionUID = 1L;

	private String numero;

	private String assunto;

	private String dataInicio;

	private String dataFim;

	private String atualizar;

	private String grupo;

	private String resolucaoDiretoriaLayout;

	private String tipoPesquisa;

	private String indicadorUsoRDParcImovel;

	private String indicadorUsoRDUsuarios;

	private String indicadorUsoRDDebitoCobrar;

	private String indicadorEmissaoAssuntoConta;

	private String indicadorTrataMediaAtualizacaoMonetaria;

	private String idLocalidade;

	private String anoMesReferenciaDebitoInicio;

	private String anoMesReferenciaDebitoFim;

	private String nomeLocalidade;

	private String indicadorCobrarDescontosArrasto;

	private String indicadorArrasto;

	public String getAtualizar(){

		return atualizar;
	}

	public void setAtualizar(String atualizar){

		this.atualizar = atualizar;
	}

	public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest httpServletRequest){

		/** @todo: finish this method, this is just the skeleton. */
		return null;
	}

	public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest){

		numero = null;
		assunto = null;
		dataInicio = null;
		dataFim = null;
		resolucaoDiretoriaLayout = null;
		grupo = null;
		indicadorUsoRDParcImovel = null;
		indicadorUsoRDUsuarios = null;
		indicadorUsoRDDebitoCobrar = null;
		anoMesReferenciaDebitoInicio = null;
		anoMesReferenciaDebitoFim = null;
	}

	public String getDataFim(){

		return dataFim;
	}

	public void setDataFim(String dataFim){

		this.dataFim = dataFim;
	}

	public String getDataInicio(){

		return dataInicio;
	}

	public void setDataInicio(String dataInicio){

		this.dataInicio = dataInicio;
	}

	public String getNumero(){

		return numero;
	}

	public void setNumero(String numero){

		this.numero = numero;
	}

	public String getAssunto(){

		return assunto;
	}

	public void setAssunto(String assunto){

		this.assunto = assunto;
	}

	public String getGrupo(){

		return grupo;
	}

	public void setGrupo(String grupo){

		this.grupo = grupo;
	}

	public String getResolucaoDiretoriaLayout(){

		return resolucaoDiretoriaLayout;
	}

	public void setResolucaoDiretoriaLayout(String resolucaoDiretoriaLayout){

		this.resolucaoDiretoriaLayout = resolucaoDiretoriaLayout;
	}

	public String getTipoPesquisa(){

		return tipoPesquisa;
	}

	public void setTipoPesquisa(String tipoPesquisa){

		this.tipoPesquisa = tipoPesquisa;
	}

	public String getIndicadorUsoRDParcImovel(){

		return indicadorUsoRDParcImovel;
	}

	public void setIndicadorUsoRDParcImovel(String indicadorUsoRDParcImovel){

		this.indicadorUsoRDParcImovel = indicadorUsoRDParcImovel;
	}

	public String getIndicadorUsoRDUsuarios(){

		return indicadorUsoRDUsuarios;
	}

	public void setIndicadorUsoRDUsuarios(String indicadorUsoRDUsuarios){

		this.indicadorUsoRDUsuarios = indicadorUsoRDUsuarios;
	}

	public String getIndicadorUsoRDDebitoCobrar(){

		return indicadorUsoRDDebitoCobrar;
	}

	public void setIndicadorUsoRDDebitoCobrar(String indicadorUsoRDDebitoCobrar){

		this.indicadorUsoRDDebitoCobrar = indicadorUsoRDDebitoCobrar;
	}

	public String getIdLocalidade(){

		return idLocalidade;
	}

	public void setIdLocalidade(String idLocalidade){

		this.idLocalidade = idLocalidade;
	}

	public String getAnoMesReferenciaDebitoInicio(){

		return anoMesReferenciaDebitoInicio;
	}

	public void setAnoMesReferenciaDebitoInicio(String anoMesReferenciaDebitoInicio){

		this.anoMesReferenciaDebitoInicio = anoMesReferenciaDebitoInicio;
	}

	public String getAnoMesReferenciaDebitoFim(){

		return anoMesReferenciaDebitoFim;
	}

	public void setAnoMesReferenciaDebitoFim(String anoMesReferenciaDebitoFim){

		this.anoMesReferenciaDebitoFim = anoMesReferenciaDebitoFim;
	}

	public String getNomeLocalidade(){

		return nomeLocalidade;
	}

	public void setNomeLocalidade(String nomeLocalidade){

		this.nomeLocalidade = nomeLocalidade;
	}

	public String getIndicadorEmissaoAssuntoConta(){

		return indicadorEmissaoAssuntoConta;
	}

	public void setIndicadorEmissaoAssuntoConta(String indicadorEmissaoAssuntoConta){

		this.indicadorEmissaoAssuntoConta = indicadorEmissaoAssuntoConta;
	}

	public String getIndicadorTrataMediaAtualizacaoMonetaria(){

		return indicadorTrataMediaAtualizacaoMonetaria;
	}

	public void setIndicadorTrataMediaAtualizacaoMonetaria(String indicadorTrataMediaAtualizacaoMonetaria){

		this.indicadorTrataMediaAtualizacaoMonetaria = indicadorTrataMediaAtualizacaoMonetaria;
	}

	public String getIndicadorCobrarDescontosArrasto(){

		return indicadorCobrarDescontosArrasto;
	}

	public void setIndicadorCobrarDescontosArrasto(String indicadorCobrarDescontosArrasto){

		this.indicadorCobrarDescontosArrasto = indicadorCobrarDescontosArrasto;
	}

	public void setIndicadorArrasto(String indicadorArrasto){

		this.indicadorArrasto = indicadorArrasto;
	}

	public String getIndicadorArrasto(){

		return indicadorArrasto;
	}

}
