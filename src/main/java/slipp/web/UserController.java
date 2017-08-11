package slipp.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import slipp.domain.User;
import slipp.domain.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
	static final String USER_PATH = "/users";
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginedUser");
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(String userId, String password, HttpSession session) {
		System.out.println("userId : " + userId + " password : " + password);
		
		User dbUser = userRepository.findByUserId(userId);
		if (dbUser == null) {
			return "user/login_failed";
		}
		
		if (!dbUser.matchPassword(password)) {
			return "user/login_failed";
		}
		
		session.setAttribute("loginedUser", dbUser);
		
		return "redirect:/";
	}
	
	@GetMapping("/{id}/form")
	public ModelAndView updateForm(@PathVariable Long id, HttpSession session) {
		Object tempUser = session.getAttribute("loginedUser");
		if(tempUser == null) {
			return new ModelAndView("redirect:/");
		}
		
		User loginedUser = (User)tempUser;
		if (!loginedUser.matchId(id)) {
			return new ModelAndView("redirect:/");
		}
		
		User user = userRepository.findOne(id);
		ModelAndView mav = new ModelAndView("user/updateForm");
		mav.addObject("user", user);
		return mav;
	}
	
	@PostMapping("/{id}")
	public String update(@PathVariable Long id, User user, HttpSession session) {
		Object tempUser = session.getAttribute("loginedUser");
		if(tempUser == null) {
			return "redirect:/";
		}
		
		User loginedUser = (User)tempUser;
		if (!loginedUser.matchId(id)) {
			return "redirect:/";
		}
		
		User dbUser = userRepository.findOne(id);
		
		if (dbUser.update(user)) {
			userRepository.save(dbUser);
		}
		
		return "redirect:/users";
	}
	
	
	@GetMapping("/{id}")
	public ModelAndView show(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("user/profile");
		mav.addObject("user", userRepository.findOne(id));
		return mav;
	}
	
	@GetMapping("")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("user/list");
		mav.addObject("users", userRepository.findAll());
		return mav;
	}
	
	@PostMapping("")
	public ModelAndView create(User user) {	
		userRepository.save(user);
		
		return new ModelAndView("redirect:/users");
	}
}
