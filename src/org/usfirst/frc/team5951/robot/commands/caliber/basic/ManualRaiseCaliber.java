package org.usfirst.frc.team5951.robot.commands.caliber.basic;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.commands.brakes.LockBrakes;
import org.usfirst.frc.team5951.robot.commands.brakes.ReleaseBrakes;
import org.usfirst.frc.team5951.robot.subsystems.Caliber;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualRaiseCaliber extends Command {

	Caliber caliber;
	double caliberPosition;

	public ManualRaiseCaliber()
	{
		caliber = Robot.CALIBER;
		requires(caliber);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		new ReleaseBrakes().start();
		caliberPosition = caliber.getPosition();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		caliber.setPosition(caliberPosition);
		caliberPosition -= 10;
		System.out.println(caliberPosition);
		System.out.println(caliber.getPosition());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		new LockBrakes().start();;
	}
}
