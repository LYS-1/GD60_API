package com.iu.api2.collections.ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentDAO {
	private StringBuffer sb;
	private ArrayList<String> name = new ArrayList<String>();
	private ArrayList<Integer> number = new ArrayList<Integer>();
	private ArrayList<Integer> kor = new ArrayList<Integer>();
	private ArrayList<Integer> eng = new ArrayList<Integer>();
	private ArrayList<Integer> math = new ArrayList<Integer>();
	private ArrayList<Integer> sum = new ArrayList<Integer>();
	private ArrayList<Double> avg = new ArrayList<Double>();
	
	public StudentDAO() {
		this.sb = new StringBuffer();
		sb.append("iu-1-90-60-70-");
		sb.append("winter-2-86-84-75-");
		sb.append("suji, 3, 89, 74, 87,");
		sb.append("choa, 4, 72, 25, 99,");
		
		String str = sb.toString();
		str = str.replace("-", ",");
		str = str.replace(", ", ",");
		
		String st[] = str.split(",");
		for( int i = 0; i < st.length; i += 5) {
			this.name.add(st[i].toUpperCase());
			this.number.add(Integer.parseInt(st[i+1]));
			this.kor.add(Integer.parseInt(st[i+2]));
			this.eng.add(Integer.parseInt(st[i+3]));
			this.math.add(Integer.parseInt(st[i+4]));
		}
		
		for( int i = 0; i < kor.size(); i ++) {
			int s = kor.get(i) + eng.get(i) + math.get(i);
			double a = s / 3;
			this.sum.add(s);
			this.avg.add(a);
		}
	}
	public void init() {
		String str = sb.toString();
		str = str.replace("-", ",");
		str = str.replace(", ", ",");
		
		String st[] = str.split(",");
		for( int i = 0; i < st.length; i += 5) {
			this.name.add(st[i].toUpperCase());
			this.number.add(Integer.parseInt(st[i+1]));
			this.kor.add(Integer.parseInt(st[i+2]));
			this.eng.add(Integer.parseInt(st[i+3]));
			this.math.add(Integer.parseInt(st[i+4]));
		}
		
		for( int i = 0; i < kor.size(); i ++) {
			int s = kor.get(i) + eng.get(i) + math.get(i);
			double a = s / 3;
			this.sum.add(s);
			this.avg.add(a);
		}
	}
	
	public void addStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요.");
		name.add(sc.next().toUpperCase());
		System.out.println("번호를 입력하세요.");
		number.add(sc.nextInt());
		System.out.println("국어 성적을 입력하세요.");
		int sKor = sc.nextInt();
		kor.add(sKor);
		System.out.println("영어 성적을 입력하세요.");
		int sEng = sc.nextInt();
		eng.add(sEng);
		System.out.println("수학 성적을 입력하세요.");
		int sMath = sc.nextInt();
		math.add(sMath);
		
		int a = sKor + sEng + sMath;
		double b = a / 3;
		sum.add(a);
		avg.add(b);
	}
	public void delStudent(StudentDAO std, String s) {
		int id = -1;
		for( int i = 0; i < name.size(); i ++) {
			if(name.get(i).equals(s.toUpperCase())) {
				id = i;
				name.remove(id);
				number.remove(id);
				kor.remove(id);
				eng.remove(id);
				math.remove(id);
				sum.remove(id);
				avg.remove(id);
				break;
			}
		}
		if ( id == -1) {
			System.out.println("없는 학생입니다.");
		}
	}
	public ArrayList<String> getName() {
		return name;
	}
	public void setName(ArrayList<String> name) {
		this.name = name;
	}
	public ArrayList<Integer> getNumber() {
		return number;
	}
	public void setNumber(ArrayList<Integer> number) {
		this.number = number;
	}
	public ArrayList<Integer> getKor() {
		return kor;
	}
	public void setKor(ArrayList<Integer> kor) {
		this.kor = kor;
	}
	public ArrayList<Integer> getEng() {
		return eng;
	}
	public void setEng(ArrayList<Integer> eng) {
		this.eng = eng;
	}
	public ArrayList<Integer> getMath() {
		return math;
	}
	public void setMath(ArrayList<Integer> math) {
		this.math = math;
	}
	public ArrayList<Integer> getSum() {
		return sum;
	}
	public void setSum(ArrayList<Integer> sum) {
		this.sum = sum;
	}
	public ArrayList<Double> getAvg() {
		return avg;
	}
	public void setAvg(ArrayList<Double> avg) {
		this.avg = avg;
	}
}
