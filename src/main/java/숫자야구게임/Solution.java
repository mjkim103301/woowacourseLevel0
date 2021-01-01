package 숫자야구게임;

import java.util.Scanner;
import static 숫자야구게임.PlayerFrame.NUM_COUNT;

public class Solution {
    private Computer computer;
    private User user;
    private Scanner scan=new Scanner(System.in);
    private enum Who{
        USER,
        COMPUTER
    }
    private enum Status{
        STRIKE,
        BALL,
        OUT
    }

    private void setGuessStatus(int statusIndex, int who){
        if(who==Who.USER.ordinal()){
            user.setStatus(statusIndex);
        }else{
            computer.setStatus(statusIndex);
        }
    }

    private boolean getOutResult(int []guess, int guessIndex, int[]target, int targetIndex, int who){
        if(guess[guessIndex]==target[targetIndex]){
            if(guessIndex==targetIndex){
                setGuessStatus(Status.STRIKE.ordinal(), who);
            }else{
                setGuessStatus(Status.BALL.ordinal(), who);
            }
            return false;
        }
        return true;
    }

    private void findAns(int[] guess, int [] target, int who){
        boolean isOut=true;
        for(int guessIndex=0;guessIndex<NUM_COUNT;guessIndex++){
            for(int targetIndex=0;targetIndex<NUM_COUNT;targetIndex++){
                isOut=getOutResult(guess, guessIndex, target, targetIndex, who);
                if(isOut==false){
                    break;
                }
            }
            if(isOut){
                setGuessStatus(Status.OUT.ordinal(), who);
            }
        }
    }

    private void printStatus(int[] state){
        if(state[Status.STRIKE.ordinal()]>0){
            System.out.print(state[Status.STRIKE.ordinal()]+"스트라이크 ");
        }
        if(state[Status.BALL.ordinal()]>0){
            System.out.print(state[Status.BALL.ordinal()]+"볼 ");
        }
        if(state[Status.OUT.ordinal()]>0){
            System.out.print(state[Status.OUT.ordinal()]+"아웃 ");
        }
        System.out.println("\n");
    }

    private boolean printResult(int[] state, int who){
        int choice;
        if(state[Status.STRIKE.ordinal()]==NUM_COUNT){
            if(who==Who.USER.ordinal()){
                System.out.println("<승리!> 3개의 숫자를 모두 맞히셨습니다! 게임종료\n");

            }else if(who==Who.COMPUTER.ordinal()){
                System.out.println("<패배ㅠ> 컴퓨터가 먼저 사용자의 숫자를 모두 맞혔습니다.");
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            choice=scan.nextInt();
            if(choice==2){
                System.out.println("게임을 종료합니다.\n");
                return true;
            }else{
                new Solution();
            }
        }
        return false;
    }

    private boolean isFinish(int who){

        int[] state=new int[NUM_COUNT];
        if(who==Who.USER.ordinal()){
            state=user.getStatus();
        }else if(who==Who.COMPUTER.ordinal()){
            state=computer.getStatus();
        }
        printStatus(state);
        return printResult(state, who);
    }

    private boolean userTurn(){
        user.setGuess();
        findAns(user.getGuess(), computer.getOwnNumber(), Who.USER.ordinal());
        return isFinish(Who.USER.ordinal());
    }

    private boolean computerTurn(){
        computer.setGuess();
        findAns(computer.getGuess(), user.getOwnNumber(), Who.COMPUTER.ordinal());
        int[] status=computer.getStatus();
        if(status[Status.OUT.ordinal()]==NUM_COUNT){
            computer.removeAllGuess();
        }else if(status[Status.OUT.ordinal()]==0){
                computer.removeOthers();
        }
        return isFinish(Who.COMPUTER.ordinal());
    }

    public void start(){
        while (true) {
            if(userTurn()==true){
                break;
            }
            if(computerTurn()==true){
                break;
            }
            user.clear();
            computer.clear();
        }
        System.out.println("프로그램이 종료됐습니다.");
    }

    public Solution() {
        System.out.println("게임을 시작합니다.");
        computer = new Computer();
        user = new User();

        computer.setOwnNumber();
        user.setOwnNumber();
    }
}
