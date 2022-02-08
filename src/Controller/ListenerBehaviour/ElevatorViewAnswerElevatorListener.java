package Controller.ListenerBehaviour;

import Model.Elevator.Elevator;
import View.Ressource;
import View.ElevatorView;

public class ElevatorViewAnswerElevatorListener implements Elevator.ElevatorListener {

    private Elevator elevator;
    private ElevatorView elevatorView;
    private Ressource rsc;

    public ElevatorViewAnswerElevatorListener(ElevatorView elevatorView, Elevator elevator) {
        this.elevator = elevator;
        this.elevatorView = elevatorView;
    }

    @Override
    public void doorStateChanged() {
        System.out.println("ElevatorView : The state of door changed");
        switch (elevator.getElevatorState()) {
            case INSERVICE:
                System.out.println(elevator.toString());
                switch (elevator.getElevatorState()) {
                    case INSERVICE:
                        switch(elevator.getDoorState()) {
                            case OPEN:
                                elevatorView.getLabelElevator().setIcon(rsc.getIconElevatorOpen());
                                break;
                            case CLOSE:
                                elevatorView.getLabelElevator().setIcon(rsc.getIconElevatorClose());
                                break;
                            case OPENING:
                            case CLOSING:
                                elevatorView.getLabelElevator().setIcon(rsc.getIconElevatorInTransition());
                                break;
                            default:
                                System.out.println("ElevatorView : no match");
                        }
                        break;
                    default:
                        System.out.println("ElevatorView is not in service");
                        break;
                }
                break;
            default:
                System.out.println("Nothing match");
                break;
        }

    }
    @Override
    public void currentLevelChanged() {
        System.out.println("ElevatorView : currentLevelChanged");
        if (elevator.getCurrentLevel() >= 0) {
            int nextLevel = (4 - elevator.getCurrentLevel()) * 135 + 3;
            elevatorView.getLabelElevator().setBounds(0, nextLevel, 100, 135);
            switch (elevator.getCurrentLevel()) {
                case 1:
                    //elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator0());
                    break;
                case 2:
                    //elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator1());
                    break;
                case 3:
                    //elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator2());
                    break;
                case 4:
                    //elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator3());
                    break;
                default:
                    System.out.println("Nothing match");
            }
        }
    }

    @Override
    public void elevatorStateChanged() {
        switch(elevator.getElevatorState()) {
            case INSERVICE:
                switch(elevator.getDoorState()) {
                    case OPEN:
                        elevatorView.getLabelElevator().setIcon(rsc.getIconElevatorOpen());
                        break;
                    case CLOSE:
                        elevatorView.getLabelElevator().setIcon(rsc.getIconElevatorClose());
                        break;
                    case OPENING:
                    case CLOSING:
                        elevatorView.getLabelElevator().setIcon(rsc.getIconElevatorInTransition());
                        break;
                    default:
                        System.out.println("ElevatorView : no match");
                        break;
                }
                System.out.println("Elevator.Elevator in service");
                break;
            case OUTOFSERVICE:
                elevatorView.getLabelElevator().setIcon(rsc.getIconElevatorOutOfService());
                System.out.println("Elevator.Elevator out of service");
                break;
            case EMERGENCY:
                System.out.println("Emergency on the elevator");
                break;
            case POWEROFF:
                elevatorView.getLabelElevator().setIcon(rsc.getIconElevatorClose());
                System.out.println("Elevator power off");
                break;
            default:
                System.out.println("No match detected in the elevator state");
                break;
        }
    }
    @Override
    public void directionChanged() {
        switch(elevator.getDirection()) {
            case UP:
                elevatorView.getLabelElevator().setIcon(rsc.getIconElevatorUp());
                System.out.println("Elevator moving up");
                break;
            case DOWN:
                elevatorView.getLabelElevator().setIcon(rsc.getIconElevatorDown());
                System.out.println("Elevator moving down");
                break;
            case IDLE:
                switch(elevator.getCurrentLevel()) {
                    case 1:
                        elevatorView.getLabelElevator().setIcon(rsc.getIconElevator0());
                        System.out.println("Elevator not moving; Actually level 0");
                        break;
                    case 2:
                        elevatorView.getLabelElevator().setIcon(rsc.getIconElevator1());
                        System.out.println("Elevator not moving; Actually level 1");
                        break;
                    case 3:
                        elevatorView.getLabelElevator().setIcon(rsc.getIconElevator2());
                        System.out.println("Elevator not moving; Actually level 2");
                        break;
                    case 4:
                        elevatorView.getLabelElevator().setIcon(rsc.getIconElevator3());
                        System.out.println("Elevator not moving; Actually level 3");
                        break;
                    default:
                        System.out.println("Elevator not moving; No match on floor detected");
                        break;
                }
                break;
            default:
                System.out.println("No match detected in the elevator direction");
                break;
        }
    }

