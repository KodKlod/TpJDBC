
public abstract class MainDemoiThread implements Runnable {
	
	public static void main (String [] args) throws Exception {

		MainDemoiThread instance = new MainDemoiThread() {
			@Override
			public void run() {
				try {
					boucleJaiFaim();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread monThread = new Thread(instance);
		monThread.start();
		boucleCoucou();

	}


	private static void boucleJaiFaim() throws InterruptedException {
		int j = 1;
		for (;;) {
			Thread.sleep(1500);
			System.out.println("J'ai faim ! : " + j++);
		}
	}

	private static void boucleCoucou() throws InterruptedException {
		int i= 1;
		do{
			System.out.println("Coucou : " + i);
			i++;
			Thread.sleep(1000);
		}
		while (i>0);
	}

}
