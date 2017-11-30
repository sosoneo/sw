<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<rapid:override name="title">
    任务详情
</rapid:override>
<rapid:override name="content">
    <nav>
        <ul class="nav nav-tabs">
            <li role="presentation"><a href="/admin/tasks">任务管理列表</a></li>
            <li role="presentation" class="active"><a href="#">任务详情</a></li>
        </ul>
    </nav>
    <table class="table table-bordered table-striped">
        <tr>
            <th>ID</th>
            <td>${taskEntity.id}</td>
        </tr>
        <tr>
            <th>任务名称</th>
            <td>${taskEntity.title}</td>
        </tr>
        <tr>
            <th>任务链接</th>
            <td>${taskEntity.linkUrl}</td>
        </tr>
        <tr>
            <th>任务详情</th>
            <td>${taskEntity.info}</td>
        </tr>
    </table>
</rapid:override>
<%@ include file="base/base.jsp"%>
