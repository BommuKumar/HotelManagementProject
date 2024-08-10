package com.naresh.Database.customException;

public class RoomsNotExistedInThisHotel extends RuntimeException{
	
	
	public RoomsNotExistedInThisHotel(String msg)
	{
		super(msg);
	}
	public RoomsNotExistedInThisHotel(String msg,Throwable cause)
	{
		super(msg,cause);
	}


}
