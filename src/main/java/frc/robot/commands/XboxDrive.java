package frc.robot.commands;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSystem;
public class XboxDrive extends CommandBase{
    DriveSystem m_DriveSystem;
    public XboxDrive(DriveSystem m_DriveSystem){
        this.m_DriveSystem = m_DriveSystem;
    }
    @Override
    public void execute() {
        m_DriveSystem.ControllerDrive();
    }
}
