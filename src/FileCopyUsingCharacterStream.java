import java.io.*;

public class FileCopyUsingCharacterStream {
    public static void main(String[] args) {
        File sourceFile = new File("source.txt");
        File destinationFile = new File("destination.txt");

        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(sourceFile), "UTF-8");
             OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(destinationFile), "UTF-8")) {

            char[] buffer = new char[1024];
            int charsRead;
            while ((charsRead = isr.read(buffer)) != -1) {
                osw.write(buffer, 0, charsRead);
            }

            System.out.println("文件复制完成（使用转换流）！");
        } catch (IOException e) {
            System.out.println("文件复制失败: " + e.getMessage());
        }
    }
}
