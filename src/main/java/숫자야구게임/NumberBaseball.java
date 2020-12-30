package 숫자야구게임;

import java.util.Random;
import java.util.Scanner;

class Solution{
    private static final int NUM_BOUND=10;
    private static final int NUM_SIZE=3;
    private static final int ZERO_UNICODE=48;

    private int[] computer;
    private int[] user;
    private int[] state;

    public enum Status{
        STRIKE,
        BALL,
        OUT
    }

   public boolean getOutResult(int userIndex, int computerIndex){
       if(user[userIndex]==computer[computerIndex]){
           if(userIndex==computerIndex){
               state[Status.STRIKE.ordinal()]++;
           }else {
               state[Status.BALL.ordinal()]++;
           }
           return false;
       }
       return true;
    }

    public void findAns( ){
        state=new int[NUM_SIZE];
        boolean isOut=true;
        for(int ui=0;ui<NUM_SIZE;ui++){
            for(int ci=0;ci<NUM_SIZE;ci++){
                isOut=getOutResult(ui, ci);
                if(isOut==false)break;
            }
            if(isOut){
                state[Status.OUT.ordinal()]++;
            }
        }
     
    }

    public void computerGenerator() {
        Random generator = new Random();
        computer = new int[NUM_SIZE];
        for (int i = 0; i < NUM_SIZE; i++) {
            computer[i] = generator.nextInt(NUM_BOUND);
        }
    }
    public boolean isFinish(){
        int choice;
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
        if(state[Status.STRIKE.ordinal()]==NUM_SIZE){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료\n");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            choice=scan.nextInt();

            if(choice==2){
                System.out.println("게임을 종료합니다.\n");
                return true;
            }else{
                computerGenerator();
            }
        }
        return false;
    }
    public void solution(){

        user=new int[NUM_SIZE];
        String userNumber;

        while(true){
            Scanner scan=new Scanner(System.in);
            System.out.println("숫자를 입력해주세요: ");
            userNumber=scan.nextLine();
            for(int i=0;i<NUM_SIZE;i++){
                user[i]=userNumber.charAt(i)-ZERO_UNICODE;
            }
            findAns();
            if(isFinish()==true){
                return;
            }

        }
    }
}

public class NumberBaseball {
    public static void main(String[] args){
        Solution solution=new Solution();
        solution.computerGenerator();
        solution.solution();

    }
}



