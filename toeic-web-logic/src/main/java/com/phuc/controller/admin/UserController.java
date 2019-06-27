package com.phuc.controller.admin;

import com.phuc.command.UserCommand;
import com.phuc.core.dto.UserDTO;
import com.phuc.core.service.UserService;
import com.phuc.core.service.impl.UserServiceImpl;
import com.phuc.core.web.common.WebConstant;
import com.phuc.core.web.utils.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = {"/admin-user-list.html"})
public class UserController extends HttpServlet {
    UserService userService = new UserServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserCommand userCommand = FormUtil.populate(UserCommand.class, request);
        UserDTO pojo = userCommand.getPojo();
        if (userCommand.getUrlType().equals(WebConstant.URL_LIST)) {
            Map<String, Object> mapProperty = new HashMap<String, Object>();
            Object[] objects = userService.findByProperty(mapProperty, userCommand.getSortExpression(), userCommand.getSortDirection(), userCommand.getFirstItem(), userCommand.getMaxPageItems());
            userCommand.setListResult((List<UserDTO>) objects[1]);
            userCommand.setTotalItems(Integer.parseInt(objects[0].toString()));
            request.setAttribute(WebConstant.LIST_ITEMS, userCommand);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/list.jsp");
            rd.forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
