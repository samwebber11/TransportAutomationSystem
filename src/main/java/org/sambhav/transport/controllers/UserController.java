package org.sambhav.transport.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.sambhav.transport.customs.DateValidator;
import org.sambhav.transport.customs.Distance;
import org.sambhav.transport.customs.Payment;
import org.sambhav.transport.models.Rides;
import org.sambhav.transport.models.User;
import org.sambhav.transport.services.SecurityService;
import org.sambhav.transport.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;
	
	private Distance distance;
	
	private Payment payment;
	
	private DateValidator dateValidator;
	
	@Autowired
	private void setDateValidator(DateValidator date)
	{
		this.dateValidator = date;
	}
	
	@Autowired
	private void setPayment(Payment payment)
	{
		this.payment = payment;
	}
	
	@Autowired
	public void setDistance(Distance distance)
	{
		this.distance = distance;
	}
	
//	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	Get Method for ride 
//	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	@GetMapping("/ride")
	public ModelAndView takeARide()
	{
		ModelAndView view = new ModelAndView();
		Rides ride = new Rides();
		view.addObject(ride);
		view.setViewName("ride");
		return view;
	}
	
//	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	Get method for page rendering on start of application
//	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	@GetMapping("/")
	public ModelAndView welcome()
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("welcome");
		return view;
	}
	
//	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	Get Method for login
//	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	@GetMapping("/login")
	public ModelAndView login()
	{
		ModelAndView view = new ModelAndView();
		if(securityService.findLoggedInUsername()!=null)
		{
			view.setViewName("booking");
		}
		else
		{
			view.setViewName("login");
		}
		return view;
	}
	
//	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	Get Method for registration
//	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	@GetMapping("/registration")
	public ModelAndView registration()
	{
		ModelAndView view = new ModelAndView();
		User user = new User();
		view.addObject("user",user);
		view.setViewName("registration");
		return view;
	}
	
//	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	Get Method for Booking(Page After Successful Login)
//	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	@GetMapping("/booking")
	public ModelAndView booking()
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("booking");
		return view;
	}
	
//	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	Get Method for Any Page on Rendering URL not present in application
//	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	@GetMapping("/*")
	public ModelAndView anyPage()
	{
		ModelAndView view = new ModelAndView();
		if(securityService.findLoggedInUsername()!=null)
		{
			view.setViewName("booking");
		}
		else
		{
			view.setViewName("homepage");
		}
		
		return view;
	}
	
//	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	Get Method for Homepage
//	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	@GetMapping("/homepage")
	public ModelAndView homepage()
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("homepage");
		return view;
	}
	
//	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	Post Method for Registration
//	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	@PostMapping("/registration")
	public ModelAndView saveUser(@Valid User user,BindingResult bindingResult)
	{
		System.out.println("Hit here");
		 ModelAndView modelAndView = new ModelAndView();
	        User userExists = userService.findByEmail(user.getEmail());
	        if (userExists != null) {
	            bindingResult
	                    .rejectValue("email", "error.user",
	                            "You are already a member.Please kindly login!");
	        }
	        if (bindingResult.hasErrors()) {
	        	System.out.println(bindingResult.getAllErrors());
	            modelAndView.setViewName("homepage");
	        } else {
	            userService.saveUser(user);
	            modelAndView.addObject("successMessage", "User has been registered successfully");
	            modelAndView.setViewName("registration");

	        }
	        return modelAndView;
	}
	

//	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	Post Method For a Ride
//	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	@PostMapping("/ride")
	public ModelAndView checkDistance(Rides ride)
	{
		ModelAndView view = new ModelAndView();
//		JSONObject obj4 = null;
//		JSONObject obj5 = null;
//		 try {
//             //method of DistanceTime Class
//    	   String source = ride.getStartLocation();
//    	   String destination = ride.getEndLocation();
//           String response=distance.calculate(source,destination);
//           JSONParser parser = new JSONParser();
//           try {
//
//           Object obj = parser.parse(response);
//           JSONObject jsonobj=(JSONObject)obj;
//
//           JSONArray dist=(JSONArray)jsonobj.get("rows");
//           JSONObject obj2 = (JSONObject)dist.get(0);
//           JSONArray disting=(JSONArray)obj2.get("elements");
//           JSONObject obj3 = (JSONObject)disting.get(0);
//           obj4=(JSONObject)obj3.get("distance");
//           obj5=(JSONObject)obj3.get("duration");
//           System.out.println(obj4.get("text"));
//           System.out.println(obj5.get("text"));
//       }
//   catch(Exception e) {
//       e.printStackTrace();
//   	}
//       }
//
//       catch(Exception e) {
//           System.out.println("Exception Occurred");
//       }
		 
		 String source = ride.getStartLocation();
		 String destination = ride.getEndLocation();
		 String startDate = ride.getStarting();
		 
		 if(!dateValidator.validateDate(startDate))
		 {
			 view.addObject("errorMessage","*Date is in invalid format");
			 return view;
		 }
//		 Only for testing In Real Application this will come from map api...
		 
		 String distance = "386.5km";
		 Double hrsTaken = payment.hrsTaken(distance);
		 Double totalPrice = payment.calculatePrice(distance);
		 
		 Date startTime = dateValidator.calculateStartTime(startDate);
		 
//		 startTime will be current time plus the minimum time required by the driver to reach that starting point.
//		 if that time will be less than the scheduled starting time then startTime will be time calculated above.
		 System.out.println(startTime);
		 
		 Date endTime = dateValidator.calculateEndTime(startTime,hrsTaken);
		 view.addObject("hrsTaken","Total Time to travel: "+hrsTaken);
		 view.addObject("price","You will be charged: "+ totalPrice);
		 view.addObject("distance",source);
         view.addObject("timeToTravel", destination);
 		 view.addObject("successMessage","Location send successfully");
 		 view.addObject("startTime","Starting Time: "+startTime);
 		 view.addObject("endTime","Ending Time: "+endTime);
		
		return view;
	}
	
	
//	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	Page After Confirming a location
//	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	@GetMapping("/getter")
	public ModelAndView getRide()
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("getter");
		return view;
	}
}