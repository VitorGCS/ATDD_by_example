package org.trafficlights.test.acceptance;

import org.trafficlights.domain.LightState;

public class FirstLightSwitchingCrossingController {

    LightState firstState;
    LightState secondState;

    public void setFirstLight(LightState state){
        firstState = state;
    }
    public void setSecondLight(LightState state){
        secondState = state;
    }

    public LightState firstLight(){
        return firstState;
    }

    public LightState secondLight() {
        return secondState;
    }

    public void execute(){
        firstState = firstState.next();
    }
}
