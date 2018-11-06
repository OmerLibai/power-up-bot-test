package org.usfirst.frc.team5951.robot.commands.auton;

import org.usfirst.frc.team5951.robot.commands.caliber.basic.PushCube;
import org.usfirst.frc.team5951.robot.commands.caliber.groups.UpPositionGroup;
import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.chassis.TurnToAngleOneSide;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class MiddleToLeftAuton extends CommandGroup {

    public MiddleToLeftAuton() {
    	addSequential(new UpPositionGroup());
        addSequential(new TurnToAngleOneSide(-22.4));
        addSequential(new DriveStraight(2.2));
        addSequential(new TurnToAngleOneSide(21), 0.5);
        addSequential(new PushCube());
        addSequential(new WaitCommand(2));
        addSequential(new DriveStraight(-1));
    }
    
    @Override
    protected void interrupted() {
    	System.out.println("Autonomous interrupted!!!!");
    }
}
