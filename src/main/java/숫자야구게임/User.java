package 숫자야구게임;

public class User implements Player {
    int[] ownNumber = new int[3];
    int[] status=new int[3];
    int[] guess=new int[3];

    @Override
    public void setOwnNumber() {
        System.out.println("사용자의 비밀숫자 3개를 연속으로 입력하세요.");
        String userNumber=scan.nextLine();
        for(int i=0;i<3;i++){
            ownNumber[i]=userNumber.charAt(i)-'0';
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
        System.out.println("사용자가 컴퓨터를 추측할 차례입니다. 숫자를 입력해주세요: ");
        String guessNumber=scan.nextLine();
        for(int i=0;i<3;i++){
            guess[i]=guessNumber.charAt(i)-'0';
        }
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
