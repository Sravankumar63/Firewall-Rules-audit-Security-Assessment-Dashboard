package com.sravan.firewall_audit.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

@Service
public class FirewallScannerService {

	public String getIptablesRules() {

	    StringBuilder output =
	            new StringBuilder();

	    try {

	        Process process =
	                Runtime.getRuntime()
	                .exec(new String[] {
	                    "wsl",
	                    "iptables",
	                    "-L",
	                    "-n",
	                    "-v"
	                });

	        BufferedReader reader =
	                new BufferedReader(
	                new InputStreamReader(
	                process.getInputStream()));

	        String line;

	        while ((line = reader.readLine())
	                != null) {

	            output.append(line)
	                  .append("\n");
	        }

	    } catch (Exception e) {

	        output.append(
	            "Error: "
	            + e.getMessage());
	    }

	    return output.toString();
	}
}