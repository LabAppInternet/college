package cat.tecnocampus.college.webControllers;

import domain.exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/*
TODO 5 All annotations on this file have been removed. You need to write them again so that it copes with the different
exceptions that may occur
 */

@ControllerAdvice
public class ExceptionHandlingController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlingController.class);

    /*
    This method must cope with RegisterPreviousLevelSubjectsFirst
     */
    @ExceptionHandler(RegisterPreviousLevelSubjectsFirst.class)
    public String handlePreviousSubjectsNotSelected(HttpServletRequest request, Exception ex) {

        logger.error("Request: " + request.getRequestURL() + " raised " + ex);

        String errorMsg = "You must register all subjects of precedent levels!!!";
        return "redirect:/registerSubjects/"+errorMsg;
    }

    /*
    This method must cope with org.springframework.web.bind.MissingServletRequestParameterException
     */
    @ExceptionHandler(org.springframework.web.bind.MissingServletRequestParameterException.class)
    public String handleNoSubjectSelected(HttpServletRequest request, Exception ex) {

        logger.error("Request: " + request.getRequestURL() + " raised " + ex);

        String errorMsg = "You must choose at least one subject!!!";
        return "redirect:/registerSubjects/"+errorMsg;
    }


    /*
    This method must cope with StudentDoesNotExistsException, StudentWithNoRegistrations,
    SubjectAlreadyRegisteredException, UnRegisteredSubjectException
     */
    @ExceptionHandler({StudentDoesNotExistsException.class, StudentWithNoRegistrations.class, SubjectAlreadyRegisteredException.class, UnRegisteredSubjectException.class})
    public String handleManyErrors(Model model, HttpServletRequest request, Exception ex) {
        String url = request.getRequestURL().toString();

        logger.error("Request: " + url + " raised " + ex);

        model.addAttribute("errorMsg", ex.getMessage());
        return "errorPage";
    }


}
