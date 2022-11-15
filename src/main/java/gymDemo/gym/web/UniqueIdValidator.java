package gymDemo.gym.web;

import gymDemo.gym.service.GymService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueIdValidator implements ConstraintValidator<UniqueId, Integer> {
    private final GymService gymService;
    public UniqueIdValidator(GymService aGymService){
        gymService = aGymService;
    }
    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {
        return !gymService.getGymById(id).isPresent();
    }
}
