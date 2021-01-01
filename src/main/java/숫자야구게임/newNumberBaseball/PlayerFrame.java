package 숫자야구게임.newNumberBaseball;

public abstract class PlayerFrame implements Player {
    static final int NUM_COUNT=3;
    int[] ownNumber = new int[NUM_COUNT];
    int[] status=new int[NUM_COUNT];
    int[] guess=new int[NUM_COUNT];

    @Override
    public abstract void setOwnNumber();

    int[] getOwnNumber() {
        return ownNumber;
    }

    void setStatus(int i){
        status[i]++;
    }

    int[] getStatus() {
        return status;
    }

    @Override
    public abstract void setGuess();

    int[] getGuess() {
        return guess;
    }

    void clear() {
        guess=new int[NUM_COUNT];
        status=new int[NUM_COUNT];
    }
}
