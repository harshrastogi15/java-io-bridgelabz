package watchservice;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class WatchServiceFile {
        private static final String DIRECTORY = "file/";

        public static void main(String[] args) {
            try {

                WatchService watchService = FileSystems.getDefault().newWatchService();
                Path directoryPath = Paths.get(DIRECTORY);
                directoryPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                        StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

                Thread watcherThread = new Thread(() -> watchDirectory(watchService));
                watcherThread.start();


            } catch (IOException e) {
                System.out.println("Error");
            }
        }


    /**
     *
     * Method to watch directory using watch service
     *
     * @param watchService
     */

    private static void watchDirectory(WatchService watchService) {
            try {
                while (true) {
                    WatchKey key = watchService.take();

                    for (WatchEvent<?> event : key.pollEvents()) {
                        System.out.println("Event Type: " + event.kind() + ", File Affected: " + event.context());
                        Path file =  (Path) event.context();
                        Path currentPath = Paths.get(DIRECTORY).resolve(file);
                        if (!currentPath.getFileName().toString().endsWith("~")) {
                            System.out.println(currentPath);
                            int entries = countEntries(currentPath);
                            System.out.println("Entries in File : " + currentPath + " is " + entries);
                        }
                    }


                    boolean reset = key.reset();
                    if (!reset) {
                        break;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    /**
     *
     * Method to find entries in file
     *
     * @param filePath
     * @return
     */
    private static int countEntries(Path filePath) {
            int entryCount = 0;

            try {
                entryCount = (int) Files.lines(filePath).count();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return entryCount;
        }

}