    @Override
    public void req1Changed() {
        if(elevator.getReq1()) {
            elevatorView.getBtnLevel0().setIcon(rsc.getIconLevel0Green());
            System.out.println("Req1 is true");
        }else {
            elevatorView.getBtnLevel0().setIcon(rsc.getIconLevel0());
            System.out.println("Req1 is false");
        }
    }

    @Override
    public void up1Changed() {
        if(elevator.getUp1()) {
            elevatorView.getBtnUp().setIcon(rsc.getIconUpGreen());
            System.out.println("Up1 is true");
        }else {
            elevatorView.getBtnUp().setIcon(rsc.getIconUp());
            System.out.println("Up1 is false");
        }
    }

    @Override
    public void req2Changed() {
        if(elevator.getReq2()) {
            elevatorView.getBtnLevel1().setIcon(rsc.getIconLevel1Green());
            System.out.println("Req2 is true");
        }else {
            elevatorView.getBtnLevel1().setIcon(rsc.getIconLevel1());
            System.out.println("Req2 is false");
        }
    }

    @Override
    public void up2Changed() {
        if(elevator.getUp2()) {
            elevatorView.getBtnUp_1().setIcon(rsc.getIconUpGreen());
            System.out.println("Up2 is true");
        }else {
            elevatorView.getBtnUp_1().setIcon(rsc.getIconUp());
            System.out.println("Up2 is false");
        }
    }

    @Override
    public void down2Changed() {
        if(elevator.getDown2()) {
            elevatorView.getBtnDown_1().setIcon(rsc.getIconDownGreen());
            System.out.println("Down2 is true");
        }else {
            elevatorView.getBtnDown_1().setIcon(rsc.getIconDown());
            System.out.println("Down2 is false");
        }
    }

    @Override
    public void req3Changed() {
        if(elevator.getReq3()) {
            elevatorView.getBtnLevel2().setIcon(rsc.getIconLevel2Green());
            System.out.println("Req3 is true");
        }else {
            elevatorView.getBtnLevel2().setIcon(rsc.getIconLevel2());
            System.out.println("Req3 is false");
        }
    }

    @Override
    public void up3Changed() {
        if(elevator.getUp3()) {
            elevatorView.getBtnUp_2().setIcon(rsc.getIconUpGreen());
            System.out.println("Up3 is true");
        }else {
            elevatorView.getBtnUp_2().setIcon(rsc.getIconUp());
            System.out.println("Up3 is false");
        }
    }

    @Override
    public void down3Changed() {
        if(elevator.getDown3()) {
            elevatorView.getBtnDown_2().setIcon(rsc.getIconDownGreen());
            System.out.println("Down3 is true");
        }else {
            elevatorView.getBtnDown_2().setIcon(rsc.getIconDown());
            System.out.println("Down3 is false");
        }
    }

    @Override
    public void req4Changed() {
        if(elevator.getReq4()) {
            elevatorView.getBtnLevel3().setIcon(rsc.getIconLevel3Green());
            System.out.println("Req4 is true");
        }else {
            elevatorView.getBtnLevel3().setIcon(rsc.getIconLevel3());
            System.out.println("Req4 is false");
        }
    }

    @Override
    public void down4Changed() {
        if(elevator.getDown4()) {
            elevatorView.getBtnDown_3().setIcon(rsc.getIconDownGreen());
            System.out.println("Down4 is true");
        }else {
            elevatorView.getBtnDown_3().setIcon(rsc.getIconDown());
            System.out.println("Down4 is false");
        }
    }

    @Override
    public void openChanged() {
        if(elevator.getOpen()) {
            elevatorView.getBtnOpen().setIcon(rsc.getIconOpenGreen());
            System.out.println("Open is true");
        } else {
            elevatorView.getBtnOpen().setIcon(rsc.getIconOpen());
            System.out.println("Open is false");
        }
    }

