package org.usfirst.frc.team5951.robot.commands.leds;

import org.usfirst.frc.team5951.robot.subsystems.LEDs;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class LEDsOff extends InstantCommand {

	private LEDs leds;
	
    public LEDsOff() {
    	this.leds = LEDs.getInstance();
    	requires(this.leds);
    }

    // Called once when the command executes
    protected void initialize() {
    	this.leds.ledsOff();
    }

}
