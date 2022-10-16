package com.mi.code;

import javax.swing.*;
import java.net.URL;

/**
 * 游戏数据
 */
public class GameData {

    /** 身体图片数据 */
    public static URL bodyURL = GameData.class.getResource(GameConstants.PATH_PREFIX + GameConstants.BODY);
    public static ImageIcon bodyImageICon =new ImageIcon(bodyURL);

    /** 向下头图片数据 */
    public static URL downURL = GameData.class.getResource(GameConstants.PATH_PREFIX + GameConstants.DOWN);
    public static ImageIcon downImageICon =new ImageIcon(downURL);
    /** 向左头图片数据 */
    public static URL leftURL = GameData.class.getResource(GameConstants.PATH_PREFIX + GameConstants.LEFT);
    public static ImageIcon leftImageICon =new ImageIcon(leftURL);
    /** 向右头图片数据 */
    public static URL rightURL = GameData.class.getResource(GameConstants.PATH_PREFIX + GameConstants.RIGHT);
    public static ImageIcon rightImageICon =new ImageIcon(rightURL);
    /** 向上头图片数据 */
    public static URL upURL = GameData.class.getResource(GameConstants.PATH_PREFIX + GameConstants.UP);
    public static ImageIcon upImageICon =new ImageIcon(upURL);

    /** 食物图片数据 */
    public static URL foodURL = GameData.class.getResource(GameConstants.PATH_PREFIX + GameConstants.FOOD);
    public static ImageIcon foodImageICon =new ImageIcon(foodURL);

    /** 头部图片数据 */
    public static URL headerURL = GameData.class.getResource(GameConstants.PATH_PREFIX + GameConstants.HEADER);
    public static ImageIcon headerImageICon =new ImageIcon(headerURL);
}
