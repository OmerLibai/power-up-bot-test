package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;
import org.usfirst.frc.team5951.robot.commands.caliber.groups.ReleaseAndShoot;

/**
 * Caliber subsystem-
 * 1 TalonSRX- liftMotor
 * 2 DoubleSolenoids- squish,push
 * 3 static final integers for 0 power, negative power and positive power- NO_SPEEED, MIN_SPEED, MAX_SPEED
 * 
 * methods-
 * liftRaise
 * liftLower
 * liftLock
 * caliberPushOpen
 * caliberPushClose
 * caliberCatch
 * caliberRelease * 
 **/

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Caliber extends Subsystem {

	// Create TalonSRK
	private WPI_TalonSRX mainLiftMotor;
	private WPI_TalonSRX secondaryLiftMotor;

	// Create 2 DoubleSolenoids
	private DoubleSolenoid push;

	// Create 2 digital inputs for IR sensors
	private DigitalInput leftIR;
	private DigitalInput rightIR;

	private Spark cubeStopperMotor;

	private Encoder cubeStopperEncoder;

	private PIDController cubeStopperController;

	// Sets speed val.5es
	public static final double FORWARD_SPEED = 0.8;
	public static final double BACKWARD_SPEED = -0.1;
	public static final double NO_SPEED = 0;

	// Sets position values
	public static final int GROUND_POSITION = 2902;
	public static final int MIDDLE_POSITION = 2451;
	public static final int SWITCH_POSITION = 2050;

	// Set PID values
	public static final double KP_SWITCH = 1;
	public static final double KP_SCALE = 1.7;
	public static final double KP_BACKWARD = 0.5;
	public static final double KI = 0;
	public static final double KD_FLOOR = 100;
	public static final double KD_SWITCH = 4.0;
	public static final double KD_SCALE = 2.5;
	public static final double KD_BACKWARD = 3;

	// Cube stopper PID Values
	public static final double KP_STOPPER = 0.1;
	public static final double KD_STOPPER = 0.02;

	public static final double STOPPED_POSITION = 96.5;
	public static final double RELEASED_POSITION = 10;

	public static final int ALLOWABLE_ERROR = 100;
	public static final int ALLOWABLE_ERROR_SCALE = 20;
	public static final int MOVING_SPEED = 12;

	private double currentSetpoint;

	// Sets the TalonSRX, the IR sensors and the 2DoubleSolenoids and puts their
	// ports
	public Caliber() {
		mainLiftMotor = new WPI_TalonSRX(RobotMap.LIFT_MOTOR_MAIN_PORT);
		secondaryLiftMotor = new WPI_TalonSRX(RobotMap.LIFT_MOTOR_SECONDARY_PORT);

		mainLiftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
		mainLiftMotor.config_kP(0, KP_SWITCH, 0);
		mainLiftMotor.config_kI(0, 0, 0);
		mainLiftMotor.config_kD(0, KD_SWITCH, 0);
		mainLiftMotor.configPeakOutputForward(1, 0);
		mainLiftMotor.configPeakOutputReverse(-1, 0);
		mainLiftMotor.configAllowableClosedloopError(0, ALLOWABLE_ERROR, 0);

		mainLiftMotor.setNeutralMode(NeutralMode.Brake);
		secondaryLiftMotor.setNeutralMode(NeutralMode.Brake);

		mainLiftMotor.setInverted(true); //reversed
		secondaryLiftMotor.setInverted(true);

		secondaryLiftMotor.follow(mainLiftMotor);

		cubeStopperMotor = new Spark(RobotMap.CUBE_STOPPER_MOTOR);
		cubeStopperMotor.setInverted(true);

		push = new DoubleSolenoid(RobotMap.PCM_PRIMARY_PORT, RobotMap.PUSH_PORT_FORWARD, RobotMap.PUSH_PORT_REVERSE);

		leftIR = new DigitalInput(RobotMap.LEFT_IR);
		rightIR = new DigitalInput(RobotMap.RIGHT_IR);

		cubeStopperEncoder = new Encoder(RobotMap.CUBE_STOPPER_ENCODER_A, RobotMap.CUBE_STOPPER_ENCODER_B);
		cubeStopperEncoder.setReverseDirection(true);

		cubeStopperController = new PIDController(KP_STOPPER, 0, KD_STOPPER, cubeStopperEncoder, cubeStopperMotor);

		cubeStopperController.setOutputRange(-0.3, 0.75);

		currentSetpoint = GROUND_POSITION;
	}

	// Opens the push cylinder
	public void caliberPush() {
		push.set(Value.kForward);
	}

	// Closes the push cylinder
	public void caliberRetract() {
		push.set(Value.kReverse);
	}

	public boolean isInPlace() {
		System.out.println(Math.abs(currentSetpoint - getPosition()) + ", "
				+ Math.abs(mainLiftMotor.getSelectedSensorVelocity(0)));
		return Math.abs(currentSetpoint - getPosition()) < ALLOWABLE_ERROR
				&& Math.abs(mainLiftMotor.getSelectedSensorVelocity(0)) < MOVING_SPEED;
	}
	public boolean isInPlaceScale() {
		System.out.println(Math.abs(currentSetpoint - getPosition()) + ", "
				+ Math.abs(mainLiftMotor.getSelectedSensorVelocity(0)));
		return Math.abs(currentSetpoint - getPosition()) < ALLOWABLE_ERROR_SCALE
				&& Math.abs(mainLiftMotor.getSelectedSensorVelocity(0)) < MOVING_SPEED;
	}

	public double getError() {
		return mainLiftMotor.getClosedLoopError(0);
	}

	public double getCaliberRate() {
		return this.mainLiftMotor.getSelectedSensorVelocity(0);
	}

	public double getLeftMotorOutput() {
		return this.mainLiftMotor.getMotorOutputPercent();
	}

	public double getRightMotorOutput() {
		return this.secondaryLiftMotor.getMotorOutputPercent();
	}

	/**
	 * Gets the caliber to the ground intake position
	 */
	public void groundPosition() {
		this.currentSetpoint = GROUND_POSITION;
		mainLiftMotor.set(ControlMode.PercentOutput, 0.1);
	}

	/**
	 * Gets the caliber to the switch shoot position
	 */
	public void switchPosition() {
		this.currentSetpoint = SWITCH_POSITION;
		mainLiftMotor.config_kP(0, KP_SWITCH, 0);
		mainLiftMotor.config_kI(0, KI, 0);
		mainLiftMotor.config_kD(0, KD_SWITCH, 0);
		mainLiftMotor.set(ControlMode.Position, SWITCH_POSITION);
	}

	/**
	 * Manually sets the position of the caliber
	 * 
	 * @param position
	 *            - position to be set
	 */
	public void setPosition(double position) {
		mainLiftMotor.config_kP(0, KP_SWITCH, 0);
		mainLiftMotor.config_kD(0, 0, 0);
		mainLiftMotor.set(ControlMode.Position, position);
	}

	/**
	 * Locks the cube in place
	 */
	public void stopCube() {
		cubeStopperController.enable();
		cubeStopperController.setSetpoint(STOPPED_POSITION);
	}

	/**
	 * Releases the cube
	 */
	public void releaseCube() {
		cubeStopperController.enable();
		cubeStopperController.setSetpoint(RELEASED_POSITION);
	}

	/**
	 * Sets the stopper back slowly, used to reset the encoder
	 */
	public void slowlyReleaseCube() {
		cubeStopperController.disable();
		cubeStopperMotor.set(-0.3);
	}

	/**
	 * Resets the stopper encoder
	 */
	public void resetStopperEncoder() {
		cubeStopperEncoder.reset();
	}

	/**
	 * Stops the caliber, gives 0 power to the motors
	 */
	public void stopCaliber() {
		mainLiftMotor.set(ControlMode.PercentOutput, 0);
		mainLiftMotor.setNeutralMode(NeutralMode.Brake);
	}

	public double getStopperPosition() {
		return this.cubeStopperEncoder.getDistance();
	}

	/**
	 * Toggles the pushing piston's mode
	 */
	public void togglePush() {
		if (push.get() == Value.kForward) {
			caliberRetract();
		} else {
			new ReleaseAndShoot().start();
		}
	}

	/**
	 * Returns absolute position of the lift encoder
	 * 
	 * @return - Lift's absolute position
	 */
	public double getPosition() {
		return mainLiftMotor.getSensorCollection().getPulseWidthPosition();
	}

	// Returns the left IR value
	public boolean leftIR() {
		return !leftIR.get();
	}

	// Returns true if the left IR value or the right IR value is true
	// Returns the opposite because the sensor outputs true if there is no object.
	public boolean isCubeIn() {
		return !leftIR.get() || !rightIR.get();
	}

	// Returns the right IR value
	public boolean rightIR() {
		return !rightIR.get();
	}

	@Override
	protected void initDefaultCommand() {
	}

}
