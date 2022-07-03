package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.models.Category;
import pl.coderslab.models.Donation;
import pl.coderslab.models.Institution;
import pl.coderslab.models.User;
import pl.coderslab.repositories.CategoryRepository;
import pl.coderslab.repositories.DonationRepository;
import pl.coderslab.repositories.InstitutionRepository;
import pl.coderslab.repositories.UserRepository;

import java.security.Principal;
import java.util.List;

@Controller
public class DonationController {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    public DonationController(UserRepository userRepository, CategoryRepository categoryRepository, InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    @GetMapping("/add")
    public String addDonationForm(Model model, Principal principal) {
        User user = userRepository.getUserByEmail(principal.getName());
        model.addAttribute("user", user);

        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);

        List<Institution> institutions = institutionRepository.findAll();
        model.addAttribute("institutions", institutions);

        model.addAttribute("donation", new Donation());
        return "donationForm";
    }

    @PostMapping("/add")
    public String addDonation(Donation donation){
        donationRepository.save(donation);
        return "donationFormConfirmation";
    }
}
