/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5951.robot;

import org.usfirst.frc.team5951.robot.commands.brakes.ResetBrakeEncoder;
import org.usfirst.frc.team5951.robot.commands.brakes.SoftLockBrakes;
import org.usfirst.frc.team5951.robot.commands.caliber.basic.ManualLowerCaliber;
import org.usfirst.frc.team5951.robot.commands.caliber.basic.ManualRaiseCaliber;
import org.usfirst.frc.team5951.robot.commands.caliber.basic.ResetStopperEncoder;
import org.usfirst.frc.team5951.robot.commands.caliber.basic.ToggleBlocker;
import org.usfirst.frc.team5951.robot.commands.caliber.basic.ToggleBrakes;
import org.usfirst.frc.team5951.robot.commands.caliber.basic.TogglePush;
import org.usfirst.frc.team5951.robot.commands.caliber.groups.GroundPositionGroup;
import org.usfirst.frc.team5951.robot.commands.caliber.groups.UpPositionGroup;
import org.usfirst.frc.team5951.robot.commands.intake.IntakeCommand;
import org.usfirst.frc.team5951.robot.commands.intake.OuttakeCommand;
import org.usfirst.frc.team5951.robot.commands.intake.ToggleIntakePosition;
import org.usfirst.frc.team5951.robot.commands.leds.FlashLEDsCube;
import org.usfirst.frc.team5951.robot.commands.leds.LEDsOff;
import org.usfirst.frc.team5951.robot.commands.shooter.RollUpScale;
import org.usfirst.frc.team5951.robot.commands.shooter.RollUpSwitch;
import org.usfirst.frc.team5951.robot.triggers.CubeInRobot;
import org.usfirst.frc.team5951.robot.triggers.LeftTriggerPressed;
import org.usfirst.frc.team5951.robot.triggers.POVDown;
import org.usfirst.frc.team5951.robot.triggers.POVLeft;
import org.usfirst.frc.team5951.robot.triggers.POVUp;
import org.usfirst.frc.team5951.robot.triggers.RightTriggerPressed;
import org.usfirst.frc.team5951.robot.util.JoystickUtil;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// using only one joystick for test
	public static final Joystick DRIVER_STICK = new Joystick(RobotMap.DRIVER_STICK);
	public static final XboxController OPERATOR_STICK = new XboxController(RobotMap.OPERATOR_STICK);

	public static final CubeInRobot CUBE_IN_ROBOT_TRIGGER = new CubeInRobot();

	public static final JoystickButton TOGGLE_PUSH = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.Y);
	public static final JoystickButton SHOOT_SCALE = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.A);
	public static final JoystickButton TOGGLE_CUBE_BLOCKER = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.B);
	public static final JoystickButton TOGGLE_INTAKE_PISTONS = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.X);

	public static final JoystickButton SHOOT_SWITCH = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.STICK_RIGHT);

	public static final JoystickButton RESET_BRAKE = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.START);
	public static final JoystickButton TOGGLE_BRAKE = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.BACK);

	public static final JoystickButton RESET_BLOCKER = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.STICK_LEFT);

	public static final JoystickButton INTAKE = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.L1);
	public static final JoystickButton OUTTAKE = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.R1);

	public static final RightTriggerPressed LIFT_MORE = new RightTriggerPressed();
	public static final LeftTriggerPressed LIFT_LESS = new LeftTriggerPressed();

	public static final POVDown GROUND_POSITION = new POVDown(OPERATOR_STICK);
	public static final POVUp SWITCH_POSITION = new POVUp(OPERATOR_STICK);
	public static final POVLeft SOFT_BRAKES = new POVLeft(OPERATOR_STICK);

	public OI() {
		CUBE_IN_ROBOT_TRIGGER.whenActive(new FlashLEDsCube());
		CUBE_IN_ROBOT_TRIGGER.whenInactive(new LEDsOff());

		TOGGLE_PUSH.whenPressed(new TogglePush());
		SHOOT_SCALE.whileHeld(new RollUpScale());
		TOGGLE_CUBE_BLOCKER.toggleWhenPressed(new ToggleBlocker());
		TOGGLE_INTAKE_PISTONS.toggleWhenPressed(new ToggleIntakePosition());

		INTAKE.whileHeld(new IntakeCommand());
		OUTTAKE.whileHeld(new OuttakeCommand());

		GROUND_POSITION.whenActive(new GroundPositionGroup());
		SWITCH_POSITION.whenActive(new UpPositionGroup());
		SOFT_BRAKES.whenActive(new SoftLockBrakes());

		RESET_BRAKE.whenPressed(new ResetBrakeEncoder(1));
		TOGGLE_BRAKE.toggleWhenPressed(new ToggleBrakes());

		RESET_BLOCKER.whenPressed(new ResetStopperEncoder(2.25));

		LIFT_MORE.whileActive(new ManualRaiseCaliber());
		LIFT_LESS.whileActive(new ManualLowerCaliber());
		
		SHOOT_SWITCH.whileHeld(new RollUpSwitch());
	}
}
