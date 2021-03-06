package org.usfirst.frc.team5951.robot.commands.chassis;

import org.usfirst.frc.team5951.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnToAngleSmallArch extends Command {

	private Chassis chassis;

	private double rotateAngle;

	private double i_accum = 0;;

	public TurnToAngleSmallArch(double rotateAngle) {
		this.chassis = Chassis.getInstance();
		requires(this.chassis);

		this.rotateAngle = rotateAngle;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		this.chassis.resetGyro();
		this.chassis.setMultiplyer(1);
		this.i_accum = 0;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (getAngleError() > 0) {
			this.chassis.setRightPower((-getAngleError() * Chassis.ROTATE_ONE_KP + i_accum * Chassis.ROTATE_KI) / 2.0);
			this.chassis.setLeftPower(-getAngleError() * Chassis.ROTATE_ONE_KP + i_accum * Chassis.ROTATE_KI);
		} else {
			this.chassis.setRightPower(-getAngleError() * Chassis.ROTATE_ONE_KP + i_accum * Chassis.ROTATE_KI);
			this.chassis.setLeftPower((-getAngleError() * Chassis.ROTATE_ONE_KP + i_accum * Chassis.ROTATE_KI) / 2.0);
		}
		i_accum -= getAngleError();
		if (Math.abs(getAngleError()) < 2) {
			i_accum = 0;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Math.abs(this.getAngleError()) < 2 && Math.abs(this.chassis.getYawRate()) < 2;
	}

	// Called once after isFinished returns true
	protected void end() {
		this.chassis.stopChassis();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}

	private double getAngleError() {
		return this.rotateAngle - this.chassis.getYaw();
	}
}
