package concurrent.locks;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *排队自旋锁
 *
 */
public class TicketLock {
	//服务号
	private AtomicInteger serviceNum = new AtomicInteger();
	//排队号
	private AtomicInteger ticketNum = new AtomicInteger();
	
	//叫号, 接受服务
	public int lock() {
		//原子性的获得一个排队号
		int myTicketNum = ticketNum.incrementAndGet();
		
		//如果获得的排队号码和当前窗口显示的服务号码不一致, 则不断的轮询等待
		while(serviceNum.get() != myTicketNum) {
			
		}
		
		return myTicketNum;
	}
	
	//服务完毕, 服务号加1
	public void unlock(int myTicket) {
		
		int nextTicketNum = myTicket + 1;
		serviceNum.compareAndSet(myTicket, nextTicketNum);
		
	}
}
