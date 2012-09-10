package com.survey.panelsns.model.entity;

public class Users {
	
	public static final Users DEFAULT=new Users(){
		{
			this.setId(0L);
		}
	};
    
    private Long id;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }
}