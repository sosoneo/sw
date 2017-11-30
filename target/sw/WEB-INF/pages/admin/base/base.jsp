<%--
  Created by IntelliJ IDEA.
  User: sosoneo
  Date: 2017/11/27
  Time: 下午7:12
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<html lang="zh-CN">
<head>
    <title>
        <rapid:block name="title">
        </rapid:block>
    </title>
    <rapid:block name="header"></rapid:block>
    <%@ include file="header.jsp"%>
</head>

<body>
<div class="container">
    <rapid:block name="content">
    </rapid:block>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>
