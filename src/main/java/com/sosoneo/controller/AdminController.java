package com.sosoneo.controller;

import com.sosoneo.interceptor.LoginCheck;
import com.sosoneo.model.TAdminUserEntity;
import com.sosoneo.model.TTaskEntity;
import com.sosoneo.repository.AdminUserRepository;
import com.sosoneo.repository.TaskRepository;
import javafx.scene.control.Cell;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.ValidationMode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by sosoneo on 2017/11/24.
 */
@Controller
public class AdminController {
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    AdminUserRepository adminUserRepository;

    @RequestMapping(value = "/admin/tasks", method = RequestMethod.GET)
    @LoginCheck
    public String getTasks(ModelMap modelMap, HttpSession session) {
        List<TTaskEntity> taskList = taskRepository.findAll();
        modelMap.addAttribute("taskList", taskList);
        modelMap.addAttribute("username", session.getAttribute("username"));
        return "/admin/tasks";
    }

    @RequestMapping(value = "/admin/addTask", method = RequestMethod.GET)
    @LoginCheck
    public String addTask(ModelMap modelMap) {
        if(!modelMap.containsAttribute("taskEntity")){
            modelMap.addAttribute("taskEntity", new TTaskEntity());
        }
        return "/admin/addTask";
    }

    @RequestMapping(value = "/admin/addTaskP", method = RequestMethod.POST)
    @LoginCheck
    public String addTaskP(ModelMap modelMap, @Valid @ModelAttribute("taskEntity") TTaskEntity taskEntity, BindingResult result) throws NoSuchAlgorithmException {
        if (result.hasErrors()) {
            return addTask(modelMap);
        }else {
            taskRepository.saveAndFlush(taskEntity);
            return "redirect:/admin/tasks";
        }
    }

    @RequestMapping(value = "/admin/tasks/show/{id}", method = RequestMethod.GET)
    @LoginCheck
    public String taskDetail(@PathVariable("id") Integer taskId,ModelMap modelMap) {
        TTaskEntity taskEntity = taskRepository.findOne(taskId);
        modelMap.addAttribute("taskEntity", taskEntity);
        return "/admin/taskDetail";
    }

    @RequestMapping(value = "/admin/tasks/delete/{id}", method = RequestMethod.GET)
    @LoginCheck
    public String taskDelete(@PathVariable("id") Integer taskId, ModelMap modelMap) {
        taskRepository.delete(taskId);
        taskRepository.flush();
        return "redirect:/admin/tasks";
    }

    @RequestMapping(value = "/admin/tasks/update/{id}", method = RequestMethod.GET)
    @LoginCheck
    public String updateTask(@PathVariable("id") Integer taskId, ModelMap modelMap) {
        TTaskEntity taskEntity = taskRepository.findOne(taskId);
        modelMap.addAttribute("taskEntity", taskEntity);
        return "/admin/updateTask";
    }

    @RequestMapping(value = "/admin/updateTaskP", method = RequestMethod.POST)
    @LoginCheck
    public String updateTaskP(ModelMap modelMap, @Valid @ModelAttribute("taskEntity") TTaskEntity taskEntity, BindingResult result) throws NoSuchAlgorithmException {
        if (result.hasErrors()) {
            return updateTask(taskEntity.getId(),modelMap);
        }else {
            taskRepository.updateTask(taskEntity.getTitle(),taskEntity.getInfo(),taskEntity.getLinkUrl(),
                    taskEntity.getIconUrl(),taskEntity.getBannerUrl(),taskEntity.getBannerTitle(),
                    taskEntity.getBannerLinkUrl(),taskEntity.getId());
            return "redirect:/admin/tasks/show/"+Integer.toString(taskEntity.getId());
        }
    }

    @RequestMapping(value = "/admin/login", method = RequestMethod.GET)
    public String adminLogin(ModelMap modelMap, @Param("errorMessage") String errorMessage) {
        if (errorMessage!= null && errorMessage.length()>0) {
            modelMap.addAttribute("errorMessage",errorMessage);
        }
        return "/admin/login";
    }

    @RequestMapping(value = "/admin/loginP", method = RequestMethod.POST)
    public String adminLoginP(HttpServletRequest httpServletRequest, RedirectAttributes attr, @Valid @ModelAttribute("userEntity") TAdminUserEntity adminUserEntity, BindingResult result) throws  NoSuchAlgorithmException {
        if (result.hasErrors()) {
            attr.addFlashAttribute("errorMessage", "登录出错");
            return "redirect:/admin/login";
        }else {
            TAdminUserEntity qAdminUserEntity = adminUserRepository.getAdminUserByUsernameAndPassword(adminUserEntity.getUsername(), adminUserEntity.getPassword());
            System.out.println(qAdminUserEntity);
            if (qAdminUserEntity==null) {
                attr.addFlashAttribute("errorMessage", "用户名或密码错误");
                return "redirect:/admin/login";
            }else {
                HttpSession session = httpServletRequest.getSession();
                session.setAttribute("username", qAdminUserEntity.getUsername());
                return "redirect:/admin/tasks";
            }
        }
    }

    @RequestMapping(value = "/admin/loginoutP", method = RequestMethod.POST)
    @ResponseBody
    @LoginCheck
    public String adminLoginout(HttpSession session) {
        session.removeAttribute("username");
        return "/admin/login";
    }
}
