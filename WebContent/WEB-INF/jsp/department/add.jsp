<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!-- sample.js不加也不会出现问题，当时添加上是因为本地index,如果不加，出不来效果 -->
<script language="javascript" src="${pageContext.request.contextPath}/ckeditor/samples/js/sample.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/js/jquery-ckeditor.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/js/department-add.js"></script>
<html>
<head>
	<title>部门设置</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>

<!-- 标题显示 --> 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 部门信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <s:form action="departmentAction_add.action">
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/css/blue/images/item_point.gif" /> 部门信息 </DIV>  -->
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mains:form">
                    <tr><td>部门名称</td>
                        <!-- <td><input type="text" name="name" class="InputStyle"/> *</td> -->
                        <td><s:textfield name="dname" cssClass="inputStyle"></s:textfield> *</td>
                    </tr>
                    <tr><td>职能说明</td>
                        <!-- <td><textarea name="description" class="TextareaStyle"></textarea></td> -->
                        <td><s:textarea name="description" cssClass="TextareaStyle"></s:textarea></td>
                    </tr>
                </table>
            </div>
        </div>
        
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="${pageContext.request.contextPath}/css/images/save.png"/>
            <a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/css/images/goBack.png"/></a>
        </div>
    </s:form>
</div>

<div class="Description">
	说明：<br />
	1，上级部门的列表是有层次结构的（树形）。<br/>
	2，如果是修改：上级部门列表中不能显示当前修改的部门及其子孙部门。因为不能选择自已或自已的子部门作为上级部门。<br />
</div>

</body>
</html>