import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ccwc {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java ccwc [-w] [-l] [-c] [-b] filename");
            System.exit(1);
        }

        String option = args[0];
        String filename = args[1];

        try {
            switch (option) {
                case "-w":
                    int wordCount = countWords(filename);
                    System.out.println("Word count: " + wordCount);
                    break;
                case "-l":
                    int lineCount = countLines(filename);
                    System.out.println("Line count: " + lineCount);
                    break;
                case "-c":
                    int charCount = countCharacters(filename);
                    System.out.println("Character count: " + charCount);
                    break;
                case "-b":
                    long byteCount = countBytes(filename);
                    System.out.println("Byte count: " + byteCount);
                    break;
                default:
                    System.out.println("Invalid option. Please use -w, -l, -c, or -b.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static int countWords(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int wordCount = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                // Memecah baris menjadi kata-kata menggunakan spasi sebagai delimiter
                String[] words = line.split("\\s+");
                wordCount += words.length; // Menambah jumlah kata dalam baris ke total jumlah kata
            }
            return wordCount;
        }
    }

    private static int countLines(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int lineCount = 0;
            while (reader.readLine() != null) {
                lineCount++;
            }
            return lineCount;
        }
    }

    private static int countCharacters(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int charCount = 0;
            while (reader.read() != -1) {
                charCount++;
            }
            return charCount;
        }
    }

    private static long countBytes(String filename) throws IOException {
        try (FileReader fileReader = new FileReader(filename)) {
            long byteCount = 0;
            while (fileReader.read() != -1) {
                byteCount++;
            }
            return byteCount;
        }
    }
}
