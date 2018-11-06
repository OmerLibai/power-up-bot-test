package org.usfirst.frc.team5951.robot.commands.auton;

import org.usfirst.frc.team5951.robot.commands.caliber.basic.PushCube;
import org.usfirst.frc.team5951.robot.commands.caliber.basic.SwitchPosition;
import org.usfirst.frc.team5951.robot.commands.caliber.groups.UpPositionGroup;
import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class StraightForwardAuton extends CommandGroup {

    public StraightForwardAuton() {
        addSequential(new UpPositionGroup());
        addSequential(new DriveStraight(2.5));
        addSequential(new PushCube());
        addSequential(new WaitCommand(1.5));
        addSequential(new DriveStraight(-1));
    }
}
