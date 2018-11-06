package org.usfirst.frc.team5951.robot.commands.brakes;

import org.usfirst.frc.team5951.robot.commands.caliber.basic.StopCaliberMotor;
import org.usfirst.frc.team5951.robot.subsystems.Brakes;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LockBrakes extends Command {

	public LockBrakes() {
		requires(Brakes.getInstance());
	}

	// Called once when the command executes
	protected void initialize() {
		Brakes.getInstance().lock();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Brakes.getInstance().isInPlace();
	}

	// Called once after isFinished returns true
	protected void end() {
		new StopCaliberMotor().start();
		System.err.print("Finished");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
