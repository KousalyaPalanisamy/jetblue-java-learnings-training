package com.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import com.collections.operations.SortWithComps;

public class CollectionVariables 
{
	public List<Object> getArrayList1()
	{
		List<Object> arl = new ArrayList<>();
		arl.add("a1");
		arl.add(2);
		arl.add(true);
		arl.add(45.0);
		arl.add("true string");
		arl.add(92);
		return arl;
	}

	public List<String> getArrayList2()
	{
		List<String> arl = new ArrayList<>();
		arl.add("hibernate");
		arl.add("Shut down");
		arl.add("Restart");
		arl.add("abnormal");
		arl.add("Sleep");
		arl.add("Switch User");
		arl.add("Restart");
		return arl;
	}

	public List<Integer> getArrayList3()
	{
		List<Integer> arl = new ArrayList<>();
		arl.add(15);
		arl.add(46);
		arl.add(7);
		arl.add(12);
		arl.add(30);
		arl.add(10);
		return arl;
	}

	public List<String> getArrayList4()
	{
		List<String> arl = new ArrayList<>();
		arl.add("hibernate");
		arl.add("Shut down");
		arl.add("Restart");
		arl.add("new element");
		return arl;
	}

	public List<Object> getlinkedList1()
	{
		List<Object> linkedList1 = new LinkedList<>();
		linkedList1.add("a1");
		linkedList1.add(2);
		linkedList1.add(true);
		linkedList1.add(45.0);
		return linkedList1;
	}

	public List<String> getlinkedList2()
	{
		List<String> linkedList2 = new LinkedList<>();
		linkedList2.add("Navarre");
		linkedList2.add("Scotland");
		linkedList2.add("Chennai");
		linkedList2.add("Yeman");
		linkedList2.add("641664");
		return linkedList2;
	}

	public Set<String> getHashSet()
	{
		HashSet<String> hs = new HashSet<>();
		hs.add("Navarre");
		hs.add("Scotland");
		hs.add("Chennai");
		hs.add("Yeman");
		hs.add("641664");
		return hs;
	}

	public SortedMap<String, String> getTreeMap()
	{
		TreeMap<String, String> tmap = new TreeMap<>();
		tmap.put("Name", "Henry");
		tmap.put("Height", "6.1 feet");
		tmap.put("Birth Place", "France");
		return tmap;
	}

	public Map<String, Integer> getHashMap()
	{
		Map<String, Integer> hm = new HashMap<>(); 
		hm.put("English marks", 54); 
		hm.put("Maths Marks", 80); 
		hm.put("History Marks", 82);
		return hm;
	}

	public Map<Integer, String> getHashMap2()
	{
		Map<Integer, String> hm = new HashMap<>(); 
		hm.put(1534, "John"); 
		hm.put(341, "Mary"); 
		hm.put(290, "James");
		hm.put(1364, "Henry");
		hm.put(1030, "Francis");
		hm.put(26, "Catherine");
		return hm;
	}

	public List<SortWithComps> getArrayListOfTypeSortWithComps()
	{
		List<SortWithComps> al = new ArrayList<>();
		al.add(new SortWithComps(1030,"John","Software engineer"));
		al.add(new SortWithComps(1046,"Catherine","Data Analyst"));
		al.add(new SortWithComps(1006,"Kenna","Technical Lead"));
		al.add(new SortWithComps(1668,"Lola","Associate Lead"));
		return al;
	}



}

