package com.naresh.Database.customException;

public class HotelNotExistedWithThisId extends RuntimeException{
	
	
	public HotelNotExistedWithThisId(String msg)
	{
		super(msg);
	}
	public HotelNotExistedWithThisId(String msg,Throwable cause)
	{
		super(msg,cause);
	}


}
