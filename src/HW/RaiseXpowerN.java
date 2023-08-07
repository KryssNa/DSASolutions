package HW;

public class RaiseXpowerN {

        public static void main(String[] args) {
            int x=2;
            int n=2;
            int ans=power(x,n);
            System.out.println(ans);
        }
        static int power(int x,int n){
            if(n==0){
                return 1;
            }
            int temp=power(x,n/2);

            if(n%2==0){
                return temp*temp;
            }
            else{
                return temp*temp*x;
            }
        }
}
