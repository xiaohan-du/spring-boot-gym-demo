package gymDemo.gym.web;

import gymDemo.gym.service.GymDto;
import gymDemo.gym.service.GymService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    private List<GymDto> getGyms() {
        return gymService.getGyms();
    }

    private List<GymDto> getGymsBySearch(String query) {
        return gymService.getGymsBySearch(query);
    }
    @ModelAttribute
    public void getGyms(@RequestParam(name = "q", required = false) Optional<String> query, Model model) {
        List<GymDto> gyms;
        if (query.isPresent()) {
            gyms = this.getGymsBySearch(query.get());
        } else {
            gyms = this.getGyms();
        }
        model.addAttribute("gyms", gyms);
    }

    @GetMapping("gym-list")
    public ModelAndView getGymsView(Model model) {
        var mv = new ModelAndView("gym/gym-list", model.asMap());
        return mv;
    }

    @GetMapping("profile/{id}")
    public ModelAndView getGym(@PathVariable Integer id, Model model) {
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
