package com.collections;

import java.util.HashMap;
import java.util.Map;

import com.collections.operations.EqualsAndHashCode;

public class ExecuteEqualsHashCode 
{
	public static void main(String[] args) {
		EqualsAndHashCode e1 = new EqualsAndHashCode("1030");
		EqualsAndHashCode e2 = new EqualsAndHashCode("1078");
		Map<EqualsAndHashCode, String> map = new HashMap<>();
		map.put(e1,"Henry");
		map.put(e2, "Francis");
		System.out.println(map.size());

		//map.forEach((K,V) -> System.out.println(K.hashCode()));
	}

}


/*
without equals
CourseData [courseId=S2-19_SSAMZC327, courseName=Systems Programming, courseDurationInMonths=6]

StudentData [studentId=1030, stuedntName=John, courseId=S2-19_SSAMZC327, courseName=Systems Programming]
StudentData [studentId=1668, stuedntName=Lola, courseId=S2-19_SSAMZC327, courseName=Systems Programming]
StudentData [studentId=1030, stuedntName=John, courseId=S2-19_SSAMZC327, courseName=Systems Programming]

CourseData [courseId=S2-19_SSAMZC313, courseName=Object Oriented Programming and Design, courseDurationInMonths=7]

StudentData [studentId=1006, stuedntName=Kenna, courseId=S2-19_SSAMZC313, courseName=Object Oriented Programming and Design]
StudentData [studentId=1976, stuedntName=Mary, courseId=S2-19_SSAMZC313, courseName=Object Oriented Programming and Design]
StudentData [studentId=1006, stuedntName=Kenna, courseId=S2-19_SSAMZC313, courseName=Object Oriented Programming and Design]

CourseData [courseId=S2-19_SSAMZC363, courseName=Data Structures and Algorithms, courseDurationInMonths=5]

StudentData [studentId=1654, stuedntName=Henry, courseId=S2-19_SSAMZC363, courseName=Data Structures and Algorithms]
StudentData [studentId=1064, stuedntName=Charles, courseId=S2-19_SSAMZC363, courseName=Data Structures and Algorithms]
StudentData [studentId=1668, stuedntName=Lola, courseId=S2-19_SSAMZC363, courseName=Data Structures and Algorithms]

CourseData [courseId=S2-19_SSAMZC353, courseName=Computer Organization and Architecture, courseDurationInMonths=10]

StudentData [studentId=1046, stuedntName=Catherine, courseId=S2-19_SSAMZC353, courseName=Computer Organization and Architecture]
StudentData [studentId=1324, stuedntName=Francis, courseId=S2-19_SSAMZC353, courseName=Computer Organization and Architecture]
StudentData [studentId=1654, stuedntName=Henry, courseId=S2-19_SSAMZC353, courseName=Computer Organization and Architecture]

CourseData [courseId=S1-19_SSAMZC264, courseName=Linear Algebra & Optimization, courseDurationInMonths=8]

 */

/*

with equals
CourseData [courseId=S2-19_SSAMZC327, courseName=Systems Programming, courseDurationInMonths=6]

StudentData [studentId=1030, stuedntName=John, courseId=S2-19_SSAMZC327, courseName=Systems Programming]
StudentData [studentId=1668, stuedntName=Lola, courseId=S2-19_SSAMZC327, courseName=Systems Programming]

CourseData [courseId=S2-19_SSAMZC313, courseName=Object Oriented Programming and Design, courseDurationInMonths=7]

StudentData [studentId=1006, stuedntName=Kenna, courseId=S2-19_SSAMZC313, courseName=Object Oriented Programming and Design]
StudentData [studentId=1976, stuedntName=Mary, courseId=S2-19_SSAMZC313, courseName=Object Oriented Programming and Design]

CourseData [courseId=S2-19_SSAMZC363, courseName=Data Structures and Algorithms, courseDurationInMonths=5]

StudentData [studentId=1654, stuedntName=Henry, courseId=S2-19_SSAMZC363, courseName=Data Structures and Algorithms]
StudentData [studentId=1064, stuedntName=Charles, courseId=S2-19_SSAMZC363, courseName=Data Structures and Algorithms]
StudentData [studentId=1668, stuedntName=Lola, courseId=S2-19_SSAMZC363, courseName=Data Structures and Algorithms]

CourseData [courseId=S2-19_SSAMZC353, courseName=Computer Organization and Architecture, courseDurationInMonths=10]

StudentData [studentId=1046, stuedntName=Catherine, courseId=S2-19_SSAMZC353, courseName=Computer Organization and Architecture]
StudentData [studentId=1324, stuedntName=Francis, courseId=S2-19_SSAMZC353, courseName=Computer Organization and Architecture]
StudentData [studentId=1654, stuedntName=Henry, courseId=S2-19_SSAMZC353, courseName=Computer Organization and Architecture]

CourseData [courseId=S1-19_SSAMZC264, courseName=Linear Algebra & Optimization, courseDurationInMonths=8]

 */