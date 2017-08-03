package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Baseball {
    public static ArrayList<Integer> generateComputerBalls() {
        List<Integer> possibleBalls = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(possibleBalls);
        
        ArrayList<Integer> computerBalls = new ArrayList<>(3);
        computerBalls.add(possibleBalls.get(0));
        computerBalls.add(possibleBalls.get(1));
        computerBalls.add(possibleBalls.get(2));
        return computerBalls;
    }
    
    public static int calculateBall(ArrayList<Integer> computerBalls, int userBall, int position) {
        if (!computerBalls.contains(userBall)) {
            return 0;
        }
        
        int computerBall = computerBalls.get(position);
        if (userBall == computerBall) {
            return 2;
        }
        
        return 1;
    }
    
    public static String calculateBalls(ArrayList<Integer> computerBalls, ArrayList<Integer> userBalls) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < userBalls.size(); i++) {
            int result = calculateBall(computerBalls, userBalls.get(i), i);
            
            if (result == 2) {
                strike++;
            } else if (result == 1) {
                ball++;
            }
        }
        
        return String.format("결과 : %d strike, %d ball", strike, ball);
    }
    
    public static ArrayList<Integer> inputUserBalls(String inputValue) {
        String[] values = inputValue.split(" ");
        ArrayList<Integer> userBalls = new ArrayList<>();
        for (String value : values) {
            userBalls.add(Integer.parseInt(value));
        }
        return userBalls;
    }
}
