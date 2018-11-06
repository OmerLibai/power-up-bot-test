package org.usfirst.frc.team5951.robot.commands.caliber.basic;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Caliber;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class PushCube extends InstantCommand {

	private Caliber caliber;
	
    public PushCube() {
    	this.caliber = Robot.CALIBER;
    }

    // Called once when the command executes
    protected void initialize() {
    	this.caliber.caliberPush();
    }

}
