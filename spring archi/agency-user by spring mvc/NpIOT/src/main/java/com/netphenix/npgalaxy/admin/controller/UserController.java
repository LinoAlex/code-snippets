/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netphenix.npgalaxy.admin.controller;

import com.netphenix.npgalaxy.admin.service.UserService;
import com.netphenix.npgalaxy.bean.LoginUserBean;
import com.netphenix.npgalaxy.bean.Permission;
import com.netphenix.npgalaxy.controller.BaseController;
import com.netphenix.npgalaxy.model.Account;
import com.netphenix.npgalaxy.model.Agency;
import com.netphenix.npgalaxy.model.AgencyLicence;
import com.netphenix.npgalaxy.model.AgencyProduct;
import com.netphenix.npgalaxy.model.AgencySettings;
import com.netphenix.npgalaxy.model.Property;
import com.netphenix.npgalaxy.model.UserAccount;
import com.netphenix.npgalaxy.model.VbUser;
import com.netphenix.npgalaxy.utils.VbUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author jp
 */
@Controller
@CrossOrigin(origins = {"*"})
@RequestMapping("user")
public class UserController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "test", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Map test(HttpServletRequest request, HttpServletResponse response) {
        Map returnMap = new HashMap();
        returnMap.put("status", "Success");
        return returnMap;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    VbUser create(HttpServletRequest request, HttpServletResponse response, @RequestBody VbUser teUser) {
        return userService.create(teUser);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody
    VbUser update(HttpServletRequest request, HttpServletResponse response, @RequestBody VbUser teUser) {
        return userService.update(teUser);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List read(HttpServletRequest request, HttpServletResponse response) {
        return userService.read();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    VbUser read(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer id) {
        return userService.read(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody
    VbUser delete(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer id) {
        return userService.delete(id);
    }

//    @RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json")
//    public @ResponseBody
//    Map login(HttpServletRequest request, HttpServletResponse response, @RequestBody LoginUserBean loginUserBean) {
//        SecurityAuthBean authData = userService.getPermissions(loginUserBean);
//        //LoginUserBean userBean = userService.authenicate(loginUserBean);
//        HttpSession session = request.getSession();
//
//        session.setAttribute("isAuthenticated", authData != null);
//        if (authData == null) {
//            Map returnMap = new HashMap();
//            returnMap.put("authData", null);
//            returnMap.put("errorMessage", "Login Failed");
//            return returnMap;
//        }
//        VbUser user = userService.createNewUser(authData);
//        session.setAttribute("userId", user.getId());
//        session.setAttribute("username", authData.getUserName());
//        session.setAttribute("accessToken", authData.getAccessToken());
//        session.setAttribute("permission", authData.getPermission());
//        session.setAttribute("userGuid", authData.getUserGuid());
//        Map returnMap = new HashMap();
//        returnMap.put("authData", authData);
//        returnMap.put("dealers", new ArrayList<>());
//        return returnMap;
//    }
    @RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    LoginUserBean login(HttpServletRequest request, HttpServletResponse response, @RequestBody LoginUserBean loginUserBean) {
        HttpSession session = request.getSession();
        Object agencyPathObject = session.getAttribute("agencyPath");
        String agencyPath = null;
        if (agencyPathObject != null) {
            agencyPath = agencyPathObject + "";
        }
        if (agencyPath != null && !agencyPath.equalsIgnoreCase("")) {
            loginUserBean.setAgencyPath(agencyPath);
        }
        System.out.println("login user bean------->"+loginUserBean);
        LoginUserBean userBean = userService.authenicate(loginUserBean);
        
        LOGGER.debug("userBean object---->"+userBean);

        session.setAttribute("isAuthenticated", userBean.getAuthenticated());
        session.setAttribute("username", userBean.getUsername());
        session.setAttribute("agencyId", userBean.getAgencyId());
        session.setAttribute("id", userBean.getId());
        if (userBean != null && userBean.getUsername() != null && userBean.getAuthenticated()) {
            VbUser user = userService.findByUsername(userBean.getUsername());
            userBean.setPermission(VbUtils.getPermissions(user, userService.getUserPermissionById(user.getId())));
            session.setAttribute("permission", userBean.getPermission());
        }
        return userBean;
    }

    @RequestMapping(value = "getPermission", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    LoginUserBean getPermission(HttpServletRequest request, HttpServletResponse response) {
        String user = getUser(request);
        LoginUserBean loginUserBean = new LoginUserBean();
        loginUserBean.setUsername(user);
        loginUserBean.setPermission((Permission) request.getSession().getAttribute("permission"));
        return loginUserBean;
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("../../login.html");
    }

    @RequestMapping(value = "account", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Object createAccount(HttpServletRequest request, HttpServletResponse response, @RequestBody Account account) {
        if (account.getAgencyId() == null) {
            VbUser loggedInUser = userService.findByUsername(getUser(request));
            account.setAgencyId(loggedInUser.getAgencyId());
        }
        return userService.createAccount(account);
    }

    @RequestMapping(value = "account", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody
    Account updateAccount(HttpServletRequest request, HttpServletResponse response, @RequestBody Account account) {
        return userService.updateAccount(account);
    }

    @RequestMapping(value = "account", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Account> getAccount(HttpServletRequest request, HttpServletResponse response) {
        VbUser loggedInUser = userService.findByUsername(getUser(request));
        if (loggedInUser.getAgencyId() == null) {
            return userService.getAccount();
        }
        return userService.getAccount(loggedInUser.getAgencyId());
    }

    @RequestMapping(value = "account/{accountId}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody
    Account deleteAccount(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer accountId) {
        return userService.deleteAccount(accountId);
    }

    @RequestMapping(value = "property", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Property createProperty(HttpServletRequest request, HttpServletResponse response, @RequestBody Property property) {
        return userService.createProperty(property);
    }

    @RequestMapping(value = "property", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody
    Property updateProperty(HttpServletRequest request, HttpServletResponse response, @RequestBody Property property) {
        return userService.updateProperty(property);
    }

    @RequestMapping(value = "property", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List getProperty(HttpServletRequest request, HttpServletResponse response) {
        return userService.getProperty();
    }

    @RequestMapping(value = "property/{accountId}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List getPropertyByAccountId(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer accountId) {
        return userService.getPropertyByAccountId(accountId);
    }

    @RequestMapping(value = "property/{propertyId}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody
    Property deleteProperty(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer propertyId) {
        return userService.deleteProperty(propertyId);
    }

    @RequestMapping(value = "userAccount", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    UserAccount createUserAccount(HttpServletRequest request, HttpServletResponse response, @RequestBody UserAccount userAccount) {
        return userService.createUserAccount(userAccount);
    }

    @RequestMapping(value = "userAccount", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody
    UserAccount updateUserAccount(HttpServletRequest request, HttpServletResponse response, @RequestBody UserAccount userAccount) {
        return userService.updateUserAccount(userAccount);
    }

    @RequestMapping(value = "userAccount", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List getUserAccount(HttpServletRequest request, HttpServletResponse response) {
        return userService.getUserAccount();
    }

    @RequestMapping(value = "userAccount/{accountId}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List getUserAccountById(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer accountId) {
        return userService.getUserAccountById(accountId);
    }

    @RequestMapping(value = "userAccount/{userAccountId}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody
    UserAccount deleteUserAccount(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer userAccountId) {
        return userService.deleteUserAccount(userAccountId);
    }

    @RequestMapping(value = "agency", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Object createAgency(HttpServletRequest request, HttpServletResponse response, @RequestBody Agency agency) {

        return userService.createAgency(agency);
    }

    @RequestMapping(value = "agency", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody
    Agency updateAgency(HttpServletRequest request, HttpServletResponse response, @RequestBody Agency agency) {
        return userService.updateAgency(agency);
    }

    @RequestMapping(value = "agency", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List getAgency(HttpServletRequest request, HttpServletResponse response) {
        return userService.getAgency();
    }

    @RequestMapping(value = "agency/{agencyId}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody
    Agency deleteAgency(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer agencyId) {
        return userService.deleteAgency(agencyId);
    }

    @RequestMapping(value = "agencyLicence", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    AgencyLicence createAgencyLicence(HttpServletRequest request, HttpServletResponse response, @RequestBody AgencyLicence agencyLicence) {
        return userService.createAgencyLicence(agencyLicence);
    }

    @RequestMapping(value = "agencyLicence", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody
    AgencyLicence updateAgencyLicence(HttpServletRequest request, HttpServletResponse response, @RequestBody AgencyLicence agencyLicence) {
        return userService.updateAgencyLicence(agencyLicence);
    }

    @RequestMapping(value = "agencyLicence", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List getAgencyLicence(HttpServletRequest request, HttpServletResponse response) {
        return userService.getAgencyLicence();
    }

    @RequestMapping(value = "agencyLicence/{agencyId}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List getAgencyLicenceById(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer agencyId) {
        return userService.getAgencyLicenceById(agencyId);
    }

    @RequestMapping(value = "agencyLicence/{agencyLicenceId}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody
    Agency deleteAgencyLicence(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer agencyLicenceId) {
        return userService.deleteAgencyLicence(agencyLicenceId);
    }

    @RequestMapping(value = "agencyUser/{agencyUserId}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List getAgencyUserById(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer agencyUserId) {
        return userService.getAgencyUserById(agencyUserId);
    }

    @RequestMapping(value = "agencyProduct", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    AgencyProduct createAgencyProduct(HttpServletRequest request, HttpServletResponse response, @RequestBody AgencyProduct agencyProduct) {
        return userService.createAgencyProduct(agencyProduct);
    }

    @RequestMapping(value = "agencyProduct", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody
    AgencyProduct updateAgencyProduct(HttpServletRequest request, HttpServletResponse response, @RequestBody AgencyProduct agencyProduct) {
        return userService.updateAgencyProduct(agencyProduct);
    }

    @RequestMapping(value = "agencyProduct/{agencyProductId}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List getAgencyProductById(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer agencyProductId) {
        return userService.getAgencyProductById(agencyProductId);
    }

    @RequestMapping(value = "productUpdateOrder/{agencyProductId}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Object updateWidgetUpdateOrder(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer agencyProductId) {
        String productOrder = request.getParameter("productOrder");
         LOGGER.debug("product order------>"+productOrder);
        userService.productUpdateOrder(agencyProductId, productOrder);
        return null;
    }

    @RequestMapping(value = "agencyProduct/{agencyProductId}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody
    AgencyProduct deleteAgencyProductId(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer agencyProductId) {
        return userService.deleteAgencyProductId(agencyProductId);
    }

    @RequestMapping(value = "agencySetting", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    AgencySettings createAgencySettings(HttpServletRequest request, HttpServletResponse response, @RequestBody AgencySettings agencySettings) {

        return userService.createAgencySettings(agencySettings);
    }

    @RequestMapping(value = "agencySetting", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody
    AgencySettings updateAgencySettings(HttpServletRequest request, HttpServletResponse response, @RequestBody AgencySettings agencySettings) {
        return userService.updateAgencySettings(agencySettings);
    }

    @RequestMapping(value = "agencySetting/{agencyId}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    AgencySettings getAgencySettingsById(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer agencyId) {
        return userService.getAgencySettingsById(agencyId);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handle(HttpMessageNotReadableException e) {
        e.printStackTrace();
    }
}
