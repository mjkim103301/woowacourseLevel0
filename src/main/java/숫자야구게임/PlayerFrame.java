package 숫자야구게임;

public abstract class PlayerFrame implements Player {
    static final int NUM_COUNT=3;
    int[] ownNumber = new int[NUM_COUNT];
    int[] status=new int[NUM_COUNT];
    int[] guess=new int[NUM_COUNT];

    @Override
    public abstract void setOwnNumber();

    public int[] getOwnNumber() {
        return ownNumber;
    }

    public void setStatus(int i){
        status[i]++;
    }

    public int[] getStatus() {
        return status;
    }

    @Override
    public abstract void setGuess();

    public int[] getGuess() {
        return guess;
    }

    public void clear() {
        guess=new int[NUM_COUNT];
        status=new int[NUM_COUNT];
    }
}
