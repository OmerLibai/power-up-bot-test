package org.usfirst.frc.team5951.robot.commands.caliber.groups;

import org.usfirst.frc.team5951.robot.commands.caliber.basic.PushCube;
import org.usfirst.frc.team5951.robot.commands.caliber.basic.ReleaseCube;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class ReleaseAndShoot extends CommandGroup {

    public ReleaseAndShoot() {
    	addSequential(new ReleaseCube());
    	addSequential(new WaitCommand(0.2));
    	addSequential(new PushCube());
    }
}
