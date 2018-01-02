
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="pragma" content="no-cache" />
<title>Natural Language Classifier Assessment</title>

<link href="./css/style.css" rel="stylesheet" type="text/css"></head>
<body>
	<form name="nlcQAForm" action="WatsonNLCServlet" method="post" autocomplete="off">
		<table>
			<tr>
				<td><jsp:include page="/topHeader.jsp" flush="true"></jsp:include></td>
			</tr>

			<tr>
				<td colspan=2 style="font-size: 12pt;" align="center">

					<h3>Ask a question</h3>
				</td>
			</tr>
			<tr>
				<td><input type="text" name="question" size=80 required="required"  
					value="<%=request.getParameter("question") != null ? request.getParameter("question") : ""%>"
					placeholder="Enter your question or Try a sample question below">
				</td>
				<td><input type="submit" value="Ask"></td>
			</tr>
			<tr>
				<td colspan="2"><h3>Sample questions</h3></td>
			</tr>
			<tr>
				<td colspan="2">What is the capital of UAE?</td>
			</tr>
			<tr>
				<td colspan="2">What is IBM Watson?</td>
			</tr>
			<tr>
				<td colspan="2">What is the temperature outside today?</td>
			</tr>
		</table>
		<%
			if (request.getAttribute("result") != null && !request.getAttribute("result").equals("")) {
		%>
		<h2>Answer</h2>
		<div class="generic">
			<table>
			
				<tr>
					<td colspan="2"><%=request.getAttribute("result")%></td>
				</tr>
			</table>
		</div>
		<%
			}
		%>
	</form>
</body>
</html>
