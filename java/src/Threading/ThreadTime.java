package Threading;

public class ThreadTime {


}
 class SumUp{
    long startValue;
    long endValue;
    long counter;
    long Max_Num = Integer.MAX_VALUE;

    public SumUp(long startRange, long endRange){
        this.startValue= startRange;
        this.endValue=endRange;
    }

    public void add(){
        for (long i = startValue; i <=endValue; i++){
            counter +=i;
        }
    }

    public static void addTwoThreads(){
        

    }




}
