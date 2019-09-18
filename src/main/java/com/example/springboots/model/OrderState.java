package com.example.springboots.model;

public class OrderState {
    private Integer state_id;


    private String state;

    public OrderState() {
        super();
    }

    public OrderState(Integer state_id, String state) {
        this.state_id = state_id;
        this.state = state;
    }

    public Integer getState_id() {
        return state_id;
    }

    public void setState_id(Integer state_id) {
        this.state_id = state_id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "OrderState{" +
                "state_id=" + state_id +
                ", state='" + state + '\'' +
                '}';
    }
}