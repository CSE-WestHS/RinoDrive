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
    public DriveSystem(int leftID, int rightID){
        leftMotor = new VictorSPX(leftID);
        rightMotor = new VictorSPX(leftID);
    }

    @Override
  public void periodic() {
    // This method will be called once per scheduler run
    if (Math.abs(OI.DriveController.getLeftY()) + Math.abs(OI.DriveController.getRightY()) >= 0.2 ){
        leftMotor.set(ControlMode.PercentOutput, OI.DriveController.getLeftY() * Constants.OperatorConstants.MOTORSPEED);
        rightMotor.set(ControlMode.PercentOutput, OI.DriveController.getRightY() * Constants.OperatorConstants.MOTORSPEED);
    }
    else{
        leftMotor.set(ControlMode.PercentOutput, 0);
        rightMotor.set(ControlMode.PercentOutput, 0);
    }
  }
}
