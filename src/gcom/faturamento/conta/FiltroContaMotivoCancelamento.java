
package gcom.faturamento.conta;

import gcom.util.filtro.Filtro;

/**
 * filtro de Motivo Cancelamento de conta
 * 
 * @author Francisco do Nascimento
 * @created 17 de outubro de 2007
 */
public class FiltroContaMotivoCancelamento
				extends Filtro {

	private static final long serialVersionUID = 1L;

	/**
	 * Description of the Field
	 */
	public final static String CODIGO = "id";

	/**
	 * Description of the Field
	 */
	public final static String DESCRICAO = "descricaoMotivoCancelamentoConta";

	public static final String INDICADOR_USO = "indicadorUso";

	public final static String SOLICITACAO_TIPO_ESPECIFICACAO = "solicitacaoTipoEspecificacao";

	/**
	 * Construtor da classe FiltroContaMotivoRetificacao
	 */
	public FiltroContaMotivoCancelamento() {

	}

	/**
	 * Construtor da classe FiltroContaMotivoRetificacao
	 * 
	 * @param campoOrderBy
	 *            Descri��o do par�metro
	 */
	public FiltroContaMotivoCancelamento(String campoOrderBy) {

		this.campoOrderBy = campoOrderBy;
	}
}