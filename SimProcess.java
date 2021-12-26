package contextSwitch;
import java.util.Random; 

public class SimProcess {

	private int pid;
	private String procName;
	private int totalInstructions;
	
	/**
	 * Constructor for a SimProcess
	 * @param pid The process ID in int
	 * @param procName The process name in String
	 * @param totalInstructions The total instructions in int
	 */
	public SimProcess(int pid, String procName, int totalInstructions) {
		this.pid = pid;
		this.procName = procName;
		this.totalInstructions = totalInstructions;
	}
	
	/**
	 *  
	 * @return procName The name of the process currently on the processor.
	 */
	public String procName() {
		return procName;
	}

	/**
	 * This method executes the next instruction.
	 * @param i The int value of which instruction to execute next
	 * @return The ProcessState - FINISHED, BLOCKED, or READY
	 */
	public ProcessState execute(int i) {
		System.out.println("PID: " + pid + " Process Name: "  + procName 
				+ " executing instruction: " + (i));
		Random num = new Random();
		int integer = num.nextInt(100)+1;
		if (i >= totalInstructions) {
			return ProcessState.FINISHED;
		}
		if (integer <= 15) {
			return ProcessState.BLOCKED;
		}
		else {
			return ProcessState.READY;
		}
		
		
	}
}
 