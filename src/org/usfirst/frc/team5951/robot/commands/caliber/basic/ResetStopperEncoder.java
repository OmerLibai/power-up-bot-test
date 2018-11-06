package org.usfirst.frc.team5951.robot.commands.caliber.basic;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Caliber;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class ResetStopperEncoder extends TimedCommand {

	private Caliber caliber;
	
    public ResetStopperEncoder(double timeout) {
        super(timeout);
        
        caliber = Robot.CALIBER;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	caliber.slowlyReleaseCube();
    }

    
    // Called once after timeout
    protected void end() {
    	caliber.resetStopperEncoder();
    	caliber.releaseCube();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
