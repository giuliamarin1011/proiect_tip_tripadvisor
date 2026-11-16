
package TravelGuide.controller;

import TravelGuide.entity.Utilizator;
import TravelGuide.service.UtilizatorService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/utilizatori")
public class UtilizatorController {

    private final UtilizatorService utilizatorService;

    public UtilizatorController(UtilizatorService utilizatorService) {
        this.utilizatorService = utilizatorService;
    }

    @GetMapping
    public String getAllUtilizatori(Model model) {
        model.addAttribute("utilizatori",
                utilizatorService.getAllUtilizatori());

        return "utilizatori/list";
    }

    @GetMapping("/nou")
    public String showAddForm(Model model) {
        model.addAttribute("utilizator", new Utilizator());

        return "utilizatori/form";
    }

    @PostMapping("/salveaza")
    public String saveUtilizator(
            @ModelAttribute Utilizator utilizator,
            @RequestParam(required = false) String parola) {

        if (utilizator.getIdUtilizator() != null) {

            Utilizator existent = utilizatorService
                    .getUtilizatorById(utilizator.getIdUtilizator())
                    .orElseThrow(() ->
                            new IllegalArgumentException(
                                    "Utilizator invalid"));

            existent.setNume(utilizator.getNume());
            existent.setEmail(utilizator.getEmail());

            // Rolul existent nu se modifică
            utilizatorService.saveUtilizator(existent, parola);

        } else {

            if (parola == null || parola.isBlank()) {
                return "redirect:/utilizatori/nou";
            }

            // Orice utilizator nou primește rolul USER
            utilizator.setRol("USER");

            utilizatorService.saveUtilizator(utilizator, parola);
        }

        return "redirect:/utilizatori";
    }

    @GetMapping("/editeaza/{id}")
    public String showEditForm(
            @PathVariable Integer id,
            Model model) {

        Utilizator utilizator = utilizatorService
                .getUtilizatorById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Utilizator invalid: " + id));

        model.addAttribute("utilizator", utilizator);

        return "utilizatori/form";
    }

    @PostMapping("/sterge/{id}")
    public String deleteUtilizator(@PathVariable Integer id) {

        utilizatorService.deleteUtilizator(id);

        return "redirect:/utilizatori";
    }
}
