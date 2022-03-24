import java.io.*;

//0 - written, 1 - read
public class Writer {
    public static void main(String[] args) throws IOException, InterruptedException {
            int[] num = new int[2];
            num[0] = (int)(Math.random() * 10);
            num[1] = (int)(Math.random() * 10);

            System.out.print("WRITER ");
            Function.write(0, num[0], num[1]);

            while (true) {
                if (Function.status() == 1) {
                    num[0] = (int) (Math.random() * 10);
                    num[1] = (int) (Math.random() * 10);

                    System.out.print("WRITER ");
                    Function.write(0, num[0], num[1]);
                }
                Thread.sleep(100);
            }
    }

}