    @Override
    public void closeChanged() {
        if(elevator.getClose()) {
            elevatorView.getBtnClose().setIcon(rsc.getIconCloseGreen());
            System.out.println("Close is true");
        } else {
            elevatorView.getBtnClose().setIcon(rsc.getIconClose());
            System.out.println("Close is false");
        }
    }

    @Override
    public void emergencyChanged() {
        if(elevator.getEmergency()) {
            elevatorView.getBtnLevel0().setIcon(rsc.getIconLevel0Red());
            elevatorView.getBtnLevel1().setIcon(rsc.getIconLevel1Red());
            elevatorView.getBtnLevel2().setIcon(rsc.getIconLevel2Red());
            elevatorView.getBtnLevel3().setIcon(rsc.getIconLevel3Red());
            elevatorView.getBtnStop().setIcon(rsc.getIconStopRed());
            //elevatorView.getBtnOpen().setIcon(rsc.getIconOpenRed());
            //elevatorView.getBtnClose().setIcon(rsc.getIconCloseRed());

        } else {
            elevatorView.getBtnLevel0().setIcon(rsc.getIconLevel0());
            elevatorView.getBtnLevel1().setIcon(rsc.getIconLevel1());
            elevatorView.getBtnLevel2().setIcon(rsc.getIconLevel2());
            elevatorView.getBtnLevel3().setIcon(rsc.getIconLevel3());
            elevatorView.getBtnStop().setIcon(rsc.getIconStop());
            //elevatorView.getBtnOpen().setIcon(rsc.getIconOpen());
            //elevatorView.getBtnClose().setIcon(rsc.getIconClose());
        }
    }

    @Override
    public void poresetChanged() {
        if(elevator.getPOreset()) {
            elevatorView.getBtnLevel0().setIcon(rsc.getIconLevel0());
            elevatorView.getBtnLevel1().setIcon(rsc.getIconLevel1());
            elevatorView.getBtnLevel2().setIcon(rsc.getIconLevel2());
            elevatorView.getBtnLevel3().setIcon(rsc.getIconLevel3());
            elevatorView.getBtnStop().setIcon(rsc.getIconStop());
            elevatorView.getBtnOpen().setIcon(rsc.getIconOpen());
            elevatorView.getBtnClose().setIcon(rsc.getIconClose());
            elevatorView.getBtnUp().setIcon(rsc.getIconUp());
            elevatorView.getBtnUp_1().setIcon(rsc.getIconUp());
            elevatorView.getBtnUp_2().setIcon(rsc.getIconUp());
            elevatorView.getBtnDown_1().setIcon(rsc.getIconDown());
            elevatorView.getBtnDown_2().setIcon(rsc.getIconDown());
            elevatorView.getBtnDown_3().setIcon(rsc.getIconDown());
            elevatorView.getBtnPOreset().setIcon(rsc.getIconLedGreen());
            elevatorView.getBtnPOdv2().setIcon(rsc.getIconLedOff());
            elevatorView.getBtnPOdv1().setIcon(rsc.getIconLedOff());
            elevatorView.getBtnPOdclose().setIcon(rsc.getIconLedOff());
            elevatorView.getBtnPOdopen().setIcon(rsc.getIconLedOff());
            elevatorView.getBtnPOuv2().setIcon(rsc.getIconLedOff());
            elevatorView.getBtnPOuv1().setIcon(rsc.getIconLedOff());
        } else {
            elevatorView.getBtnPOreset().setIcon(rsc.getIconLedOff());
        }
    }

    @Override
    public void podv2Changed() {
        if(elevator.getPOdv2()) {
            elevatorView.getBtnPOdv2().setIcon(rsc.getIconLedGreen());
        } else {
            elevatorView.getBtnPOdv2().setIcon(rsc.getIconLedOff());
        }
    }

    @Override
    public void podv1Changed() {
        if(elevator.getPOdv1()) {
            elevatorView.getBtnPOdv1().setIcon(rsc.getIconLedGreen());
        } else {
            elevatorView.getBtnPOdv1().setIcon(rsc.getIconLedOff());
        }
    }

    @Override
    public void pouv1Changed() {
        if(elevator.getPOuv1()) {
            elevatorView.getBtnPOuv1().setIcon(rsc.getIconLedGreen());
        } else {
            elevatorView.getBtnPOuv1().setIcon(rsc.getIconLedOff());
        }
    }

