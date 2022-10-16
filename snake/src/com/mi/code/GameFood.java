package com.mi.code;

import java.awt.*;
import java.util.Random;

/**
 * 游戏食物
 */
public class GameFood {

    private Random random;

    private int xFood;

    private int yFood;

    public GameFood(int[] xPosition, int[] yPosition) {
        // 初始化食物
        this.random = new Random();
        this.xFood = GameConstants.GRID_SIZE + GameConstants.GRID_SIZE * this.random.nextInt(800 / 25 - 1);
        this.yFood = 75 + GameConstants.GRID_SIZE * this.random.nextInt(600 / 25 - 1);
        while (true) {
            int breakCount = 0;
            for (int i = 0; i < xPosition.length; i++) {
                if (this.xFood == xPosition[i] && this.yFood == yPosition[i]) {
                    this.xFood = GameConstants.GRID_SIZE + GameConstants.GRID_SIZE * this.random.nextInt(800 / 25);
                    this.yFood = 75 + GameConstants.GRID_SIZE * this.random.nextInt(600 / 25);
                    break;
                } else {
                    breakCount++;
                }
            }
            if (breakCount == xPosition.length) {
                break;
            }
        }
    }

    /**
     * 画食物
     *
     * @param gamePanel
     * @param graphics
     */
    public void drawFood(Component gamePanel, Graphics graphics) {

        GameData.foodImageICon.paintIcon(gamePanel, graphics, this.xFood, this.yFood);
    }

    public int getxFood() {
        return xFood;
    }

    public void setxFood(int xFood) {
        this.xFood = xFood;
    }

    public int getyFood() {
        return yFood;
    }

    public void setyFood(int yFood) {
        this.yFood = yFood;
    }
}
