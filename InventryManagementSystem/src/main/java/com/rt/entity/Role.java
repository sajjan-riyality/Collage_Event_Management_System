package com.rt.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    public static final Set<Role> USER = null;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable = false, unique = true)
	private RoleType name; // This should be RoleType, not String

    
    
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
    
    

	public Role(Long id, RoleType name) {
		this.id = id;
		this.name = name;
	}

	public Role() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoleType getName() {
		return name;
	}

	public void setName(RoleType name) {
		this.name = name;
	}

	public Role orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

    
    
    
}


	
   
    
    
    

