<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
<head>

<%@ include file="/jsp/util/titulo.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet" href="<bean:message key="caminho.css"/>EstilosCompesa.css" type="text/css">

<%@ page import="gcom.util.ConstantesSistema"%>

<script language="JavaScript" src="<bean:message key="caminho.js"/>validacao/regras_validator.js"></script>

<html:javascript staticJavascript="false"  formName="GerarRelatorioImoveisFaturasAtrasoActionForm"/>

<script language="JavaScript" src="<bean:message key="caminho.js"/>util.js"></script>
<script language="JavaScript" src="<bean:message key="caminho.js"/>Calendario.js" ></script>

<script language="JavaScript">
	
	function validarForm(){
		
		var form = document.forms[0];
		if(validateGerarRelatorioImoveisFaturasAtrasoActionForm(form) && campoObrigatorio() && 
			validarCampos() ){

			submeterFormPadrao(form);
		}
	}
	
	
	function validarCampos(){
		
		var form = document.forms[0];
		
		msg = verificarAtributosInicialFinal(form.localidadeInicial,form.localidadeFinal,"Localidade");
		if( msg != ""){
			alert(msg);
			return false;
		}else{
			msg = verificarAtributosInicialFinal(form.setorComercialInicial,form.setorComercialFinal,"Setor Comercial");
			if( msg != ""){
				alert(msg);
				return false;
			}else{
				msg = verificarAtributosInicialFinal(form.rotaInicial,form.rotaFinal,"Rota");
				if( msg != ""){
					alert(msg);
					return false;
				}else{
					msg = verificarAtributosInicialFinal(form.sequencialRotaInicial,form.sequencialRotaFinal,"Sequencial da Rota");
					if( msg != ""){
						alert(msg);
						return false;
					}else{
						msg = verificarAtributosInicialFinal(form.quantidadeFaturasAtrasoInicial,form.quantidadeFaturasAtrasoFinal,"Quantidade de Faturas");
						if( msg != ""){
							alert(msg);
							return false;
						}else{
							
							if (comparaMesAno(form.referenciaFaturasAtrasoInicial.value, '>', form.referenciaFaturasAtrasoFinal.value) == true){
								msg = "ReferÍncia de Faturas final deve ser maior ou igual a ReferÍncia de Faturas inicial."
							}
							
							if( msg != ""){
								alert(msg);
								return false;
							}else{
								msg = verificarAtributosInicialFinal(form.valorFaturasAtrasoInicial,form.valorFaturasAtrasoFinal,"Valor de Faturas");
								if( msg != ""){
									alert(msg);
									return false;
								}			
							}
						}
					}
				}
			}
		}
	
		return true;
	}
	
	function campoObrigatorio(){       
		var form = document.forms[0];
		var msg = "";
		
		if(form.quantidadeFaturasAtrasoInicial.value.length < 1 && form.quantidadeFaturasAtrasoFinal.value.length < 1){
			msg = "Informe a Qtd. de Faturas";
			form.quantidadeFaturasAtrasoInicial.focus();
		}
		
		if(form.referenciaFaturasAtrasoInicial.value.length < 1 && form.referenciaFaturasAtrasoFinal.value.length < 1){
			msg = "Informe a ReferÍncia das Faturas ";
			form.referenciaFaturasAtrasoInicial.focus();
		}
		
		if( msg != ""){
			alert(msg);
			return false;
		}
		
		return true;
	}
	
	function verificarAtributosInicialFinal(campoInicio, campoFim, nomeCampo){
		
		var msg = "";     		
				   
		if (campoInicio.value.length > 0 && campoInicio.value.length < 1){
			msg = "Informe "+nomeCampo+" Final";
		} else if (campoInicio.value.length < 1 && campoInicio.value.length > 0) {
			msg = "Informe "+nomeCampo+" Inicial";
		} else {
			if (campoInicio.value > campoFim.value){
				msg = nomeCampo+" deve ser maior ou igual a "+nomeCampo+" Inicial.";
			}
		}
		
		return msg;
	}
	
	
	
	function chamarPopup(url, tipo, objeto, codigoObjeto, altura, largura, msg,campo){
		if(!campo.disabled){
	  		if (objeto == null || codigoObjeto == null){
	     		if(tipo == "" ){
	      			abrirPopup(url,altura, largura);
	     		}else{
		  			abrirPopup(url + "?" + "tipo=" + tipo, altura, largura);
		 		}
	 		}else{
				if (codigoObjeto.length < 1 || isNaN(codigoObjeto)){
					alert(msg);
				}else{
					abrirPopup(url + "?" + "tipo=" + tipo + "&" + objeto + "=" + codigoObjeto, altura, largura);
				}
			}
  		}
	}
	
  	function limpar(){

  		var form = document.forms[0];
  		
  		

  		form.gerenciaRegional.value = "-1";
  		form.unidadeNegocio.value = "-1";
  		
  		form.localidadeInicial.value = '';
  		form.setorComercialInicial.value = '';
  		form.rotaInicial.value ='';
  		form.sequencialRotaInicial.value = '';
  		form.localidadeFinal.value = '';
  		form.setorComercialFinal.value = '';
  		form.rotaFinal.value = '';
  		form.sequencialRotaFinal.value = '';
  		form.situacaoLigacaoAgua.value = "-1";
  		form.categorias.value = "-1";
  		form.quantidadeFaturasAtrasoInicial.value = '';
  		form.quantidadeFaturasAtrasoFinal.value = '';
  		form.referenciaFaturasAtrasoInicial.value = '';
  		form.referenciaFaturasAtrasoFinal.value = '';
  		form.valorFaturasAtrasoInicial.value = '';
  		form.valorFaturasAtrasoFinal.value = '';
  		

  		form.action='exibirGerarRelatorioImoveisFaturasAtrasoAction.do?menu=sim';
	    form.submit();
  	}
  	
  	function replicarLocalidade(){
		var formulario = document.forms[0]; 
		
		formulario.localidadeFinal.value = formulario.localidadeInicial.value;
		formulario.setorComercialInicial.focus;
	}
	
	function replicarSetorComercial(){
		var formulario = document.forms[0]; 
		formulario.setorComercialFinal.value = formulario.setorComercialInicial.value;
		formulario.rotaInicial.focus;
	} 
	
	function replicarRota(){
		var formulario = document.forms[0]; 
		formulario.rotaFinal.value = formulario.rotaInicial.value;
		formulario.sequencialRotaInicial.focus;
	} 
  	
	function replicarSequencialRota(){
		var formulario = document.forms[0];
		formulario.sequencialRotaFinal.value = formulario.sequencialRotaInicial.value;
	} 
	
	function limparOrigem(tipo){
		var form = document.forms[0];
		
		switch(tipo){
		
		case 1: //De localidade pra baixo

			form.nomeLocalidadeInicial.value = "";
			form.localidadeFinal.value = "";
			form.nomeLocalidadeFinal.value = "";
			form.setorComercialInicial.value = "";
		    form.setorComercialFinal.value = "";
		  	form.rotaInicial.value = "";
		   	form.sequencialRotaInicial.value = "";
		    
		case 2: //De setor para baixo

		   form.nomeSetorComercialInicial.value = "";
		   form.setorComercialFinal.value = "";
		   form.nomeSetorComercialFinal.value = "";
		   form.rotaFinal.value = "";
		   form.sequencialRotaFinal.value = "";
		    
			
		}
	}
	
	function limparBorrachaOrigem(tipo){
		var form = document.forms[0];
		
		switch(tipo){
			case 1: //De localidara pra baixo

				form.localidadeInicial.value = "";
				form.nomeLocalidadeInicial.value = "";
				form.localidadeFinal.value = "";
				form.nomeLocalidadeFinal.value = "";
				break;
			case 2: //De setor para baixo
		     	
		     	form.setorComercialInicial.value = "";
		     	form.nomeSetorComercialInicial.value = "";
		     	form.setorComercialFinal.value = "";
		     	form.nomeSetorComercialFinal.value = "";
		}
	}
	
	function limparBorrachaDestino(tipo){
		var form = document.forms[0];

		switch(tipo){
			case 1: //De localidade pra baixo
				form.localidadeFinal.value = "";
				form.nomeLocalidadeFinal.value = "";
				form.setorComercialFinal.value = "";
				
			case 2: //De setor para baixo		   
		   		form.setorComercialFinal.value = ""; 
		   		form.nomeSetorComercialFinal.value = "";		   
		}
	}
	
	
	function recuperarDadosPopup(codigoRegistro, descricaoRegistro, tipoConsulta) {

		var form = document.forms[0];

		if (tipoConsulta == 'localidadeOrigem') {
      		
      		form.localidadeInicial.value = codigoRegistro;
	  		form.nomeLocalidadeInicial.value = descricaoRegistro;
	  		
	  		form.localidadeFinal.value = codigoRegistro;
      		form.nomeLocalidadeFinal.value = descricaoRegistro;
      		
	  		form.nomeLocalidadeInicial.style.color = "#000000";
	  		form.nomeLocalidadeFinal.style.color = "#000000";
	  		
	  		form.setorComercialInicial.focus();
		}

		if (tipoConsulta == 'localidadeDestino') {
		
      		form.localidadeFinal.value = codigoRegistro;
      		form.nomeLocalidadeFinal.value = descricaoRegistro;
	  		form.nomeLocalidadeFinal.style.color = "#000000";

	  		form.setorComercialFinal.focus();
		}
	}
	
	
	function recuperarDadosQuatroParametros(idRegistro, descricaoRegistro, codigoRegistro, tipoConsulta) {

		var form = document.forms[0];

		if (tipoConsulta == 'setorComercialOrigem') {
		  	form.setorComercialInicial.value = codigoRegistro;
		  	form.nomeSetorComercialInicial.value = descricaoRegistro;
		  	form.nomeSetorComercialInicial.style.color = "#000000"; 
		  	
		  	form.setorComercialFinal.value = codigoRegistro;
		  	form.nomeSetorComercialFinal.value = descricaoRegistro;
		  	form.nomeSetorComercialFinal.style.color = "#000000";
		  	
		}

		if (tipoConsulta == 'setorComercialDestino') {
		  	form.setorComercialFinal.value = codigoRegistro;
		  	form.nomeSetorComercialFinal.value = descricaoRegistro;
		  	form.nomeSetorComercialFinal.style.color = "#000000";
		}
	}	
	  	
