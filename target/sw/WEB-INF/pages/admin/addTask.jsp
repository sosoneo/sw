<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<rapid:override name="title">
    添加任务
</rapid:override>
<rapid:override name="content">
    <nav>
        <ul class="nav nav-tabs">
            <li role="presentation"><a href="/admin/tasks">任务管理列表</a></li>
            <li role="presentation" class="active"><a href="/admin/addTask">添加任务</a></li>
        </ul>
    </nav>

    <form:form action="/admin/addTaskP" method="post" role="form" commandName="taskEntity" modelAttribute="taskEntity">
        <div class="form-group">
            <label for="title">任务名称:</label>
            <input id="title" name="title" type="text" class="form-control" placeholder="请输入任务名称"/>
            <div class="has-error">
                <form:errors path="title" class="help-inline"/>
            </div>
        </div>
        <div class="form-group">
            <label for="info">任务详情:</label>
            <input id="info" name="info" type="text" class="form-control" placeholder="请输入任务详情"/>
            <div class="has-error">
                <form:errors path="info" class="help-inline"/>
            </div>
        </div>
        <div class="form-group">
            <label for="linkUrl">任务链接:</label>
            <input id="linkUrl" name="linkUrl" type="text" class="form-control" placeholder="请输入任务链接"/>
            <div class="has-error">
                <form:errors path="linkUrl" class="help-inline"/>
            </div>
        </div>
        <div class="form-group">
            <label for="iconUrl">任务头像链接:</label>
            <input id="iconUrl" name="iconUrl" type="text" class="form-control" placeholder="请输入任务头像链接"/>
            <div class="has-error">
                <form:errors path="iconUrl" class="help-inline"/>
            </div>
        </div>
        <div class="form-group">
            <label for="bannerUrl">轮播图图像链接:</label>
            <input id="bannerUrl" name="bannerUrl" type="text" class="form-control" placeholder="请输入轮播图图像链接"/>
        </div>
        <div class="form-group">
            <label for="bannerTitle">轮播图标题:</label>
            <input id="bannerTitle" name="bannerTitle" type="text" class="form-control" placeholder="请输入轮播图标题"/>
        </div>
        <div class="form-group">
            <label for="bannerLinkUrl">轮播图指向链接:</label>
            <input id="bannerLinkUrl" name="bannerLinkUrl" type="text" class="form-control" placeholder="请输入轮播图指向链接"/>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">创建</button>
        </div>
    </form:form>
</rapid:override>
<%@ include file="base/base.jsp"%>
