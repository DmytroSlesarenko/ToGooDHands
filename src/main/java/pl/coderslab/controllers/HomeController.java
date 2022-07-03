package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.models.Institution;
import pl.coderslab.models.User;
import pl.coderslab.repositories.DonationRepository;
import pl.coderslab.repositories.InstitutionRepository;
import pl.coderslab.repositories.UserRepository;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    private final UserRepository userRepository;
    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    public HomeController(UserRepository userRepository, InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.userRepository = userRepository;
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    @GetMapping("/donation")
    public String homeAction(Model model, Principal principal){
        User user = userRepository.getUserByEmail(principal.getName());
        model.addAttribute("user", user);

        List<Institution> institutions = institutionRepository.findAll();
        model.addAttribute("institutions", institutions);

        Integer sumOfBags = donationRepository.sumOfBags();
        model.addAttribute("sumOfBags", Optional.ofNullable(sumOfBags).orElse(0));

        Integer sumOfDonations = donationRepository.sumOfDonations();
        model.addAttribute("sumOfDonations", Optional.ofNullable(sumOfDonations).orElse(0));
        return "main";
    }
}
