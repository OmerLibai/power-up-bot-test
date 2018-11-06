package org.usfirst.frc.team5951.robot.commands.auton;

import org.usfirst.frc.team5951.robot.commands.brakes.ResetBrakeEncoder;
import org.usfirst.frc.team5951.robot.commands.caliber.basic.PushCube;
import org.usfirst.frc.team5951.robot.commands.caliber.basic.SwitchPosition;
import org.usfirst.frc.team5951.robot.commands.caliber.groups.UpPositionGroup;
import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraightTimed;
import org.usfirst.frc.team5951.robot.commands.chassis.TurnToAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightSwitchRightAngle extends CommandGroup {

    public RightSwitchRightAngle() {
    	addSequential(new ResetBrakeEncoder(2.25));
    	addSequential(new UpPositionGroup());
        addSequential(new DriveStraight(3.28));
        addSequential(new TurnToAngle(-90));
        addSequential(new DriveStraightTimed(0.5));
        addSequential(new PushCube());
    }
}
