package com.sravan.firewall_audit.DTO;

import java.util.List;

public class AssessmentResponse {

    private String targetIp;
    private List<Integer> openPorts;
    private int highRisk;
    private int mediumRisk;
    private int score;

    public String getTargetIp() {
        return targetIp;
    }

    public void setTargetIp(String targetIp) {
        this.targetIp = targetIp;
    }

    public List<Integer> getOpenPorts() {
        return openPorts;
    }

    public void setOpenPorts(List<Integer> openPorts) {
        this.openPorts = openPorts;
    }

    public int getHighRisk() {
        return highRisk;
    }

    public void setHighRisk(int highRisk) {
        this.highRisk = highRisk;
    }

    public int getMediumRisk() {
        return mediumRisk;
    }

    public void setMediumRisk(int mediumRisk) {
        this.mediumRisk = mediumRisk;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}