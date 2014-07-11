package com.qcm.platform.repo;

public interface LoginDao {

	public String getUserRole(String identifiant, String motDePasse);
	public String getRoleForIdentifiiant(String identifiant);

}
