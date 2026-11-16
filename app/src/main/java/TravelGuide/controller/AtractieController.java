package TravelGuide.controller;

import TravelGuide.entity.Atractie;
import TravelGuide.service.AtractieService;
import TravelGuide.service.OrasService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/atractii")
public class AtractieController {

    private final AtractieService atractieService;
    private final OrasService orasService;

    public AtractieController(AtractieService atractieService,
                              OrasService orasService) {
        this.atractieService = atractieService;
        this.orasService = orasService;
    }

    @GetMapping
    public String getAllAtractii(Model model) {
        model.addAttribute("atractii", atractieService.getAllAtractii());
        return "atractii/list";
    }

    @GetMapping("/nou")
    public String showAddForm(Model model) {
        model.addAttribute("atractie", new Atractie());
        model.addAttribute("orase", orasService.getAllOrase());
        return "atractii/form";
    }

    @PostMapping("/salveaza")
    public String saveAtractie(@ModelAttribute Atractie atractie) {
        atractieService.saveAtractie(atractie);
        return "redirect:/atractii";
    }

    @GetMapping("/editeaza/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Atractie atractie = atractieService.getAtractieById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Atractie invalida: " + id));

        model.addAttribute("atractie", atractie);
        model.addAttribute("orase", orasService.getAllOrase());

        return "atractii/form";
    }

    @GetMapping("/sterge/{id}")
    public String deleteAtractie(@PathVariable Integer id) {
        atractieService.deleteAtractie(id);
        return "redirect:/atractii";
    }
}