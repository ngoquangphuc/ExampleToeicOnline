package com.phuc.controller.admin;

import com.phuc.command.UserCommand;
import com.phuc.core.dto.RoleDTO;
import com.phuc.core.dto.UserDTO;
import com.phuc.core.service.RoleService;
import com.phuc.core.service.UserService;
import com.phuc.core.service.impl.RoleServiceImpl;
import com.phuc.core.service.impl.UserServiceImpl;
import com.phuc.core.web.common.WebConstant;
import com.phuc.core.web.utils.FormUtil;
import com.phuc.core.web.utils.WebCommonUtil;
import org.apache.log4j.Logger;

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
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/admin-user-list.html", "/ajax-admin-user-edit.html"})
public class UserController extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    UserService userService = new UserServiceImpl();
    RoleService roleService = new RoleServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserCommand userCommand = FormUtil.populate(UserCommand.class, request);
        UserDTO pojo = userCommand.getPojo();
        ResourceBundle bundle = ResourceBundle.getBundle("ApplicationResources");
        if (userCommand.getUrlType() != null && userCommand.getUrlType().equals(WebConstant.URL_LIST)) {
            Map<String, Object> mapProperty = new HashMap<String, Object>();
            Object[] objects = userService.findByProperty(mapProperty, userCommand.getSortExpression(), userCommand.getSortDirection(), userCommand.getFirstItem(), userCommand.getMaxPageItems());
            userCommand.setListResult((List<UserDTO>) objects[1]);
            userCommand.setTotalItems(Integer.parseInt(objects[0].toString()));
            request.setAttribute(WebConstant.LIST_ITEMS, userCommand);
            if (userCommand.getCrudaction() != null) {
                Map<String, String> mapMessage = buildMapRedirectMessage(bundle);
                WebCommonUtil.addRedirectMessage(request, userCommand.getCrudaction(), mapMessage);
            }
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/list.jsp");
            rd.forward(request, response);
        } else if (userCommand.getUrlType() != null && userCommand.getUrlType().equals(WebConstant.URL_EDIT)) {
            if (pojo != null && pojo.getUserId() != null) {
                userCommand.setPojo(userService.findById(pojo.getUserId()));
            }
            userCommand.setRoles(roleService.findAll());
            request.setAttribute(WebConstant.FORM_ITEM, userCommand);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/edit.jsp");
            rd.forward(request, response);
        }
    }

    private Map<String, String> buildMapRedirectMessage(ResourceBundle bundle) {
        Map<String, String> mapMessage = new HashMap<String, String>();
        mapMessage.put(WebConstant.REDIRECT_INSERT, bundle.getString("lebel.user.message.add.success"));
        mapMessage.put(WebConstant.REDIRECT_UPDATE, bundle.getString("lebel.user.message.update.success"));
        mapMessage.put(WebConstant.REDIRECT_DELETE, bundle.getString("lebel.user.message.delete.success"));
        mapMessage.put(WebConstant.REDIRECT_ERROR, bundle.getString("lebel.message.error"));
        return mapMessage;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UserCommand userCommand = FormUtil.populate(UserCommand.class, request);
            UserDTO pojo = userCommand.getPojo();
            if (userCommand.getUrlType().equals(WebConstant.URL_EDIT)) {
                if (userCommand.getCrudaction() != null && userCommand.getCrudaction().equals(WebConstant.INSERT_UPDATE)) {
                    RoleDTO roleDTO = new RoleDTO();
                    roleDTO.setRoleId(userCommand.getRoleId());
                    pojo.setRoleDTO(roleDTO);
                    if (pojo != null && pojo.getUserId() != null) {
                        //update user
                        userService.updateUser(pojo);
                        request.setAttribute(WebConstant.MESSAGE_RESPONSE, WebConstant.REDIRECT_UPDATE);
                    } else {
                        //save user
                        userService.saveUser(pojo);
                        request.setAttribute(WebConstant.MESSAGE_RESPONSE, WebConstant.REDIRECT_INSERT);
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            request.setAttribute(WebConstant.MESSAGE_RESPONSE, WebConstant.TYPE_ERROR);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/edit.jsp");
        rd.forward(request, response);
    }
}
