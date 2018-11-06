/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5951.robot;

import org.usfirst.frc.team5951.robot.commands.auton.DriveToScale;
import org.usfirst.frc.team5951.robot.subsystems.Brakes;
import org.usfirst.frc.team5951.robot.subsystems.Caliber;
import org.usfirst.frc.team5951.robot.subsystems.Chassis;
import org.usfirst.frc.team5951.robot.subsystems.Intake;
import org.usfirst.frc.team5951.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {

	public static final Caliber CALIBER = new Caliber();
	public static final Intake INTAKE = new Intake();
	public static final Shooter SHOOTER = new Shooter();
	public static final Compressor COMP = new Compressor();
	public static final SendableChooser<String> CHOOSER_POSITION = new SendableChooser<String>();
	public static final SendableChooser<String> CHOOSER_TARGET = new SendableChooser<String>();
	
	private CommandGroup autoCommand;

	public static final OI OI = new OI();

	private String gameMessage;

	private int timesIterated;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		CameraServer.getInstance().startAutomaticCapture();
		COMP.start();

		// Position Chooser
		CHOOSER_POSITION.addDefault("M", "M");
		CHOOSER_POSITION.addObject("R", "R");
		CHOOSER_POSITION.addObject("L", "L");

		// Target Position
		CHOOSER_TARGET.addDefault("Switch", "Switch");
		CHOOSER_TARGET.addObject("Scale", "Scale");
		CHOOSER_TARGET.addObject("Line", "Line");

		SmartDashboard.putData("Position chooser: ", CHOOSER_POSITION);
		SmartDashboard.putData("Target choose: ", CHOOSER_TARGET);
		
		timesIterated = 0;
	}

	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
	 */
	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString code to get the
	 * auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons to
	 * the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
//		while (timesIterated < 15) {
//			timesIterated++;
//		}
//		this.autoCommand = new StraightForwardAuton();
//		this.gameMessage = DriverStation.getInstance().getGameSpecificMessage();
//		while (gameMessage.isEmpty()) {
//			gameMessage = DriverStation.getInstance().getGameSpecificMessage();
//		}
//		// // Switch
//		if (CHOOSER_TARGET.getSelected().equals("Line")) {
//			autoCommand = new CrossAutoLine();
//		} else {
//			if (gameMessage.charAt(0) == 'L') {
//
//				if (CHOOSER_POSITION.getSelected().equals("M")) {
//					autoCommand = new MiddleToLeftAuton();
//
//				} else if (CHOOSER_POSITION.getSelected().equals("L")) {
//					autoCommand = new LeftSwitchRightAngle();
//
//				} else {
//					autoCommand = new CrossAutoLine();
//
//				}
//
//			} else {
//				if (CHOOSER_POSITION.getSelected().equals("M")) {
//					autoCommand = new MiddleToRightAuton();
//				} else if (CHOOSER_POSITION.getSelected().equals("L")) {
//					autoCommand = new CrossAutoLine();
//				} else {
//					autoCommand = new RightSwitchRightAngle();
//				}
//			}
//			System.out.println("Auto command started: ");
//			autoCommand.start();
//			System.out.println(autoCommand);
//			System.out.println(autoCommand.isRunning());
//		}
//
//		if (autoCommand.isRunning()) {
//			System.out.println("Running");
//		}
//
//		System.out.println(timesIterated);
		
//		new StraightForwardAuton().start();
		new DriveToScale().start();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Gyro value: ", Chassis.getInstance().getYaw());
		SmartDashboard.putNumber("Left chassis encoder: ", Chassis.getInstance().getLeftDistance());
		SmartDashboard.putNumber("Right chassis encoder: ", Chassis.getInstance().getRightDistance());
		SmartDashboard.putNumber("Caliber position: ", CALIBER.getPosition());
		SmartDashboard.putNumber("Caliber left output: ", CALIBER.getLeftMotorOutput());
		SmartDashboard.putNumber("Caliber right output: ", CALIBER.getRightMotorOutput());
		SmartDashboard.putNumber("Caliber error: ", CALIBER.getError());
		SmartDashboard.putNumber("Caliber rate: ", CALIBER.getCaliberRate());
		SmartDashboard.putBoolean("LEFT IR: ", CALIBER.leftIR());
		SmartDashboard.putBoolean("Right IR: ", CALIBER.rightIR());
		SmartDashboard.putNumber("Shooter output: ", SHOOTER.getShooterOutput());

		SmartDashboard.putNumber("Brake encoder value: ", Brakes.getInstance().getBrakesPosition());
		SmartDashboard.putNumber("Brake output: ", Brakes.getInstance().getOutput());

		SmartDashboard.putNumber("Stopper encoder: ", CALIBER.getStopperPosition());
		SmartDashboard.putBoolean("Intake Open: ", INTAKE.isIntakeOpen());
		
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
