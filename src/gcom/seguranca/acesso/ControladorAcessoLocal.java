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

package gcom.seguranca.acesso;

import gcom.seguranca.acesso.usuario.Usuario;
import gcom.seguranca.acesso.usuario.UsuarioAbrangencia;
import gcom.seguranca.acesso.usuario.UsuarioSituacao;
import gcom.seguranca.transacao.Tabela;
import gcom.util.ControladorException;

import java.util.Collection;

/**
 * Declara��o p�blica de servi�os do Session Bean de ControladorCliente
 * 
 * @author S�vio Luiz
 * @created 25 de Abril de 2005
 */
public interface ControladorAcessoLocal
				extends javax.ejb.EJBLocalObject {

	/**
	 * M�todo que consulta todas as TabelaColunas que estejam ligadas a uma
	 * Operacao
	 * 
	 * @author Thiago Toscano
	 * @date 23/03/2006
	 * @return
	 * @throws ControladorException
	 */
	public Collection getTabelaColunaPertencenteOperacao() throws ControladorException;

	/**
	 * M�todo que pesquisa todas as tabelas colunas que tem ligacao com operacao
	 * pela operacao tabela
	 * 
	 * @author thiago toscano
	 * @date 23/03/2006
	 * @param idOperacao
	 * @return
	 * @throws ControladorException
	 */
	public Collection getTabelaColunaDasOperacaoTabela(Integer idOperacao) throws ControladorException;

	/**
	 * [UC0280] Inserir Funcionalidade
	 * Metodo que verifica os dados da tabela e inseri a funcionalidade
	 * 
	 * @author R�mulo Aur�lio
	 * @date 28/04/2006
	 * @param funcionalidade
	 * @throws ControladorException
	 */

	public Integer inserirFuncionalidade(Funcionalidade funcionalidade, Collection colecaoFuncionalidadeDependencia)
					throws ControladorException;

	/**
	 * [UC0281] Manter Funcionalidade [SB0001] Atualizar Funcionalidade Metodo
	 * que atualiza a funcionalidade
	 * 
	 * @author R�mulo Aur�lio
	 * @date 17/05/2006
	 * @param funcionalidade
	 * @throws ControladorException
	 */

	public void atualizarFuncionalidade(Funcionalidade funcionalidade, Collection colecaoFuncionalidadeDependencia)
					throws ControladorException;

	/**
	 * [UC0197] Filtrar Opera��es Efetuadas
	 * 
	 * @author Saulo Lima
	 * @date 18/05/2012
	 * @param
	 * @throws ControladorException
	 */
	public Collection<Funcionalidade> pesquisarFuncionalidadesComOperacaoAuditavel() throws ControladorException;

	/**
	 * M�todo que insere um grupo e suas funcionalidades com as operacoes
	 * [UC0278] Inserir Grupo
	 * 
	 * @author Thiago Toscano
	 * @date 08/05/2006
	 * @param grupo
	 * @param grupoFuncionalidadeOperacao
	 */
	public void inserirGrupo(Grupo grupo, Collection grupoFuncionalidadeOperacao) throws ControladorException;

	/**
	 * M�todo que atualiza um grupo e suas funcionalidades com as operacoes
	 * [UC0279] Atualiza Grupo
	 * 
	 * @author Thiago Toscano
	 * @date 08/05/2006
	 * @param grupo
	 * @param grupoFuncionalidadeOperacao
	 */
	public void atualizarGrupo(Grupo grupo, Collection grupoFuncionalidadeOperacao) throws ControladorException;

	/**
	 * Remove os grupos selecionados na tela de manter gruo e os relacionamentos existentes para
	 * o grupo(remove da tabela GrupoFuncionalidadeOperacao).
	 * [UC0279] - Manter Grupo
	 * 
	 * @author Pedro Alexandre
	 * @date 29/06/2006
	 * @param idsGrupos
	 * @throws ControladorException
	 */
	public void removerGrupo(String[] idsGrupos) throws ControladorException;

	/**
	 * [UC0278] Inserir Situacao Usuario
	 * Metodo que verifica os dados da tabela e inseri a Situa��o do Usu�rio
	 * 
	 * @author Thiago Ten�rio
	 * @date 09/05/2006
	 * @param Situa��o
	 *            Usuario
	 * @throws ControladorException
	 */

	public Integer inserirSituacaoUsuario(UsuarioSituacao usuarioSituacao) throws ControladorException;

	/**
	 * Inseri uma opera��o e seus relacionamentos com as tabelas se existir
	 * [UC0284]Inserir Opera��o
	 * 
	 * @author Pedro Alexandre
	 * @date 08/05/2006
	 * @param operacao
	 * @param colecaoOperacaoTabela
	 * @throws ControladorException
	 */
	public void inserirOperacao(Operacao operacao, Collection<Tabela> colecaoOperacaoTabela, Usuario usuarioLogado)
					throws ControladorException;

	/**
	 * [UC0297] Inserir Abrang�ncia Usuario
	 * Metodo que verifica os dados da tabela e inseri a Abrang�ncia
	 * 
	 * @author Thiago Ten�rio
	 * @date 09/05/2006
	 * @param inserirAbrangenciaUsuario
	 * @throws ControladorException
	 */

	public Integer inserirAbrangenciaUsuario(UsuarioAbrangencia usuarioAbrangencia) throws ControladorException;

	/**
	 * [UC0294] Situacao Usuario [] Atualizar Situacao do Usuario
	 * 
	 * @author Thiago Ten�rio
	 * @date 25/05/2006
	 * @param Situacao
	 *            Usuario
	 * @throws ControladorException
	 */

	public void atualizarSituacaoUsuario(UsuarioSituacao usuarioSituacao, Collection colecaoUsuarioSituacao) throws ControladorException;

	/**
	 * [UC0298] Abrang�ncia Usuario [] Atualizar Abrang�ncia do Usuario
	 * 
	 * @author Thiago Ten�rio
	 * @date 25/05/2006
	 * @param Abrang�ncia
	 *            Usuario
	 * @throws ControladorException
	 */

	public void atualizarAbrangenciaUsuario(UsuarioAbrangencia usuarioAbrangencia) throws ControladorException;

	/**
	 * Constroi um menu de acesso de acordo com as permiss�es que o usu�rio que est�
	 * logado no sistema conteme monta o link de retorno com o link informado.
	 * [UC0277] - Construir menu de acesso
	 * 
	 * @author Pedro Alexandre
	 * @date 10/07/2006
	 * @param usuarioLogado
	 * @param linkRetorno
	 * @return
	 * @throws ControladorException
	 */
	public String construirMenuAcesso(Usuario usuarioLogado, String linkRetorno) throws ControladorException;

	/**
	 * Met�do respons�vel por validar o login e senha do usu�rio,
	 * verificando se o usu�rio existe no sistema.
	 * [UC0287] - Efetuar Login
	 * 
	 * @author Pedro Alexandre
	 * @date 04/07/2006
	 * @param login
	 * @param senha
	 * @return
	 * @throws ControladorException
	 */
	public Usuario validarUsuario(String login, String senha) throws ControladorException;

	/**
	 * Met�do respons�vel por registrar o acesso do usu�rio incrementando o n� de acessos
	 * e atualizando a data do ultimo acesso do usu�rio.
	 * [UC0287] - Efetuar Login
	 * 
	 * @author Pedro Alexandre
	 * @date 04/07/2006
	 * @param usuario
	 * @throws ControladorException
	 */
	public void registrarAcessoUsuario(Usuario usuario) throws ControladorException;

	/**
	 * Met�do respons�vel por criar a arvore do menu com todas as permiss�es
	 * do usu�rio de acordo com os grupos que o usu�rio pertence.
	 * [UC0287] - Efetuar Login
	 * 
	 * @author Pedro Alexandre
	 * @date 04/07/2006
	 * @param permissoesUsuario
	 * @return
	 * @throws ControladorException
	 */
	public FuncionalidadeCategoria pesquisarArvoreFuncionalidades(Collection permissoesUsuario) throws ControladorException;

	/**
	 * Met�do respons�vel por atualizar as datas de expira��o do login do usu�rio
	 * assim como definir uma nova senha para o login
	 * [UC0289] Efetuar Altera��o da Senha
	 * 
	 * @author Pedro Alexandre
	 * @date 13/07/2006
	 * @param usuarioLogado
	 * @param dataNascimentoString
	 * @param cpf
	 * @param lembreteSenha
	 * @param novaSenha
	 * @param confirmacaoNovaSenha
	 * @throws ControladorException
	 */
	public void efetuarAlteracaoSenha(Usuario usuarioLogado, String dataNascimentoString, String cpf, String lembreteSenha,
					String novaSenha, String confirmacaoNovaSenha) throws ControladorException;

	/**
	 * [UC0287] - Efetuar Login
	 * Met�do respons�vel por enviar uma nova senha para o e-mail
	 * do usu�rio com situa��o pendente
	 * [SB0002] - Lembrar senha
	 * 
	 * @author Pedro Alexandre
	 * @date 14/07/2006
	 * @param login
	 * @param cpf
	 * @param dataNascimentoString
	 * @throws ControladorException
	 */
	public void lembrarSenha(String login, String cpf, String dataNascimentoString) throws ControladorException;

	/**
	 * Verifica se uma url solicitada para o servidor � uma funcionalidade ou uma opera��o
	 * 
	 * @author Pedro Alexandre
	 * @date 18/07/2006
	 * @param url
	 * @return
	 * @throws ControladorException
	 */
	public String verificarTipoURL(String url) throws ControladorException;

	/**
	 * Met�do que verifica se o usu�rio tem permiss�o para acessar a funcionalidade
	 * que est� sendo requisitada (existe ocorr�ncia na tabela GrupoFuncionalidadeOperacao).
	 * Verifica se o(s) grupo(s) que o usu�rio pertence tem acesso a funcionalidade e
	 * se todas as opera��es desta funcionalidade n�o est�o com restri��es(existe ocorr�ncia na
	 * tabela UsuarioGrupoRestricao)
	 * 
	 * @author Pedro Alexandre
	 * @date 18/07/2006
	 * @param usuarioLogado
	 * @param urlFuncionalidade
	 * @param colecaoGruposUsuario
	 * @return
	 * @throws ControladorException
	 */
	public boolean verificarAcessoPermitidoFuncionalidade(Usuario usuarioLogado, String urlFuncionalidade, Collection colecaoGruposUsuario)
					throws ControladorException;

	/**
	 * Met�do que verifica se o usu�rio tem permiss�o para acessar a opera��o
	 * que est� sendo requisitada (existe ocorr�ncia na tabela GrupoFuncionalidadeOperacao).
	 * Verifica se o(s) grupo(s) que o usu�rio pertence tem acesso a opera��o e
	 * se a opera��o desta funcionalidade n�o est�o com restri��o(existe ocorr�ncia na tabela
	 * UsuarioGrupoRestricao)
	 * 
	 * @author Pedro Alexandre
	 * @date 18/07/2006
	 * @param usuarioLogado
	 * @param urlOperacao
	 * @param colecaoGruposUsuario
	 * @return
	 * @throws ControladorException
	 */
	public boolean verificarAcessoPermitidoOperacao(Usuario usuarioLogado, String urlOperacao, Collection colecaoGruposUsuario)
					throws ControladorException;

	/**
	 * [UC0285] - Manter Opera��o
	 * Met�do respons�vel por atualizar uma opera��o no sistema e os relacionamentos entre
	 * a tabela e a opera��o
	 * [SB0001] - Atualizar Opera��o
	 * 
	 * @author Pedro Alexandre
	 * @date 02/08/2006
	 * @param operacao
	 * @param colecaoOperacaoTabela
	 * @throws ControladorException
	 */
	public void atualizarOperacao(Operacao operacao, Collection<OperacaoTabela> colecaoOperacaoTabela, Usuario usuarioLogado)
					throws ControladorException;

	/**
	 * [UC0285] - Manter Opera��o
	 * Met�do respons�vel por remover uma opera��o no sistema e os relacionamentos entre
	 * a tabela e a opera��o
	 * [SB0002] - Excluir Opera��o
	 * 
	 * @author Pedro Alexandre
	 * @date 02/08/2006
	 * @param idsOperacao
	 * @throws ControladorException
	 */
	public void removerOperacao(String[] idsOperacao, Usuario usuarioLogado) throws ControladorException;

	/**
	 * Met�do respons�vel por verificar se o usu�rio tem abrang�ncia sobre a opera��o
	 * e o n�vel de informa��o que est�o sendo informados.
	 * [UC0XXX] Verificar Acesso Abrang�ncia
	 * 
	 * @author Pedro Alexandre
	 * @date 13/11/2006
	 * @param abrangencia
	 * @return
	 * @throws ControladorException
	 */
	public boolean verificarAcessoAbrangencia(Abrangencia abrangencia) throws ControladorException;

	/**
	 * [UC3043] Registrar Log de Execu��o do Processo
	 * Registra uma mensagem no log do processo em execu��o
	 * 
	 * @author Hugo Lima
	 * @date 19/12/2011
	 * @param idFuncionalidadeIniciada
	 * @param mensagem
	 * @throws ControladorException
	 */
	public void registrarLogExecucaoProcesso(Integer idFuncionalidadeIniciada, String mensagem) throws ControladorException;

	/**
	 * Consulta os dados de acesso do usu�rio ao M�dulo gest�o de Leitura
	 * 
	 * @author Felipe Rosacruz
	 * @date 25/03/2014
	 * @param usuariologado
	 * @throws ControladorException
	 */
	public Object[] consultarDadosAcessoGcsME(Usuario usuariologado) throws ControladorException;
}