/*
 * Copyright (C) 2007-2007 the GSAN - Sistema Integrado de Gest�o de Servi�os de Saneamento
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
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA
 */

/*
 * GSAN - Sistema Integrado de Gest�o de Servi�os de Saneamento
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

package gcom.relatorio.operacional;

import gcom.cadastro.sistemaparametro.SistemaParametro;
import gcom.fachada.Fachada;
import gcom.operacional.FiltroSistemaAbastecimento;
import gcom.operacional.SistemaAbastecimento;
import gcom.relatorio.ConstantesRelatorios;
import gcom.relatorio.RelatorioDataSource;
import gcom.seguranca.acesso.usuario.Usuario;
import gcom.tarefa.TarefaException;
import gcom.tarefa.TarefaRelatorio;
import gcom.util.agendadortarefas.AgendadorTarefas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * [UCXXXX] Manter Sistema Abastecimento
 * 
 * @author Anderson Italo
 * @date 03/02/2011
 */
public class RelatorioManterSistemaAbastecimento
				extends TarefaRelatorio {

	private static final long serialVersionUID = 1L;

	public RelatorioManterSistemaAbastecimento(Usuario usuario) {

		super(usuario, ConstantesRelatorios.RELATORIO_SISTEMA_ABASTECIMENTO_MANTER);
	}

	@Deprecated
	public RelatorioManterSistemaAbastecimento() {

		super(null, "");
	}

	public Object executar() throws TarefaException{

		FiltroSistemaAbastecimento filtroSistemaAbastecimento = (FiltroSistemaAbastecimento) getParametro("filtroSistemaAbastecimento");
		SistemaAbastecimento sistemaAbastecimentoParametros = (SistemaAbastecimento) getParametro("sistemaAbastecimentoParametros");
		int tipoFormatoRelatorio = (Integer) getParametro("tipoFormatoRelatorio");

		// valor de retorno
		byte[] retorno = null;

		// cole��o de beans do relat�rio
		List relatorioBeans = new ArrayList();

		RelatorioManterSistemaAbastecimentoBean relatorioBean = null;

		Fachada fachada = Fachada.getInstancia();

		Collection colecaoSistemaAbastecimento = fachada.pesquisar(filtroSistemaAbastecimento, SistemaAbastecimento.class.getName());

		if(colecaoSistemaAbastecimento != null && !colecaoSistemaAbastecimento.isEmpty()){

			Iterator sistemaAbastecimentoIterator = colecaoSistemaAbastecimento.iterator();

			while(sistemaAbastecimentoIterator.hasNext()){

				SistemaAbastecimento sistemaAbastecimento = (SistemaAbastecimento) sistemaAbastecimentoIterator.next();

				String descricaoAbreviada = "";
				if(sistemaAbastecimento.getDescricaoAbreviada() != null && !sistemaAbastecimento.getDescricaoAbreviada().equals("")){
					descricaoAbreviada = sistemaAbastecimento.getDescricaoAbreviada();
				}

				relatorioBean = new RelatorioManterSistemaAbastecimentoBean(
				// C�digo
								sistemaAbastecimento.getCodigo().toString(),
								// Descri��o
								sistemaAbastecimento.getDescricao(),
								// Descri��o Abreviada
								descricaoAbreviada);

				relatorioBeans.add(relatorioBean);
			}
		}

		// Par�metros do relat�rio
		Map parametros = new HashMap();

		// adiciona os par�metros do relat�rio
		SistemaParametro sistemaParametro = fachada.pesquisarParametrosDoSistema();

		if(sistemaAbastecimentoParametros.getCodigo() != null && sistemaAbastecimentoParametros.getCodigo().intValue() > 0){

			parametros.put("codigo", sistemaAbastecimentoParametros.getCodigo().toString());
		}

		if(sistemaAbastecimentoParametros.getDescricao() != null && !sistemaAbastecimentoParametros.getDescricao().equals("")){

			parametros.put("descricao", sistemaAbastecimentoParametros.getDescricao());
		}

		if(sistemaAbastecimentoParametros.getDescricaoAbreviada() != null
						&& !sistemaAbastecimentoParametros.getDescricaoAbreviada().equals("")){

			parametros.put("descricaoAbreviada", sistemaAbastecimentoParametros.getDescricaoAbreviada());
		}

		if(sistemaAbastecimentoParametros.getIndicadorUso() > 0){

			if(sistemaAbastecimentoParametros.getIndicadorUso() == 1){
				parametros.put("indicadorUso", "Ativo");
			}else{
				parametros.put("indicadorUso", "Inativo");
			}
		}else{
			parametros.put("indicadorUso", "Todos");
		}

		parametros.put("imagem", sistemaParametro.getImagemRelatorio());

		if(tipoFormatoRelatorio == TIPO_PDF){
			parametros.put("tipoFormatoRelatorio", "PDF");
		}

		// cria uma inst�ncia do dataSource do relat�rio
		RelatorioDataSource ds = new RelatorioDataSource(relatorioBeans);

		retorno = this.gerarRelatorio(ConstantesRelatorios.RELATORIO_SISTEMA_ABASTECIMENTO_MANTER, parametros, ds, tipoFormatoRelatorio);

		// retorna o relat�rio gerado
		return retorno;
	}

	@Override
	public int calcularTotalRegistrosRelatorio(){

		return 0;
	}

	public void agendarTarefaBatch(){

		AgendadorTarefas.agendarTarefa("RelatorioManterSistemaAbastecimento", this);
	}

}