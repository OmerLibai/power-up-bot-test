package org.usfirst.frc.team5951.robot.util;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * General chassis side class with unknown number of motors
 * 
 * @author Yair Ziv
 */
public class ChassisSide {
	
	//Motor array
	private TalonSRX[] motors;
	
	/**
	 * {@link ChassisSide} constructor with unknown amount of motor controllers
	 * Sets all motors but the first to follow the first one (the "leader") 
	 * 
	 * @param motors - All motors on the chassis side
	 */
	public ChassisSide(TalonSRX... motors) {
		this.motors = motors;
		for (int i = 1; i < motors.length; i++) {
//			this.motors[i].set(ControlMode.Follower, this.motors[0].getDeviceID());
			this.motors[i].follow(this.motors[0]);
		}
	}
	
	/**
	 * Sets all the motors to the wanted output and control mode
	 * @param mode - {@link ControlMode} value
	 * @param output - Wanted value
	 */
	public void set(ControlMode mode, double output) {
		this.motors[0].set(mode,  output);
	}
	
}
