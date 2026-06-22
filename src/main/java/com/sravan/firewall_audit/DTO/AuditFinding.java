package com.sravan.firewall_audit.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AuditFinding {

    private String ruleName;
    private String riskLevel;
    private String finding;
    private String recommendation;

    public AuditFinding() {
    }

    public AuditFinding(String ruleName, String riskLevel,
                        String finding, String recommendation) {
        this.ruleName = ruleName;
        this.riskLevel = riskLevel;
        this.finding = finding;
        this.recommendation = recommendation;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getFinding() {
        return finding;
    }

    public void setFinding(String finding) {
        this.finding = finding;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}
