<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<style>
    .list-row {
        width: 100%;
        height: 80px;
        border-bottom: solid 1px;
    }
    .list-row-id {
        float: left;
        font-size: 18px;
        font-weight: bold;
        margin-top: 20px;
        margin-left: 2%;
        margin-right: 2%;
        text-align: center;
    }
    .list-row-icon {
        float: left;
        margin-top: 15px;
    }
    .list-row-box {
        float: left;
        margin-top: 10px;
        margin-left: 20px;
    }
    .list-row-box-title {
        font-size: 14px;
    }
    .list-row-box-info {
        font-size: 12px;
    }
    .list-row-box-join {
        font-size: 10px;
    }
</style>
<rapid:override name="title">
    苹果平台
</rapid:override>
<rapid:override name="content">
    <c:if test="${!empty taskList}">
        <% int rankInt=1; %>
        <c:forEach items="${taskList}" var="task">
            <a href="${task.linkUrl}">
                <div class="list-row">
                    <div class="list-row-id">
                        <%= rankInt %>
                        <%rankInt++;%>
                    </div>
                    <div class="list-row-icon">
                        <img src="/resources/static/img/${task.iconUrl}" width="50px" height="50px">
                    </div>
                    <div class="list-row-box">
                        <div class="list-row-box-title">
                            ${task.title}
                        </div>
                        <div class="list-row-box-info">
                            ${task.info}
                        </div>
                        <div class="list-row-box-join">
                            已有62341人加入
                        </div>
                        <%--<button type="button" class="btn btn-default">加入</button>--%>
                    </div>
                </div>
            </a>
        </c:forEach>
    </c:if>
</rapid:override>
<%@ include file="admin/base/base.jsp"%>

