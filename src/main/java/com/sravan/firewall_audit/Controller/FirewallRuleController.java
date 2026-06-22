package com.sravan.firewall_audit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sravan.firewall_audit.DTO.AssessmentRequest;
import com.sravan.firewall_audit.DTO.AssessmentResponse;
import com.sravan.firewall_audit.DTO.AuditFinding;
import com.sravan.firewall_audit.Model.FirewallRule;
import com.sravan.firewall_audit.Service.FirewallRuleService;
import com.sravan.firewall_audit.Service.FirewallScannerService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/firewall")
public class FirewallRuleController {

    @Autowired
    private FirewallRuleService firewallRuleService;

    @Autowired
    private FirewallScannerService firewallScannerService;
    
    @GetMapping("/rules")
    public List<FirewallRule> getAllRules() {
        return firewallRuleService.getAllRules();
    }

    @PostMapping("/rules")
    public FirewallRule saveRule(
            @RequestBody FirewallRule firewallRule) {

        return firewallRuleService.saveRule(firewallRule);
    }

    @GetMapping("/audit/dangerous")
    public List<FirewallRule> getDangerousRules() {

        return firewallRuleService.findDangerousRules();
    }

    @GetMapping("/audit/report")
    public List<AuditFinding> getAuditReport() {

        return firewallRuleService.generateAuditReport();
    }
    
    @GetMapping("/iptables")
    public String getIptablesRules() {

        return firewallScannerService
                .getIptablesRules();
    }

    @PostMapping("/analyze")
    public AssessmentResponse analyzeFirewall(
            @RequestBody AssessmentRequest request) {

        AssessmentResponse response =
                new AssessmentResponse();

        response.setTargetIp(request.getIp());

        if ("192.168.1.100".equals(request.getIp())) {

            response.setOpenPorts(
                    List.of(21, 22, 80, 3389));

            response.setHighRisk(2);
            response.setMediumRisk(1);
            response.setScore(50);

        } else if ("10.0.0.5".equals(request.getIp())) {

            response.setOpenPorts(
                    List.of(22, 443));

            response.setHighRisk(0);
            response.setMediumRisk(0);
            response.setScore(90);

        } else if ("172.16.1.50".equals(request.getIp())) {

            response.setOpenPorts(
                    List.of(21, 23));

            response.setHighRisk(2);
            response.setMediumRisk(0);
            response.setScore(20);

        } else {

            response.setOpenPorts(
                    List.of(80));

            response.setHighRisk(0);
            response.setMediumRisk(1);
            response.setScore(70);
        }

        return response;
    }
}