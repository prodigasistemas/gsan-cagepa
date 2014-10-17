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
 * GSANPCG
 * Eduardo Henrique
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

package gcom.arrecadacao.bean;

import java.io.Serializable;

/**
 * @author S�vio Luiz
 * @created 30 de Janeiro de 2006 [UC0264] - Distribuir Dados do C�digo de
 *          Barras
 * @author eduardo henrique
 * @date 20/12/2008
 *       Adi��o de Atributo de identifica��o de C�digo de Barras de Sistema Legado.
 */
public class RegistroHelperCodigoBarras
				implements Serializable {

	private static final long serialVersionUID = 1L;

	public RegistroHelperCodigoBarras() {

	}

	private String idProduto;

	private String idSegmento;

	private String idValorReal;

	private String digitoVerificadorGeral;

	private String valorPagamento;

	private String idEmpresa;

	private RegistroHelperCodigoBarrasTipoPagamento registroHelperCodigoBarrasTipoPagamento;

	private String tipoPagamento;

	private boolean legado;

	private String descricaoOcorrencia;

	public String getDigitoVerificadorGeral(){

		return digitoVerificadorGeral;
	}

	public void setDigitoVerificadorGeral(String digitoVerificadorGeral){

		this.digitoVerificadorGeral = digitoVerificadorGeral;
	}

	public String getIdEmpresa(){

		return idEmpresa;
	}

	public void setIdEmpresa(String idEmpresa){

		this.idEmpresa = idEmpresa;
	}

	public String getIdProduto(){

		return idProduto;
	}

	public void setIdProduto(String idProduto){

		this.idProduto = idProduto;
	}

	public String getIdSegmento(){

		return idSegmento;
	}

	public void setIdSegmento(String idSegmento){

		this.idSegmento = idSegmento;
	}

	public String getIdValorReal(){

		return idValorReal;
	}

	public void setIdValorReal(String idValorReal){

		this.idValorReal = idValorReal;
	}

	public String getTipoPagamento(){

		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento){

		this.tipoPagamento = tipoPagamento;
	}

	public String getValorPagamento(){

		return valorPagamento;
	}

	public void setValorPagamento(String valorPagamento){

		this.valorPagamento = valorPagamento;
	}

	public RegistroHelperCodigoBarrasTipoPagamento getRegistroHelperCodigoBarrasTipoPagamento(){

		return registroHelperCodigoBarrasTipoPagamento;
	}

	public void setRegistroHelperCodigoBarrasTipoPagamento(RegistroHelperCodigoBarrasTipoPagamento registroHelperCodigoBarrasTipoPagamento){

		this.registroHelperCodigoBarrasTipoPagamento = registroHelperCodigoBarrasTipoPagamento;
	}

	public boolean isLegado(){

		return legado;
	}

	public void setLegado(boolean legado){

		this.legado = legado;
	}

	public String getDescricaoOcorrencia(){

		return descricaoOcorrencia;
	}

	public void setDescricaoOcorrencia(String descricaoOcorrencia){

		this.descricaoOcorrencia = descricaoOcorrencia;
	}

}