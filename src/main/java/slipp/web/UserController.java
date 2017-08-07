package slipp.web;

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
