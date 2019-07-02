package org.sambhav.transport.customs;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

@Component
public class Payment {

	private Double calculateDistance(String distance)
	{
		String substring = null;
		int index = 0;
		for(int i=0;i<distance.length();i++) {
			if(!Character.isDigit(distance.charAt(i)) && distance.charAt(i)!='.')
			{
				index = i;
				break;
			}
		}
		
		substring = distance.substring(0,index);
		Double value = Double.parseDouble(substring);
		
		return value;
	}
	public Double calculatePrice (String distance)
	{
		Double value = calculateDistance(distance);
		
//		Assuming avg speed of truck to go from one place to another is 30-40km/hr = (30+40)/2 = 35km/hr
		
//		Assuming the perkm 
//		Rate of fuel = 66.5 per litre
//		Average mileage of trucks is 7 km/litre
		
		double fuelUsed = value/(7.0);
		double priceFuel = fuelUsed*66.5;
		
//		We set a charge of Rs 4/km
//		Initially this value will be set after some time we can increase the value
		double priceApp = value*4.0;
		double totalPrice = priceApp + priceFuel;
		BigDecimal bd = new BigDecimal(totalPrice).setScale(2, RoundingMode.HALF_UP);
        totalPrice = bd.doubleValue();
        return totalPrice;
	}
	
	public Double hrsTaken(String distance)
	{
		Double value = calculateDistance(distance);
		Double hrs = value/35.0;
		Double hrsInTraffic = 0.5;
		double totalTime = hrs+hrsInTraffic;
		BigDecimal bd = new BigDecimal(totalTime).setScale(2, RoundingMode.HALF_UP);
        totalTime = bd.doubleValue();
		return totalTime;
	}
}
