package gymDemo.gym.web;

import gymDemo.gym.service.GymDto;
import gymDemo.gym.service.GymService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping({"gym"})
public class GymController {
    private final GymService gymService;
    public GymController(GymService svc) {
        this.gymService = svc;
    }

    @ModelAttribute
    public void getGyms(Model model) {
        List<GymDto> gyms = gymService.getGyms();
        model.addAttribute("gyms", gyms);
        System.out.println(gyms);
    }

    @GetMapping("gym-list")
    public ModelAndView getGymsView(Model model) {
        List<GymDto> gyms = gymService.getGyms();
        model.addAttribute("gyms", gyms);
        var mv = new ModelAndView("gym/gym-list", model.asMap());
        return mv;
    }

    @GetMapping("profile/{id}")
    public ModelAndView getGym(@PathVariable String id, Model model) {
        Optional<GymDto> gym = gymService.getGymById(id);
        if (gym.isPresent()) {
            model.addAttribute("gym", gym.get());
            var mv = new ModelAndView("gym/gym-profile", model.asMap());
            return mv;
        } else {
            return new ModelAndView("redirect: /404");
        }
    }
}
