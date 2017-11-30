package com.sosoneo.controller;

import com.sosoneo.model.TTaskEntity;
import com.sosoneo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by sosoneo on 2017/11/24.
 */
@Controller
public class MainController {
    @Autowired
    TaskRepository taskRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        List<TTaskEntity> taskList = taskRepository.findAll();
        modelMap.addAttribute("taskList", taskList);
        return "index";
    }
}
