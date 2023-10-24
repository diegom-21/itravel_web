package pe.tecsup.itravel_cliente.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    // Maneja la solicitud GET para la página de inicio
    @GetMapping("")

    public String index(){
        return "index/index"; //la vista html
    }

}
