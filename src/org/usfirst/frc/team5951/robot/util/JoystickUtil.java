package org.usfirst.frc.team5951.robot.util;

public class JoystickUtil {
	/**
	 * Class containing joystick values for the XBOX
	 * 
	 * @author Yair Ziv
	 */
	public final static class XBOX {
		// Buttons
		public static final int A = 1;
		public static final int B = 2;
		public static final int X = 3;
		public static final int Y = 4;
		public static final int LB = 5;
		public static final int RB = 6;
		public static final int L1 = 5;
		public static final int R1 = 6;
				public static final int BACK = 7;
		public static final int START = 8;
		public static final int STICK_LEFT = 9;
		public static final int STICK_RIGHT = 10;

		// POV
		public static final int POV_CENTER = -1;
		public static final int POV_UP = 0;
		public static final int POV_UP_RIGHT = 45;
		public static final int POV_RIGHT = 90;
		public static final int POV_DOWN_RIGHT = 135;
		public static final int POV_DOWN = 180;
		public static final int POV_DOWN_LEFT = 225;
		public static final int POV_LEFT = 270;
		public static final int POV_LEFT_UP = 315;
	}

	/**
	 * Class containing joystick values for normal Joystick
	 * 
	 * @author Yair Ziv
	 */
	final static class JOYSTICK {
		// Buttons
		public static final int TRIGGER = 1;
		public static final int THUMB = 2;
	}
	
	/**
	 * Class containing the custom joystick button IDs
	 * @author Yair Ziv
	 *
	 */
	final static class CUSTOM {
		
	}
}
