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
 * Thiago Silva Toscano de Brito
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
 * Eduardo Henrique Bandeira Carneiro da Silva
 * Saulo Vasconcelos de Lima
 * Virginia Santos de Melo
 * Vitor Cavalcante Hora
 */

package gcom.micromedicao.bean;

import java.io.Serializable;

public class RelatorioResumoLeituraFaturamentoImediatoHelper
				implements Serializable {

	private static final long serialVersionUID = 4711284798056314127L;

	private Integer idLocalidade;

	private String descricaoLocalidade;

	private Integer idSetorComercial;

	private String descricaoSetorComercial;

	private Integer idAnormalidade;

	private String descricaoAnormalidade;

	private Integer idLeitura;

	/**
	 * Construtor Default da classe
	 */
	public RelatorioResumoLeituraFaturamentoImediatoHelper() {

		super();
	}

	public RelatorioResumoLeituraFaturamentoImediatoHelper(Integer idLocalidade, String descricaoLocalidade, Integer idSetorComercial,
															String descricaoSetorComercial, Integer idAnormalidade,
															String descricaoAnormalidade, Integer idLeitura) {

		super();
		this.idLocalidade = idLocalidade;
		this.descricaoLocalidade = descricaoLocalidade;
		this.idSetorComercial = idSetorComercial;
		this.descricaoSetorComercial = descricaoSetorComercial;
		this.idAnormalidade = idAnormalidade;
		this.descricaoAnormalidade = descricaoAnormalidade;
		this.idLeitura = idLeitura;
	}

	public Integer getIdSetorComercial(){

		return idSetorComercial;
	}

	public void setIdSetorComercial(Integer idSetorComercial){

		this.idSetorComercial = idSetorComercial;
	}

	public Integer getIdLocalidade(){

		return idLocalidade;
	}

	public void setIdLocalidade(Integer idLocalidade){

		this.idLocalidade = idLocalidade;
	}

	public Integer getIdLeitura(){

		return idLeitura;
	}

	public void setIdLeitura(Integer idLeitura){

		this.idLeitura = idLeitura;
	}

	public Integer getIdAnormalidade(){

		return idAnormalidade;
	}

	public void setIdAnormalidade(Integer idAnormalidade){

		this.idAnormalidade = idAnormalidade;
	}

	public String getDescricaoSetorComercial(){

		return descricaoSetorComercial;
	}

	public void setDescricaoSetorComercial(String descricaoSetorComercial){

		this.descricaoSetorComercial = descricaoSetorComercial;
	}

	public String getDescricaoLocalidade(){

		return descricaoLocalidade;
	}

	public void setDescricaoLocalidade(String descricaoLocalidade){

		this.descricaoLocalidade = descricaoLocalidade;
	}

	public String getDescricaoAnormalidade(){

		return descricaoAnormalidade;
	}

	public void setDescricaoAnormalidade(String descricaoAnormalidade){

		this.descricaoAnormalidade = descricaoAnormalidade;
	}

}
