package org.usfirst.frc.team5951.robot.commands.chassis;

import org.usfirst.frc.team5951.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraight extends Command {

	private double distanceSP;
	private Chassis chassis;

    public DriveStraight(double distanceSP) {
    	this.distanceSP = distanceSP;
    	this.chassis = Chassis.getInstance();
    	requires(this.chassis);	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.chassis.resetEncoders();
    	this.chassis.resetGyro();
    	this.chassis.setMultiplyer(1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	this.chassis.arcadeDrive(getDistanceError() * Chassis.DRIVE_KP, getRotationError() * Chassis.DRIVE_ROTATE_KP);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(this.getDistanceError()) < 0.05 && Math.abs(this.getRotationError()) < 2;
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

    private double getDistanceError() {
    	return this.chassis.getAverageDistance() - this.distanceSP;
    }

    private double getRotationError() {
    	return -this.chassis.getYaw();
    }
}
