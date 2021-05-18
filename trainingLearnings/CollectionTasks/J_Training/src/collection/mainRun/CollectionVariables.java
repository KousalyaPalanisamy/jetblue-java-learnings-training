package collection.mainRun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeMap;

import collection.trials.SortWithComps;

public class CollectionVariables 
{
	public LinkedList<CollectionVariables> getlinkedList1()
	{
		LinkedList linkedList1 = new LinkedList();
		linkedList1.add("a1");
		linkedList1.add(2);
		linkedList1.add(true);
		linkedList1.add(45.0);
		return linkedList1;
	}

	public LinkedList<String> getlinkedList2()
	{
		LinkedList<String> linkedList2 = new LinkedList();
		linkedList2.add("Navarre");
		linkedList2.add("Scotland");
		linkedList2.add("Chennai");
		linkedList2.add("Yeman");
		linkedList2.add("641664");
		return linkedList2;
	}

	public ArrayList getArrayList1()
	{
		ArrayList<Comparable> arl = new ArrayList<Comparable>();
		arl.add("a1");
		arl.add(2);
		arl.add(true);
		arl.add(45.0);
		arl.add("true");
		arl.add(92);
		return arl;
	}

	public ArrayList<String> getArrayList2()
	{
		ArrayList<String> arl = new ArrayList<String>();
		arl.add("hibernate");
		arl.add("Shut down");
		arl.add("Restart");
		arl.add("abnormal");
		arl.add("Sleep");
		arl.add("Switch User");
		return arl;
	}

	public HashSet<String> getHashSet()
	{
		HashSet<String> hs = new HashSet<String>();
		hs.add("Navarre");
		hs.add("Scotland");
		hs.add("Chennai");
		hs.add("Yeman");
		hs.add("641664");
		return hs;
	}

	public TreeMap<String, String> getTreeMap()
	{
		TreeMap<String, String> tmap = new TreeMap<String, String>();
		tmap.put("Name", "Henry");
		tmap.put("Height", "6.1 feet");
		tmap.put("Birth Place", "France");
		return tmap;
	}

	public HashMap<String, Integer> getHashMap()
	{
		HashMap<String, Integer> hm = new HashMap<String, Integer>(); 

		hm.put("English marks", 54); 
		hm.put("Maths Marks", 80); 
		hm.put("History Marks", 82);
		return hm;
	}

	public ArrayList<SortWithComps> getArrayListToSort()
	{
		ArrayList<SortWithComps> al = new ArrayList<SortWithComps>();
		al.add(new SortWithComps(1030,"John","Software engineer"));
		al.add(new SortWithComps(1046,"Catherine","Data Analyst"));
		al.add(new SortWithComps(1006,"Kenna","Technical Lead"));
		return al;
	}
}

