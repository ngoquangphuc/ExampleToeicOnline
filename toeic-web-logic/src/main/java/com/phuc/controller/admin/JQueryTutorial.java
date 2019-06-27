package com.phuc.controller.admin;

import com.phuc.command.JqueryCommand;
import com.phuc.core.web.common.WebConstant;
import com.phuc.core.web.utils.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-closest-method.html", "/admin-find-method.html"})
public class JQueryTutorial extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JqueryCommand jqueryCommand = FormUtil.populate(JqueryCommand.class, request);
        if (jqueryCommand != null) {
            if (jqueryCommand.getUrlType().equals(WebConstant.URL_CLOSEST_METHOD)) {
                RequestDispatcher rd = request.getRequestDispatcher("/views/jquery_tutorial/closestMethod.jsp");
                rd.forward(request, response);
            }
            if (jqueryCommand.getUrlType().equals(WebConstant.URL_FIND_METHOD)) {
                RequestDispatcher rd = request.getRequestDispatcher("/views/jquery_tutorial/findMethod.jsp");
                rd.forward(request, response);
            }
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
