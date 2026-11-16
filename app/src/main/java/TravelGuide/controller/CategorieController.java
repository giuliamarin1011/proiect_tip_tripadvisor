
package TravelGuide.controller;

import TravelGuide.entity.Categorie;
import TravelGuide.service.CategorieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorii")
public class CategorieController {

    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    // Afisarea tuturor categoriilor
    @GetMapping
    public String getAllCategorii(Model model) {
        model.addAttribute("categorii", categorieService.getAllCategorii());
        return "categorii/list";
    }

    // Formular pentru adaugarea unei categorii
    @GetMapping("/nou")
    public String showAddForm(Model model) {
        model.addAttribute("categorie", new Categorie());
        return "categorii/form";
    }

    // Salvarea unei categorii
    @PostMapping("/salveaza")
    public String saveCategorie(@ModelAttribute Categorie categorie) {
        categorieService.saveCategorie(categorie);
        return "redirect:/categorii";
    }

    // Formular pentru editare
    @GetMapping("/editeaza/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Categorie categorie = categorieService.getCategorieById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Categorie invalida: " + id));

        model.addAttribute("categorie", categorie);
        return "categorii/form";
    }

    // Stergerea unei categorii
    @GetMapping("/sterge/{id}")
    public String deleteCategorie(@PathVariable Integer id) {
        categorieService.deleteCategorie(id);
        return "redirect:/categorii";
    }
}
