package gymDemo.gym.web;

import gymDemo.gym.service.GymAndManagerDto;
import gymDemo.gym.service.GymDto;
import gymDemo.gym.service.GymService;
import gymDemo.gym.service.MemberDto;
import gymDemo.gym.web.forms.GymForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("member-list")
    public ModelAndView getMembers(Model model) {
        List<MemberDto> members = gymService.getMembers();
        model.addAttribute("members", members);
        var mv = new ModelAndView("admin/member-list", model.asMap());
        return mv;
    }

    @GetMapping("add")
    public ModelAndView getNewGymForm(Model model) {
        model.addAttribute("gymForm", new GymForm());
        var mv = new ModelAndView("admin/gym-form", model.asMap());
        return mv;
    }

    @GetMapping("update/{id}")
    public ModelAndView updateGymForm(@PathVariable("id") Optional<Integer> id, Model model) {
        Optional<GymAndManagerDto> gymAndManagerDtoOptional = gymService.getGymByIdWithManagers(id.get());
        var gymAndManagerDto = gymAndManagerDtoOptional.get();
        GymForm updateForm = new GymForm(
                gymAndManagerDto.getName(),
                gymAndManagerDto.getId(),
                gymAndManagerDto.getLocation(),
                gymAndManagerDto.getFee(),
                gymAndManagerDto.getIsApproved());
        model.addAttribute("gymForm", updateForm);
        var mv = new ModelAndView("admin/gym-form", model.asMap());
        return mv;
    }

    @PostMapping("add")
    public ModelAndView postNewGymForm(@Valid GymForm gymForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(System.out::println);
            return new ModelAndView("admin/gym-form", model.asMap());
        } else {
            GymDto gymDto = new GymDto(gymForm.getName(), gymForm.getId(), gymForm.getLocation(), gymForm.getFee(), Boolean.FALSE, null);
            gymService.addNewGym(gymDto);
            var mv = new ModelAndView("redirect:/gym/gym-list");
            return mv;
        }
    }
}
