package com.ngtesting.platform.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "sys_company_priviledge")
public class SysCompanyPriviledge extends BaseEntity {
	private static final long serialVersionUID = -5510206858644860272L;

    private String name;
    private String descr;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "companyPriviledgeSet")
    private Set<SysCompanyRole> companyRoleSet = new HashSet<SysCompanyRole>(0);

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

	public Set<SysCompanyRole> getCompanyRoleSet() {
		return companyRoleSet;
	}

	public void setCompanyRoleSet(Set<SysCompanyRole> companyRoleSet) {
		this.companyRoleSet = companyRoleSet;
	}
    
}