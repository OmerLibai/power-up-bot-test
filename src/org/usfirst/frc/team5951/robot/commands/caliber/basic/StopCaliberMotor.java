package org.usfirst.frc.team5951.robot.commands.caliber.basic;

import org.usfirst.frc.team5951.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class StopCaliberMotor extends InstantCommand {

    public StopCaliberMotor() {
    	requires(Robot.CALIBER);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.CALIBER.stopCaliber();
    }

}
