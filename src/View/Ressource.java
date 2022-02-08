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
    private static URL urlElevatorInTransition = Ressource.class.getResource("/elevatorInTransitionEasterEgg.png");
    private static URL urlElevatorOutOfService = Ressource.class.getResource("/elevatorOutOfService.png");
    private static Icon iconElevatorOpen = new ImageIcon(urlElevatorOpen);
    private static Icon iconElevatorClose = new ImageIcon(urlElevatorClose);
    private static Icon iconElevatorInTransition = new ImageIcon(urlElevatorInTransition);
    private static Icon iconElevatorOutOfService = new ImageIcon(urlElevatorOutOfService);

    //Picture for the Up button
    private static URL urlUp = Ressource.class.getResource("/up.png");
    private static URL urlUpGreen = Ressource.class.getResource("/upGreen.png");
    private static Icon iconUp = new ImageIcon(urlUp);
    private static Icon iconUpGreen = new ImageIcon(urlUpGreen);

    //Picture for the down button
    private static URL urlDown = Ressource.class.getResource("/down.png");
    private static URL urlDownGreen = Ressource.class.getResource("/downGreen.png");
    private static Icon iconDown = new ImageIcon(urlDown);
    private static Icon iconDownGreen = new ImageIcon(urlDownGreen);

    //Picture for the stop button
    private static URL urlStop = Ressource.class.getResource("/stop.png");
    private static URL urlStopPressed = Ressource.class.getResource("/stopPressed.png");
    private static Icon iconStop = new ImageIcon(urlStop);
    private static Icon iconStopRed = new ImageIcon(urlStopPressed);

    //Picture for the open button
    private static URL urlOpen = Ressource.class.getResource("/open.png");
    private static URL urlOpenGreen = Ressource.class.getResource("/openGreen.png");
    private static URL urlOpenRed = Ressource.class.getResource("/openRed.png");
    private static Icon iconOpen = new ImageIcon(urlOpen);
    private static Icon iconOpenGreen = new ImageIcon(urlOpenGreen);
    private static Icon iconOpenRed = new ImageIcon(urlOpenRed);

    //Picture for the close button
    private static URL urlClose = Ressource.class.getResource("/close.png");
    private static URL urlCloseGreen = Ressource.class.getResource("/closeGreen.png");
    private static URL urlCloseRed = Ressource.class.getResource("/closeRed.png");
    private static Icon iconClose = new ImageIcon(urlClose);
    private static Icon iconCloseGreen = new ImageIcon(urlCloseGreen);
    private static Icon iconCloseRed = new ImageIcon(urlCloseRed);

    //Picture for the level 0 button
    private static URL urlLevel0 = Ressource.class.getResource("/level0.png");
    private static URL urlLevel0Green = Ressource.class.getResource("/level0Green.png");
    private static URL urlLevel0Red = Ressource.class.getResource("/level0Red.png");
    private static Icon iconLevel0 = new ImageIcon(urlLevel0);
    private static Icon iconLevel0Green = new ImageIcon(urlLevel0Green);
    private static Icon iconLevel0Red = new ImageIcon(urlLevel0Red);

    //Picture for the level 1 button
    private static URL urlLevel1 = Ressource.class.getResource("/level1.png");
    private static URL urlLevel1Green = Ressource.class.getResource("/level1Green.png");
    private static URL urlLevel1Red = Ressource.class.getResource("/level1Red.png");
    private static Icon iconLevel1 = new ImageIcon(urlLevel1);
    private static Icon iconLevel1Green = new ImageIcon(urlLevel1Green);
    private static Icon iconLevel1Red = new ImageIcon(urlLevel1Red);

    //Picture for the level 2 button
    private static URL urlLevel2 = Ressource.class.getResource("/level2.png");
    private static URL urlLevel2Green = Ressource.class.getResource("/level2Green.png");
    private static URL urlLevel2Red = Ressource.class.getResource("/level2Red.png");
    private static Icon iconLevel2 = new ImageIcon(urlLevel2);
    private static Icon iconLevel2Red = new ImageIcon(urlLevel2Red);
    private static Icon iconLevel2Green = new ImageIcon(urlLevel2Green);

    //Picture for the level 3 button
    private static URL urlLevel3 = Ressource.class.getResource("/level3.png");
    private static URL urlLevel3Green = Ressource.class.getResource("/level3Green.png");
    private static URL urlLevel3Red = Ressource.class.getResource("/level3Red.png");
    private static Icon iconLevel3 = new ImageIcon(urlLevel3);
    private static Icon iconLevel3Green = new ImageIcon(urlLevel3Green);
    private static Icon iconLevel3Red = new ImageIcon(urlLevel3Red);

    //Picture for the digit 0
    private static URL urlDigit0 = Ressource.class.getResource("/digit0.png");
    private static URL urlDigit0Green = Ressource.class.getResource("/digit0Green.png");
    private static Icon iconDigit0 = new ImageIcon(urlDigit0);
    private static Icon iconDigit0Green = new ImageIcon(urlDigit0Green);

    //Picture for the digit 1
    private static URL urlDigit1 = Ressource.class.getResource("/digit1.png");
    private static URL urlDigit1Green = Ressource.class.getResource("/digit1Green.png");
    private static Icon iconDigit1 = new ImageIcon(urlDigit1);
    private static Icon iconDigit1Green = new ImageIcon(urlDigit1Green);

    //Picture for the digit 2
    private static URL urlDigit2 = Ressource.class.getResource("/digit2.png");
    private static URL urlDigit2Green = Ressource.class.getResource("/digit2Green.png");
    private static  Icon iconDigit2 = new ImageIcon(urlDigit2);
    private static Icon iconDigit2Green = new ImageIcon(urlDigit2Green);

    //Picture for the digit 3
    private static URL urlDigit3 = Ressource.class.getResource("/digit3.png");
    private static URL urlDigit3Green = Ressource.class.getResource("/digit3Green.png");
    private static Icon iconDigit3 = new ImageIcon(urlDigit3);
    private static Icon iconDigit3Green = new ImageIcon(urlDigit3Green);

    //Picture for the digit 4
    private static URL urlDigit4 = Ressource.class.getResource("/digit4.png");
    private static URL urlDigit4Green = Ressource.class.getResource("/digit4Green.png");
    private static Icon iconDigit4 = new ImageIcon(urlDigit4);
    private static Icon iconDigit4Green = new ImageIcon(urlDigit4Green);

    //Picture for the digit 5
    private static URL urlDigit5 = Ressource.class.getResource("/digit5.png");
    private static URL urlDigit5Green = Ressource.class.getResource("/digit5Green.png");
    private static Icon iconDigit5 = new ImageIcon(urlDigit5);
    private static Icon iconDigit5Green = new ImageIcon(urlDigit5Green);

    //Picture for the digit 6
    private static URL urlDigit6 = Ressource.class.getResource("/digit6.png");
    private static URL urlDigit6Green = Ressource.class.getResource("/digit6Green.png");
    private static Icon iconDigit6 = new ImageIcon(urlDigit6);
    private static  Icon iconDigit6Green = new ImageIcon(urlDigit6Green);

    //Picture for the digit 7
    private static URL urlDigit7 = Ressource.class.getResource("/digit7.png");
    private static URL urlDigit7Green = Ressource.class.getResource("/digit7Green.png");
    private static  Icon iconDigit7 = new ImageIcon(urlDigit7);
    private static   Icon iconDigit7Green = new ImageIcon(urlDigit7Green);

    //Picture for the digit 8
    private static URL urlDigit8 = Ressource.class.getResource("/digit8.png");
    private static URL urlDigit8Green = Ressource.class.getResource("/digit8Green.png");
    private static   Icon iconDigit8 = new ImageIcon(urlDigit8);
    private static  Icon iconDigit8Green = new ImageIcon(urlDigit8Green);

    //Picture for the digit 9
    private static URL urlDigit9 = Ressource.class.getResource("/digit9.png");
    private static URL urlDigit9Green = Ressource.class.getResource("/digit9Green.png");
    private static Icon iconDigit9 = new ImageIcon(urlDigit9);
    private static Icon iconDigit9Green = new ImageIcon(urlDigit9Green);

    //Picture for the cancel button
    private static URL urlCross = Ressource.class.getResource("/cross.png");
    private static URL urlCrossPressed = Ressource.class.getResource("/crossPressed.png");
    private static Icon iconCross = new ImageIcon(urlCross);
    private static  Icon iconCrossPressed = new ImageIcon(urlCrossPressed);

    //Picture for the validate button
    private static URL urlCheck = Ressource.class.getResource("/check.png");
    private static URL urlCheckPressed = Ressource.class.getResource("/checkPressed.png");
    private static Icon iconCheck = new ImageIcon(urlCheck);
    private static  Icon iconCheckPressed = new ImageIcon(urlCheckPressed);

    //Picture for the User/Supervisor mode
    private static URL urlUser = Ressource.class.getResource("/user.png");
    private static URL urlSupervisor = Ressource.class.getResource("/supervisor.png");
    private static Icon iconUser = new ImageIcon(urlUser);
    private static Icon iconSupervisor = new ImageIcon(urlSupervisor);

    //Picture for the led for the supervisor button
    private static URL urlLedOff = Ressource.class.getResource("/ledOff.png");
    private static URL urlLedGreen = Ressource.class.getResource("/ledGreen.png");
    private static URL urlLedRed = Ressource.class.getResource("/ledRed.png");
    private static  Icon iconLedOff = new ImageIcon(urlLedOff);
    private static  Icon iconLedGreen = new ImageIcon(urlLedGreen);
    private static  Icon iconLedRed = new ImageIcon(urlLedRed);

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
    private static  Icon iconElevatorOff = new ImageIcon(urlElevatorOff);
    private static  Icon iconElevator0 = new ImageIcon(urlElevator0);
    private static Icon iconElevator0Up = new ImageIcon(urlElevator0Up);
    private static Icon iconElevator0Down = new ImageIcon(urlElevator0Down);
    private static Icon iconElevator1 = new ImageIcon(urlElevator1);
    private static  Icon iconElevator1Up = new ImageIcon(urlElevator1Up);
    private static  Icon iconElevator1Down = new ImageIcon(urlElevator1Down);
    private static  Icon iconElevator2 = new ImageIcon(urlElevator2);
    private static  Icon iconElevator2Up = new ImageIcon(urlElevator2Up);
    private static  Icon iconElevator2Down = new ImageIcon(urlElevator2Down);
    private static  Icon iconElevator3 = new ImageIcon(urlElevator3);
    private static  Icon iconElevator3Up = new ImageIcon(urlElevator3Up);
    private static  Icon iconElevator3Down = new ImageIcon(urlElevator3Down);
    private static  Icon iconElevatorUp = new ImageIcon(urlElevatorUp);
    private static   Icon iconElevatorDown = new ImageIcon(urlElevatorDown);
    private static   Icon iconElevatorSmile = new ImageIcon(urlElevatorSmile);

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

    public static Icon getIconUp() {
        return iconUp;
    }

    public static Icon getIconUpGreen() {
        return iconUpGreen;
    }

    public static  Icon getIconDown() {
        return iconDown;
    }

    public static Icon getIconDownGreen() {
        return iconDownGreen;
    }

    public static Icon getIconStop() {
        return iconStop;
    }

    public static Icon getIconStopRed() {
        return iconStopRed;
    }

    public static Icon getIconOpen() {
        return iconOpen;
    }

    public static Icon getIconOpenGreen() {
        return iconOpenGreen;
    }

    public static Icon getIconOpenRed() {
        return iconOpenRed;
    }

    public static Icon getIconClose() {
        return iconClose;
    }

    public static Icon getIconCloseGreen() {
        return iconCloseGreen;
    }

    public static Icon getIconCloseRed() {
        return iconCloseRed;
    }

    public static  Icon getIconLevel0() {
        return iconLevel0;
    }

    public static Icon getIconLevel0Green() {
        return iconLevel0Green;
    }

    public static Icon getIconLevel0Red() {
        return iconLevel0Red;
    }

    public static Icon getIconLevel1() {
        return iconLevel1;
    }

    public static Icon getIconLevel1Green() {
        return iconLevel1Green;
    }

    public static Icon getIconLevel1Red() {
        return iconLevel1Red;
    }

    public static Icon getIconLevel2() {
        return iconLevel2;
    }

    public static Icon getIconLevel2Red() {
        return iconLevel2Red;
    }

    public static Icon getIconLevel2Green() {
        return iconLevel2Green;
    }

    public static Icon getIconLevel3() {
        return iconLevel3;
    }

    public static Icon getIconLevel3Green() {
        return iconLevel3Green;
    }

    public static Icon getIconLevel3Red() {
        return iconLevel3Red;
    }

    public static Icon getIconDigit0() {
        return iconDigit0;
    }

    public static Icon getIconDigit0Green() {
        return iconDigit0Green;
    }

    public static Icon getIconDigit1() {
        return iconDigit1;
    }

    public static Icon getIconDigit1Green() {
        return iconDigit1Green;
    }

    public static Icon getIconDigit2() {
        return iconDigit2;
    }

    public static Icon getIconDigit2Green() {
        return iconDigit2Green;
    }

    public static Icon getIconDigit3() {
        return iconDigit3;
    }

    public static Icon getIconDigit3Green() {
        return iconDigit3Green;
    }

    public static Icon getIconDigit4() {
        return iconDigit4;
    }

    public static Icon getIconDigit4Green() {
        return iconDigit4Green;
    }

    public static Icon getIconDigit5() {
        return iconDigit5;
    }

    public static Icon getIconDigit5Green() {
        return iconDigit5Green;
    }

    public static Icon getIconDigit6() {
        return iconDigit6;
    }

    public static Icon getIconDigit6Green() {
        return iconDigit6Green;
    }

    public static Icon getIconDigit7() {
        return iconDigit7;
    }

    public static Icon getIconDigit7Green() {
        return iconDigit7Green;
    }

    public static Icon getIconDigit8() {
        return iconDigit8;
    }

    public static Icon getIconDigit8Green() {
        return iconDigit8Green;
    }

    public static Icon getIconDigit9() {
        return iconDigit9;
    }

    public static Icon getIconDigit9Green() {
        return iconDigit9Green;
    }

    public static Icon getIconCross() {
        return iconCross;
    }

    public static Icon getIconCrossPressed() {
        return iconCrossPressed;
    }

    public static Icon getIconCheck() {
        return iconCheck;
    }

    public static Icon getIconCheckPressed() {
        return iconCheckPressed;
    }

    public static Icon getIconUser() {
        return iconUser;
    }

    public static Icon getIconSupervisor() {
        return iconSupervisor;
    }

    public static Icon getIconLedOff() {
        return iconLedOff;
    }

    public static Icon getIconLedGreen() {
        return iconLedGreen;
    }

    public static Icon getIconLedRed() {
        return iconLedRed;
    }

    public static Icon getIconElevatorOff() {
        return iconElevatorOff;
    }

    public static Icon getIconElevator0() {
        return iconElevator0;
    }

    public static Icon getIconElevator1() {
        return iconElevator1;
    }

    public static Icon getIconElevator2() {
        return iconElevator2;
    }

    public static Icon getIconElevator3() {
        return iconElevator3;
    }

    public static Icon getIconElevatorUp() {
        return iconElevatorUp;
    }

    public static Icon getIconElevatorDown() {
        return iconElevatorDown;
    }

    public static Icon getIconElevatorSmile() {
        return iconElevatorSmile;
    }

    public static Icon getIconElevator0Up() {
        return iconElevator0Up;
    }

    public static Icon getIconElevator0Down() {
        return iconElevator0Down;
    }

    public static Icon getIconElevator1Up() {
        return iconElevator1Up;
    }

    public static Icon getIconElevator1Down() {
        return iconElevator1Down;
    }

    public static Icon getIconElevator2Up() {
        return iconElevator2Up;
    }

    public static Icon getIconElevator2Down() {
        return iconElevator2Down;
    }

    public static Icon getIconElevator3Up() {
        return iconElevator3Up;
    }

    public static Icon getIconElevator3Down() {
        return iconElevator3Down;
    }
}