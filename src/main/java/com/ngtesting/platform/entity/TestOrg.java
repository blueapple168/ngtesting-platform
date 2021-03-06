package com.ngtesting.platform.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tst_org")
public class TestOrg extends BaseEntity {
	private static final long serialVersionUID = -970910958057582029L;

	private String name;
    private String website;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id", insertable = false, updatable = false)
    private TestUser admin;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "tst_r_org_user", joinColumns = {
			@JoinColumn(name = "org_id", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "user_id",
					nullable = false, updatable = false) })
    private Set<TestUser> userSet = new HashSet<TestUser>(0);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Set<TestUser> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<TestUser> userSet) {
		this.userSet = userSet;
	}

	public TestUser getAdmin() {
		return admin;
	}

	public void setAdmin(TestUser admin) {
		this.admin = admin;
	}

}
