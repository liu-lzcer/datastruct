import java.io.*;

public class FileCopyUsingByteStream {
    public static void main(String[] args) {
        File sourceFile = new File("source.txt");
        File destinationFile = new File("destination.txt");

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("文件复制完成！");
        } catch (IOException e) {
            System.out.println("文件复制失败: " + e.getMessage());
        }
    }
}
