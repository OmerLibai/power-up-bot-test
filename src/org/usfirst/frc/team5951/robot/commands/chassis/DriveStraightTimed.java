package org.usfirst.frc.team5951.robot.commands.chassis;

import org.usfirst.frc.team5951.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class DriveStraightTimed extends TimedCommand {

	private Chassis chassis;
	
    public DriveStraightTimed(double timeout) {
        super(timeout);
    	this.chassis = Chassis.getInstance();
    	requires(this.chassis);	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	chassis.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	this.chassis.arcadeDrive(-0.5, getRotationError() * Chassis.ROTATE_KP);
    }

    // Called once after isFinished returns true
    protected void end() {
    	this.chassis.stopChassis();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
    
    private double getRotationError() {
    	return -this.chassis.getYaw();
    }
}
