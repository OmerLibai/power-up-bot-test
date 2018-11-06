package org.usfirst.frc.team5951.robot.commands.brakes;

import org.usfirst.frc.team5951.robot.subsystems.Brakes;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class ResetBrakeEncoder extends TimedCommand {

	private Brakes brakes;
	
    public ResetBrakeEncoder(double timeout) {
        super(timeout);
        
        this.brakes = Brakes.getInstance();
        requires(this.brakes);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.brakes.stopBrakeMotor();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	this.brakes.slowlyUnwind();
    }

    // Called once after timeout
    protected void end() {
    	this.brakes.resetEncoder();
    	this.brakes.stopBrakeMotor();
    	this.brakes.unlock();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.brakes.stopBrakeMotor();
    }
}
