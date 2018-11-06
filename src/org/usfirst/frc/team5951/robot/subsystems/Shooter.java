
package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

	private WPI_TalonSRX shooterMotorLeft;
	private WPI_TalonSRX shooterMotorRight;

	private DoubleSolenoid shooterFolders;

	public Shooter() {
		// TODO set one motor high and low as reverse
		this.shooterMotorLeft = new WPI_TalonSRX(RobotMap.SHOOTER_RIGHT_MOTOR);
		this.shooterMotorRight = new WPI_TalonSRX(RobotMap.SHOOTER_LEFT_MOTOR);

		this.shooterMotorRight.follow(shooterMotorLeft);
		this.shooterMotorRight.setInverted(true);

		this.shooterFolders = new DoubleSolenoid(RobotMap.PCM_PRIMARY_PORT, RobotMap.SHOOTER_PISTONS_FORWARD,
				RobotMap.SHOOTER_PISTONS_REVERSE);
	}

	/**
	 * this function stop all the motors of the subsystem
	 */
	public void stop() {
		shooterMotorLeft.set(ControlMode.PercentOutput, 0);
	}

	/**
	 * Rolls the shooter up to shooting speed for the scale
	 */
	public void rollUpScale() {
		shooterMotorLeft.set(ControlMode.PercentOutput, 1);
	}
	
	/**
	 * Rolls the shooter up to shooting speed for the switch
	 */
	public void rollUpSwitch() {
		shooterMotorLeft.set(ControlMode.PercentOutput, 0.4);
	}
	
	/**
	 * Opens the shooter to shooting position
	 */
	public void openShooter() {
		this.shooterFolders.set(Value.kForward);
	}
	
	/**
	 * Closes the shooter
	 */
	public void closeShooter() {
		this.shooterFolders.set(Value.kReverse);
	}
	
	public double getShooterOutput() {
		return this.shooterMotorRight.getMotorOutputPercent();
	}

	/**
	 * Toggles the position of the shooter folders
	 */
	public void toggleShooterPistons() {
		if(this.shooterFolders.get() == Value.kForward) {
			this.shooterFolders.set(Value.kReverse);
		} else {
			this.shooterFolders.set(Value.kForward);
		}
	}
	
	protected void initDefaultCommand() {
		// setDefaultCommand(new StopShot());

	}

}
