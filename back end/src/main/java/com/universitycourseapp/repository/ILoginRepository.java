package com.universitycourseapp.repository;

public interface ILoginRepository {
	
	public boolean verifyApplicantCredentials(String username,String pwd);
	public boolean verifyAdmissionCommiteeMemberCredentials(String username,String pwd);
	public boolean verifyUniversityStaffMemberCredentials(String username,String pwd);
}
