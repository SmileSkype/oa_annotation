<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<html>
<head>
<title>导航菜单</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="JavaScript" src="js/jquery-ztree-2.5.js"></script>
<script language="JavaScript" src="js/menu.js"></script>
<link type="text/css" rel="stylesheet" href="css/blue/menu.css" />
<link rel="stylesheet" href="zTreeStyle/zTreeStyle.css" type="text/css">
</head>
<body style="margin: 0">
<TABLE border=0 width="700">
	<TR>
		<TD width=340px align=center valign=top>
		<div class="zTreeDemoBackground">
			<ul id="menuTree" class="tree"></ul>
		</div>		
		</TD>
	</TR>
</TABLE>
</body>
</html>