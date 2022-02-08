package Model.Elevator;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import Controller.Request.*;

public class Elevator {
	
	public interface ElevatorListener {

		//Action to trigger when the door state of the elevator changes
		public void doorStateChanged();
      
		//Action to trigger when the current level of the elevator changes
		public void currentLevelChanged();
		
		//Action to trigger when the state of the elevator changes
		public void elevatorStateChanged();
		
		//Action to trigger when the direction of the elevator changes
		public void directionChanged();

		//Action to trigger when req1 changes
		public void req1Changed();

		//Action to trigger when up1 changes
		public void up1Changed();

		//Action to trigger when req2 changes
		public void req2Changed();

		//Action to trigger when up2 changes
		public void up2Changed();

		//Action to trigger when down2 changed
		public void down2Changed();

		//Action to trigger when req3 changes
		public void req3Changed();

		//Action to trigger when up3 changes
		public void up3Changed();

		//Action to trigger when down3 changes
		public void down3Changed();

		//Action to trigger when req4 changes
		public void req4Changed();

		//Action to trigger when down4 changes
		public void down4Changed();

		//Action to trigger when open changes
		public void openChanged();

		//Action to trigger when close changes
		public void closeChanged();

		//Action to trigger when emergency changes
		public void emergencyChanged();

		//Action to trigger when POreset changes
		public void poresetChanged();

		//Action to trigger when podv2 changes
		public void podv2Changed();

		//Action to trigger when podv1 changes
		public void podv1Changed();

		//Action to trigger when pouv1 changes
		public void pouv1Changed();

		//Action to trigger when pouv2 changes
		public void pouv2Changed();

		//Action to trigger when podclose changes
		public void podcloseChanged();

		//Action to trigger when podopen changes
		public void podopenChanged();

		//Action to trigger when pov_crawlselect changes
		public void povcrawlselectChanged();

		//Action to trigger when pis_l1sl changes
		public void pis_l1slChanged();

		//Action to trigger when pis_l1r changes
		public void pis_l1rChanged();

		//Action to trigger when pis_l1su changes
		public void pis_l1suChanged();

		//Action to trigger when pis_l1au changes
		public void pis_l1auChanged();

		//Action to trigger when pis_l2sl changes
		public void pis_l2slChanged();

		//Action to trigger when pis_l2r changes
		public void pis_l2rChanged();

		//Action to trigger when pis_l2su changes
		public void pis_l2suChanged();

		//Action to trigger when pis_l2au changes
		public void pis_l2auChanged();

		//Action to trigger when pis_l3sl changes
		public void pis_l3slChanged();

		//Action to trigger when pis_l3r changes
		public void pis_l3rChanged();

		//Action to trigger when pis_l3su changes
		public void pis_l3suChanged();

		//Action to trigger when pis_l3au changes
		public void pis_l3auChanged();

		//Action to trigger when pis_l4sl changes
		public void pis_l4slChanged();

		//Action to trigger when pis_l4r changes
		public void pis_l4rChanged();

		//Action to trigger when pis_l1al changes
		public void pis_l1alChanged();

		//Action to trigger when pis_l2al changes
		public void pis_l2alChanged();

		//Action to trigger when pis_l3al changes
		public void pis_l3alChanged();

		//Action to trigger when pis_l4al changes
		public void pis_l4alChanged();

		//Action to trigger when pis_l4su changes
		public void pis_l4suChanged();

		//Action to trigger when pis_l4au changes
		public void pis_l4auChanged();

		//Action to trigger when pis_dopened changes
		public void pis_dopenedChanged();

		//Action to trigger when pis_dclosed changes
		public void pis_dclosedChanged();

		//Action to trigger when pim_ready changes
		public void pim_readyChanged();

		//Action to trigger when pis_on changes
		public void pim_onChanged();

		//Action to trigger when pim_error changes
		public void pim_errorChanged();

		//Action to trigger when pis_v changes
		public void pis_vChanged();
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

	private Boolean PIs_l1al = false;

	private Boolean PIs_l2al = false;

	private Boolean PIs_l3al = false;

	private Boolean PIs_l4al = false;

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

	private ArrayList<ElevatorListener> allListener;

	public Elevator() {
		this.doorState = DoorState.CLOSE;
		this.elevatorState = ElevatorState.INSERVICE;
		this.direction = Direction.IDLE;
		this.currentLevel = 1;
		this.setAllListener(null);
	}
	
	public Elevator(DoorState doorState, ElevatorState elevatorState, int currentLevel, Direction direction) {
		this.doorState = doorState;
		this.elevatorState = elevatorState;
		this.direction = direction;
		this.currentLevel = currentLevel;
		this.setAllListener(null);
	}

