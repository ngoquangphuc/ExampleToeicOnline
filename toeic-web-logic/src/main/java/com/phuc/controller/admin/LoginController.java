package com.phuc.controller.admin;

import com.phuc.command.UserCommand;
import com.phuc.core.dto.CheckLogin;
import com.phuc.core.dto.UserDTO;
import com.phuc.core.service.UserService;
import com.phuc.core.service.impl.UserServiceImpl;
import com.phuc.core.web.common.WebConstant;
import com.phuc.core.web.utils.FormUtil;
import com.phuc.core.web.utils.SingletonServiceUtil;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet("/login.html")
public class LoginController extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    ResourceBundle bundle = ResourceBundle.getBundle("ResourcesBundle");

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserCommand command = FormUtil.populate(UserCommand.class, request);
        UserDTO pojo = command.getPojo();
        if (pojo != null) {
            CheckLogin login = SingletonServiceUtil.getUserServiceInstance().checkLogin(pojo.getName(), pojo.getPassword());
            if (login.isUserExist()) {
                if (login.getRoleName().equals(WebConstant.ROLE_ADMIN)) {
                    response.sendRedirect("admin-home.html");
                } else if (login.getRoleName().equals(WebConstant.ROLE_USER)) {
                    response.sendRedirect("home.html");
                }
            } else {
                request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_ERROR);
                request.setAttribute(WebConstant.MESSAGE_RESPONSE, bundle.getString("lebel.name.password.wrong"));
                RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
                rd.forward(request, response);
            }
        }
    }
}
