package com.mi.code;

import java.awt.*;

/**
 * 游戏的状态
 */
public class GameStatus {

    /**
     * 游戏的状态
     */
    private boolean status = false;

    /**
     * 游戏失败的状态
     */
    private boolean failStatus = false;

    public GameStatus() {
    }

    /**
     * 设置游戏停止状态
     * @param graphics
     */
    public void setGameStopStatus(Graphics graphics) {
        if(!this.status) {
            // 设置文本颜色
            graphics.setColor(Color.WHITE);
            // 设置字体
            graphics.setFont(new Font("微软雅黑", Font.BOLD, 40));
            // 设置文本内容
            graphics.drawString("按空格键开始游戏", 300, 350);
        }
    }

    /**
     * 设置游戏失败状态
     * @param graphics
     */
    public void setGameFailStatus(Graphics graphics) {
        if(this.failStatus) {
            // 设置文本颜色
            graphics.setColor(Color.RED);
            // 设置字体
            graphics.setFont(new Font("微软雅黑", Font.BOLD, 40));
            // 设置文本内容
            graphics.drawString("游戏失败!, 按空格重新开始", 300, 350);
        }
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getFailStatus() {
        return failStatus;
    }

    public void setFailStatus(boolean failStatus) {
        this.failStatus = failStatus;
    }
}
