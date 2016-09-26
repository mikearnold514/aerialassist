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
public class GatorUtil extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Solenoid wrist;
    DigitalInput limiter;

    
    public GatorUtil(){
        wrist = new Solenoid(RobotMap.wristChannel);
        limiter = new DigitalInput(RobotMap.gatorLimitSwitch);
    }
 
    public void gatorUp(){
        wrist.set(false);
    }
    
    public void gatorDown(){
        wrist.set(true);
    }
    
    public boolean getGatorStatus(){
        return !limiter.get();
    }
    
    public void updateStatus(){
        SmartDashboard.putBoolean("Gator up = ", getGatorStatus());
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
