package org.usfirst.frc.team5951.robot.triggers;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class POVRight extends Trigger {
	
	private GenericHID stick;
	
	public POVRight(GenericHID stick) {
		this.stick = stick;
	}

    public boolean get() {
        return this.stick.getPOV() == 90;
    }
}
