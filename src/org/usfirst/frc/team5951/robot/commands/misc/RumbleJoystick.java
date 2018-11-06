package org.usfirst.frc.team5951.robot.commands.misc;

import org.usfirst.frc.team5951.robot.OI;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class RumbleJoystick extends TimedCommand {

	private double rumble;
	
    public RumbleJoystick(double timeout, double rumble) {
        super(timeout);
        this.rumble = rumble;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	OI.OPERATOR_STICK.setRumble(RumbleType.kLeftRumble, rumble);
    	OI.OPERATOR_STICK.setRumble(RumbleType.kRightRumble, rumble);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Called once after timeout
    protected void end() {
    	OI.OPERATOR_STICK.setRumble(RumbleType.kLeftRumble, 0);
    	OI.OPERATOR_STICK.setRumble(RumbleType.kRightRumble, 0);    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	OI.OPERATOR_STICK.setRumble(RumbleType.kLeftRumble, 0);
    	OI.OPERATOR_STICK.setRumble(RumbleType.kRightRumble, 0);
    }
}
