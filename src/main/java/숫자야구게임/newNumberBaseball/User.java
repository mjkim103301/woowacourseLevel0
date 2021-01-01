package 숫자야구게임.newNumberBaseball;

import java.util.Scanner;

public class User extends PlayerFrame {
    private Scanner scan=new Scanner(System.in);
    @Override
    public void setOwnNumber() {
        System.out.println("사용자의 비밀숫자 3개를 연속으로 입력하세요.");
        String userNumber=scan.nextLine();
        for(int i=0;i<NUM_COUNT;i++){
            ownNumber[i]=userNumber.charAt(i)-'0';
        }
    }

    @Override
    public void setGuess() {
        System.out.println("사용자가 컴퓨터를 추측할 차례입니다. 숫자를 입력해주세요: ");
        String guessNumber=scan.nextLine();
        for(int i=0;i<NUM_COUNT;i++){
            guess[i]=guessNumber.charAt(i)-'0';
        }
    }
}
