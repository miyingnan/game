package com.mi.code;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * 游戏窗口
 */
public class GameFrame extends JFrame {

    private GamePanel gamePanel;

    private GameSnake gameSnake;

    private GameStatus gameStatus;

    private GameFood gameFood;

    private GameScore gameScore;

    private Timer timer;

    private GameActionListener gameActionListener;


    public GameFrame() {
        this.gameStatus = new GameStatus();
        this.gameSnake = new GameSnake();
        this.gameScore = new GameScore(this.gameSnake.getLength());
        this.gameFood = new GameFood(this.gameSnake.getxPosition(), this.gameSnake.getyPosition());
        this.gamePanel = new GamePanel(this.gameStatus, this.gameSnake, this.gameFood, this.gameScore);
        this.initFrame();
        // 设置获取焦点
        this.setFocusable(true);
        // 设置键盘监听事件
        GameKeyListener gameKeyListener = new GameKeyListener(this, this.gameScore, this.gameStatus, this.gameSnake, this.gameFood);
        this.addKeyListener(gameKeyListener);
        // 设置动作监听器
        this.gameActionListener = new GameActionListener(this, gameStatus, gameSnake, gameFood, this.gameScore);
        this.timer = new Timer(100, this.gameActionListener);
        this.timer.start();
    }

    private void initFrame() {
        // 设置窗口大小
        this.setBounds(100, 100, 900, 720);
        // 设置窗口关闭事件
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 设置窗口颜色
        this.setBackground(Color.BLACK);
        // 设置窗口大小不可变
        this.setResizable(false);
        // 设置图标
        URL iconUrl = this.getClass().getResource(GameConstants.PATH_PREFIX + GameConstants.UP);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(iconUrl));
        // 设置标题
        this.setTitle("贪吃蛇Java版邀你来玩");

        // 设置容器
        Container contentPane = this.getContentPane();
        // 添加面板
        contentPane.add(this.gamePanel);

        // 设置窗口可见性(只能放在最下面)
        this.setVisible(true);
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public GameSnake getGameSnake() {
        return gameSnake;
    }

    public void setGameSnake(GameSnake gameSnake) {
        this.gameSnake = gameSnake;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public GameFood getGameFood() {
        return gameFood;
    }

    public void setGameFood(GameFood gameFood) {
        this.gameFood = gameFood;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public GameActionListener getGameActionListener() {
        return gameActionListener;
    }

    public void setGameActionListener(GameActionListener gameActionListener) {
        this.gameActionListener = gameActionListener;
    }
}
