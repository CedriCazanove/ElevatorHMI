import org.json.JSONArray;
import org.json.JSONException;

public class Elevator {
	
	public interface ElevatorListener {

		//Action to trigger when the door state of the elevator change
		public void doorStateChanged();
      
		//Action to trigger when the current level of the elevator change
		public void currentLevelChanged();
		
		//Action to trigger when the state of the elevator change
		public void elevatorStateChanged();
		
		//Action to trigger when the direction of the elevator change
		public void directionChanged();
	      
	}
	
	private DoorState doorState;
	
	private ElevatorState elevatorState;
	
	private int currentLevel;
	
	private Direction direction;

	private Boolean req1 = false;

	private Boolean up1 = false;

	private Boolean req2 = false;

	private Boolean up2 = false;

	private Boolean down2 = false;

	private Boolean req3 = false;

	private Boolean up3 = false;

	private Boolean down3 = false;

	private Boolean req4 = false;

	private Boolean down4 = false;

	private Boolean open = false;

	private Boolean close = false;

	private Boolean emergency = false;

	private Boolean POreset = false;

	private Boolean POdv2 = false;

	private Boolean POdv1 = false;

	private Boolean POuv1 = false;

	private Boolean POuv2 = false;

	private Boolean POdclose = false;

	private Boolean POdopen = false;

	private int POv_crawlSelect;

	private Boolean PIs_l1sl = false;

	private Boolean PIs_l1r = false;

	private Boolean PIs_l1su = false;

	private Boolean PIs_l1au = false;

	private Boolean PIs_l2sl = false;

	private Boolean PIs_l2r = false;

	private Boolean PIs_l2su = false;

	private Boolean PIs_l2au = false;

	private Boolean PIs_l3sl = false;

	private Boolean PIs_l3r = false;

	private Boolean PIs_l3su = false;

	private Boolean PIs_l3au = false;

	private Boolean PIs_l4sl = false;

	private Boolean PIs_l4r = false;

	private Boolean PIs_l4su = false;

	private Boolean PIs_l4au = false;

	private Boolean PIs_dopened = false;

	private Boolean PIs_dclosed = true;

	private Boolean PIm_ready = false;

	private Boolean PIm_on = false;

	private Boolean PIm_error = false;

	private int PIs_v;
	
	private ElevatorListener listener;

	Elevator() {
		this.doorState = DoorState.CLOSE;
		this.elevatorState = ElevatorState.OUTOFSERVICE;
		this.direction = Direction.IDLE;
		this.currentLevel = 0;
		this.setListener(null);
	}
	
	public Elevator(DoorState doorState, ElevatorState elevatorState, int currentLevel, Direction direction) {
		this.doorState = doorState;
		this.elevatorState = elevatorState;
		this.direction = direction;
		this.currentLevel = currentLevel;
		this.setListener(null);
	}

	public DoorState getDoorState() {
		return doorState;
	}

	public void setDoorState(DoorState doorState) {
		this.doorState = doorState;
		if (listener != null) {
            listener.doorStateChanged();
		}
	}

	public ElevatorState getElevatorState() {
		return elevatorState;
	}

	public void setElevatorState(ElevatorState elevatorState) {
		this.elevatorState = elevatorState;
		if (listener != null) {
            listener.elevatorStateChanged();
		}
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
		if (listener != null) {
            listener.directionChanged();
		}
	}

