package TravelGuide.controller;

import TravelGuide.entity.AtractieCategorie;
import TravelGuide.entity.AtractieCategorie.AtractieCategorieId;
import TravelGuide.service.AtractieCategorieService;
import TravelGuide.service.AtractieService;
import TravelGuide.service.CategorieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/asocieri")
public class AtractieCategorieController {

    private final AtractieCategorieService asociereService;
    private final AtractieService atractieService;
    private final CategorieService categorieService;

    public AtractieCategorieController(
            AtractieCategorieService asociereService,
            AtractieService atractieService,
            CategorieService categorieService) {

        this.asociereService = asociereService;
        this.atractieService = atractieService;
        this.categorieService = categorieService;
    }

    @GetMapping
    public String getAllAsocieri(Model model) {
        model.addAttribute("asocieri", asociereService.getAllAsocieri());
        return "asocieri/list";
    }

    @GetMapping("/nou")
    public String showAddForm(Model model) {
        model.addAttribute("asociere", new AtractieCategorie());
        model.addAttribute("atractii", atractieService.getAllAtractii());
        model.addAttribute("categorii", categorieService.getAllCategorii());

        return "asocieri/form";
    }

    @PostMapping("/salveaza")
    public String saveAsociere(
            @RequestParam Integer idAtractie,
            @RequestParam Integer idCategorie) {

        AtractieCategorieId id =
                new AtractieCategorieId(idAtractie, idCategorie);

        AtractieCategorie asociere = new AtractieCategorie();
        asociere.setAtractie(
                atractieService.getAtractieById(idAtractie).orElseThrow());
        asociere.setCategorie(
                categorieService.getCategorieById(idCategorie).orElseThrow());

        asociereService.saveAsociere(asociere);

        return "redirect:/asocieri";
    }

    @GetMapping("/sterge/{idAtractie}/{idCategorie}")
    public String deleteAsociere(
            @PathVariable Integer idAtractie,
            @PathVariable Integer idCategorie) {

        AtractieCategorieId id =
                new AtractieCategorieId(idAtractie, idCategorie);

        asociereService.deleteAsociere(id);

        return "redirect:/asocieri";
    }
}