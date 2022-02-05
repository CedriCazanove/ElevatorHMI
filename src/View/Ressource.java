package View;

import javax.swing.*;
import java.net.URL;

public class Ressource {
    //Picture for the displaying the level on the left
    private static URL urlFloorIndicator = Ressource.class.getResource("/floorIndicator.png");
    private static Icon iconFloorIndicator = new ImageIcon(urlFloorIndicator);

    //Picture of the elevator
    private static URL urlElevatorOpen = Ressource.class.getResource("/elevatorOpen.png");
    private static URL urlElevatorClose = Ressource.class.getResource("/elevatorClose.png");
    private static URL urlElevatorInTransition = Ressource.class.getResource("/elevatorInTransition.png");
    private static URL urlElevatorOutOfService = Ressource.class.getResource("/elevatorOutOfService.png");
    private static Icon iconElevatorOpen = new ImageIcon(urlElevatorOpen);
    private static Icon iconElevatorClose = new ImageIcon(urlElevatorClose);
    private static Icon iconElevatorInTransition = new ImageIcon(urlElevatorInTransition);
    private static Icon iconElevatorOutOfService = new ImageIcon(urlElevatorOutOfService);

    //Picture for the Up button
    private static URL urlUp = Ressource.class.getResource("/up.png");
    private static URL urlUpGreen = Ressource.class.getResource("/upGreen.png");
    Icon iconUp = new ImageIcon(urlUp);
    Icon iconUpGreen = new ImageIcon(urlUpGreen);

    //Picture for the down button
    private static URL urlDown = Ressource.class.getResource("/down.png");
    private static URL urlDownGreen = Ressource.class.getResource("/downGreen.png");
    Icon iconDown = new ImageIcon(urlDown);
    Icon iconDownGreen = new ImageIcon(urlDownGreen);

    //Picture for the stop button
    private static URL urlStop = Ressource.class.getResource("/stop.png");
    private static URL urlStopPressed = Ressource.class.getResource("/stopPressed.png");
    Icon iconStop = new ImageIcon(urlStop);
    Icon iconStopRed = new ImageIcon(urlStopPressed);

    //Picture for the open button
    private static URL urlOpen = Ressource.class.getResource("/open.png");
    private static URL urlOpenGreen = Ressource.class.getResource("/openGreen.png");
    private static URL urlOpenRed = Ressource.class.getResource("/openRed.png");
    Icon iconOpen = new ImageIcon(urlOpen);
    Icon iconOpenGreen = new ImageIcon(urlOpenGreen);
    Icon iconOpenRed = new ImageIcon(urlOpenRed);

    //Picture for the close button
    private static URL urlClose = Ressource.class.getResource("/close.png");
    private static URL urlCloseGreen = Ressource.class.getResource("/closeGreen.png");
    private static URL urlCloseRed = Ressource.class.getResource("/closeRed.png");
    Icon iconClose = new ImageIcon(urlClose);
    Icon iconCloseGreen = new ImageIcon(urlCloseGreen);
    Icon iconCloseRed = new ImageIcon(urlCloseRed);

    //Picture for the level 0 button
    private static URL urlLevel0 = Ressource.class.getResource("/level0.png");
    private static URL urlLevel0Green = Ressource.class.getResource("/level0Green.png");
    private static URL urlLevel0Red = Ressource.class.getResource("/level0Red.png");
    Icon iconLevel0 = new ImageIcon(urlLevel0);
    Icon iconLevel0Green = new ImageIcon(urlLevel0Green);
    Icon iconLevel0Red = new ImageIcon(urlLevel0Red);

    //Picture for the level 1 button
    private static URL urlLevel1 = Ressource.class.getResource("/level1.png");
    private static URL urlLevel1Green = Ressource.class.getResource("/level1Green.png");
    private static URL urlLevel1Red = Ressource.class.getResource("/level1Red.png");
    Icon iconLevel1 = new ImageIcon(urlLevel1);
    Icon iconLevel1Green = new ImageIcon(urlLevel1Green);
    Icon iconLevel1Red = new ImageIcon(urlLevel1Red);

    //Picture for the level 2 button
    private static URL urlLevel2 = Ressource.class.getResource("/level2.png");
    private static URL urlLevel2Green = Ressource.class.getResource("/level2Green.png");
    private static URL urlLevel2Red = Ressource.class.getResource("/level2Red.png");
    Icon iconLevel2 = new ImageIcon(urlLevel2);
    Icon iconLevel2Red = new ImageIcon(urlLevel2Red);
    Icon iconLevel2Green = new ImageIcon(urlLevel2Green);

