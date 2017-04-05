package com.ngtesting.platform.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sys_org_role")
public class SysOrgRole extends BaseEntity {
	private static final long serialVersionUID = -3556080851163371948L;
	
	@Enumerated(EnumType.STRING)
    private OrgRoleCode code;
	
	private String name;
    private String descr;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id", insertable = false, updatable = false)
    private SysOrg org;

    @Column(name = "org_id")
    private Long orgId;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "r_org_role_user", joinColumns = { 
			@JoinColumn(name = "org_role_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "user_id", 
					nullable = false, updatable = false) })
    private Set<SysUser> userSet = new HashSet<SysUser>(0);
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "r_org_role_privilege", joinColumns = { 
			@JoinColumn(name = "org_role_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "org_privilege_id", 
					nullable = false, updatable = false) })
    private Set<SysOrgPrivilege> orgPrivilegeSet = new HashSet<SysOrgPrivilege>(0);
    
    public static enum OrgRoleCode {
        org_admin("org_admin"),
        project_admin("project_admin");

        private OrgRoleCode(String textVal) {
            this.textVal = textVal;
        }

        private String textVal;
        public String toString() {
            return textVal;
        }
        
        public static OrgRoleCode getValue(String str) {
        	OrgRoleCode status = null;
        	switch(str) { 
            	case "org_admin": status = OrgRoleCode.org_admin; break;
            	case "project_admin": status = OrgRoleCode.project_admin; break;
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
	public Set<SysOrgPrivilege> getOrgPrivilegeSet() {
		return orgPrivilegeSet;
	}
	public void setOrgPrivilegeSet(
			Set<SysOrgPrivilege> orgPrivilegeSet) {
		this.orgPrivilegeSet = orgPrivilegeSet;
	}
	public SysOrg getOrg() {
		return org;
	}
	public void setOrg(SysOrg org) {
		this.org = org;
	}
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public Set<SysUser> getUserSet() {
		return userSet;
	}
	public void setUserSet(Set<SysUser> userSet) {
		this.userSet = userSet;
	}
}
