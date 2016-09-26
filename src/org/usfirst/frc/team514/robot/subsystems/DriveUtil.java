/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team514.robot.subsystems;

import org.usfirst.frc.team514.robot.RobotMap;
import org.usfirst.frc.team514.robot.commands.DriveTeleOp;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author marnold
 */
public class DriveUtil extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    RobotDrive drive;
    SpeedController leftdrive, rightdrive;
    boolean inverted;
    String mode;
    
    public DriveUtil(){
        leftdrive = new Talon(RobotMap.drv_LEFT_MOTOR);
        rightdrive = new Talon(RobotMap.drv_RIGHT_MOTOR);
        drive = new RobotDrive(leftdrive, rightdrive);
        invertDrive(true);
        this.mode = "";
    }
    
    private void invertDrive(boolean invert){
        drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, invert);
        drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, invert);
        inverted = invert;
    }
    
    public void invertMotors(boolean invert){
        if(invert != inverted){
            invertDrive(invert);            
        }
    }
    
    public void driveTank(Joystick left, Joystick right){
        invertMotors(true);
        drive.tankDrive(left, right);
        this.mode = "Tank          ";
    }
    
    public void driveArcade(Joystick stick){
        invertMotors(true);
        drive.arcadeDrive(stick);
        this.mode = "Arcade        ";
    }
    
    public void drive(double left, double right){
        invertMotors(false);
        drive.tankDrive(left, right);
        this.mode = "Autonomous    ";
    }
    
    public void updateStatus(){
        SmartDashboard.putString("Drive Mode = ", this.mode);
        SmartDashboard.putBoolean("Motors Inverted = ", inverted);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DriveTeleOp(RobotMap.tank_Mode));
    }
}
