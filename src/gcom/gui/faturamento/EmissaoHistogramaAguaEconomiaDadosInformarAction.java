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

package gcom.gui.faturamento;

import gcom.atendimentopublico.ligacaoagua.FiltroLigacaoAguaSituacao;
import gcom.atendimentopublico.ligacaoagua.LigacaoAguaSituacao;
import gcom.cadastro.cliente.EsferaPoder;
import gcom.cadastro.cliente.FiltroEsferaPoder;
import gcom.cadastro.imovel.Categoria;
import gcom.cadastro.imovel.CategoriaTipo;
import gcom.cadastro.imovel.FiltroCategoria;
import gcom.cadastro.imovel.FiltroCategoriaTipo;
import gcom.cadastro.imovel.FiltroImovelPerfil;
import gcom.cadastro.imovel.ImovelPerfil;
import gcom.cadastro.localidade.FiltroGerenciaRegional;
import gcom.cadastro.localidade.FiltroLocalidade;
import gcom.cadastro.localidade.FiltroQuadra;
import gcom.cadastro.localidade.FiltroSetorComercial;
import gcom.cadastro.localidade.FiltroUnidadeNegocio;
import gcom.cadastro.localidade.GerenciaRegional;
import gcom.cadastro.localidade.Localidade;
import gcom.cadastro.localidade.Quadra;
import gcom.cadastro.localidade.SetorComercial;
import gcom.cadastro.localidade.UnidadeNegocio;
import gcom.faturamento.ConsumoFaixaCategoria;
import gcom.faturamento.FiltroConsumoFaixaCategoria;
import gcom.faturamento.consumotarifa.ConsumoTarifa;
import gcom.faturamento.consumotarifa.FiltroConsumoTarifa;
import gcom.gui.ActionServletException;
import gcom.gui.GcomAction;
import gcom.util.ConstantesSistema;
import gcom.util.Util;
import gcom.util.filtro.ConectorOr;
import gcom.util.filtro.ParametroSimples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * [UC00605] Informar Dados para Emiss�o do Histograma de �gua Por Economia
 * 
 * @author Rafael Pinto
 * @date 14/06/2007
 */