    //Picture for the level 3 button
    private static URL urlLevel3 = Ressource.class.getResource("/level3.png");
    private static URL urlLevel3Green = Ressource.class.getResource("/level3Green.png");
    private static URL urlLevel3Red = Ressource.class.getResource("/level3Red.png");
    Icon iconLevel3 = new ImageIcon(urlLevel3);
    Icon iconLevel3Green = new ImageIcon(urlLevel3Green);
    Icon iconLevel3Red = new ImageIcon(urlLevel3Red);

    //Picture for the digit 0
    private static URL urlDigit0 = Ressource.class.getResource("/digit0.png");
    private static URL urlDigit0Green = Ressource.class.getResource("/digit0Green.png");
    Icon iconDigit0 = new ImageIcon(urlDigit0);
    Icon iconDigit0Green = new ImageIcon(urlDigit0Green);

    //Picture for the digit 1
    private static URL urlDigit1 = Ressource.class.getResource("/digit1.png");
    private static URL urlDigit1Green = Ressource.class.getResource("/digit1Green.png");
    Icon iconDigit1 = new ImageIcon(urlDigit1);
    Icon iconDigit1Green = new ImageIcon(urlDigit1Green);

    //Picture for the digit 2
    private static URL urlDigit2 = Ressource.class.getResource("/digit2.png");
    private static URL urlDigit2Green = Ressource.class.getResource("/digit2Green.png");
    Icon iconDigit2 = new ImageIcon(urlDigit2);
    Icon iconDigit2Green = new ImageIcon(urlDigit2Green);

    //Picture for the digit 3
    private static URL urlDigit3 = Ressource.class.getResource("/digit3.png");
    private static URL urlDigit3Green = Ressource.class.getResource("/digit3Green.png");
    Icon iconDigit3 = new ImageIcon(urlDigit3);
    Icon iconDigit3Green = new ImageIcon(urlDigit3Green);

    //Picture for the digit 4
    private static URL urlDigit4 = Ressource.class.getResource("/digit4.png");
    private static URL urlDigit4Green = Ressource.class.getResource("/digit4Green.png");
    Icon iconDigit4 = new ImageIcon(urlDigit4);
    Icon iconDigit4Green = new ImageIcon(urlDigit4Green);

    //Picture for the digit 5
    private static URL urlDigit5 = Ressource.class.getResource("/digit5.png");
    private static URL urlDigit5Green = Ressource.class.getResource("/digit5Green.png");
    Icon iconDigit5 = new ImageIcon(urlDigit5);
    Icon iconDigit5Green = new ImageIcon(urlDigit5Green);

    //Picture for the digit 6
    private static URL urlDigit6 = Ressource.class.getResource("/digit6.png");
    private static URL urlDigit6Green = Ressource.class.getResource("/digit6Green.png");
    Icon iconDigit6 = new ImageIcon(urlDigit6);
    Icon iconDigit6Green = new ImageIcon(urlDigit6Green);

    //Picture for the digit 7
    private static URL urlDigit7 = Ressource.class.getResource("/digit7.png");
    private static URL urlDigit7Green = Ressource.class.getResource("/digit7Green.png");
    Icon iconDigit7 = new ImageIcon(urlDigit7);
    Icon iconDigit7Green = new ImageIcon(urlDigit7Green);

    //Picture for the digit 8
    private static URL urlDigit8 = Ressource.class.getResource("/digit8.png");
    private static URL urlDigit8Green = Ressource.class.getResource("/digit8Green.png");
    Icon iconDigit8 = new ImageIcon(urlDigit8);
    Icon iconDigit8Green = new ImageIcon(urlDigit8Green);

    //Picture for the digit 9
    private static URL urlDigit9 = Ressource.class.getResource("/digit9.png");
    private static URL urlDigit9Green = Ressource.class.getResource("/digit9Green.png");
    Icon iconDigit9 = new ImageIcon(urlDigit9);
    Icon iconDigit9Green = new ImageIcon(urlDigit9Green);

    //Picture for the cancel button
    private static URL urlCross = Ressource.class.getResource("/cross.png");
    private static URL urlCrossPressed = Ressource.class.getResource("/crossPressed.png");
    Icon iconCross = new ImageIcon(urlCross);
    Icon iconCrossPressed = new ImageIcon(urlCrossPressed);

