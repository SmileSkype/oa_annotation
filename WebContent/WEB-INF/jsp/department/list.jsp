<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>部门列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath }/css/images/title_arrow.gif"/> 部门管理
            														
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
            	<td width="150px">部门名称</td>
				<td width="150px">上级部门名称</td>
				<td width="200px">职能说明</td>
				<td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="departmentList">
			<%-- <tr class="TableDe.tail1 template">
				<td><a href="_list_level2.html">${department.name}</a>&nbsp;</td>
				<td>${department.parent.name}&nbsp;</td>
				<td>${department.description}&nbsp;</td>
				<td><a onClick="return window.confirm('这将删除所有的下级部门，您确定要删除吗？')" href="#">删除</a>
					<a href="saveUI.html">修改</a>
				</td>
			</tr> --%>
			<!-- 
				iterator说明：
					正在迭代的元素位于栈顶
					 如果value属性不写，或者value="top",则认为是迭代的对象栈的栈顶元素
			 -->
			<s:iterator value="departmentList">
				<tr class="TableDe.tail1 template">
					<td align="center"><s:property value="dname"/></td>
					<td align="center"><s:property value="description" escape="false"/></td>
					<!-- 
						在struts2的标签中，只能用ognl表达式，不能用el表达式
						在html标签中，只能用el表达式，不能用ognl表达式
					 -->
					<td align="center"><s:a action="departmentAction_deleteDepartmentById.action?did=%{did}">删除</s:a>
						<!-- <a href="departmentAction_toUpdate.action?did=%{did}">修改</a>  此处出错的原因是html标签中使用了ognl表达式-->
						<s:a href="departmentAction_toUpdate.action?did=%{did}">修改</s:a>
					</td>
				</tr>
			</s:iterator>
			
			<!-- list里面嵌套list -->
			<%-- <s:iterator>
				<s:iterator>
					<s:property value="dname"/>
				</s:iterator>
			</s:iterator> --%>
			
			<!-- list里面嵌套map,list放在了对象栈中 -->
			<%-- <s:iterator>
				<s:iterator>
					<s:property value="key"/>
					<s:property value="value.dname"/>
				</s:iterator>
			</s:iterator> --%>
			
			<!-- map里面嵌套list -->
			<%-- <s:iterator value="#maps">
				 <s:property value="key"/>
				 <!-- 遍历list -->
				 <s:iterator value="value">
				 	<s:property value="dname"/>
				 </s:iterator>
			</s:iterator> --%>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <a href="departmentAction_addUI.action"><img src="${pageContext.request.contextPath}/css/images/createNew.png" /></a>
        </div>
    </div>
</div>

<!--说明-->	
<div id="Description"> 
	说明：<br />
	1，列表页面只显示一层的（同级的）部门数据，默认显示最顶级的部门列表。<br />
	2，点击部门名称，可以查看此部门相应的下级部门列表。<br />
	3，删除部门时，同时删除此部门的所有下级部门。
</div>

</body>
</html>
