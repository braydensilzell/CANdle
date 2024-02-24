// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.CANDle;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.PneumaticsBase;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  JoystickButton button;
  public static final String m_Tracking = null;
  

  public static CANDle candle = new CANDle(0, 0);
  public final XboxController driver = new XboxController(0);


// The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    
    //CANDle candle = new CANDle();
   //candle.rainbowAnimation(244);
    // Configure the trigger bindings
    configureBindings();
      // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.

    

    m_driverController.rightBumper().whileTrue(new InstantCommand(() -> candle.strobeAnimation(255, 0, 0, 0.4, 244)));
    m_driverController.rightBumper().whileFalse(new InstantCommand(() -> candle.strobeAnimation(0, 0, 0, 1, 244)));
    
    m_driverController.a().whileTrue(new InstantCommand(() -> candle.strobeAnimation(0, 0, 255, 1, 244)));
    m_driverController.a().whileFalse(new InstantCommand(() -> candle.strobeAnimation(0, 0, 0, 1, 244)));

    m_driverController.b().whileTrue(new InstantCommand(() -> candle.strobeAnimation(108, 108, 0, 1, 244)));
    m_driverController.b().whileFalse(new InstantCommand(() -> candle.strobeAnimation(0, 0, 0, 1, 244)));

    m_driverController.x().whileTrue(new InstantCommand(() -> candle.strobeAnimation(0, 255, 0, 1, 244)));
    m_driverController.x().whileFalse(new InstantCommand(() -> candle.strobeAnimation(0, 0, 0, 1, 244)));

    m_driverController.leftBumper().onTrue(new InstantCommand(() -> candle.strobeAnimation(0, 255, 0, 0.4, 244)));
    m_driverController.leftBumper().onFalse(new InstantCommand(() -> candle.strobeAnimation(0, 0, 0, 1, 244)));
  
    m_driverController.y().whileTrue(new InstantCommand(() -> candle.strobeAnimation(100, 0, 100, 1, 244)));
    m_driverController.y().whileFalse(new InstantCommand(() -> candle.strobeAnimation(0, 0, 0, 1, 244)));

    m_driverController.povRight().whileTrue(new InstantCommand(() -> candle.strobeAnimation(0, 133, 134, 1, 244)));
    m_driverController.povRight().whileFalse(new InstantCommand(() -> candle.strobeAnimation(0, 0, 0, 1, 244)));
  
    m_driverController.povDown().whileTrue(new InstantCommand(() -> candle.strobeAnimation(115, 115, 25, 0.4, 244)));
    m_driverController.povDown().onFalse(new InstantCommand(() -> candle.strobeAnimation(0, 0, 0, 1, 244)));
    
    m_driverController.povUp().whileTrue(new InstantCommand(() -> candle.strobeAnimation(115, 115, 25, 1, 244)));
    m_driverController.povUp().whileFalse(new InstantCommand(() -> candle.strobeAnimation(0, 0, 0, 1, 244)));

    m_driverController.povLeft().whileTrue(new InstantCommand(() -> candle.rainbowAnimation(244)));
    m_driverController.povLeft().whileFalse(new InstantCommand(() -> candle.strobeAnimation(0, 0, 0, 1, 244)));

    //m_driverController.rightStick().whileTrue(new InstantCommand(() -> candle.strobeAnimation(57, 40, 30, 1, 244)));
    //m_driverController.rightStick().whileFalse(new InstantCommand(() -> candle.strobeAnimation(0, 0, 0, 1, 244)));

    //m_driverController.leftStick().whileTrue(new InstantCommand(() -> candle.strobeAnimation(0, 0, 200, 1, 244)));
    //m_driverController.leftStick().whileFalse(new InstantCommand(() -> candle.strobeAnimation(0, 0, 0, 1, 244)));

    //m_driverController.povUpRight().whileTrue(new InstantCommand(() -> candle.strobeAnimation(190, 250, 0, 1, 244)));
    //m_driverController.povUpRight().whileFalse(new InstantCommand(() -> candle.strobeAnimation(0, 0, 0, 1, 244)));

    //m_driverController.povUpLeft().whileTrue(new InstantCommand(() -> candle.strobeAnimation(139, 128, 0, 1, 244)));
    //m_driverController.povUpLeft().whileFalse(new InstantCommand(() -> candle.strobeAnimation(0, 0, 0, 1, 244)));


  }
 private void True(InstantCommand instantCommand) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'True'");
  }
private void False(InstantCommand instantCommand) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'False'");
  }
public void configurebuttons(){



 }


  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

        //if(driver.getAButtonPressed()) {
      //candle.candleOn(0, 0, 200);
    //}
    //if(driver.getAButtonReleased()) {
      //candle.candleOn(0, 0, 0);
  //}

    // // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // // cancelling on release.
    // m_driverController.rightBumper().whileTrue(new InstantCommand(() -> candle.strobeAnimation(200, 0, 0, 0.6, 244)));
    // m_driverController.rightBumper().onFalse(new InstantCommand(() -> candle.strobeAnimation(0, 0, 0, 1, 244)));
    
    // m_driverController.x().whileTrue(new InstantCommand(() -> candle.candleChunkOn(0, 0, 200, 100, 0, 244)));
    // m_driverController.x().onFalse(new InstantCommand(() -> candle.candleChunkOn(0, 0, 0, 0, 0, 0)));

    // m_driverController.y().whileTrue(new InstantCommand(() -> candle.candleOn(0, 200, 100)));
    // m_driverController.y().onFalse(new InstantCommand(() -> candle.candleOn(0, 0, 0)));

    // m_driverController.a().whileTrue(new InstantCommand(() -> candle.candleOn(0, 200, 0)));
    // m_driverController.a().onFalse(new InstantCommand(() -> candle.candleOn(0, 0, 0)));

    // m_driverController.leftBumper().whileTrue(new InstantCommand(() -> candle.strobeAnimation(0, 200, 0, 0.6, 244)));
    // m_driverController.leftBumper().onFalse(new InstantCommand(() -> candle.strobeAnimation(0, 0, 0, 1, 244)));
  
    // m_driverController.b().whileTrue(new InstantCommand(() -> candle.candleOn(200, 0, 100)));
    // m_driverController.b().onFalse(new InstantCommand(() -> candle.candleOn(0, 0, 0)));

    // m_driverController.povUp().whileTrue(new InstantCommand(() -> candle.candleOn(200, 50, 50)));
    // m_driverController.povUp().onFalse(new InstantCommand(() -> candle.candleOn(0, 0, 0)));
  
    // m_driverController.povDown().whileTrue(new InstantCommand(() -> candle.strobeAnimation(50, 200, 50, 0.6, 244)));
    // m_driverController.povDown().onFalse(new InstantCommand(() -> candle.strobeAnimation(0, 0, 0, 1, 244)));
    
    // m_driverController.povLeft().whileTrue(new InstantCommand(() -> candle.candleOn(0, 50, 200)));
    // m_driverController.povLeft().onFalse(new InstantCommand(() -> candle.candleOn(0, 0, 0)));
  
 
  }
 

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
