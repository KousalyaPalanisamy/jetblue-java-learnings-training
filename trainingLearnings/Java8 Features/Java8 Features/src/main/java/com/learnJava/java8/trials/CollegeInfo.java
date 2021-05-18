package com.learnJava.java8.trials;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//repeatable annotation type
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Repeatable(CollegeInfos.class)
public @interface CollegeInfo {
	String collegeCode() default "A1";
	String collegeName() default "Bharathiyar University";
	String university() default "Bharathiyar University";
	//	@interface Games
	//	{
	//		Game[] values();
	//	}
}

//containing annotation type - wrapping annotation
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@interface CollegeInfos
{
	CollegeInfo[] value();
}
//@interface Game
//{
//	String gameName();
//}
