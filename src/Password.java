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

    private Password.PasswordListener listener;

    public Password() {
        this.setListener(null);
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public PasswordListener getListener() {
        return listener;
    }

    public void setListener(PasswordListener listener) {
        this.listener = listener;
    }

    public void addDigit(int digit) {
        this.pass += digit;
        if (listener != null) {
            listener.changed();
        }
    }

    public void removeLastDigit() {
        if (this.pass.length() > 0) {
            this.pass = this.pass.substring(0, this.pass.length() - 1);
        } else {
            this.pass = "";
        }
        if (listener != null) {
            listener.changed();
        }
    }

    public void isPassCorrect() {
        if (this.pass.equals(this.password)) {
            if (listener != null) {
                listener.passwordIsCorrect();
            }
        }
        this.pass = "";
        if (listener != null) {
            listener.changed();
        }
    }
}
