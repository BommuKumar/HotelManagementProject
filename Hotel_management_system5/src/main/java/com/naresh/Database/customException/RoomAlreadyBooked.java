package com.naresh.Database.customException;

public class RoomAlreadyBooked extends RuntimeException{
	
	
	public RoomAlreadyBooked(String msg)
	{
		super(msg);
	}
	public RoomAlreadyBooked(String msg,Throwable cause)
	{
		super(msg,cause);
	}

}
