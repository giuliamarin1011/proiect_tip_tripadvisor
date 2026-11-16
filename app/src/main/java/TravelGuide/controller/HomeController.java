
package TravelGuide.controller;

import TravelGuide.service.AtractieService;
import TravelGuide.service.OrasService;
import TravelGuide.service.RecenzieService;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final AtractieService atractieService;
    private final OrasService orasService;
    private final RecenzieService recenzieService;

    public HomeController(
            AtractieService atractieService,
            OrasService orasService,
            RecenzieService recenzieService) {

        this.atractieService = atractieService;
        this.orasService = orasService;
        this.recenzieService = recenzieService;
    }

    @GetMapping("/")
    public String home(Model model, Authentication authentication) {

        model.addAttribute("atractii",
                atractieService.getAllAtractii());

        model.addAttribute("orase",
                orasService.getAllOrase());

        // Incarcam toate recenziile pentru pagina principala
        model.addAttribute("recenzii",
                recenzieService.getAllRecenzii());

        boolean autentificat = authentication != null
                && authentication.isAuthenticated()
                && !"anonymousUser".equals(authentication.getPrincipal());

        boolean esteAdmin = autentificat
                && authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        boolean esteUser = autentificat
                && authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_USER"));

        boolean esteVisitor = !autentificat;

        model.addAttribute("isAdmin", esteAdmin);
        model.addAttribute("isUser", esteUser);
        model.addAttribute("isVisitor", esteVisitor);

        return "home";
    }
}
