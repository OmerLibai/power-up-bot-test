package org.usfirst.frc.team5951.robot.commands.brakes;

import org.usfirst.frc.team5951.robot.subsystems.Brakes;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SoftLockBrakes extends Command {

	public SoftLockBrakes() {
		requires(Brakes.getInstance());
	}

	// Called once when the command executes
	protected void initialize() {
		Brakes.getInstance().softLock();
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
		System.out.println("Finished");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
