package slipp.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import slipp.domain.Question;

@Controller
public class QuestionController {
	public static ArrayList<Question> questions = new ArrayList<>();
	
	@PostMapping("/questions")
	public ModelAndView create(Question question) {	
		questions.add(question);
		System.out.println("size : " + questions.size());
		
		return new ModelAndView("redirect:/");
	}
	
	@GetMapping("/questions/{index}")
	public ModelAndView show(@PathVariable int index) {
		ModelAndView mav = new ModelAndView("qna/show");
		mav.addObject("question", questions.get(index));
		return mav;
	}
}
