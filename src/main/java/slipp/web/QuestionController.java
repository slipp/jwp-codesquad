package slipp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import slipp.domain.Question;
import slipp.domain.QuestionRepository;

@Controller
public class QuestionController {
	@Autowired
	private QuestionRepository questionRepository;
	
	@PostMapping("/questions")
	public ModelAndView create(Question question) {
		questionRepository.save(question);		
		return new ModelAndView("redirect:/");
	}
	
	@GetMapping("/questions/{id}")
	public ModelAndView show(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("qna/show");
		mav.addObject("question", questionRepository.findOne(id));
		return mav;
	}
}
