package org.sambhav.transport.validators;


import org.sambhav.transport.models.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Should not be empty");
        if (user.getPassword().length() < 3 || user.getPassword().length() > 10) {
            errors.rejectValue("password", "Password.Wrong");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "Password.Match");
        }
    }
}
