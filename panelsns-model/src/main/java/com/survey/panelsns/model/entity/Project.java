package com.survey.panelsns.model.entity;

public class Project {
	
	public static final Project DEFAULT=new Project(){
		{
			this.setId(0L);
			this.setUserId(Users.DEFAULT.getId());
		}
	};
    
    private Long id;

    
    private Long userId;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public Long getUserId() {
        return userId;
    }

    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}