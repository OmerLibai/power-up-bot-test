package org.usfirst.frc.team5951.robot.util;

/**
 * Contains functions to help with the steering of the chassis.
 * 
 * @author Yair Ziv
 */
public class ChassisMath {

	/**
	 * Function used to calculate power to each side of the chassis.
	 * 
	 * @param moveValue
	 *            - Joystick's Y value
	 * @param rotateValue
	 *            - Joystick X value
	 * @return - Power to each side of the chassis, position 0 is left side
	 *         position 1 is right side.
	 */
	public static double[] calculatePower(double moveValue, double rotateValue) {
		double[] arr = new double[2];
		if (moveValue > 1)
			moveValue = 1;
		if (moveValue < -1)
			moveValue = -1;
		if (rotateValue > 1)
			rotateValue = 1;
		if (rotateValue < -1)
			rotateValue = -1;
		double max = Math.max(Math.abs(moveValue), Math.abs(rotateValue));
		double sum = moveValue + rotateValue;
		double dif = moveValue - rotateValue;
		if (moveValue >= 0) {
			if (rotateValue >= 0) {
				arr[0] = max;
				arr[1] = dif;
			} else {
				arr[0] = sum;
				arr[1] = max;
			}
		} else {
			if (rotateValue >= 0) {
				arr[0] = sum;
				arr[1] = -max;
			} else {
				arr[0] = -max;
				arr[1] = dif;
			}
		}
		return arr;
	}
	
	/**
	 * @param moveValue
	 * @param rotateValue
	 * @param deadzone
	 * @return Power to each side of the chassis
	 */
	@Deprecated
	public static double[] calculatePowerDZ(double moveValue, double rotateValue, double deadzone) {
		double output[] = new double[2];
		
		if(Math.abs(moveValue) < deadzone) moveValue = 0;
		else if (moveValue > 0) moveValue = (moveValue - deadzone) / (1.0 - deadzone);
		else moveValue = (moveValue - deadzone) / (1.0 - deadzone) * -1;
		
		if(Math.abs(rotateValue) < deadzone) rotateValue = 0;
		else if (rotateValue > 0) rotateValue = (rotateValue - deadzone) / (1.0 - deadzone);
		else rotateValue = (rotateValue - deadzone) / (1.0 - deadzone) * -1;
		
		if (moveValue > 1)
			moveValue = 1;
		if (moveValue < -1)
			moveValue = -1;
		if (rotateValue > 1)
			rotateValue = 1;
		if (rotateValue < -1)
			rotateValue = -1;
		double max = Math.max(Math.abs(moveValue), Math.abs(rotateValue));
		double sum = moveValue + rotateValue;
		double dif = moveValue - rotateValue;
		if (moveValue >= 0) {
			if (rotateValue >= 0) {
				output[0] = max;
				output[1] = dif;
			} else {
				output[0] = sum;
				output[1] = max;
			}
		} else {
			if (rotateValue >= 0) {
				output[0] = sum;
				output[1] = -max;
			} else {
				output[0] = -max;
				output[1] = dif;
			}
		}
		return output;		
	}

}