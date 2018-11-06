package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Led subsystem
 */
public class LEDs extends Subsystem {

	private static LEDs m_instance;

	// Components
	private Relay spikeRelay;

	public LEDs() {
		spikeRelay = new Relay(RobotMap.LED_RELAY);
	}

	/**
	 * @return Same instance of the {@link LEDs} subsystem
	 */
	public static LEDs getInstance() {
		if (m_instance == null)
			m_instance = new LEDs();
		return m_instance;
	}

	/**
	 * Turns the LEDs on
	 */
	public void ledsOn() {
		this.spikeRelay.set(Value.kForward);
	}

	/**
	 * Turns the LEDs off
	 */
	public void ledsOff() {
		this.spikeRelay.set(Value.kOff);
	}

	public void initDefaultCommand() {
	}
}
