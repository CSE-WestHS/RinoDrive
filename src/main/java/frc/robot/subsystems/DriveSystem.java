package frc.robot.subsystems;
import edu.wpi.first.wpilibj.simulation.XboxControllerSim;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.OI;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.Constants;

public class DriveSystem extends SubsystemBase{
    VictorSPX leftMotor;
    VictorSPX rightMotor;
    VictorSPX leftMotor2;
    VictorSPX rightMotor2;
    public DriveSystem(int leftID, int leftID2, int rightID, int rightID2){
        
        leftMotor = new VictorSPX(leftID);
        rightMotor = new VictorSPX(rightID);
        leftMotor2 = new VictorSPX(leftID2);
        rightMotor2 = new VictorSPX(rightID2);
    }

    @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }
  public void ControllerDrive(){
    if (Math.abs(OI.DriveController.getLeftY()) + Math.abs(OI.DriveController.getRightY()) >= 0.2 ){
      // 0.95 is LeftAdj
        leftMotor.set(ControlMode.PercentOutput, -OI.DriveController.getLeftY() * Constants.OperatorConstants.MOTORSPEED * 0.95);
        rightMotor.set(ControlMode.PercentOutput, OI.DriveController.getRightY() * Constants.OperatorConstants.MOTORSPEED);
        leftMotor2.set(ControlMode.PercentOutput, -OI.DriveController.getLeftY() * Constants.OperatorConstants.MOTORSPEED * 0.95);
        rightMotor2.set(ControlMode.PercentOutput, OI.DriveController.getRightY() * Constants.OperatorConstants.MOTORSPEED);

    }
    else{
        leftMotor.set(ControlMode.PercentOutput, 0);
        rightMotor.set(ControlMode.PercentOutput, 0);
        leftMotor2.set(ControlMode.PercentOutput, 0);
        rightMotor2.set(ControlMode.PercentOutput, 0);
    }
  }
}
