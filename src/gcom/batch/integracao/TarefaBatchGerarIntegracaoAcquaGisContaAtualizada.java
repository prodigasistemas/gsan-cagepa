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

package gcom.batch.integracao;

import gcom.seguranca.acesso.usuario.Usuario;
import gcom.tarefa.TarefaBatch;
import gcom.tarefa.TarefaException;
import gcom.util.ConstantesJNDI;
import gcom.util.agendadortarefas.AgendadorTarefas;

import java.util.Collection;
import java.util.Collections;

import org.apache.log4j.Logger;

/**
 * Tarefa que manda para batch Gerar Integra��o Dados Conta Atualizada.
 * 
 * @author Josenildo Neves
 * @created 28/06/2013
 */
public class TarefaBatchGerarIntegracaoAcquaGisContaAtualizada
				extends TarefaBatch {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(TarefaBatchGerarIntegracaoAcquaGisContaAtualizada.class);

	public static final String PARAM_IDS_LOCALIDADE = "IDS_LOCALIDADES";

	public TarefaBatchGerarIntegracaoAcquaGisContaAtualizada(Usuario usuario, int idFuncionalidadeIniciada) {

		super(usuario, idFuncionalidadeIniciada);
	}

	@Deprecated
	public TarefaBatchGerarIntegracaoAcquaGisContaAtualizada() {

		super(null, 0);
	}

	public Object executar() throws TarefaException{

		Collection<Integer> idsLocalidades = Collections.checkedCollection((Collection) getParametro(PARAM_IDS_LOCALIDADE), Integer.class);

		LOGGER.info("Disparando Gera��o de Inegra��o AcquaGis Conta Atualizada para [" + idsLocalidades.size() + "] Localidades.");
		for(Integer idLocalidade : idsLocalidades){
			enviarMensagemControladorBatch(ConstantesJNDI.BATCH_GERAR_INTEGRACAO_ACQUAGIS_CONTA_ATUALIZADA_MDB,
							new Object[] {this.getIdFuncionalidadeIniciada(), idLocalidade});
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

		AgendadorTarefas.agendarTarefa("GerarIntegracaoAquaGisontaAtualizadaBatch", this);
	}

}
