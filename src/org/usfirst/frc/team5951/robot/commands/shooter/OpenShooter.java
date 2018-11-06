package org.usfirst.frc.team5951.robot.commands.shooter;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class OpenShooter extends InstantCommand {

	private Shooter shooter;
	
    public OpenShooter() {
    	this.shooter = Robot.SHOOTER;
    }

    // Called once when the command executes
    protected void initialize() {
    	this.shooter.openShooter();
    }

}
