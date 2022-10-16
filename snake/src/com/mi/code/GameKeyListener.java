package com.mi.code;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 键盘事件监听器
 */
public class GameKeyListener implements KeyListener {

    private GameStatus gameStatus;

    private GameFrame gameFrame;

    private GameSnake gameSnake;

    private GameScore gameScore;

    private GameFood gameFood;

    public GameKeyListener(GameFrame gameFrame, GameScore gameScore, GameStatus gameStatus, GameSnake gameSnake, GameFood gameFood) {
        this.gameStatus = gameStatus;
        this.gameFrame = gameFrame;
        this.gameSnake = gameSnake;
        this.gameScore = gameScore;
        this.gameFood = gameFood;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 键盘按下事件
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        // 判断是否是空格键按下
        if (keyCode == KeyEvent.VK_SPACE) {
            if (this.gameStatus.getFailStatus()) {
                // 重新绘制游戏
                // 初始化贪吃蛇的长度为3
                this.gameSnake.setLength(GameConstants.SNAKE_INIT_LENGTH);
                this.gameSnake.setAllXPosition(new int[(800 / 25) * (600 / 25)]);
                this.gameSnake.setAllYPosition(new int[(800 / 25) * (600 / 25)]);
                // 初始化蛇头蛇身的位置
                for (int i = this.gameSnake.getLength(); i > 0; i--) {
                    this.gameSnake.setxPosition(i * GameConstants.GRID_SIZE + GameConstants.GRID_SIZE, this.gameSnake.getLength() - i);
                    this.gameSnake.setyPosition(100, this.gameSnake.getLength() - i);
                }
                // 初始化蛇头方向
                this.gameSnake.setGameDirection(GameDirection.RIGHT);
                // 重新绘制食物
                GameFood gameFood = new GameFood(this.gameSnake.getxPosition(), this.gameSnake.getyPosition());
                this.gameFood.setxFood(gameFood.getxFood());
                this.gameFood.setyFood(gameFood.getyFood());
                // 重新设置分数
                this.gameScore.setLength(this.gameSnake.getLength());
                this.gameScore.setScore((this.gameSnake.getLength() - GameConstants.SNAKE_INIT_LENGTH) * 5);
                // 设置游戏状态
                this.gameStatus.setFailStatus(false);
                this.gameStatus.setStatus(true);
                this.gameFrame.setGameStatus(this.gameStatus);
            } else {
                // 设置游戏状态为之前的对立状态
                this.gameStatus.setStatus(!this.gameStatus.getStatus());
            }
            // 刷新游戏页面
            this.gameFrame.repaint();
        }

        // 判断是否按下方向键
        switch (keyCode) {
            case KeyEvent.VK_UP:
                // 如果蛇正在向下运动，按下向上不起作用
                if (this.gameSnake.getGameDirection().equals(GameDirection.DOWN) || this.gameSnake.getGameDirection().equals(GameDirection.UP)) {
                    break;
                }
                // 设置蛇头的方向
                this.gameSnake.setGameDirection(GameDirection.UP);
                // 不用设置坐标
//                // 设置蛇身体的坐标
//                for (int index = this.gameSnake.getLength() - 1; index > 0; index--) {
//                    this.gameSnake.setxPosition(this.gameSnake.getxPosition()[index - 1], index);
//                    this.gameSnake.setyPosition(this.gameSnake.getyPosition()[index - 1], index);
//                }
//                this.gameSnake.setxPosition(0, this.gameSnake.getLength());
//                this.gameSnake.setyPosition(0, this.gameSnake.getLength());
//                this.gameSnake.setyPosition(this.gameSnake.getyPosition()[0] - GameConstants.GRID_SIZE, 0);

                break;
            case KeyEvent.VK_DOWN:
                // 如果蛇正在向下运动，按下向上不起作用
                if (this.gameSnake.getGameDirection().equals(GameDirection.UP) || this.gameSnake.getGameDirection().equals(GameDirection.DOWN)) {
                    break;
                }
                // 设置蛇头的方向
                this.gameSnake.setGameDirection(GameDirection.DOWN);
//                // 设置蛇身体的坐标
//                for (int index = this.gameSnake.getLength() - 1; index > 0; index--) {
//                    this.gameSnake.setxPosition(this.gameSnake.getxPosition()[index - 1], index);
//                    this.gameSnake.setyPosition(this.gameSnake.getyPosition()[index - 1], index);
//                }
//                this.gameSnake.setxPosition(0, this.gameSnake.getLength());
//                this.gameSnake.setyPosition(0, this.gameSnake.getLength());
//                this.gameSnake.setyPosition(this.gameSnake.getyPosition()[0] + GameConstants.GRID_SIZE, 0);
                break;
            case KeyEvent.VK_LEFT:
                // 如果蛇正在向下运动，按下向上不起作用
                if (this.gameSnake.getGameDirection().equals(GameDirection.RIGHT) || this.gameSnake.getGameDirection().equals(GameDirection.LEFT)) {
                    break;
                }
                // 设置蛇头的方向
                this.gameSnake.setGameDirection(GameDirection.LEFT);
//                // 设置蛇身体的坐标
//                for (int index = this.gameSnake.getLength() - 1; index > 0; index--) {
//                    this.gameSnake.setxPosition(this.gameSnake.getxPosition()[index - 1], index);
//                    this.gameSnake.setyPosition(this.gameSnake.getyPosition()[index - 1], index);
//                }
//                this.gameSnake.setxPosition(0, this.gameSnake.getLength());
//                this.gameSnake.setyPosition(0, this.gameSnake.getLength());
//                this.gameSnake.setxPosition(this.gameSnake.getxPosition()[0] - GameConstants.GRID_SIZE, 0);
                break;
            case KeyEvent.VK_RIGHT:
                // 如果蛇正在向下运动，按下向上不起作用
                if (this.gameSnake.getGameDirection().equals(GameDirection.LEFT) || this.gameSnake.getGameDirection().equals(GameDirection.RIGHT)) {
                    break;
                }
                // 设置蛇头的方向
                this.gameSnake.setGameDirection(GameDirection.RIGHT);
//                // 设置蛇身体的坐标
//                for (int index = this.gameSnake.getLength() - 1; index > 0; index--) {
//                    this.gameSnake.setxPosition(this.gameSnake.getxPosition()[index - 1], index);
//                    this.gameSnake.setyPosition(this.gameSnake.getyPosition()[index - 1], index);
//                }
//                this.gameSnake.setxPosition(0, this.gameSnake.getLength());
//                this.gameSnake.setyPosition(0, this.gameSnake.getLength());
//                this.gameSnake.setxPosition(this.gameSnake.getxPosition()[0] + GameConstants.GRID_SIZE, 0);
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
