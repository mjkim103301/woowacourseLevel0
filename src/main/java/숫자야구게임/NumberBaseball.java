package 숫자야구게임;

import java.util.Random;
import java.util.Scanner;

class Solution{
    public enum Status{
        STRIKE,
        BALL,
        OUT
    }
    public int[] findAns(int[] computer, int[]user){
        int[] state=new int[3];
        boolean isOut=true;
        for(int ui=0;ui<3;ui++){
            for(int ci=0;ci<3;ci++){
                if(user[ui]==computer[ci]){
                    if((ui==ci)||(user[ui]==computer[ui])){
                        state[Status.STRIKE.ordinal()]++;
                    }else {
                        state[Status.BALL.ordinal()]++;
                    }
                    isOut=false;
                    break;
                }

            }
            if(isOut){
                state[Status.OUT.ordinal()]++;
            }
            isOut=true;
        }
        return state;
    }
    public int[] computerGenerator(){
        Random generator=new Random();
        int[] computer=new int[3];
        for(int i=0;i<3;i++){
            computer[i]=generator.nextInt(10);
        }
        return computer;
    }
    public void solution(int[] computer){

        int []user=new int[3];
        String userNumber;
        int []state;
        int choice;
        while(true){
            Scanner scan=new Scanner(System.in);
            System.out.println("숫자를 입력해주세요: ");
            userNumber=scan.nextLine();
            for(int i=0;i<3;i++){
                user[i]=userNumber.charAt(i)-48;
            }
            state=findAns(computer, user).clone();

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
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료\n");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
                choice=scan.nextInt();
                if(choice==2){
                    System.out.println("게임을 종료합니다.\n");
                    return;
                }else{
                    computer=computerGenerator();
                }
            }
        }
    }
}
public class NumberBaseball {
    public static void main(String[] args){
        Solution solution=new Solution();
        int[]computer=solution.computerGenerator();
        solution.solution(computer);

    }


}