    @Override
    public void pouv2Changed() {
        if(elevator.getPOuv2()) {
            elevatorView.getBtnPOuv2().setIcon(rsc.getIconLedGreen());
        } else {
            elevatorView.getBtnPOuv2().setIcon(rsc.getIconLedOff());
        }
    }

    @Override
    public void podcloseChanged() {
        if(elevator.getPOdclose()) {
            elevatorView.getBtnPOdclose().setIcon(rsc.getIconLedGreen());
        } else {
            elevatorView.getBtnPOdclose().setIcon(rsc.getIconLedOff());
        }
    }

    @Override
    public void podopenChanged() {
        if(elevator.getPOdopen()) {
            elevatorView.getBtnPOdopen().setIcon(rsc.getIconLedGreen());
        } else {
            elevatorView.getBtnPOdopen().setIcon(rsc.getIconLedOff());
        }
    }

    @Override
    public void povcrawlselectChanged() {
        elevatorView.getLblPOv_crawlValue().setText("" + elevator.getPOv_crawlSelect());
        //elevatorView.getSliderPOv_crawlSelect().setValue(elevator.getPOv_crawlSelect());
    }

    @Override
    public void pis_l1slChanged() {

    }

    @Override
    public void pis_l1rChanged() {
        if(elevator.getPIs_l1r()) {
            System.out.println("ElevatorView : L1 Reached");
            int nextLevel = (3)*135 + 3;
            elevatorView.getLabelElevator().setBounds(0, nextLevel, 100, 135);
            elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator0());
        } else {
            directionChanged();
        }
    }

    @Override
    public void pis_l1suChanged() {

    }

    @Override
    public void pis_l1auChanged() {

    }

    @Override
    public void pis_l2slChanged() {

    }

    @Override
    public void pis_l2rChanged() {
        if(elevator.getPIs_l2r()) {
            System.out.println("ElevatorView : L2 Reached");
            int nextLevel = (2)*135 + 3;
            elevatorView.getLabelElevator().setBounds(0, nextLevel, 100, 135);
            elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator1());
        } else {
            directionChanged();
        }
    }

    @Override
    public void pis_l2suChanged() {

    }

    @Override
    public void pis_l2auChanged() {

    }

    @Override
    public void pis_l3slChanged() {

    }

    @Override
    public void pis_l3rChanged() {
        if(elevator.getPIs_l3r()) {
            System.out.println("ElevatorView : L3 Reached");
            int nextLevel = 2*135 + 3;
            elevatorView.getLabelElevator().setBounds(0, nextLevel, 100, 135);
            elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator2());
        } else {
            directionChanged();
        }
    }

    @Override
    public void pis_l3suChanged() {

    }

    @Override
    public void pis_l3auChanged() {

    }

    @Override
    public void pis_l4slChanged() {

    }

    @Override
    public void pis_l4rChanged() {
        if(elevator.getPIs_l4r()) {
            System.out.println("ElevatorView : L4 Reached");
            int nextLevel = 3;
            elevatorView.getLabelElevator().setBounds(0, nextLevel, 100, 135);
            elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator3());
        }
    }

    @Override
    public void pis_l1alChanged() {

    }

    @Override
    public void pis_l2alChanged() {

    }

    @Override
    public void pis_l3alChanged() {

    }

    @Override
    public void pis_l4alChanged() {

    }

    @Override
    public void pis_l4suChanged() {

    }

    @Override
    public void pis_l4auChanged() {

    }

    @Override
    public void pis_dopenedChanged() {
        if(elevator.getPIs_dopened()) {
            elevatorView.getLabelElevator().setIcon(rsc.getIconElevatorOpen());
            System.out.println("Open is true");
        } else {
            elevatorView.getLabelElevator().setIcon(rsc.getIconElevatorClose());
            System.out.println("Open is false");
        }
    }

    @Override
    public void pis_dclosedChanged() {
        if(elevator.getPIs_dclosed()) {
            elevatorView.getLabelElevator().setIcon(rsc.getIconElevatorClose());
            System.out.println("Open is true");
        } else {
            elevatorView.getLabelElevator().setIcon(rsc.getIconElevatorOpen());
            System.out.println("Open is false");
        }
    }

    @Override
    public void pim_readyChanged() {

    }

    @Override
    public void pim_onChanged() {
    }

    @Override
    public void pim_errorChanged() {

    }

    @Override
    public void pis_vChanged() {

    }
}
