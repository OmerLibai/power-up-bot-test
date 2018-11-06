package org.usfirst.frc.team5951.robot.commands.caliber.basic;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Caliber;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SwitchPosition extends Command {

	private Caliber caliber;
	private boolean isStartedMoving;
	
    public SwitchPosition() {
    	this.caliber = Robot.CALIBER;
    	requires(this.caliber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println(this.toString() + "Started");
    	this.caliber.switchPosition();
    	isStartedMoving = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Math.abs(this.caliber.getCaliberRate()) > Caliber.MOVING_SPEED) {
    		this.isStartedMoving = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return this.caliber.isInPlace() && this.isStartedMoving;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("Switch End");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("Switch Interrupted");
    }
}
