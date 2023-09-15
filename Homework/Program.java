package Homework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Program
 */
public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Введите данные записи, разделенные пробелом(пустая строка - выход):");
            String data = scanner.nextLine();
            String[] splitData = data.split(" ");
            switch (isCorrectAmount(splitData)) {
                case 2:
                    System.out.println("Выход из программы...");
                    exit = true;
                    break;
                case -1:
                    System.out.println("Введено меньше данных, чем требуется!");
                    break;
                case 1:
                    System.out.println("Введено больше данных, чем требуется!");
                    break;

                default:
                    Record record = parsingData(splitData);
                    if (record.isGenderPresent() && record.isDatePresent() && record.isPhNumPresent()
                            && record.isLastNamePresent() && record.isFirstNamePresent()
                            && record.isSecondNamePresent()) {
                        writeInFile(record);
                    } else
                        System.out.println("Введены некорректные данные! Повторите ввод");

                    break;
            }
        }

        scanner.close();
    }

    static void writeInFile(Record rec) {
        File file = new File(rec.getLastName() + ".txt");
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(rec + "\n");
            fileWriter.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    static int isCorrectAmount(String[] array) {
        if (array[0].equals(""))
            return 2;
        if (array.length == 6)
            return 0;
        if (array.length > 6)
            return 1;
        return -1;
    }

    static Record parsingData(String[] d) {
        Record rec = new Record();
        for (String part : d) {
            if (!rec.isGenderPresent())
                if (rec.parsGender(part))
                    continue;
            if (!rec.isDatePresent())
                if (rec.parsDate(part))
                    continue;
            if (!rec.isPhNumPresent())
                if (rec.parsPhoneNumber(part))
                    continue;
            if (!rec.isLastNamePresent()) {
                rec.setLastName(part);
                rec.setLastNamePresent(true);
                continue;
            }
            if (!rec.isFirstNamePresent() && rec.isLastNamePresent()) {
                rec.setFirstName(part);
                rec.setFirstNamePresent(true);
                continue;
            }

            if (!rec.isSecondNamePresent() && rec.isFirstNamePresent()) {
                rec.setSecondName(part);
                rec.setSecondNamePresent(true);
            }

        }
        return rec;
    }
}