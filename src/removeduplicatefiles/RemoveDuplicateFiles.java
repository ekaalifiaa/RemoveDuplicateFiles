/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package removeduplicatefiles;

/**
 *
 * @author Dell 7300
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateFiles {
    public static void main(String[] args) {
        // Ganti dengan path folder yang ingin diperiksa
        String folderPath = "C:\\Users\\Dell 7300\\Downloads\\Check This Folder";

        // Membuat objek File untuk merepresentasikan folder
        File folder = new File(folderPath);

        // Memeriksa apakah itu benar-benar folder dan eksis
        if (folder.isDirectory()) {
            // Mendapatkan daftar file dalam folder
            File[] files = folder.listFiles();

            // Membuat HashSet untuk menyimpan isi file
            Set<String> fileContents = new HashSet<>();

            // Memeriksa file-file dalam folder
            for (File file : files) {
                try {
                    // Membaca isi file sebagai string
                    String content = new String(Files.readAllBytes(file.toPath()));

                    // Memeriksa apakah isi file sudah ada
                    if (!fileContents.contains(content)) {
                        // Menambahkan isi file ke HashSet
                        fileContents.add(content);
                    } else {
                        // Menghapus file duplikat
                        Files.delete(file.toPath());
                        System.out.println("File dihapus: " + file.getName());
                    }
                } catch (IOException e) {
                    System.out.println("Gagal memproses file: " + file.getName());
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Path yang diberikan bukanlah sebuah folder.");
        }
    }
}