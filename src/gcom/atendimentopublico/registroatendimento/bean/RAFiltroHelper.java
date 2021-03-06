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

package gcom.atendimentopublico.registroatendimento.bean;

import gcom.atendimentopublico.registroatendimento.RegistroAtendimento;
import gcom.cadastro.unidade.UnidadeOrganizacional;

/**
 * [UC0406] Filtrar Registro de Atendimento
 * Classe facilitadora para o retorno do filtro a ser usado no manter.
 * 
 * @author Leonardo Regis
 * @date 09/08/2006
 */
public class RAFiltroHelper {

	private RegistroAtendimento registroAtendimento;

	private String situacao;

	private UnidadeOrganizacional unidadeAtual;

	private UnidadeOrganizacional unidadeDestino;

	private String osProgramada;

	private String indicadorOrdemServicoGerada;

	private String enderecoOcorrencia;

	private String situacaoOS;

	private String servicoOS;

	/**
	 * @return Retorna o campo unidadeDestino.
	 */
	public UnidadeOrganizacional getUnidadeDestino(){

		return unidadeDestino;
	}

	/**
	 * @param unidadeDestino
	 *            O unidadeDestino a ser setado.
	 */
	public void setUnidadeDestino(UnidadeOrganizacional unidadeDestino){

		this.unidadeDestino = unidadeDestino;
	}

	public RAFiltroHelper() {

	}

	public String getSituacao(){

		return situacao;
	}

	public void setSituacao(String situacao){

		this.situacao = situacao;
	}

	public RegistroAtendimento getRegistroAtendimento(){

		return registroAtendimento;
	}

	public void setRegistroAtendimento(RegistroAtendimento registroAtendimento){

		this.registroAtendimento = registroAtendimento;
	}

	public UnidadeOrganizacional getUnidadeAtual(){

		return unidadeAtual;
	}

	public void setUnidadeAtual(UnidadeOrganizacional unidadeAtual){

		this.unidadeAtual = unidadeAtual;
	}

	public void setOsProgramada(String osProgramada){

		this.osProgramada = osProgramada;
	}

	public String getOsProgramada(){

		return osProgramada;
	}

	public String getIndicadorOrdemServicoGerada(){

		return indicadorOrdemServicoGerada;
	}

	public void setIndicadorOrdemServicoGerada(String indicadorOrdemServicoGerada){

		this.indicadorOrdemServicoGerada = indicadorOrdemServicoGerada;
	}

	public String getEnderecoOcorrencia(){

		return enderecoOcorrencia;
	}

	public void setEnderecoOcorrencia(String enderecoOcorrencia){

		this.enderecoOcorrencia = enderecoOcorrencia;
	}

	public void setSituacaoOS(String situacaoOS){

		this.situacaoOS = situacaoOS;
	}

	public String getSituacaoOS(){

		return situacaoOS;
	}

	public void setServicoOS(String servicoOS){

		this.servicoOS = servicoOS;
	}

	public String getServicoOS(){

		return servicoOS;
	}

}
