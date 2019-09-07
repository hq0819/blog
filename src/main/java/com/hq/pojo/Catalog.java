package com.hq.pojo;

public class Catalog {
    private Integer id;

    private String name;

    private String keywords;

    private Boolean type;

    private String desc;
    
    

    @Override
	public String toString() {
		return "Catalog [id=" + id + ", name=" + name + ", keywords=" + keywords + ", type=" + type + ", desc=" + desc
				+ "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}