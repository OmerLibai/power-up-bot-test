package org.usfirst.frc.team5951.robot.commands.auton;

import org.usfirst.frc.team5951.robot.commands.caliber.basic.PushCube;
import org.usfirst.frc.team5951.robot.commands.caliber.basic.SwitchPosition;
import org.usfirst.frc.team5951.robot.commands.caliber.groups.UpPositionGroup;
import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraightTimed;
import org.usfirst.frc.team5951.robot.commands.chassis.TurnToAngle;
import org.usfirst.frc.team5951.robot.commands.chassis.TurnToAngleOneSide;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftSwitchRightAngle extends CommandGroup {

	public LeftSwitchRightAngle() {
		addSequential(new UpPositionGroup());
		addSequential(new TurnToAngleOneSide(-8));
		addSequential(new DriveStraight(3.28));
		addSequential(new TurnToAngle(95));
		addSequential(new DriveStraightTimed(0.5));
		addSequential(new PushCube());
	}
}
