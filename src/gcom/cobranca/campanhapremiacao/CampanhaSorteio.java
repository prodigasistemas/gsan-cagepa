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
 * 
 * GSANPCG
 * Virg�nia Melo
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

package gcom.cobranca.campanhapremiacao;

import gcom.interceptor.ObjetoTransacao;
import gcom.seguranca.acesso.usuario.Usuario;
import gcom.util.Util;
import gcom.util.filtro.Filtro;

import java.util.Date;

public class CampanhaSorteio
				extends ObjetoTransacao {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Date dataSorteio;

	private Date sorteioInicio;

	private Date sorteioFim;

	private Integer quantidadePremiacoes;

	private Integer quantidadePremiacoesCanceladas;

	private Campanha campanha;

	private Usuario usuario;

	private Date ultimaAlteracao;

	public CampanhaSorteio() {

		// TODO Auto-generated constructor stub
	}

	@Override
	public Filtro retornaFiltro(){

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] retornaCamposChavePrimaria(){

		String[] retorno = new String[1];
		retorno[0] = "id";
		return retorno;
	}

	public Integer getId(){

		return id;
	}

	public void setId(Integer id){

		this.id = id;
	}


	public Date getUltimaAlteracao(){

		return ultimaAlteracao;
	}


	public void setUltimaAlteracao(Date ultimaAlteracao){

		this.ultimaAlteracao = ultimaAlteracao;
	}

	public Date getDataSorteio(){

		return dataSorteio;
	}

	public void setDataSorteio(Date dataSorteio){

		this.dataSorteio = dataSorteio;
	}

	public Date getSorteioInicio(){

		return sorteioInicio;
	}

	public void setSorteioInicio(Date sorteioInicio){

		this.sorteioInicio = sorteioInicio;
	}

	public Date getSorteioFim(){

		return sorteioFim;
	}

	public void setSorteioFim(Date sorteioFim){

		this.sorteioFim = sorteioFim;
	}

	public Integer getQuantidadePremiacoes(){

		return quantidadePremiacoes;
	}

	public void setQuantidadePremiacoes(Integer quantidadePremiacoes){

		this.quantidadePremiacoes = quantidadePremiacoes;
	}

	public Integer getQuantidadePremiacoesCanceladas(){

		return quantidadePremiacoesCanceladas;
	}

	public void setQuantidadePremiacoesCanceladas(Integer quantidadePremiacoesCanceladas){

		this.quantidadePremiacoesCanceladas = quantidadePremiacoesCanceladas;
	}

	public Campanha getCampanha(){

		return campanha;
	}

	public void setCampanha(Campanha campanha){

		this.campanha = campanha;
	}

	public Usuario getUsuario(){

		return usuario;
	}

	public void setUsuario(Usuario usuario){

		this.usuario = usuario;
	}

	public String getDataSorteioFormatada(){

		return Util.formatarData(dataSorteio);

	}

}
