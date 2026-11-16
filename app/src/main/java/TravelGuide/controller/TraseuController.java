package TravelGuide.controller;

import TravelGuide.entity.Traseu;
import TravelGuide.service.TraseuService;
import TravelGuide.service.AtractieService;
import TravelGuide.service.MijlocTransportService;
import TravelGuide.service.OrasService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trasee")
public class TraseuController {

    private final TraseuService traseuService;
    private final AtractieService atractieService;
    private final MijlocTransportService mijlocTransportService;
    private final OrasService orasService;

    public TraseuController(
            TraseuService traseuService,
            AtractieService atractieService,
            MijlocTransportService mijlocTransportService,
            OrasService orasService) {

        this.traseuService = traseuService;
        this.atractieService = atractieService;
        this.mijlocTransportService = mijlocTransportService;
        this.orasService = orasService;
    }

    @GetMapping
    public String getAllTrasee(Model model) {
        model.addAttribute("trasee", traseuService.getAllTrasee());
        return "trasee/list";
    }

    @GetMapping("/nou")
    public String showAddForm(Model model) {
        model.addAttribute("traseu", new Traseu());
        addFormData(model);
        return "trasee/form";
    }

    @PostMapping("/salveaza")
    public String saveTraseu(@ModelAttribute Traseu traseu) {
        traseuService.saveTraseu(traseu);
        return "redirect:/trasee";
    }

    @GetMapping("/editeaza/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {

        Traseu traseu = traseuService.getTraseuById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Traseu invalid: " + id));

        model.addAttribute("traseu", traseu);
        addFormData(model);

        return "trasee/form";
    }

    @GetMapping("/sterge/{id}")
    public String deleteTraseu(@PathVariable Integer id) {
        traseuService.deleteTraseu(id);
        return "redirect:/trasee";
    }

    private void addFormData(Model model) {
        model.addAttribute("atractii", atractieService.getAllAtractii());
        model.addAttribute("transporturi",
                mijlocTransportService.getAllMijloaceTransport());
        model.addAttribute("orase", orasService.getAllOrase());
    }
}