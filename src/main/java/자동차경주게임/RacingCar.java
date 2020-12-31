package 자동차경주게임;

import java.util.*;

class Car{
    String name;
    int location;
    int random;
    public Car(String name, int location, int random){
        this.name=name;
        this.location=location;
        this.random=random;
    }
}
class Solution{
    private static final int NUM_BOUND=10;
    Scanner scanner=new Scanner(System.in);
    ArrayList<Car> cars=new ArrayList<>();
    int N;
    int numberOfCars=0;

    void init(String carNames) {
        String carName;
        int division = -1;
        int lastDivision;
        do {
            lastDivision = division + 1;
            division = carNames.indexOf(",", lastDivision);
            if (division > 0) {
                carName = carNames.substring(lastDivision, division);
                cars.add(new Car(carName, 0, 0));
            }
        } while (division != -1);
        carName = carNames.substring(lastDivision);
        cars.add(new Car(carName, 0, 0));
        numberOfCars = cars.size();
    }

    public void run(){
        Random generator = new Random();

        for (int i = 0; i < numberOfCars; i++) {
            cars.get(i).random= generator.nextInt(NUM_BOUND);
            if(cars.get(i).random>3){
                cars.get(i).location++;
            }
        }
    }

    public void sort(){
        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car car, Car t1) {
                return t1.location-car.location;
            }
        });
    }

    public int findWinner(){
        int winnerIndex=0;

        sort();
        for(int i=1;i<numberOfCars;i++){
            if(cars.get(winnerIndex).location==cars.get(i).location){
                winnerIndex++;
                continue;
            }
            break;
        }
        return winnerIndex;
    }

    public void printLocation(){
        for(int j=0;j<numberOfCars;j++){
            System.out.print(cars.get(j).name+": ");
            for(int k=0;k<cars.get(j).location;k++){
                System.out.print("-");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public void printWinner(int winnerIndex){
        for(int j=0;j<=winnerIndex;j++){
            if(j>0){
                System.out.print(", ");
            }
            System.out.print(cars.get(j).name);
        }
        System.out.println("가 최종 우승했습니다.");
    }

    public void solution(){
        String carNames;
        int winnerIndex;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = scanner.nextLine();

        init(carNames);
        System.out.println("\n시도할 회수는 몇회인가요?");
        N=scanner.nextInt();
        System.out.println("\n실행결과");
        for(int i=0;i<N;i++){
            run();
            printLocation();
        }
        winnerIndex=findWinner();
        printWinner(winnerIndex);
    }
}

public class RacingCar {
    public static void main(String[] args){
        Solution sol=new Solution();
        sol.solution();
    }
}
