package 숫자야구게임;

import java.util.ArrayList;
import java.util.Random;

public class Computer extends PlayerFrame {
    private Random generator = new Random();
    private ArrayList<Integer> numberRange= new ArrayList<>();

    public Computer(){
        for(int i=0;i<10;i++){
            numberRange.add(i);
        }
    }
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
    public void setGuess() {
        ArrayList<Integer> numberCandidates= new ArrayList<>();
        numberCandidates= (ArrayList<Integer>) numberRange.clone();
        System.out.println("컴퓨터가 사용자를 추측할 차례입니다.");
        System.out.println("숫자 후보들입니다.");
        int size=numberCandidates.size();
        for(int j=0;j<size;j++){
            System.out.print(numberCandidates.get(j)+", ");
        }
        System.out.println();

        for (int i = 0; i < 3; i++) {
            int index=generator.nextInt(numberCandidates.size());
            guess[i] = numberCandidates.get(index);
            numberCandidates.remove(index);
            System.out.print(guess[i]+" ");
        }
        System.out.println("값을 추측했습니다.");
    }
    public void removeAllGuess(){
        for(int i=0;i<3;i++){
            int num=guess[i];
            numberRange.remove((Integer) num);
        }
    }
    public void removeOthers(){
        int []remain=guess.clone();
        numberRange.clear();
        for(int i=0;i<3;i++){
            numberRange.add(remain[i]);
        }
    }
}
