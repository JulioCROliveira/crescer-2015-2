package br.com.cwi.crescer.lavanderia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {

    @RequestMapping("/")
    public String index(Model model) {
        String mensagem = "Bem vindo, Lavanderia Crescer";
        model.addAttribute("mensagem", mensagem);

        return "index";
    }
}
