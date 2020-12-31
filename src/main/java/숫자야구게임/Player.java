package 숫자야구게임;

import java.util.Scanner;

public interface Player {
    Scanner scan=new Scanner(System.in);
    void setOwnNumber();
    int[] getOwnNumber();
    void setStatus(int i);
    int[] getStatus();
    void setGuess();
    int[] getGuess();
    void clear();

}
