package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Yair Ziv
 */
public class Brakes extends Subsystem {

	// Components
	private WPI_TalonSRX brakeMotor;
	private Encoder brakeEncoder;

	// PID controller
	private PIDController pidController;

	// Brakes instance
	private static Brakes m_instance;
	
	private boolean isLocked;
	
	// PID values
	public static final double KP = 0.03;
	public static final double KI = 0;
	public static final double KD = 0;
	
	public static final double LOCKED_POSITION = 0;
	public static final double SOFT_BRAKE_POSITION = -75;
	public static final double UNLOCKED_POSITION = -245;

	private Brakes() {
		this.brakeMotor = new WPI_TalonSRX(RobotMap.BRAKE_MOTOR);
		this.brakeMotor.setInverted(true);
		this.brakeMotor.configPeakOutputForward(1, 0);
		this.brakeMotor.configPeakOutputReverse(-1, 0);

		this.brakeEncoder = new Encoder(RobotMap.CALIBER_BRAKE_ENCODER_A, RobotMap.CALIBER_BRAKE_ENCODER_B);
		this.brakeEncoder.setReverseDirection(true);

		this.pidController = new PIDController(KP, KI, KD, brakeEncoder, brakeMotor);
		this.pidController.setAbsoluteTolerance(30);
		this.pidController.setOutputRange(-1, 1);
		
		this.isLocked = false;
	}

	/**
	 * @return an instance of {@link Brakes}
	 */
	public static Brakes getInstance() {
		if (m_instance == null) {
			m_instance = new Brakes();
		}
		return m_instance;
	}
	
	/**
	 * PID Locks the brakes 
	 */
	public void lock() {
		this.pidController.setSetpoint(LOCKED_POSITION);
		this.isLocked = true;
		this.pidController.enable();
	}
	
	/**
	 * PID Locks the brakes 
	 */
	public void softLock() {
		this.pidController.setSetpoint(SOFT_BRAKE_POSITION);
		this.isLocked = true;
		this.pidController.enable();
	}
	
	/**
	 * Unlocks the brakes
	 */
	public void unlock() {
		this.pidController.setSetpoint(UNLOCKED_POSITION);
		this.isLocked = false;
		this.pidController.enable();
	}
	
	/**
	 * @return - Whether the brakes are locked or not
	 */
	public boolean isLocked() {
		return this.isLocked;
	}
	
	/**
	 * @return - Brake motor position
	 */
	public double getBrakesPosition() {
		return this.brakeEncoder.getDistance();
	}
	
	/**
	 * @return PWM Output of the motor
	 */
	public double getOutput() {
		return this.brakeMotor.getOutputCurrent();
	}
	
	public boolean isInPlace() {
		return this.pidController.onTarget();
	}
	
	/**
	 * Resets the encoder
	 */
	public void resetEncoder() {
		this.pidController.disable();
		this.brakeEncoder.reset();
	}
	
	/**
	 * Slowly unwinds the brake
	 */
	public void slowlyUnwind() {
		this.pidController.disable();
		this.brakeMotor.set(1);
	}
	
	public void stopBrakeMotor() {
		this.pidController.disable();
		this.brakeMotor.set(0);
	}
	
	public void setPower(double power) {
		this.pidController.disable();
		this.brakeMotor.set(power);
	}
	
	public double getSetpoint() {
		return this.pidController.getSetpoint();
	}
	
	public double getError() {
		return this.pidController.getError();
	}
	
	public void initDefaultCommand() {
	}
}
