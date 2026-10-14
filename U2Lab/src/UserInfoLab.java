import java.util.Scanner;

public class UserInfoLab {
    public static void main(String[] args) {
        // Part 1
        // Create a Scanner for keyboard input
        // Ask the user to enter their first and last name and pass these
        // values to the generateUsername method and save the returned result.
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        String firstName = kb.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = kb.nextLine();
        String username = generateUsername(firstName, lastName);
        System.out.println("Username: " + username);
        // Part 2
        // Ask the user to enter a password and pass this value to the validatePassword method.
        // The validatePassword method will check if the password meets the criteria:
        System.out.println("Enter a password: ");
        String password = kb.nextLine();
        boolean isValid = validatePassword(password);
        // Part 3
        // If the user entered a valid password in step 2, then ask the user to enter their
        // credit card number and pass this value to the maskCreditCard method.
        if (isValid) {
            System.out.println("Enter a your credit card number: ");
            String credCard = kb.nextLine();
            String masked = maskCreditCard(credCard);
            System.out.println(masked);
        } else {
            System.out.println("N/A");

        }
    }
        // Part 4
        // If the user entered a valid password AND valid credit card number, display the output
        // as shown in the demo video
        // https://drive.google.com/file/d/1sMOw5wkOgSfuUcvQhFyZ5flnv_d9qQd3/view?usp=sharing



    public static String generateUsername(String firstName, String lastName) {
        String firstPart = firstName;
        if (firstName.length() >= 3) {
            firstPart = firstName.substring(0, 3);
        }
        String lastPart = lastName;
        if (lastName.length() >= 3) {
            lastPart = lastName.substring(0, 3);
        }
        String userName = firstPart + lastPart;
        userName = userName.toLowerCase();
        return userName;
    }

public static boolean validatePassword(String password){
            boolean valid = true;
            if (password.length() < 8) {
                System.out.println("Invalid(too short)");
                valid = false;
            }
            boolean hasUpper = false;
            for (int i = 0; i < password.length(); i++) {
                if (Character.isUpperCase(password.charAt(i))) {
                    hasUpper = true;
                }
            }
            if (!hasUpper) {
                System.out.println("Invalid(No Capitalized Letter)");
                valid = false;
            }
            if (!containsDigit(password)) {
                System.out.println("Invalid(No digit)");
                valid = false;
            }
            return valid;
        }

    public static String maskCreditCard(String creditCardNumber) {
        if(creditCardNumber.length() == 16){
            if(allDigits(creditCardNumber)){
                return "**** **** **** " + creditCardNumber.substring(12);
            }
            else{
                return "N/A";
            }
        }
        else{
            return "N/A";
        }
    }


    /**
     This method verifies that the string contains at least one numeric digit
     @param str The string to check
     @return true or false if a digit is present
     */
    public static boolean containsDigit(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (Character.isDigit(c))
                return true;
        }
        return false;
    }

    /**
     * Checks if the entire String is all numerical
     * @param str The string to check
     * @return true or false if the string is ALL digits
     */
    public static boolean allDigits(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

}
