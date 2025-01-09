package sus.amogus.practice_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MorseDecoder {

    private static Map<String, String> morseCodeMap = new HashMap<>();

    public static void main(String[] args) {
        // Загрузка алфавита из файла
        loadMorseCodeMap("morse_code.txt");

        // Пример зашифрованного сообщения
        String encryptedMessage = ".... . .-.. .-.. --- / .-- --- .-. .-.. -..";

        // Расшифровка сообщения и вывод в консоль
        String decryptedMessage = decryptMessage(encryptedMessage);
        System.out.println("Расшифрованное сообщение: " + decryptedMessage);
    }

    /**
     * Загружает азбуку Морзе из файла в словарь.
     * @param filename имя файла
     */
    private static void loadMorseCodeMap(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/"+filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    morseCodeMap.put(parts[1], parts[0]); // Morse code как ключ, символ как значение
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    /**
     * Расшифровывает сообщение азбукой Морзе.
     * @param message сообщение
     * @return расшифрованное сообщение
     */
    private static String decryptMessage(String message) {
        StringBuilder result = new StringBuilder();
        String[] words = message.split(" / "); // Разделение на слова
        for (String word : words) {
            String[] letters = word.split(" "); // Разделение на буквы
            for (String letter : letters) {
                String decryptedLetter = morseCodeMap.get(letter);
                if (decryptedLetter != null) {
                    result.append(decryptedLetter);
                } else {
                    //System.out.print("?");
                }
            }
            result.append(" ");
        }
        return result.toString().trim();
    }
}