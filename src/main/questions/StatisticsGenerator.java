package main.questions;

import main.questions.RandomAccessArrayDeque.Node;

public class StatisticsGenerator {
	int window1Size;
	int window2Size;
	Node w1Start,w1End;
	int window2Sum=0,window1Sum=0;
	Node w1Max=null,w2Max=null;
	RandomAccessArrayDeque deq;
	int count=0;
	Node window1Head=null;

/*
 * Constructor requires the window1 and window2 size 
 */
	public StatisticsGenerator(int window1,int window2){
		this.window2Size=Math.max(window1,window2);
		this.window1Size=Math.min(window1,window2);
		deq=new RandomAccessArrayDeque(this.window2Size);
	}
/*
 * The insert method of RandomAccessArrayDeque will return the previous head of the window if exists.
 * 
 */
	void setWindow2Average(StatisticsRecord record,int number,int index){
		window2Sum+=number;
		Node oldHead=deq.insert(number,index);
		if(oldHead==null){
			//Window size as exceeded the maximum capacity
			if(deq.tailNode.index-deq.head.index==this.window2Size-1){
				//Window size is equal to the maximum capacity
				record.setW2Avg(((double)window2Sum)/window2Size);
			}else{
				//Window size as not reached the maximum capacity
				record.setW2Avg(-1);
			}
		}else{
			window2Sum-=oldHead.value;
			record.setW2Avg(((double)window2Sum)/window2Size);
		}
	}

	void setWindow1Average(StatisticsRecord record,int number){
		//add the current number to the window1 sum
		this.window1Sum+=number;
		
		w1End=deq.tailNode;
		if(w1Start==null){
			//First time when w1start is not set.
			w1Start=deq.head;
			record.setW1Avg(-1);
		}else{
			if(w1End.index-w1Start.index>this.window1Size-1){
				//current size is greater than maximum capacity
				//subtract the last head value of window1
				this.window1Sum-=w1Start.value;
				w1Start=deq.findNext(w1Start);
				record.setW1Avg(((double)window1Sum)/window1Size);
			}else if(w1End.index-w1Start.index==this.window1Size-1){
				//current size equal to max window1 size
				
				record.setW1Avg(((double)window1Sum)/window1Size);
			}else{
				//not yet reached the window1 max size
				record.setW1Avg(-1);
			}

		}
	}

	/**
	 * @param record
	 */
	void setWindow2Max(StatisticsRecord record){
		if(this.w2Max==null){
			//for first time when w2Max is not set
			this.w2Max=deq.head;
		}else{
			
			if(w2Max.index<deq.head.index){
				//previous max node's index is less than current window head index
				//which means the window has passed the max element
				Node curr=w2Max.next;
				w2Max=curr;
				//iterate from the previous max element till the tail of the window and find max
				while(curr!=null && curr.index<=deq.tailNode.index){			
					if(curr.value>=w2Max.value){
						w2Max=curr;
					}
					curr=curr.next;
				}
			}else{
				//the previous max is still inside the current window, we now have to check max element with new element only
			 
				if(w2Max.value<=deq.tailNode.value){
					w2Max=w1End;
				}
			}
		}
		if(deq.tailNode.index-deq.head.index<this.window2Size-1){
			record.setW2Max(-1);
		}else{
			record.setW2Max(w2Max.value);
		}
	}

	void setWindow1Max(StatisticsRecord record){
		//small window index
		if(this.w1Max==null){
			//for first time when w1max is not set
			this.w1Max=deq.head;
		}else{
			//we already know the w2Max which is the larger window and both the windows end at the current index (count)
			if(w2Max.index>=w1Start.index && w2Max.index<=w1End.index){
				//current w2max is within the window of w1, then it is w1max
				w1Max=w2Max;
			}else{
				//find the w1max by looping from w1Start index to w1End index
				Node curr=w1Start;
				w1Max=w1Start;
				while(curr!=null && curr.index<=w1End.index){			
					if(curr.value>=w1Max.value){
						w1Max=curr;
					}
					curr=curr.next;
				}
			}
		}
		if(w1End.index-w1Start.index<this.window1Size-1){
			record.setW1Max(-1);
		}else{
			record.setW1Max(w1Max.value);
		}
	}


	public StatisticsRecord printStatistics(int number){
		count++;
		StatisticsRecord record=new StatisticsRecord();
		setWindow2Average(record,number,count);
		setWindow1Average(record,number);
		setWindow2Max(record);
		setWindow1Max(record);
		System.out.println(record);
		return record;
	}
}
