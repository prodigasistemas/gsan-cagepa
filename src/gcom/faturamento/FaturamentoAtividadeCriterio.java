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

package gcom.faturamento;

import gcom.atendimentopublico.ligacaoagua.LigacaoAguaSituacao;
import gcom.atendimentopublico.ligacaoesgoto.LigacaoEsgotoSituacao;
import gcom.interceptor.ObjetoGcom;
import gcom.micromedicao.leitura.LeituraTipo;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author Isaac Silva, Anderson Italo
 * @date 29/06/2011, 15/08/2011
 */
public class FaturamentoAtividadeCriterio
				extends ObjetoGcom {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private FaturamentoAtividade faturamentoAtividade;

	private LigacaoAguaSituacao ligacaoAguaSituacao;

	private LigacaoEsgotoSituacao ligacaoEsgotoSituacao;

	private Short indicadorHidrometroLigacaoAgua;

	private Short indicadorHidrometroLigacaoPoco;

	private Short indicadorLeituraFiscalizacaoCortado;

	private Short indicadorLeituraFiscalizacaoSuprimido;

	private Short indicadorSituacaoLigacaoAguaFaturavel;

	private Short indicadorSituacaoLigacaoEsgotoFaturavel;

	private LeituraTipo leituraTipo;

	private Short indicadorDebitoACobrar;

	private Short indicadorDebitoACobrarParcelamento;

	public Integer getId(){

		return id;
	}

	public void setId(Integer id){

		this.id = id;
	}

	public FaturamentoAtividade getFaturamentoAtividade(){

		return faturamentoAtividade;
	}

	public void setFaturamentoAtividade(FaturamentoAtividade faturamentoAtividade){

		this.faturamentoAtividade = faturamentoAtividade;
	}

	public LigacaoAguaSituacao getLigacaoAguaSituacao(){

		return ligacaoAguaSituacao;
	}

	public void setLigacaoAguaSituacao(LigacaoAguaSituacao ligacaoAguaSituacao){

		this.ligacaoAguaSituacao = ligacaoAguaSituacao;
	}

	public LigacaoEsgotoSituacao getLigacaoEsgotoSituacao(){

		return ligacaoEsgotoSituacao;
	}

	public void setLigacaoEsgotoSituacao(LigacaoEsgotoSituacao ligacaoEsgotoSituacao){

		this.ligacaoEsgotoSituacao = ligacaoEsgotoSituacao;
	}

	public Short getIndicadorHidrometroLigacaoAgua(){

		return indicadorHidrometroLigacaoAgua;
	}

	public void setIndicadorHidrometroLigacaoAgua(Short indicadorHidrometroLigacaoAgua){

		this.indicadorHidrometroLigacaoAgua = indicadorHidrometroLigacaoAgua;
	}

	public Short getIndicadorHidrometroLigacaoPoco(){

		return indicadorHidrometroLigacaoPoco;
	}

	public void setIndicadorHidrometroLigacaoPoco(Short indicadorHidrometroLigacaoPoco){

		this.indicadorHidrometroLigacaoPoco = indicadorHidrometroLigacaoPoco;
	}

	public Short getIndicadorLeituraFiscalizacaoCortado(){

		return indicadorLeituraFiscalizacaoCortado;
	}

	public void setIndicadorLeituraFiscalizacaoCortado(Short indicadorLeituraFiscalizacaoCortado){

		this.indicadorLeituraFiscalizacaoCortado = indicadorLeituraFiscalizacaoCortado;
	}

	public Short getIndicadorLeituraFiscalizacaoSuprimido(){

		return indicadorLeituraFiscalizacaoSuprimido;
	}

	public void setIndicadorLeituraFiscalizacaoSuprimido(Short indicadorLeituraFiscalizacaoSuprimido){

		this.indicadorLeituraFiscalizacaoSuprimido = indicadorLeituraFiscalizacaoSuprimido;
	}

	public String toString(){

		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	public String[] retornaCamposChavePrimaria(){

		String[] retorno = new String[1];
		retorno[0] = "id";
		return retorno;
	}

	public Short getIndicadorSituacaoLigacaoAguaFaturavel(){

		return indicadorSituacaoLigacaoAguaFaturavel;
	}

	public void setIndicadorSituacaoLigacaoAguaFaturavel(Short indicadorSituacaoLigacaoAguaFaturavel){

		this.indicadorSituacaoLigacaoAguaFaturavel = indicadorSituacaoLigacaoAguaFaturavel;
	}

	public Short getIndicadorSituacaoLigacaoEsgotoFaturavel(){

		return indicadorSituacaoLigacaoEsgotoFaturavel;
	}

	public void setIndicadorSituacaoLigacaoEsgotoFaturavel(Short indicadorSituacaoLigacaoEsgotoFaturavel){

		this.indicadorSituacaoLigacaoEsgotoFaturavel = indicadorSituacaoLigacaoEsgotoFaturavel;
	}

	public LeituraTipo getLeituraTipo(){

		return leituraTipo;
	}

	public void setLeituraTipo(LeituraTipo leituraTipo){

		this.leituraTipo = leituraTipo;
	}

	public Short getIndicadorDebitoACobrar(){

		return indicadorDebitoACobrar;
	}

	public void setIndicadorDebitoACobrar(Short indicadorDebitoACobrar){

		this.indicadorDebitoACobrar = indicadorDebitoACobrar;
	}

	public Short getIndicadorDebitoACobrarParcelamento(){

		return indicadorDebitoACobrarParcelamento;
	}

	public void setIndicadorDebitoACobrarParcelamento(Short indicadorDebitoACobrarParcelamento){

		this.indicadorDebitoACobrarParcelamento = indicadorDebitoACobrarParcelamento;
	}

}
