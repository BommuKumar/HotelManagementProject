package com.naresh.Database.customException;

public class RoomNotExistedWithThisId extends RuntimeException{
	
	
	public RoomNotExistedWithThisId(String msg)
	{
		super(msg);
	}
	public RoomNotExistedWithThisId(String msg,Throwable cause)
	{
		super(msg,cause);
	}


}
