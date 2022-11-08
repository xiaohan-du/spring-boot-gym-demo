package gymDemo.gym.web;

import gymDemo.gym.service.GymDto;
import gymDemo.gym.service.GymService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class IndexController {
    private final GymService gymService;
    public IndexController(GymService svc) { this.gymService = svc; }

    @ModelAttribute
    public void getGyms(Model model) {
        List<GymDto> gyms = gymService.getGyms();
        model.addAttribute("gyms", gyms);
    }

    @GetMapping("")
    public String index(){
        return "index";
    }
}