    //Picture for the validate button
    private static URL urlCheck = Ressource.class.getResource("/check.png");
    private static URL urlCheckPressed = Ressource.class.getResource("/checkPressed.png");
    Icon iconCheck = new ImageIcon(urlCheck);
    Icon iconCheckPressed = new ImageIcon(urlCheckPressed);

    //Picture for the User/Supervisor mode
    private static URL urlUser = Ressource.class.getResource("/user.png");
    private static URL urlSupervisor = Ressource.class.getResource("/supervisor.png");
    Icon iconUser = new ImageIcon(urlUser);
    Icon iconSupervisor = new ImageIcon(urlSupervisor);

    //Picture for the led for the supervisor button
    private static URL urlLedOff = Ressource.class.getResource("/ledOff.png");
    private static URL urlLedGreen = Ressource.class.getResource("/ledGreen.png");
    private static URL urlLedRed = Ressource.class.getResource("/ledRed.png");
    Icon iconLedOff = new ImageIcon(urlLedOff);
    Icon iconLedGreen = new ImageIcon(urlLedGreen);
    Icon iconLedRed = new ImageIcon(urlLedRed);

    //Picture for the floor/direction indicator of the elevator
    private static URL urlElevatorOff = Ressource.class.getResource("/elevatorIndicatorOff.png");
    private static URL urlElevator0 = Ressource.class.getResource("/elevatorIndicator0.png");
    private static URL urlElevator0Up = Ressource.class.getResource("/elevatorIndicator0Up.png");
    private static URL urlElevator0Down = Ressource.class.getResource("/elevatorIndicator0Down.png");
    private static URL urlElevator1 = Ressource.class.getResource("/elevatorIndicator1.png");
    private static URL urlElevator1Up = Ressource.class.getResource("/elevatorIndicator1Up.png");
    private static URL urlElevator1Down = Ressource.class.getResource("/elevatorIndicator1Down.png");
    private static URL urlElevator2 = Ressource.class.getResource("/elevatorIndicator2.png");
    private static URL urlElevator2Up = Ressource.class.getResource("/elevatorIndicator2Up.png");
    private static URL urlElevator2Down = Ressource.class.getResource("/elevatorIndicator2Down.png");
    private static URL urlElevator3 = Ressource.class.getResource("/elevatorIndicator3.png");
    private static URL urlElevator3Up = Ressource.class.getResource("/elevatorIndicator3Up.png");
    private static URL urlElevator3Down = Ressource.class.getResource("/elevatorIndicator3Down.png");
    private static URL urlElevatorUp = Ressource.class.getResource("/elevatorIndicatorUp.png");
    private static URL urlElevatorDown = Ressource.class.getResource("/elevatorIndicatorDown.png");
    private static URL urlElevatorSmile = Ressource.class.getResource("/elevatorIndicatorSmile.png");
    Icon iconElevatorOff = new ImageIcon(urlElevatorOff);
    Icon iconElevator0 = new ImageIcon(urlElevator0);
    Icon iconElevator0Up = new ImageIcon(urlElevator0Up);
    Icon iconElevator0Down = new ImageIcon(urlElevator0Down);
    Icon iconElevator1 = new ImageIcon(urlElevator1);
    Icon iconElevator1Up = new ImageIcon(urlElevator1Up);
    Icon iconElevator1Down = new ImageIcon(urlElevator1Down);
    Icon iconElevator2 = new ImageIcon(urlElevator2);
    Icon iconElevator2Up = new ImageIcon(urlElevator2Up);
    Icon iconElevator2Down = new ImageIcon(urlElevator2Down);
    Icon iconElevator3 = new ImageIcon(urlElevator3);
    Icon iconElevator3Up = new ImageIcon(urlElevator3Up);
    Icon iconElevator3Down = new ImageIcon(urlElevator3Down);
    Icon iconElevatorUp = new ImageIcon(urlElevatorUp);
    Icon iconElevatorDown = new ImageIcon(urlElevatorDown);
    Icon iconElevatorSmile = new ImageIcon(urlElevatorSmile);

    public static Icon getIconFloorIndicator() {
        return iconFloorIndicator;
    }

    public static Icon getIconElevatorOpen() {
        return iconElevatorOpen;
    }

    public static Icon getIconElevatorClose() {
        return iconElevatorClose;
    }

    public static Icon getIconElevatorInTransition() {
        return iconElevatorInTransition;
    }

    public static Icon getIconElevatorOutOfService() {
        return iconElevatorOutOfService;
    }

    public Icon getIconUp() {
        return iconUp;
    }

