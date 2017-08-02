package slipp.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import bb.Baseball;

@Controller
public class BaseballController {
	ArrayList<Integer> computerBalls;
	
	@GetMapping("/baseball")
	public ModelAndView input(String inputValue) {
		if (computerBalls == null) {
			computerBalls = Baseball.generateComputerBalls();
		}
		
		System.out.println("input value : " + inputValue);
		
		ArrayList<Integer> userBalls = Baseball.inputUserBalls(inputValue);
		String result = Baseball.calculateBalls(computerBalls, userBalls);
		
		ModelAndView mav = new ModelAndView("baseball/result");
		mav.addObject("result", result);
		return mav;
	}
	
	@GetMapping("/newgame")
	public ModelAndView newgame(String inputValue) {
		computerBalls = Baseball.generateComputerBalls();
		
		ModelAndView mav = new ModelAndView("redirect:/baseball/form.html");
		return mav;
	}
	
}
