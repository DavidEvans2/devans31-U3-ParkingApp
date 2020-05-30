package Final.CheckInMachine;

import Final.CheckInSystem;
import Final.CheckOutSystem;
import Final.MachinePlan;

public enum CheckInPlan implements MachinePlan {
    INSTANCE;

    CheckInPlan(){
        try{
            Thread.currentThread().sleep(2000);
        }catch (InterruptedException ie){
        }
    }
    @Override
    public CheckInSystem getInSystemType(String type)
    {
        switch (type)
        {
            case "CheckIn":
                return new CheckIn();
            case "Special event CheckIn":
                return new SpecialEventCheckIn();
            default: return null;
        }
    }
    @Override
    public CheckOutSystem getOutSystemType(String type2){
        return null;
    }
}
