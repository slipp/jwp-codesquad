package slipp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import slipp.domain.QuestionRepository;

@Controller
public class HomeController {
	@Autowired
	private QuestionRepository questionRepository;
	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("questions", questionRepository.findAll());
		return mav;
	}
}
