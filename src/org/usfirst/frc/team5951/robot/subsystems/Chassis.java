package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;
import org.usfirst.frc.team5951.robot.commands.chassis.ArcadeDrive;
import org.usfirst.frc.team5951.robot.util.ChassisMath;
import org.usfirst.frc.team5951.robot.util.ChassisSide;
import org.usfirst.frc.team5951.robot.util.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * TODO Find roborio orientation
 * 
 */
public class Chassis extends Subsystem {

	// Component declarations
	private WPI_TalonSRX leadRightMotor, rightFollower1, leadLeftMotor, leftFollower1;

	private ChassisSide leftChassisSide, rightChassisSide;

	private Encoder leftEncoder, rightEncoder;

	private AHRS navX;

	// Global variables
	private int multiplier = 1;

	public static final double DEAD_ZONE = 0.05;

	// PID Values
	// Turn PID
	public static final double ROTATE_KP = 0.1;
	
	public static final double ROTATE_ONE_KP = 0.6;

	public static final double ROTATE_KI = 0.00013;

	public static final double DRIVE_ROTATE_KP = 0.12;

	// Drive PID
	public static final double DRIVE_KP = 0.85;

	// Chassis object for reference
	private static Chassis m_chassis;

	public Chassis() {
		// Lead motors init
		this.leadRightMotor = new WPI_TalonSRX(RobotMap.CHASSIS_RIGHT_LEADER);
		this.leadLeftMotor = new WPI_TalonSRX(RobotMap.CHASSIS_LEFT_LEADER);

		// Followers init
		this.leftFollower1 = new WPI_TalonSRX(RobotMap.CHASSIS_LEFT_FOLLOWER_1);
		this.rightFollower1 = new WPI_TalonSRX(RobotMap.CHASSIS_RIGHT_FOLLOWER_1);

		this.leadRightMotor.setInverted(false);
		this.rightFollower1.setInverted(false);
		this.leadLeftMotor.setInverted(false);
		this.leftFollower1.setInverted(true); 

		this.leftEncoder = new Encoder(RobotMap.LEFT_CHASSIS_ENCODER_A, RobotMap.LEFT_CHASSIS_ENCODER_B);

		this.rightEncoder = new Encoder(RobotMap.RIGHT_CHASSIS_ENCODER_A, RobotMap.RIGHT_CHASSIS_ENCODER_B);

		this.leftEncoder.setReverseDirection(false);
		this.rightEncoder.setReverseDirection(false);

		this.leftEncoder.setDistancePerPulse(1.0 / Constants.LEFT_CHASSIS_ENCODER_PPM);
		this.rightEncoder.setDistancePerPulse(1.0 / Constants.RIGHT_CHASSIS_ENCODER_PPM);

		// Case 3 motor drivetrain
		this.leftChassisSide = new ChassisSide(leadLeftMotor, leftFollower1);

		this.rightChassisSide = new ChassisSide(leadRightMotor, rightFollower1);

		this.navX = new AHRS(Port.kMXP);
	}

//	/**
//	 * Returns the same instance of chassis every time for no chance of 2 chassis at
//	 * the same time
//	 */
	public static Chassis getInstance() {
		if (m_chassis == null) {
			m_chassis = new Chassis();
		}

		return m_chassis;
	}
	
	public double getUpdateRate() {
		return this.navX.getActualUpdateRate();
	}

	/**
	 * Arcade drive method Multiplier is either 1 or -1, used when wanted to control
	 * robot reverse.
	 * 
	 * @param moveValue
	 *            - Y axis of joystick
	 * @param rotateValue
	 *            - X axis of joystick
	 */
	public void arcadeDrive(double moveValue, double rotateValue) {
		double[] output = ChassisMath.calculatePower(moveValue, rotateValue);

		this.leftChassisSide.set(ControlMode.PercentOutput, output[1] * this.multiplier);
		this.rightChassisSide.set(ControlMode.PercentOutput, output[0] * this.multiplier);
	}

	/**
	 * Arcade drive with dead-zone UNTESTED Multiplier is either 1 or -1 used when
	 * wanted to control the robot in reverse
	 * 
	 * @param moveValue
	 *            - Y axis of joystick
	 * @param rotateValue
	 *            - X axis of joystick
	 */
	@Deprecated
	public void arcadeDriveDZ(double moveValue, double rotateValue) {
		double[] output = ChassisMath.calculatePowerDZ(moveValue, rotateValue, DEAD_ZONE);

		this.leftChassisSide.set(ControlMode.PercentOutput, output[0] * this.multiplier);
		this.rightChassisSide.set(ControlMode.PercentOutput, output[1] * this.multiplier);
	}

	public void tankDrive(double powerLeft, double powerRight) {
		this.leftChassisSide.set(ControlMode.PercentOutput, powerLeft);
		this.rightChassisSide.set(ControlMode.PercentOutput, powerRight);
	}
	
	public void setLeftPower(double power) {
		this.leftChassisSide.set(ControlMode.PercentOutput, power);
	}
	
	public void setRightPower(double power) {
		this.rightChassisSide.set(ControlMode.PercentOutput, power);
	}
	
	/**
	 * Stops the chassis, sets the outputs to (0,0)
	 */
	public void stopChassis() {
		this.leftChassisSide.set(ControlMode.PercentOutput, 0);
		this.rightChassisSide.set(ControlMode.PercentOutput, 0);
	}

	/**
	 * Resets the yaw gyro position
	 */
	public void resetGyro() {
		//this.navX.reset();
		this.navX.zeroYaw();
	}

	public void resetEncoders() {
		this.leftEncoder.reset();
		this.rightEncoder.reset();
	}

	/**
	 * Return yaw value rotation (x, z axis)
	 * 
	 * @return
	 */
	public double getYaw() {
		return this.navX.getYaw();
	}

	/**
	 * Returns the change rate of the robot's angle
	 * 
	 * @return
	 */
	public double getYawRate() {
		return this.navX.getRate();
	}

	/**
	 * Left chassis distance
	 */
	public double getLeftDistance() {
		return this.leftEncoder.getDistance();
	}

	/**
	 * Right chassis distance
	 */
	public double getRightDistance() {
		return this.rightEncoder.getDistance();
	}

	/**
	 * @return Raw right encoder value (unscaled).
	 */
	public double getRightEncoderRaw() {
		return this.rightEncoder.getRaw();
	}

	/**
	 * @return Raw left encoder value (unscaled).
	 */
	public double getLeftEncoderRaw() {
		return this.leftEncoder.getRaw();
	}

	/**
	 * Average distance of the encoders
	 * 
	 * @return
	 */
	public double getAverageDistance() {
		return (this.getRightDistance() + this.getLeftDistance()) / 2.0;
	}

	/**
	 * Sets the multiplier
	 */
	public void setMultiplyer(int multiplyer) {
		this.multiplier = multiplyer;
	}

	/**
	 * Inverts the chassis, forward is reverse, left is right
	 */
	public void invertChassis() {
		this.multiplier *= -1;
	}

	public double getAmper() {
		return leadLeftMotor.getOutputCurrent();
		
	}
	
	/**
	 * When no command is running on the chassis, use the {@link ArcadeDrive}
	 * command
	 */
	public void initDefaultCommand() {
		this.setDefaultCommand(new ArcadeDrive());
	}
}
