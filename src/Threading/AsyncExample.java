package Threading;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class AsyncExample {
   public static int calcualtesum(int a[]){

       try{

           Thread.sleep(3000);
       }
       catch (Exception e){
           System.out.println(e);
       }
       return Arrays.stream(a).sum();


   }

    public static void main(String[] args) {
        int a[]={1,2,3};
        CompletableFuture<Integer> sum=CompletableFuture.supplyAsync(()->calcualtesum(a));
        CompletableFuture<Integer> square=sum.thenApplyAsync(result->result*result);
        CompletableFuture<Void>  printresult=square.thenAcceptAsync(result-> System.out.println(result));

        System.out.println("executing taks 5...................");

        printresult.join();
    }

}
