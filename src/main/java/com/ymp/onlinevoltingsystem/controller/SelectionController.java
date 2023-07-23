package com.ymp.onlinevoltingsystem.controller;

import com.ymp.onlinevoltingsystem.model.User;
import com.ymp.onlinevoltingsystem.service.SelectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author Yoon Myat Phoo
 * @created 7/20/2023
 * @project online-voting-system
 * @package com.ymp.onlinevotingsystem.controller
 */

@Controller
@Slf4j
public class SelectionController {

    @Autowired
    private SelectionService selectionService;

    public SelectionController(SelectionService selectionService) {
        this.selectionService = selectionService;
    }

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/leaderboard")
    public String getLeaderboard() {
        return "leaderboard";
    }

    @GetMapping("/preview")
    public String getPreview() {
        return "preview";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("saveRegister") User userModel,Model model) {
        log.info("Enter register method....");
        try{
            String response = selectionService.register(userModel);
            log.info("response: {}", response);
            if (response.equals("duplicate user")) {
                model.addAttribute("serverError", userModel.getEmail() + " already exists!");
                log.info("Exit register method ....");
                return "register";
            }
            else if(response.equals("input is empty")){
                model.addAttribute("inputError","input is empty");
                log.info("Exit register method .....");
                return "register";
            }
            else if(response.equals("Password and Confirmation Password do not match or input is empty")){
                model.addAttribute("passwordError","Password and Confirmation Password do not match");
                log.info("Exit register method .....");
                return "register";
            }
            model.addAttribute("successMessage", userModel.getEmail() + " is successfully added!");
            log.info("Exit register method....");
            return "register";
        }catch (Exception e){
            model.addAttribute("ServerError", e.toString());
            log.info("Exit register method....");
            return "error_page";
        }
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("login") User userModel, Model model) {
        log.info("Enter login method...");
       User user = selectionService.login(userModel);
        if (user != null) {
            return "leaderboard";
        } else {
            model.addAttribute("loginError", "Invalid credentials");
        }
        log.info("Exit login method...");
        return "login";
    }

}
