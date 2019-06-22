<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url value="/admin-guideline-listen-list.html" var="requestURI"/>
<c:url value="/admin-guideline-listen-edit.html" var="listenGuidelineEditUrl">
    <c:param name="urlType" value="url_edit"/>
</c:url>
<html>
<head>
    <title><fmt:message key="label.guideline.listen.list" bundle="${lang}"/></title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {

                }
            </script>
            <ul class="breadcrumbs">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#"><fmt:message key="label.home" bundle="${lang}"/> </a>
                </li>
                <li class="active"><fmt:message key="label.guideline.listen.list" bundle="${lang}"/></li>
            </ul><!-- /.breadcrumbs -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <a href="${listenGuidelineEditUrl}" type="button">Thêm bài hướng dẫn</a>
                    <c:if test="${not empty messageResponse}">
                        <div class="alert alert-block alert-${alert}">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                                ${messageResponse}
                        </div>
                    </c:if>
                    <div class="table-responsive">
                        <fmt:bundle basename="ApplicationResources">
                            <display:table id="tableList" name="items.listResult" partialList="true"
                                           size="${items.totalItems}" sort="external"
                                           pagesize="${items.maxPageItems}" requestURI="${requestURI}"
                                           class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                           style="margin: 3em 0 1.5em;">
                                <display:column property="title" titleKey="label.guideline.listen.title" sortable="true" sortName="title"/>
                                <display:column property="content" titleKey="label.guideline.listen.content" sortable="true" sortName="content"/>
                            </display:table>
                        </fmt:bundle>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
