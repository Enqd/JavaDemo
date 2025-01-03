package day12.doudizhu.src.com.itheima.domain;

import com.itheima.game.GameJFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Poker extends JLabel implements MouseListener{
	//属性
	//1.牌的名字，格式：数字-数字
	private String name;

	//2.牌显示正面还是反面
	private boolean up;

	//3.牌是否可以被点击
	private boolean canClick = false;

	//4.牌当前的状态
	//如果是已经被点击状态，此时被点击，会执行降落动作
	//如果是没有被点击状态，此时被点击，会执行升起动作
	private boolean clicked = false;

	public Poker(String name, boolean up){
		this.name = name;
		this.up = up;

		//判断当前牌是正面还是反面
		if(up){
			//显示正面
			turnFront();
		}else{
			//显示反面
			turnRear();
		}

		//初始化牌
		//设置牌的宽高
		this.setSize(71, 96);
		//把牌显示出来
		this.setVisible(true);
		//给牌加上监听
		this.addMouseListener(this);//this：触发事件后，执行本类里面的方法
	}


	//实现方法
	//显示正面
	public void turnFront(){
		this.setIcon(new ImageIcon("day12/doudizhu/image/poker/" + name + ".png"));
		//修改成员变量
		this.up = true;
	}

	//显示背面
	public void turnRear(){
		this.setIcon(new ImageIcon("day12/doudizhu/image/poker/rear.png"));
		//修改成员变量
		this.up = false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//点击
		//判断是否可以点击
		int size = 0;
		if(canClick){
			//当牌被点击之后，要么升起，要么降落
			//向下y轴正方向，向右x轴正方向
			if(clicked){
				//如果已经点击过，则降落，y增加20像素
				size = 20;
			}else{
				//如果没有点击，则升起，y减少20像素
				size = -20;
			}
			//点击完后修改clicked的值
			clicked = !clicked;

			//修改牌的位置
			//获取当前牌的位置坐标
			Point from = this.getLocation();
			//创建一个Point对象表示结束位置
			Point to = new Point(from.x, from.y + size);
			//把最新的位置设置给牌
			this.setLocation(to);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}


	/**
	 * 获取
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取
	 * @return up
	 */
	public boolean isUp() {
		return up;
	}

	/**
	 * 设置
	 * @param up
	 */
	public void setUp(boolean up) {
		this.up = up;
	}

	/**
	 * 获取
	 * @return canClick
	 */
	public boolean isCanClick() {
		return canClick;
	}

	/**
	 * 设置
	 * @param canClick
	 */
	public void setCanClick(boolean canClick) {
		this.canClick = canClick;
	}

	/**
	 * 获取
	 * @return clicked
	 */
	public boolean isClicked() {
		return clicked;
	}

	/**
	 * 设置
	 * @param clicked
	 */
	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

	public String toString() {
		return "Poker{name = " + name + ", up = " + up + ", canClick = " + canClick + ", clicked = " + clicked + "}";
	}
}
