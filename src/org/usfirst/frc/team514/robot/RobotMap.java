package org.usfirst.frc.team514.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    // **************  Constants and Values     (ClassName/ClassObjectName/RobotMapVariablePrefix ****** //
        // Compressor Subsystem (CompressorUtil/compUtil/cmp)
        
        // Drive Subsystem (DriveUtil/driveUtil/drv)
        // Encoder Data = 4" Wheel Diameter, 12.57" Circumference
        // 174 Ticks/Inch
            public static final double ENCODER_DISTANCE = 1614.0;
            public static final double auto_LeftMotor = 0.75;
            public static final double auto_RightMotor = 0.75;
            public static final double C2R_inputMin = -100.0;
            public static final double C2R_inputMax = 100.0;
            public static final double C2R_outputMin = -0.25;
            public static final double C2R_outputMax = 0.25;
        
                        
        //This is the constant for ball magnet speed
            public static final double mag_capture = 0.5;
            public static final double mag_release = -0.5;
            public static final int mag_Capture_mode = 1;
            public static final int mag_Release_mode = 2;
            public static final int mag_Off_mode = 3;
            
        //These are constants for gatorUtil
            public static final int gatorUp_mode = 1;
            public static final int gatorDown_mode = 2;
            
        //These are constants for jawUtil
            public static final int jawOpen_mode = 2;
            public static final int jawClose_mode = 1;
        
        //These are constants for tetnsionUtil
            public static final double tension_off = 0.0;
            public static final double tension_increase = -0.75;
            public static final double tension_decrease = 0.75;
            public static final double tension_value = 500.0;
            public static final double tension_release_limit = 800.0;
        
        //These are constants for shotUtil
            public static final int fire_mode = 1;
            public static final int fire_ready_mode = 2;
            public static final int pass_ready_mode = 3;
                    
        //PIDControlller Constants...
            public static final double Kp = 0.08;
            public static final double Ki = 0.0;
            public static final double Kd = 0.5;
            public static final double Kperiod = 0.005;
    
        // All Timer Constants...
            public static final double auto_WAIT = 0.25;
            public static final double start_Vision = 3.0;
            public static final double vision_Interval = 1.0;
            public static final double stop_Vision = 7.0;
            public static final double latch_WAIT = 0.25;
            public static final double return_WAIT = 1.0;
            public static final int timer_Start = 1;
            public static final int timer_Reset = 2;
            public static final int timer_Stop = 3;
            public static final int timer_Run = 4;
            
    // **************  Physical Device Mapping  ************************** //
        // Digital Side Car Mapping
            // All PWMs go here!
            public static final int drv_LEFT_MOTOR = 2;
            public static final int drv_RIGHT_MOTOR = 1;
            public static final int mag_MOTOR = 3;
            public static final int tension_MOTOR = 4;

            // All DIO go here!
            public static final int leftEncoder1 = 1;
            public static final int leftEncoder2 = 2;
            public static final int rightEncoder1 = 3;
            public static final int rightEncoder2 = 4;
            public static final int tensionLimitSwitch = 5;
            public static final int gatorLimitSwitch = 6;
            public static final int jawLimitSwitch = 7;
            public static final int cmp_SWITCH = 8;
            public static final int shotReady = 9;
            public static final int ballReady = 10;
            
            // All Relays go here!
            public static final int cmp_RELAY = 8;
            
            // All Analog Modules go here!
            public static final int pot_Channel = 1;
            public static final int gyro_Channel = 2;
            
            // All PNEUMATIC Modules go here!
            
            public static final int wristChannel = 1;
            public static final int jawChannel = 2;
            public static final int shot_Out_Channel = 3;
            public static final int latchChannel = 4;
            public static final int shot_Back_Channel = 5;
            
    
        // Right Joystick and Buttons
        public static final int RIGHT_STICK = 2;
        public static final int TANK_Button = 2;
        public static final int ARCADE_Button = 3;
    
        // Left Joystick and Buttons
        public static final int LEFT_STICK = 1;
        /*
         * Put the test and calibration commands on the
         * Left Stick.  Remove for competition
         */
    
        // Controller and Buttons
        public static final int CONTROLLER = 3;
       public static final int Capture_button = 1;
       public static final int Primer_Button = 2;
       public static final int Release_button = 3;
       public static final int GatorUp_Button = 5;
       public static final int GatorDown_Button = 7;
       public static final int JawOpen_Button = 6;
       public static final int JawClosed_Button = 8;
       public static final int Fire_Button = 4;
       public static final int Shot_Button = 9;
       public static final int Pass_Button = 10;
        
        //Declare Encoder Constants
        public static final int stop_Encoder = 2;
        public static final int start_Encoder = 3;
        public static final int reset_Encoder = 1;
        
        //Declare Drive Mode Constants
        public static final int tank_Mode = 2;
        public static final int arcade_Mode = 1;
    
}
