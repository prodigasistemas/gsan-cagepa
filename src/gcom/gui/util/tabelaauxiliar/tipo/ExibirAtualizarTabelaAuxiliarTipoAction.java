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

package gcom.gui.util.tabelaauxiliar.tipo;

import gcom.fachada.Fachada;
import gcom.gui.ActionServletException;
import gcom.gui.GcomAction;
import gcom.gui.ManutencaoRegistroActionForm;
import gcom.util.filtro.ParametroSimples;
import gcom.util.tabelaauxiliar.tipo.FiltroTabelaAuxiliarTipo;
import gcom.util.tabelaauxiliar.tipo.TabelaAuxiliarTipo;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * < <Descri��o da Classe>>
 * 
 * @author Administrador
 */
public class ExibirAtualizarTabelaAuxiliarTipoAction
				extends GcomAction {

	/**
	 * < <Descri��o do m�todo>>
	 * 
	 * @param actionMapping
	 *            Descri��o do par�metro
	 * @param actionForm
	 *            Descri��o do par�metro
	 * @param httpServletRequest
	 *            Descri��o do par�metro
	 * @param httpServletResponse
	 *            Descri��o do par�metro
	 * @return Descri��o do retorno
	 */
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		// Seta o mapeamento de retorno
		ActionForward retorno = actionMapping.findForward("atualizarTabelaAuxiliarTipo");

		// Obt�m a inst�ncia da sess�o
		HttpSession sessao = httpServletRequest.getSession(false);

		// Obt�m a inst�ncia da fachada
		Fachada fachada = Fachada.getInstancia();

		// Pega o actionform associado
		ManutencaoRegistroActionForm manutencaoRegistroActionForm = (ManutencaoRegistroActionForm) actionForm;

		// C�digo da tabela auxiliar a ser atualizada
		String id = manutencaoRegistroActionForm.getIdRegistroAtualizacao();

		// Cria o filtro para atividade
		FiltroTabelaAuxiliarTipo filtroTabelaAuxiliarTipo = new FiltroTabelaAuxiliarTipo();

		// String com path do pacote mais o nome do objeto
		String pacoteNomeObjeto = (String) sessao.getAttribute("pacoteNomeObjeto");

		// Declara��o de vari�veis e objetos
		// String tituloTipo = null;
		// String titulo = null;
		// Object objetoTipo = null;
		String pacoteNomeObjetoTipo = null;
		// String funcionalidadeTabelaAuxiliarTipoManter = null;
		int tamMaxCampoDescricao = 40;

		// Recebe valor do objeto envia pela sess�o
		TabelaAuxiliarTipo tabelaAuxiliarTipo = (TabelaAuxiliarTipo) sessao.getAttribute("tabelaAuxiliarTipo");

		// ********BLOCO DE C�DIGO PARA DEFINI��O DOS CADASTROS PERTENCENTES A
		// INSERIR TABELA AUXILIAR TIPO******//
		// Para serem incluidos novos cadastros com c�digo, descri��o e tipo
		// basta apenas cria um novo
		// if (condicional) semelhante ao exemplo abaixo, informando apenas os
		// dados relativos
		// ao objeto desejado.

		// ---BACIA
		// Identifica a string do objeto passado no get do request
		/*
		 * if (tabelaAuxiliarTipo instanceof Bacia) { //Cria o objeto pricipal
		 * Bacia bacia = new Bacia(); //Cria o objeto tipo TipoPavimentoRua
		 * tipoPavimentoRua = new TipoPavimentoRua(); //Pega o path do pacote
		 * mais o tipo do objeto pacoteNomeObjetoTipo =
		 * tipoPavimentoRua.getClass().getName(); //T�tulo da p�gina titulo =
		 * "Bacia"; tituloTipo = "Tipo Pavimento Rua"; //Associa o objeto tabela
		 * auxiliar ao tipo criado tabelaAuxiliarTipo = bacia; //Associa o
		 * objeto tipo ao tipo criado objetoTipo = tipoPavimentoRua; //Define o
		 * link a ser exibido na p�gina de sucesso
		 * funcionalidadeTabelaAuxiliarTipoManter =
		 * Funcionalidade.TABELA_AUXILIAR_TIPO_MANTER +
		 * Funcionalidade.TELA_BACIA; //Obt�m o tamanho da propriedade da classe
		 * de acordo com length do mapeamento tamMaxCampoDescricao =
		 * HibernateUtil.getColumnSize(Bacia.class,"descricao"); }
		 */
		// ********FIM DO BLOCO DE C�DIGO*******//
		// Pesquisa o objeto de acordo com o filtro passado
		Collection colecaoTipos = fachada.pesquisarTabelaAuxiliar(filtroTabelaAuxiliarTipo, pacoteNomeObjetoTipo);

		// Caso a cole��o esteja vazia, indica erro inesperado
		if(colecaoTipos == null || colecaoTipos.isEmpty()){
			throw new ActionServletException("erro.sistema");
		}
		// Manda a cole��o de tipos da tabela auxiliar na sess�o
		httpServletRequest.setAttribute("colecaoTipos", colecaoTipos);

		// Adiciona o par�metro no filtro
		filtroTabelaAuxiliarTipo.adicionarParametro(new ParametroSimples(FiltroTabelaAuxiliarTipo.ID, id));

		// Pesquisa a tabela auxiliar no sistema
		Collection tabelasAuxiliaresTipos = fachada.pesquisarTabelaAuxiliar(filtroTabelaAuxiliarTipo, pacoteNomeObjeto);

		// Caso a cole��o esteja vazia, indica erro inesperado
		if(tabelasAuxiliaresTipos == null || tabelasAuxiliaresTipos.isEmpty()){
			throw new ActionServletException("erro.sistema");
		}

		Iterator iteratorTabelaAuxiliarTipo = tabelasAuxiliaresTipos.iterator();

		// A tabela auxiliar tipo que ser� atualizada
		tabelaAuxiliarTipo = (TabelaAuxiliarTipo) iteratorTabelaAuxiliarTipo.next();

		// Manda os objetos na sess�o
		sessao.setAttribute("tabelaAuxiliarTipo", tabelaAuxiliarTipo);
		httpServletRequest.setAttribute("tipo", tabelaAuxiliarTipo.getIdTipo());
		httpServletRequest.setAttribute("tamMaxCampoDescricao", new Integer(tamMaxCampoDescricao));

		// Devolve o mapeamento de retorno
		return retorno;
	}

}