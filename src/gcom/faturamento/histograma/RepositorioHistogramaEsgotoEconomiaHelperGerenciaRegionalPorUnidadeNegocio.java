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
 * Eduardo Henrique
 */
package gcom.faturamento.histograma;

import gcom.cadastro.localidade.GerenciaRegional;
import gcom.faturamento.bean.FiltrarEmitirHistogramaEsgotoEconomiaHelper;
import gcom.faturamento.bean.HistogramaEsgotoEconomiaDTO;

import org.hibernate.Hibernate;

/**
 * @author mgrb
 *
 */
public class RepositorioHistogramaEsgotoEconomiaHelperGerenciaRegionalPorUnidadeNegocio
				extends AbstractRepositorioHistogramaEsgotoEconomiaHelper {

	/**
	 * RepositorioHistogramaEsgotoEconomiaHelperEstadoPorUnidadeNegocio
	 * <p>
	 * Esse m�todo Constroi uma inst�ncia de
	 * RepositorioHistogramaEsgotoEconomiaHelperEstadoPorUnidadeNegocio.
	 * </p>
	 * 
	 * @author Marlos Ribeiro
	 * @since 11/06/2013
	 */
	public RepositorioHistogramaEsgotoEconomiaHelperGerenciaRegionalPorUnidadeNegocio() {

		super();
		// COLUNAS ADCIONAIS
		adcionarColunaAdcional("gr.GREG_ID", "GREG_ID", Hibernate.LONG);
		adcionarColunaAdcional("gr.GREG_NMREGIONAL", "GREG_NMREGIONAL", Hibernate.STRING);
		adcionarColunaAdcional("gr.GREG_NMABREVIADO", "GREG_NMABREVIADO", Hibernate.STRING);
		adcionarColunaAdcional("un.UNEG_ID", "UNEG_ID", Hibernate.LONG);
		adcionarColunaAdcional("un.UNEG_NMUNIDADENEGOCIO", "UNEG_NMUNIDADENEGOCIO", Hibernate.STRING);
		adcionarColunaAdcional("un.UNEG_NMABREVIADO", "UNEG_NMABREVIADO", Hibernate.STRING);

		// RELACIONAMENTO
		adcionarRelacionamento("GERENCIA_REGIONAL", "gr", "GREG_ID", FK_HEE_GREG_ID);
		adcionarRelacionamento("UNIDADE_NEGOCIO", "un", "UNEG_ID", FK_HEE_UNEG_ID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected HistogramaEsgotoEconomiaDTO preencherHistogramaHelper(Object[] objects){

		HistogramaEsgotoEconomiaDTO histogramaDTO = new HistogramaEsgotoEconomiaDTO();
		histogramaDTO.setTotalizadorDescricao("TOTALIZADOR");
		StringBuffer opcaoTotalizacao = new StringBuffer();
		// GERENCIA REGIONAL
		opcaoTotalizacao.append(objects[0]).append(DIVISOR_TOTALIZADOR_ID_DESC).append(String.valueOf(objects[1]).trim());
		opcaoTotalizacao.append(DIVISOR_TOTALIZADOR_ITEM);
		// UNIDADE NEGOCIO
		opcaoTotalizacao.append(objects[3]).append(DIVISOR_TOTALIZADOR_ID_DESC).append(String.valueOf(objects[4]).trim());
		histogramaDTO.setDescricaoOpcaoTotalizacao(opcaoTotalizacao.toString());

		return histogramaDTO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected FiltrarEmitirHistogramaEsgotoEconomiaHelper criarFiltroQuebra(FiltrarEmitirHistogramaEsgotoEconomiaHelper filtro,
					Integer[] itemQuebra){

		FiltrarEmitirHistogramaEsgotoEconomiaHelper filtroQuebra = new FiltrarEmitirHistogramaEsgotoEconomiaHelper(filtro);
		filtroQuebra.setOpcaoTotalizacao(OpcaoTotalizacaoEnum.GERENCIA_REGIONAL.getOpcao());
		for(int i = 0; i < itemQuebra.length; i++){
			switch(i){
				case 0:
					GerenciaRegional gr = new GerenciaRegional();
					gr.setId(itemQuebra[i]);
					filtroQuebra.setGerenciaRegional(gr);
					break;
			}
		}
		return filtroQuebra;
	}

}
