package 숫자야구게임;

import java.util.Random;

public class Computer implements Player {
    int[] ownNumber = new int[3];
    int[] status=new int[3];
    int[] guess=new int[3];
    private Random generator = new Random();

    @Override
    public void setOwnNumber() {
        for (int i = 0; i < 3; i++) {
            ownNumber[i] = generator.nextInt(10);
        }

        System.out.println("컴퓨터 숫자: ");
        for(int i=0;i<3;i++){
            System.out.print(ownNumber[i]+" ");
        }
    }

    @Override
    public int[] getOwnNumber() {
        return ownNumber;
    }

    @Override
    public void setStatus(int i) {
        status[i]++;

    }

    @Override
    public int[] getStatus() {
        return status;
    }

    @Override
    public void setGuess() {
        System.out.println("컴퓨터가 사용자를 추측할 차례입니다.");
        for (int i = 0; i < 3; i++) {
            guess[i] = generator.nextInt(10);
            System.out.print(guess[i]+" ");
        }
        System.out.println("값을 추측했습니다.");
    }

    @Override
    public int[] getGuess() {
        return guess;
    }

    @Override
    public void clear() {
        for(int i=0;i<3;i++){
            guess[i]=0;
            status[i]=0;
        }
    }
}
