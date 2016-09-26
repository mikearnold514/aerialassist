
package org.usfirst.frc.team514.robot;

import org.usfirst.frc.team514.robot.commands.AutoCMD;
import org.usfirst.frc.team514.robot.commands.DriveTeleOp;
import org.usfirst.frc.team514.robot.commands.OperateBallMag;
import org.usfirst.frc.team514.robot.commands.OperateGator;
import org.usfirst.frc.team514.robot.commands.OperateJaw;
import org.usfirst.frc.team514.robot.commands.OperateShot;
import org.usfirst.frc.team514.robot.commands.OperateTension;
import org.usfirst.frc.team514.robot.commands.PrimeShot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    Joystick leftstick, rightstick, controller;
    JoystickButton tank, arcade, capture, release,
                   gatorUp, gatorDown, jawOpen, jawClose, fire, primer, 
                   passmode, shotmode; 
    /*
     * Block of Test JoystickButtons - Remove when done!
     
    JoystickButton testTrackingOn, testTrackingOff,
            testTensionerForward, testTensionerReverse, 
            testShooterFwd, testShooterBwd, testShooterOff,
            testlatchfire,testlatchreturn, testDriveEncoder, testStopDrive,
            testEncoderReset, testEncoderStart,
            testTimerStart, testTimerStop;
    /*
     * End Block of Test Joystick Buttons
     */
    
    public OI(){
        leftstick = new Joystick(RobotMap.LEFT_STICK);
        rightstick = new Joystick(RobotMap.RIGHT_STICK);
        controller = new Joystick(RobotMap.CONTROLLER);
        
        tank = new JoystickButton(rightstick, RobotMap.TANK_Button);
        arcade = new JoystickButton(rightstick, RobotMap.ARCADE_Button);

        
        /*
         * Block of Test Command Buttons - Remove when done!
         *
        testTrackingOn = new JoystickButton(leftstick, 8);
        testTrackingOff = new JoystickButton(leftstick, 9); 
        testTensionerForward = new JoystickButton(leftstick, 4);
        testTensionerReverse = new JoystickButton(leftstick, 5);
        testShooterFwd = new JoystickButton(leftstick, 6);
        testShooterBwd = new JoystickButton(leftstick, 7);
        testShooterOff = new JoystickButton(leftstick, 2);
        testlatchfire = new JoystickButton (leftstick, 10);
        testlatchreturn = new JoystickButton (leftstick, 11);
        testDriveEncoder = new JoystickButton(rightstick, 6);
        testStopDrive = new JoystickButton(rightstick, 7);
        testEncoderReset = new JoystickButton(rightstick, 9);
        testEncoderStart = new JoystickButton(rightstick, 8);
        testTimerStart = new JoystickButton(rightstick, 11);
        testTimerStop = new JoystickButton(rightstick, 10);
        /*
         * End Block of Test Command Buttons
         */
        capture = new JoystickButton(controller, RobotMap.Capture_button);
        release = new JoystickButton(controller, RobotMap.Release_button);
        gatorUp = new JoystickButton(controller, RobotMap.GatorUp_Button);
        gatorDown = new JoystickButton(controller, RobotMap.GatorDown_Button);
        jawOpen = new JoystickButton(controller, RobotMap.JawOpen_Button);
        jawClose = new JoystickButton(controller, RobotMap.JawClosed_Button);
        fire = new JoystickButton(controller, RobotMap.Fire_Button);
        passmode = new JoystickButton(controller, RobotMap.Pass_Button);
        shotmode = new JoystickButton(controller, RobotMap.Shot_Button);
        primer = new JoystickButton(controller, RobotMap.Primer_Button);
        
        tank.whenPressed(new DriveTeleOp(RobotMap.tank_Mode));
        arcade.whenPressed(new DriveTeleOp(RobotMap.arcade_Mode));
     
        capture.whileHeld(new OperateBallMag(RobotMap.mag_Capture_mode));
        release.whileHeld(new OperateBallMag(RobotMap.mag_Release_mode));
        
        gatorUp.whenPressed(new OperateGator(RobotMap.gatorUp_mode));
        gatorDown.whenPressed(new OperateGator(RobotMap.gatorDown_mode));
        
        jawOpen.whenPressed(new OperateJaw(RobotMap.jawOpen_mode));
        jawClose.whenPressed(new OperateJaw(RobotMap.jawClose_mode));
        
        fire.whileHeld(new OperateShot());
        fire.whenReleased(new OperateTension(RobotMap.pass_ready_mode));
        primer.whenPressed(new PrimeShot());
        passmode.whenPressed(new OperateTension(RobotMap.pass_ready_mode));
        shotmode.whenPressed(new OperateTension(RobotMap.fire_ready_mode));
        
        /*
         * Test Commands - Remove when Done!
         *
        testTrackingOn.whenPressed(new TestTarget(true));
        testTrackingOff.whenPressed(new TestTarget(false));
        
        testTensionerForward.whileHeld(new TestTensioner(1));
        testTensionerForward.whenReleased(new TestTensioner(3));
        testTensionerReverse.whileHeld(new TestTensioner(2));        
        testTensionerReverse.whenReleased(new TestTensioner(3));
        
        testShooterFwd.whenPressed(new TestShooter(1));
        testShooterBwd.whenPressed(new TestShooter(2));
        testShooterOff.whenPressed(new TestShooter(3));
        testlatchfire.whenPressed(new TestLatch(true));
        testlatchreturn.whenPressed(new TestLatch(false));
        
        testDriveEncoder.whenPressed(new DriveEncoder(false));
        testStopDrive.whenPressed(new DriveEncoder(true));
        
        testEncoderReset.whenPressed(new OperateEncoder(RobotMap.reset_Encoder));
        testEncoderStart.whenPressed(new OperateEncoder(RobotMap.start_Encoder));
        
        testTimerStart.whenPressed(new OperateTimer(RobotMap.timer_Reset));
        testTimerStart.whenReleased(new OperateTimer(RobotMap.timer_Run));
        testTimerStop.whenPressed(new OperateTimer(RobotMap.timer_Stop));
        /*
         * End Block of Test Commands
         */
        
        //AutonomousMode Selections
        SmartDashboard.putData("Left Side", new AutoCMD(true));
        SmartDashboard.putData("Right Side", new AutoCMD(false));
        
    }
    
    public Joystick getLeftstick(){
        return leftstick;
    }
    
    public Joystick getRightstick(){
        return rightstick;
    }
}

