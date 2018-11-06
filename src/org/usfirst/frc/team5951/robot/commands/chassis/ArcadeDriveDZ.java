package org.usfirst.frc.team5951.robot.commands.chassis;

import org.usfirst.frc.team5951.robot.OI;
import org.usfirst.frc.team5951.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.command.Command;

/**
 * TODO Test
 */
@Deprecated
public class ArcadeDriveDZ extends Command {

	private Chassis chassis;
	
    public ArcadeDriveDZ() {
        this.chassis = Chassis.getInstance();
        requires(this.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	this.chassis.arcadeDriveDZ(OI.OPERATOR_STICK.getY(), OI.OPERATOR_STICK.getX());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
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
}
