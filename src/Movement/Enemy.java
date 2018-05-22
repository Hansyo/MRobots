package Movement;

import java.util.Random;

public class Enemy {
	public String name;
	private int age;
	private int ManpukuGage;
	private int x,y;
	Random rnd = new Random();

	public Enemy(String name,int age) {
		this.name = name;
		this.age = age;
		this.ManpukuGage = 60;
		this.x = rnd.nextInt(100) - 50;
		this.y = rnd.nextInt(100) - 50;
	}

	public void print_data() {
		System.out.println("名前:" + this.name);
		System.out.println("年齢:" + this.age);
		System.out.println("満腹度:" + this.ManpukuGage);
		System.out.println();
	}

	public void eat(int eating) {
		this.ManpukuGage += eating;
	}

	public void ChangeStateX(int data) {
		this.x += data;
	}

	public void ChangeStateY(int data) {
		this.y += data;
	}

	public int GetStateX() {
		return this.x;
	}

	public int GetStateY() {
		return this.y;
	}

}
