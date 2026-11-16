
package TravelGuide.controller;

import TravelGuide.entity.MijlocTransport;
import TravelGuide.service.MijlocTransportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/transporturi")
public class MijlocTransportController {

    private final MijlocTransportService mijlocTransportService;

    public MijlocTransportController(
            MijlocTransportService mijlocTransportService) {
        this.mijlocTransportService = mijlocTransportService;
    }

    @GetMapping
    public String getAllTransporturi(Model model) {
        model.addAttribute("transporturi",
                mijlocTransportService.getAllMijloaceTransport());
        return "transporturi/list";
    }

    @GetMapping("/nou")
    public String showAddForm(Model model) {
        model.addAttribute("transport",
                new MijlocTransport());
        return "transporturi/form";
    }

    @PostMapping("/salveaza")
    public String saveTransport(
            @ModelAttribute("transport") MijlocTransport transport) {
        mijlocTransportService.saveMijlocTransport(transport);
        return "redirect:/transporturi";
    }

    @GetMapping("/editeaza/{id}")
    public String showEditForm(
            @PathVariable Integer id, Model model) {

        MijlocTransport transport = mijlocTransportService
                .getMijlocTransportById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Mijloc de transport invalid: " + id));

        model.addAttribute("transport", transport);
        return "transporturi/form";
    }

    @GetMapping("/sterge/{id}")
    public String deleteTransport(@PathVariable Integer id) {
        mijlocTransportService.deleteMijlocTransport(id);
        return "redirect:/transporturi";
    }
}
