
package TravelGuide.controller;

import TravelGuide.entity.Utilizator;
import TravelGuide.service.UtilizatorService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserDashboardController {

    private final UtilizatorService utilizatorService;

    public UserDashboardController(UtilizatorService utilizatorService) {
        this.utilizatorService = utilizatorService;
    }

    @GetMapping("/cont")
    public String userDashboard(Authentication authentication, Model model) {

        Utilizator utilizator = utilizatorService
                .getUtilizatorByEmail(authentication.getName())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Utilizatorul nu a fost găsit"
                ));

        model.addAttribute("utilizator", utilizator);

        return "user-dashboard";
    }
}
