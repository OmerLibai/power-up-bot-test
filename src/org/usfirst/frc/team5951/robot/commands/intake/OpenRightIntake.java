package org.usfirst.frc.team5951.robot.commands.intake;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class OpenRightIntake extends InstantCommand {

	private Intake intake;
	
    public OpenRightIntake() {
        intake = Robot.INTAKE;
    }

    // Called once when the command executes
    protected void initialize() {
    	intake.openIntakeRight();
    }

}
