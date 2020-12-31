package 숫자야구게임;

import java.util.Scanner;

public class Solution {
    Computer computer;
    User user;
    enum Who{
        user,
        computer
    }
    enum Status{
        STRIKE,
        BALL,
        OUT
    };
    public void setGuessStatus(int statusIndex, int who){
        if(who==Who.user.ordinal()){
            user.setStatus(statusIndex);
        }else{
            computer.setStatus(statusIndex);
        }
    }
    public boolean getOutResult(int []guess, int guessIndex, int[]target, int targetIndex, int who){
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

    public void findAns(int[] guess, int [] target, int who){
        boolean isOut=true;
        for(int guessIndex=0;guessIndex<3;guessIndex++){
            for(int targetIndex=0;targetIndex<3;targetIndex++){
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

    public boolean isFinish(int who){
        int choice;
        int[] state=new int[3];
        if(who==Who.user.ordinal()){
            state=user.getStatus();
        }else if(who==Who.computer.ordinal()){
            state=computer.getStatus();
        }

        Scanner scan=new Scanner(System.in);
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
        if(state[Status.STRIKE.ordinal()]==3){
            if(who==Who.user.ordinal()){
                System.out.println("<승리!> 3개의 숫자를 모두 맞히셨습니다! 게임종료\n");

            }else if(who==Who.computer.ordinal()){
                System.out.println("패배. 컴퓨터가 먼저 사용자의 숫자를 모두 맞혔습니다.");
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

    public boolean userTurn(){
        user.setGuess();
        findAns(user.getGuess(), computer.getOwnNumber(), Who.user.ordinal());
        return isFinish(Who.user.ordinal());
    }

    public boolean computerTurn(){
        computer.setGuess();
        findAns(computer.getGuess(), user.getOwnNumber(), Who.computer.ordinal());
        return isFinish(Who.computer.ordinal());
    }

    public Solution() {
        System.out.println("게임을 시작합니다.");
        computer = new Computer();
        user = new User();

        computer.setOwnNumber();
        user.setOwnNumber();

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

        System.out.println("게임이 종료됐습니다.");
    }
}
