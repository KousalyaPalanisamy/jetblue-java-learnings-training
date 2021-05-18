package collection.mainRun;

import java.util.Scanner;

import ExceptionHandling.exceptions.CustomExceptions;
import ExceptionHandling.trials.DataValidator;
import collection.trials.OperationsOnList;
import collection.trials.OperationsOnSetAndMap;

public class MainRun {
	int getChoice()
	{
		Scanner in = new Scanner(System.in);
		DataValidator dv = new DataValidator();
		int choice = in.nextInt();

		try
		{
			dv.validatePositiveLength(choice,7);
		}
		catch(CustomExceptions e)
		{
			System.out.println(e+" Try again");
			getChoice();
		}
		return choice;
	}
	public static void main(String[] args) {
		//		AddStudents as = new AddStudents();
		//		as.addStudents();
		System.out.printf("\nChoose a program\n"+
				"1. sort ArrayList using Comparable and Comparator in java\n" + 
				"2. sort ArrayList in descending order in java \n" + 
				"3. convert LinkedList to ArrayList in java \n" + 
				"4. check if element exists in HashSet in java \n" + 
				"5. reverse ArrayList in java \n" + 
				"6. iterate TreeMap in java\n" + 
				"7. iterate the HashMap in java\n");

		MainRun mr = new MainRun();
		OperationsOnList operateList = new OperationsOnList();
		OperationsOnSetAndMap operateSetMap = new OperationsOnSetAndMap();
		CollectionVariables collectionVariables = new CollectionVariables();

		int choice = mr.getChoice();

		switch(choice)
		{
		case 1 : 
			operateList.sortWithComps(collectionVariables.getArrayListToSort());
			break;
		case 2 : 
			operateList.descendingSort(collectionVariables.getArrayList1());
			operateList.descendingSort(collectionVariables.getArrayList2());
			break;
		case 3 : 
			operateList.linkedListToArrayList(collectionVariables.getlinkedList1());
			operateList.linkedListToArrayList(collectionVariables.getlinkedList2());
			break;
		case 4 : 
			operateSetMap.findElementInHashSet(collectionVariables.getHashSet());
			break;
		case 5 : 
			operateList.reverseArrayList(collectionVariables.getArrayList1());
			operateList.reverseArrayList(collectionVariables.getArrayList2());
			break;
		case 6 : 
			operateSetMap.iterateTreeMap(collectionVariables.getTreeMap());
			break;
		case 7 : 
			operateSetMap.iterateHashMap(collectionVariables.getHashMap());
			break;
		default : System.out.println("Unable to proceed.. Please try later");
		}


	}

}

/*
Write a program to 
- sort ArrayList using Comparable and Comparator in java 
- sort ArrayList in descending order in java -
- convert LinkedList to ArrayList in java -
- check if element exists in HashSet in java 
- reverse ArrayList in java -
- iterate TreeMap in java
- iterate the HashMap in java
 */

//send a list as a parameter to handle methods
