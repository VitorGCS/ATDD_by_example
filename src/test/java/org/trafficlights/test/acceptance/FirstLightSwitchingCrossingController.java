package org.trafficlights.test.acceptance;

import org.trafficlights.domain.LightState;

public class FirstLightSwitchingCrossingController {

    LightState firstState;

    public void setFirstLight(LightState state){
        firstState = state;
    }
    public void setSecondLight(LightState state){

    }

    public LightState firstLight(){
        return firstState.next();
    }

    public LightState secondLight() {
        return LightState.RED;
    }

}
