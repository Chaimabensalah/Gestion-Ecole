package com.ecole.gestion.ecole.model;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "user")
public class User {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "user_id")
		private int user_id;
		
		@Column(name = "login")
	    private String login;
		
		
		
		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}


		@Column(name = "password")
		@Length(min = 5, message = "*Your password must have at least 5 characters")
		@NotEmpty(message = "*Please provide your password")
		@Transient
		private String password;
		
		 
		@Column(name = "enabled")
	    private boolean enabled;
	     
	    public User() {
	        super();
	        this.enabled=false;
	    }
	    
	    
		@Column(name = "active")
		private int active;
		
		@ManyToMany(cascade = CascadeType.ALL)
		@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
		private Set<Role> roles;

		public int getUser_id() {
			return user_id;
		}

		public void setUser_id(int id) {
			this.user_id = id;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		 

		public int getActive() {
			return active;
		}

		public void setActive(int active) {
			this.active = active;
		}

		public Set<Role> getRoles() {
			return roles;
		}

		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}
		
		public boolean isEnabled() {
		        return enabled;
		    }

		public void setEnabled(final boolean enabled) {
		        this.enabled = enabled;
		    }

			
		private Personne personne;
			/*@OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
			public Personne getCompte() {
				return this.personne;
			}

			public void setPersonne(Personne email) {
				this.personne = email;
			}*/
			
		@OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
		public Personne getPersonne() {
				return this.personne;
			}

		public void setPersonne(Personne email) {
				this.personne = email;
			}
			
			
			
		@Column(name = "confirmation_token")
		private String confirmationToken;

		public String getConfirmationToken() {
				return confirmationToken;
			}

		public void setConfirmationToken(String confirmationToken) {
				this.confirmationToken = confirmationToken;
			}
	

}
