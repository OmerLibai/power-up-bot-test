package org.usfirst.frc.team5951.robot.commands.auton;

import org.usfirst.frc.team5951.robot.commands.brakes.LockBrakes;
import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrossAutoLine extends CommandGroup {

    public CrossAutoLine() {
    	addSequential(new LockBrakes());
    	addSequential(new DriveStraight(3.0));
    }
    
    @Override
    protected void interrupted() {
    	System.out.println("Interrupted!");
    }
}
