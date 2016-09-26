/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team514.robot.subsystems;

import org.usfirst.frc.team514.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Team 514
 */
public class JawUtil extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Solenoid jaw;
    DigitalInput limiter;
    
    public JawUtil(){
        jaw = new Solenoid(RobotMap.jawChannel);
        limiter = new DigitalInput(RobotMap.jawLimitSwitch);
    }
    
    public void OpenJaw(){
        jaw.set(true);
    }
    
    public void CloseJaw(){
        jaw.set(false);
    }
    
    public boolean getJawStatus(){
        return !limiter.get();
    }
    
    public void updateStatus(){
        SmartDashboard.putBoolean("Jaw Open = ", getJawStatus());
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
