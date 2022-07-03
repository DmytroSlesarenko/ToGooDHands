package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.models.Category;
import pl.coderslab.models.Donation;
import pl.coderslab.models.Institution;
import pl.coderslab.repositories.CategoryRepository;
import pl.coderslab.repositories.DonationRepository;
import pl.coderslab.repositories.InstitutionRepository;

import java.util.List;

@Controller
public class DonationController {

    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    public DonationController(CategoryRepository categoryRepository, InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    @GetMapping("/add/donation")
    public String addDonationForm(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);

        List<Institution> institutions = institutionRepository.findAll();
        model.addAttribute("institutions", institutions);

        model.addAttribute("donation", new Donation());
        return "donationForm";
    }

    @PostMapping("/add/donation")
    public String addDonation(Donation donation){
        donationRepository.save(donation);
        return "donationFormConfirmation";
    }
}
