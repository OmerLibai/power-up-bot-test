package org.usfirst.frc.team5951.robot.commands.chassis;

import org.usfirst.frc.team5951.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ResetGyro extends InstantCommand {

    public ResetGyro() {
        
    }

    // Called once when the command executes
    protected void initialize() {
    	Chassis.getInstance().resetGyro();
    }

}
