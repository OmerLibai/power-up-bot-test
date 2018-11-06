package org.usfirst.frc.team5951.robot.commands.shooter;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RollUpScale extends Command {

	private Shooter shooter;
	
    public RollUpScale() {
    	this.shooter = Robot.SHOOTER;
    	requires(this.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	new OpenShooter().start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	this.shooter.rollUpScale();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	this.shooter.stop();
    	new CloseShooter().start();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
