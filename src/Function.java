import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

public class Function {
    static void write(int status, int a,int b) throws IOException {
        byte[] bytes = {(byte) status, (byte) a, (byte) b};
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);

        FileOutputStream out = new FileOutputStream(FileData.FileName);
        FileChannel fileChannel = out.getChannel();
        fileChannel.write(byteBuffer);
        System.out.println("WROTE:");
        System.out.println(status + " " + a + " " + b);

        byteBuffer.flip();
        fileChannel.close();
        out.close();
    }

    static int status() throws IOException {
        File file = new File(FileData.FileName);

        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate((int)fileChannel.size());
        fileChannel.read(byteBuffer);

        byteBuffer.flip();
        fileChannel.close();
        fileInputStream.close();

        return byteBuffer.get();
    }

    static int[] getNum() throws IOException {
        int[] num = new int[2];
        File file = new File(FileData.FileName);

        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate((int)fileChannel.size());
        fileChannel.read(byteBuffer);

        byteBuffer.flip();
        fileChannel.close();
        fileInputStream.close();

        byteBuffer.get();
        num[0] = byteBuffer.get();
        num[1] = byteBuffer.get();

        return num;
    }
}
