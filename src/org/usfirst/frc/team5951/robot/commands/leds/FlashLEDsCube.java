package org.usfirst.frc.team5951.robot.commands.leds;

import org.usfirst.frc.team5951.robot.commands.caliber.basic.StopCube;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Flashed the LEDs as indicators when the cube is in the robot
 */
public class FlashLEDsCube extends CommandGroup {

    public FlashLEDsCube() {
        addSequential(new LEDsOn());
        addSequential(new WaitCommand(0.1));
        addSequential(new LEDsOff());
        addSequential(new StopCube());
        addSequential(new WaitCommand(0.1));
        addSequential(new LEDsOn());
        addSequential(new WaitCommand(0.1));
        addSequential(new LEDsOff());
        addSequential(new WaitCommand(0.1));
        addSequential(new LEDsOn());
        addSequential(new WaitCommand(0.1));
        addSequential(new LEDsOff());
        addSequential(new WaitCommand(0.1));
        addSequential(new LEDsOn());
    }
}
