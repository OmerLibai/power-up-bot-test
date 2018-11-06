package org.usfirst.frc.team5951.robot.triggers;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class POVUp extends Trigger {
	
	private GenericHID stick;
	
	public POVUp(GenericHID stick) {
		this.stick = stick;
	}

    public boolean get() {
        return this.stick.getPOV() == 0;
    }
}
