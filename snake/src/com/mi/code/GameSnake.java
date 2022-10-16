package com.mi.code;

import java.awt.*;
import java.util.Objects;

/**
 * 贪吃蛇对象
 */
public class GameSnake {

    // 长度
    private int length;

    // X轴坐标
    private int[] xPosition = new int[(800 / 25) * (600 / 25)];

    // y轴坐标
    private int[] yPosition = new int[(800 / 25) * (600 / 25)];

    // 蛇头的方向
    private GameDirection gameDirection;

    public GameSnake() {
        // 初始化贪吃蛇的长度为3
        this.length = GameConstants.SNAKE_INIT_LENGTH;
        // 初始化蛇头蛇身的位置
        for (int i = this.length; i > 0; i--) {
            this.xPosition[this.length - i] = i * GameConstants.GRID_SIZE + GameConstants.GRID_SIZE;
            this.yPosition[this.length - i] = 100;
        }
        // 初始化蛇头方向
        this.gameDirection = GameDirection.RIGHT;
    }

    /**
     * 绘制贪吃蛇
     */
    public void drawSnake(GamePanel gamePanel, Graphics graphics, GameDirection gameDirection) {
        // 判断蛇头方向
        if (Objects.isNull(gameDirection)) {
            gameDirection = this.gameDirection;
        }
        // 绘制蛇头
        switch (gameDirection) {
            case RIGHT:
                GameData.rightImageICon.paintIcon(gamePanel, graphics, this.xPosition[0], this.yPosition[0]);
                break;
            case LEFT:
                GameData.leftImageICon.paintIcon(gamePanel, graphics, this.xPosition[0], this.yPosition[0]);
                break;
            case DOWN:
                GameData.downImageICon.paintIcon(gamePanel, graphics, this.xPosition[0], this.yPosition[0]);
                break;
            case UP:
                GameData.upImageICon.paintIcon(gamePanel, graphics, this.xPosition[0], this.yPosition[0]);
                break;
            default:
                GameData.rightImageICon.paintIcon(gamePanel, graphics, this.xPosition[0], this.yPosition[0]);
                break;
        }
        // 绘制蛇身
        for (int i = 1; i < this.length; i++) {
            GameData.bodyImageICon.paintIcon(gamePanel, graphics, this.xPosition[i], this.yPosition[i]);
        }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int[] getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition, int indexPosition) {
        this.xPosition[indexPosition] = xPosition;
    }

    public int[] getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition, int indexPosition) {
        this.yPosition[indexPosition] = yPosition;
    }

    public GameDirection getGameDirection() {
        return gameDirection;
    }

    public void setGameDirection(GameDirection gameDirection) {
        this.gameDirection = gameDirection;
    }

    public void setAllXPosition(int[] xPosition) {
        this.xPosition = xPosition;
    }

    public void setAllYPosition(int[] yPosition) {
        this.yPosition = yPosition;
    }
}
