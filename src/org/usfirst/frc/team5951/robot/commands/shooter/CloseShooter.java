package org.usfirst.frc.team5951.robot.commands.shooter;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class CloseShooter extends InstantCommand {

	private Shooter shooter;
	
    public CloseShooter() {
    	this.shooter = Robot.SHOOTER;
    }

    // Called once when the command executes
    protected void initialize() {
    	this.shooter.closeShooter();
    }

}
