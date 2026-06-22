package com.sravan.firewall_audit.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sravan.firewall_audit.Repository.FirewallRuleRepository;
import com.sravan.firewall_audit.DTO.AuditFinding;
import com.sravan.firewall_audit.Model.FirewallRule;

@Service
public class FirewallRuleService {

    @Autowired
    private FirewallRuleRepository firewallRuleRepository;

    public List<FirewallRule> getAllRules() {

        return firewallRuleRepository.findAll();

    }
    public FirewallRule saveRule(FirewallRule firewallRule) {

        return firewallRuleRepository.save(firewallRule);

    }
    
    public List<FirewallRule> findDangerousRules() {

        List<FirewallRule> allRules = firewallRuleRepository.findAll();

        return allRules.stream()
                .filter(rule ->
                        rule.getEnabled() &&
                        rule.getAction().equalsIgnoreCase("ALLOW") &&
                        (rule.getPort() == 21 ||
                         rule.getPort() == 23 ||
                         rule.getPort() == 3389))
                .toList();
    }
    
    public List<AuditFinding> generateAuditReport() {

        List<FirewallRule> dangerousRules = findDangerousRules();

        List<AuditFinding> findings = new ArrayList<>();

        for (FirewallRule rule : dangerousRules) {

            AuditFinding finding = new AuditFinding();

            finding.setRuleName(rule.getRuleName());

            if (rule.getPort() == 23) {

                finding.setRiskLevel("HIGH");
                finding.setFinding("Telnet transmits credentials in plaintext");
                finding.setRecommendation("Replace Telnet with SSH on port 22");

            }

            findings.add(finding);
        }

        return findings;
    }
}
