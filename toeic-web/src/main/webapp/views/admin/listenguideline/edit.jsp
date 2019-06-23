<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url value="/admin-guideline-listen-edit.html" var="formUrl"/>
<html>
<head>
    <title><fmt:message key="label.guideline.listen.edit" bundle="${lang}"/></title>
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

                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#"><fmt:message key="label.home" bundle="${lang}"/></a>
                    </li>
                    <li class="active"><fmt:message key="label.guideline.listen.edit" bundle="${lang}"/></li>
                </ul><!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <c:if test="${not empty messageResponse}">
                            <div class="alert alert-block alert-${alert}">
                                <button type="button" class="close" data-dismiss="alert">
                                    <i class="ace-icon fa fa-times"></i>
                                    </button>
                                    ${messageResponse}
                            </div>
                        </c:if>
                        <%--<div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"></label>
                            <div class="col-sm-9">
                                <h2>This is a heading</h2>

                                <p>This is a paragraph.</p>
                                <p>This is another paragraph.</p>

                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"></label>
                            <div class="col-sm-9">
                                <button>Click me</button>
                            </div>
                        </div>--%>
                       <%-- <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"></label>
                            <div class="col-sm-9">
                                <input type="text" value="JSP-Servlet" id="value"/>
                            </div>
                        </div>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"></label>
                            <div class="col-sm-9">
                                <p id="showValue">Nothing in this</p>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"></label>
                            <div class="col-sm-9">
                                <button onclick="usingValAction()">Show Info</button>
                            </div>
                        </div>--%>
                        <%--<div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"></label>
                            <div class="col-sm-9">
                                <input type="checkbox" id="testCheckBox">
                            </div>
                        </div>--%>
                        <%--jQuery CSS() method--%>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"></label>
                            <div class="col-sm-9">
                                <p style="color: red" id="demoCSSMethod1">This is another paragraph.</p>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"></label>
                            <div class="col-sm-9">
                                <button id="demoCSSMethod" onclick="demoCSSMethod()">Change color text</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        $(document).ready(function(){
            hideAllWhenClickButton();
        });
        
        function hideAllWhenClickButton() {
            $("button").click(function () {
                $("p").hide();
            });
        }
        function usingValAction() {
            var value = $('#value').val();
            $('#showValue').html(value);
        }
        function demoCSSMethod() {
                $('#demoCSSMethod1').css("color", "blue");
        }

    </script>
</body>
</html>