</script>

</head>

<body leftmargin="5" topmargin="5" onload="javascript:setarFoco('${requestScope.mesAnoFaturamento}');">

<html:form action="/gerarRelatorioImoveisFaturasAtrasoAction.do"
	name="GerarRelatorioImoveisFaturasAtrasoActionForm"
	type="gcom.gui.relatorio.cadastro.GerarRelatorioImoveisFaturasAtrasoActionForm"
	method="post">

<%@ include file="/jsp/util/cabecalho.jsp"%>
<%@ include file="/jsp/util/menu.jsp" %>

<table width="770" border="0" cellspacing="4" cellpadding="0">
	  <tr>
	    <td width="149" valign="top" class="leftcoltext">
	      <div align="center">
	        <%--<p align="left">&nbsp;</p>--%>
	        <%--<p align="left">&nbsp;</p>--%>
	        <%--<p align="left">&nbsp;</p>--%>
	
			<%@ include file="/jsp/util/informacoes_usuario.jsp"%>
	
	        <%--<p align="left">&nbsp;</p>--%>
	        <%--<p align="left">&nbsp;</p>--%>
	        <%--<p align="left">&nbsp;</p>--%>
	        <%--<p align="left">&nbsp;</p>--%>
	        <%--<p align="left">&nbsp;</p>--%>
	        <%--<p align="left">&nbsp;</p>--%>
	        <%--<p align="left">&nbsp;</p>--%>
	        <%--<p align="left">&nbsp;</p>--%>
	        <%--<p align="left">&nbsp;</p>--%>
	        <%--<p align="left">&nbsp;</p>--%>
	        <%--<p align="left">&nbsp;</p>--%>
	        <%--<p align="left">&nbsp;</p>--%>
	
			<%@ include file="/jsp/util/mensagens.jsp"%>
	
	        <%--<p align="left">&nbsp;</p>--%>
	        <%--<p align="left">&nbsp;</p>--%>
	        <%--<p align="left">&nbsp;</p>--%>
	        <%--<p align="left">&nbsp;</p>--%>
	        <%--<p align="left">&nbsp;</p>--%>
	        <%--<p align="left">&nbsp;</p>--%>
	        <%--<p align="left">&nbsp;</p>--%>
	      	</div>
	      	</td>
			<td width="600" valign="top" class="centercoltext">
		        <table height="100%">
			        <tr>
			          <td></td>
			        </tr>
		      	</table>

			<table width="100%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td width="11"><img border="0"
						src="<bean:message key="caminho.imagens"/>parahead_left.gif" /></td>
					<td class="parabg">Gerar Relat&oacute;rio  de Im&oacute;veis com Faturas em Atraso</td>
					<td width="11"><img border="0"
						src="<bean:message key="caminho.imagens"/>parahead_right.gif" /></td>
				</tr>
			</table>
			<p>&nbsp;</p>
			<table width="100%" border="0">
				
				<tr>
					<td colspan="2">Para gerar o relat&oacute;rio, informe os dados abaixo:</td>
				</tr>

				<tr>
					<td>
						<strong>Ger&ecirc;ncia Regional:</strong>
					</td>

					<td>
						<strong> 
						<html:select property="gerenciaRegional" 
							style="width: 230px;" 
							onchange="javascript:reloadForm();">
							
							<html:option
								value="<%=""+ConstantesSistema.NUMERO_NAO_INFORMADO%>">&nbsp;
							</html:option>
					
							<logic:present name="colecaoGerenciaRegional" scope="request">
								<html:options collection="colecaoGerenciaRegional"
									labelProperty="nome" 
									property="id" />
							</logic:present>
						</html:select> 														
						</strong>
					</td>
				</tr>

				<tr>
					<td>
						<strong>Unidade de Neg&oacute;cio:</strong>
					</td>

					<td>
						<strong> 
						<html:select property="unidadeNegocio" style="width: 230px;">
							<html:option
								value="<%=""+ConstantesSistema.NUMERO_NAO_INFORMADO%>">&nbsp;
							</html:option>
					
							<logic:present name="colecaoUnidadeNegocio" scope="request">
								<html:options collection="colecaoUnidadeNegocio"
									labelProperty="nome" 
									property="id" />
							</logic:present>
						</html:select> 														
						</strong>
					</td>
				</tr>				
              	
				<tr>
					<td><strong>Localidade Inicial:</strong></td>
					
					<td>
						
						<html:text maxlength="3" 
							tabindex="1"
							property="localidadeInicial" 
							size="3"
							onblur="javascript:replicarLocalidade();" 
							onkeyup="javascript:limparOrigem(1);"
							onkeypress="javascript:limparOrigem(1);validaEnterComMensagem(event, 'exibirGerarRelatorioImoveisFaturasAtrasoAction.do?objetoConsulta=1','localidadeInicial','Localidade Inicial');"/>
							
						<a href="javascript:chamarPopup('exibirPesquisarLocalidadeAction.do', 'origem', null, null, 275, 480, '',document.forms[0].localidadeInicial);limparOrigem(1);">
							<img width="23" 
								height="21" 
								border="0" 
								style="cursor:hand;"
								src="<bean:message key="caminho.imagens"/>pesquisa.gif"
								title="Pesquisar Localidade" /></a>
								

						<logic:present name="localidadeInicialEncontrada" scope="request">
							<html:text property="nomeLocalidadeInicial" 
								size="30"
								maxlength="30" 
								readonly="true"
								style="background-color:#EFEFEF; border:0; color: #000000" />
						</logic:present> 

						<logic:notPresent name="localidadeInicialEncontrada" scope="request">
							<html:text property="nomeLocalidadeInicial" 
								size="30"
								maxlength="30" 
								readonly="true"
								style="background-color:#EFEFEF; border:0; color: red" />
						</logic:notPresent>

						
						<a href="javascript:limparBorrachaOrigem(1);"> 
							<img src="<bean:message key="caminho.imagens"/>limparcampo.gif"
								border="0" 
								title="Apagar" /></a>
					</td>
				</tr>
				
				<tr>
					<td><strong>Setor Comercial Inicial:</strong></td>
					
					<td>
						
						<html:text maxlength="3" 
							tabindex="1"
							property="setorComercialInicial" 
							size="3"
							onblur="javascript:replicarSetorComercial();"
							onkeyup="limparOrigem(2);"
							onkeypress="javascript:limparOrigem(2);validaEnterComMensagem(event, 'exibirGerarRelatorioImoveisFaturasAtrasoAction.do?objetoConsulta=2','setorComercialInicial','Setor Comercial Inicial');"/>
							
						<a href="javascript:chamarPopup('exibirPesquisarSetorComercialAction.do', 'setorComercialOrigem', 'idLocalidade', document.forms[0].localidadeInicial.value , 275, 480, 'Informe Localidade Inicial',document.forms[0].setorComercialInicial);
						         limparOrigem(2);">
							<img width="23" 
								height="21" 
								border="0" 
								style="cursor:hand;"
								src="<bean:message key="caminho.imagens"/>pesquisa.gif"
								title="Pesquisar Setor Comercial" /></a>
								

						<logic:present name="setorComercialInicialEncontrado" scope="request">
							<html:text property="nomeSetorComercialInicial" 
								size="30"
								maxlength="30" 
								readonly="true"
								style="background-color:#EFEFEF; border:0; color: #000000" />
						</logic:present> 

						<logic:notPresent name="setorComercialInicialEncontrado" scope="request">
							<html:text property="nomeSetorComercialInicial" 
								size="30"
								maxlength="30" 
								readonly="true"
								style="background-color:#EFEFEF; border:0; color: red" />
						</logic:notPresent>
						
						<a href="javascript:limparBorrachaOrigem(2);"> 
							<img src="<bean:message key="caminho.imagens"/>limparcampo.gif"
								border="0" 
								title="Apagar" /></a>
					</td>
				</tr>
				
				<tr>
					<td><strong>Rota Inicial:</strong></td>
					
					<td>
						
						<html:text maxlength="3" 
							tabindex="1"
							property="rotaInicial"
							onblur="javascript:replicarRota();"
							size="3"/>
					</td>
				</tr>

				<tr>
					<td><strong>Sequencial Inicial da Rota:</strong></td>
					
					<td>
						
						<html:text maxlength="3" 
							tabindex="1"
							property="sequencialRotaInicial"
							onblur="javascript:replicarSequencialRota();"
							size="3"/>
					</td>
				</tr>
				
				
				<tr>
					<td><strong>Localidade Final:</strong></td>
					
					<td>
						
						<html:text maxlength="3" 
							tabindex="1"
							property="localidadeFinal" 
							size="3"
							onkeypress="validaEnterComMensagem(event, 'exibirGerarRelatorioImoveisFaturasAtrasoAction.do?objetoConsulta=3','localidadeFinal','Localidade Final');"/>
							
						<a href="javascript:chamarPopup('exibirPesquisarLocalidadeAction.do', 'destino', null, null, 275, 480, '',document.forms[0].localidadeFinal);limparDestino(1);">
							<img width="23" 
								height="21" 
								border="0" 
								style="cursor:hand;"
								src="<bean:message key="caminho.imagens"/>pesquisa.gif"
								title="Pesquisar Localidade" /></a>
								 

						<logic:present name="localidadeFinalEncontrada" scope="request">
							<html:text property="nomeLocalidadeFinal" 
								size="30"
								maxlength="30" 
								readonly="true"
								style="background-color:#EFEFEF; border:0; color: #000000" />
						</logic:present> 

						<logic:notPresent name="localidadeFinalEncontrada" scope="request">
							<html:text property="nomeLocalidadeFinal" 
								size="30"
								maxlength="30" 
								readonly="true"
								style="background-color:#EFEFEF; border:0; color: red" />
						</logic:notPresent>

						
						<a href="javascript:limparBorrachaDestino(1);"> 
							<img src="<bean:message key="caminho.imagens"/>limparcampo.gif"
								border="0" 
								title="Apagar" /></a>
					</td>
				</tr>
				
				<tr>
					<td><strong>Setor Comercial Final:</strong></td>
					
					<td>
						
						<html:text maxlength="3" property="setorComercialFinal"
							size="3"
							onkeypress="limparDestino(2);validaEnterDependencia(event, 'exibirGerarRelatorioImoveisFaturasAtrasoAction.do?objetoConsulta=4', document.forms[0].setorComercialFinal, document.forms[0].localidadeFinal.value, 'Localidade Final');"
							tabindex="8"/>
								
						<a href="javascript:chamarPopup('exibirPesquisarSetorComercialAction.do', 'setorComercialDestino', 'idLocalidade', document.forms[0].localidadeFinal.value, 275, 480, 'Informe Localidade Final',document.forms[0].setorComercialFinal);
							        limparDestino(2);">
							<img width="23" 
								height="21" 
								border="0" 
								src="<bean:message key="caminho.imagens"/>pesquisa.gif"
								title="Pesquisar Setor Comercial" /></a>
								

						<logic:present name="setorComercialFinalEncontrado" scope="request">
							<html:text property="nomeSetorComercialFinal" 
								size="30"
								maxlength="30" 
								readonly="true"
								style="background-color:#EFEFEF; border:0; color: #000000" />
						</logic:present> 

						<logic:notPresent name="setorComercialFinalEncontrado" scope="request">
							<html:text property="nomeSetorComercialFinal" 
								size="30"
								maxlength="30" 
								readonly="true"
								style="background-color:#EFEFEF; border:0; color: red" />
						</logic:notPresent>
						
						<a href="javascript:limparBorrachaDestino(2);"> 
							<img src="<bean:message key="caminho.imagens"/>limparcampo.gif"
								border="0" 
								title="Apagar" /></a>
					</td>
				</tr>
				
				<tr>
					<td><strong>Rota Final:</strong></td>
					
					<td>
						
						<html:text maxlength="3" 
							tabindex="1"
							property="rotaFinal" 
							size="3"/>
					</td>
				</tr>

				<tr>
					<td><strong>Sequencial Final da Rota:</strong></td>
					
					<td>
						
						<html:text maxlength="3" 
							tabindex="1"
							property="sequencialRotaFinal" 
							size="3"/>
					</td>
				</tr>
				
              	<tr> 
                	<td>
                		<strong>Situa&ccedil;&atilde;o da Liga&ccedil;&atilde;o de &Aacute;gua</strong>
                    </td>
                	
                	<td colspan="6">
               			<strong>
						<html:select property="situacaoLigacaoAgua" 
							style="width: 350px; height:100px;" 
							multiple="true">
							
							<html:option value="<%=""+ConstantesSistema.NUMERO_NAO_INFORMADO%>">&nbsp;</html:option>
							
							<logic:present name="colecaoSituacaoLigacaoAgua" scope="request">
								<html:options collection="colecaoSituacaoLigacaoAgua" 
									labelProperty="descricao" 
									property="id" />
							</logic:present>
						</html:select>                
                 		</strong>
                 	 </td>
              	</tr>				
              	<tr> 
                	<td>
                		<strong>Categorias</strong>                		
                    </td>
                	
                	<td colspan="6">
               			<strong>
						<html:select property="categorias" 
							style="width: 350px; height:100px;" 
							multiple="true">
							
							<html:option value="<%=""+ConstantesSistema.NUMERO_NAO_INFORMADO%>">&nbsp;</html:option>
							
							<logic:present name="colecaoCategoria" scope="request">
								<html:options collection="colecaoCategoria" 
									labelProperty="descricao" 
									property="id" />
							</logic:present>
						</html:select>                
                 		</strong>
                 	 </td>
              	</tr>    				
				<tr>
					<td><strong>Qtd. de Faturas :</strong><font color="#FF0000">*</font></td>					
					<td colsan="3">						
						<html:text maxlength="5"
							tabindex="1"
							property="quantidadeFaturasAtrasoInicial" 
							size="3" onkeyup="javascript:replicarCampo( document.forms[0].quantidadeFaturasAtrasoFinal, document.forms[0].quantidadeFaturasAtrasoInicial );"/>
						<strong>a</strong>
						<html:text maxlength="5"
							tabindex="1"
							property="quantidadeFaturasAtrasoFinal" 
							size="3"/>
					</td>
				</tr>
				<tr>
					<td><strong>Refer&ecirc;ncia das Faturas :</strong><font color="#FF0000">*</font></td>					
					<td colsan="3">						
						<html:text maxlength="7"
							tabindex="1"
							property="referenciaFaturasAtrasoInicial" 
							size="7" onkeyup="javascript:replicarCampo( document.forms[0].referenciaFaturasAtrasoFinal, document.forms[0].referenciaFaturasAtrasoInicial );mascaraAnoMes(this, event);"/>
						<strong>a</strong>
						<html:text maxlength="7"
							tabindex="1"
							property="referenciaFaturasAtrasoFinal" 
							size="7" onkeyup="javascript:mascaraAnoMes(this, event);"/> (mm/aaaa)
					</td>
				</tr>
				<tr>
					<td><strong>Valor de Faturas :</strong></td>						
					<td colsan="3">						
						<html:text maxlength="7"
							tabindex="1"
							property="valorFaturasAtrasoInicial" 
							size="3" onkeyup="javascript:replicarCampo( document.forms[0].valorFaturasAtrasoFinal, document.forms[0].valorFaturasAtrasoInicial );"/>
						<strong>a</strong>
						<html:text maxlength="7"
							tabindex="1"
							property="valorFaturasAtrasoFinal" 
							size="3"/>
					</td>
				</tr>
				<tr>
					<td height="24" >
			          	<input type="button" 
			          		class="bottonRightCol" 
			          		value="Limpar" 
			          		onclick="javascript:limpar()"/>
					</td>
				
					<td align="right">
						<input type="button" 
							name="Button" 
							class="bottonRightCol" 
							value="Gerar" 
							onClick="javascript:validarForm()" />
					</td>
					
				</tr>
			</table>
			<p>&nbsp;</p>
			</td>
		</tr>
	</table>
<%@ include file="/jsp/util/rodape.jsp"%>	
</html:form>
</body>
<!-- relatorio_imoveis_faturas_atraso_gerar.jsp -->
</html:html>
