package gymDemo.gym.web;

import gymDemo.gym.service.GymDto;
import gymDemo.gym.service.GymService;
import gymDemo.gym.web.forms.GymForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("admin/gym")
public class GymAdminController {
    private final GymService gymService;
    public GymAdminController(GymService svc) {
        this.gymService = svc;
    }

    @ModelAttribute
    public void getGyms(Model model) {
        List<GymDto> gyms = gymService.getGyms();
        model.addAttribute("gyms", gyms);
    }

    @GetMapping("add")
    public ModelAndView getNewGymForm(Model model) {
        model.addAttribute("gymForm", new GymForm());
        var mv = new ModelAndView("admin/gym-form", model.asMap());
        return mv;
    }

    @PostMapping("add")
    public ModelAndView postNewGymForm(@Valid GymForm gymForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(System.out::println);
            return new ModelAndView("admin/gym-form", model.asMap());
        } else {
            GymDto gymDto = new GymDto(gymForm.getName(), gymForm.getId(), gymForm.getLocation(), Double.parseDouble(gymForm.getFee()), Boolean.FALSE);
            gymService.addNewGym(gymDto);
            var mv = new ModelAndView("redirect:/gym/gym-list");
            return mv;
        }
    }
}
