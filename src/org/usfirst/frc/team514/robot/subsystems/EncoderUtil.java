/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team514.robot.subsystems;

import org.usfirst.frc.team514.robot.RobotMap;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author marnold
 */
public class EncoderUtil extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Encoder leftencoder;
    Encoder rightencoder;
    double input, output;
    boolean range;
   
    
    public EncoderUtil(){
        leftencoder = new Encoder(RobotMap.leftEncoder1, RobotMap.leftEncoder2,
                                  true, CounterBase.EncodingType.k4X);
        //leftencoder.stop();
        leftencoder.reset();
        //leftencoder.start();
        rightencoder = new Encoder(RobotMap.rightEncoder1, RobotMap.rightEncoder2,
                                   true, CounterBase.EncodingType.k4X);
        //rightencoder.stop();
        rightencoder.reset();
        //rightencoder.start();
        this.range = false;
    }
    
    /*public void stopEncoder(){
        leftencoder.stop();
        rightencoder.stop();
    }
    */
    
    /*public void startEncoder(){
        leftencoder.start();
        rightencoder.start();
    }
    */
    
    public void resetEncoder(){
        leftencoder.reset();
        rightencoder.reset();
    }
    
    public double getLeftEncoderDistance(){
        return leftencoder.getDistance();
    }
    
    public double getRightEncoderDistance(){
        return rightencoder.getDistance();    
    }
    
    public boolean getShotRange(){
        return this.range;
    }
    
    public void setShotRange(boolean range){
        this.range = range;
    }
    
    public double coerce2Range(double input){
        // TODO code application logic here
        double inputMin, inputMax, inputCenter;
        double outputMin, outputMax, outputCenter;
        double scale, result;
        //double output;
        
        inputMin = RobotMap.C2R_inputMin; 
        inputMax = RobotMap.C2R_inputMax;     
        
        outputMin = RobotMap.C2R_outputMin;
        outputMax = RobotMap.C2R_outputMax;
        
        //14 Encode ticks per inch...
        this.input = input;
                
            /* Determine the center of the input range and output range */
            inputCenter = Math.abs(inputMax - inputMin) / 2 + inputMin;
            outputCenter = Math.abs(outputMax - outputMin) / 2 + outputMin;

            /* Scale the input range to the output range */
            scale = (outputMax - outputMin) / (inputMax - inputMin);

            /* Apply the transformation */
            result = (input + -inputCenter) * scale + outputCenter;

            /* Constrain to the output range */
            output = Math.max(Math.min(result, outputMax), outputMin);

       return output;
       
    }
    
    public void updateStatus(){
        SmartDashboard.putNumber("Left Encoder Value = ", leftencoder.getDistance());
        SmartDashboard.putNumber("Right Encoder Value", rightencoder.getDistance());
        SmartDashboard.putNumber("Input Value = ", input);
        SmartDashboard.putNumber("Output Value = ", output);
    }

    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