    public Icon getIconUpGreen() {
        return iconUpGreen;
    }

    public Icon getIconDown() {
        return iconDown;
    }

    public Icon getIconDownGreen() {
        return iconDownGreen;
    }

    public Icon getIconStop() {
        return iconStop;
    }

    public Icon getIconStopRed() {
        return iconStopRed;
    }

    public Icon getIconOpen() {
        return iconOpen;
    }

    public Icon getIconOpenGreen() {
        return iconOpenGreen;
    }

    public Icon getIconOpenRed() {
        return iconOpenRed;
    }

    public Icon getIconClose() {
        return iconClose;
    }

    public Icon getIconCloseGreen() {
        return iconCloseGreen;
    }

    public Icon getIconCloseRed() {
        return iconCloseRed;
    }

    public Icon getIconLevel0() {
        return iconLevel0;
    }

    public Icon getIconLevel0Green() {
        return iconLevel0Green;
    }

    public Icon getIconLevel0Red() {
        return iconLevel0Red;
    }

    public Icon getIconLevel1() {
        return iconLevel1;
    }

    public Icon getIconLevel1Green() {
        return iconLevel1Green;
    }

    public Icon getIconLevel1Red() {
        return iconLevel1Red;
    }

    public Icon getIconLevel2() {
        return iconLevel2;
    }

    public Icon getIconLevel2Red() {
        return iconLevel2Red;
    }

    public Icon getIconLevel2Green() {
        return iconLevel2Green;
    }

    public Icon getIconLevel3() {
        return iconLevel3;
    }

    public Icon getIconLevel3Green() {
        return iconLevel3Green;
    }

    public Icon getIconLevel3Red() {
        return iconLevel3Red;
    }

    public Icon getIconDigit0() {
        return iconDigit0;
    }

    public Icon getIconDigit0Green() {
        return iconDigit0Green;
    }

    public Icon getIconDigit1() {
        return iconDigit1;
    }

    public Icon getIconDigit1Green() {
        return iconDigit1Green;
    }

    public Icon getIconDigit2() {
        return iconDigit2;
    }

    public Icon getIconDigit2Green() {
        return iconDigit2Green;
    }

    public Icon getIconDigit3() {
        return iconDigit3;
    }

    public Icon getIconDigit3Green() {
        return iconDigit3Green;
    }

    public Icon getIconDigit4() {
        return iconDigit4;
    }

    public Icon getIconDigit4Green() {
        return iconDigit4Green;
    }

    public Icon getIconDigit5() {
        return iconDigit5;
    }

    public Icon getIconDigit5Green() {
        return iconDigit5Green;
    }

    public Icon getIconDigit6() {
        return iconDigit6;
    }

    public Icon getIconDigit6Green() {
        return iconDigit6Green;
    }

    public Icon getIconDigit7() {
        return iconDigit7;
    }

    public Icon getIconDigit7Green() {
        return iconDigit7Green;
    }

    public Icon getIconDigit8() {
        return iconDigit8;
    }

    public Icon getIconDigit8Green() {
        return iconDigit8Green;
    }

    public Icon getIconDigit9() {
        return iconDigit9;
    }

    public Icon getIconDigit9Green() {
        return iconDigit9Green;
    }

    public Icon getIconCross() {
        return iconCross;
    }

    public Icon getIconCrossPressed() {
        return iconCrossPressed;
    }

    public Icon getIconCheck() {
        return iconCheck;
    }

    public Icon getIconCheckPressed() {
        return iconCheckPressed;
    }

    public Icon getIconUser() {
        return iconUser;
    }

    public Icon getIconSupervisor() {
        return iconSupervisor;
    }

    public Icon getIconLedOff() {
        return iconLedOff;
    }

    public Icon getIconLedGreen() {
        return iconLedGreen;
    }

    public Icon getIconLedRed() {
        return iconLedRed;
    }

    public Icon getIconElevatorOff() {
        return iconElevatorOff;
    }

    public Icon getIconElevator0() {
        return iconElevator0;
    }

    public Icon getIconElevator1() {
        return iconElevator1;
    }

    public Icon getIconElevator2() {
        return iconElevator2;
    }

    public Icon getIconElevator3() {
        return iconElevator3;
    }

    public Icon getIconElevatorUp() {
        return iconElevatorUp;
    }

    public Icon getIconElevatorDown() {
        return iconElevatorDown;
    }

    public Icon getIconElevatorSmile() {
        return iconElevatorSmile;
    }
}