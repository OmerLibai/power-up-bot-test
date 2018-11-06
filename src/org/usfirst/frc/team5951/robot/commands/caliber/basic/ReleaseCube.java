package org.usfirst.frc.team5951.robot.commands.caliber.basic;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Caliber;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ReleaseCube extends InstantCommand {

	private Caliber caliber;
	
    public ReleaseCube() {
        caliber = Robot.CALIBER;
    }

    // Called once when the command executes
    protected void initialize() {
    	caliber.releaseCube();
    }

}
