package com.helpezee.generics;

public class TestMultiGenericContainer {

	public static void main(String[] args) {

		MultiGenericContainer<String, String> mondayWeather = new MultiGenericContainer<String, String>("Monday","Sunny");
		MultiGenericContainer<Integer, Double> dayOfWeekDegrees = new MultiGenericContainer<Integer, Double>(1, 78.0);

		String mondayForecast = mondayWeather.getFirstPosition();
		System.out.println("mondayForecast----" + mondayForecast);
		// The Double type is unboxed--to double, in this case. More on this in
		// next section!
		double sundayDegrees = dayOfWeekDegrees.getSecondPosition();
		System.out.println("sundayDegrees-----" + sundayDegrees);

		/* ################################################## */
		MultiGenericContainer<String, String> mondayWeather1 = new MultiGenericContainer<>("Monday","Sunny");
		MultiGenericContainer<Integer, Double> dayOfWeekDegrees1 = new MultiGenericContainer<>(1, 78.0);
		String mondayForecast1 = mondayWeather1.getFirstPosition(); // Works fine with String
		// The following generates "Incompatible types" error and won't compile
		//int mondayOutlook = mondayWeather1.getSecondPosition();
		double sundayDegrees1 = dayOfWeekDegrees1.getSecondPosition(); // Unboxing ccurs

	}

}
