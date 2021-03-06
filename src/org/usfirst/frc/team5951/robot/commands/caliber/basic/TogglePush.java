package org.usfirst.frc.team5951.robot.commands.caliber.basic;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Caliber;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class TogglePush extends InstantCommand {

	private Caliber caliber;
	
    public TogglePush() {
    	this.caliber = Robot.CALIBER;
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.CALIBER.releaseCube();
    	this.caliber.togglePush();
    }

}
