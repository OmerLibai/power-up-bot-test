package org.usfirst.frc.team5951.robot.triggers;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class POVDown extends Trigger {
	
	private GenericHID stick;
	
	public POVDown(GenericHID stick) {
		this.stick = stick;
	}

    public boolean get() {
        return this.stick.getPOV() == 180;
    }
}
