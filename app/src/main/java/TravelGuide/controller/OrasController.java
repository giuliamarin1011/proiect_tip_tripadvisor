
package TravelGuide.controller;

import TravelGuide.entity.Oras;
import TravelGuide.service.OrasService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orase")
public class OrasController {

    private final OrasService orasService;

    public OrasController(OrasService orasService) {
        this.orasService = orasService;
    }

    @GetMapping
    public String getAllOrase(Model model) {
        model.addAttribute("orase", orasService.getAllOrase());
        return "orase/list";
    }

    @GetMapping("/nou")
    public String showAddForm(Model model) {
        model.addAttribute("oras", new Oras());
        return "orase/form";
    }

    @PostMapping("/salveaza")
    public String saveOras(
            @Valid @ModelAttribute("oras") Oras oras,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "orase/form";
        }

        orasService.saveOras(oras);
        return "redirect:/orase";
    }

    @GetMapping("/editeaza/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Oras oras = orasService.getOrasById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Oras invalid: " + id));

        model.addAttribute("oras", oras);
        return "orase/form";
    }

    @GetMapping("/sterge/{id}")
    public String deleteOras(@PathVariable Integer id) {
        orasService.deleteOras(id);
        return "redirect:/orase";
    }
}
