
package gcom.relatorio.cobranca;

import gcom.batch.Relatorio;
import gcom.cadastro.sistemaparametro.SistemaParametro;
import gcom.cobranca.bean.EmitirAvisoCobrancaHelper;
import gcom.fachada.Fachada;
import gcom.relatorio.ConstantesRelatorios;
import gcom.relatorio.RelatorioDataSource;
import gcom.seguranca.acesso.usuario.Usuario;
import gcom.tarefa.TarefaException;
import gcom.tarefa.TarefaRelatorio;
import gcom.util.ControladorException;
import gcom.util.agendadortarefas.AgendadorTarefas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelatorioAvisoCorte
				extends TarefaRelatorio {

	public RelatorioAvisoCorte(Usuario usuario) {

		super(usuario, ConstantesRelatorios.RELATORIO_AVISO_CORTE);
	}

	public RelatorioAvisoCorte() {

		super(null, "");
	}

	private static final long serialVersionUID = 1L;

	public Object executar() throws TarefaException{

		byte[] retorno = null;

		// ------------------------------------
		Integer idFuncionalidadeIniciada = this.getIdFuncionalidadeIniciada();
		// ------------------------------------
		int tipoFormatoRelatorio = (Integer) getParametro("tipoFormatoRelatorio");

		String descricaoArquivo = null;
		if(getParametro("descricaoArquivo") != null){
			descricaoArquivo = (String) getParametro("descricaoArquivo");
		}

		List<EmitirAvisoCobrancaHelper> colecaoEmitirAvisoCobrancaHelper = (ArrayList) getParametro("colecaoEmitirAvisoCobrancaHelper");
		List<RelatorioAvisoCorteBean> collRelatorioAvisoCorteBean = new ArrayList<RelatorioAvisoCorteBean>();
		List<EmitirAvisoCobrancaHelper> colecaoOrdenada = this.dividirColecaoOrdenando(colecaoEmitirAvisoCobrancaHelper);

		EmitirAvisoCobrancaHelper primeiroHelper = null;
		EmitirAvisoCobrancaHelper segundoHelper = null;

		int pagina1 = 1;
		int pagina2 = 0;
		int totalPaginas = colecaoEmitirAvisoCobrancaHelper.size();

		if((totalPaginas % 2) == 0){
			pagina2 = (totalPaginas / 2) + 1;
		}else{
			pagina2 = (totalPaginas / 2) + 2;
		}

		for(EmitirAvisoCobrancaHelper helper : colecaoOrdenada){

			if((primeiroHelper == null) && (segundoHelper == null)){
				primeiroHelper = helper;
				primeiroHelper.setNumeroPagina(pagina1++);
			}else{
				segundoHelper = helper;
				segundoHelper.setNumeroPagina(pagina2++);
			}

			if((primeiroHelper != null) && (segundoHelper != null)){

				collRelatorioAvisoCorteBean.add(new RelatorioAvisoCorteBean(primeiroHelper, segundoHelper));

				primeiroHelper = null;
				segundoHelper = null;
			}
		}

		if(primeiroHelper != null && segundoHelper == null){
			collRelatorioAvisoCorteBean.add(new RelatorioAvisoCorteBean(primeiroHelper, segundoHelper));
		}

		Map parametros = new HashMap();

		SistemaParametro sistemaParametro = Fachada.getInstancia().pesquisarParametrosDoSistema();

		parametros.put("imagem", sistemaParametro.getImagemRelatorio());

		RelatorioDataSource ds = new RelatorioDataSource(collRelatorioAvisoCorteBean);

		retorno = gerarRelatorio(ConstantesRelatorios.RELATORIO_AVISO_CORTE, parametros, ds, tipoFormatoRelatorio);

		// Grava o relatório no sistema
		try{
			this.persistirRelatorioConcluido(retorno, Relatorio.AVISO_CORTE, idFuncionalidadeIniciada, descricaoArquivo);
		}catch(ControladorException e){
			e.printStackTrace();
			throw new TarefaException("Erro ao gravar relatório no sistema", e);
		}

		return retorno;
	}

	public int calcularTotalRegistrosRelatorio(){

		int retorno = 0;

		return retorno;
	}

	public void agendarTarefaBatch(){

		AgendadorTarefas.agendarTarefa("RelatorioAvisoCorte", this);
	}

	private List<EmitirAvisoCobrancaHelper> dividirColecaoOrdenando(List<EmitirAvisoCobrancaHelper> colecao){

		List<EmitirAvisoCobrancaHelper> retorno = new ArrayList<EmitirAvisoCobrancaHelper>();
		List<EmitirAvisoCobrancaHelper> colecaoTmp = colecao;
		int quantidadeItens = 0;
		int tamanhoColecao = colecaoTmp.size();
		int metadeColecao = 0;
		if(tamanhoColecao % 2 == 0){
			metadeColecao = tamanhoColecao / 2;
		}else{
			metadeColecao = (tamanhoColecao / 2) + 1;
		}
		while(quantidadeItens < metadeColecao){
			retorno.add(colecaoTmp.get(quantidadeItens));
			if(metadeColecao + quantidadeItens < tamanhoColecao){
				retorno.add(colecaoTmp.get(metadeColecao + quantidadeItens));
			}
			quantidadeItens++;
		}
		tamanhoColecao = 0;

		return retorno;
	}
}
