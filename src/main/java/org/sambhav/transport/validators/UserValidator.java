//package org.sambhav.transport.validators;
//
//
//import org.sambhav.transport.models.User;
//import org.sambhav.transport.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//
//@Component
//public class UserValidator implements Validator {
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return User.class.equals(aClass);
//    }
//
//    @Override
//    public void validate(Object o, Errors errors) {
//        User user = (User) o;
//
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Non-Empty");
//        if (user.getUserName().length() < 8 || user.getUserName().length() > 32) {
//            errors.rejectValue("username", "User.Invalid");
//        }
//        if (userService.findByUsername(user.getUserName()) != null) {
//            errors.rejectValue("username", "User.Found");
//        }
//
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Should not be empty");
//        if (user.getPasswd().length() < 2 || user.getPasswd().length() > 12) {
//            errors.rejectValue("password", "Password.Wrong");
//        }
//
//        if (!user.getConfirmPasswd().equals(user.getPasswd())) {
//            errors.rejectValue("passwordConfirm", "Password.WrongMatch");
//        }
//    }
//}
