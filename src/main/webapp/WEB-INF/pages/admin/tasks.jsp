<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<rapid:override name="title">任务列表</rapid:override>
<rapid:override name="content">
    <nav>
        <ul class="nav nav-tabs">
            <li role="presentation" class="active"><a href="/admin/tasks">任务管理列表</a></li>
            <li role="presentation"><a href="/admin/addTask">添加任务</a></li>
            <li role="presentation">${username}</li>
            <li role="presentation"><a onclick="submit_loginout();" href="#">登出</a></li>
        </ul>
    </nav>
    <c:if test="${!empty taskList}">
        <table class="table table-bordered table-striped">
            <tr>
                <th>ID</th>
                <th>任务名称</th>
                <th>任务详情</th>
                <th>任务链接</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${taskList}" var="task">
                <tr>
                    <td>${task.id}</td>
                    <td>${task.title}</td>
                    <td>${task.info}</td>
                    <td><a href="${task.linkUrl}">点我</a> </td>
                    <td>
                        <a href="/admin/tasks/show/${task.id}" type="button" class="btn btn-sm btn-success">详情</a>
                        <a href="/admin/tasks/update/${task.id}" type="button" class="btn btn-sm btn-warning">修改</a>
                        <a href="/admin/tasks/delete/${task.id}" type="button" class="btn btn-sm btn-danger">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</rapid:override>
<script type="application/javascript">
    function submit_loginout() {
        $.ajax({
            type:"POST",
            url:"/admin/loginoutP",
            success:function(data){
                console.log("SUCCESS: ", data);
                window.location.href=data;
            },
        });
    }
</script>
<%@ include file="base/base.jsp"%>
