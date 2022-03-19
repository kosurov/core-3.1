import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();
        File tempFile = new File("D:\\Games\\GameOfTheYear\\temp", "temp.txt");

        File[] dirs = new File[] {
                new File("D:\\Games\\GameOfTheYear\\src\\"),
                new File("D:\\Games\\GameOfTheYear\\res"),
                new File("D:\\Games\\GameOfTheYear\\savegames"),
                new File("D:\\Games\\GameOfTheYear\\temp"),
                new File("D:\\Games\\GameOfTheYear\\src\\main"),
                new File("D:\\Games\\GameOfTheYear\\src\\test"),
                new File("D:\\Games\\GameOfTheYear\\res\\drawables"),
                new File("D:\\Games\\GameOfTheYear\\res\\vectors"),
                new File("D:\\Games\\GameOfTheYear\\res\\icons")
        };

        File[] files = new File[] {
                new File("D:\\Games\\GameOfTheYear\\src\\main", "Main.java"),
                new File("D:\\Games\\GameOfTheYear\\src\\main", "Utils.java"),
                tempFile
        };

        for (File dir : dirs) {
            log.append(createDirAndGetLog(dir));
        }

        for (File file : files) {
            log.append(createFileAndGetLog(file));
        }

        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write(log.toString());
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static String createDirAndGetLog(File dir) {
        if (dir.mkdir()) {
            return "Каталог '" + dir.getPath() + "' успешно создан.\n";
        } else {
            return "Не удалось создать каталог '" + dir.getPath() + "'.\n";
        }
    }

    public static String createFileAndGetLog(File file) {
        try {
            if (file.createNewFile()) {
                return "Файл '" + file.getName() + "' в каталоге '" + file.getParent() + "' успешно создан.\n";
            } else {
                return "Не удалось создать файл '" + file.getName() + "' в каталоге '" + file.getParent() + "'.\n";
            }
        } catch (IOException exception) {
            return "Не удалось создать файл '" + file.getName() + "'. " + exception.getMessage() + "\n";
        }
    }
}