public class EmissaoHistogramaAguaEconomiaDadosInformarAction
				extends GcomAction {

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		// Seta o mapeamento de retorno
		ActionForward retorno = actionMapping.findForward("emissaoHistogramaAguaEconomiaDadosInformar");

		// Form
		EmissaoHistogramaAguaEconomiaDadosInformarActionForm form = (EmissaoHistogramaAguaEconomiaDadosInformarActionForm) actionForm;

		String acao = httpServletRequest.getParameter("acao");

		if(acao != null && !acao.equals("")){

			String tipoConsumoCategoria = form.getTipoConsumoCategoria();

			// Inserir Faixa - Mostrar Popup
			if("I".equals(acao)){

				if(tipoConsumoCategoria.equals(Categoria.RESIDENCIAL.toString())){
					form.setSubTituloFaixaConsumo("Residencial");
				}else if(tipoConsumoCategoria.equals(Categoria.COMERCIAL.toString())){
					form.setSubTituloFaixaConsumo("Comercial");
				}else if(tipoConsumoCategoria.equals(Categoria.INDUSTRIAL.toString())){
					form.setSubTituloFaixaConsumo("Industrial");
				}else if(tipoConsumoCategoria.equals(Categoria.PUBLICO.toString())){
					form.setSubTituloFaixaConsumo("Publico");
				}else{
					form.setSubTituloFaixaConsumo("Outros");
				}

				form.setLimiteInferiorFaixa(null);
				form.setLimiteSuperiorFaixa(null);

				retorno = actionMapping.findForward("emissaoHistogramaAguaEconomiaDadosInformarFaixa");

				// Remover Faixa
			}else if("R".equals(acao)){

				String idRemover = httpServletRequest.getParameter("idRemover");
				this.removeConsumoFaixaCategoria(form, Integer.parseInt(idRemover));

				// Inserir Faixa - Insere na colecao
			}else if("A".equals(acao)){
				this.validarInclusaoConsumoFaixaCategoria(form);
			}

		}else{

			// Flag indicando que o usu�rio fez uma consulta a partir da tecla Enter
			String objetoConsulta = httpServletRequest.getParameter("objetoConsulta");

			// [UC0018] - Pesquisar Elo
			if(objetoConsulta != null && !objetoConsulta.trim().equals("") && objetoConsulta.trim().equals("1")){

				// Faz a consulta do Elo P�lo
				this.pesquisarEloPolo(form);
			}

			// [UC0023] - Pesquisar Localidade
			if(objetoConsulta != null && !objetoConsulta.trim().equals("") && objetoConsulta.trim().equals("2")){

				// Faz a consulta de Localidade
				this.pesquisarLocalidade(form);
			}

			// [UC0142] - Pesquisar Setor Comercial
			if(objetoConsulta != null && !objetoConsulta.trim().equals("") && objetoConsulta.trim().equals("3")){

				// Faz a consulta de Setor Comercial
				this.pesquisarSetorComercial(form);
			}

			// [UC0143] - Pesquisar Quadra
			if(objetoConsulta != null && !objetoConsulta.trim().equals("") && objetoConsulta.trim().equals("4")){

				// Faz a consulta de Quadra
				this.pesquisarQuadra(httpServletRequest, form);
			}
		}

		// Monta os select�s do jsp
		this.pesquisarGerenciaRegional(httpServletRequest);
		this.pesquisarUnidadeNegocio(httpServletRequest, form);
		this.pesquisarCategoriaTipo(httpServletRequest);
		this.pesquisarCategoria(httpServletRequest, form);
		this.pesquisarConsumoTarifa(httpServletRequest);
		this.pesquisarPerfilImovel(httpServletRequest);
		this.pesquisarEsferaPoder(httpServletRequest);
		this.pesquisarLigacaoAguaSituacao(httpServletRequest);

		if(acao == null || acao.equals("")){
			this.pesquisarConsumoFaixaCategoria(form, httpServletRequest);
		}else if("M".equals(acao)){
			Collection<ConsumoFaixaCategoria> colecaoFaixa = (Collection<ConsumoFaixaCategoria>) form
							.getLinkedHashMapConsumoFaixaCategoria().get(form.getTipoConsumoCategoria());
			// verifica se a categoria escolhida est� sem
			form.setColecaoConsumoFaixaCategoria(colecaoFaixa);
			form.setTamanhoColecao(Integer.toString(0));
			if(colecaoFaixa == null || colecaoFaixa.isEmpty()){
				throw new ActionServletException("atencao.faixa_consumo_inexistente_para_categoria");
			}
			form.setTamanhoColecao(Integer.toString(colecaoFaixa.size()));
		}

		// Seta os request�s encontrados
		this.setaRequest(httpServletRequest, form);

		return retorno;
	}

	/**
	 * Pesquisa Elo P�lo
	 * 
	 * @author Rafael Pinto
	 * @date 14/06/2007
	 */
	private void pesquisarEloPolo(EmissaoHistogramaAguaEconomiaDadosInformarActionForm form){

		FiltroLocalidade filtroLocalidade = new FiltroLocalidade();
		filtroLocalidade.adicionarParametro(new ParametroSimples(FiltroLocalidade.ID_ELO, form.getEloPolo()));

		filtroLocalidade.adicionarCaminhoParaCarregamentoEntidade("localidade");

		// Recupera Elo P�lo
		Collection colecaoEloPolo = this.getFachada().pesquisar(filtroLocalidade, Localidade.class.getName());

		if(colecaoEloPolo != null && !colecaoEloPolo.isEmpty()){

			Localidade localidade = (Localidade) Util.retonarObjetoDeColecao(colecaoEloPolo);

			localidade = localidade.getLocalidade();

			form.setEloPolo(localidade.getId().toString());
			form.setNomeEloPolo(localidade.getDescricao());

		}else{
			form.setEloPolo(null);
			form.setNomeEloPolo("Localidade inexistente");
		}
	}

	/**
	 * Pesquisa Localidade
	 * 
	 * @author Rafael Pinto
	 * @date 14/06/2007
	 */
	private void pesquisarLocalidade(EmissaoHistogramaAguaEconomiaDadosInformarActionForm form){

		FiltroLocalidade filtroLocalidade = new FiltroLocalidade();
		filtroLocalidade.adicionarParametro(new ParametroSimples(FiltroLocalidade.ID, form.getLocalidade()));

		// Recupera Localidade
		Collection colecaoLocalidade = this.getFachada().pesquisar(filtroLocalidade, Localidade.class.getName());

		if(colecaoLocalidade != null && !colecaoLocalidade.isEmpty()){

			Localidade localidade = (Localidade) Util.retonarObjetoDeColecao(colecaoLocalidade);

			form.setLocalidade(localidade.getId().toString());
			form.setNomeLocalidade(localidade.getDescricao());

		}else{
			form.setLocalidade(null);
			form.setNomeLocalidade("Localidade inexistente");
		}
	}

	/**
	 * Pesquisa Setor comercial
	 * 
	 * @author Rafael Pinto
	 * @date 16/06/2007
	 */
	private void pesquisarSetorComercial(EmissaoHistogramaAguaEconomiaDadosInformarActionForm form){

		FiltroSetorComercial filtroSetorComercial = new FiltroSetorComercial();
		filtroSetorComercial
						.adicionarParametro(new ParametroSimples(FiltroSetorComercial.CODIGO_SETOR_COMERCIAL, form.getSetorComercial()));

		filtroSetorComercial.adicionarParametro(new ParametroSimples(FiltroSetorComercial.LOCALIDADE, form.getLocalidade()));

		// Recupera Setor Comercial
		Collection colecaoSetorComercial = this.getFachada().pesquisar(filtroSetorComercial, SetorComercial.class.getName());

		if(colecaoSetorComercial != null && !colecaoSetorComercial.isEmpty()){

			SetorComercial setorComercial = (SetorComercial) Util.retonarObjetoDeColecao(colecaoSetorComercial);

			form.setSetorComercial(Integer.toString(setorComercial.getCodigo()));
			form.setNomeSetorComercial(setorComercial.getDescricao());

		}else{
			form.setSetorComercial(null);
			form.setNomeSetorComercial("Setor Comercial inexistente");
		}
	}

	/**
	 * Pesquisa Quadra
	 * 
	 * @author Rafael Pinto
	 * @date 14/06/2007
	 */
	private void pesquisarQuadra(HttpServletRequest httpServletRequest, EmissaoHistogramaAguaEconomiaDadosInformarActionForm form){

		FiltroQuadra filtroQuadra = new FiltroQuadra();
		filtroQuadra.adicionarParametro(new ParametroSimples(FiltroQuadra.NUMERO_QUADRA, form.getQuadra()));

		filtroQuadra.adicionarParametro(new ParametroSimples(FiltroQuadra.CODIGO_SETORCOMERCIAL, form.getSetorComercial()));

		// Recupera Quadra
		Collection colecaoQuadra = this.getFachada().pesquisar(filtroQuadra, Quadra.class.getName());

		if(colecaoQuadra != null && !colecaoQuadra.isEmpty()){

			Quadra quadra = (Quadra) Util.retonarObjetoDeColecao(colecaoQuadra);

			form.setQuadra(Integer.toString(quadra.getNumeroQuadra()));
			// form.setNomeQuadra(quadra.getDescricao());

		}else{
			form.setQuadra(null);
			httpServletRequest.setAttribute("msgQuadra", "QUADRA INEXISTENTE");

		}
	}

	/**
	 * Seta os request com os id encontrados
	 * 
	 * @author Rafael Pinto
	 * @date 14/06/2007
	 */
	private void setaRequest(HttpServletRequest httpServletRequest, EmissaoHistogramaAguaEconomiaDadosInformarActionForm form){

		// Elo Polo
		if(form.getEloPolo() != null && !form.getEloPolo().equals("") && form.getNomeEloPolo() != null && !form.getNomeEloPolo().equals("")){

			httpServletRequest.setAttribute("eloPoloEncontrado", "true");
		}

		// Localidade
		if(form.getLocalidade() != null && !form.getLocalidade().equals("") && form.getNomeLocalidade() != null
						&& !form.getNomeLocalidade().equals("")){

			httpServletRequest.setAttribute("localidadeEncontrada", "true");
		}

		// Setor Comercial
		if(form.getSetorComercial() != null && !form.getSetorComercial().equals("") && form.getNomeSetorComercial() != null
						&& !form.getNomeSetorComercial().equals("")){

			httpServletRequest.setAttribute("setorComercialEncontrado", "true");
		}

		// Quadra
		if(form.getNomeQuadra() != null && !form.getNomeQuadra().equals("")){
			httpServletRequest.setAttribute("quadraNaoEncontrada", "true");
		}
	}

	/**
	 * Pesquisa Gerencial Regional
	 * 
	 * @author Rafael Pinto
	 * @date 14/06/2007
	 */
	private void pesquisarGerenciaRegional(HttpServletRequest httpServletRequest){

		FiltroGerenciaRegional filtroGerenciaRegional = new FiltroGerenciaRegional();

		filtroGerenciaRegional.setConsultaSemLimites(true);
		filtroGerenciaRegional.setCampoOrderBy(FiltroGerenciaRegional.NOME);
		filtroGerenciaRegional.adicionarParametro(new ParametroSimples(FiltroQuadra.INDICADORUSO, ConstantesSistema.INDICADOR_USO_ATIVO));

		Collection colecaoGerenciaRegional = this.getFachada().pesquisar(filtroGerenciaRegional, GerenciaRegional.class.getName());

		if(colecaoGerenciaRegional == null || colecaoGerenciaRegional.isEmpty()){
			throw new ActionServletException("atencao.naocadastrado", null, "Ger�ncia Regional");
		}else{
			httpServletRequest.setAttribute("colecaoGerenciaRegional", colecaoGerenciaRegional);
		}
	}

	/**
	 * Pesquisa Unidade Negocio
	 * 
	 * @author Rafael Pinto
	 * @date 14/06/2007
	 */
	private void pesquisarUnidadeNegocio(HttpServletRequest httpServletRequest, EmissaoHistogramaAguaEconomiaDadosInformarActionForm form){

		FiltroUnidadeNegocio filtroUnidadeNegocio = new FiltroUnidadeNegocio();

		filtroUnidadeNegocio.setConsultaSemLimites(true);
		filtroUnidadeNegocio.setCampoOrderBy(FiltroUnidadeNegocio.NOME);

		if(form.getGerenciaRegional() != null
						&& !form.getGerenciaRegional().equals(Integer.toString(ConstantesSistema.NUMERO_NAO_INFORMADO))){

			filtroUnidadeNegocio.adicionarParametro(new ParametroSimples(FiltroUnidadeNegocio.ID_GERENCIA, form.getGerenciaRegional()));
		}

		filtroUnidadeNegocio.adicionarParametro(new ParametroSimples(FiltroUnidadeNegocio.INDICADOR_USO,
						ConstantesSistema.INDICADOR_USO_ATIVO));

		Collection colecaoUnidadeNegocio = this.getFachada().pesquisar(filtroUnidadeNegocio, UnidadeNegocio.class.getName());

		if(colecaoUnidadeNegocio == null || colecaoUnidadeNegocio.isEmpty()){
			throw new ActionServletException("atencao.naocadastrado", null, "Unidade de Neg�cio");
		}else{
			httpServletRequest.setAttribute("colecaoUnidadeNegocio", colecaoUnidadeNegocio);
		}
	}

	/**
	 * Pesquisa Categoria Tipo
	 * 
	 * @author Rafael Pinto
	 * @date 14/06/2007
	 */
	private void pesquisarCategoriaTipo(HttpServletRequest httpServletRequest){

		FiltroCategoriaTipo filtroCategoriaTipo = new FiltroCategoriaTipo();

		filtroCategoriaTipo.setConsultaSemLimites(true);
		filtroCategoriaTipo.setCampoOrderBy(FiltroCategoriaTipo.DESCRICAO);

		Collection colecaoTipoCategoria = this.getFachada().pesquisar(filtroCategoriaTipo, CategoriaTipo.class.getName());

		if(colecaoTipoCategoria == null || colecaoTipoCategoria.isEmpty()){
			throw new ActionServletException("atencao.naocadastrado", null, "Categoria Tipo");
		}else{
			httpServletRequest.setAttribute("colecaoTipoCategoria", colecaoTipoCategoria);
		}
	}

	/**
	 * Pesquisa Categoria
	 * 
	 * @author Rafael Pinto
	 * @date 14/06/2007
	 */
	private void pesquisarCategoria(HttpServletRequest httpServletRequest, EmissaoHistogramaAguaEconomiaDadosInformarActionForm form){

		FiltroCategoria filtroCategoria = new FiltroCategoria();

		filtroCategoria.setConsultaSemLimites(true);
		filtroCategoria.setCampoOrderBy(FiltroCategoria.DESCRICAO);
		filtroCategoria.adicionarParametro(new ParametroSimples(FiltroCategoria.INDICADOR_USO, ConstantesSistema.INDICADOR_USO_ATIVO));

		if(form.getTipoCategoria() != null && !form.getTipoCategoria().equals(Integer.toString(ConstantesSistema.NUMERO_NAO_INFORMADO))){

			filtroCategoria.adicionarParametro(new ParametroSimples(FiltroCategoria.TIPO_CATEGORIA, form.getTipoCategoria()));
		}

		Collection colecaoCategoria = this.getFachada().pesquisar(filtroCategoria, Categoria.class.getName());

		if(colecaoCategoria == null || colecaoCategoria.isEmpty()){
			throw new ActionServletException("atencao.naocadastrado", null, "Categoria");
		}else{
			httpServletRequest.setAttribute("colecaoCategoria", colecaoCategoria);
		}
	}

	/**
	 * Pesquisa Consumo Tarifa
	 * 
	 * @author Rafael Pinto
	 * @date 14/06/2007
	 */
	private void pesquisarConsumoTarifa(HttpServletRequest httpServletRequest){

		FiltroConsumoTarifa filtroConsumoTarifa = new FiltroConsumoTarifa();

		filtroConsumoTarifa.setConsultaSemLimites(true);
		filtroConsumoTarifa.setCampoOrderBy(FiltroConsumoTarifa.DESCRICAO);
		filtroConsumoTarifa.adicionarParametro(new ParametroSimples(FiltroConsumoTarifa.INDICADOR_USO,
						ConstantesSistema.INDICADOR_USO_ATIVO));

		Collection colecaoTarifa = this.getFachada().pesquisar(filtroConsumoTarifa, ConsumoTarifa.class.getName());

		if(colecaoTarifa == null || colecaoTarifa.isEmpty()){
			throw new ActionServletException("atencao.naocadastrado", null, "Tarifa");
		}else{
			httpServletRequest.setAttribute("colecaoTarifa", colecaoTarifa);
		}
	}

	/**
	 * Pesquisa Perfil Imovel
	 * 
	 * @author Rafael Pinto
	 * @date 14/06/2007
	 */
	private void pesquisarPerfilImovel(HttpServletRequest httpServletRequest){

		FiltroImovelPerfil filtroImovelPerfil = new FiltroImovelPerfil();

		filtroImovelPerfil.setConsultaSemLimites(true);
		filtroImovelPerfil.setCampoOrderBy(FiltroImovelPerfil.DESCRICAO);
		filtroImovelPerfil
						.adicionarParametro(new ParametroSimples(FiltroImovelPerfil.INDICADOR_USO, ConstantesSistema.INDICADOR_USO_ATIVO));

		Collection colecaoPerfilImovel = this.getFachada().pesquisar(filtroImovelPerfil, ImovelPerfil.class.getName());

		if(colecaoPerfilImovel == null || colecaoPerfilImovel.isEmpty()){
			throw new ActionServletException("atencao.naocadastrado", null, "Perfil do Im�vel");
		}else{
			httpServletRequest.setAttribute("colecaoPerfilImovel", colecaoPerfilImovel);
		}
	}

	/**
	 * Pesquisa Esfera Poder
	 * 
	 * @author Rafael Pinto
	 * @date 14/06/2007
	 */
	private void pesquisarEsferaPoder(HttpServletRequest httpServletRequest){

		FiltroEsferaPoder filtroEsferaPoder = new FiltroEsferaPoder();

		filtroEsferaPoder.setConsultaSemLimites(true);
		filtroEsferaPoder.setCampoOrderBy(FiltroEsferaPoder.DESCRICAO);
		filtroEsferaPoder.adicionarParametro(new ParametroSimples(FiltroEsferaPoder.INDICADOR_USO, ConstantesSistema.INDICADOR_USO_ATIVO));

		Collection colecaoEsferaPoder = this.getFachada().pesquisar(filtroEsferaPoder, EsferaPoder.class.getName());

		if(colecaoEsferaPoder == null || colecaoEsferaPoder.isEmpty()){
			throw new ActionServletException("atencao.naocadastrado", null, "Esfera Poder");
		}else{
			httpServletRequest.setAttribute("colecaoEsferaPoder", colecaoEsferaPoder);
		}
	}

	/**
	 * Pesquisa Situacao Ligacao Agua
	 * 
	 * @author Rafael Pinto
	 * @date 14/06/2007
	 */
	private void pesquisarLigacaoAguaSituacao(HttpServletRequest httpServletRequest){

		FiltroLigacaoAguaSituacao filtroLigacaoAguaSituacao = new FiltroLigacaoAguaSituacao();

		filtroLigacaoAguaSituacao.setConsultaSemLimites(true);
		filtroLigacaoAguaSituacao.setCampoOrderBy(FiltroLigacaoAguaSituacao.DESCRICAO);
		filtroLigacaoAguaSituacao.adicionarParametro(new ParametroSimples(FiltroLigacaoAguaSituacao.INDICADOR_USO,
						ConstantesSistema.INDICADOR_USO_ATIVO));

		Collection colecaoSituacaoLigacaoAgua = this.getFachada().pesquisar(filtroLigacaoAguaSituacao, LigacaoAguaSituacao.class.getName());

		if(colecaoSituacaoLigacaoAgua == null || colecaoSituacaoLigacaoAgua.isEmpty()){
			throw new ActionServletException("atencao.naocadastrado", null, "Esfera Poder");
		}else{
			httpServletRequest.setAttribute("colecaoSituacaoLigacaoAgua", colecaoSituacaoLigacaoAgua);
		}
	}

	/**
	 * Pesquisa Consumo Faixa Por Categoria
	 * 
	 * @author Rafael Pinto
	 * @date 15/06/2007
	 */
	private void pesquisarConsumoFaixaCategoria(EmissaoHistogramaAguaEconomiaDadosInformarActionForm form,
					HttpServletRequest httpServletRequest){

		Collection colecaoCategoria = (Collection) httpServletRequest.getAttribute("colecaoCategoria");

		LinkedHashMap<String, Collection<ConsumoFaixaCategoria>> linkedHashMapConsumoFaixaCategoria = new LinkedHashMap<String, Collection<ConsumoFaixaCategoria>>();

		FiltroConsumoFaixaCategoria filtro = new FiltroConsumoFaixaCategoria();

		filtro.setConsultaSemLimites(true);
		filtro.setCampoOrderBy(FiltroConsumoFaixaCategoria.NUMERO_FAIXA_INICIO);

		if(colecaoCategoria != null && !colecaoCategoria.isEmpty()){

			if(colecaoCategoria.size() == 1){

				Categoria categoria = (Categoria) Util.retonarObjetoDeColecao(colecaoCategoria);

				filtro.adicionarParametro(new ParametroSimples(FiltroConsumoFaixaCategoria.ID_CATEGORIA, categoria.getId()));

			}else{

				Iterator itera = colecaoCategoria.iterator();

				while(itera.hasNext()){
					Categoria cat = (Categoria) itera.next();

					filtro.adicionarParametro(new ParametroSimples(FiltroConsumoFaixaCategoria.ID_CATEGORIA, cat.getId(),
									ConectorOr.CONECTOR_OR, colecaoCategoria.size()));

				}
			}
		}

		if(form.getTipoCategoria() != null && !form.getTipoCategoria().equals(Integer.toString(ConstantesSistema.NUMERO_NAO_INFORMADO))){

			filtro.adicionarParametro(new ParametroSimples(FiltroConsumoFaixaCategoria.ID_CATEGORIA_TIPO, form.getTipoCategoria()));
		}

		filtro.adicionarCaminhoParaCarregamentoEntidade("categoria");

		Collection colecaoConsumoFaixaCategoria = this.getFachada().pesquisar(filtro, ConsumoFaixaCategoria.class.getName());

		if(colecaoConsumoFaixaCategoria != null && !colecaoConsumoFaixaCategoria.isEmpty()){

			Collection<ConsumoFaixaCategoria> colecaoFaixa = null;
			Iterator itera = colecaoConsumoFaixaCategoria.iterator();

			while(itera.hasNext()){

				ConsumoFaixaCategoria consumoFaixaCategoria = (ConsumoFaixaCategoria) itera.next();

				Categoria categoria = consumoFaixaCategoria.getCategoria();

				if(linkedHashMapConsumoFaixaCategoria.get(categoria.getId().toString()) != null){
					colecaoFaixa = linkedHashMapConsumoFaixaCategoria.get("" + categoria.getId());
					colecaoFaixa.add(consumoFaixaCategoria);

					linkedHashMapConsumoFaixaCategoria.put(categoria.getId().toString(), colecaoFaixa);
				}else{
					colecaoFaixa = new ArrayList<ConsumoFaixaCategoria>();
					colecaoFaixa.add(consumoFaixaCategoria);

					linkedHashMapConsumoFaixaCategoria.put(categoria.getId().toString(), colecaoFaixa);
				}

			}
			if(form.getTipoConsumoCategoria() != null && !form.getTipoConsumoCategoria().equals("")){
				colecaoFaixa = linkedHashMapConsumoFaixaCategoria.get(form.getTipoConsumoCategoria());
			}
			if(colecaoFaixa == null || colecaoFaixa.isEmpty()){

				Categoria categoria = (Categoria) colecaoCategoria.iterator().next();
				colecaoFaixa = linkedHashMapConsumoFaixaCategoria.get(categoria.getId().toString());

				form.setTipoConsumoCategoria(categoria.getId().toString());

			}else if(form.getTipoConsumoCategoria() == null){

				String idCategoria = (String) linkedHashMapConsumoFaixaCategoria.keySet().iterator().next();
				String tipoConsumoCategoria = idCategoria;
				form.setTipoConsumoCategoria(tipoConsumoCategoria);
			}

			form.setColecaoConsumoFaixaCategoria(colecaoFaixa);
			Integer tamanhoColecao = Integer.valueOf(0);
			if(colecaoFaixa != null){
				tamanhoColecao = colecaoFaixa.size();
			}
			form.setTamanhoColecao(tamanhoColecao.toString());
			form.setLinkedHashMapConsumoFaixaCategoria(linkedHashMapConsumoFaixaCategoria);

		}else{
			throw new ActionServletException("atencao.naocadastrado", null, "Consumo Faixa Categoria");
		}

	}

	/**
	 * Remove o Objeto Consumo Faixa Categoria
	 * 
	 * @author Rafael Pinto
	 * @date 15/06/2007
	 * @param EmissaoHistogramaAguaEconomiaDadosInformarActionForm
	 * @param idRemover
	 */
	private void removeConsumoFaixaCategoria(EmissaoHistogramaAguaEconomiaDadosInformarActionForm form, int idRemover){

		Collection<ConsumoFaixaCategoria> novaColecaoConsumoFaixaCategoria = new ArrayList<ConsumoFaixaCategoria>();

		Collection<ConsumoFaixaCategoria> colecaoParaIterar = (Collection<ConsumoFaixaCategoria>) form
						.getLinkedHashMapConsumoFaixaCategoria().get(form.getTipoConsumoCategoria());

		int index = 0;
		for(Iterator iter = colecaoParaIterar.iterator(); iter.hasNext();){

			index++;

			ConsumoFaixaCategoria element = (ConsumoFaixaCategoria) iter.next();

			if(index != idRemover){
				novaColecaoConsumoFaixaCategoria.add(element);
			}
		}

		if(novaColecaoConsumoFaixaCategoria.isEmpty()){
			throw new ActionServletException("atencao.consumo_faixa_nao_informada");
		}

		this.ordenaColecaoFaixaConsumoCategoria(novaColecaoConsumoFaixaCategoria);

		form.getLinkedHashMapConsumoFaixaCategoria().put(form.getTipoConsumoCategoria(), novaColecaoConsumoFaixaCategoria);
		form.setColecaoConsumoFaixaCategoria(novaColecaoConsumoFaixaCategoria);
		form.setTamanhoColecao(Integer.toString(novaColecaoConsumoFaixaCategoria.size()));
	}

	/**
	 * Valida a inclus�o do Objeto Consumo Faixa Categoria
	 * 
	 * @author Rafael Pinto
	 * @date 15/06/2007
	 */
	private void validarInclusaoConsumoFaixaCategoria(EmissaoHistogramaAguaEconomiaDadosInformarActionForm form){

		boolean ehValido = true;

		Collection<ConsumoFaixaCategoria> colecaoFaixas = (Collection<ConsumoFaixaCategoria>) form.getLinkedHashMapConsumoFaixaCategoria()
						.get(form.getTipoConsumoCategoria());

		int numeroFaixaInicio = Integer.parseInt(form.getLimiteInferiorFaixa());
		int numeroFaixaFim = Integer.parseInt(form.getLimiteSuperiorFaixa());
		Categoria categoria = new Categoria();

		FiltroConsumoFaixaCategoria filtroConsumoFaixaCategoria = new FiltroConsumoFaixaCategoria();

		filtroConsumoFaixaCategoria
						.adicionarParametro(new ParametroSimples(FiltroConsumoFaixaCategoria.ID, form.getTipoConsumoCategoria()));

		Collection colecaoConsumoFaixaCategoria = this.getFachada().pesquisar(filtroConsumoFaixaCategoria,
						ConsumoFaixaCategoria.class.getName());

		ConsumoFaixaCategoria consumoFaixa = (ConsumoFaixaCategoria) Util.retonarObjetoDeColecao(colecaoConsumoFaixaCategoria);

		if(consumoFaixa != null){

			categoria.setId(consumoFaixa.getId());

		}

		Iterator itera = colecaoFaixas.iterator();
		while(itera.hasNext()){
			ConsumoFaixaCategoria consumoExistente = (ConsumoFaixaCategoria) itera.next();

			int numeroFaixaInicioExistente = consumoExistente.getNumeroFaixaInicio();
			int numeroFaixaFimExistente = consumoExistente.getNumeroFaixaFim();

			if((numeroFaixaInicio >= numeroFaixaInicioExistente && numeroFaixaInicio <= numeroFaixaFimExistente)
							|| (numeroFaixaFim >= numeroFaixaInicioExistente && numeroFaixaInicio <= numeroFaixaFimExistente)){

				ehValido = false;
			}
		}

		if(ehValido){
			ConsumoFaixaCategoria consumoFaixaCategoria = new ConsumoFaixaCategoria();

			consumoFaixaCategoria.setNumeroFaixaInicio(numeroFaixaInicio);
			consumoFaixaCategoria.setNumeroFaixaFim(numeroFaixaFim);
			consumoFaixaCategoria.setCategoria(categoria);

			colecaoFaixas.add(consumoFaixaCategoria);

			this.ordenaColecaoFaixaConsumoCategoria(colecaoFaixas);
			Integer tamanhoColecao = Integer.valueOf(0);
			if(colecaoFaixas != null){
				tamanhoColecao = colecaoFaixas.size();
			}
			form.setColecaoConsumoFaixaCategoria(colecaoFaixas);
			form.setTamanhoColecao(tamanhoColecao.toString());
		}else{
			throw new ActionServletException("atencao.consumo_faixa_ja_informada");
		}
	}

	/**
	 * Ordena a colecao de consumo faixa categoria
	 * 
	 * @author Rafael Pinto
	 * @date 21/06/2007
	 * @param Collection
	 *            <ConsumoFaixaCategoria>
	 */
	private void ordenaColecaoFaixaConsumoCategoria(Collection colecaoConsumoFaixaCategoria){

		Collections.sort((List) colecaoConsumoFaixaCategoria, new Comparator() {

			public int compare(Object a, Object b){

				ConsumoFaixaCategoria consumo1 = (ConsumoFaixaCategoria) a;
				ConsumoFaixaCategoria consumo2 = (ConsumoFaixaCategoria) b;

				Integer faixaInicio1 = consumo1.getNumeroFaixaInicio();
				Integer faixaInicio2 = consumo2.getNumeroFaixaInicio();

				return faixaInicio1.compareTo(faixaInicio2);
			}
		});

	}

}