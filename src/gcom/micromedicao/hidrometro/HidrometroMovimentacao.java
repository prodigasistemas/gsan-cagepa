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

package gcom.micromedicao.hidrometro;

import gcom.seguranca.acesso.usuario.Usuario;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class HidrometroMovimentacao
				implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
	private Integer id;

	/** nullable persistent field */
	private Date data;

	/** nullable persistent field */
	private Date hora;

	/** nullable persistent field */
	private String parecer;

	/** nullable persistent field */
	private String quantidade;

	/** nullable persistent field */
	private String fixo;

	/** nullable persistent field */
	private String faixaInicial;

	/** nullable persistent field */
	private String faixaFinal;

	/** nullable persistent field */
	private Date ultimaAlteracao;

	/** persistent field */
	private gcom.micromedicao.hidrometro.HidrometroMotivoMovimentacao hidrometroMotivoMovimentacao;

	/** persistent field */
	private gcom.micromedicao.hidrometro.HidrometroLocalArmazenagem hidrometroLocalArmazenagemDestino;

	/** persistent field */
	private gcom.micromedicao.hidrometro.HidrometroLocalArmazenagem hidrometroLocalArmazenagemOrigem;

	/** persistent field */
	private Set hidrometroMovimentados;

	/** persistent field */
	private Usuario usuario;

	/** full constructor */
	public HidrometroMovimentacao(Date data, Date hora, String parecer, Date ultimaAlteracao,
									gcom.micromedicao.hidrometro.HidrometroMotivoMovimentacao hidrometroMotivoMovimentacao,
									gcom.micromedicao.hidrometro.HidrometroLocalArmazenagem hidrometroLocalArmazenagemDestino,
									gcom.micromedicao.hidrometro.HidrometroLocalArmazenagem hidrometroLocalArmazenagemOrigem,
									Usuario usuario) {

		this.data = data;
		this.hora = hora;
		this.parecer = parecer;
		this.ultimaAlteracao = ultimaAlteracao;
		this.hidrometroMotivoMovimentacao = hidrometroMotivoMovimentacao;
		this.hidrometroLocalArmazenagemDestino = hidrometroLocalArmazenagemDestino;
		this.hidrometroLocalArmazenagemOrigem = hidrometroLocalArmazenagemOrigem;
		this.usuario = usuario;
	}

	/** default constructor */
	public HidrometroMovimentacao() {

	}

	/** minimal constructor */
	public HidrometroMovimentacao(gcom.micromedicao.hidrometro.HidrometroMotivoMovimentacao hidrometroMotivoMovimentacao,
									gcom.micromedicao.hidrometro.HidrometroLocalArmazenagem hidrometroLocalArmazenagemDestino,
									gcom.micromedicao.hidrometro.HidrometroLocalArmazenagem hidrometroLocalArmazenagemOrigem,
									Usuario usuario) {

		this.hidrometroMotivoMovimentacao = hidrometroMotivoMovimentacao;
		this.hidrometroLocalArmazenagemDestino = hidrometroLocalArmazenagemDestino;
		this.hidrometroLocalArmazenagemOrigem = hidrometroLocalArmazenagemOrigem;
		this.usuario = usuario;
	}

	public Integer getId(){

		return this.id;
	}

	public void setId(Integer id){

		this.id = id;
	}

	public Date getData(){

		return this.data;
	}

	public void setData(Date data){

		this.data = data;
	}

	public Date getHora(){

		return this.hora;
	}

	public void setHora(Date hora){

		this.hora = hora;
	}

	public String getParecer(){

		return this.parecer;
	}

	public void setParecer(String parecer){

		this.parecer = parecer;
	}

	public Date getUltimaAlteracao(){

		return this.ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao){

		this.ultimaAlteracao = ultimaAlteracao;
	}

	public gcom.micromedicao.hidrometro.HidrometroMotivoMovimentacao getHidrometroMotivoMovimentacao(){

		return this.hidrometroMotivoMovimentacao;
	}

	public Set getHidrometroMovimentados(){

		return hidrometroMovimentados;
	}

	public void setHidrometroMovimentados(Set hidrometroMovimentados){

		this.hidrometroMovimentados = hidrometroMovimentados;
	}

	public void setHidrometroMotivoMovimentacao(gcom.micromedicao.hidrometro.HidrometroMotivoMovimentacao hidrometroMotivoMovimentacao){

		this.hidrometroMotivoMovimentacao = hidrometroMotivoMovimentacao;
	}

	public gcom.micromedicao.hidrometro.HidrometroLocalArmazenagem getHidrometroLocalArmazenagemDestino(){

		return this.hidrometroLocalArmazenagemDestino;
	}

	public void setHidrometroLocalArmazenagemDestino(
					gcom.micromedicao.hidrometro.HidrometroLocalArmazenagem hidrometroLocalArmazenagemDestino){

		this.hidrometroLocalArmazenagemDestino = hidrometroLocalArmazenagemDestino;
	}

	public gcom.micromedicao.hidrometro.HidrometroLocalArmazenagem getHidrometroLocalArmazenagemOrigem(){

		return this.hidrometroLocalArmazenagemOrigem;
	}

	public void setHidrometroLocalArmazenagemOrigem(gcom.micromedicao.hidrometro.HidrometroLocalArmazenagem hidrometroLocalArmazenagemOrigem){

		this.hidrometroLocalArmazenagemOrigem = hidrometroLocalArmazenagemOrigem;
	}

	public Usuario getUsuario(){

		return this.usuario;
	}

	public void setUsuario(Usuario usuario){

		this.usuario = usuario;
	}

	public String toString(){

		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	public String getQuantidade(){

		return quantidade;
	}

	public void setQuantidade(String quantidade){

		this.quantidade = quantidade;
	}

	public String getFaixaFinal(){

		return faixaFinal;
	}

	public void setFaixaFinal(String faixaFinal){

		this.faixaFinal = faixaFinal;
	}

	public String getFaixaInicial(){

		return faixaInicial;
	}

	public void setFaixaInicial(String faixaInicial){

		this.faixaInicial = faixaInicial;
	}

	public String getFixo(){

		return fixo;
	}

	public void setFixo(String fixo){

		this.fixo = fixo;
	}

	public boolean equals(Object other){

		if((this == other)) return true;
		if(!(other instanceof HidrometroMovimentacao)) return false;
		HidrometroMovimentacao castOther = (HidrometroMovimentacao) other;
		return new EqualsBuilder()
						.append(this.getId(), castOther.getId())
						.append(this.getData(), castOther.getData())
						.append(this.getHora(), castOther.getHora())
						.append(this.getParecer(), castOther.getParecer())
						.append(this.getHidrometroMotivoMovimentacao().getId(), castOther.getHidrometroMotivoMovimentacao().getId())
						.append(this.getHidrometroLocalArmazenagemDestino().getId(),
										castOther.getHidrometroLocalArmazenagemDestino().getId())
						.append(this.getHidrometroLocalArmazenagemOrigem().getId(), castOther.getHidrometroLocalArmazenagemOrigem().getId())
						.isEquals();
	}
}
