<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/pager-taglib.tld" prefix="pg" %>
<%@ taglib uri="/WEB-INF/menus-taglib.tld" prefix="menu" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html:html>
<head>
<%@ include file="/jsp/util/titulo.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet" href="<bean:message key="caminho.css"/>EstilosCompesa.css" type="text/css">
<%--Incluir esse javascript para validar quando os checkboxes est�o vazios--%>
<script language="JavaScript" src="./javascript/util/validacao/ManutencaoRegistro.js" ></script>

<script language="JavaScript">
  function Confirmacao()
  {
    if (CheckboxNaoVazio(document.ManutencaoRegistroActionForm.idRegistrosRemocao) && confirm('Deseja realmente remover o(s) registro(s) de <%=((String) session.getAttribute("titulo")).toLowerCase()%>?'))
      {
      return true;
      }
    else
      {
      return false;
      }
  }
</script>

</head>

<body leftmargin="5" topmargin="5">

<html:form
  action="/removerTabelaAuxiliarAction"
  name="ManutencaoRegistroActionForm"
  type="gcom.gui.ManutencaoRegistroActionForm"
  method="post"
  onsubmit="return Confirmacao()"
>

<%@ include file="/jsp/util/cabecalho.jsp"%>
<%@ include file="/jsp/util/menu.jsp" %>

<table width="770" border="0" cellspacing="4" cellpadding="0">
  <tr>
    <td width="149" valign="top" class="leftcoltext">
      <div align="center">
        <%@ include file="/jsp/util/informacoes_usuario.jsp"%>
        <%@ include file="/jsp/util/mensagens.jsp"%>
      </div>
    </td>
    <td width="625" valign="top" bgcolor="#003399" class="centercoltext">
      <table>
        <tr>
          <td></td>
        </tr>
      </table>
      <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="11"><img border="0" src="<bean:message key="caminho.imagens"/>parahead_left.gif"/></td>
          <td class="parabg">Manter <bean:write name="titulo" scope="session"/> </td>
          <td width="11"><img border="0" src="<bean:message key="caminho.imagens"/>parahead_right.gif"/></td>
        </tr>
      </table>
      <p>&nbsp;</p>
      <table width="100%" border="1" cellpadding="1" cellspacing="0" bordercolor="#000000">
        <tr bordercolor="#90c7fc">
          <td colspan="4" bgcolor="#90c7fc"><%=((String) session.getAttribute("titulo"))%> Cadastrado(a)(s):</td>
        </tr>
        <tr bordercolor="#000000">
          <td width="62" bgcolor="#90c7fc">&nbsp;</td>
          <td width="67" bordercolor="#000000" bgcolor="#90c7fc"> <div align="center"><strong>C&oacute;digo</strong></div></td>
          <td width="482" bgcolor="#90c7fc"><strong><strong><bean:write name="descricao" scope="session"/></strong></td></tr>
        <%--Esquema de pagina��o--%>
        <pg:pager maxIndexPages="10" export="currentPageNumber=pageNumber"
	index="center" maxPageItems="10">
      <pg:param name="pg"/>
      <pg:param name="q"/>

      <logic:iterate name="tabelasAuxiliares" id="tabelasAuxiliares">
	<pg:item>
        <tr bordercolor="#90c7fc">
          <td>
	    <div align="center">
	      <strong>
                <input type="checkbox" name="idRegistrosRemocao" value="<bean:write name="tabelasAuxiliares" property="id"/>"/>
              </strong>
            </div>
          </td>
          <td>
	    <div align="center">
              <strong>
                <bean:write name="tabelasAuxiliares" property="id"/>
              </strong>
            </div>
          </td>
          <td>
            <strong>
	      <html:link page="/exibirAtualizarTabelaAuxiliarAction.do"
			 paramName="tabelasAuxiliares"
			 paramProperty="id"
     			 paramId="idRegistroAtualizacao">
		<bean:write name="tabelasAuxiliares" property="descricao"/>
	      </html:link>
            </strong>
          </td>
        </tr>
	</pg:item>
      </logic:iterate>
        <tr bordercolor="#90c7fc">
          <td colspan="4">&nbsp;</td>
        </tr>
        <tr bordercolor="#90c7fc">
          <td colspan="4"> <div align="left">
              <html:submit styleClass="bottonRightCol" value="Excluir" property="Button"/>
            </div></td>
        </tr>
      </table>
      <p>&nbsp;</p>
      <table width="100%" border="0">
        <tr>
          <td>
            <div align="center"><strong><%@ include file="/jsp/util/indice_pager.jsp"%></strong></div>
	  </td>
	  </pg:pager>
        <%-- Fim do esquema de pagina��o --%>
        </tr>
      </table>
      <p>&nbsp;</p>
    </td>
  </tr>
</table>

<%@ include file="/jsp/util/rodape.jsp"%>

</body>
</html:form>
</html:html>