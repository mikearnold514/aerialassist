/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team514.robot.subsystems;

import org.usfirst.frc.team514.robot.RobotMap;
import org.usfirst.frc.team514.robot.commands.OperateBallMag;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Team 514
 */
public class BallMagUtil extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    SpeedController Mag;
    public BallMagUtil(){
        Mag = new Victor(RobotMap.mag_MOTOR);
    }
    
    public void Capture(){
        Mag.set(RobotMap.mag_capture);
    }
    
    public void Release(){
        Mag.set(RobotMap.mag_release);
        
    } 
    
    public void Off(){
        Mag.set(0.0);
    } 

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new OperateBallMag(RobotMap.mag_Off_mode));
    }
}
