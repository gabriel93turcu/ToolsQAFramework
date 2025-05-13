package allureUtility;

import java.io.File;

public class AllureCleaner {
    public static void deleteFolder() {
        File folder = new File("allure-results");

        if (!folder.exists()) {
            System.out.println("Folderul 'allure-results' nu există.");
            return;
        }

        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteFolder(); // recursiv pentru subfoldere
                } else {
                    file.delete();
                }
            }
        }

        if (folder.delete()) {
            System.out.println("Folderul 'allure-results' a fost șters.");
        } else {
            System.out.println("Nu s-a putut șterge folderul 'allure-results'.");
        }
    }
}
