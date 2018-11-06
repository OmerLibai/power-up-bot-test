package org.usfirst.frc.team5951.robot.commands.caliber.groups;

import org.usfirst.frc.team5951.robot.commands.brakes.LockBrakes;
import org.usfirst.frc.team5951.robot.commands.brakes.ReleaseBrakes;
import org.usfirst.frc.team5951.robot.commands.caliber.basic.StopCaliberMotor;
import org.usfirst.frc.team5951.robot.commands.caliber.basic.SwitchPosition;
import org.usfirst.frc.team5951.robot.commands.intake.CloseIntakeDelay;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class UpPositionGroup extends CommandGroup {

	public UpPositionGroup() {
		addSequential(new ReleaseBrakes());
		addSequential(new SwitchPosition());
	//	addSequential(new LockBrakes());
	//	addSequential(new WaitCommand(0.2));
	//	addSequential(new StopCaliberMotor());
	//	addSequential(new CloseIntakeDelay());
	}
	
	@Override
	protected void initialize() {
		System.out.println(this.toString() + " started");
	}
	
	@Override
	protected void end() {
		System.out.println(this.toString() + "has ended");
	}
}
