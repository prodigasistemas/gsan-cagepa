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

package gcom.gui.faturamento.debito;

import org.apache.struts.validator.ValidatorActionForm;

/**
 * Form utilizado na pesquisa de d�bitos a cobrar de um im�vel
 * 
 * @author Pedro Alexandre
 * @date 13/03/2006
 */
public class PesquisarDebitoACobrarActionForm
				extends ValidatorActionForm {

	private static final long serialVersionUID = 1L;

	private String referenciaDebitoInicial;

	private String referenciaDebitoFinal;

	private String dataGeracaoDebitoInicial;

	private String dataGeracaoDebitoFinal;

	private String[] idSituacaoDebitoACobrar;

	private String[] idTipoDebito;

	private String[] idTipoDebitoSelecionados;

	private String idImovel;

	private String inscricaoImovel;

	private String nomeClienteUsuario;

	private String situacaoAguaImovel;

	private String situacaoEsgotoImovel;

	public String getDataGeracaoDebitoFinal(){

		return dataGeracaoDebitoFinal;
	}

	public void setDataGeracaoDebitoFinal(String dataGeracaoDebitoFinal){

		this.dataGeracaoDebitoFinal = dataGeracaoDebitoFinal;
	}

	public String getDataGeracaoDebitoInicial(){

		return dataGeracaoDebitoInicial;
	}

	public void setDataGeracaoDebitoInicial(String dataGeracaoDebitoInicial){

		this.dataGeracaoDebitoInicial = dataGeracaoDebitoInicial;
	}

	public String getIdImovel(){

		return idImovel;
	}

	public void setIdImovel(String idImovel){

		this.idImovel = idImovel;
	}

	public String[] getIdSituacaoDebitoACobrar(){

		return idSituacaoDebitoACobrar;
	}

	public void setIdSituacaoDebitoACobrar(String[] idSituacaoDebitoACobrar){

		this.idSituacaoDebitoACobrar = idSituacaoDebitoACobrar;
	}

	public String[] getIdTipoDebito(){

		return idTipoDebito;
	}

	public void setIdTipoDebito(String[] idTipoDebito){

		this.idTipoDebito = idTipoDebito;
	}

	public String getInscricaoImovel(){

		return inscricaoImovel;
	}

	public void setInscricaoImovel(String inscricaoImovel){

		this.inscricaoImovel = inscricaoImovel;
	}

	public String getNomeClienteUsuario(){

		return nomeClienteUsuario;
	}

	public void setNomeClienteUsuario(String nomeClienteUsuario){

		this.nomeClienteUsuario = nomeClienteUsuario;
	}

	public String getReferenciaDebitoFinal(){

		return referenciaDebitoFinal;
	}

	public void setReferenciaDebitoFinal(String referenciaDebitoFinal){

		this.referenciaDebitoFinal = referenciaDebitoFinal;
	}

	public String getReferenciaDebitoInicial(){

		return referenciaDebitoInicial;
	}

	public void setReferenciaDebitoInicial(String referenciaDebitoInicial){

		this.referenciaDebitoInicial = referenciaDebitoInicial;
	}

	public String getSituacaoAguaImovel(){

		return situacaoAguaImovel;
	}

	public void setSituacaoAguaImovel(String situacaoAguaImovel){

		this.situacaoAguaImovel = situacaoAguaImovel;
	}

	public String getSituacaoEsgotoImovel(){

		return situacaoEsgotoImovel;
	}

	public void setSituacaoEsgotoImovel(String situacaoEsgotoImovel){

		this.situacaoEsgotoImovel = situacaoEsgotoImovel;
	}

	public String[] getIdTipoDebitoSelecionados(){

		return idTipoDebitoSelecionados;
	}

	public void setIdTipoDebitoSelecionados(String[] idTipoDebitoSelecionados){

		this.idTipoDebitoSelecionados = idTipoDebitoSelecionados;
	}

}
