package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

@Controller
public class AuthenticationController {
    private AuthenticationService service;

    @Autowired
    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @GetMapping("/sign-in")
    public String signin(Model model) {
      return "signin";
    }

    @PostMapping("/sign-in")
    public String signin(@RequestParam("login_id") String login_id, @RequestParam("password") String password, Model model) {
      if(service.signin(login_id, password)){
        model.addAttribute("message", "アカウントの登録に成功しました");
        return "message";
      }else{
        model.addAttribute("message", "アカウントの登録に失敗しました");
        return "signin";
      }
    }

    @GetMapping("/sign-on")
    public String signon(Model model) {
      return "signon";
    }

    @PostMapping("/sign-on")
    public String signon(@RequestParam("login_id") String login_id, @RequestParam("password") String password, Model model) {
      if(service.signon(login_id, password)){
        model.addAttribute("message", "ログインに成功しました");
        return "message";
      }else{
        model.addAttribute("message", "ログインに失敗しました");
        return "signon";
      }
    }

}
