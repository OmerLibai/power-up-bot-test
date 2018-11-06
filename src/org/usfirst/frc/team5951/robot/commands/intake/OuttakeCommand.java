package org.usfirst.frc.team5951.robot.commands.intake;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OuttakeCommand extends Command {

	private Intake intake;
	
    public OuttakeCommand() {
    	intake = Robot.INTAKE;
    	requires(intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.CALIBER.releaseCube();
    	intake.closeIntakeLeft();
    	intake.closeIntakeRight();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	intake.insertCube();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	intake.stopIntake();
    	intake.openIntakeLeft();
    	intake.openIntakeRight();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
