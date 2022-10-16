package com.mi.code;

import javax.swing.*;
import java.awt.*;

/**
 * 游戏面板
 */
public class GamePanel extends JPanel {

    private GameSnake gameSnake;

    private GameStatus gameStatus;

    private GameFood gameFood;

    private GameScore gameScore;

    public GamePanel() {
    }
    public GamePanel(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
    public GamePanel(GameSnake gameSnake) {
        this.gameSnake = gameSnake;
    }
    public GamePanel(GameStatus gameStatus, GameSnake gameSnake, GameFood gameFood, GameScore gameScore) {
        this.gameStatus = gameStatus;
        this.gameSnake = gameSnake;
        this.gameFood = gameFood;
        this.gameScore = gameScore;
    }

    /**
     * 绘制面板，所有的游戏都是在面板上绘制的, 使用该画笔画出来的
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        // 清屏
        super.paintComponent(g);
        // 设置面板颜色
        this.setBackground(Color.WHITE);
        // 绘制头部广告
        GameData.headerImageICon.paintIcon(this, g, 25, 11);
        // 绘制分数和长度
        this.gameScore.drawLength(g);
        this.gameScore.drawScore(g);
        // 设置文本颜色
        g.setColor(Color.BLACK);
        // 绘制游戏区
        g.fillRect(25, 75, 850, 600);
        // 绘制食物
        this.gameFood.drawFood(this, g);

        // 在游戏区绘制贪吃蛇
        this.gameSnake.drawSnake(this, g, null);

        // 设置游戏停止状态
        this.gameStatus.setGameStopStatus(g);
        // 设置游戏失败状态
        this.gameStatus.setGameFailStatus(g);

    }
}
