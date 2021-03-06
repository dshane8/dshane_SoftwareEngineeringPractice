package edu.ithaca.dragon.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email) && isAmountValid(startingBalance)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("One or more of the values you entered are invalid, cannot create account");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance, if the amount is greater
     * than the balance or negative, it should do nothing
     */
    public void withdraw (double amount)  {
        if (amount < balance && isAmountValid(amount)) {
            balance -= amount;
        }
    }

    /**
     * An email is valid if it contains one '@' sign
     * @param email - string of the email address to be validated
     * @return - true if the email is valid, false if not
     */
    public static boolean isEmailValid(String email){
        if (email.indexOf('@') >= 0){
            if (email.indexOf('@') == email.lastIndexOf('@')){
                return true;
            }
        }
        return false;
    }

    public static boolean isAmountValid(double amount){
        if (amount >= 0){
            String amt = Double.toString(amount);
            int numDecimalPlaces = amt.length() - amt.indexOf('.') - 1;
            if (numDecimalPlaces < 3){
                return true;
            }
        }
        return false;
    }
}
