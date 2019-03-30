
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class TaskThreadDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(new delete_file());
        executor.execute(new take_photo());
        executor.shutdown();

    }


    //判断文件夹中是否有文件
    public static boolean HaveFile(String file_path) {

        File file = new File(file_path);
        File[] listFiles = file.listFiles();
        if (listFiles.length > 0) {
            return true;
        } else {
            return false;
        }
    }


    //获得文件夹中一个文件的路径
    public static String Get_file_path(String file_path) {
        File file = new File(file_path);
        File[] listFiles = file.listFiles();
        String photo_path = listFiles[0].getAbsolutePath();
        return photo_path;
    }


    //删除文件夹中文件
    public static void Delete_file(String file_name) {
        File file = new File(file_name);
        if (!file.exists()) {
            System.out.println("删除文件失败:" + file_name + "不存在！");
        } else {
            System.out.println("删除文件成功！");
        }
    }
}


class take_photo implements Runnable{
    @Override
    public void run(){
        while(true){
            try {
                System.out.println("take photo success");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class delete_file implements Runnable{
    @Override
    public void run(){
        while(true){
            try {
                System.out.println("成功删除！");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}