package Model.Password;

import java.util.ArrayList;

public class Password {

    public interface PasswordListener {

        //Action to perform when the password is correct
        public void passwordIsCorrect();

        //Action to perform when we write something in pass
        public void changed();

    }

    private String password = "1234";

    private String pass = "";

    private Boolean isCorrect = false;

    private ArrayList<Password.PasswordListener> allListener;

    public Password() {
        this.setAllListener(null);
    }

    public ArrayList<PasswordListener> getAllListener() {
        return allListener;
    }

    public void setAllListener(ArrayList<PasswordListener> allListener) {
        this.allListener = allListener;
    }

    public void addNewPasswordListener(Password.PasswordListener passwordListener) {
        if (this.allListener == null) {
            this.allListener = new ArrayList<>();
        }
        this.allListener.add(passwordListener);
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void addDigit(int digit) {
        this.pass += digit;
        for (PasswordListener listener : allListener) {
            listener.changed();
        }
    }

    public void removeLastDigit() {
        if (this.pass.length() > 0) {
            this.pass = this.pass.substring(0, this.pass.length() - 1);
        } else {
            this.pass = "";
        }
        for (PasswordListener listener : allListener) {
            listener.changed();
        }
    }

    public void isPassCorrect() {
        if (this.pass.equals(this.password)) {
            for (PasswordListener listener : allListener) {
                listener.passwordIsCorrect();
            }
        }
        clear();
    }


    public void clear() {
        this.pass = "";
        for (PasswordListener listener : allListener) {
            listener.changed();
        }
    }
}
