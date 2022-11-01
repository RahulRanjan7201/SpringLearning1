package com.demo.learning.learningspring.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.learning.learningspring.business.ReservationService;
import com.demo.learning.learningspring.data.Guest;

@Controller
@RequestMapping("/guests")
public class GuestController {
	private final ReservationService reservationService;

	public GuestController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getGuests(Model model) {
		List<Guest> guests = this.reservationService.getHotelGuests();
		model.addAttribute("guests", guests);
		return "guests";
	}

}
