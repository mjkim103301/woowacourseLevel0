package 숫자야구게임.newNumberBaseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Computer extends PlayerFrame {
    private Random generator = new Random();
    private ArrayList<Integer> numberRange= new ArrayList<>();
    private HashMap<String, Integer> hash=new HashMap<>();
    private ArrayList<Integer> computerRange=new ArrayList<>();

    Computer(){
        for(int i=0;i<10;i++){
            numberRange.add(i);
            computerRange.add(i);
        }
    }

    @Override
    public void setOwnNumber() {
        for (int i = 0; i < NUM_COUNT; i++) {
            int index=generator.nextInt(computerRange.size());
            ownNumber[i] = computerRange.get(index);
            computerRange.remove(index);
        }
        System.out.println("컴퓨터 숫자: ");
        for(int i=0;i<NUM_COUNT;i++){
            System.out.print(ownNumber[i]+" ");
        }
        System.out.println();
    }

    private String makeCandidates(){
        String candidate="";
        ArrayList<Integer> numberCandidates = (ArrayList<Integer>) numberRange.clone();
        for (int i = 0; i < NUM_COUNT; i++) {
            int index=generator.nextInt(numberCandidates.size());
            guess[i] = numberCandidates.get(index);
            numberCandidates.remove(index);
            candidate+=guess[i];
        }
        return candidate;
    }

    @Override
    public void setGuess() {
        System.out.println("컴퓨터가 사용자를 추측할 차례입니다.");
        System.out.println("숫자 후보들입니다.");
        int size=numberRange.size();
        for(int j=0;j<size;j++){
            System.out.print(numberRange.get(j)+", ");
        }
        System.out.println();
        while(true){
            String candidate=makeCandidates();
            if(!hash.containsKey(candidate)){
                hash.put(candidate,1);
                break;
            }
        }
        for(int i=0;i<NUM_COUNT;i++){
            System.out.print(guess[i]+" ");
        }
        System.out.println("값을 추측했습니다.");
    }

    void removeAllGuess(){
        for(int i=0;i<NUM_COUNT;i++){
            int num=guess[i];
            numberRange.remove((Integer) num);
        }
    }

    void removeOthers(){
        int []remain;
        if(numberRange.size()<=NUM_COUNT){
            return;
        }
        remain=guess.clone();
        Arrays.sort(remain);
        numberRange.clear();
        for(int i=0;i<NUM_COUNT;i++){
            numberRange.add(remain[i]);
        }
    }
}
