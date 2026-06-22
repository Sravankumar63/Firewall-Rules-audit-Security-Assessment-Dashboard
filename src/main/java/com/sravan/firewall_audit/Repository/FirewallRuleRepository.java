package com.sravan.firewall_audit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sravan.firewall_audit.Model.FirewallRule;

public interface FirewallRuleRepository extends JpaRepository<FirewallRule, Long> {

}
