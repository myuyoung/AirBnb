package me.changwook.AirBnb.controller;

import lombok.RequiredArgsConstructor;
import me.changwook.AirBnb.dto.AccommodationDTO;
import me.changwook.AirBnb.service.AccommodationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api/accommodations")
@RequiredArgsConstructor
public class AccommodationController {
    private final AccommodationService service;

    @GetMapping
    public String getAccommodation(@RequestParam("id") Long id, Model model) {
        AccommodationDTO accommodation = service.getAccommodationForHtmlById(id);
        model.addAttribute("accommodation", accommodation);
        return "accommodation-detail";
    }

    @GetMapping("detail")
    @ResponseBody
    public AccommodationDTO getAccommodationDetail(@RequestParam("id") Long id) {
        return service.getAccommodationForJsonById(id);
    }
}
