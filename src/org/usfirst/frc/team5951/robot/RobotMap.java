/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5951.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * 
 * @author FRC 5951 programming
 * 
 */
public class RobotMap {

	// OI
	public static final int DRIVER_STICK = 0;
	public static final int OPERATOR_STICK = 1;

	// Caliber
	public static final int LIFT_MOTOR_MAIN_PORT = 7;
	public static final int LIFT_MOTOR_SECONDARY_PORT = 10;

	// Chassis
	public static final int CHASSIS_RIGHT_LEADER = 2;
	public static final int CHASSIS_RIGHT_FOLLOWER_1 = 3;
	public static final int CHASSIS_LEFT_LEADER = 5;
	public static final int CHASSIS_LEFT_FOLLOWER_1 = 6;

	public static final int SHOOTER_RIGHT_MOTOR = 9;
	public static final int SHOOTER_LEFT_MOTOR = 4;

	public static final int INTAKE_LEFT_MOTOR = 8;
	public static final int INTAKE_RIGHT_MOTOR = 0;
	
	public static final int BRAKE_MOTOR = 1;
	
	public static final int CUBE_STOPPER_MOTOR = 1;

	public static final int PCM_PRIMARY_PORT = 1;
	public static final int PCM_SECONDARY_PORT = 0;
	
	public static final int PUSH_PORT_FORWARD = 4;
	public static final int PUSH_PORT_REVERSE = 5;//6

	public static final int INTAKE_PISTON_LEFT_FORWORD =7;//5
	public static final int INTAKE_PISTON_LEFT_REVERSE = 6;//1
	public static final int INTAKE_PISTON_RIGHT_FORWORD = 1;//0
	public static final int INTAKE_PISTON_RIGHT_REVERSE = 0;//7
	
	public static final int SHOOTER_PISTONS_FORWARD = 3;//reversed
	public static final int SHOOTER_PISTONS_REVERSE = 2;

	public static final int LEFT_IR = 4;
	public static final int RIGHT_IR = 5;
	
	public static final int LEFT_CHASSIS_ENCODER_A = 0;
	public static final int LEFT_CHASSIS_ENCODER_B = 1;
	public static final int RIGHT_CHASSIS_ENCODER_A = 2;
	public static final int RIGHT_CHASSIS_ENCODER_B = 3;
	
	public static final int CALIBER_BRAKE_ENCODER_A = 6;
	public static final int CALIBER_BRAKE_ENCODER_B = 7;
	
	public static final int CUBE_STOPPER_ENCODER_A = 8;
	public static final int CUBE_STOPPER_ENCODER_B= 9;

	// LEDs
	public static final int LED_RELAY = 0;
}
