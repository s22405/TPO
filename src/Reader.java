import java.io.IOException;

public class Reader {
    //0 - written, 1 - read
    public static void main(String[] args) throws IOException, InterruptedException {
        while(true){
           if(Function.status() == 0){
               int[] num = Function.getNum();
               System.out.println(num[0] + " + " + num[1] + " = " + (num[0] + num[1]));

               System.out.print("READER ");
               Function.write(1,num[0],num[1]);
           }
            Thread.sleep(105);
        }

    }


}
