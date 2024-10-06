package com.localeapp.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class AboutMeController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/about")
    public String aboutMe(Model model, Locale locale) {
        model.addAttribute("name", messageSource.getMessage("about.name", null, locale));
        model.addAttribute("bio", messageSource.getMessage("about.bio", null, locale));
        model.addAttribute("imagePath", "/images_projects/i.jpg");
        return "about";
    }
}