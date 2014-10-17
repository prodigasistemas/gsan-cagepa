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

package gcom.faturamento.bean;

import java.math.BigDecimal;

/**
 * [UC3114] - Gerar Relat�rios Faturamento Consumo Direto Indireto Estadual
 * 
 * @author Victon Santos
 * @date 27/09/2013
 */
public class FaturamentoConsumoDiretoIndiretoEstadualRelatorioHelper {

	private BigDecimal referencia;

	private BigDecimal codigoResponsavel;

	private String responsavel;

	private String tipoResponsavel;

	private BigDecimal localidade;

	private String nomeLocalidade;

	private BigDecimal matricula;

	private BigDecimal codigoUsuario;

	private String usuario;

	private BigDecimal tipoAgua;

	private BigDecimal tipoEsgoto;

	private Character categoria;

	private BigDecimal economia;

	private String endereco;

	private BigDecimal valorLeituraAnterior;

	private BigDecimal valorLeituraAtual;

	private BigDecimal consumoMicromedido;

	private BigDecimal consumoFaturado;

	private BigDecimal consumoMedio;

	public BigDecimal getReferencia(){

		return referencia;
	}

	public void setReferencia(BigDecimal referencia){

		this.referencia = referencia;
	}

	public BigDecimal getCodigoResponsavel(){

		return codigoResponsavel;
	}

	public void setCodigoResponsavel(BigDecimal codigoResponsavel){

		this.codigoResponsavel = codigoResponsavel;
	}


	public String getResponsavel(){

		return responsavel;
	}


	public void setResponsavel(String responsavel){

		this.responsavel = responsavel;
	}


	public String getTipoResponsavel(){

		return tipoResponsavel;
	}


	public void setTipoResponsavel(String tipoResponsavel){

		this.tipoResponsavel = tipoResponsavel;
	}

	public BigDecimal getLocalidade(){

		return localidade;
	}

	public void setLocalidade(BigDecimal localidade){

		this.localidade = localidade;
	}


	public String getNomeLocalidade(){

		return nomeLocalidade;
	}


	public void setNomeLocalidade(String nomeLocalidade){

		this.nomeLocalidade = nomeLocalidade;
	}
	public BigDecimal getMatricula(){

		return matricula;
	}

	public void setMatricula(BigDecimal matricula){

		this.matricula = matricula;
	}

	public BigDecimal getCodigoUsuario(){

		return codigoUsuario;
	}

	public void setCodigoUsuario(BigDecimal codigoUsuario){

		this.codigoUsuario = codigoUsuario;
	}


	public String getUsuario(){

		return usuario;
	}


	public void setUsuario(String usuario){

		this.usuario = usuario;
	}

	public BigDecimal getTipoAgua(){

		return tipoAgua;
	}

	public void setTipoAgua(BigDecimal tipoAgua){

		this.tipoAgua = tipoAgua;
	}

	public BigDecimal getTipoEsgoto(){

		return tipoEsgoto;
	}

	public void setTipoEsgoto(BigDecimal tipoEsgoto){

		this.tipoEsgoto = tipoEsgoto;
	}

	public Character getCategoria(){

		return categoria;
	}

	public void setCategoria(Character categoria){

		this.categoria = categoria;
	}

	public BigDecimal getEconomia(){

		return economia;
	}

	public void setEconomia(BigDecimal economia){

		this.economia = economia;
	}


	public String getEndereco(){

		return endereco;
	}


	public void setEndereco(String endereco){

		this.endereco = endereco;
	}

	public BigDecimal getValorLeituraAnterior(){

		return valorLeituraAnterior;
	}

	public void setValorLeituraAnterior(BigDecimal valorLeituraAnterior){

		this.valorLeituraAnterior = valorLeituraAnterior;
	}

	public BigDecimal getValorLeituraAtual(){

		return valorLeituraAtual;
	}

	public void setValorLeituraAtual(BigDecimal valorLeituraAtual){

		this.valorLeituraAtual = valorLeituraAtual;
	}

	public BigDecimal getConsumoMicromedido(){

		return consumoMicromedido;
	}

	public void setConsumoMicromedido(BigDecimal consumoMicromedido){

		this.consumoMicromedido = consumoMicromedido;
	}

	public BigDecimal getConsumoFaturado(){

		return consumoFaturado;
	}

	public void setConsumoFaturado(BigDecimal consumoFaturado){

		this.consumoFaturado = consumoFaturado;
	}

	public BigDecimal getConsumoMedio(){

		return consumoMedio;
	}

	public void setConsumoMedio(BigDecimal consumoMedio){

		this.consumoMedio = consumoMedio;
	}

}
