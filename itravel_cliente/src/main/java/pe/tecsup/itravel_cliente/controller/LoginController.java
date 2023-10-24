package pe.tecsup.itravel_cliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import pe.tecsup.itravel_cliente.model.User;

@Controller
@RequestMapping("/login")
public class LoginController {

    // URL del servicio de autenticación en el servidor de la aplicación principal
    private static final String LOGIN_API = "http://localhost:8090/itravel/login/auth"; //POST
    @Autowired
    private RestTemplate restTemplate;

    // Maneja la solicitud GET para la página de inicio de sesión
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("user", new User());
        return "login/index"; //la vista html
    }
    /*
    @PostMapping("")
    public String login(Model model, User user, RedirectAttributes ra){
        ResponseEntity<String> response = restTemplate.postForEntity(LOGIN_API, user, String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            ra.addFlashAttribute("msgExito", "Login exitoso");
            System.out.println("Login Exitoso");
        } else {
            ra.addFlashAttribute("msgError", "Error en el inicio de sesión");
            System.out.println("no exito");
        }
        return "login/index";
    }
    */

    // Maneja la solicitud POST para el inicio de sesión
    @PostMapping("")
    public String login(Model model, User user, RedirectAttributes ra) {
        ResponseEntity<String> response = restTemplate.postForEntity(LOGIN_API, user, String.class);

        HttpStatus statusCode = response.getStatusCode();

        if (statusCode.is2xxSuccessful()) {
            ra.addFlashAttribute("msgSuccess", "Login successful");
            ra.addFlashAttribute("email", user.getEmail());
            System.out.println("Login Exitoso");
            System.out.println("Email: " + user.getEmail());
            return "redirect:/login/welcome";

        } else if (statusCode == HttpStatus.UNAUTHORIZED) {
            ra.addFlashAttribute("msgError", "Invalid credentials");
            System.out.println("Error en las credenciales");
            return "redirect:/login/unauthorized-page";
        } else if (statusCode == HttpStatus.NOT_FOUND) {
            ra.addFlashAttribute("msgError", "User not found");
            System.out.println("No encontrado");
            return "redirect:/login/not-found-page";
        } else {
            ra.addFlashAttribute("msgError", "Internal server error");
            System.out.println("ERROR DE EL SERVIDOOOOR");
            return "redirect:/login/error-page";
        }
    }

    // Maneja la página de bienvenida después de un inicio de sesión exitoso
    @GetMapping("/welcome")
    public String welcome(@ModelAttribute("email") String email) {
        System.out.println("Email: " + email);
        return "login/welcome";
    }


    // Maneja la página de error de inicio de sesión no autorizado
    @GetMapping("/unauthorized-page")
    public String unauthorized(Model model) {
        System.out.println("Error en las credenciales");
        return "login/unauthorized-page";
    }

    // Maneja la página de error de usuario no encontrado
    @GetMapping("/not-found-page")
    public String notFound(Model model) {
        System.out.println("Usuario no encontrado");
        return "login/not-found-page";
    }

    // Maneja la página de error interno del servidor
    @GetMapping("/error-page")
    public String error(Model model) {
        return "login/error-page";
    }

    // Maneja las páginas de error generales
    @RequestMapping("/error")
    public String handleError(Model model) {
        // Agregar cualquier dato relacionado con errores necesario al modelo
        return "login/error-page"; // Reemplazar con la página HTML apropiada para el manejo de errores
    }



}

