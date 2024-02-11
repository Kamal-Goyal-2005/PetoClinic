package com.caltech.clinic;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.caltech.clinic.pogo.User;
import com.caltech.clinic.service.UserService;


@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	
	Logger log=Logger.getAnonymousLogger();
	
	@RequestMapping("/")
	public ModelAndView defaultpage(HttpServletRequest request,HttpServletResponse response) {
		log.info("entered into the / request");
		ModelAndView mv=new ModelAndView();	
		mv.setViewName("index.jsp");	
		log.info("went to index.jsp page ");
		return mv;
		
	}
	
	@PostMapping("/RegisterController")
	public ModelAndView registerUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("entered into the / RegisterController");
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		String phone = request.getParameter("phone");
		String name = request.getParameter("name");
		
		String pwd = passwordEncoder.encode(request.getParameter("password"));

		System.out.println(name + " " + pwd);
        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setPwd(pwd);
		
        String message = userService.register(user);
        
        mv.setViewName("error.jsp");
		mv.addObject("errormsg", message);

		return mv;

		// return "sum of numbers is " + result;
	}
	
	@RequestMapping("/UserController")
	public ModelAndView loginUser(HttpServletRequest request,HttpServletResponse response) {
		log.info("entered into the / LoginController");
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
			String username = request.getParameter("username");
			String pwd = request.getParameter("password");
			System.out.println(username + " " + pwd);
			
			boolean i = userService.validateuser(username, pwd);
			boolean j = userService.checkAdmin(username, pwd);
		


			if (j) {
				session.setAttribute("LoggedIn", "TRUE");
				mv.setViewName("main.jsp");
			} else if (i) {
				session.setAttribute("LoggedIn", "TRUE");
				session.setAttribute("name", username);
				mv.setViewName("main.jsp");
			} else {
				mv.setViewName("error.jsp");
				mv.addObject("errormsg", "<h3>Invalid Username or Password</h3>");
			}
			System.out.println("Validate User:"+i + ", Admin User: " + j);
			return mv;	
	}
	
	

}
