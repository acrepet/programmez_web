/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gigservation.gigreservationweb.validator;

import com.programmez.samples.gigreservation.domain.Ticketing;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author agnes007
 */
@Component("gigFormValidator")
public class TicketingFormValidator  implements Validator {
    @SuppressWarnings("unchecked")
    @Override
    public boolean supports(Class clazz)
    {
        return Ticketing.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object model, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "band","required.band", "Band is required.");
    }
}

