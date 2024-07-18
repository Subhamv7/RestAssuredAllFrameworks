package practice_Serialization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class project1 {

	String projectName;
	String projectStatus;
	int teamSize;
	List<String> teamMember;
	ProjectManager projectManager;

	public project1(String projectName, String projectStatus, int teamSize, List<String> teamMember,
			ProjectManager projectManager) {
		super();
		this.projectName = projectName;
		this.projectStatus = projectStatus;
		this.teamSize = teamSize;
		this.teamMember = teamMember;
		this.projectManager = projectManager;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamMember(List<String> teamMember) {
		this.teamMember = teamMember;
	}

	public List<String> getTeamMember() {
		return teamMember;
	}

	public void setProjectManager(ProjectManager projectManager) {
		this.projectManager = projectManager;
	}

	public ProjectManager getProjectManager() {
		return projectManager;
	}

}

class ProjectManager {

	String name;

	String empID;
	
	

	public ProjectManager(String name, String empID) {
		super();
		this.name = name;
		this.empID = empID;
	}

	

public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmpID() {
		return empID;
	}



	public void setEmpID(String empID) {
		this.empID = empID;
	}
}



public  class Run3_Pojo {
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		List<String> lst = new ArrayList<String>();
		lst.add("Avit");
		lst.add("Sunny");
		lst.add("Subham");
		
		ProjectManager pm = new ProjectManager("Satya" , "tp01");
		
		project1 projectObj = new project1("Apple_54", "created", 10, lst, pm);
		
		ObjectMapper objM = new ObjectMapper();
		objM.writeValue(new File("./Project1.json"), projectObj);
	

	}

}

