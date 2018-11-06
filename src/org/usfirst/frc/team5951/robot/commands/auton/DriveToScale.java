package org.usfirst.frc.team5951.robot.commands.auton;

import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveToScale extends CommandGroup {

    public DriveToScale() {
        addSequential(new DriveStraight(4.5));
    }
}
