package org.sambhav.transport.controllers;

import javax.validation.Valid;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.sambhav.transport.customs.Distance;
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
	
	@Autowired
	public void setDistance(Distance distance)
	{
		this.distance = distance;
	}
	
	@GetMapping("/ride")
	public ModelAndView takeARide()
	{
		ModelAndView view = new ModelAndView();
		Rides ride = new Rides();
		view.addObject(ride);
		view.setViewName("ride");
		return view;
	}
	
	@GetMapping("/")
	public ModelAndView welcome()
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("welcome");
		return view;
	}
	
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
	
	@GetMapping("/registration")
	public ModelAndView registration()
	{
		ModelAndView view = new ModelAndView();
		User user = new User();
		view.addObject("user",user);
		view.setViewName("registration");
		return view;
	}
	
	@GetMapping("/booking")
	public ModelAndView booking()
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("booking");
		return view;
	}
	
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
	
	
	
	@GetMapping("/homepage")
	public ModelAndView homepage()
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("homepage");
		return view;
	}
	
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
		JSONObject obj4 = null;
		JSONObject obj5 = null;
		 try {
             //method of DistanceTime Class
    	   String source = ride.getStartLocation();
    	   String destination = ride.getEndLocation();
           String response=distance.calculate(source,destination);
           JSONParser parser = new JSONParser();
           try {

           Object obj = parser.parse(response);
           JSONObject jsonobj=(JSONObject)obj;

           JSONArray dist=(JSONArray)jsonobj.get("rows");
           JSONObject obj2 = (JSONObject)dist.get(0);
           JSONArray disting=(JSONArray)obj2.get("elements");
           JSONObject obj3 = (JSONObject)disting.get(0);
           obj4=(JSONObject)obj3.get("distance");
           obj5=(JSONObject)obj3.get("duration");
           System.out.println(obj4.get("text"));
           System.out.println(obj5.get("text"));
       }
   catch(Exception e) {
       e.printStackTrace();
   	}
       }

       catch(Exception e) {
           System.out.println("Exception Occurred");
       }
		 
		 view.addObject("distance",obj4.get("text"));
         view.addObject("timeToTravel", obj5.get("text"));
 		 view.addObject("successMessage","Location send successfully");
//		System.out.println(ride.getStartLocation());
		
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