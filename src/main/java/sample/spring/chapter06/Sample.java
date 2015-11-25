package sample.spring.chapter06;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("sample")
public class Sample {
	
	@Value("#{configuration.environment}")
	private String environment;
	
	@Value("#{configuration.getCountry()}")
	private String country;
	
	@Value("#{configuration.getState()}")
	private String state;
	
	private String[] splitName;
	
	
	@Autowired
	public void splitName( @Value("#{configuration.splitName('FirstName LastName')}")  String [] splitName  ) {
		this.splitName = splitName;
	}

	@Override
	public String toString() {
		return "Sample [environment=" + environment + ", country=" + country
				+ ", state=" + state + ", splitName="
				+ Arrays.toString(splitName) + "]";
	}
}
