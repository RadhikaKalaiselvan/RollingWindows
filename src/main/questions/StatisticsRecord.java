package main.questions;

/**
 * @author radhikakalaiselvan
 * Format of single statistics record output
 */
public class StatisticsRecord{
	int w1Max,w2Max;
	double w1Avg,w2Avg;
	StatisticsRecord(){

	}
	StatisticsRecord(int w1Max,double w1Avg,int w2Max,double w2Avg){
		this.w1Max=w1Max;
		this.w1Avg=w1Avg;
		this.w2Avg=w2Avg;
		this.w2Max=w2Max;
	}

	public int getW1Max() {
		return w1Max;
	}
	public void setW1Max(int w1Max) {
		this.w1Max = w1Max;
	}
	public double getW1Avg() {
		return w1Avg;
	}
	public void setW1Avg(double w1Avg) {
		this.w1Avg = w1Avg;
	}
	public int getW2Max() {
		return w2Max;
	}
	public void setW2Max(int w2Max) {
		this.w2Max = w2Max;
	}
	public double getW2Avg() {
		return w2Avg;
	}
	public void setW2Avg(double w2Avg) {
		this.w2Avg = w2Avg;
	}

	public String toString(){
		return "["+String.format("%.2f",this.w1Avg)+","+this.w1Max+","+String.format("%.2f",this.w2Avg)+","+this.w2Max+"]";
	}
}
