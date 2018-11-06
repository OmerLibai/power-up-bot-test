package org.usfirst.frc.team5951.robot.commands.chassis;

import org.usfirst.frc.team5951.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class MultiplyChassis extends InstantCommand {

	private Chassis chassis;
	private int multiplyValue;
	
    public MultiplyChassis(int multiplyValue) {
    	this.chassis = Chassis.getInstance();
    	this.multiplyValue = multiplyValue;
    }

    // Called once when the command executes
    protected void initialize() {
    	this.chassis.setMultiplyer(multiplyValue);
    }

}
