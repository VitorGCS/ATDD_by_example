package org.trafficlights.test.acceptance;

import org.trafficlights.domain.LightState;

public class TrafficLights {

   /* //First implementation
    private String state;

    public void setPreviousState(String state){
        this.state = state;
    }

    public String nextState(){
        if("red".equals(state))
            return "red, yellow";
        if("red, yellow".equals(state))
            return "green";
        if("green".equals(state))
            return "yellow";
        if("yellow".equals(state))
            return "red";
        return "yellow blink";
    }*/

    //Second implementation with enumerations and with support in Fitnesse:
    private LightState state;

    public void setPreviousState(LightState state){
        this.state = state;
    }

    public LightState nextState(){
        return state.next();
    }
}