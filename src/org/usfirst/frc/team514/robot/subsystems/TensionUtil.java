/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team514.robot.subsystems;

import org.usfirst.frc.team514.robot.RobotMap;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Team 514
 */
public class TensionUtil extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    SpeedController tensioner;
    DigitalInput limiter;
    AnalogPotentiometer pot;
    boolean tight, loose;
    
    public TensionUtil() {
       tensioner = new Victor(RobotMap.tension_MOTOR);
       limiter = new DigitalInput(RobotMap.tensionLimitSwitch);
       pot = new AnalogPotentiometer(RobotMap.pot_Channel);
      
    }
    
    public void setTension(){
        //if(!limiter.get()){
        if(pot.pidGet() >= RobotMap.tension_value){
            tensioner.set(RobotMap.tension_increase);
            this.tight = false;
            this.loose = false;
        }else{
            tensionerOff();
            this.tight = true;
            this.loose = false;
        }
    }
    
    public void releaseTension(){
        if(pot.pidGet() <= RobotMap.tension_release_limit){
            tensioner.set(RobotMap.tension_decrease);
            this.loose = false;
            this.tight = false;
        }else{
            tensionerOff();
            this.loose = true;
            this.tight = false;
        }
    }
    
    public boolean getTensionStatus(){
        boolean done = false;
        
        if(loose || tight){
            done = true;
            tensionerOff();
        }

        return done; 
    }
    
    public void tensionerOff(){
        tensioner.set(RobotMap.tension_off);
    }
    
    public boolean isTight(){
        return this.tight;
    }
    
    public boolean isLoose(){
        return this.loose;
    }
    
    public void updateStatus(){
        SmartDashboard.putNumber("Pot value = ", pot.pidGet());
        SmartDashboard.putBoolean("Tension Status = ", getTensionStatus());
        SmartDashboard.putBoolean("Tight = ", isTight());
        SmartDashboard.putBoolean("Loose = ", isLoose());
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
