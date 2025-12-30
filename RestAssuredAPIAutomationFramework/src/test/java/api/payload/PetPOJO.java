package api.payload;

import java.util.List;

public class PetPOJO {
	
	
/*
  
 Nested JSON Payload :- 

 {
  "id": 0,
  "category": {
    "id": 0,
    "name": "string"
  },
  "name": "doggie",
  "photoUrls": [
    "string"
  ],
  "tags": [
    {
      "id": 0,
      "name": "string"
    }
  ],
  "status": "available"
 }
 
	
*/	

    private long id;
    private CategoryPOJO category;
    private String name;
    private List<String> photoUrls;
    private List<TagPOJO> tags;
    private String status;   // available | pending | sold

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CategoryPOJO getCategory() {
        return category;
    }

    public void setCategory(CategoryPOJO category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<TagPOJO> getTags() {
        return tags;
    }

    public void setTags(List<TagPOJO> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

