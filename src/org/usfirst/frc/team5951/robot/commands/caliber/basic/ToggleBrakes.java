package org.usfirst.frc.team5951.robot.commands.caliber.basic;

import org.usfirst.frc.team5951.robot.subsystems.Brakes;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleBrakes extends Command {

    public ToggleBrakes() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Brakes.getInstance().lock();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Brakes.getInstance().unlock();
    }
}
