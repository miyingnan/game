package com.mi.code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 动作监听器
 */
public class GameActionListener implements ActionListener {

    private GameFrame gameFrame;

    private GameFood gameFood;

    private GameStatus gameStatus;

    private GameSnake gameSnake;

    private GameScore gameScore;

    public GameActionListener(GameFrame gameFrame, GameStatus gameStatus, GameSnake gameSnake, GameFood gameFood, GameScore gameScore) {
        this.gameFrame = gameFrame;
        this.gameStatus = gameStatus;
        this.gameSnake = gameSnake;
        this.gameScore = gameScore;
        this.gameFood = gameFood;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 判断游戏状态，游戏状态为启动才执行
        if (this.gameStatus.getStatus() && !this.gameStatus.getFailStatus()) {
            // 蛇吃食物(头部坐标与食物坐标相同)
            if (this.gameSnake.getxPosition()[0] == this.gameFood.getxFood() && this.gameSnake.getyPosition()[0] == this.gameFood.getyFood()) {
                // 设置贪吃蛇长度
                this.gameSnake.setLength(this.gameSnake.getLength() + 1);
                // 设置分数
                this.gameScore.setLength(this.gameSnake.getLength());
                this.gameScore.setScore((this.gameSnake.getLength() - GameConstants.SNAKE_INIT_LENGTH) * 5);
                // 重新绘制食物
                GameFood gameFood = new GameFood(this.gameSnake.getxPosition(), this.gameSnake.getyPosition());
                this.gameFood.setxFood(gameFood.getxFood());
                this.gameFood.setyFood(gameFood.getyFood());
            }
            for (int index = this.gameSnake.getLength() - 1; index > 0; index--) {
                this.gameSnake.getxPosition()[index] = this.gameSnake.getxPosition()[index - 1];
                this.gameSnake.getyPosition()[index] = this.gameSnake.getyPosition()[index - 1];
            }
            // 判断蛇头的位置
            GameDirection gameDirection = this.gameSnake.getGameDirection();
            switch (gameDirection) {
                case UP:
                    this.gameSnake.getyPosition()[0] = this.gameSnake.getyPosition()[0] - GameConstants.GRID_SIZE;
                    break;
                case DOWN:
                    this.gameSnake.getyPosition()[0] = this.gameSnake.getyPosition()[0] + GameConstants.GRID_SIZE;
                    break;
                case LEFT:
                    this.gameSnake.getxPosition()[0] = this.gameSnake.getxPosition()[0] - GameConstants.GRID_SIZE;
                    break;
                case RIGHT:
                    this.gameSnake.getxPosition()[0] = this.gameSnake.getxPosition()[0] + GameConstants.GRID_SIZE;
                    break;
                default:
                    break;
            }

            // 边界判断
            if (this.gameSnake.getyPosition()[0] <= 50) {
                this.gameSnake.getyPosition()[0] = 600 + 50;
            }
            if (this.gameSnake.getyPosition()[0] > 650) {
                this.gameSnake.getyPosition()[0] = 75;
            }
            if (this.gameSnake.getxPosition()[0] <= 0) {
                this.gameSnake.getxPosition()[0] = 800 + 50;
            }
            if (this.gameSnake.getxPosition()[0] > 850) {
                this.gameSnake.getxPosition()[0] = 25;
            }

            // 判断游戏是否失败（头部触碰身体）
            for (int i = 1; i < this.gameSnake.getxPosition().length; i++) {
                if (this.gameSnake.getxPosition()[i] == 0 && this.gameSnake.getyPosition()[i] == 0) {
                    break;
                }
                if (this.gameSnake.getxPosition()[0] == this.gameSnake.getxPosition()[i] && this.gameSnake.getyPosition()[0] == this.gameSnake.getyPosition()[i]) {
                    this.gameStatus.setFailStatus(true);
                }
            }
            // 刷新页面
            this.gameFrame.repaint();
        }
    }
}

