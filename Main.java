package contextSwitch;

import java.util.*;

public class Main {
public static void main(String[] args) {
		
		/*
		 * All processes are instantiated as well as their corresponding ProcessControlBlocks
		 */
		ProcessControlBlock excelPCB = new ProcessControlBlock(new SimProcess(1, "excel", 175));
		ProcessControlBlock wordPCB = new ProcessControlBlock(new SimProcess(2, "word", 31));
		ProcessControlBlock powerPointPCB = new ProcessControlBlock(new SimProcess(3, "Power Point", 220));
		ProcessControlBlock firefoxPCB = new ProcessControlBlock(new SimProcess(4, "firefox", 50));
		ProcessControlBlock chromePCB = new ProcessControlBlock(new SimProcess(5, "chrome", 50));
		ProcessControlBlock eclipsePCB = new ProcessControlBlock(new SimProcess(6, "eclipse", 40));
		ProcessControlBlock aptanaPCB = new ProcessControlBlock( new SimProcess(7, "aptana", 30));
		ProcessControlBlock sqlServerPCB = new ProcessControlBlock(new SimProcess(8, "sql", 200));
		ProcessControlBlock notepadPCB = new ProcessControlBlock(new SimProcess(9, "notepad", 100));
		ProcessControlBlock pycharmPCB = new ProcessControlBlock(new SimProcess(10, "pycharm", 180));
		
		//An arrayList of ready process is instantiated with all the processes added to it
		ArrayList<ProcessControlBlock> readyProcesses = new ArrayList<ProcessControlBlock> ();
		readyProcesses.add(excelPCB);
		readyProcesses.add(wordPCB);
		readyProcesses.add(powerPointPCB);
		readyProcesses.add(firefoxPCB);
		readyProcesses.add(chromePCB);
		readyProcesses.add(eclipsePCB);
		readyProcesses.add(aptanaPCB);
		readyProcesses.add(sqlServerPCB);
		readyProcesses.add(notepadPCB);
		readyProcesses.add(pycharmPCB);
		
		//An arrayList to hold the blocked processes is instantiated
		ArrayList<ProcessControlBlock> blockedProcesses = new ArrayList<ProcessControlBlock>();
		executeProcess(readyProcesses,  blockedProcesses); //call to the executeProcess method
	}
	
	/**
	 * This method executes the processes using if-else logic
	 * @param readyProcesses The arrayList of ready processes
	 * @param blockedProcesses The arrayList of blocked processes
	 */
	public static void executeProcess(ArrayList<ProcessControlBlock> readyProcesses, ArrayList<ProcessControlBlock> blockedProcesses) {
		final int QUANTUM = 5; 
		int countQuantum = 0;
		
		//A process is placed on the processor
		SimProcessor simProc = new SimProcessor(readyProcesses.get(0).getProcess());
		//it is then removed from the ready processes
		readyProcesses.remove(0);
		ProcessControlBlock currProcess = new ProcessControlBlock(simProc.getSimProcess());
		 
		//for loop to iterate 3000 steps 
		for (int i = 0; i  < 3000; i++) {
			countQuantum++;//increments the quantum each time it executes the process
			
			System.out.println("Step " + (i+1));
			ProcessState ps = simProc.executeNextInstruction();

			
			if (ps == ProcessState.BLOCKED  || ps == ProcessState.FINISHED || countQuantum == QUANTUM ) {
				i++; //increment i because a context switch is counted as another step/ iteration
				//Then sets all the process's registers and current instruction in the PCB
				currProcess.setCurrentInstruction(simProc.getCurrInstruction());
				currProcess.setRegister1(simProc.getRegister1());
				currProcess.setRegister2(simProc.getRegister2());
				currProcess.setRegister3(simProc.getRegister3());
				currProcess.setRegister4(simProc.getRegister4());
				if (ps == ProcessState.BLOCKED) {
					System.out.println("*** Process blocked ***");
					blockedProcesses.add(currProcess);

				}
				else if (ps == ProcessState.FINISHED) {
					System.out.println("*** Process completed ***");
					

				}
				else {
					System.out.println("*** Quantum expired ***");
					readyProcesses.add(currProcess);

				}
				
				//statement will only execute if there are processes on the ready list
				if(readyProcesses.size() != 0) {
					System.out.println("Step " + (i+1) + " Context switch: Saving Process: " + simProc.getSimProcess().procName());
					System.out.println("\nInstruction: " + simProc.getCurrInstruction() + " R1: " + simProc.getRegister1() +
										" R2: " + simProc.getRegister2() + 
										" R3: " + simProc.getRegister3() + " R4: " + simProc.getRegister4());
					
					currProcess = readyProcesses.get(0);
					readyProcesses.remove(0);
					simProc.setSimProcess(currProcess.getProcess());
					simProc.setCurrInstruction(currProcess.getCurrentInstruction());
					simProc.setRegister1(currProcess.getRegister1());
					simProc.setRegister2(currProcess.getRegister2());
					simProc.setRegister3(currProcess.getRegister3());
					simProc.setRegister4(currProcess.getRegister4());
					System.out.println("Restoring Process: " + currProcess.getProcess().procName() + "\nInstruction: " + currProcess.getCurrentInstruction() + " R1: " + currProcess.getRegister1() 
					+ " R2: " + currProcess.getRegister2() + " R3: " + currProcess.getRegister3() + " R4: " + currProcess.getRegister4());
					
	
				}
				//otherwise processor idles
				else {	
					System.out.println("Processor is idling");	
				}
				
				
				
				countQuantum = 0;
				addReadyProcesses(readyProcesses, blockedProcesses);//call to the addReadyProcesses method to 
																	//add more processes onto the ready list by 30% chance
				
			}
		}
				
	}
			 
		/**
		 * 	This method will attempt to add processes onto the ready list with a 30% chance of it occurring.
		 * @param readyProcesses The arrayList of ready processes
		 * @param blockedProcesses The arrayList of blocked processes
		 */
	
	public static void addReadyProcesses(ArrayList<ProcessControlBlock> readyProcesses, ArrayList<ProcessControlBlock> blockedProcesses) {
	
			for (int j = 0; j < blockedProcesses.size(); j++) {
					Random random = new Random();
					int num = random.nextInt(100)+1;
					if (num <= 30 && blockedProcesses.size() != 0) {
						readyProcesses.add(blockedProcesses.get(j));
						blockedProcesses.remove(j);
					}
				
			}

	}

}

