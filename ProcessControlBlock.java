package contextSwitch;

public class ProcessControlBlock {
	
	private SimProcess process;
	private int currentInstruction;
	private int register1;
	private int register2;
	private int register3;
	private int register4;
	
	
	/**
	 * Constructor for the PCB
	 * @param process The process passed in is assigned to PCB's process.
	 */
	public ProcessControlBlock(SimProcess process) {
		this.process = process;
	}
	
	/**
	 * Method returns the process
	 * @return
	 */
	public SimProcess getProcess() {
		return process;
	}
	
	/**
	 * Method sets the current instruction of the PCB
	 * @param currentInstruction
	 */
	public void setCurrentInstruction(int currentInstruction) {
		this.currentInstruction = currentInstruction;
	}
	
	/**
	 * Method returns the current instruction
	 * @return
	 */
	public int getCurrentInstruction() {
		return currentInstruction;
	}
	
	public void setRegister1(int num) {
			register1 = num;
	}
	
	public void setRegister2(int num) {
		register2 = num;
	}
	
	public void setRegister3(int num) {
		register3 = num;
	}
	
	public void setRegister4(int num) {
		register4 = num;
	}
	
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
}
