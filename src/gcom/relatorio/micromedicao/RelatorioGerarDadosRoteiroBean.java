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

package gcom.relatorio.micromedicao;

import gcom.micromedicao.bean.GerarDadosParaLeituraHelper;
import gcom.relatorio.RelatorioBean;

/**
 * [UC ]
 * 
 * @author S�vio Luiz
 * @date 27/08/2007
 */
public class RelatorioGerarDadosRoteiroBean
				implements RelatorioBean {

	private String anoMesReferncia;

	private String codigoVinculada;

	private String codigoLocalidade;

	private String descricaoLocalidade;

	private String codigoSetor;

	private String codigoRota;

	private String grupo;

	private String localizacao;

	private String enderecoImovel;

	private String categoria;

	private String numeroHidrometro;

	private String localInstalacao;

	private String matriculaImovel;

	private String faixaLeitura;

	private String elo;

	public RelatorioGerarDadosRoteiroBean(GerarDadosParaLeituraHelper gerarDadosParaLeituraHelper) {

		this.codigoRota = gerarDadosParaLeituraHelper.getCodigoRota();
		this.descricaoLocalidade = gerarDadosParaLeituraHelper.getDescricaoLocalidade();
		this.anoMesReferncia = gerarDadosParaLeituraHelper.getAnoMesReferncia();
		this.grupo = gerarDadosParaLeituraHelper.getGrupo();
		this.codigoSetor = gerarDadosParaLeituraHelper.getCodigoSetor();
		this.numeroHidrometro = gerarDadosParaLeituraHelper.getNumeroHidrometro();
		this.localInstalacao = gerarDadosParaLeituraHelper.getLocalInstalacao();
		this.matriculaImovel = gerarDadosParaLeituraHelper.getMatriculaImovel();
		this.enderecoImovel = gerarDadosParaLeituraHelper.getEnderecoImovel();
		this.faixaLeitura = gerarDadosParaLeituraHelper.getFaixaLeitura();
		this.categoria = gerarDadosParaLeituraHelper.getCategoria();
		this.elo = gerarDadosParaLeituraHelper.getElo();
	}

	public String getAnoMesReferncia(){

		return anoMesReferncia;
	}

	public void setAnoMesReferncia(String anoMesReferncia){

		this.anoMesReferncia = anoMesReferncia;
	}

	public String getCodigoRota(){

		return codigoRota;
	}

	public void setCodigoRota(String codigoRota){

		this.codigoRota = codigoRota;
	}

	public String getCodigoSetor(){

		return codigoSetor;
	}

	public void setCodigoSetor(String codigoSetor){

		this.codigoSetor = codigoSetor;
	}

	public String getDescricaoLocalidade(){

		return descricaoLocalidade;
	}

	public void setDescricaoLocalidade(String descricaoLocalidade){

		this.descricaoLocalidade = descricaoLocalidade;
	}

	public String getGrupo(){

		return grupo;
	}

	public void setGrupo(String grupo){

		this.grupo = grupo;
	}

	public String getLocalInstalacao(){

		return localInstalacao;
	}

	public void setLocalInstalacao(String localInstalacao){

		this.localInstalacao = localInstalacao;
	}

	public String getMatriculaImovel(){

		return matriculaImovel;
	}

	public void setMatriculaImovel(String matriculaImovel){

		this.matriculaImovel = matriculaImovel;
	}

	public String getNumeroHidrometro(){

		return numeroHidrometro;
	}

	public void setNumeroHidrometro(String numeroHidrometro){

		this.numeroHidrometro = numeroHidrometro;
	}

	public String getEnderecoImovel(){

		return enderecoImovel;
	}

	public void setEnderecoImovel(String enderecoImovel){

		this.enderecoImovel = enderecoImovel;
	}

	public String getCodigoVinculada(){

		return codigoVinculada;
	}

	public void setCodigoVinculada(String codigoVinculada){

		this.codigoVinculada = codigoVinculada;
	}

	public String getCodigoLocalidade(){

		return codigoLocalidade;
	}

	public void setCodigoLocalidade(String codigoLocalidade){

		this.codigoLocalidade = codigoLocalidade;
	}

	public String getLocalizacao(){

		return localizacao;
	}

	public void setLocalizacao(String localizacao){

		this.localizacao = localizacao;
	}

	public String getCategoria(){

		return categoria;
	}

	public void setCategoria(String categoria){

		this.categoria = categoria;
	}

	public String getFaixaLeitura(){

		return faixaLeitura;
	}

	public void setFaixaLeitura(String faixaLeitura){

		this.faixaLeitura = faixaLeitura;
	}

	public String getElo(){

		return elo;
	}

	public void setElo(String elo){

		this.elo = elo;
	}

}