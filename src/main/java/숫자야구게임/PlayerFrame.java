package 숫자야구게임;

public abstract class PlayerFrame implements Player {
    int[] ownNumber = new int[3];
    int[] status=new int[3];
    int[] guess=new int[3];

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
        for(int i=0;i<3;i++){
            guess[i]=0;
            status[i]=0;
        }
    }
}
