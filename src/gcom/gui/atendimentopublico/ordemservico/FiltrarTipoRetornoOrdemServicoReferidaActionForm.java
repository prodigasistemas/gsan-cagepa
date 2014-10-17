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

package gcom.gui.atendimentopublico.ordemservico;

import org.apache.struts.validator.ValidatorActionForm;

/**
 * [UC0397] Filtrar Tipo de Retorno da OS Referida
 * 
 * @author Thiago Ten�rio
 * @date 26/10/2006
 */
public class FiltrarTipoRetornoOrdemServicoReferidaActionForm
				extends ValidatorActionForm {

	private static final long serialVersionUID = 1L;

	private String codigoTipoRetorno;

	private String descricao;

	private String servicoTipoReferencia;

	private String deferimento;

	private String trocaServico;

	private String situacao;

	private String atendimentoMotivoEncerramento;

	private String indicadorUso;

	private String abreviatura;

	private String documentoCobranca;

	private String atualizar;

	/**
	 * @return Retorna o campo atualizar.
	 */
	public String getAtualizar(){

		return atualizar;
	}

	/**
	 * @param atualizar
	 *            O atualizar a ser setado.
	 */
	public void setAtualizar(String atualizar){

		this.atualizar = atualizar;
	}

	/**
	 * @return Retorna o campo codigoTipoRetorno.
	 */
	public String getCodigoTipoRetorno(){

		return codigoTipoRetorno;
	}

	/**
	 * @param codigoTipoRetorno
	 *            O codigoTipoRetorno a ser setado.
	 */
	public void setCodigoTipoRetorno(String codigoTipoRetorno){

		this.codigoTipoRetorno = codigoTipoRetorno;
	}

	/**
	 * @return Retorna o campo indicadorUso.
	 */
	public String getIndicadorUso(){

		return indicadorUso;
	}

	/**
	 * @param indicadorUso
	 *            O indicadorUso a ser setado.
	 */
	public void setIndicadorUso(String indicadorUso){

		this.indicadorUso = indicadorUso;
	}

	/**
	 * @return Retorna o campo abreviatura.
	 */
	public String getAbreviatura(){

		return abreviatura;
	}

	/**
	 * @param abreviatura
	 *            O abreviatura a ser setado.
	 */
	public void setAbreviatura(String abreviatura){

		this.abreviatura = abreviatura;
	}

	/**
	 * @return Retorna o campo atendimentoMotivoEncerramento.
	 */
	public String getAtendimentoMotivoEncerramento(){

		return atendimentoMotivoEncerramento;
	}

	/**
	 * @param atendimentoMotivoEncerramento
	 *            O atendimentoMotivoEncerramento a ser setado.
	 */
	public void setAtendimentoMotivoEncerramento(String atendimentoMotivoEncerramento){

		this.atendimentoMotivoEncerramento = atendimentoMotivoEncerramento;
	}

	/**
	 * @return Retorna o campo deferimento.
	 */
	public String getDeferimento(){

		return deferimento;
	}

	/**
	 * @param deferimento
	 *            O deferimento a ser setado.
	 */
	public void setDeferimento(String deferimento){

		this.deferimento = deferimento;
	}

	/**
	 * @return Retorna o campo descricao.
	 */
	public String getDescricao(){

		return descricao;
	}

	/**
	 * @param descricao
	 *            O descricao a ser setado.
	 */
	public void setDescricao(String descricao){

		this.descricao = descricao;
	}

	/**
	 * @return Retorna o campo documentoCobranca.
	 */
	public String getDocumentoCobranca(){

		return documentoCobranca;
	}

	/**
	 * @param documentoCobranca
	 *            O documentoCobranca a ser setado.
	 */
	public void setDocumentoCobranca(String documentoCobranca){

		this.documentoCobranca = documentoCobranca;
	}

	/**
	 * @return Retorna o campo servicoTipoReferencia.
	 */
	public String getServicoTipoReferencia(){

		return servicoTipoReferencia;
	}

	/**
	 * @param servicoTipoReferencia
	 *            O servicoTipoReferencia a ser setado.
	 */
	public void setServicoTipoReferencia(String servicoTipoReferencia){

		this.servicoTipoReferencia = servicoTipoReferencia;
	}

	/**
	 * @return Retorna o campo situacao.
	 */
	public String getSituacao(){

		return situacao;
	}

	/**
	 * @param situacao
	 *            O situacao a ser setado.
	 */
	public void setSituacao(String situacao){

		this.situacao = situacao;
	}

	/**
	 * @return Retorna o campo trocaServico.
	 */
	public String getTrocaServico(){

		return trocaServico;
	}

	/**
	 * @param trocaServico
	 *            O trocaServico a ser setado.
	 */
	public void setTrocaServico(String trocaServico){

		this.trocaServico = trocaServico;
	}

}