
package TravelGuide.controller;

import TravelGuide.entity.Recenzie;
import TravelGuide.entity.Utilizator;
import TravelGuide.service.RecenzieService;
import TravelGuide.service.UtilizatorService;
import TravelGuide.service.AtractieService;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/recenzii")
public class RecenzieController {

    private final RecenzieService recenzieService;
    private final UtilizatorService utilizatorService;
    private final AtractieService atractieService;

    public RecenzieController(
            RecenzieService recenzieService,
            UtilizatorService utilizatorService,
            AtractieService atractieService) {

        this.recenzieService = recenzieService;
        this.utilizatorService = utilizatorService;
        this.atractieService = atractieService;
    }

    // Afisarea recenziilor in functie de rol
    @GetMapping
    public String getAllRecenzii(
            Model model,
            Authentication authentication) {

        boolean autentificat = authentication != null
                && authentication.isAuthenticated()
                && !"anonymousUser".equals(authentication.getPrincipal());

        boolean esteAdmin = autentificat
                && authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        boolean esteUser = autentificat
                && authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_USER"));

        if (esteAdmin || !autentificat) {

            // ADMIN si VISITOR vad toate recenziile
            model.addAttribute(
                    "recenzii",
                    recenzieService.getAllRecenzii()
            );

        } else if (esteUser) {

            // USER vede doar recenziile proprii
            Utilizator utilizatorCurent = utilizatorService
                    .getUtilizatorByEmail(authentication.getName())
                    .orElseThrow(() ->
                            new IllegalArgumentException("Utilizator inexistent"));

            model.addAttribute(
                    "recenzii",
                    recenzieService.getRecenziiByUtilizator(
                            utilizatorCurent.getIdUtilizator()
                    )
            );
        }

        model.addAttribute("isAdmin", esteAdmin);
        model.addAttribute("isUser", esteUser);

        return "recenzii/list";
    }

    // Formular pentru adaugarea unei recenzii
    @GetMapping("/nou")
    public String showAddForm(Model model) {

        model.addAttribute("recenzie", new Recenzie());
        model.addAttribute("atractii", atractieService.getAllAtractii());

        return "recenzii/form";
    }

    // Salvarea unei recenzii
    @PostMapping("/salveaza")
    public String saveRecenzie(
            @ModelAttribute Recenzie recenzie,
            Authentication authentication) {

        Utilizator utilizatorCurent = utilizatorService
                .getUtilizatorByEmail(authentication.getName())
                .orElseThrow(() ->
                        new IllegalArgumentException("Utilizator inexistent"));

        if (recenzie.getIdRecenzie() != null) {

            // Doar ADMIN poate modifica o recenzie existenta
            Recenzie existenta = recenzieService
                    .getRecenzieById(recenzie.getIdRecenzie())
                    .orElseThrow(() ->
                            new IllegalArgumentException("Recenzie inexistenta"));

            verificaAcces(existenta, utilizatorCurent);

            // Pastram autorul original
            recenzie.setUtilizator(existenta.getUtilizator());

        } else {

            // La adaugare, autorul este utilizatorul autentificat
            recenzie.setUtilizator(utilizatorCurent);
        }

        recenzieService.saveRecenzie(recenzie);

        return "redirect:/recenzii";
    }

    // Formular pentru editarea unei recenzii
    @GetMapping("/editeaza/{id}")
    public String showEditForm(
            @PathVariable Integer id,
            Model model,
            Authentication authentication) {

        Recenzie recenzie = recenzieService
                .getRecenzieById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Recenzie inexistenta"));

        Utilizator utilizatorCurent = utilizatorService
                .getUtilizatorByEmail(authentication.getName())
                .orElseThrow(() ->
                        new IllegalArgumentException("Utilizator inexistent"));

        verificaAcces(recenzie, utilizatorCurent);

        model.addAttribute("recenzie", recenzie);
        model.addAttribute("atractii", atractieService.getAllAtractii());

        return "recenzii/form";
    }

    // Stergerea unei recenzii
    @PostMapping("/sterge/{id}")
    public String deleteRecenzie(
            @PathVariable Integer id,
            Authentication authentication) {

        Recenzie recenzie = recenzieService
                .getRecenzieById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Recenzie inexistenta"));

        Utilizator utilizatorCurent = utilizatorService
                .getUtilizatorByEmail(authentication.getName())
                .orElseThrow(() ->
                        new IllegalArgumentException("Utilizator inexistent"));

        verificaAcces(recenzie, utilizatorCurent);

        recenzieService.deleteRecenzie(id);

        return "redirect:/recenzii";
    }

    // Verificam daca utilizatorul are drepturi de ADMIN
    private void verificaAcces(
            Recenzie recenzie,
            Utilizator utilizator) {

        if (!"ADMIN".equals(utilizator.getRol())) {
            throw new AccessDeniedException(
                    "Nu ai permisiunea de a modifica sau sterge recenzii."
            );
        }
    }
}
