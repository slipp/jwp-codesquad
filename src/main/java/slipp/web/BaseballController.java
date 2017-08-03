package slipp.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import baseball.Baseball;

@Controller
public class BaseballController {
	ArrayList<Integer> computerBalls;
	
	@GetMapping("/baseball")
	public ModelAndView input(String inputValue) {
		if (computerBalls == null) {
			computerBalls = Baseball.generateComputerBalls();
		}
		
		String result = null;
		if (inputValue == null) {
			result = "게임 시작 전";
		} else {
			System.out.println("input value : " + inputValue);
			
			ArrayList<Integer> userBalls = Baseball.inputUserBalls(inputValue);
			result = Baseball.calculateBalls(computerBalls, userBalls);
		}
		
		ModelAndView mav = new ModelAndView("baseball/result");
		mav.addObject("result", result);
		mav.addObject("computerBalls", computerBalls);
		mav.addObject("inputValue", inputValue);
		return mav;
	}
	
	@GetMapping("/baseball/new")
	public ModelAndView newgame(String inputValue) {
		computerBalls = Baseball.generateComputerBalls();
		
		return new ModelAndView("redirect:/baseball");
	}
	
}
