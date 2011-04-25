/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigservation.gigreservationweb.controler;

import com.gigservation.gigreservationweb.validator.TicketingFormValidator;
import com.programmez.samples.gigreservation.domain.Ticketing;
import com.programmez.samples.gigreservation.service.TicketOrderService;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author agnes007
 */
@Controller
public class TicketingReservationControler {

    @Autowired
    private TicketOrderService ticketOrderService;
    @Autowired
    private TicketingFormValidator validator;
    @Autowired
    Comparator<String> comparator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/searchTicketings")
    public String searchTicketings(@RequestParam("input1") String name, Model model) {

        List<Ticketing> ticketings = ticketOrderService.searchTicketingsByBand(name.trim());
        model.addAttribute("ticketings", ticketings);


        return "ticketings";
    }

    @RequestMapping("/{name}")
    public String displayTicketingById(@PathVariable String name, Model model) {

        List<Ticketing> ticketings = ticketOrderService.searchTicketingsByBand(name.trim());
        model.addAttribute("ticketings", ticketings);

        return "ticketings";
    }

    @RequestMapping("/hello")
    public ModelAndView handleRequest() {

        return new ModelAndView("hello");
    }

    @RequestMapping(value = "/")
    public String home() {
        System.out.println("HomeController: Passing through...");
        return "home";
    }

    @RequestMapping(value = "/compare", method = RequestMethod.GET)
    public String compare(@RequestParam("input1") String input1,
            @RequestParam("input2") String input2, Model model) {

        int result = comparator.compare(input1, input2);
        String inEnglish = (result < 0) ? "less than" : (result > 0 ? "greater than" : "equal to");

        String output = "According to our Comparator, '" + input1 + "' is " + inEnglish + "'" + input2 + "'";

        model.addAttribute("output", output);
        return "compareResult";
    }

    @RequestMapping("/hello2")
    public ModelAndView handleRequest2() {

        return new ModelAndView("hello");
    }
//    @RequestMapping("/viewAllTicketings")
//    public ModelAndView getAllTicketings()
//    {
//        ModelAndView mav = new ModelAndView("showTicketings");
//        List<Ticketing> contacts = ticketOrderService.getAllTicketings();
//        mav.addObject("SEARCH_TICKETINGS_RESULTS_KEY", contacts);
//        return mav;
//    }
//    @RequestMapping(value="/saveTicketing", method=RequestMethod.GET)
//    public ModelAndView newuserForm()
//    {
//        ModelAndView mav = new ModelAndView("newTicketing");
//        Ticketing contact = new Ticketing();
//        mav.getModelMap().put("newTicketing", contact);
//        return mav;
//    }
//
//    @RequestMapping(value="/saveTicketing", method=RequestMethod.POST)
//    public String create(@ModelAttribute("newTicketing")Ticketing contact, BindingResult result, SessionStatus status)
//    {
//        validator.validate(contact, result);
//        if (result.hasErrors())
//        {
//            return "newTicketing";
//        }
//        ticketOrderService.save(contact);
//        status.setComplete();
//        return "redirect:viewAllTicketings.do";
//    }
//
//    @RequestMapping(value="/updateTicketing", method=RequestMethod.GET)
//    public ModelAndView edit(@RequestParam("id")Integer id)
//    {
//        ModelAndView mav = new ModelAndView("editTicketing");
//        Ticketing contact = ticketOrderService.getById(id);
//        mav.addObject("editTicketing", contact);
//        return mav;
//    }
//
//    @RequestMapping(value="/updateTicketing", method=RequestMethod.POST)
//    public String update(@ModelAttribute("editTicketing") Ticketing contact, BindingResult result, SessionStatus status)
//    {
//        validator.validate(contact, result);
//        if (result.hasErrors()) {
//            return "editTicketing";
//        }
//        ticketOrderService.update(contact);
//        status.setComplete();
//        return "redirect:viewAllTicketings.do";
//    }
//
//    @RequestMapping("deleteTicketing")
//    public ModelAndView delete(@RequestParam("id")Integer id)
//    {
//        ModelAndView mav = new ModelAndView("redirect:viewAllTicketings.do");
//        ticketOrderService.delete(id);
//        return mav;
//    }
}
