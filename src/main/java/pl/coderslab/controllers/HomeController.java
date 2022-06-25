package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.models.Institution;
import pl.coderslab.repositories.DonationRepository;
import pl.coderslab.repositories.InstitutionRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    public HomeController(InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    @RequestMapping("/home")
    public String homeAction(Model model){
        List<Institution> institutions = institutionRepository.findAll();
        model.addAttribute("institutions", institutions);

        Integer sumOfBags = donationRepository.sumOfBags();
        model.addAttribute("sumOfBags", Optional.ofNullable(sumOfBags).orElse(0));

        Integer sumOfDonations = donationRepository.sumOfDonations();
        model.addAttribute("sumOfDonations", Optional.ofNullable(sumOfDonations).orElse(0));
        return "main";
    }
}
