package org.usfirst.frc.team5951.robot.triggers;

import org.usfirst.frc.team5951.robot.OI;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class RightTriggerPressed extends Trigger {

    public boolean get() {
        return OI.OPERATOR_STICK.getTriggerAxis(Hand.kRight) > 0.5;
    }
}
