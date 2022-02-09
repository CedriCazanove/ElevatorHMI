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
            directionChanged();
            /*switch (elevator.getCurrentLevel()) {
                case 1:
                    elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator0());
                    break;
                case 2:
                    elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator1());
                    break;
                case 3:
                    elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator2());
                    break;
                case 4:
                    elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator3());
                    break;
                default:
                    System.out.println("Nothing match");
            }*/
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
                System.out.println("Elevator moving up");
                switch(elevator.getCurrentLevel()) {
                    case 1:
                        System.out.println("Elevator moving up; Actually level 0");
                        elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator0Up());
                        break;
                    case 2:
                        System.out.println("Elevator moving up; Actually level 1");
                        elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator1Up());
                        break;
                    case 3:
                        System.out.println("Elevator moving up; Actually level 2");
                        elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator2Up());
                        break;
                    case 4:
                        System.out.println("Elevator moving up; Actually level 3");
                        elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator3Up());
                        break;
                    default:
                        System.out.println("Elevator moving up; No match on floor detected");
                        break;
                }
                break;
            case DOWN:
                System.out.println("Elevator moving down");
                switch(elevator.getCurrentLevel()) {
                    case 1:
                        System.out.println("Elevator moving down; Actually level 0");
                        elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator0Down());
                        break;
                    case 2:
                        System.out.println("Elevator moving down; Actually level 1");
                        elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator1Down());
                        break;
                    case 3:
                        System.out.println("Elevator moving down; Actually level 2");
                        elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator2Down());
                        break;
                    case 4:
                        System.out.println("Elevator moving down; Actually level 3");
                        elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator3Down());
                        break;
                    default:
                        System.out.println("Elevator moving down; No match on floor detected");
                        break;
                }
                break;
            case IDLE:
                switch(elevator.getCurrentLevel()) {
                    case 1:
                        System.out.println("Elevator not moving; Actually level 0");
                        elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator0());
                        break;
                    case 2:
                        System.out.println("Elevator not moving; Actually level 1");
                        elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator1());
                        break;
                    case 3:
                        System.out.println("Elevator not moving; Actually level 2");
                        elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator2());
                        break;
                    case 4:
                        System.out.println("Elevator not moving; Actually level 3");
                        elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator3());
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
            System.out.println("Req1 is true");
            elevatorView.getBtnLevel0().setIcon(rsc.getIconLevel0Green());
        }else {
            System.out.println("Req1 is false");
            elevatorView.getBtnLevel0().setIcon(rsc.getIconLevel0());
        }
    }

    @Override
    public void up1Changed() {
        if(elevator.getUp1()) {
            System.out.println("Up1 is true");
            elevatorView.getBtnUp().setIcon(rsc.getIconUpGreen());
        }else {
            System.out.println("Up1 is false");
            elevatorView.getBtnUp().setIcon(rsc.getIconUp());
        }

    }

    @Override
    public void req2Changed() {
        if(elevator.getReq2()) {
            System.out.println("Req2 is true");
            elevatorView.getBtnLevel1().setIcon(rsc.getIconLevel1Green());
        }else {
            System.out.println("Req2 is false");
            elevatorView.getBtnLevel1().setIcon(rsc.getIconLevel1());
        }
    }

    @Override
    public void up2Changed() {
        if(elevator.getUp2()) {
            System.out.println("Up2 is true");
            elevatorView.getBtnUp_1().setIcon(rsc.getIconUpGreen());
        }else {
            System.out.println("Up2 is false");
            elevatorView.getBtnUp_1().setIcon(rsc.getIconUp());
        }
    }

    @Override
    public void down2Changed() {
        if(elevator.getDown2()) {
            System.out.println("Down2 is true");
            elevatorView.getBtnDown_1().setIcon(rsc.getIconDownGreen());
        }else {
            System.out.println("Down2 is false");
            elevatorView.getBtnDown_1().setIcon(rsc.getIconDown());
        }
    }

    @Override
    public void req3Changed() {
        if(elevator.getReq3()) {
            System.out.println("Req3 is true");
            elevatorView.getBtnLevel2().setIcon(rsc.getIconLevel2Green());
        }else {
            System.out.println("Req3 is false");
            elevatorView.getBtnLevel2().setIcon(rsc.getIconLevel2());
        }
    }

    @Override
    public void up3Changed() {
        if(elevator.getUp3()) {
            System.out.println("Up3 is true");
            elevatorView.getBtnUp_2().setIcon(rsc.getIconUpGreen());
        }else {
            System.out.println("Up3 is false");
            elevatorView.getBtnUp_2().setIcon(rsc.getIconUp());
        }
    }

    @Override
    public void down3Changed() {
        if(elevator.getDown3()) {
            System.out.println("Down3 is true");
            elevatorView.getBtnDown_2().setIcon(rsc.getIconDownGreen());
        }else {
            System.out.println("Down3 is false");
            elevatorView.getBtnDown_2().setIcon(rsc.getIconDown());
        }
    }

    @Override
    public void req4Changed() {
        if(elevator.getReq4()) {
            System.out.println("Req4 is true");
            elevatorView.getBtnLevel3().setIcon(rsc.getIconLevel3Green());
        }else {
            System.out.println("Req4 is false");
            elevatorView.getBtnLevel3().setIcon(rsc.getIconLevel3());
        }
    }

    @Override
    public void down4Changed() {
        if(elevator.getDown4()) {
            System.out.println("Down4 is true");
            elevatorView.getBtnDown_3().setIcon(rsc.getIconDownGreen());
        }else {
            System.out.println("Down4 is false");
            elevatorView.getBtnDown_3().setIcon(rsc.getIconDown());
        }
    }

    @Override
    public void openChanged() {
        if(elevator.getOpen()) {
            System.out.println("Open is true");
            elevatorView.getBtnOpen().setIcon(rsc.getIconOpenGreen());
        } else {
            System.out.println("Open is false");
            elevatorView.getBtnOpen().setIcon(rsc.getIconOpen());
        }
    }

    @Override
    public void closeChanged() {
        if(elevator.getClose()) {
            System.out.println("Close is true");
            elevatorView.getBtnClose().setIcon(rsc.getIconCloseGreen());
        } else {
            System.out.println("Close is false");
            elevatorView.getBtnClose().setIcon(rsc.getIconClose());
        }
    }

    @Override
    public void emergencyChanged() {
        if(elevator.getEmergency()) {
            System.out.println("Emergency true");
            elevatorView.getBtnLevel0().setIcon(rsc.getIconLevel0Red());
            elevatorView.getBtnLevel1().setIcon(rsc.getIconLevel1Red());
            elevatorView.getBtnLevel2().setIcon(rsc.getIconLevel2Red());
            elevatorView.getBtnLevel3().setIcon(rsc.getIconLevel3Red());
            elevatorView.getBtnStop().setIcon(rsc.getIconStopRed());
            elevatorView.getBtnOpen().setIcon(rsc.getIconOpenRed());
            elevatorView.getBtnClose().setIcon(rsc.getIconCloseRed());
        } else {
            System.out.println("Emergency false");
            elevatorView.getBtnLevel0().setIcon(rsc.getIconLevel0());
            elevatorView.getBtnLevel1().setIcon(rsc.getIconLevel1());
            elevatorView.getBtnLevel2().setIcon(rsc.getIconLevel2());
            elevatorView.getBtnLevel3().setIcon(rsc.getIconLevel3());
            elevatorView.getBtnStop().setIcon(rsc.getIconStop());
            elevatorView.getBtnOpen().setIcon(rsc.getIconOpen());
            elevatorView.getBtnClose().setIcon(rsc.getIconClose());
        }
    }

    @Override
    public void poresetChanged() {
        if(elevator.getPOreset()) {
            System.out.println("POreset true");
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
            System.out.println("POreset false");
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
        switch(elevator.getDirection()) {
            case UP:
                if(elevator.getPIs_l1r()) {
                    System.out.println("ElevatorView : L1 Reached");
                    int nextLevel = (3)*135 + 3;
                    elevatorView.getLabelElevator().setBounds(0, nextLevel, 100, 135);
                    elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator0Up());
                } else {
                    directionChanged();
                }
                break;
            case DOWN:
                if(elevator.getPIs_l1r()) {
                    System.out.println("ElevatorView : L1 Reached");
                    int nextLevel = (3)*135 + 3;
                    elevatorView.getLabelElevator().setBounds(0, nextLevel, 100, 135);
                    elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator0Down());
                } else {
                    directionChanged();
                }
                break;
            case IDLE:
                if(elevator.getPIs_l1r()) {
                    System.out.println("ElevatorView : L1 Reached");
                    int nextLevel = (3)*135 + 3;
                    elevatorView.getLabelElevator().setBounds(0, nextLevel, 100, 135);
                    elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator0());
                } else {
                    directionChanged();
                }
                break;
            default:
                System.out.println("No match detected in the elevator direction");
                break;
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
        switch(elevator.getDirection()) {
            case UP:
                if(elevator.getPIs_l2r()) {
                    System.out.println("ElevatorView : L2 Reached");
                    int nextLevel = (2)*135 + 3;
                    elevatorView.getLabelElevator().setBounds(0, nextLevel, 100, 135);
                    elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator1Up());
                } else {
                    directionChanged();
                }
                break;
            case DOWN:
                if(elevator.getPIs_l2r()) {
                    System.out.println("ElevatorView : L2 Reached");
                    int nextLevel = (2)*135 + 3;
                    elevatorView.getLabelElevator().setBounds(0, nextLevel, 100, 135);
                    elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator1Down());
                } else {
                    directionChanged();
                }
                break;
            case IDLE:
                if(elevator.getPIs_l2r()) {
                    System.out.println("ElevatorView : L2 Reached");
                    int nextLevel = (2)*135 + 3;
                    elevatorView.getLabelElevator().setBounds(0, nextLevel, 100, 135);
                    elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator1());
                } else {
                    directionChanged();
                }
                break;
            default:
                System.out.println("No match detected in the elevator direction");
                break;
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
        switch(elevator.getDirection()) {
            case UP:
                if(elevator.getPIs_l3r()) {
                    System.out.println("ElevatorView : L3 Reached");
                    int nextLevel = (1)*135 + 3;
                    elevatorView.getLabelElevator().setBounds(0, nextLevel, 100, 135);
                    elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator2Up());
                } else {
                    directionChanged();
                }
                break;
            case DOWN:
                if(elevator.getPIs_l3r()) {
                    System.out.println("ElevatorView : L3 Reached");
                    int nextLevel = (1)*135 + 3;
                    elevatorView.getLabelElevator().setBounds(0, nextLevel, 100, 135);
                    elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator2Down());
                } else {
                    directionChanged();
                }
                break;
            case IDLE:
                if(elevator.getPIs_l3r()) {
                    System.out.println("ElevatorView : L3 Reached");
                    int nextLevel = (1)*135 + 3;
                    elevatorView.getLabelElevator().setBounds(0, nextLevel, 100, 135);
                    elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator2());
                } else {
                    directionChanged();
                }
                break;
            default:
                System.out.println("No match detected in the elevator direction");
                break;
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
        switch(elevator.getDirection()) {
            case UP:
                if(elevator.getPIs_l4r()) {
                    System.out.println("ElevatorView : L4 Reached");
                    int nextLevel = 3;
                    elevatorView.getLabelElevator().setBounds(0, nextLevel, 100, 135);
                    elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator3Up());
                } else {
                    directionChanged();
                }
                break;
            case DOWN:
                if(elevator.getPIs_l4r()) {
                    System.out.println("ElevatorView : L4 Reached");
                    int nextLevel = 3;
                    elevatorView.getLabelElevator().setBounds(0, nextLevel, 100, 135);
                    elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator3Down());
                } else {
                    directionChanged();
                }
                break;
            case IDLE:
                if(elevator.getPIs_l4r()) {
                    System.out.println("ElevatorView : L1 Reached");
                    int nextLevel = 3;
                    elevatorView.getLabelElevator().setBounds(0, nextLevel, 100, 135);
                    elevatorView.getLblElevatorIndicator().setIcon(rsc.getIconElevator3());
                } else {
                    directionChanged();
                }
                break;
            default:
                System.out.println("No match detected in the elevator direction");
                break;
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
            System.out.println("Open is true");
            elevatorView.getLabelElevator().setIcon(rsc.getIconElevatorOpen());
        } else {
            System.out.println("Open is false");
            elevatorView.getLabelElevator().setIcon(rsc.getIconElevatorClose());
        }
    }

    @Override
    public void pis_dclosedChanged() {
        if(elevator.getPIs_dclosed()) {
            System.out.println("Open is true");
            elevatorView.getLabelElevator().setIcon(rsc.getIconElevatorClose());
        } else {
            System.out.println("Open is false");
            elevatorView.getLabelElevator().setIcon(rsc.getIconElevatorOpen());
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
        //elevatorView.getSliderPOv_crawlSelect().setValue(elevator.getPIs_v());
        elevatorView.getLblPOv_crawlValue().setText("" + elevator.getPIs_v());
    }
}
