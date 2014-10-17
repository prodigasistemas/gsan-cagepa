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
 * Andr� Nishimura
 * Eduardo Henrique Bandeira Carneiro da Silva
 * Jos� Gilberto de Fran�a Matos
 * Saulo Vasconcelos de Lima
 * Virginia Santos de Melo
 *
 * Este programa � software livre; voc� pode redistribu�-lo e/ou
 * modific�-lo sob os termos de Licen�a P�blica Geral GNU, conforme
 * publicada pela Free Software Foundation; vers�o 2 da Licen�a.
 * Este programa � distribu�do na expectativa de ser �til, mas SEM
 * QUALQUER GARANTIA; sem mesmo a garantia impl�cita de
 * COMERCIALIZA��O ou de ADEQUA��O A QUALQUER PROP�SITO EM
 * PARTICULAR. 
 * Consulte a Licen�a P�blica Geral GNU para obter mais detalhes.
 * Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU
 * junto com este programa; se n�o, escreva para Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
 * 02111-1307, USA.
 */

package gcom.atendimentopublico.ordemservico.bean;

import gcom.atendimentopublico.ordemservico.FormaProgramacao;

/**
 * Classe helper para exibi��o dos campos no JSP.
 * 
 * @author Saulo Lima e Virg�nia Melo
 * @date 26/05/2009
 */
public class FormaProgramacaoHelper {

	private boolean mesmoDia;

	private boolean solicitaAutorizacao;

	private boolean diaPosterior;

	private boolean posterior;

	public FormaProgramacaoHelper(int idFormaGeracao) {

		if(idFormaGeracao == FormaProgramacao.FormaProgramacaoServico.MESMO_DIA.valorId()){
			this.mesmoDia = true;
		}else if(idFormaGeracao == FormaProgramacao.FormaProgramacaoServico.SOLICITA_AUTORIZACAO.valorId()){
			this.solicitaAutorizacao = true;
		}else if(idFormaGeracao == FormaProgramacao.FormaProgramacaoServico.DIA_POSTERIOR.valorId()){
			this.diaPosterior = true;
		}else if(idFormaGeracao == FormaProgramacao.FormaProgramacaoServico.POSTERIOR.valorId()){
			this.posterior = true;
		}
	}

	public boolean isMesmoDia(){

		return mesmoDia;
	}

	public void setMesmoDia(boolean mesmoDia){

		this.mesmoDia = mesmoDia;
	}

	public boolean isSolicitaAutorizacao(){

		return solicitaAutorizacao;
	}

	public void setSolicitaAutorizacao(boolean solicitaAutorizacao){

		this.solicitaAutorizacao = solicitaAutorizacao;
	}

	public boolean isDiaPosterior(){

		return diaPosterior;
	}

	public void setDiaPosterior(boolean diaPosterior){

		this.diaPosterior = diaPosterior;
	}

	public boolean isPosterior(){

		return posterior;
	}

	public void setPosterior(boolean posterior){

		this.posterior = posterior;
	}
}