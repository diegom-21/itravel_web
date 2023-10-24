package pe.tecsup.itravel_cliente.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.tecsup.itravel_cliente.model.User;


@Controller
@RequestMapping("/registrar")
public class RegisterController {

    // URL del servicio para registrar un nuevo usuario en el servidor de la aplicación principal
    private static final String REGISTRAR_USUARIO_API = "http://localhost:8090/itravel/registrar/nuevoUsuario"; //POST
    @Autowired
    private RestTemplate restTemplate; //Permite consumir las API REST


    // Maneja la solicitud GET para el formulario de registro de un nuevo usuario
    @GetMapping("")
    public String nuevo(Model model) {
        model.addAttribute("nuevoUsuario", new User());
        return "registrar/nuevo"; // Asegúrate de que la vista HTML "nuevo.html" esté ubicada en la ubicación correcta.
    }


    // Maneja la solicitud POST para registrar un nuevo usuario
    @PostMapping("/nuevoUsuario")
    public String store(User nuevoUsuario, RedirectAttributes ra) {
        // Realiza una solicitud POST para registrar el nuevo usuario en el servidor principal
        restTemplate.postForEntity(REGISTRAR_USUARIO_API, nuevoUsuario, User.class);

        // Agrega un mensaje de éxito para mostrar al usuario
        ra.addFlashAttribute("msgExito", "Usuario registrado exitosamente");

        // Redirige a la página de inicio de sesión o a donde desees
        return "redirect:/login"; // Redirige a la página de inicio de sesión nuevamente o a la página deseada.
    }
}
