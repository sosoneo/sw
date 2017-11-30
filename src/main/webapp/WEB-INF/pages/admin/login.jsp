<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<rapid:override name="title">管理员登录</rapid:override>
<rapid:override name="content">
    <c:if test="${!empty errorMessage}">
        <div class="alert alert-warning alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <strong>${errorMessage}</strong>
        </div>
    </c:if>

    <form:form  action="/admin/loginP" method="post" role="form" commandName="userEntity" modelAttribute="userEntity">
        <div class="form-group">
            <label for="username">用户名:</label>
            <input id="username" name="username" type="text" class="form-control" placeholder="请输入用户名"/>
            <div class="has-error">
                <form:errors path="username" class="help-inline"/>
            </div>
        </div>
        <div class="form-group">
            <label for="password">密码:</label>
            <input id="password" name="password" type="text" class="form-control" placeholder="请输入密码"/>
            <div class="has-error">
                <form:errors path="password" class="help-inline"/>
            </div>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">登录</button>
        </div>
    </form:form>
</rapid:override>
<%@ include file="base/base.jsp"%>