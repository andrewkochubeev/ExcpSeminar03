package Homework;

public class Record {
    private String lastName;
    private String firstName;
    private String secondName;
    private String date;
    private long phoneNumber;
    private char gender;
    private boolean isLastNamePresent = false;

    public void setLastNamePresent(boolean isLastNamePresent) {
        this.isLastNamePresent = isLastNamePresent;
    }

    public boolean isLastNamePresent() {
        return isLastNamePresent;
    }

    private boolean isFirstNamePresent = false;

    public void setFirstNamePresent(boolean isFirstNamePresent) {
        this.isFirstNamePresent = isFirstNamePresent;
    }

    public boolean isFirstNamePresent() {
        return isFirstNamePresent;
    }

    private boolean isSecondNamePresent = false;

    public void setSecondNamePresent(boolean isSecondNamePresent) {
        this.isSecondNamePresent = isSecondNamePresent;
    }

    public boolean isSecondNamePresent() {
        return isSecondNamePresent;
    }

    private boolean isGenderPresent = false;

    public boolean isGenderPresent() {
        return isGenderPresent;
    }

    private boolean isDatePresent = false;

    public boolean isDatePresent() {
        return isDatePresent;
    }

    private boolean isPhNumPresent = false;

    public boolean isPhNumPresent() {
        return isPhNumPresent;
    }

    public boolean parsGender(String s) {
        if ((s.charAt(0) == 'f' || s.charAt(0) == 'm') && s.length() == 1) {
            gender = s.charAt(0);
            isGenderPresent = true;
            return true;
        }
        return false;

    }

    public boolean parsPhoneNumber(String s) {
        if (s.charAt(0) == '8' && s.length() == 11) {
            try {
                phoneNumber = Long.parseLong(s);
                isPhNumPresent = true;
                return true;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public boolean parsDate(String s) {
        if (s.length() == 10 && s.charAt(2) == '.' && s.charAt(5) == '.') {
            String[] array = s.split("\\.");
            if (array.length != 3)
                return false;
            try {
                int day = Integer.parseInt(array[0]);
                if (day <= 0 || day > 31)
                    return false;
                int month = Integer.parseInt(array[1]);
                if (month <= 0 || month > 12)
                    return false;
                int year = Integer.parseInt(array[2]);
                if (year <= 1899 || year > 2023)
                    return false;
                isDatePresent = true;
                date = s;
                return true;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return lastName + firstName + secondName + date + phoneNumber + gender;
    }
}
