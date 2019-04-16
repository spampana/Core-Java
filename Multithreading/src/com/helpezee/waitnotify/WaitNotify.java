package com.helpezee.waitnotify;

class Chat{
	private boolean flag=true;
	
	synchronized void question(String ques){
		if(flag==false){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" asking "+ques);
		flag=false;
		notify();
	}
	
	synchronized void answer(String ans){
		if(flag==true){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" replying "+ans);
		flag=true;
		notify();
	}
}

class QuestionTask implements Runnable{

	private Chat chat;
	private String questions[]={"Hi","How are you?","I am doing fine"};
	
	public QuestionTask(Chat chat) {
		super();
		this.chat = chat;
	}

	@Override
	public void run() {
		for(String ques:questions){
			chat.question(ques);
		}
	}
}

class AnswerTask implements Runnable{

	private Chat chat;
	private String answers[]={"Hello","I am good and How about you?","Great!"};
	
	public AnswerTask(Chat chat) {
		super();
		this.chat = chat;
	}

	@Override
	public void run() {
		for(String ans:answers){
			chat.answer(ans);
		}
		
	}
	
}
public class WaitNotify {

	public static void main(String[] args) {
		Chat chat=new Chat();
		Thread venkatesh=new Thread(new QuestionTask(chat),"Venkatesh");
		Thread shiva=new Thread(new AnswerTask(chat),"Shiva");
		venkatesh.start();
		shiva.start();

	}

}
