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
 */

package gcom.batch.cadastro;

import gcom.seguranca.acesso.usuario.Usuario;
import gcom.tarefa.TarefaBatch;
import gcom.tarefa.TarefaException;
import gcom.util.ConstantesJNDI;
import gcom.util.ConstantesSistema;
import gcom.util.agendadortarefas.AgendadorTarefas;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Tarefa que manda para batch Gerar Resumo Ligacoes Economias
 * 
 * @author Rodrigo Silveira
 * @created 17/01/2007
 */
public class TarefaBatchEncerrarFaturamentoGerarResumoLigacoesEconomias
				extends TarefaBatch {

	private static final long serialVersionUID = 1L;

	public TarefaBatchEncerrarFaturamentoGerarResumoLigacoesEconomias(Usuario usuario, int idFuncionalidadeIniciada) {

		super(usuario, idFuncionalidadeIniciada);
	}

	@Deprecated
	public TarefaBatchEncerrarFaturamentoGerarResumoLigacoesEconomias() {

		super(null, 0);
	}

	public Object executar() throws TarefaException{

		List<Integer> colecaoRotas = (List<Integer>) getParametro(ConstantesSistema.COLECAO_UNIDADES_PROCESSAMENTO_BATCH);
		Integer referenciaFaturamento = (Integer) getParametro("referenciaFaturamento");

		Iterator iterator = colecaoRotas.iterator();

		while(iterator.hasNext()){

			Integer idRota = (Integer) iterator.next();

			System.out.println("ROTA ENCERRAR FATURAMENTO GERAR RESUMO LIGACOES ECONOMIAS" + (idRota)
							+ "*********************************************************");

			enviarMensagemControladorBatch(ConstantesJNDI.BATCH_ENCERRAR_FATURAMENTO_GERAR_RESUMO_LIGACOES_ECONOMIAS_MDB,
							new Object[] {idRota, referenciaFaturamento, this.getIdFuncionalidadeIniciada()});

		}

		return null;
	}

	@Override
	public Collection pesquisarTodasUnidadeProcessamentoBatch(){

		return null;
	}

	@Override
	public Collection pesquisarTodasUnidadeProcessamentoReinicioBatch(){

		return null;
	}

	@Override
	public void agendarTarefaBatch(){

		AgendadorTarefas.agendarTarefa("EncerrarFaturamentoGerarResumoLigacoesEconomiasBatch", this);
	}

}
