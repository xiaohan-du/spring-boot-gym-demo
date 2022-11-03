package gymDemo.gym.web;

import gymDemo.gym.service.GymDto;
import gymDemo.gym.service.GymService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("gym")
public class GymController {
    private final GymService gymService;
    public GymController(GymService svc) {
        this.gymService = svc;
    }

    @GetMapping("gym-list")
    public ModelAndView getGyms(Model model) {
        List<GymDto> gyms = gymService.getGyms();
        model.addAttribute("gyms", gyms);
        var mv = new ModelAndView("gym/gym-list", model.asMap());
        return mv;
    }
}
