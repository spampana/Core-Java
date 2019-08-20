package com.helpezee.threadcommunication;

class Chat {
	private boolean flag = true;

	synchronized void question(String qustn) {
		if (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " asking: " + qustn);
		flag = false;
		notify();
	}

	synchronized void answer(String ans) {
		if (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " replying: " + ans);
		flag = true;
		notify();
	}
}

class QuestionTask implements Runnable {

	private Chat chat;

	private String qstns[] = { "Hi", "How r u?", "I am fine" };

	public QuestionTask(Chat chat) {
		super();
		this.chat = chat;
	}

	@Override
	public void run() {
		for (String ques : qstns) {
			chat.question(ques);
		}
	}
}

class AnswerTask implements Runnable {

	private Chat chat;
	private String answers[] = { "Hello!", "I am good, How abt u?", "Great!" };

	public AnswerTask(Chat chat) {
		super();
		this.chat = chat;
	}

	@Override
	public void run() {
		for (String ans : answers) {
			chat.answer(ans);
		}
	}

}

public class ThreadCommunicationDemo {

	public static void main(String[] args) {
		Chat chat = new Chat();
		Thread dhanaraju = new Thread(new QuestionTask(chat), "Dhanaraju");
		Thread prasad = new Thread(new AnswerTask(chat), "Prasad");
		dhanaraju.start();
		prasad.start();
	}

}
