package org.usfirst.frc.team5951.robot.util;

public class UnitConverter {

	public enum Unit {
		CENTIMETER(1), METER(100), INCH(2.54), FOOT(30.48), MILIMETER(0.1);
		
		private double value;
		
		Unit(double value){
			this.value = value;
		}
		
		public double get() {
			return this.value;
		}
	}
	
	public static double convert(double value, Unit original, Unit convertTo) {
		return (value * original.get()) / convertTo.get();
	}

}
