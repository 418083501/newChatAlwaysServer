package lulu.model;

import java.util.LinkedList;

public class GroupInfo {
	private String id;
	private String name;
	private String destrib;
	private String facePath;
	private LinkedList<BaseUser> users;
	private long onwerID;
	
	public long getOnwerID() {
		return onwerID;
	}
	public void setOnwerID(long onwerID) {
		this.onwerID = onwerID;
	}
	public LinkedList<BaseUser> getUsers() {
		return users;
	}
	public void setUsers(LinkedList<BaseUser> users) {
		this.users = users;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDestrib() {
		return destrib;
	}
	public void setDestrib(String destrib) {
		this.destrib = destrib;
	}
	public String getFacePath() {
		return facePath;
	}
	public void setFacePath(String facePath) {
		this.facePath = facePath;
	}
	
}