	public void addNewElevatorListener(ElevatorListener elevatorListener) {
		if (this.allListener == null) {
			this.allListener = new ArrayList<>();
		}
		this.allListener.add(elevatorListener);
	}

	public DoorState getDoorState() {
		return doorState;
	}

	public void setDoorState(DoorState doorState) {
		this.doorState = doorState;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.doorStateChanged();
			}
		}
	}

	public ElevatorState getElevatorState() {
		return elevatorState;
	}

	public void setElevatorState(ElevatorState elevatorState) {
		this.elevatorState = elevatorState;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.elevatorStateChanged();
			}
		}
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.directionChanged();
			}
		}
	}

	public int getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.currentLevelChanged();
			}
		}
	}

	public Boolean getReq1() {
		return req1;
	}

	public void setReq1(Boolean req1) {
		this.req1 = req1;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.req1Changed();
			}
		}
	}

	public Boolean getUp1() {
		return up1;
	}

	public void setUp1(Boolean up1) {
		this.up1 = up1;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.up1Changed();
			}
		}
	}

	public Boolean getReq2() {
		return req2;
	}

	public void setReq2(Boolean req2) {
		this.req2 = req2;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.req2Changed();
			}
		}
	}

	public Boolean getUp2() {
		return up2;
	}

	public void setUp2(Boolean up2) {
		this.up2 = up2;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.up2Changed();
			}
		}
	}

	public Boolean getDown2() {
		return down2;
	}

	public void setDown2(Boolean down2) {
		this.down2 = down2;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.down2Changed();
			}
		}
	}

	public Boolean getReq3() {
		return req3;
	}

	public void setReq3(Boolean req3) {
		this.req3 = req3;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.req3Changed();
			}
		}
	}

	public Boolean getUp3() {
		return up3;
	}

	public void setUp3(Boolean up3) {
		this.up3 = up3;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.up3Changed();
			}
		}
	}

	public Boolean getDown3() {
		return down3;
	}

	public void setDown3(Boolean down3) {
		this.down3 = down3;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.down3Changed();
			}
		}
	}

	public Boolean getReq4() {
		return req4;
	}

	public void setReq4(Boolean req4) {
		this.req4 = req4;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.req4Changed();
			}
		}
	}

	public Boolean getDown4() {
		return down4;
	}

	public void setDown4(Boolean down4) {
		this.down4 = down4;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.down4Changed();
			}
		}
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.openChanged();
			}
		}
	}

	public Boolean getClose() {
		return close;
	}

	public void setClose(Boolean close) {
		this.close = close;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.closeChanged();
			}
		}
	}

	public Boolean getEmergency() {
		return emergency;
	}

	public void setEmergency(Boolean emergency) {
		this.emergency = emergency;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.emergencyChanged();
			}
		}
	}

	public Boolean getPOreset() {
		return POreset;
	}

	public void setPOreset(Boolean POreset) {
		this.POreset = POreset;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.poresetChanged();
			}
		}
	}

	public Boolean getPOdv2() {
		return POdv2;
	}

	public void setPOdv2(Boolean POdv2) {
		this.POdv2 = POdv2;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.podv2Changed();
			}
		}
	}

	public Boolean getPOdv1() {
		return POdv1;
	}

	public void setPOdv1(Boolean POdv1) {
		this.POdv1 = POdv1;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.podv1Changed();
			}
		}
	}

	public Boolean getPOuv1() {
		return POuv1;
	}

	public void setPOuv1(Boolean POuv1) {
		this.POuv1 = POuv1;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pouv1Changed();
			}
		}
	}

	public Boolean getPOuv2() {
		return POuv2;
	}

	public void setPOuv2(Boolean POuv2) {
		this.POuv2 = POuv2;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pouv2Changed();
			}
		}
	}

	public Boolean getPOdclose() {
		return POdclose;
	}

	public void setPOdclose(Boolean POdclose) {
		this.POdclose = POdclose;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.podcloseChanged();
			}
		}
	}

	public Boolean getPOdopen() {
		return POdopen;
	}

	public void setPOdopen(Boolean POdopen) {
		this.POdopen = POdopen;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.podopenChanged();
			}
		}
	}

	public int getPOv_crawlSelect() {
		return POv_crawlSelect;
	}

	public void setPOv_crawlSelect(int POv_crawlSelect) {
		this.POv_crawlSelect = POv_crawlSelect;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.povcrawlselectChanged();
			}
		}
	}

	public Boolean getPIs_l1sl() {
		return PIs_l1sl;
	}

	public void setPIs_l1sl(Boolean PIs_l1sl) {
		this.PIs_l1sl = PIs_l1sl;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pis_l1slChanged();
			}
		}
	}

	public Boolean getPIs_l1al() {
		return PIs_l1al;
	}

	public void setPIs_l1al(Boolean PIs_l1al) {
		this.PIs_l1al = PIs_l1al;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pis_l1alChanged();
			}
		}
	}

	public Boolean getPIs_l2al() {
		return PIs_l2al;
	}

	public void setPIs_l2al(Boolean PIs_l2al) {
		this.PIs_l2al = PIs_l2al;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pis_l2alChanged();
			}
		}
	}

	public Boolean getPIs_l3al() {
		return PIs_l3al;
	}

	public void setPIs_l3al(Boolean PIs_l3al) {
		this.PIs_l3al = PIs_l3al;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pis_l3alChanged();
			}
		}
	}

	public Boolean getPIs_l4al() {
		return PIs_l4al;
	}

	public void setPIs_l4al(Boolean PIs_l4al) {
		this.PIs_l4al = PIs_l4al;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pis_l4alChanged();
			}
		}
	}

	public Boolean getPIs_l1r() {
		return PIs_l1r;
	}

	public void setPIs_l1r(Boolean PIs_l1r) {
		this.PIs_l1r = PIs_l1r;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pis_l1rChanged();
			}
		}
	}

	public Boolean getPIs_l1su() {
		return PIs_l1su;
	}

	public void setPIs_l1su(Boolean PIs_l1su) {
		this.PIs_l1su = PIs_l1su;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pis_l1suChanged();
			}
		}
	}

	public Boolean getPIs_l1au() {
		return PIs_l1au;
	}

	public void setPIs_l1au(Boolean PIs_l1au) {
		this.PIs_l1au = PIs_l1au;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pis_l1auChanged();
			}
		}
	}

	public Boolean getPIs_l2sl() {
		return PIs_l2sl;
	}

	public void setPIs_l2sl(Boolean PIs_l2sl) {
		this.PIs_l2sl = PIs_l2sl;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pis_l2slChanged();
			}
		}
	}

	public Boolean getPIs_l2r() {
		return PIs_l2r;
	}

	public void setPIs_l2r(Boolean PIs_l2r) {
		this.PIs_l2r = PIs_l2r;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pis_l2rChanged();
			}
		}
	}

	public Boolean getPIs_l2su() {
		return PIs_l2su;
	}

	public void setPIs_l2su(Boolean PIs_l2su) {
		this.PIs_l2su = PIs_l2su;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pis_l2suChanged();
			}
		}
	}

	public Boolean getPIs_l2au() {
		return PIs_l2au;
	}

	public void setPIs_l2au(Boolean PIs_l2au) {
		this.PIs_l2au = PIs_l2au;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pis_l2auChanged();
			}
		}
	}

	public Boolean getPIs_l3sl() {
		return PIs_l3sl;
	}

	public void setPIs_l3sl(Boolean PIs_l3sl) {
		this.PIs_l3sl = PIs_l3sl;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pis_l3slChanged();
			}
		}
	}

	public Boolean getPIs_l3r() {
		return PIs_l3r;
	}

	public void setPIs_l3r(Boolean PIs_l3r) {
		this.PIs_l3r = PIs_l3r;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pis_l3rChanged();
			}
		}
	}

	public Boolean getPIs_l3su() {
		return PIs_l3su;
	}

	public void setPIs_l3su(Boolean PIs_l3su) {
		this.PIs_l3su = PIs_l3su;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pis_l3suChanged();
			}
		}
	}

	public Boolean getPIs_l3au() {
		return PIs_l3au;
	}

	public void setPIs_l3au(Boolean PIs_l3au) {
		this.PIs_l3au = PIs_l3au;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pis_l3auChanged();
			}
		}
	}

	public Boolean getPIs_l4sl() {
		return PIs_l4sl;
	}

	public void setPIs_l4sl(Boolean PIs_l4sl) {
		this.PIs_l4sl = PIs_l4sl;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pis_l4slChanged();
			}
		}
	}

	public Boolean getPIs_l4r() {
		return PIs_l4r;
	}

	public void setPIs_l4r(Boolean PIs_l4r) {
		this.PIs_l4r = PIs_l4r;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pis_l4rChanged();
			}
		}
	}

	public Boolean getPIs_l4su() {
		return PIs_l4su;
	}

	public void setPIs_l4su(Boolean PIs_l4su) {
		this.PIs_l4su = PIs_l4su;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pis_l4suChanged();
			}
		}
	}

	public Boolean getPIs_l4au() {
		return PIs_l4au;
	}

	public void setPIs_l4au(Boolean PIs_l4au) {
		this.PIs_l4au = PIs_l4au;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pis_l4auChanged();
			}
		}
	}

	public Boolean getPIs_dopened() {
		return PIs_dopened;
	}

	public void setPIs_dopened(Boolean PIs_dopened) {
		this.PIs_dopened = PIs_dopened;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pis_dopenedChanged();
			}
		}
	}

	public Boolean getPIs_dclosed() {
		return PIs_dclosed;
	}

	public void setPIs_dclosed(Boolean PIs_dclosed) {
		this.PIs_dclosed = PIs_dclosed;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pis_dclosedChanged();
			}
		}
	}

	public Boolean getPIm_ready() {
		return PIm_ready;
	}

	public void setPIm_ready(Boolean PIm_ready) {
		this.PIm_ready = PIm_ready;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pim_readyChanged();
			}
		}
	}

	public Boolean getPIm_on() {
		return PIm_on;
	}

	public void setPIm_on(Boolean PIm_on) {
		this.PIm_on = PIm_on;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pim_onChanged();
			}
		}
	}

	public Boolean getPIm_error() {
		return PIm_error;
	}

	public void setPIm_error(Boolean PIm_error) {
		this.PIm_error = PIm_error;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pim_errorChanged();
			}
		}
	}

	public int getPIs_v() {
		return PIs_v;
	}

	public void setPIs_v(int PIs_v) {
		this.PIs_v = PIs_v;
		if (allListener != null) {
			for (ElevatorListener listener : allListener) {
				listener.pis_vChanged();
			}
		}
	}

	public ArrayList<ElevatorListener> getAllListener() {
		return allListener;
	}

	public void setAllListener(ArrayList<ElevatorListener> allListener) {
		this.allListener = allListener;
	}

	public String toString() {
		return "Model.Elevator.Elevator : \n - DoorState : " + this.doorState +
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
		} else if (requestState.getType().equals("ServState")) {
			if (requestState.getState().equals("in service")) {
				setElevatorState(ElevatorState.INSERVICE);
			} else if (requestState.getState().equals("out of service")) {
				setElevatorState(ElevatorState.OUTOFSERVICE);
			} else if (requestState.getState().equals("emergency")) {
				setElevatorState(ElevatorState.EMERGENCY);
			} else if (requestState.getState().equals("power off")) {
				setElevatorState(ElevatorState.POWEROFF);
			}
		}
	}
	
	public void treatRequestBackLevel(RequestBackLevel requestLevel) {
		System.out.println("Model.Elevator.Elevator received a level request to treat");
		try {
			System.out.println(" New Level : " + requestLevel.getLevel().toString());
			setCurrentLevel(Integer.parseInt(requestLevel.getLevel()));
			System.out.println(toString());
		} catch(NumberFormatException e) {
			//e.printStackTrace();
			System.out.println("in transition");
			setCurrentLevel(-1); //for in transition
			System.out.println("in transition");
		}
	}

	public void treatRequestBackDirection(RequestBackDirection requestState) {
		System.out.println("Elevator received a direction request to treat");
		if (requestState.getDirection().equals("up") | requestState.getDirection().equals("UP")) {
			setDirection(Direction.UP);
		} else if (requestState.getDirection().equals("down") | requestState.getDirection().equals("DOWN")) {
			setDirection(Direction.DOWN);
		} else if (requestState.getDirection().equals("idle") | requestState.getDirection().equals("IDLE")) {
			setDirection(Direction.IDLE);
		}
	}

	public void treatRequestBackAnswer(RequestBackPanelAnswer requestBackPanelAnswer) throws JSONException {
		System.out.println("Elevator received a panel answer request to treat");
		JSONArray allStates = requestBackPanelAnswer.getAnswer();
		for (int i = 0; i < allStates.length(); i++) {
			//try {
			String name = allStates.getJSONObject(i).getString("name");
			System.out.println("name : " + name);
			switch (name) {
				case "PIs_l1sl":
					System.out.println("PIs_l1sl");
					setPIs_l1sl(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "PIs_l1al":
					System.out.println("PIs_l1al");
					setPIs_l1al(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "PIs_l2al":
					System.out.println("PIs_l2al");
					setPIs_l2al(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "PIs_l3al":
					System.out.println("PIs_l3al");
					setPIs_l3al(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "PIs_l4al":
					System.out.println("PIs_l4al");
					setPIs_l4al(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "PIs_l1r":
					System.out.println("PIs_l1r");
					setPIs_l1r(allStates.getJSONObject(i).getBoolean("value"));
					if (getPIs_l1r()) {
						setCurrentLevel(1);
					}
					break;
				case "PIs_l1su":
					System.out.println("PIs_l1su");
					setPIs_l1su(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "PIs_l1au":
					System.out.println("PIs_l1au");
					setPIs_l1au(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "PIs_l2sl":
					System.out.println("PIs_l2sl");
					setPIs_l2sl(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "PIs_l2r":
					System.out.println("PIs_l2r");
					setPIs_l2r(allStates.getJSONObject(i).getBoolean("value"));
					if (getPIs_l2r()) {
						setCurrentLevel(2);
					}
					break;
				case "PIs_l2su":
					System.out.println("PIs_l2su");
					setPIs_l2su(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "PIs_l2au":
					System.out.println("PIs_l2au");
					setPIs_l2au(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "PIs_l3sl":
					System.out.println("PIs_l3sl");
					setPIs_l3sl(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "PIs_l3r":
					System.out.println("PIs_l3r");
					setPIs_l3r(allStates.getJSONObject(i).getBoolean("value"));
					if (getPIs_l3r()) {
						setCurrentLevel(3);
					}
					break;
				case "PIs_l3su":
					System.out.println("PIs_l3su");
					setPIs_l3su(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "PIs_l3au":
					System.out.println("PIs_l3au");
					setPIs_l3au(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "PIs_l4sl":
					System.out.println("PIs_l4sl");
					setPIs_l4sl(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "PIs_l4r":
					System.out.println("PIs_l4r");
					setPIs_l4r(allStates.getJSONObject(i).getBoolean("value"));
					if (getPIs_l4r()) {
						setCurrentLevel(4);
					}
					break;
				case "PIs_l4su":
					System.out.println("PIs_l4su");
					setPIs_l1su(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "PIs_l4au":
					System.out.println("PIs_l4au");
					setPIs_l4au(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "POreset":
					System.out.println("POreset");
					setPOreset(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "POdv2":
					System.out.println("POdv2");
					setPOdv2(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "POdv1":
					System.out.println("POdv1");
					setPOdv1(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "POuv1":
					System.out.println("POuv1");
					setPOuv1(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "POuv2":
					System.out.println("POuv2");
					setPOuv2(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "POdclose":
					System.out.println("POdclose");
					setPOdclose(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "POdopen":
					System.out.println("POdopen");
					setPOdopen(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "POv_crawlSelect":
					System.out.println("POv_crawlSelect");
					setPOv_crawlSelect(allStates.getJSONObject(i).getInt("value"));
					break;
				case "PIs_dopened":
					System.out.println("PIs_dopened");
					setPIs_dopened(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "PIs_dclosed":
					System.out.println("PIs_dclosed");
					setPIs_dclosed(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "PIm_ready":
					System.out.println("PIm_ready");
					setPIm_ready(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "PIm_on":
					System.out.println("PIm_on");
					setPIm_on(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "PIm_error":
					System.out.println("PIm_error");
					setPIm_error(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "PIs_v":
					System.out.println("PIs_v");
					setPIs_v(allStates.getJSONObject(i).getInt("value"));
					break;
				case "1REQ":
					System.out.println("1REQ");
					setReq1(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "1UP":
					System.out.println("1UP");
					setUp1(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "2REQ":
					System.out.println("2REQ");
					setReq2(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "2UP":
					System.out.println("2UP");
					setUp2(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "2DOWN":
					System.out.println("2DOWN");
					setDown2(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "3REQ":
					System.out.println("3REQ");
					setReq3(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "3UP":
					System.out.println("3UP");
					setUp3(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "3DOWN":
					System.out.println("3DOWN");
					setDown3(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "4REQ":
					System.out.println("4REQ");
					setReq4(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "4DOWN":
					System.out.println("4DOWN");
					setDown4(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "OPEN":
					System.out.println("OPEN");
					setOpen(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "CLOSE":
					System.out.println("CLOSE");
					setClose(allStates.getJSONObject(i).getBoolean("value"));
					break;
				case "EMERGENCY":
					System.out.println("EMERGENCY");
					setEmergency(allStates.getJSONObject(i).getBoolean("value"));
					break;
				default:
					System.out.println("No state match");
					break;
			}
			/*} catch (JSONException e) {
				System.out.println("Error: " + e.getMessage());
			}*/
		}
	}
}
