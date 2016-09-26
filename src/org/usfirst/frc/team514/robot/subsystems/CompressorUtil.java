/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team514.robot.subsystems;

import org.usfirst.frc.team514.robot.commands.CMP_Start;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author marnold
 */
public class CompressorUtil extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Compressor comp;
   
    public CompressorUtil(){
        //comp = new Compressor(RobotMap.cmp_SWITCH, RobotMap.cmp_RELAY);
    	comp = new Compressor();
    }
    
    public void enable(){
        comp.start();
    }
    
    public boolean isEnabled(){
        return comp.enabled();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        if(!isEnabled()){
            setDefaultCommand(new CMP_Start());            
        }
    }
    
    public void updateStatus(){
        //SmartDashboard.putBoolean("Compressor Enabled", comp.enabled());
    }
}
