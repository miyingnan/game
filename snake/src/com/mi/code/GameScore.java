package com.mi.code;

import java.awt.*;

/**
 * 游戏分数
 */
public class GameScore {

    private int length;

    private int score;

    public GameScore() {

    }

    public GameScore(int length) {
        this.length = length;
        this.score = (length - GameConstants.SNAKE_INIT_LENGTH) * 5;
    }

    /**
     * 画分数
     *
     * @param graphics
     */
    public void drawScore(Graphics graphics) {
        // 设置文本颜色
        graphics.setColor(Color.WHITE);
        // 设置字体
        graphics.setFont(new Font("微软雅黑", Font.BOLD, 20));
        // 设置文本内容
        graphics.drawString("分数为：" + this.score, 750, 32);
    }

    /**
     * 画分数
     *
     * @param graphics
     */
    public void drawLength(Graphics graphics) {
        // 设置文本颜色
        graphics.setColor(Color.WHITE);
        // 设置字体
        graphics.setFont(new Font("微软雅黑", Font.BOLD, 20));
        // 设置文本内容
        graphics.drawString("长度为：" + this.length, 750, 57);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
