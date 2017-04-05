package com.ngtesting.platform.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.ngtesting.platform.entity.EvtEvent.EventStatus;

@Entity
@Table(name = "sys_project_privilege")
public class SysProjectPrivilege extends BaseEntity {
	private static final long serialVersionUID = -5510206858644860272L;

	@Enumerated(EnumType.STRING)
    private ProjectPrivilegeCode code;
	
    private String name;
    private String descr;
    
    @Enumerated(EnumType.STRING)
    private PrivilegeAction action;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "projectPrivilegeSet")
    private Set<SysProjectRole> projectRoleSet = new HashSet<SysProjectRole>(0);
    
    public static enum ProjectPrivilegeCode {
    	req("req"),
    	cases("cases"),
    	plan("plan"),
    	round("round"),
    	result("result"),
    	report("report");

        private ProjectPrivilegeCode(String textVal) {
            this.textVal = textVal;
        }

        private String textVal;
        public String toString() {
            return textVal;
        }
        
        public static ProjectPrivilegeCode getValue(String str) {
        	ProjectPrivilegeCode status = null;
        	switch(str) { 
            	case "req": status = ProjectPrivilegeCode.req; break;
            	case "cases": status = ProjectPrivilegeCode.cases; break;
            	case "plan": status = ProjectPrivilegeCode.plan; break;
            	case "round": status = ProjectPrivilegeCode.round; break;
            	case "result": status = ProjectPrivilegeCode.result; break;
            	case "report": status = ProjectPrivilegeCode.report; break;
            }
        	
        	return status;
        }
    }
    
    public static enum PrivilegeAction {
        update("update"),
        remove("remove"),
        close("close");

        private PrivilegeAction(String textVal) {
            this.textVal = textVal;
        }

        private String textVal;
        public String toString() {
            return textVal;
        }
        
        public static PrivilegeAction getValue(String str) {
        	PrivilegeAction status = null;
        	switch(str) { 
            	case "update": status = PrivilegeAction.update; break;
            	case "remove": status = PrivilegeAction.remove; break;
            	case "close": status = PrivilegeAction.close; break;
            }
        	
        	return status;
        }
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Set<SysProjectRole> getProjectRoleSet() {
		return projectRoleSet;
	}

	public void setProjectRoleSet(Set<SysProjectRole> projectRoleSet) {
		this.projectRoleSet = projectRoleSet;
	}

	public ProjectPrivilegeCode getCode() {
		return code;
	}

	public void setCode(ProjectPrivilegeCode code) {
		this.code = code;
	}

	public PrivilegeAction getAction() {
		return action;
	}

	public void setAction(PrivilegeAction action) {
		this.action = action;
	}
    
}
