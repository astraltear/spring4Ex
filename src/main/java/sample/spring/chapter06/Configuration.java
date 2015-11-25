package sample.spring.chapter06;

import org.springframework.stereotype.Component;

@Component("configuration")
public class Configuration {
	public static String environment="DEV";
	
	public String getCountry() {
		return "Some Country";
	}
	
	public String getState() {
		return "Some state";
	}
	
	public String[] splitName(String name) {
		return name.split(" ");
	}
	
}
