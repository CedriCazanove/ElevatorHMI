package Controller.ListenerBehaviour;

import Model.Password.Password;
import View.ElevatorView;

public class ElevatorViewAnswerPasswordListener implements Password.PasswordListener {

    private ElevatorView elevatorView;
    private Password password;

    public ElevatorViewAnswerPasswordListener(ElevatorView elevatorView, Password password) {
        this.elevatorView = elevatorView;
        this.password = password;
    }

    @Override
    public void passwordIsCorrect() {
        elevatorView.getPanelCodeAccessSupervisor().setVisible(false);
        elevatorView.setSupervisor(true);
        elevatorView.getPanelSupervisor().setVisible(elevatorView.getSupervisor());
    }

    @Override
    public void changed() {
        elevatorView.getLblPassword().setText(password.getPass());
    }
}