	public int getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
		if (listener != null) {
            listener.currentLevelChanged();
		}
	}

	public Boolean getReq1() {
		return req1;
	}

	public void setReq1(Boolean req1) {
		this.req1 = req1;
	}

	public Boolean getUp1() {
		return up1;
	}

	public void setUp1(Boolean up1) {
		this.up1 = up1;
	}

	public Boolean getReq2() {
		return req2;
	}

	public void setReq2(Boolean req2) {
		this.req2 = req2;
	}

	public Boolean getUp2() {
		return up2;
	}

	public void setUp2(Boolean up2) {
		this.up2 = up2;
	}

	public Boolean getDown2() {
		return down2;
	}

	public void setDown2(Boolean down2) {
		this.down2 = down2;
	}

	public Boolean getReq3() {
		return req3;
	}

	public void setReq3(Boolean req3) {
		this.req3 = req3;
	}

	public Boolean getUp3() {
		return up3;
	}

	public void setUp3(Boolean up3) {
		this.up3 = up3;
	}

	public Boolean getDown3() {
		return down3;
	}

	public void setDown3(Boolean down3) {
		this.down3 = down3;
	}

	public Boolean getReq4() {
		return req4;
	}

	public void setReq4(Boolean req4) {
		this.req4 = req4;
	}

	public Boolean getDown4() {
		return down4;
	}

	public void setDown4(Boolean down4) {
		this.down4 = down4;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public Boolean getClose() {
		return close;
	}

	public void setClose(Boolean close) {
		this.close = close;
	}

	public Boolean getEmergency() {
		return emergency;
	}

	public void setEmergency(Boolean emergency) {
		this.emergency = emergency;
	}

	public Boolean getPOreset() {
		return POreset;
	}

	public void setPOreset(Boolean POreset) {
		this.POreset = POreset;
	}

	public Boolean getPOdv2() {
		return POdv2;
	}

	public void setPOdv2(Boolean POdv2) {
		this.POdv2 = POdv2;
	}

	public Boolean getPOdv1() {
		return POdv1;
	}

	public void setPOdv1(Boolean POdv1) {
		this.POdv1 = POdv1;
	}

	public Boolean getPOuv1() {
		return POuv1;
	}

	public void setPOuv1(Boolean POuv1) {
		this.POuv1 = POuv1;
	}

	public Boolean getPOuv2() {
		return POuv2;
	}

	public void setPOuv2(Boolean POuv2) {
		this.POuv2 = POuv2;
	}

	public Boolean getPOdclose() {
		return POdclose;
	}

	public void setPOdclose(Boolean POdclose) {
		this.POdclose = POdclose;
	}

	public Boolean getPOdopen() {
		return POdopen;
	}

	public void setPOdopen(Boolean POdopen) {
		this.POdopen = POdopen;
	}

	public int getPOv_crawlSelect() {
		return POv_crawlSelect;
	}

	public void setPOv_crawlSelect(int POv_crawlSelect) {
		this.POv_crawlSelect = POv_crawlSelect;
	}

	public Boolean getPIs_l1sl() {
		return PIs_l1sl;
	}

	public void setPIs_l1sl(Boolean PIs_l1sl) {
		this.PIs_l1sl = PIs_l1sl;
	}

	public Boolean getPIs_l1r() {
		return PIs_l1r;
	}

	public void setPIs_l1r(Boolean PIs_l1r) {
		this.PIs_l1r = PIs_l1r;
	}

	public Boolean getPIs_l1su() {
		return PIs_l1su;
	}

	public void setPIs_l1su(Boolean PIs_l1su) {
		this.PIs_l1su = PIs_l1su;
	}

	public Boolean getPIs_l1au() {
		return PIs_l1au;
	}

	public void setPIs_l1au(Boolean PIs_l1au) {
		this.PIs_l1au = PIs_l1au;
	}

	public Boolean getPIs_l2sl() {
		return PIs_l2sl;
	}

	public void setPIs_l2sl(Boolean PIs_l2sl) {
		this.PIs_l2sl = PIs_l2sl;
	}

	public Boolean getPIs_l2r() {
		return PIs_l2r;
	}

	public void setPIs_l2r(Boolean PIs_l2r) {
		this.PIs_l2r = PIs_l2r;
	}

	public Boolean getPIs_l2su() {
		return PIs_l2su;
	}

	public void setPIs_l2su(Boolean PIs_l2su) {
		this.PIs_l2su = PIs_l2su;
	}

	public Boolean getPIs_l2au() {
		return PIs_l2au;
	}

	public void setPIs_l2au(Boolean PIs_l2au) {
		this.PIs_l2au = PIs_l2au;
	}

	public Boolean getPIs_l3sl() {
		return PIs_l3sl;
	}

	public void setPIs_l3sl(Boolean PIs_l3sl) {
		this.PIs_l3sl = PIs_l3sl;
	}

	public Boolean getPIs_l3r() {
		return PIs_l3r;
	}

	public void setPIs_l3r(Boolean PIs_l3r) {
		this.PIs_l3r = PIs_l3r;
	}

	public Boolean getPIs_l3su() {
		return PIs_l3su;
	}

	public void setPIs_l3su(Boolean PIs_l3su) {
		this.PIs_l3su = PIs_l3su;
	}

	public Boolean getPIs_l3au() {
		return PIs_l3au;
	}

	public void setPIs_l3au(Boolean PIs_l3au) {
		this.PIs_l3au = PIs_l3au;
	}

	public Boolean getPIs_l4sl() {
		return PIs_l4sl;
	}

	public void setPIs_l4sl(Boolean PIs_l4sl) {
		this.PIs_l4sl = PIs_l4sl;
	}

	public Boolean getPIs_l4r() {
		return PIs_l4r;
	}

	public void setPIs_l4r(Boolean PIs_l4r) {
		this.PIs_l4r = PIs_l4r;
	}

	public Boolean getPIs_l4su() {
		return PIs_l4su;
	}

	public void setPIs_l4su(Boolean PIs_l4su) {
		this.PIs_l4su = PIs_l4su;
	}

	public Boolean getPIs_l4au() {
		return PIs_l4au;
	}

	public void setPIs_l4au(Boolean PIs_l4au) {
		this.PIs_l4au = PIs_l4au;
	}

	public Boolean getPIs_dopened() {
		return PIs_dopened;
	}

	public void setPIs_dopened(Boolean PIs_dopened) {
		this.PIs_dopened = PIs_dopened;
	}

	public Boolean getPIs_dclosed() {
		return PIs_dclosed;
	}

	public void setPIs_dclosed(Boolean PIs_dclosed) {
		this.PIs_dclosed = PIs_dclosed;
	}

	public Boolean getPIm_ready() {
		return PIm_ready;
	}

	public void setPIm_ready(Boolean PIm_ready) {
		this.PIm_ready = PIm_ready;
	}

	public Boolean getPIm_on() {
		return PIm_on;
	}

	public void setPIm_on(Boolean PIm_on) {
		this.PIm_on = PIm_on;
	}

	public Boolean getPIm_error() {
		return PIm_error;
	}

	public void setPIm_error(Boolean PIm_error) {
		this.PIm_error = PIm_error;
	}

	public int getPIs_v() {
		return PIs_v;
	}

	public void setPIs_v(int PIs_v) {
		this.PIs_v = PIs_v;
	}

	public ElevatorListener getListener() {
		return listener;
	}

	public void setListener(ElevatorListener listener) {
		this.listener = listener;
	}
	
	public String toString() {
		return "Elevator : \n - DoorState : " + this.doorState + 
						  "\n - ElevatorState : " + this.elevatorState +
						  "\n - CurrentLevel : " + this.currentLevel +
						  "\n - Direction : " + this.direction;
	}
	
	public void treatRequestBackState(RequestBackState requestState) {
		System.out.println("Elevator received a state request to treat");
		if (requestState.getType().equals("DoorState")) {
			if (requestState.getState().equals("opened")) {
				setDoorState(DoorState.OPEN);
			} else if (requestState.getState().equals("closed")) {
				setDoorState(DoorState.CLOSE);
			} else if (requestState.getState().equals("in motion")) {
				setDoorState(DoorState.CLOSING);
			}
		}
	}
	
	public void treatRequestBackLevel(RequestBackLevel requestLevel) {
		System.out.println("Elevator received a level request to treat");
		try {
			System.out.println(" New Level : " + requestLevel.getLevel().toString());
			setCurrentLevel(Integer.parseInt(requestLevel.getLevel()));
			System.out.println(toString());
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public void treatRequestBackDirection(RequestBackDirection requestState) {
		System.out.println("Elevator received a direction request to treat");
		if (requestState.getDirection().equals("up")) {
			setDirection(Direction.UP);
		} else if (requestState.getDirection().equals("down")) {
			setDirection(Direction.DOWN);
		} else if (requestState.getDirection().equals("idle")) {
			setDirection(Direction.IDLE);
		}
	}

	public void treatRequestBackAnswer(RequestBackPanelAnswer requestBackPanelAnswer) throws JSONException {
		System.out.println("Elevator received a panel answer request to treat");
		JSONArray allStates = requestBackPanelAnswer.getAnswer();
		for (int i = 0; i < allStates.length(); i++) {
			String name = allStates.getJSONObject(i).getString("name");
			switch (name) {
				case "PIs_l1sl":
					setPIs_l1sl(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("PIs_l1sl");
					break;
				case "PIs_l1r":
					setPIs_l1r(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("PIs_l1r");
					break;
				case "PIs_l&su":
					setPIs_l1su(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("PIs_l1su");
					break;
				case "PIs_l1au":
					setPIs_l1au(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("PIs_l1au");
					break;
				case "PIs_l2sl":
					setPIs_l2sl(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("PIs_l2sl");
					break;
				case "PIs_l2r":
					setPIs_l2r(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("PIs_l2r");
					break;
				case "PIs_l2su":
					setPIs_l2su(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("PIs_l2su");
					break;
				case "PIs_l2au":
					setPIs_l2au(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("PIs_l2au");
					break;
				case "PIs_l3sl":
					setPIs_l3sl(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("PIs_l3sl");
					break;
				case "PIs_l3r":
					setPIs_l3r(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("PIs_l3r");
					break;
				case "PIs_l3su":
					setPIs_l3su(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("PIs_l3su");
					break;
				case "PIs_l3au":
					setPIs_l3au(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("PIs_l3au");
					break;
				case "PIs_l4sl":
					setPIs_l4sl(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("PIs_l4sl");
					break;
				case "PIs_l4r":
					setPIs_l4r(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("PIs_l4r");
					break;
				case "PIs_l4su":
					setPIs_l1su(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("PIs_l4su");
					break;
				case "PIs_l4au":
					setPIs_l4au(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("PIs_l4au");
					break;
				case "POreset":
					setPOreset(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("POreset");
					break;
				case "POdv2":
					setPOdv2(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("POdv2");
					break;
				case "POdv1":
					setPOdv1(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("POdv1");
					break;
				case "POuv1":
					setPOuv1(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("POuv1");
					break;
				case "POuv2":
					setPOuv2(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("POuv2");
					break;
				case "POdclose":
					setPOdclose(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("POdclose");
					break;
				case "POdopen":
					setPOdopen(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("POdopen");
					break;
				case "POv_crawlSelect":
					setPOv_crawlSelect(allStates.getJSONObject(i).getInt("value"));
					System.out.println("POv_crawlSelect");
					break;
				case "PIs_dopened":
					setPIs_dopened(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("PIs_dopened");
					break;
				case "PIs_dclosed":
					setPIs_dclosed(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("PIs_dclosed");
					break;
				case "PIm_ready":
					setPIm_ready(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("PIm_ready");
					break;
				case "PIm_on":
					setPIm_on(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("PIm_on");
					break;
				case "PIm_error":
					setPIm_error(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("PIm_error");
					break;
				case "PIs_v":
					setPIs_v(allStates.getJSONObject(i).getInt("value"));
					System.out.println("PIs_v");
					break;
				case "1REQ":
					setReq1(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("1REQ");
					break;
				case "1UP":
					setUp1(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("1UP");
					break;
				case "2REQ":
					setReq2(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("2REQ");
					break;
				case "2UP":
					setUp2(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("2UP");
					break;
				case "2DOWN":
					setDown2(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("2DOWN");
					break;
				case "3REQ":
					setReq3(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("3REQ");
					break;
				case "3UP":
					setUp3(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("3UP");
					break;
				case "3DOWN":
					setDown3(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("3DOWN");
					break;
				case "4REQ":
					setReq4(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("4REQ");
					break;
				case "4DOWN":
					setDown4(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("4DOWN");
					break;
				case "OPEN":
					setOpen(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("OPEN");
					break;
				case "CLOSE":
					setClose(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("CLOSE");
					break;
				case "EMERGENCY":
					setEmergency(allStates.getJSONObject(i).getBoolean("value"));
					System.out.println("EMERGENCY");
					break;
				default:
					System.out.println("No state match");
					break;
			}
		}
	}
}
