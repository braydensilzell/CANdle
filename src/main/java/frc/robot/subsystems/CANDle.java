// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.led.Animation;
import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.CANdleConfiguration;
import com.ctre.phoenix.led.LarsonAnimation;
import com.ctre.phoenix.led.RainbowAnimation;
import com.ctre.phoenix.led.StrobeAnimation;
import com.ctre.phoenix.led.CANdle.LEDStripType;
import com.ctre.phoenix.led.CANdle.VBatOutputMode;
import com.ctre.phoenix.led.LarsonAnimation.BounceMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CANDle extends SubsystemBase {
    CANdle candle = new CANdle(10);

    public CANDle(int buttonChannel, int lightChannel) {
      //TODO Auto-generated constructor stub
    }

    public void candle(){
           CANdleConfiguration configAll = new CANdleConfiguration();
        configAll.statusLedOffWhenActive = true;
        configAll.disableWhenLOS = true; //will be diff between hold and press
        configAll.stripType = LEDStripType.GRB;
        configAll.brightnessScalar = 1;
        configAll.vBatOutputMode = VBatOutputMode.Modulated;
        candle.configAllSettings(configAll, 100);
    }

    public void configLEDs() {
        CANdleConfiguration configAll = new CANdleConfiguration();
        configAll.statusLedOffWhenActive = true;
        configAll.disableWhenLOS = true; //will be diff between hold and press
        configAll.stripType = LEDStripType.GRB;
        configAll.brightnessScalar = 1;
        configAll.vBatOutputMode = VBatOutputMode.Modulated;
        candle.configAllSettings(configAll, 100);
    }

  public void candleOn(int red, int green, int blue){
    candle.setLEDs(red, green, blue);
  }
  
  public void candleChunkOn(int red, int green, int blue, int white, int startindex, int count) {
    candle.setLEDs(red, green, blue, white, startindex, count);
  }

  public void strobeAnimation(int r, int g, int b, double speed, int numLeds){
    StrobeAnimation strobeAnim = new StrobeAnimation(r, g, b, 0, speed, 310);
    candle.animate(strobeAnim);   
  }

  public void larsonAnimation(int numLeds){
  LarsonAnimation larsonAnimation = new LarsonAnimation(0, 0, 200, 0, 0.5, numLeds, BounceMode.Front, 7);
  candle.animate(larsonAnimation);
  }

  public void rainbowAnimation(int numLeds){
  RainbowAnimation rainbowanimation = new RainbowAnimation(1, 1, 310);
  candle.animate(rainbowanimation);
  }

}