package contextSwitch;
import java.util.Random;
//represents the processor of the computer = piece of hardware

public class SimProcessor {
	private SimProcess currentProcess;
	private int register1;
	private int register2;
	private int register3;
	private int register4;
	private int currInstruction;
	/**
	 * Sets the current process to a process
	 * @param simProc The SimProcess object passed to the method
	 */
	
	public SimProcessor(SimProcess simProc) {
		currentProcess = simProc;
	}
	
	/**
	 * A setter for the Processor (not used in this program)
	 * @param p The process passed in.
	 */
	public void setSimProcess(SimProcess p) {
		currentProcess = p;
	}
	
	/**
	 * 
	 * @return The currentProcess on the processor
	 */
	public SimProcess getSimProcess() {
		return currentProcess;
	}
	
	/**
	 * This method takes a value of type int and assigns it to the register
	 * @param num The int being passed in
	 */
	public void setRegister1(int num) {
		this.register1 = num;
	}
	
	/**
	 * This method takes a value of type int and assigns it to the register
	 * @param num The int being passed in
	 */
	public void setRegister2(int num) {
		this.register2 = num;
	}
	
	/**
	 * This method takes a value of type int and assigns it to the register
	 * @param num The int being passed in
	 */
	public void setRegister3(int num) {
		this.register3 = num;
	}
	
	/**
	 * This method takes a value of type int and assigns it to the register
	 * @param num The int being passed in
	 */
	public void setRegister4(int num) {
		this.register4 = num;
	}
	
	/**
	 * The next 4 methods return the values of the registers.
	 * @return
	 */
	public int getRegister1() {
		return register1;
	}
	
	public int getRegister2() {
		return register2;
	}
	
	public int getRegister3() {
		return register3;
	}
	
	public int getRegister4() {
		return register4;
	}
	
	/**
	 * This method sets the current instruction of the processor
	 * @param currInstruction The current instruction passed to the method
	 */
	public void setCurrInstruction(int currInstruction) {
		this.currInstruction = currInstruction;
	}
	
	/**
	 * This method returns the current instruction of the processor
	 * @return currInstruction
	 */
	public int getCurrInstruction() {
		return currInstruction;
	}
	
	/**
	 * This method executes the next Instruction by calling the 
	 * execute method of the SimProcess class and passing to it the currInstruction.
	 * @return The ProcessState of the current process
	 */
	public ProcessState executeNextInstruction() {
		Random random = new Random();
		ProcessState ps = currentProcess.execute(currInstruction);
		currInstruction++;
		setRegister1(random.nextInt(1000));
		setRegister2(random.nextInt(1000));
		setRegister3(random.nextInt(1000));
		setRegister4(random.nextInt(1000));
		
		return ps;
	}
}
