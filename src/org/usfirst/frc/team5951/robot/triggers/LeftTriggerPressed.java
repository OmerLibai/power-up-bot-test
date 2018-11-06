package org.usfirst.frc.team5951.robot.triggers;

import org.usfirst.frc.team5951.robot.OI;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class LeftTriggerPressed extends Trigger {

    public boolean get() {
        return OI.OPERATOR_STICK.getTriggerAxis(Hand.kLeft) > 0.5;
    }
}
